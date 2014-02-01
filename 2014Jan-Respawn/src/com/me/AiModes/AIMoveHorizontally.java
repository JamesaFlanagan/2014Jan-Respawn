package com.me.AiModes;

import com.me.Interfaces.IUnit;
import com.me.Levels.ILevel;

public class AIMoveHorizontally implements IAIMode {

	private final ILevel _level;
	private boolean _travellingLeft;
	
	public AIMoveHorizontally(ILevel level, boolean leftFirst)
	{
		_level = level;
		_travellingLeft = leftFirst;
	}
	
	@Override
	public void Execute(IUnit unit) {		
		
		if (_travellingLeft)
		{
			if (!_level.MoveLeft(unit))
			{
				_travellingLeft = false;
				Execute(unit);
			}
		}
		else
		{
			if (!_level.MoveRight(unit))
			{
				_travellingLeft = true;
				Execute(unit);
			}
		}
	}
}
