package com.me.Input;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputProcessor;
import com.me.Interfaces.IVisualInputProcessor;
import com.me.Objects.VirtualScreenSize;

public class PlayerInputProcessor implements InputProcessor, IVisualInputProcessor {

	private ArrowPressed _arrowPressed = ArrowPressed.None;;
	private final KeyPad _keypad;
		
	public PlayerInputProcessor (KeyPad keypad)
	{
		_keypad = keypad;
	}
		
	@Override
	public boolean keyDown(int keycode) {
		 _arrowPressed = ConvertKeyPress(keycode);
		
		return true;
	}

	@Override
	public boolean keyUp(int keycode) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean keyTyped(char character) {
		// TODO Auto-generated method stub
		return false;
	}
 
	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		
		int x = (int) (screenX * (VirtualScreenSize.Width / (float) Gdx.graphics.getWidth())); 
		int y = (int) (screenY * (VirtualScreenSize.Height / (float) Gdx.graphics.getHeight()));
		
		_arrowPressed = _keypad.QueryArrowPress(x, VirtualScreenSize.Height-y);
				
		return true;
	}
	
	private ArrowPressed ConvertKeyPress(int pressed)
	{
		switch (pressed)
		{
			case Keys.LEFT:
				return ArrowPressed.Left;
			case Keys.RIGHT:
				return ArrowPressed.Right;
			case Keys.UP:
				return ArrowPressed.Up;
			case Keys.DOWN:
				return ArrowPressed.Down;
		}
		
		return ArrowPressed.None; 
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean scrolled(int amount) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void Draw() {
		
		_keypad.Draw();
		
	}

	@Override
	public ArrowPressed GetPressedButtons() {
		ArrowPressed output = _arrowPressed;
		
		_arrowPressed = ArrowPressed.None;
		
		return output;
	}
	
}
