package com.me.Aspects.DoubleBuffered;

import java.util.ArrayList;
import java.util.List;


public class SimpleBufferManager implements IBufferManager {

	List<IDoubleBuffered> _list = new ArrayList<IDoubleBuffered>();
	
	@Override
	public void Register(IDoubleBuffered value) {
		
		_list.add(value);
	}

	@Override
	public void Clear() {
		_list.clear();
	}

	@Override
	public void Swap() {
		
		for(IDoubleBuffered value : _list)
		{
			value.Swap();
		}

	}
}
