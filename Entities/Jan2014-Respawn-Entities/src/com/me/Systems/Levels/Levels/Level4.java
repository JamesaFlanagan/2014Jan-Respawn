package com.me.Systems.Levels.Levels;

import com.artemis.Entity;
import com.artemis.World;
import com.me.Systems.Levels.ILevel;

import entityFactory.EntityFactory;

public class Level4 implements ILevel {

	@Override
	public Entity GeneratePlayer(World world) {
		return EntityFactory.CreatePlayer(5 , 4, world);
	}

	@Override
	public void GenerateLevel(World world) {
		
		EntityFactory.CreateFloor(5, 4, world);
		EntityFactory.CreateFloor(5, 5, world);
		EntityFactory.CreateFloor(5, 6, world);
		EntityFactory.CreateFloor(5, 7, world);
		EntityFactory.CreateSpikes(5, 8, world);
		
		EntityFactory.CreateFloor(3, 6, world);
		EntityFactory.CreateFloor(4, 6, world);
		EntityFactory.CreateFloor(6, 6, world);
		EntityFactory.CreateFloor(7, 6, world);
		
		EntityFactory.CreateHorizontalEnemy(7, 6, true, world);
		
	}

}