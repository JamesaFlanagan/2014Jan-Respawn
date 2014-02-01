package com.me.Components;

import com.artemis.Component;
import com.me.Aspects.DoubleBuffered.ManagedDoubleBufferedValue;

public class CPosition extends Component {

	private ManagedDoubleBufferedValue<Integer> _x;
	private ManagedDoubleBufferedValue<Integer> _y;
	
	public CPosition(int x, int y)
	{
		_x = new ManagedDoubleBufferedValue<Integer>(x);
		_y = new ManagedDoubleBufferedValue<Integer>(y);
	}
	
	public int Y()
	{
		return _y.GetLastValue();
	}
	
	public int X()
	{
		return _x.GetLastValue();
	}
	
	public CPosition Y(int value)
	{
		_y.Set(value);
		return this;
	}
	
	public CPosition X(int value)
	{
		_x.Set(value);
		return this;
	}
	
	
}
