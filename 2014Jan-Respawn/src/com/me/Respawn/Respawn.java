package com.me.Respawn;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.me.Actions.ActionsManager;
import com.me.DataLoader.AssetManager;
import com.me.Input.ArrowPressed;
import com.me.Input.PlayerInputProcessor;
import com.me.Interfaces.IActionManager;
import com.me.Levels.LevelList;
import com.me.Objects.SpriteBatchWrapper;
import com.me.Objects.VirtualScreenSize;

public class Respawn implements ApplicationListener {
	private OrthographicCamera camera;
	private SpriteBatch batch;
	private AssetManager assetManager;
	private PlayerInputProcessor playerProcessor;
	private IActionManager actionManager;
	private LevelList levels;
	private boolean gameWon = false;
	private BitmapFont font;
	private Music music;
	
	@Override
	public void create() {		
		float w = Gdx.graphics.getWidth();
		float h = Gdx.graphics.getHeight();
		
		font = new BitmapFont();
		
		music = Gdx.audio.newMusic(Gdx.files.internal("data/Jan2014-_Respawn.wav"));
		music.setLooping(true);
		music.play();
		
		camera = new OrthographicCamera(w, h);
		
		camera.setToOrtho(false, VirtualScreenSize.Width, VirtualScreenSize.Height);
		 
		batch = new SpriteBatch();
		
		actionManager = new ActionsManager();
		
		assetManager = new AssetManager(new SpriteBatchWrapper(batch), actionManager);
		
		levels = new LevelList(assetManager);
		
		playerProcessor = assetManager.GetPlayerInput(330, 100, 150, 150);
		
		LoadNextLevel();
		
		Gdx.input.setInputProcessor(playerProcessor);
	}

	@Override
	public void dispose() {
		batch.dispose();
		font.dispose();
		music.dispose();
	}

	@Override
	public void render() {		
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		
		if (!gameWon) Process();
		
		batch.setProjectionMatrix(camera.combined);
		batch.begin();
		if (!gameWon)
		{
			levels.Draw();
			playerProcessor.Draw();		
		}
		else
		{
			font.setColor(0, 0, 0, 1);
			font.draw(batch, "You Win!!", 200 , 150);
		}
		
		batch.end();
	}
	
	private void Process()
	{
		ArrowPressed arrows = playerProcessor.GetPressedButtons();
		
		if (arrows != ArrowPressed.None)
		{
			if (MovePlayer(arrows))
			{
				if (levels.LevelCompleted())
				{
					LoadNextLevel();
				}
				else
				{
					levels.ProcessEnemies();
				}
			}
			
		}
	}
	
	private void LoadNextLevel()
	{
		if (levels.NextLevelExists())
			actionManager.SetLevel(levels.getNextLevel());
		else
			gameWon = true;
	}
	
	private boolean MovePlayer(ArrowPressed arrow)
	{		
		switch(arrow)
		{
			case Left:
				return levels.MoveLeft();
				
			case Right:
				return levels.MoveRight();
				
			case Down:
				return levels.MoveDown();
				
			case Up:
				return levels.MoveUp();
		}
		
		return false;
	}	

	@Override
	public void resize(int width, int height) {
	}

	@Override
	public void pause() {
	}

	@Override
	public void resume() {
	}
}
