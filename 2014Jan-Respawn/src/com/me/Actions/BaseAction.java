package com.me.Actions;

import com.me.Interfaces.IAction;
import com.me.Interfaces.IActionManager;
import com.me.Interfaces.ITile;

public abstract class BaseAction implements IAction {

	protected IActionManager Manager;
	
	public BaseAction(IActionManager manager)
	{
		Manager = manager;
	}
	
	@Override
	public abstract void Execute(ITile tile);
}
