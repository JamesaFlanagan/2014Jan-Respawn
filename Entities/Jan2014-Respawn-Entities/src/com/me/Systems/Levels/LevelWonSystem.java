package com.me.Systems.Levels;

import com.artemis.Aspect;
import com.artemis.ComponentMapper;
import com.artemis.Entity;
import com.artemis.systems.EntityProcessingSystem;
import com.me.Components.CWinCondition;

public class LevelWonSystem extends EntityProcessingSystem {

	private ILevelSwitcher _switcher;
	private boolean _levelWon = false;
	private ComponentMapper<CWinCondition> _winMapper;
	
	@SuppressWarnings("unchecked")
	public LevelWonSystem() {
		super(Aspect.getAspectForAll(CWinCondition.class));
		
	}
	
	@Override
	protected void initialize() {
		super.initialize();
		
		_winMapper = world.getMapper(CWinCondition.class);	
		
	}
	
	public void SetLevelSwitcher(ILevelSwitcher levelSwitcher)
	{
		_switcher  = levelSwitcher;
	}
		
	@Override
	protected void begin() {		
		super.begin();
		
		_levelWon = true;
	}
	
	@Override
	protected void process(Entity e) {
		
		CWinCondition condition = _winMapper.get(e);
		
		_levelWon &=  condition.ConditionMet(); 
	}
	
	@Override
	protected void end() {		
		super.end();
		
		if (_levelWon) _switcher.SwitchToNextLevel();
	}

}
