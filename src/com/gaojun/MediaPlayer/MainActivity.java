package com.gaojun.MediaPlayer;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
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
	private List<Music> list ;
	private Util util;
	private static final String ROOT = "mnt/sdcard/";
	private Handler mHandler = new Handler(){
		@Override
		public void handleMessage(Message msg) {
			super.handleMessage(msg);
			if(msg.what == 1){
				
				adapter = new MyAdapter(MainActivity.this,(List<Music>)msg.obj);
				view.setAdapter(adapter);
			}
		}
		
	};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		view = (ListView) findViewById(R.id.lv);
		list = new ArrayList<Music>();
		util = new Util();
		new Thread(new Runnable() {
			@Override
			public void run() {
				list = util.getFiles(ROOT);
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
				
				
			}
		});
	}
}
