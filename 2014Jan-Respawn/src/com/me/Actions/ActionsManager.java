package com.me.Actions;

import com.me.Interfaces.IActionManager;
import com.me.Interfaces.ITile;
import com.me.Interfaces.ITileState;
import com.me.Levels.BaseLevel;

public class ActionsManager implements IActionManager{

	private BaseLevel _currentLevel;	
	
	public void SetLevel(BaseLevel level)
	{
		_currentLevel = level;
	}
	
	@Override
	public void IncrementSpikesTriggered() {
		_currentLevel.IncrementSpikesTriggered();	
	}

	@Override
	public void ChangeTileState(ITile tile, ITileState state) {
		
		tile.SetState(state);		
	}

	@Override
	public void RespawnUnit(ITile tile) {
		_currentLevel.Move(tile.GetUnit(), _currentLevel.GetRespawnTile());		
	}
	

}
