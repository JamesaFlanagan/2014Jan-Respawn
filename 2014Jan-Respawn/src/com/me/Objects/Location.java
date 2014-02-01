package com.me.Objects;

public class Location {

	public int X;
	public int Y;
	
	public Location(int x, int y)
	{
		X = x;
		Y = y;
	}
	
	public Location Update(int x, int y)
	{
		X = x;
		Y = y;
		
		return this;
	}
	
}
