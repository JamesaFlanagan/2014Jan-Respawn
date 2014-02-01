package com.me.Components;

import com.artemis.Component;

public class CRespawnLocation extends Component {

	private int _x;
	private int _y;
	
	public CRespawnLocation(int x, int y)
	{
		 _x = x;
		 _y = y;
	}
	
	public int X()
	{
		return _x;
	}
	
	public int Y()
	{
		return _y;
	}
	
}
