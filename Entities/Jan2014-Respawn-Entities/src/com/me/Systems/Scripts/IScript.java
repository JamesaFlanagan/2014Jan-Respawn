package com.me.Systems.Scripts;

import com.artemis.Entity;
import com.artemis.World;

public interface IScript {

	String Name();
	
	void Initialise(World world);
	
	void Execute(Entity me, Entity other);	
}
