package com.gaojun.MediaPlayer.DB;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.gaojun.MediaPlayer.Music;



public class MusicDB {
	public static final String DB_NAME = "media_player";
	public static  MusicDB musicDB;
	private SQLiteDatabase db;
	public static final int VERSION = 1;
	public MusicDB(Context context) {
		MusicOpenHelper helper = new MusicOpenHelper(context, DB_NAME, null, VERSION);
		db = helper.getWritableDatabase();
	}
	public synchronized static MusicDB getInstance(Context context) {
		if(musicDB == null){
			musicDB = new MusicDB(context);
		}
		return musicDB;
	}
	
	public void saveMusic(Music music) {
		if (music != null) {
			ContentValues values = new ContentValues();
			values.put("name", music.getName());
			values.put("path", music.getPath());
			db.insert("music", null, values);
		}
	}
	
	public List<Music> loadMusic(){
		List<Music> list = new ArrayList<Music>();
		Cursor c = db.query("music", null, null, null, null, null, null);
		if(c.moveToFirst()){
			do{
				Music music = new Music();
				music.setName(c.getString(c.getColumnIndex("name")));
				music.setPath(c.getString(c.getColumnIndex("path")));
				list.add(music);
			}while(c.moveToNext());
			
		}
		return list;
	}
}
