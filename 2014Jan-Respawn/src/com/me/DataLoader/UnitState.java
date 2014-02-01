package com.me.DataLoader;

import com.me.Interfaces.IAction;
import com.me.Interfaces.ITextureDrawer;
import com.me.Interfaces.ITextureRegion;
import com.me.Interfaces.ITile;
import com.me.Interfaces.IUnitAction;
import com.me.Interfaces.IUnitState;

public class UnitState implements IUnitState{

	private final CommonState _state;
	private IUnitAction[] _enterActions = new IUnitAction[0];
	private IAction[] _collideAction = new IAction[0];
	
	public UnitState(String type, ITextureRegion[] textureRegions, ITextureDrawer drawer)
	{
		_state = new CommonState(type, textureRegions, drawer);
		
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
	public void OnEnter(ITile tile) {
		for(IUnitAction action : _enterActions)
		{
			if (action.GetTileType() == tile.GetState().GetType()) action.Execute(tile);
		}
	}
	
	public void SetEnterActions(IUnitAction[] actions)
	{
		_enterActions = actions;
	}

	public void SetCollideActions(IAction[] actions)
	{
		_collideAction = actions;
	}
	
	@Override
	public void OnCollide(ITile tile) {		
		for(IAction action : _collideAction)
		{
			action.Execute(tile);
		}
	}
	
}
