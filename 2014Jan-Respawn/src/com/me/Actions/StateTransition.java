package com.me.Actions;

import com.me.Interfaces.IActionManager;
import com.me.Interfaces.ITile;
import com.me.Interfaces.ITileState;

public class StateTransition extends BaseAction {

	private final ITileState _state;
		
	public StateTransition(IActionManager manager, ITileState state)
	{
		super(manager);
		
		_state = state;
	}
	
	@Override
	public void Execute(ITile tile) {
		 Manager.ChangeTileState(tile, _state);
	}

}
