package Objects;

import com.me.Systems.Render.ICamera;
import com.me.Systems.Render.IRenderRequirements;
import com.me.Systems.Render.ISpriteBatch;
import com.me.Systems.Render.ITextureAtlas;

public class RenderRequirement implements IRenderRequirements {

	final ITextureAtlas _atlas;
	final ISpriteBatch _batch;
	
	final ICamera _camera = new Camera(); 
	
	public RenderRequirement(ITextureAtlas atlas, ISpriteBatch batch)
	{
		_atlas =  atlas;
		
		_batch = batch;				
	}
	
	@Override
	public ITextureAtlas GetTextureAtlas() {
		return _atlas;
	}

	@Override
	public ISpriteBatch GetSpriteBatch() {
		return _batch;
	}

	@Override
	public ICamera GetCamera() {
		return _camera;
	}

}
