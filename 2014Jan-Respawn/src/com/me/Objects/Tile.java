package com.me.Objects;

import com.me.Interfaces.ITile;
import com.me.Interfaces.ITileState;
import com.me.Interfaces.IUnit;

public class Tile implements ITile{

	private ITileState _state;
	private int _currentFrame = 0;
	private IUnit _unit = null;
	
	public Tile(ITileState state)
	{
		_state = state;
	}
	
	@Override
	public ITileState GetState() {
		return _state;
	}

	@Override
	public int GetCurrentFrame() {
		return _currentFrame;
	}

	@Override
	public void SetCurrentFrame(int frame) {
		_currentFrame = frame;		
	}

	@Override
	public IUnit GetUnit() {		
		return _unit;
	}

	@Override
	public void SetUnit(IUnit unit) {
		_unit = unit;		
	}

	@Override
	public void SetState(ITileState state) {
		_state = state;		
	}

}
