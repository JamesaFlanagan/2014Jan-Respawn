package com.me.Aspects.DoubleBuffered;

public class DoubleBufferedValue<T> implements IDoubleBufferedValue<T> {

	private T _lastValue;
	private T _value;
	
	public DoubleBufferedValue(T value)
	{
		_lastValue  = value;
		_value = value;
	}
	
	public T GetCurrentValue()
	{
		return _value;
	}
	
	public T GetLastValue()
	{
		return _lastValue;
	}
	
	public void Set(T value)
	{
		_value = value;
	}
	
	public void Swap()
	{	
		_lastValue = _value;
	}
}
