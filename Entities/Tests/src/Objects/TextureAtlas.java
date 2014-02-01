package Objects;

import com.me.Systems.Render.ITextureAtlas;
import com.me.Systems.Render.ITextureRegion;

public class TextureAtlas implements ITextureAtlas {

	TextureRegion one = new TextureRegion(1);
	TextureRegion two = new TextureRegion(2);
	
	public boolean DisposeCalled = false;
	
	@Override
	public ITextureRegion findRegion(String name) {
		
		if (name == "one") return one;
		if (name == "two") return two;		
		
		return null;
	}

	@Override
	public void Dispose() {		

		DisposeCalled = true;
		
	}

}
