package com.me.Components;

import com.artemis.Component;
import com.me.Aspects.DoubleBuffered.ManagedDoubleBufferedValue;
import com.me.Systems.AI.AIMode;
import com.me.Systems.Movement.MovementDirection;

public class CIntelligent extends Component {

	private AIMode _mode;
	private MovementDirection _direction;
	
	public CIntelligent(AIMode mode, MovementDirection direction)
	{
		_mode = mode;
		_direction = direction;
	}
	
	public MovementDirection CurrentDirection()
	{
		return _direction;
	}
	
	 public AIMode Mode()
	 {
		 return _mode;
	 }
	 
	 public CIntelligent CurrentDirection(MovementDirection direction)
	 {
		 _direction = direction;
		 return this;
	 }
	 	
}
