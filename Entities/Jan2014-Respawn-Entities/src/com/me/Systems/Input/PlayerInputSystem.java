package com.me.Systems.Input;

import com.artemis.Aspect;
import com.artemis.ComponentMapper;
import com.artemis.Entity;
import com.artemis.systems.EntityProcessingSystem;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputProcessor;
import com.me.Components.CInputButton;
import com.me.Components.CMovementIntent;
import com.me.Components.CPosition;
import com.me.Components.CSize;
import com.me.Systems.IEnabled;
import com.me.Systems.Movement.MovementDirection;


public class PlayerInputSystem extends EntityProcessingSystem implements InputProcessor {

	private MovementDirection _direction = MovementDirection.None;
	private CMovementIntent _intent;
	private ComponentMapper<CInputButton> _inputMapper;
	private ComponentMapper<CSize> _sizeMapper;	
	private ComponentMapper<CPosition> _positionMapper;
	
	private IInputMapper _visualMapper;
	private IEnabled _dependentSystem;
	
	private int _touchX = -1;
	private int _touchY = -1;
	
	@SuppressWarnings("unchecked")
	public PlayerInputSystem() {
		super(Aspect.getAspectForAll(CInputButton.class, CSize.class, CPosition.class));
	}
	
	public void SetPlayer(Entity e)
	{
		_intent = e.getComponent(CMovementIntent.class);
	}
	
	public void SetVisualInputMapper(IInputMapper mapper)
	{
		_visualMapper = mapper;
	}

	@Override
	protected void initialize() {
		super.initialize();
		_inputMapper = world.getMapper(CInputButton.class);
		_sizeMapper = world.getMapper(CSize.class);
		_positionMapper = world.getMapper(CPosition.class);
	}
	
	@Override
	protected void process(Entity e) {				
			CInputButton input = _inputMapper.get(e);
			CSize size = _sizeMapper.get(e);
			CPosition position = _positionMapper.get(e);
					
			if ((_touchX  >= position.X() && _touchX <= position.X() + size.Width()) && (_touchY >= position.Y() && _touchY <= position.Y() + size.Height()))
						_direction = input.GetDirection();
						
	}
	
	@Override
	protected void end() {		
		_intent.Direction(_direction);
		
		_dependentSystem.SetEnabled(_direction != MovementDirection.None);
		
		_direction = MovementDirection.None;
		_touchX = -1;
		_touchY = -1;
		
	};

	public void SetDependentSystem(IEnabled enabled)
	{
		_dependentSystem = enabled;
	}
	
	@Override
	public boolean keyDown(int keycode) {
		
		switch (keycode)
		{
			case Keys.UP:
			{
				_direction = MovementDirection.Up;
				break;
			}
			
			case Keys.DOWN:
			{
				_direction = MovementDirection.Down;
				break;
			}
				
			case Keys.RIGHT:
			{
				_direction = MovementDirection.Right;
				break;
			}
			
			case Keys.LEFT:
			{
				_direction = MovementDirection.Left;
				break;
			}			
		}
			
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
		
		_touchX = _visualMapper.MapX(screenX);
		_touchY = _visualMapper.MapY(screenY);
		
		return true;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		
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
}
