package com.me.Objects;

import com.me.AiModes.IAIMode;
import com.me.AiModes.NoMovement;
import com.me.Interfaces.IUnit;
import com.me.Interfaces.IUnitState;

public class Unit implements IUnit {

	private final IUnitState _state;
	private int _currentFrame = 0;
	private IAIMode _mode;
	
	public Unit(IUnitState state)
	{
		this(state, new NoMovement());
	}
	
	public Unit(IUnitState state, IAIMode mode)
	{		
		_state = state;
		_mode = mode;
	}
	
	@Override
	public IUnitState GetState() {
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
	public void DoTurn() {
		_mode.Execute(this);
	}
	
}
