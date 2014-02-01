package com.me.Components;

import com.artemis.Component;

public class CSize extends Component {

	private int _width;	
	private int _height;
	
	public CSize( int width, int height)
	{
		_width = width;
		_height = height;
	}	
	
	public int Width()
	{
		return _width;
	}
	
	public int Height()
	{
		return _height;
	}
	
}
