package com.me.AiModes;

import com.me.Interfaces.IUnit;
import com.me.Levels.ILevel;

public class AIMoveVertically implements IAIMode{

	private final ILevel _level;
	private boolean _travellingUp;
	
	public AIMoveVertically(ILevel level, boolean upFirst)
	{
		_level = level;
		_travellingUp = upFirst;
	}
	
	@Override
	public void Execute(IUnit unit) {		
		
		if (_travellingUp)
		{
			if (!_level.MoveUp(unit))
			{
				_travellingUp = false;
				Execute(unit);
			}
		}
		else
		{
			if (!_level.MoveDown(unit))
			{
				_travellingUp = true;
				Execute(unit);
			}
		}
	}
	
}
