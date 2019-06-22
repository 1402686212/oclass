package com.student.oclass.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.student.oclass.R;
import com.student.oclass.model.BookEntity;

import java.util.List;

public class CourseListAdapter extends BaseAdapter {
    /*
        作者: 16本计算机3班 tileron.Xu
        描述: 学习资源的课件列表适配器
    */
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

    //获取name
    public String getName(int position) {
        // TODO Auto-generated method stub
        return listBook.get(position).getName();
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        CourseListAdapter.ViewHolder holder=null;
        if(convertView==null) {
            holder=new CourseListAdapter.ViewHolder();
            convertView= LayoutInflater.from(context).inflate(R.layout.course_list_item, null);
            holder.iv_tag=(ImageView) convertView.findViewById(R.id.iv_tag);
            holder.tv_name=(TextView) convertView.findViewById(R.id.tv_name);
            convertView.setTag(holder);
        }else {
            holder=(CourseListAdapter.ViewHolder) convertView.getTag();
        }
        BookEntity book=listBook.get(position);
        holder.tv_name.setText(book.getName());
        return convertView;
    }
    public CourseListAdapter(Context context,List<BookEntity> listBook) {
        this.context=context;
        this.listBook=listBook;
    }
    class ViewHolder{
        ImageView iv_tag;
        TextView tv_name;
    }
}


