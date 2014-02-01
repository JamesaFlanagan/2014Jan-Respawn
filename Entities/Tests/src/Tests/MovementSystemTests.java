package Tests;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import Objects.AllTileSystem;
import Objects.XEvenTileSystem;

import com.artemis.Entity;
import com.artemis.World;
import com.me.Aspects.DoubleBuffered.IBufferManager;
import com.me.Aspects.DoubleBuffered.ManagedDoubleBufferedValue;
import com.me.Aspects.DoubleBuffered.SimpleBufferManager;
import com.me.Components.CMovementIntent;
import com.me.Components.CPosition;
import com.me.Systems.Movement.MovementDirection;
import com.me.Systems.Movement.MovementSystem;

public class MovementSystemTests {


	World world;
	World world2;
	MovementSystem target;
	MovementSystem target2;
	Entity player;
	Entity enemy;
	CMovementIntent intent;
	CPosition position;
	IBufferManager buffer; 
	
	CMovementIntent eIntent;
	CPosition ePosition;
	
	CMovementIntent wIntent;
	CPosition wPosition;
	
	XEvenTileSystem xTileSystem;
	Entity wEntity; 
	
	@Before
	public void Setup()
	{
		buffer = new SimpleBufferManager();
		ManagedDoubleBufferedValue.SetBufferManager(buffer);
		
	 	world = new World();
	 	world2 = new World();
		
		target = world.setSystem(new MovementSystem());   
		target.SetTileSystem(new AllTileSystem());
		
		target2 = world2.setSystem(new MovementSystem());
		
		xTileSystem = new XEvenTileSystem();
		target2.SetTileSystem(xTileSystem);
		
		world.initialize();
		world2.initialize();
	
		intent = new CMovementIntent(MovementDirection.None);
		position = new CPosition(3,9);
		
		eIntent = new CMovementIntent(MovementDirection.None);
		ePosition = new CPosition(10,15);
		
		wIntent = new CMovementIntent(MovementDirection.None); 
		wPosition = new CPosition(3,4);
		
		wEntity = world2.createEntity().addComponent(wPosition).addComponent(wIntent);
		
		player = world.createEntity().addComponent(position).addComponent(intent);
		
		enemy = world.createEntity().addComponent(ePosition).addComponent(eIntent);
		
		player.addToWorld();
		enemy.addToWorld();
		wEntity.addToWorld();
	}
		
	@Test
	public void ShouldIncreaseYWhenMovingUp() {
		
		intent.Direction(MovementDirection.Up);
		
		world.process();
		
		buffer.Swap();
		
		assertEquals(10, position.Y());
		assertEquals(3, position.X());
	}
	
	@Test
	public void ShouldDecreaseYWhenMovingDown() {
		
		intent.Direction(MovementDirection.Down);
		
		world.process();
		
		buffer.Swap();
		
		assertEquals(8, position.Y());
		assertEquals(3, position.X());
	}
	
	@Test
	public void ShouldDecreaseXWhenMovingLeft() {
		
		intent.Direction(MovementDirection.Left);
		
		world.process();
		
		buffer.Swap();
		
		assertEquals(2, position.X());		
		assertEquals(9, position.Y());
	}
	
	@Test
	public void ShouldIncreaseXWhenMovingRight() {
		
		intent.Direction(MovementDirection.Right);
		
		world.process();
		
		buffer.Swap();
		
		assertEquals(4, position.X());
		assertEquals(9, position.Y());
	}
	
	@Test
	public void ShouldRemainSameWhenNone() {
		
		intent.Direction(MovementDirection.None);
		
		world.process();
		
		buffer.Swap();
		
		assertEquals(3, position.X());	
		assertEquals(9, position.Y());
	}
	

	@Test
	public void ShouldIncreaseYWhenMovingUp2() {
		
		eIntent.Direction(MovementDirection.Up);
		
		world.process();
		
		buffer.Swap();
		
		assertEquals(16, ePosition.Y());
		assertEquals(10, ePosition.X());
	}
	
	@Test
	public void ShouldDecreaseYWhenMovingDown2() {
		
		eIntent.Direction(MovementDirection.Down);
		
		world.process();
		
		buffer.Swap();
		
		assertEquals(14, ePosition.Y());
		assertEquals(10, ePosition.X());
	}
	
	@Test
	public void ShouldDecreaseXWhenMovingLeft2() {
		
		eIntent.Direction(MovementDirection.Left);
		
		world.process();
		
		buffer.Swap();
		
		assertEquals(9, ePosition.X());		
		assertEquals(15, ePosition.Y());
	}
	
	@Test
	public void ShouldIncreaseXWhenMovingRight2() {
		
		eIntent.Direction(MovementDirection.Right);
		
		world.process();
		
		buffer.Swap();
		
		assertEquals(11, ePosition.X());
		assertEquals(15, ePosition.Y());
	}
	
	@Test
	public void ShouldHaveSamePositionAfterMoveToNoTileUp()
	{
		wIntent.Direction(MovementDirection.Up);
		
		world2.process();
		
		buffer.Swap();
		
		assertEquals(3, wPosition.X());
		assertEquals(4, wPosition.Y());
	}
	
	@Test
	public void ShouldHaveSamePositionAfterMoveToNoTileDown()
	{
		wIntent.Direction(MovementDirection.Down);
		
		world2.process();
		
		buffer.Swap();
		
		assertEquals(3, wPosition.X());
		assertEquals(4, wPosition.Y());
	}

	@Test
	public void ShouldHaveSamePositionAfterMoveToNoTileLeft()
	{
		wPosition.X(4);
		
		buffer.Swap();
		
		wIntent.Direction(MovementDirection.Left);
		
		world2.process();
		
		buffer.Swap();
		
		assertEquals(4, wPosition.X());
		assertEquals(4, wPosition.Y());
	}
	
	@Test
	public void ShouldHaveSamePositionAfterMoveToNoTileRight()
	{
		wPosition.X(4);
		
		buffer.Swap();
		
		wIntent.Direction(MovementDirection.Right);
		
		world2.process();
		
		buffer.Swap();
		
		assertEquals(4, wPosition.X());
		assertEquals(4, wPosition.Y());
	}
	
	@Test
	public void ShouldMoveOnlyOnceWhenPressed()
	{
		eIntent.Direction(MovementDirection.Up);
		
		buffer.Swap();
		
		world.process();
		
		buffer.Swap();
		
		world.process();
		
		buffer.Swap();
		
		assertEquals(10, ePosition.X());
		assertEquals(16, ePosition.Y());
	}
	
	@Test
	public void ShouldSendMovementDataToTileSystemOnMove()
	{
		wIntent.Direction(MovementDirection.Left);
		
		buffer.Swap();
		
		world2.process();
		
		assertEquals(wEntity, xTileSystem.Unit);
		assertEquals(2 , xTileSystem.X);
		assertEquals(4 , xTileSystem.Y);		
	}

}
