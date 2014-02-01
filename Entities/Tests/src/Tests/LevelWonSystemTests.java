package Tests;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import Objects.LevelSwitcher;

import com.artemis.World;
import com.me.Components.CWinCondition;
import com.me.Systems.Levels.LevelWonSystem;

public class LevelWonSystemTests {
	
	World world;
	LevelWonSystem target;
	LevelSwitcher switcher;
	
	@Before
	public void Setup()
	{
		world = new World();
		target = world.setSystem(new LevelWonSystem());
		switcher = new LevelSwitcher();
		
		target.SetLevelSwitcher(switcher);
		world.initialize();		
	}
	
	@Test
	public void ShouldCallSwitchLevelIfNoWinItems() {	
		
		world.process();
		
		assertEquals(true, switcher.SwitchCalled);
	}
	
	@Test
	public void ShouldNotCallSwitchIfOneWinItemOfFalse()
	{		
		world.createEntity().addComponent(new CWinCondition()).addToWorld();
		
		world.process();
		
		assertEquals(false, switcher.SwitchCalled);
	}
	
	@Test
	public void ShouldCallSwitchIfOneWinItemOfFalse()
	{		
		world.createEntity().addComponent(new CWinCondition(true)).addToWorld();
		
		world.process();
		
		assertEquals(true, switcher.SwitchCalled);
	}

}
