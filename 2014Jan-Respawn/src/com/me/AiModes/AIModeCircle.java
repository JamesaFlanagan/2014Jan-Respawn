package com.me.AiModes;

import com.me.Interfaces.IUnit;
import com.me.Levels.ILevel;

public class AIModeCircle implements IAIMode {

	private final ILevel _level;
	private Direction _direction;
	
	public AIModeCircle(ILevel level, Direction startingDirection)
	{
		_level = level;
		_direction = startingDirection;
	}
	
	@Override
	public void Execute(IUnit unit) {
		
		switch (_direction)
		{
			case Left:
			{
				if (!_level.MoveLeft(unit))
				{
					_direction = Direction.Up;
					Execute(unit);
				}
				return;
			}
			
			case Right:
			{
				if (!_level.MoveRight(unit))
				{
					_direction = Direction.Down;
					Execute(unit);
				}
				return;
			}
			
			case Up:
			{
				if (!_level.MoveUp(unit))
				{
					_direction = Direction.Right;
					Execute(unit);
				}
				return;
			}
			
			case Down:
			{
				if (!_level.MoveDown(unit))
				{
					_direction = Direction.Left;
					Execute(unit);
				}
				return;
			}
		}

	}

}
