package com.gaojun.MediaPlayer;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import android.util.Log;

public class Util {

	private Music music;
	private List<Music> list;

	public Util() {
		list = new ArrayList<Music>();
	}

	public List<Music> getFiles(String root) {
		File file = new File(root);
		File[] files = file.listFiles();

		try {
			for (File f : files) {
				if (f.isDirectory()) {
					getFiles(f.getAbsolutePath());
				} else {
					if (isMusic(f.getName())) {
						music = new Music();
						music.setName(f.getName());
						music.setPath(f.getPath());
						list.add(music);
					}
				}
			}
			
		} catch (Exception e) {
		}
		for(Music m: list){
			Log.d("List", m.getName());
			Log.d("List", m.getPath());
		}
		
		return list;

	}

	public boolean isMusic(String name) {
		if (name.endsWith("mp3")) {
			return true;
		}
		return false;
	}

}
