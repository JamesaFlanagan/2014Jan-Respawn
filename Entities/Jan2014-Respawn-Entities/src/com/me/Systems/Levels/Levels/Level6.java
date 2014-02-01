package com.me.Systems.Levels.Levels;

import com.artemis.Entity;
import com.artemis.World;
import com.me.Systems.Levels.ILevel;
import com.me.Systems.Movement.MovementDirection;

import entityFactory.EntityFactory;

public class Level6 implements ILevel {

	@Override
	public Entity GeneratePlayer(World world) {
		return EntityFactory.CreatePlayer(5, 0, world);
	}

	@Override
	public void GenerateLevel(World world) {
		
		EntityFactory.CreateFloor(1,1, world);
		EntityFactory.CreateFloor(2,1, world);
		EntityFactory.CreateFloor(3,1, world);
		EntityFactory.CreateFloor(4,1, world);
		EntityFactory.CreateFloor(5,1, world);
		EntityFactory.CreateFloor(6,1, world);
		EntityFactory.CreateFloor(7,1, world);
		EntityFactory.CreateFloor(8,1, world);
		
		EntityFactory.CreateFloor(1,8, world);
		EntityFactory.CreateFloor(2,8, world);
		EntityFactory.CreateFloor(3,8, world);
		EntityFactory.CreateFloor(4,8, world);
		EntityFactory.CreateFloor(5,8, world);
		EntityFactory.CreateFloor(6,8, world);
		EntityFactory.CreateFloor(7,8, world);
		EntityFactory.CreateFloor(8,8, world);

		EntityFactory.CreateFloor(1,2, world);
		EntityFactory.CreateFloor(1,3, world);
		EntityFactory.CreateFloor(1,4, world);
		EntityFactory.CreateFloor(1,5, world);
		EntityFactory.CreateFloor(1,6, world);
		EntityFactory.CreateFloor(1,7, world);

		EntityFactory.CreateFloor(8,2, world);
		EntityFactory.CreateFloor(8,3, world);
		EntityFactory.CreateFloor(8,4, world);
		EntityFactory.CreateFloor(8,5, world);
		EntityFactory.CreateFloor(8,6, world);
		EntityFactory.CreateFloor(8,7, world);
		
		EntityFactory.CreateFloor(5,0, world);
		
		EntityFactory.CreateSpikes(0,5, world);
		EntityFactory.CreateSpikes(5,9, world);
		EntityFactory.CreateSpikes(9,5, world);
		
		EntityFactory.CreateClockWiseEnemy(5, 8, MovementDirection.Right, world);
		EntityFactory.CreateClockWiseEnemy(3, 1, MovementDirection.Left, world);
		EntityFactory.CreateClockWiseEnemy(1, 6, MovementDirection.Up, world);
		EntityFactory.CreateClockWiseEnemy(8, 3, MovementDirection.Down, world);
		
	}

}
