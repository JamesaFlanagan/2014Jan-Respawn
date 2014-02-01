package com.me.Actions;

import com.me.Interfaces.IActionManager;
import com.me.Interfaces.ITile;

public class SpikesTriggeredAction extends BaseAction {
	        
	public SpikesTriggeredAction(IActionManager manager)
	{
		super(manager);
	}
	
	@Override
	public void Execute(ITile tile) {
		
		Manager.IncrementSpikesTriggered();
	}

}
