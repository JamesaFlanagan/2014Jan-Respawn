package com.me.Respawn;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.badlogic.gdx.tools.imagepacker.TexturePacker2;
import com.badlogic.gdx.tools.imagepacker.TexturePacker2.Settings;

public class Main {
	public static void main(String[] args) {
		LwjglApplicationConfiguration cfg = new LwjglApplicationConfiguration();
		cfg.title = "2014Jan-Respawn";
		cfg.useGL20 = false;
		cfg.width = 480;
		cfg.height = 320;
		
		//Settings settings = new Settings();
		//TexturePacker2.process(settings, "../images/Finished", "../2014Jan-Respawn-android/assets", "textureAtlas");
		
		new LwjglApplication(new Respawn(), cfg);
	}
}
