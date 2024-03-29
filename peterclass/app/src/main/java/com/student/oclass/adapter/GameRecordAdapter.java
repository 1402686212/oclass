package com.student.oclass.adapter;

import java.util.List;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.student.oclass.R;
import com.student.oclass.adapter.SyncTechAdapter.ViewHolder;
import com.student.oclass.model.BookEntity;

public class GameRecordAdapter extends BaseAdapter {

	private List<BookEntity> listBook=null;
	private Context context;

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return listBook.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return listBook.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		ViewHolder holder=null;
		if(convertView==null) {
			holder=new ViewHolder();
			convertView=LayoutInflater.from(context).inflate(R.layout.game_record_item, null);
			holder.iv_tag=(ImageView) convertView.findViewById(R.id.iv_tag);
			holder.tv_name=(TextView) convertView.findViewById(R.id.tv_name);
			holder.tv_score=(TextView) convertView.findViewById(R.id.tv_score);
			convertView.setTag(holder);
		}else {
			holder=(ViewHolder) convertView.getTag();
		}
		BookEntity book=listBook.get(position);
		holder.tv_name.setText(book.getName());
		holder.tv_score.setText(book.getTitle());

		return convertView;
	}
	public GameRecordAdapter(Context context,List<BookEntity> listBook) {
		this.context=context;
		this.listBook=listBook;
	}

	class ViewHolder{
		ImageView iv_tag;
		TextView tv_name;
		TextView tv_score;
	}

}
