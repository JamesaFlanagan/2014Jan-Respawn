package com.me.Systems.Levels.Levels;

import com.artemis.Entity;
import com.artemis.World;
import com.me.Systems.Levels.ILevel;

import entityFactory.EntityFactory;

public class Level5 implements ILevel {

	@Override
	public Entity GeneratePlayer(World world) {
		return EntityFactory.CreatePlayer(2, 5, world);
	}

	@Override
	public void GenerateLevel(World world) {
		
		
		EntityFactory.CreateFloor(2,5, world);
		EntityFactory.CreateFloor(3,5, world);
		EntityFactory.CreateFloor(4,5, world);
		EntityFactory.CreateFloor(5,5, world);
		EntityFactory.CreateFloor(6,5, world);
		EntityFactory.CreateFloor(7,5, world);
		EntityFactory.CreateFloor(8,5, world);
		EntityFactory.CreateSpikes(9,5, world);
		
		EntityFactory.CreateFloor(4,6, world);
		EntityFactory.CreateFloor(4,4, world);
		EntityFactory.CreateFloor(4,3, world);
		
		EntityFactory.CreateFloor(7,6, world);
		EntityFactory.CreateFloor(7,4, world);
		EntityFactory.CreateFloor(7,7, world);
		
		EntityFactory.CreateVerticalEnemy(7,6, true, world);
		EntityFactory.CreateVerticalEnemy(4,3, false, world);
		
	}

}
