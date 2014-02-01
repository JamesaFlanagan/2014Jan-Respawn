package com.me.Respawn_Entities;


import java.util.Stack;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.me.Systems.Levels.ILevel;
import com.me.Systems.Levels.LevelSwitcher;
import com.me.Systems.Levels.Levels.GameWonLevel;
import com.me.Systems.Levels.Levels.Level1;
import com.me.Systems.Levels.Levels.Level2;
import com.me.Systems.Levels.Levels.Level3;
import com.me.Systems.Levels.Levels.Level4;
import com.me.Systems.Levels.Levels.Level5;
import com.me.Systems.Levels.Levels.Level6;

public class Respawn_Entities implements ApplicationListener {

	private LevelSwitcher _switcher;
	private Music _music;
	
	@Override
	public void create() {
		
		_music = Gdx.audio.newMusic(Gdx.files.internal("data/Jan2014-_Respawn.wav"));
		_music.setLooping(true);
		_music.play();
		
		Stack<ILevel> levels = new Stack<ILevel>();
		
		levels.push(new GameWonLevel());
		levels.push(new Level6());
		levels.push(new Level5());
		levels.push(new Level4());
		levels.push(new Level3());
		levels.push(new Level2());
		levels.push(new Level1());
		
		_switcher = new LevelSwitcher(levels);
		
		_switcher.SwitchToNextLevel();
				
	}
	
	@Override
	public void dispose() {
		_music.dispose();
		_switcher.Dispose();
	}

	@Override
	public void render() {	
		
		_switcher.Process();
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
