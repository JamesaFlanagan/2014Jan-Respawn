package com.me.Systems.Input;

import com.me.ScreenView;

public class ScalingInputMapperVerticalFlip implements IInputMapper {

	private int _originalX;
	private int _originalY;
	
	public ScalingInputMapperVerticalFlip(int originalX, int originalY)
	{
		_originalX = originalX;
		_originalY = originalY;
	}
	
	@Override
	public int MapX(int X) {
		
		return (int) (X * (ScreenView.Width / (float) _originalX));
	}

	@Override
	public int MapY(int Y) {
		
		return ScreenView.Height - (int) (Y * ( ScreenView.Height / (float) _originalY));		
	}

}
