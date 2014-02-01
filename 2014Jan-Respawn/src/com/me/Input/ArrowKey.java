package com.me.Input;

import com.me.Interfaces.ITextureDrawer;
import com.me.Interfaces.ITextureRegion;

public class ArrowKey {

	 private final int _x;
	 private final int _y;
	 private final int _width;
	 private final int _height;
	 private final ITextureRegion _region;
	 private final ITextureDrawer _drawer;
	
	public ArrowKey(int x, int y, int width, int height, ITextureRegion region, ITextureDrawer drawer)
	{
		_x = x;
		_y = y;
		_width = width;
		_height = height;
		_region = region;
		_drawer = drawer;
	}
	
	public void Draw()
	{
		_drawer.Draw(_region, _x, _y, _width, _height);
	}
	
	public boolean WasClicked(int x, int y)
	{
		return (x >= _x  && x <= _x + _width) && (y >= _y && y <= _y + _height);
	}
	
	
}
