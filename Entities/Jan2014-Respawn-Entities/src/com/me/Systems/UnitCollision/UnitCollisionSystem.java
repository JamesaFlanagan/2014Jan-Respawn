package com.me.Systems.UnitCollision;

import java.util.ArrayList;
import java.util.LinkedList;

import com.artemis.Aspect;
import com.artemis.ComponentMapper;
import com.artemis.Entity;
import com.artemis.systems.EntityProcessingSystem;
import com.me.Components.CCollisionScript;
import com.me.Components.CPosition;
import com.me.Components.CUnit;
import com.me.Systems.Scripts.IScriptHandler;

public class UnitCollisionSystem extends EntityProcessingSystem {

	private IScriptHandler _scriptHandler;
	private ComponentMapper<CCollisionScript> _collisionScriptMapper;
	private ComponentMapper<CPosition> _positionMapper;
		
	@SuppressWarnings("unchecked")
	public UnitCollisionSystem() {
		super(Aspect.getAspectForAll(CPosition.class, CUnit.class));
	}

	@Override
	protected void initialize() {
		super.initialize();
		
		_collisionScriptMapper = world.getMapper(CCollisionScript.class);
		_positionMapper = world.getMapper(CPosition.class);
	}
	
	public UnitCollisionSystem SetScriptHandler(IScriptHandler handler)
	{
		_scriptHandler = handler;
		return this;
	}
	
	private ArrayList<Entity> list = new ArrayList<Entity>();
	
	
	@Override
	protected void process(Entity e) {
		list.add(e); 
	}
	
	@Override
	protected void end() {
		super.end();
		
		if (list.size() >= 2)
		{		
			for(int i = 0; i < list.size(); ++i)
			{
				for(int j = i + 1; j < list.size(); ++j)
				{					
					CPosition posOne = _positionMapper.get(list.get(i));
					CPosition posTwo = _positionMapper.get(list.get(j));
					
					if (posOne.X() == posTwo.X() && posOne.Y() == posTwo.Y())
					{			
						CCollisionScript script1 = _collisionScriptMapper.getSafe(list.get(i));
						CCollisionScript script2 = _collisionScriptMapper.getSafe(list.get(j));
						
						if (script1 != null)_scriptHandler.ExecuteScript(script1.ScriptName(), list.get(i), list.get(j));
						if (script2 != null)_scriptHandler.ExecuteScript(script2.ScriptName(), list.get(j), list.get(i));
					}
					
				}
			}			
			
		}
		
		list.clear();
	}
	
	

}
