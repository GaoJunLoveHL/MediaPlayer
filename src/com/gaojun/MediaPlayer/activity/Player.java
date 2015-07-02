package com.gaojun.MediaPlayer.activity;

import com.gaojun.MediaPlayer.ControlMusic;
import com.gaojun.MediaPlayer.Music;
import com.gaojun.MediaPlayer.R;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Window;
import android.widget.TextView;

public class Player extends Activity {
	private ControlMusic controlMusic;
	private Uri uri;
	private Music music;
	private TextView song_name;
		
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.play_activity);
		song_name = (TextView) findViewById(R.id.song_name);
		Intent intent = getIntent();
		Bundle bundle = intent.getBundleExtra("bundle");
		music = (Music) bundle.getSerializable("music");
		uri = Uri.parse(music.getPath());
		controlMusic = new ControlMusic(this, uri);
		song_name.setText(music.getName());
	}
	
	@Override
	public void onBackPressed() {
		super.onBackPressed();
		Intent i = new Intent(this,MainActivity.class);
		startActivity(i);
		finish();
	}
}
