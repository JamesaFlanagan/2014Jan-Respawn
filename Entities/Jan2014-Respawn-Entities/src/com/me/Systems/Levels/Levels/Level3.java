package com.me.Systems.Levels.Levels;

import com.artemis.Entity;
import com.artemis.World;
import com.me.Systems.Levels.ILevel;

import entityFactory.EntityFactory;

public class Level3 implements ILevel {

	@Override
	public Entity GeneratePlayer(World world) {
		return EntityFactory.CreatePlayer(5 , 1, world);
	}

	@Override
	public void GenerateLevel(World world) {
		
		EntityFactory.CreateStationaryEnemy(5,5,world);
		
		EntityFactory.CreateFloor(5, 1, world);
		EntityFactory.CreateFloor(5, 2, world);
		EntityFactory.CreateFloor(5, 3, world);
		EntityFactory.CreateFloor(5, 4, world);
		EntityFactory.CreateFloor(5, 5, world);
		EntityFactory.CreateFloor(5, 6, world);
		EntityFactory.CreateFloor(5, 7, world);
		EntityFactory.CreateSpikes(5, 8, world);
		
		EntityFactory.CreateFloor(6, 3, world);
		
		EntityFactory.CreateFloor(7, 3, world);
		EntityFactory.CreateFloor(7, 4, world);
		EntityFactory.CreateFloor(7, 5, world);
		EntityFactory.CreateFloor(7, 6, world);
		EntityFactory.CreateFloor(7, 7, world);
		
		EntityFactory.CreateFloor(6, 7, world);

	}

}
