package com.me.Components;

import com.artemis.Component;

public class CCollisionScript extends Component {

	private String _scriptName;
	
	public CCollisionScript(String scriptName)
	{
		_scriptName = scriptName;
	}
		
	public String ScriptName()
	{
		return _scriptName;
	}
	
}
