package com.me.Actions;

import com.me.Interfaces.IActionManager;
import com.me.Interfaces.ITile;
import com.me.Interfaces.IUnitAction;

public class RespawnUnit extends BaseAction implements IUnitAction{

	private String _tileType = "";
	
	public RespawnUnit(IActionManager manager, String tileType) {
		super(manager);
		
		_tileType = tileType;
	}
	
	public RespawnUnit(IActionManager manager) {
		super(manager);
	}

	@Override
	public void Execute(ITile tile) {
		Manager.RespawnUnit(tile);
	}

	@Override
	public String GetTileType() {
		return _tileType;
	}

}
