package com.me.Components;

import com.artemis.Component;

public class CWinCondition extends Component {

	public boolean _conditionMet = false;
	
	public CWinCondition()
	{
		
	}
	
	public CWinCondition(boolean condition)
	{
		_conditionMet = condition;		  
	}	
	
	public boolean ConditionMet()
	{
		return _conditionMet;
	}	
	
	public CWinCondition ConditionMet(boolean met)
	{
		_conditionMet = met;
		return this;
	}
	
}
