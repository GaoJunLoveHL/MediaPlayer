package com.gaojun.MediaPlayer.activity;

import com.gaojun.MediaPlayer.R;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class MyTitle extends LinearLayout{
	private Button back;
	private Button menu;
	public MyTitle(Context context, AttributeSet attrs) {
		super(context, attrs);
		LayoutInflater.from(context).inflate(R.layout.title, this);
		back = (Button) findViewById(R.id.back);
		menu = (Button) findViewById(R.id.menu);
		back.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				Intent intent = new Intent();
				intent.setClass(getContext(), MainActivity.class);
				getContext().startActivity(intent);
				((Activity) getContext()).finish();
			}
		});
		
	}

}
