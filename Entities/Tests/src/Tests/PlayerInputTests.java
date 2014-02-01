package Tests;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import Objects.Enabled;
import Objects.OneToHalfMapper;
import Objects.OneToOneMapper;

import com.artemis.ComponentType;
import com.artemis.Entity;
import com.artemis.World;
import com.artemis.managers.TagManager;
import com.badlogic.gdx.Input.Keys;
import com.me.Components.CInputButton;
import com.me.Components.CMovementIntent;
import com.me.Components.CPlayer;
import com.me.Components.CPosition;
import com.me.Components.CSize;
import com.me.Systems.Input.PlayerInputSystem;
import com.me.Systems.Movement.MovementDirection;


public class PlayerInputTests {

	World world;
	PlayerInputSystem target;
	Entity player;
	CMovementIntent intent;
	TagManager tags;
	Enabled enabled;
	
	@Before
	public void Setup()
	{
		world = new World();
		
		target = world.setSystem(new PlayerInputSystem());
		target.SetVisualInputMapper(new OneToOneMapper());
		
		world.initialize();
		
		player = world.createEntity().addComponent(new CPlayer()).addComponent( new CMovementIntent(MovementDirection.None));
		
		intent = (CMovementIntent) player.getComponent(ComponentType.getTypeFor(CMovementIntent.class));
		
		target.SetPlayer(player);
		enabled = new Enabled();
		target.SetDependentSystem(enabled);
		
		player.addToWorld();		
	}
	
	@Test
	public void ShouldSetPlayerMovementToUpWhenUpPressed() {
	
		target.keyDown(Keys.UP);
		
		world.process();
		
		assertEquals(MovementDirection.Up, intent.Direction());
		
	}
	
	@Test
	public void ShouldSetPlayerMovementToDownWhenDownPressed() {
	
		target.keyDown(Keys.DOWN);
		
		world.process();
		
		assertEquals(MovementDirection.Down, intent.Direction());		
	}
	
	@Test
	public void ShouldSetPlayerMovementToLeftWhenLeftPressed() {
	
		target.keyDown(Keys.LEFT);
		
		world.process();
	
		assertEquals(MovementDirection.Left, intent.Direction());		
	}
	
	@Test
	public void ShouldSetPlayerMovementToRightWhenRightPressed() {
	
		target.keyDown(Keys.RIGHT);
		
		world.process();
		
		assertEquals(MovementDirection.Right, intent.Direction());		
	}
	
	@Test
	public void ShouldSetPlayerMovementToNoneWhenNonePressed() {
			
		world.process();

		assertEquals(MovementDirection.None, intent.Direction());		
	}
	
	@Test
	public void ShouldSetPlayerMovementToNoneWhenDownPressedThenNothing() {
	
		target.keyDown(Keys.DOWN);
		
		world.process();
		
		world.process();
		
		assertEquals(MovementDirection.None, intent.Direction());		
	}
	
	@Test(expected=NullPointerException.class)
	public void ShouldThrowNullReferenceExceptionIfNoPlayerSet()
	{
		world = new World();
		
		target = world.setSystem(new PlayerInputSystem());
		
		world.initialize();
		
		player = world.createEntity().addComponent(new CPlayer()).addComponent( new CMovementIntent(MovementDirection.None));
				
		player.addToWorld();
		
		world.process();
	}
	
	@Test
	public void ShouldMoveLeftWhenLeftInputButtonPressed()
	{
		world.createEntity().addComponent(new CInputButton(MovementDirection.Left)).addComponent(new CSize(1000,1000)).addComponent(new CPosition(0,0)).addToWorld();
		
		target.touchDown(500, 500, 0, 0);
		
		world.process();
			
		assertEquals(MovementDirection.Left, intent.Direction());
	}
	
	@Test
	public void ShouldMoveRightWhenRightInputButtonPressed()
	{
		world.createEntity().addComponent(new CInputButton(MovementDirection.Right)).addComponent(new CSize(1000,1000)).addComponent(new CPosition(0,0)).addToWorld();
		
		target.touchDown(500, 500, 0, 0);
		
		world.process();
			
		assertEquals(MovementDirection.Right, intent.Direction());
	}
	
	@Test
	public void ShouldNotMoveIfButtonNotPressed()
	{
		world.createEntity().addComponent(new CInputButton(MovementDirection.Right)).addComponent(new CSize(1000,1000)).addComponent(new CPosition(0,0)).addToWorld();
		
		target.touchDown(1200, 1200, 0, 0);
		
		world.process();
		
		assertEquals(MovementDirection.None, intent.Direction());
			
 	}
	
	@Test
	public void ShouldNotMoveIfButtonNotPressed2()
	{
		world.createEntity().addComponent(new CInputButton(MovementDirection.Right)).addComponent(new CSize(1000,1000)).addComponent(new CPosition(0,0)).addToWorld();
		
		target.touchDown(-4, -5, 0, 0);
		
		world.process();
		
		assertEquals(MovementDirection.None, intent.Direction());
			
 	}
	
	@Test
	public void ShouldBeNoneIfPressedOnAPreviousFrame()
	{
		world.createEntity().addComponent(new CInputButton(MovementDirection.Right)).addComponent(new CSize(1000,1000)).addComponent(new CPosition(0,0)).addToWorld();
		
		target.touchDown(500, 500, 0, 0);
		
		world.process();
		
		world.process();
			
		assertEquals(MovementDirection.None, intent.Direction());
	}
	
	@Test
	public void ShouldDirectUpIfHalfButtonUsed()
	{
		target.SetVisualInputMapper( new OneToHalfMapper());
		
		world.createEntity().addComponent(new CInputButton(MovementDirection.Right)).addComponent(new CSize(1000,1000)).addComponent(new CPosition(0,0)).addToWorld();
		
		target.touchDown(1500, 1500, 0, 0);
		
		world.process();
		
		assertEquals(MovementDirection.Right, intent.Direction());
	}
	
	@Test
	public void ShouldSetEnabledTrueOnDependentWhenMove()
	{
		world.createEntity().addComponent(new CInputButton(MovementDirection.Right)).addComponent(new CSize(1000,1000)).addComponent(new CPosition(0,0)).addToWorld();
		
		target.touchDown(500, 500, 0, 0);
		
		world.process();
		
		assertEquals(true, enabled.Value);
	}
	
	@Test
	public void ShouldSetEnabledFalsOnDependentWhenNotMove()
	{
		world.createEntity().addComponent(new CInputButton(MovementDirection.Right)).addComponent(new CSize(1000,1000)).addComponent(new CPosition(0,0)).addToWorld();
				
		world.process();
		
		assertEquals(false, enabled.Value);
	}
}
