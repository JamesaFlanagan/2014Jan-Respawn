package com.me.Systems.Tiles;

import com.artemis.Aspect;
import com.artemis.ComponentMapper;
import com.artemis.Entity;
import com.artemis.systems.EntityProcessingSystem;
import com.me.Components.CCollisionScript;
import com.me.Components.CPosition;
import com.me.Components.CTile;
import com.me.Systems.Scripts.IScriptHandler;

public class TileSystem extends EntityProcessingSystem implements ITileSystem {

	private Entity[][] _grid = new Entity[10][10];
	private ComponentMapper<CPosition> _positionMapper;
	private ComponentMapper<CCollisionScript> _collisionScriptMapper;
	private IScriptHandler _scriptHandler;
	
	@SuppressWarnings("unchecked")
	public TileSystem() {
		super(Aspect.getAspectForAll(CTile.class, CPosition.class));		
	}
	
	@Override
	protected void initialize() {
		_positionMapper = ComponentMapper.getFor(CPosition.class, world);
		_collisionScriptMapper = ComponentMapper.getFor(CCollisionScript.class, world);
	};
	
	@Override
	protected void inserted(Entity e) {
		super.inserted(e);
		CPosition position = _positionMapper.get(e);
		_grid[position.Y()][position.X()] = e;
		
	};
	
	@Override
	protected void removed(Entity e) {
		super.removed(e);
		CPosition position = _positionMapper.get(e);
		_grid[position.Y()][position.X()] = null;
	}

	@Override
	public boolean HasTile(int x, int y) {
		
		return _grid[y][x] != null;
	}
	
	public void SetScriptManager(IScriptHandler handler)
	{
		_scriptHandler = handler;
	}	
	
	@Override
	protected boolean checkProcessing() {
		
		return false;
	}

	@Override
	protected void process(Entity e) {

		
	}

	@Override
	public void MoveUnitTo(Entity unit, int x, int y) {
		
		Entity tile = _grid[y][x];
		
		CCollisionScript script = _collisionScriptMapper.getSafe(tile);
		
		if (script != null)
		{
			_scriptHandler.ExecuteScript(script.ScriptName(), tile, unit);
		}
		
		CCollisionScript unitScript = _collisionScriptMapper.getSafe(unit);
		
		if (unitScript != null)
		{
			_scriptHandler.ExecuteScript(unitScript.ScriptName() , unit, tile);
		}
		
	}
	
}
