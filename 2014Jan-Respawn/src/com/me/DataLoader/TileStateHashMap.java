package com.me.DataLoader;

import java.util.HashMap;

import com.me.Interfaces.IState;
import com.me.Interfaces.ITileState;

class TileStateHashMap {

	private final HashMap<String, ITileState> _index = new HashMap<String, ITileState>();
		
	public void Add (String key, ITileState value)
	{
		_index.put(key, value);
	}
	
	public ITileState Get(String key)
	{
		return _index.get(key);
	}
}
