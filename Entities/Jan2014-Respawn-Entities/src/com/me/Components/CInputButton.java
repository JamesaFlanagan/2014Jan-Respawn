package com.me.Components;

import com.artemis.Component;
import com.me.Systems.Movement.MovementDirection;

public class CInputButton extends Component {

	private MovementDirection _direction;
	
	public CInputButton(MovementDirection direction)
	{
		_direction = direction;
	}
	
	public MovementDirection GetDirection()
	{
		return _direction;
	}	
}
