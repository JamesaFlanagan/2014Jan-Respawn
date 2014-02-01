package Tests;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import Objects.AllTileSystem;
import Objects.XEvenTileSystem;

import com.artemis.Entity;
import com.artemis.World;
import com.me.Components.CIntelligent;
import com.me.Components.CMovementIntent;
import com.me.Components.CPosition;
import com.me.Systems.AI.AIMode;
import com.me.Systems.AI.AISystem;
import com.me.Systems.Movement.MovementDirection;

public class AiSystemTests {

	World world;
	AISystem target;
	
	@Before
	public void Setup()
	{
		world = new World();
		
		target = world.setSystem(new AISystem());
		target.SetTileManager(new AllTileSystem());
		target.SetEnabled(true);
		
		world.initialize();
	}
	
	
	@Test
	public void ShouldSetMovementOfUnitToLeftIfMovingHorizontalAndLeft() {
		
		CMovementIntent intent = new CMovementIntent();
		
		Entity unit = world.createEntity().addComponent(new CPosition(5,5)).addComponent(intent).addComponent(new CIntelligent(AIMode.Horizontal, MovementDirection.Left));
		unit.addToWorld();
		
		world.process();
				
		assertEquals(MovementDirection.Left, intent.Direction());
	}
	
	@Test
	public void ShouldSetMovementRightIfMovingRight()
	{		
		CMovementIntent intent = new CMovementIntent();
		
		Entity unit = world.createEntity().addComponent(new CPosition(5,5)).addComponent(intent).addComponent(new CIntelligent(AIMode.Horizontal, MovementDirection.Right));
		unit.addToWorld();
		
		world.process();
				
		assertEquals(MovementDirection.Right, intent.Direction());
	}
	
	@Test
	public void ShouldSwapDirectionToRightIfHorizontalPathHasNoTile()
	{
		target.SetTileManager(new XEvenTileSystem());
		
		CIntelligent intelligent = new CIntelligent(AIMode.Horizontal, MovementDirection.Left); 
		
		world.createEntity().addComponent(new CPosition(4,5)).addComponent(new CMovementIntent()).addComponent(intelligent).addToWorld();
		 
		world.process();
		
		assertEquals(MovementDirection.Right, intelligent.CurrentDirection());
		
	}	
	
	@Test
	public void ShouldSwapDirectionToLeftIfHorizontalPathHasNoTile()
	{
		target.SetTileManager(new XEvenTileSystem());
		
		CIntelligent intelligent = new CIntelligent(AIMode.Horizontal, MovementDirection.Right); 
		
		world.createEntity().addComponent(new CPosition(4,5)).addComponent(new CMovementIntent()).addComponent(intelligent).addToWorld();
		 
		world.process();
		
		assertEquals(MovementDirection.Left, intelligent.CurrentDirection());
		
	}
	
	@Test
	public void ShouldSwapDirectionToUpIfVerticalPathHasNoTile()
	{
		target.SetTileManager(new XEvenTileSystem());
		
		CIntelligent intelligent = new CIntelligent(AIMode.Vertical, MovementDirection.Down); 
		
		world.createEntity().addComponent(new CPosition(5,5)).addComponent(new CMovementIntent()).addComponent(intelligent).addToWorld();
		 
		world.process();
		
		assertEquals(MovementDirection.Up, intelligent.CurrentDirection());
		
	}
	
	@Test
	public void ShouldSwapDirectionToDownIfVerticalPathHasNoTile()
	{
		target.SetTileManager(new XEvenTileSystem());
		
		CIntelligent intelligent = new CIntelligent(AIMode.Vertical, MovementDirection.Up); 
		
		world.createEntity().addComponent(new CPosition(5,5)).addComponent(new CMovementIntent()).addComponent(intelligent).addToWorld();
		 
		world.process();
		
		assertEquals(MovementDirection.Down, intelligent.CurrentDirection());
		
	}
	
	@Test
	public void ShouldRotateDirectionToRightIfClockwisePathHasNoTile()
	{
		target.SetTileManager(new XEvenTileSystem());
		
		CIntelligent intelligent = new CIntelligent(AIMode.ClockWise, MovementDirection.Up); 
		
		world.createEntity().addComponent(new CPosition(5,8)).addComponent(new CMovementIntent()).addComponent(intelligent).addToWorld();
		 
		world.process();
		
		assertEquals(MovementDirection.Right, intelligent.CurrentDirection());
	}
	
	@Test
	public void ShouldRotateDirectionToDownIfClockwisePathHasNoTile()
	{
		target.SetTileManager(new XEvenTileSystem());
		
		CIntelligent intelligent = new CIntelligent(AIMode.ClockWise, MovementDirection.Right); 
		
		world.createEntity().addComponent(new CPosition(6,8)).addComponent(new CMovementIntent()).addComponent(intelligent).addToWorld();
		 
		world.process();
		
		assertEquals(MovementDirection.Down, intelligent.CurrentDirection());
	}
	
	@Test
	public void ShouldRotateDirectionToLeftIfClockwisePathHasNoTile()
	{
		target.SetTileManager(new XEvenTileSystem());
		
		CIntelligent intelligent = new CIntelligent(AIMode.ClockWise, MovementDirection.Down); 
		
		world.createEntity().addComponent(new CPosition(5,8)).addComponent(new CMovementIntent()).addComponent(intelligent).addToWorld();
		 
		world.process();
		
		assertEquals(MovementDirection.Left, intelligent.CurrentDirection());
	}
	
	@Test
	public void ShouldRotateDirectionToUpIfClockwisePathHasNoTile()
	{
		target.SetTileManager(new XEvenTileSystem());
		
		CIntelligent intelligent = new CIntelligent(AIMode.ClockWise, MovementDirection.Left); 
		
		world.createEntity().addComponent(new CPosition(6,8)).addComponent(new CMovementIntent()).addComponent(intelligent).addToWorld();
		 
		world.process();
		
		assertEquals(MovementDirection.Up, intelligent.CurrentDirection());
	}
	
	@Test
	public void ShouldMoveUpIfClockwisePathHasTileAndMovingUp()
	{
		CIntelligent intelligent = new CIntelligent(AIMode.ClockWise, MovementDirection.Up); 
		
		world.createEntity().addComponent(new CPosition(5,8)).addComponent(new CMovementIntent()).addComponent(intelligent).addToWorld();
		 
		world.process();
		
		assertEquals(MovementDirection.Up, intelligent.CurrentDirection());
	}
	
	@Test
	public void ShouldMoveLeftIfClockwisePathHasTileAndMovingLeft()
	{
		CIntelligent intelligent = new CIntelligent(AIMode.ClockWise, MovementDirection.Left); 
		
		world.createEntity().addComponent(new CPosition(5,8)).addComponent(new CMovementIntent()).addComponent(intelligent).addToWorld();
		 
		world.process();
		
		assertEquals(MovementDirection.Left, intelligent.CurrentDirection());
	}
	
	@Test
	public void ShouldMoveRightIfClockwisePathHasTileAndMovingRight()
	{
		CIntelligent intelligent = new CIntelligent(AIMode.ClockWise, MovementDirection.Right); 
		
		world.createEntity().addComponent(new CPosition(5,8)).addComponent(new CMovementIntent()).addComponent(intelligent).addToWorld();
		 
		world.process();
		
		assertEquals(MovementDirection.Right, intelligent.CurrentDirection());
	}
	
	@Test
	public void ShouldMoveDownIfClockwisePathHasTileAndMovingDown()
	{
		CIntelligent intelligent = new CIntelligent(AIMode.ClockWise, MovementDirection.Down); 
		
		world.createEntity().addComponent(new CPosition(5,8)).addComponent(new CMovementIntent()).addComponent(intelligent).addToWorld();
		 
		world.process();
		
		assertEquals(MovementDirection.Down, intelligent.CurrentDirection());
	}
	
	@Test
	public void ShouldNotMoveIfDisabled()
	{		
		CMovementIntent intent = new CMovementIntent();
		
		Entity unit = world.createEntity().addComponent(new CPosition(5,5)).addComponent(intent).addComponent(new CIntelligent(AIMode.Horizontal, MovementDirection.Right));
		unit.addToWorld();
		
		target.SetEnabled(false);
		
		world.process();
				
		assertEquals(MovementDirection.None, intent.Direction());
	}

}
