package com.me.DataLoader;

import com.me.Interfaces.IState;
import com.me.Interfaces.ITextureDrawer;
import com.me.Interfaces.ITextureRegion;

public class CommonState implements IState {

	private final String _type;
	private final ITextureDrawer _textureDrawer;
	private final ITextureRegion[] _textureRegions;
	
	public CommonState(String type, ITextureRegion[] textureRegions, ITextureDrawer drawer)
	{
		_type = type;
		_textureRegions = textureRegions;
		_textureDrawer = drawer;		
	}
	
	@Override
	public String GetType() {		
		return _type;
	}

	@Override
	public int Draw(int frame, int x, int y) {
		_textureDrawer.TileDraw(_textureRegions[frame] , x, y);
		
		if (frame >= _textureRegions.length -1) return 0;
		
		return frame + 1;
		
	}
	
}
