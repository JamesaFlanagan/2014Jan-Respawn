package com.me.Systems.Levels;

import com.artemis.Entity;
import com.artemis.World;

public interface ILevel {

	Entity GeneratePlayer(World world);
	
	void GenerateLevel(World world);
	 
}
