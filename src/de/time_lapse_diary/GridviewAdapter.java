package de.time_lapse_diary;

import java.util.ArrayList;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class GridviewAdapter extends BaseAdapter {
	private ArrayList<String> names;
	private ArrayList<Integer> id;
	private Activity activity;

	public GridviewAdapter(Activity activity, ArrayList<String> listName,
			ArrayList<Integer> listID) {
		super();
		this.names = listName;
		this.id = listID;
		this.activity = activity;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return names.size();
	}

	@Override
	public String getItem(int position) {
		// TODO Auto-generated method stub
		return names.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return 0;
	}

	public static class ViewHolder {
		public ImageView imgViewThumbnail;
		public TextView txtViewTitle;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		ViewHolder view;
		LayoutInflater inflator = activity.getLayoutInflater();

		if (convertView == null) {
			view = new ViewHolder();
			convertView = inflator.inflate(R.layout.gridview_row, null);

			view.txtViewTitle = (TextView) convertView
					.findViewById(R.id.textView1);
			view.imgViewThumbnail = (ImageView) convertView
					.findViewById(R.id.imageView1);

			convertView.setTag(view);
		} else {
			view = (ViewHolder) convertView.getTag();
		}

		view.txtViewTitle.setText(names.get(position));
		view.imgViewThumbnail.setImageResource(id.get(position));

		return convertView;
	}
}
