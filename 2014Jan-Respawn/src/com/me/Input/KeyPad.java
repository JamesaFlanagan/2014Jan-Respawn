package com.me.Input;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.me.Interfaces.ITextureDrawer;
import com.me.Objects.TextureRegionWrapper;

public class KeyPad {
	
	private final ArrowKey _leftKey;
	private final ArrowKey _rightKey;
	private final ArrowKey _downKey;
	private final ArrowKey _upKey;
	
	public KeyPad(TextureAtlas atlas, ITextureDrawer drawer, int x, int y, int width, int height)
	{
		float widthMultiplier = 3 / 10;
		float heightMultiplier = 4 / 10;
		
			int horizontalWidth = (int) width * 4 / 10;
			int horizontalHeight = (int) height * 2 /10;
			
			int verticalWidth = (int) width * 2 / 10;
			int verticalHeight = (int) height * 4 /10;
			
			int verticalX = x + horizontalWidth;
			int horizontalY = y + verticalHeight;
		
		//_leftKey = new ArrowKey(0, 0, 100, horizontalHeight, new TextureRegionWrapper(atlas.findRegion("LeftArrow")), drawer);
		_leftKey = new ArrowKey(x, horizontalY, horizontalWidth, horizontalHeight, new TextureRegionWrapper(atlas.findRegion("LeftArrow")), drawer);
		_rightKey = new ArrowKey(verticalX + verticalWidth, horizontalY , horizontalWidth, horizontalHeight, new TextureRegionWrapper(atlas.findRegion("RightArrow")), drawer);
		
		_downKey = new ArrowKey(verticalX, y, verticalWidth, verticalHeight,  new TextureRegionWrapper(atlas.findRegion("DownArrow")), drawer);
		_upKey = new ArrowKey(verticalX, horizontalY + horizontalHeight, verticalWidth , verticalHeight,  new TextureRegionWrapper(atlas.findRegion("UpArrow")), drawer); 
	}
	
	public void Draw()
	{
		_leftKey.Draw();
		_rightKey.Draw();
		_downKey.Draw();
		_upKey.Draw();
	}
	
	public ArrowPressed QueryArrowPress(int x, int y)
	{
		if (_leftKey.WasClicked(x, y)) return ArrowPressed.Left;
		if (_rightKey.WasClicked(x, y)) return ArrowPressed.Right;
		if (_upKey.WasClicked(x, y)) return ArrowPressed.Up;
		if (_downKey.WasClicked(x, y)) return ArrowPressed.Down;
		
		return ArrowPressed.None;
	}
}
