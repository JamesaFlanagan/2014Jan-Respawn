package com.me.DataLoader;

import com.me.Interfaces.IAction;
import com.me.Interfaces.ITextureDrawer;
import com.me.Interfaces.ITextureRegion;
import com.me.Interfaces.ITile;
import com.me.Interfaces.ITileState;

class TileState implements ITileState {

	private final CommonState _state;
	private final Boolean _blocksMovement;
	private IAction[] _entryActions = new IAction[0];
	
	public TileState(String type, ITextureRegion[] textureRegions, ITextureDrawer drawer, boolean blocksMovement)
	{
		_state = new CommonState(type, textureRegions, drawer);
		_blocksMovement = blocksMovement;
		
	}
	
	@Override
	public String GetType() {		
		return _state.GetType();
	}

	@Override
	public int Draw(int frame, int x, int y) {
		return _state.Draw(frame, x, y);		
	}

	@Override
	public boolean BlocksMovement() {
		return _blocksMovement;
	}

	
	public void SetEntryActions(IAction[] actions) {
		_entryActions = actions;		
	}

	@Override
	public void OnEnter(ITile tile) {
		for (int i = 0; i < _entryActions.length; ++i)
			_entryActions[i].Execute(tile);
	}

}
