package com.me.Interfaces;

import com.me.Levels.BaseLevel;

public interface IActionManager {

	void SetLevel(BaseLevel level);
	
	void IncrementSpikesTriggered();
	
	void ChangeTileState(ITile tile, ITileState state);
	
	void RespawnUnit(ITile tile); 
}
