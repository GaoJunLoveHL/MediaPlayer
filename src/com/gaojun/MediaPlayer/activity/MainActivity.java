package com.gaojun.MediaPlayer.activity;

import java.util.ArrayList;
import java.util.List;

import com.gaojun.MediaPlayer.Music;
import com.gaojun.MediaPlayer.MyAdapter;
import com.gaojun.MediaPlayer.R;
import com.gaojun.MediaPlayer.Util;
import com.gaojun.MediaPlayer.DB.MusicDB;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

public class MainActivity extends Activity {
	private ListView view;
	private MyAdapter adapter;
	private List<Music> list;
	private MusicDB db;
	private Util util;
	private static final String ROOT = "mnt/sdcard/";
	private Handler mHandler = new Handler() {
		@Override
		public void handleMessage(Message msg) {
			super.handleMessage(msg);
			if (msg.what == 1) {
				adapter = new MyAdapter(MainActivity.this,
						(List<Music>) msg.obj);
				view.setAdapter(adapter);
			}
		}

	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		view = (ListView) findViewById(R.id.lv);
		db = MusicDB.getInstance(this);
		util = new Util(this);
		list = new ArrayList<Music>();
		new Thread(new Runnable() {
			@Override
			public void run() {
				if (db.loadMusic().isEmpty()) {
					util.getFiles(ROOT);
				}
				list = db.loadMusic();
				Message msg = mHandler.obtainMessage();
				msg.what = 1;
				msg.obj = list;
				mHandler.sendMessage(msg);
			}
		}).start();

		view.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				Music music = new Music();
				music = list.get(arg2);
				Intent intent = new Intent(MainActivity.this, Player.class);
				Bundle bundle = new Bundle();
				bundle.putSerializable("music", music);
				intent.putExtra("bundle", bundle);
				startActivity(intent);
				finish();
			}
		});
	}
}
