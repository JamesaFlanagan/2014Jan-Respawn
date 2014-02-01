package com.me.Systems.Movement;

import com.artemis.Aspect;
import com.artemis.ComponentMapper;
import com.artemis.Entity;
import com.artemis.systems.EntityProcessingSystem;
import com.me.Components.CMovementIntent;
import com.me.Components.CPosition;
import com.me.Systems.Tiles.ITileSystem;

public class MovementSystem extends EntityProcessingSystem {

	private ComponentMapper<CPosition> _positionMapper;
	private ComponentMapper<CMovementIntent> _moveIntentMapper;
	
	private ITileSystem _tileSystem;
	
	@SuppressWarnings("unchecked")
	public MovementSystem() {
		super(Aspect.getAspectForAll(CMovementIntent.class, CPosition.class));		
	}
	
	@Override
	protected void initialize() {
		_positionMapper = ComponentMapper.getFor(CPosition.class, world);
		_moveIntentMapper = ComponentMapper.getFor(CMovementIntent.class, world);
	};

	public MovementSystem SetTileSystem(ITileSystem tileSystem)
	{
		_tileSystem = tileSystem;
		return this;
	}
	
	@Override
	protected void process(Entity e) {
		
		CPosition position = _positionMapper.get(e);
		CMovementIntent intent = _moveIntentMapper.get(e);
			
		
		switch (intent.Direction())
		{
			case Up:
			{
				if (_tileSystem.HasTile(position.X(), position.Y() + 1))
					{						
						position.Y(position.Y() + 1);
						_tileSystem.MoveUnitTo(e, position.X(), position.Y() + 1);
					}
				break;
			}
			
			case Down:
			{
				if (_tileSystem.HasTile(position.X(), position.Y() - 1))
					{
						position.Y(position.Y() - 1);
						_tileSystem.MoveUnitTo(e, position.X(), position.Y() - 1);
					}
				break;
			}
			
			case Left:
			{
				if (_tileSystem.HasTile(position.X() - 1, position.Y()))
					{
						position.X(position.X() - 1);		
						_tileSystem.MoveUnitTo(e, position.X() - 1, position.Y());
					}
				break;
			}
			
			case Right:
			{
				if (_tileSystem.HasTile(position.X() + 1, position.Y()))
					{
						position.X(position.X() + 1);
						_tileSystem.MoveUnitTo(e, position.X() + 1, position.Y());
					}
				break;
			}
		default:
			break;
		}
		
		intent.Direction(MovementDirection.None);
	}

}
