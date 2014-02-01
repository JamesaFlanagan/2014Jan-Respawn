package com.me.Systems.Scripts;

import com.artemis.Entity;
import com.artemis.World;

public interface IScriptHandler {

	void Initialise(World world);
	
	void ExecuteScript(String scriptName, Entity me, Entity other);
	
}
