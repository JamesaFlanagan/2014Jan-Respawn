package com.me.Systems.Scripts.Scripts;

import com.artemis.ComponentMapper;
import com.artemis.Entity;
import com.artemis.World;
import com.me.Components.CKillsPlayer;
import com.me.Components.CPosition;
import com.me.Components.CRespawnLocation;
import com.me.Systems.Scripts.IScript;

public class PlayerHitScript implements IScript {

	public static final String Name = "PlayerHit"; 
	
	private ComponentMapper<CPosition> _positionMapper;
	private ComponentMapper<CRespawnLocation> _respawnMapper;
	private ComponentMapper<CKillsPlayer> _killsPlayerMapper;
	
	@Override
	public String Name() {
		return Name;
	}

	@Override
	public void Initialise(World world) {
		_positionMapper = world.getMapper(CPosition.class);
		_respawnMapper = world.getMapper(CRespawnLocation.class);
		_killsPlayerMapper = world.getMapper(CKillsPlayer.class);
	}

	@Override
	public void Execute(Entity me, Entity other) {
		
 		CKillsPlayer killsPlayer = _killsPlayerMapper.getSafe(other);

		if (killsPlayer != null)
		{		
			CPosition position = _positionMapper.get(me);
			CRespawnLocation respawn = _respawnMapper.get(me);
			
			position.X(respawn.X());
			position.Y(respawn.Y());			
		}		
	}

}
