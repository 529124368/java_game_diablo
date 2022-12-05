package com.niubi.game;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import com.niubi.config.Define;

// Please note that on macOS your application needs to be started with the -XstartOnFirstThread JVM argument
public class DesktopLauncher {
	public static void main(String[] arg) {
		Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
		config.setForegroundFPS(60);
		config.setWindowedMode(Define.ScreenWidth, Define.ScreenHeight);
		config.setResizable(false);
		config.setIdleFPS(15);
		config.setTitle("diablo2 demo");
		new Lwjgl3Application(new NiubiGame(), config);
	}
}
