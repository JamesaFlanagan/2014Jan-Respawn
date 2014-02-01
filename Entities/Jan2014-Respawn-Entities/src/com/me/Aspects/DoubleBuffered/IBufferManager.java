package com.me.Aspects.DoubleBuffered;

public interface IBufferManager {
	
	void Register(IDoubleBuffered value);
	
	void Clear();
	
	void Swap();
	
}
