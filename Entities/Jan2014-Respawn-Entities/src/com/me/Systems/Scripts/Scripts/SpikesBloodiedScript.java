package com.me.Systems.Scripts.Scripts;

import com.artemis.ComponentMapper;
import com.artemis.Entity;
import com.artemis.World;
import com.me.Components.CRenderable;
import com.me.Components.CWinCondition;
import com.me.Systems.Scripts.IScript;

public class SpikesBloodiedScript implements IScript {

	public static final String Name = "SpikesBloodied";
	
	private ComponentMapper<CWinCondition> _winMapper;
	private ComponentMapper<CRenderable> _renderMapper;
	
	@Override
	public String Name() {
		return Name;
	}

	@Override
	public void Initialise(World world) {
		_winMapper = world.getMapper(CWinCondition.class);
		_renderMapper = world.getMapper(CRenderable.class);
	}

	@Override
	public void Execute(Entity me, Entity other) {
		
		CWinCondition win =  _winMapper.get(me);
		CRenderable render = _renderMapper.get(me);
		
		win.ConditionMet(true);
		render.ImageName("BloodySpikes");
	}

}
