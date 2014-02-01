package com.me.Aspects.DoubleBuffered;

public class ManagedDoubleBufferedValue<T> implements IDoubleBufferedValue<T> {

	private static IBufferManager _manager = new NoManagement();
	
	private IDoubleBufferedValue<T> _innerValue;
	
	public ManagedDoubleBufferedValue(T value)
	{			
		_innerValue = new DoubleBufferedValue<T>(value);
		_manager.Register(this);
	}
	
	@Override
	public T GetCurrentValue() {
		return _innerValue.GetCurrentValue();
	}

	@Override
	public T GetLastValue() {
		return _innerValue.GetLastValue();
	}

	@Override
	public void Set(T value) {
		_innerValue.Set(value);
	}

	@Override
	public void Swap() {
		_innerValue.Swap();		
	}

	public static void SetBufferManager(IBufferManager manager)
	{
		_manager = manager;
	}
	
}
