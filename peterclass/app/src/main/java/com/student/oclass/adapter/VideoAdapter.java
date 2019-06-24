package com.student.oclass.adapter;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.student.oclass.R;
import com.student.oclass.model.BookEntity;
import com.student.oclass.utils.AppConstant;
/*
    作者：16本计算机3班张荣彬
    描述：生成在线视频列表数据
*/

public class VideoAdapter extends BaseAdapter {

    private List<BookEntity> listBook = null;

    private Context context;

    private boolean isFamousBook = false;

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

    //获取title
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
    public View getView(int position, View contentView, ViewGroup arg2) {
        // TODO Auto-generated method stub
        ViewHolder holder = null;
        if (contentView == null) {
            holder = new ViewHolder();
            if (isFamousBook) {
                contentView = LayoutInflater.from(context).inflate(R.layout.view_famous_book_item, null);
            } else {
                contentView = LayoutInflater.from(context).inflate(R.layout.sync_tech_item, null);
            }
            holder.iv_book = (ImageView) contentView.findViewById(R.id.iv_book);
            holder.layout_bg = (RelativeLayout) contentView.findViewById(R.id.layout_book);
            holder.tv_name = (TextView) contentView.findViewById(R.id.tv_name);
            contentView.setTag(holder);
        } else {
            holder = (ViewHolder) contentView.getTag();
        }
        BookEntity book = listBook.get(position);
        if (position == 0) {
            if (book.getType() == AppConstant.FAMOUS_BOOK) {
                holder.iv_book.setImageResource(R.drawable.video_1);
                holder.tv_name.setText("Hello World!");
            } else if (book.getType() == AppConstant.EXAM) {
                holder.layout_bg.setBackgroundResource(R.drawable.exam_book_bg);
                holder.tv_name.setText("新课标\n语文\n三年级\n下");
                book.setName("新课标\n语文\n三年级\n下");
            } else {
                holder.iv_book.setImageResource(R.drawable.english_default);
                holder.tv_name.setText("Android程序\n课件列表");
            }
        } else if(position == 1){
            if (book.getType() == AppConstant.FAMOUS_BOOK) {
                holder.iv_book.setImageResource(R.drawable.video_2);
                holder.tv_name.setText("我是练习生CXK");
            }
        }
        else if(position == 2){
            if (book.getType() == AppConstant.FAMOUS_BOOK) {
                holder.iv_book.setImageResource(R.drawable.video_3);
                holder.tv_name.setText("组件与插件化");
            }
        }
        else if(position == 3){
            if (book.getType() == AppConstant.FAMOUS_BOOK) {
                holder.iv_book.setImageResource(R.drawable.video_4);
                holder.tv_name.setText("第一个安卓应用");
            }
        }
        else if(position == 4){
            if (book.getType() == AppConstant.FAMOUS_BOOK) {
                holder.iv_book.setImageResource(R.drawable.video_5);
                holder.tv_name.setText("多线程开发");
            }
        }
        else {
            if (book.getType() == AppConstant.FAMOUS_BOOK) {
                holder.iv_book.setImageResource(R.drawable.video_6);
                holder.tv_name.setText("Android简介");
            } else if (book.getType() == AppConstant.EXAM) {
                holder.layout_bg.setBackgroundResource(R.drawable.exam_book_bg);
                holder.tv_name.setText("新课标\n语文\n三年级\n下");
                book.setName("新课标\n语文\n三年级\n下");
            } else {
                holder.iv_book.setImageResource(R.drawable.book_default);
                holder.tv_name.setText("新课标\n语文\n三年级\n下");
                book.setName("新课标\n语文\n三年级\n下");
            }
        }
        return contentView;
    }

    public VideoAdapter(Context context, List<BookEntity> listBook, boolean isFamousBook) {
        this.context = context;
        this.listBook = listBook;
        this.isFamousBook = isFamousBook;
    }

    class ViewHolder {
        ImageView iv_book;

        TextView tv_name;

        RelativeLayout layout_bg;
    }
}
