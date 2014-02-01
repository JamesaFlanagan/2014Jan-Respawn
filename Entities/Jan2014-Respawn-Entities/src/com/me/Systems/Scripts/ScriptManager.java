package com.me.Systems.Scripts;

import java.util.ArrayList;

import com.artemis.Entity;
import com.artemis.World;

public class ScriptManager implements IScriptHandler {

	private ArrayList<IScript> _scripts = new ArrayList<IScript>(); 
	
	@Override
	public void ExecuteScript(String scriptName, Entity me, Entity other) {
		
		for(IScript script : _scripts)
		{
			if (script.Name() == scriptName) script.Execute(me, other);
		}
	}

	@Override
	public void Initialise(World world) {
		
		for(IScript script : _scripts)
		{
			script.Initialise(world);
		}		
	}	
	
	public void Add(IScript script)
	{
		_scripts.add(script);
	}
	
}
