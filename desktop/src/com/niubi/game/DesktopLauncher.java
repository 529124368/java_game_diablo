package com.niubi.game;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;

import lsz.niubi.config.Storage;
import lsz.niubi.game.NiubiGame;

// Please note that on macOS your application needs to be started with the -XstartOnFirstThread JVM argument
public class DesktopLauncher {
	public static void main(String[] arg) {
		Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
		config.setForegroundFPS(Storage.FPS);
		config.setWindowedMode(Storage.ScreenWidth, Storage.ScreenHeight);
		config.setResizable(false);
		config.setIdleFPS(Storage.IDLE_FPS);
		config.setTitle(Storage.GAME_TITLE);
		new Lwjgl3Application(new NiubiGame(), config);
	}
}
