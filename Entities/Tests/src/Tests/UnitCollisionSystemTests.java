package Tests;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import Objects.ScriptHandler;

import com.artemis.Entity;
import com.artemis.World;
import com.me.Aspects.DoubleBuffered.ManagedDoubleBufferedValue;
import com.me.Aspects.DoubleBuffered.SimpleBufferManager;
import com.me.Components.CCollisionScript;
import com.me.Components.CPosition;
import com.me.Components.CUnit;
import com.me.Systems.UnitCollision.UnitCollisionSystem;

public class UnitCollisionSystemTests {

	World world;
	ScriptHandler handler;
	UnitCollisionSystem target;
	Entity one;
	SimpleBufferManager buffer;
	
	@Before
	public void Setup()
	{
		world = new World();
		handler = new ScriptHandler();
		buffer = new SimpleBufferManager();
		ManagedDoubleBufferedValue.SetBufferManager(buffer);
				
		target = world.setSystem(new UnitCollisionSystem()).SetScriptHandler(handler);
		
		world.initialize();
		
		one = world.createEntity().addComponent(new CPosition(0,0)).addComponent(new CUnit()).addComponent(new CCollisionScript("Test"));
		
		one.addToWorld();
	}
	
	
	@Test
	public void shouldRunUnitsScriptsOnCollision() {
		
		Entity two = world.createEntity().addComponent(new CPosition(0,0)).addComponent(new CUnit()).addComponent(new CCollisionScript("Other"));
		
		two.addToWorld();
		
		world.process();
		
		assertEquals("Test", handler.ScriptName);
		assertEquals(one, handler.Me);
		assertEquals(two, handler.Other);
		
		assertEquals("Other", handler.SecondScriptName);
		assertEquals(two, handler.SecondMe);
		assertEquals(one, handler.SecondOther);
	}
	
	@Test
	public void shouldNotRunScriptsIfDifferentPositions() {
		
		Entity two = world.createEntity().addComponent(new CPosition(0,1)).addComponent(new CUnit()).addComponent(new CCollisionScript("Other"));
		
		two.addToWorld();
		
		world.process();
		
		assertEquals(null, handler.ScriptName);
		assertEquals(null, handler.Me);
		assertEquals(null, handler.Other);
	}
	
	@Test
	public void shouldNotCauseCollisionIfOnlyOneUnit()
	{		
		world.process();
		
		assertEquals(null, handler.ScriptName);
		assertEquals(null, handler.Me);
		assertEquals(null, handler.Other);
	}
	
	@Test
	public void shouldNotCauseCollisionIfPositionChangesToNotBeColliding()
	{	
		Entity two = world.createEntity().addComponent(new CPosition(0,0)).addComponent(new CUnit()).addComponent(new CCollisionScript("Other"));
		
		two.addToWorld();
		
		world.process();
		
		handler = new ScriptHandler();
		target.SetScriptHandler(handler);
		
		two.getComponent(CPosition.class).X(5);
		
		buffer.Swap();
		
		world.process();
		
		assertEquals(null, handler.ScriptName);
		assertEquals(null, handler.Me);
		assertEquals(null, handler.Other);
	}	

	@Test
	public void shouldCallOneCollisionIfOneHasActionAndOneDoesNot()
	{
		Entity two = world.createEntity().addComponent(new CPosition(0,0)).addComponent(new CUnit());
		
		two.addToWorld();
		
		world.process();
		
		assertEquals("Test", handler.ScriptName);
		assertEquals(one, handler.Me);
		assertEquals(two, handler.Other);  
		
		assertEquals(null, handler.SecondScriptName);
		assertEquals(null, handler.SecondMe);
		assertEquals(null, handler.SecondOther);
	}
	
	@Test
	public void shouldCheckCollisionOnAllUnits()
	{
		Entity two = world.createEntity().addComponent(new CPosition(0,0)).addComponent(new CUnit());
		Entity three = world.createEntity().addComponent(new CPosition(0,0)).addComponent(new CUnit());
		
		two.addToWorld();
		three.addToWorld();		
		
		world.process();
		
		assertEquals("Test", handler.ScriptName);
		assertEquals(one, handler.Me);
		assertEquals(two, handler.Other);
		
		assertEquals("Test", handler.SecondScriptName);
		assertEquals(one, handler.SecondMe);
		assertEquals(three, handler.SecondOther);
	}
}
