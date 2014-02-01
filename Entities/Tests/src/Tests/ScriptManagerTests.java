package Tests;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import Objects.SampleScript;

import com.artemis.Entity;
import com.artemis.World;
import com.me.Systems.Scripts.ScriptManager;

public class ScriptManagerTests {

	World OneScriptWorld;
		
	ScriptManager target;
	
	Entity me;
	Entity other;
	
	SampleScript script1;
	SampleScript script2;
	
	@Before
	public void Setup()
	{
		OneScriptWorld = new World();		
		
		me = OneScriptWorld.createEntity();
		other = OneScriptWorld.createEntity();
		
		target = new ScriptManager();
		
		script1 = new SampleScript();		
		script2 = new SampleScript("Random");
		
		target.Add(script1);
		target.Add(script2);
		
		target.Initialise(OneScriptWorld);
		
	}
	
	
	
	
	@Test
	public void ShouldPassWorldThroughOnInitialise() {
				
		assertEquals(OneScriptWorld, script1.World);		
	}
	
	@Test
	public void ShouldPassWorldToAllOnInitialise()
	{
		
		assertEquals(OneScriptWorld, script1.World);
		assertEquals(OneScriptWorld, script2.World);	
	}
	
	@Test
	public void ShouldCallExecuteOnScript()
	{		
		target.ExecuteScript("Test", me, other);
		
		assertEquals(me, script1.Me);
		assertEquals(other, script1.Other);
	}
	
	 @Test
	 public void ShouldCallExecuteOnlyOnNamedScript()
	 {
		
		target.ExecuteScript("Test", me, other);
		
		assertEquals(me, script1.Me);
		assertEquals(other, script1.Other);
		
		assertEquals(null, script2.Me);
		assertEquals(null, script2.Other);
		
	 }

}
