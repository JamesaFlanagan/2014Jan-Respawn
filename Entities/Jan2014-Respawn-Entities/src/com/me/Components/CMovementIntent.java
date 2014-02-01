package com.me.Components;

import com.artemis.Component;
import com.me.Systems.Movement.MovementDirection;


public class CMovementIntent extends Component {
	
	private MovementDirection _direction;
	
	public CMovementIntent()
	{
		_direction = MovementDirection.None;
	}
	
	public CMovementIntent(MovementDirection direction)
	{
		_direction = direction;
	}	
	
	public MovementDirection Direction() {
		return _direction;
	}
	
	public CMovementIntent Direction(MovementDirection direction)
	{
		_direction = direction;
		return this;
	}

}
