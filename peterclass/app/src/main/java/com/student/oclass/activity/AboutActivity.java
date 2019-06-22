package com.student.oclass.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.student.oclass.R;

/**
 * 修改一些代码加入了历史版本查看的功能
 * @author huangyebiaoke
 * @email huangyebiaoke@outlook.com
 */
public class AboutActivity extends BaseActivity implements OnClickListener{
	TextView verison;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_about_us);
		initView();
		iv_title.setImageResource(R.drawable.about_msg_pressed);
		tv_title.setText(getResources().getString(R.string.about_us));
	}
	private void initView(){
		iv_title=(ImageView)this.findViewById(R.id.iv_title);
		tv_title=(TextView)this.findViewById(R.id.tv_title);
		btn_back=(Button)this.findViewById(R.id.btn_back);
		verison=findViewById(R.id.tv_version_information);
		verison.setOnClickListener(this);
		btn_back.setOnClickListener(this);
	}
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch(v.getId()) {
			case R.id.btn_back:
				finish();
				break;
			case R.id.tv_version_information:
				Intent intent=new Intent(AboutActivity.this,VersionActivity.class);
				startActivity(intent);
		}
	}
}
