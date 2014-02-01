package com.me.Components;


import com.artemis.Component;
import com.me.Aspects.DoubleBuffered.ManagedDoubleBufferedValue;
import com.me.Systems.Render.RenderPosition;

public class CRenderable extends Component {

	private ManagedDoubleBufferedValue<String> _imageName;
	
	private int _xMultiplier;
	private int _yMultiplier;
	private RenderPosition _position;
	
	
	public CRenderable(String imageName, RenderPosition position, int xMultiplier, int yMultiplier)
	{
		_imageName = new ManagedDoubleBufferedValue<String>(imageName);
		_xMultiplier = xMultiplier;
		_yMultiplier = yMultiplier;
		_position = position;		
	}
	
	public String ImageName()
	{
		return _imageName.GetLastValue();
	}
	
	public CRenderable ImageName(String imageName)
	{
		_imageName.Set(imageName);
		return this;
	}
	
	public RenderPosition RenderPosition()
	{
		return _position;
	}
	
	public int XMultiplier()
	{
		return _xMultiplier;
	}
	
	public int YMultiplier()
	{
		return _yMultiplier;
	}
	
}
