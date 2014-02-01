package com.me.Systems.Levels.Levels;

import com.artemis.Entity;
import com.artemis.World;
import com.me.Systems.Levels.ILevel;

import entityFactory.EntityFactory;

public class Level2 implements ILevel {

	@Override
	public Entity GeneratePlayer(World world) {
		return EntityFactory.CreatePlayer(4, 5, world);
	}

	@Override
	public void GenerateLevel(World world) {
		
		EntityFactory.CreateSpikes(1, 5, world);
		EntityFactory.CreateFloor(2, 5, world);
		EntityFactory.CreateFloor(3, 5, world);
		EntityFactory.CreateFloor(4, 5, world);
		EntityFactory.CreateFloor(5, 5, world);
		EntityFactory.CreateFloor(6, 5, world);
		EntityFactory.CreateFloor(7, 5, world);
		EntityFactory.CreateSpikes(8, 5, world);
	}

}
