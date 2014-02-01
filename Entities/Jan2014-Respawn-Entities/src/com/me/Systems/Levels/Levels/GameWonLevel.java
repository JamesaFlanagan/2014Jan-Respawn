package com.me.Systems.Levels.Levels;

import com.artemis.Entity;
import com.artemis.World;
import com.me.Systems.Levels.ILevel;

import entityFactory.EntityFactory;

public class GameWonLevel implements ILevel {

	@Override
	public Entity GeneratePlayer(World world) {
		
		return EntityFactory.CreatePlayer(7, 5, world);
	}

	@Override
	public void GenerateLevel(World world) {
		
		EntityFactory.CreateGameWonLabel(world);

	}

}
