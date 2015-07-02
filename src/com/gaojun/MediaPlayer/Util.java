package com.gaojun.MediaPlayer;

import java.io.File;
import android.content.Context;
import com.gaojun.MediaPlayer.DB.MusicDB;

public class Util {

	private Music music;
	private MusicDB db ;

	public Util(Context context) {
		db = MusicDB.getInstance(context);
	}

	public void getFiles(String root) {
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
						db.saveMusic(music);
					}
				}
			}
			
		} catch (Exception e) {
		}
//		for(Music m: list){
//			Log.d("List", m.getName());
//			Log.d("List", m.getPath());
//		}
		
		

	}

	public boolean isMusic(String name) {
		if (name.endsWith("mp3")) {
			return true;
		}
		return false;
	}

}
