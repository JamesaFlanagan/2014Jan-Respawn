package com.me.Systems.Levels;

import java.util.Stack;

import com.artemis.World;
import com.badlogic.gdx.Gdx;
import com.me.Aspects.DoubleBuffered.IBufferManager;
import com.me.Aspects.DoubleBuffered.ManagedDoubleBufferedValue;
import com.me.Aspects.DoubleBuffered.SimpleBufferManager;
import com.me.Systems.AI.AISystem;
import com.me.Systems.Input.PlayerInputSystem;
import com.me.Systems.Input.ScalingInputMapperVerticalFlip;
import com.me.Systems.Movement.MovementSystem;
import com.me.Systems.Render.RenderRequirements;
import com.me.Systems.Render.RenderSystem;
import com.me.Systems.Scripts.ScriptManager;
import com.me.Systems.Scripts.Scripts.PlayerHitScript;
import com.me.Systems.Scripts.Scripts.SpikesBloodiedScript;
import com.me.Systems.Tiles.TileSystem;
import com.me.Systems.UnitCollision.UnitCollisionSystem;

import entityFactory.EntityFactory;

public class LevelSwitcher implements ILevelSwitcher {

	private final Stack<ILevel> _levels; 
	
	private World _world;
	private RenderSystem _renderSystem;
	private PlayerInputSystem _inputSystem;
	
	private ScriptManager _scriptHandler = new ScriptManager();
	
	private IBufferManager _buffer = new SimpleBufferManager();
	
	public LevelSwitcher(Stack<ILevel> levels)
	{
		ManagedDoubleBufferedValue.SetBufferManager(_buffer);
		_levels = levels;
		LoadScripts();
	}
	
	private void SetupCommon()
	{
		_buffer.Clear();
		
		Dispose();
		
		_world = new World();
		
		_scriptHandler.Initialise(_world);
		
		_renderSystem = _world.setSystem(new RenderSystem(new RenderRequirements()));

		_inputSystem = _world.setSystem(new PlayerInputSystem());
		_inputSystem.SetVisualInputMapper(new ScalingInputMapperVerticalFlip(Gdx.graphics.getWidth(), Gdx.graphics.getHeight()));
		
		Gdx.input.setInputProcessor(_inputSystem);
		
		TileSystem tileSystem = _world.setSystem(new TileSystem()); 
		tileSystem.SetScriptManager(_scriptHandler);
				
		_inputSystem.SetDependentSystem(_world.setSystem(new AISystem().SetTileManager(tileSystem)));
		
		_world.setSystem(new MovementSystem().SetTileSystem(tileSystem));
		
		_world.setSystem(new UnitCollisionSystem().SetScriptHandler(_scriptHandler));
		
		LevelWonSystem wonSystem = _world.setSystem(new LevelWonSystem());
		
		wonSystem.SetLevelSwitcher(this);
		
		_world.initialize();
		
	}
	
	private void LoadScripts()
	{
		_scriptHandler.Add(new SpikesBloodiedScript());
		_scriptHandler.Add(new PlayerHitScript());
	}
	
	@Override
	public void SwitchToNextLevel() {
		
		SetupCommon();
		
		EntityFactory.CreateKeyPad(330, 100, 150, 150, _world);
		
		ILevel level = _levels.pop();
		
		_inputSystem.SetPlayer(level.GeneratePlayer(_world));
		
		level.GenerateLevel(_world);
	}
	
	public void Dispose()
	{
		if (_renderSystem != null) _renderSystem.Dispose();
	}

	public void Process()
	{
		_world.setDelta(Gdx.graphics.getDeltaTime());
		
		_world.process();
		
		_buffer.Swap();
	}
	
}
