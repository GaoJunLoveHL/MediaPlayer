package com.gaojun.MediaPlayer;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class MyAdapter extends BaseAdapter {
	private List<Music> list = new ArrayList<Music>();
	private Context context;
	
	public MyAdapter(Context context,List<Music> list) {
		this.context = context;
		this.list = list;
	}
	
	@Override
	public int getCount() {
		return list.size();
	}

	@Override
	public Object getItem(int arg0) {
		return list.get(arg0);
	}

	@Override
	public long getItemId(int arg0) {
		return arg0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder holder = null;
		if(convertView == null){
			holder = new ViewHolder();
			convertView = LayoutInflater.from(context).inflate(R.layout.song_list, null);
			holder.name = (TextView) convertView.findViewById(R.id.name);
			holder.path = (TextView) convertView.findViewById(R.id.path);
			convertView.setTag(holder);
		}else{
			holder = (ViewHolder) convertView.getTag();
		}
		holder.name.setText(list.get(position).getName());
		holder.path.setText(list.get(position).getPath());
		return convertView;
	}
	
	private class ViewHolder{
		private TextView name;
		private TextView path;
	}
}
