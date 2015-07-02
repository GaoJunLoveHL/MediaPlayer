package com.gaojun.MediaPlayer;

import java.io.IOException;

import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;

public class ControlMusic {
	private MediaPlayer player;
	public ControlMusic(Context context,Uri uri) {
		player = new MediaPlayer();
		try {
			player.setDataSource(context, uri);
			player.prepare();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void play(){ 
		player.start();
	}
	public void stop(){ 
		player.stop();
	}
	public void pause(){ 
		player.pause();
	}
}
