package com.me.Systems.AI;

import com.artemis.Aspect;
import com.artemis.ComponentMapper;
import com.artemis.Entity;
import com.artemis.systems.EntityProcessingSystem;
import com.me.Components.CIntelligent;
import com.me.Components.CMovementIntent;
import com.me.Components.CPosition;
import com.me.Systems.IEnabled;
import com.me.Systems.Movement.MovementDirection;
import com.me.Systems.Tiles.ITileSystem;

public class AISystem extends EntityProcessingSystem implements IEnabled {

	private ComponentMapper<CMovementIntent> _intentMapper;
	private ComponentMapper<CIntelligent> _intelligentMapper;
	private ComponentMapper<CPosition> _positionMapper;
	
	private ITileSystem _tileSystem;
	private boolean _process = false;
	 
	@SuppressWarnings("unchecked")
	public AISystem() {
		super(Aspect.getAspectForAll(CPosition.class, CMovementIntent.class, CIntelligent.class));
		
	}
	
	public AISystem SetTileManager(ITileSystem tileManager)
	{
		_tileSystem = tileManager;
		return this;		
	}
	
	@Override
	protected void initialize() {
		super.initialize();
		
		_intentMapper = world.getMapper(CMovementIntent.class);
		_intelligentMapper = world.getMapper(CIntelligent.class);
		_positionMapper = world.getMapper(CPosition.class);
	}
	

	@Override
	protected void process(Entity e) {
		
		CIntelligent intel = _intelligentMapper.get(e);
		
		CPosition position = _positionMapper.get(e);
		
		if (intel.Mode() == AIMode.Horizontal)
		{		
			if (intel.CurrentDirection() == MovementDirection.Left && !_tileSystem.HasTile(position.X() -1, position.Y()))
				intel.CurrentDirection(MovementDirection.Right);
			else
			if (intel.CurrentDirection() == MovementDirection.Right && !_tileSystem.HasTile(position.X() +1, position.Y()))
				intel.CurrentDirection(MovementDirection.Left);
		}
		else if (intel.Mode() == AIMode.Vertical)
		{
			if (intel.CurrentDirection() == MovementDirection.Down && !_tileSystem.HasTile(position.X(), position.Y()-1))
				intel.CurrentDirection(MovementDirection.Up);
			else
			if (intel.CurrentDirection() == MovementDirection.Up && !_tileSystem.HasTile(position.X(), position.Y()+1))
				intel.CurrentDirection(MovementDirection.Down);
		}
		else if (intel.Mode() == AIMode.ClockWise)
		{
			if (intel.CurrentDirection() == MovementDirection.Up && !_tileSystem.HasTile(position.X(), position.Y()+1))
				intel.CurrentDirection(MovementDirection.Right);
			else if (intel.CurrentDirection() == MovementDirection.Down && !_tileSystem.HasTile(position.X(), position.Y() -1))
				intel.CurrentDirection(MovementDirection.Left);			
			else if (intel.CurrentDirection() == MovementDirection.Left && !_tileSystem.HasTile(position.X() -1, position.Y()))
				intel.CurrentDirection(MovementDirection.Up);	
			else if (intel.CurrentDirection() == MovementDirection.Right && !_tileSystem.HasTile(position.X() +1, position.Y()))
				intel.CurrentDirection(MovementDirection.Down);
		}
		
		_intentMapper.get(e).Direction(intel.CurrentDirection());
		
	}
	
	public void SetEnabled(boolean enabled)
	{
		_process = enabled;
	}
	
	@Override
	protected boolean checkProcessing() {	
		return _process;
	}

}
