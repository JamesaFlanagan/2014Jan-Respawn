package Tests;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import Objects.ScriptHandler;

import com.artemis.Entity;
import com.artemis.World;
import com.me.Components.CCollisionScript;
import com.me.Components.CPosition;
import com.me.Components.CTile;
import com.me.Systems.Tiles.TileSystem;

public class TileSystemTests {

	World world;
	TileSystem target;
	ScriptHandler handler;
	Entity unit;
	
	@Before
	public void Setup()
	{
		world = new World();
		
		target = world.setSystem(new TileSystem());  
		
		handler = new ScriptHandler();
		target.SetScriptManager(handler);
		
		world.initialize();
		
		unit = world.createEntity();
	}	
	
	@Test
	public void ShouldReturnFalseWhenNoTiles() {   
		
		assertEquals(false, target.HasTile(0, 0));
	}
	
	@Test
	public void ShouldReturnTrueWhenTilePresent() {   
		
		world.createEntity().addComponent(new CTile()).addComponent(new CPosition(0,0)).addToWorld();
		
		world.process();
		
		assertEquals(true, target.HasTile(0, 0));
	}
	
	@Test
	public void ShouldReturnFalseWhenAnotherTilePresentButNotPresent() {   
		
		world.createEntity().addComponent(new CTile()).addComponent(new CPosition(0,0)).addToWorld();
		
		world.process();
		
		assertEquals(false, target.HasTile(1, 1));
	}
	
	@Test
	public void ShouldReturnFalseWhenATileRemoved() {   
		
		Entity e = world.createEntity().addComponent(new CTile()).addComponent(new CPosition(0,0));
		
		e.addToWorld();
		
		world.process();
		
		world.deleteEntity(e);
		
		world.process();
		
		assertEquals(false, target.HasTile(0, 0));
	}
	
	@Test
	public void ShouldCallScriptManagerOnTilesScriptWithPlayerAsOther()
	{
		String scriptName = "Test";
		Entity tile = world.createEntity().addComponent(new CTile()).addComponent(new CPosition(0,0)).addComponent(new CCollisionScript(scriptName));
		 
		tile.addToWorld();
		world.process();
				
		target.MoveUnitTo(unit, 0, 0);
		
		assertEquals(scriptName, handler.ScriptName);
		assertEquals(tile, handler.Me);
		assertEquals(unit, handler.Other);		
	}
	
	@Test
	public void ShouldCallScriptManagerOnTilesScriptWithPlayerAsOther2()
	{
		String scriptName = "Easy";
		Entity tile = world.createEntity().addComponent(new CTile()).addComponent(new CPosition(0,0)).addComponent(new CCollisionScript(scriptName));
				
		tile.addToWorld();
		world.process();
		
		target.MoveUnitTo(unit, 0, 0);
		
		assertEquals(scriptName, handler.ScriptName);
		assertEquals(tile, handler.Me);
		assertEquals(unit, handler.Other);		
	}
	
	@Test
	public void ShouldCallNotCallScriptManagerOnTilesWithNoScript()
	{
		Entity tile = world.createEntity().addComponent(new CTile()).addComponent(new CPosition(0,0));
		 		
		tile.addToWorld();
		world.process();
				
		target.MoveUnitTo(unit, 0, 0);
				
		assertEquals(null, handler.Me);
		assertEquals(null, handler.Other);		
	}
	
	@Test
	public void ShouldCallScriptManagerOnUnitWithScript()
	{
		Entity tile = world.createEntity().addComponent(new CTile()).addComponent(new CPosition(0,0)).addComponent(new CCollisionScript("h"));
		Entity unit2 = world.createEntity().addComponent(new CCollisionScript("Random"));
				
		tile.addToWorld();
		unit2.addToWorld();
		
		world.process();
		
		target.MoveUnitTo(unit2, 0, 0);
		
		assertEquals(unit2, handler.SecondMe);
		assertEquals(tile, handler.SecondOther);
	}
	
	@Test
	public void ShouldNotCallScriptManagerOnUnitWithNoScript()
	{
		Entity tile = world.createEntity().addComponent(new CTile()).addComponent(new CPosition(0,0)).addComponent(new CCollisionScript("h"));
		Entity unit2 = world.createEntity();
				
		tile.addToWorld();
		unit2.addToWorld();
		
		world.process();
		
		target.MoveUnitTo(unit2, 0, 0);
		
		assertEquals(null, handler.SecondMe);
		assertEquals(null, handler.SecondOther);
	}
	

}
