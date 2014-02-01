package com.me.Aspects.DoubleBuffered;

public interface IDoubleBufferedValue<T> extends IDoubleBuffered {
	
	public T GetCurrentValue();
	
	public T GetLastValue();
	
	public void Set(T value);
	
}
