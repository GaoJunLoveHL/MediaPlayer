package com.gaojun.MediaPlayer;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

public class MainActivity extends Activity {
	private Music music = new Music();
	private ListView view;
	private MyAdapter adapter;
	private List<Music> list = new ArrayList<Music>();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		view = (ListView) findViewById(R.id.lv);
		add("aa","/sdcard/");
		add("bb", "/sdcard");
		add("cc", "sdcard");
		adapter = new MyAdapter(this, list);
		view.setAdapter(adapter);
		view.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				
			}
		});
	}
	void add(String name,String path){
		music.setName(name);
		music.setPath(path);
		list.add(music);
	}
}
