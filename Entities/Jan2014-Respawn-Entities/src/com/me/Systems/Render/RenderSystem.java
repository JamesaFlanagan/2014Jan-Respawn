package com.me.Systems.Render;

import java.util.Comparator;
import java.util.TreeSet;

import com.artemis.Aspect;
import com.artemis.ComponentMapper;
import com.artemis.Entity;
import com.artemis.EntitySystem;
import com.artemis.utils.ImmutableBag;
import com.me.Components.CPosition;
import com.me.Components.CRenderable;
import com.me.Components.CSize;

public class RenderSystem extends EntitySystem {

	private final ITextureAtlas _atlas; 
	private final ICamera _camera;
	private ISpriteBatch _batch; 
	
	private ComponentMapper<CRenderable> _renderMapper;
	private ComponentMapper<CPosition> _positionMapper;
	private ComponentMapper<CSize> _sizeMapper;
	
	private TreeSet<Entity> _list = new TreeSet<Entity>(new Comparator<Entity> (){

		@Override
		public int compare(Entity arg0, Entity arg1) {
			
			RenderPosition one = _renderMapper.get(arg0).RenderPosition();
			RenderPosition two = _renderMapper.get(arg1).RenderPosition();
			
			//if (one == two) return ;
			
			if ( one.ordinal() > two.ordinal()) return 1;
			
			return - 1;
		}
		
	});  
		
	@SuppressWarnings("unchecked")
	public RenderSystem(IRenderRequirements requirements) {
		super(Aspect.getAspectForAll(CPosition.class, CRenderable.class, CSize.class));
		
		_atlas = requirements.GetTextureAtlas();

		_camera = requirements.GetCamera();
		_batch =  requirements.GetSpriteBatch();
		
	}
	
	@Override
	protected void initialize() {
		
		_renderMapper = ComponentMapper.getFor(CRenderable.class, world);
		_positionMapper = ComponentMapper.getFor(CPosition.class, world);
		_sizeMapper = ComponentMapper.getFor(CSize.class, world);
	};
	
	@Override
	protected void begin() {
		
		_batch.SetProjectionMatrix(_camera.Combined());
		_batch.Begin();
	};

	@Override
	protected void end() {		
		_batch.End();		
	};
	
	protected void process(Entity e) {
		
		CRenderable render = _renderMapper.get(e);
		CPosition position = _positionMapper.get(e);
		CSize size = _sizeMapper.get(e);
		
		ITextureRegion region = _atlas.findRegion(render.ImageName());
		
 		_batch.Draw(region, position.X() * render.XMultiplier(), position.Y() * render.YMultiplier(), size.Width(), size.Height());
	}
	
	@Override
	protected void processEntities(ImmutableBag<Entity> entities)
	{	
		for(Entity e : _list)
		{
			process(e);
		}
	}
	
	public void Dispose()
	{    
		_batch.Dispose();
		_atlas.Dispose();		
	}

	@Override
	protected boolean checkProcessing() {
		return true;
	}
	
	@Override
	protected void inserted(Entity e) {
		super.inserted(e);
		_list.add(e);
	}
	
	@Override
	protected void removed(Entity e) {
		super.removed(e);
		
		_list.remove(e);
	}
}
