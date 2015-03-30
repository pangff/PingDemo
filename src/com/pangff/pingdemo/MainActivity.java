package com.pangff.pingdemo;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends Activity {

	TextView textView ;
	Handler handler = new Handler(){
		public void handleMessage(Message msg) {
			textView.setText(String.valueOf(msg.obj));
			msg.recycle();
		};
	};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		textView = (TextView) findViewById(R.id.contentView);
	}

	public void doPing(View view){
		new Thread(){
			public void run() {
				String data = PingUtil.ping("www.baidu.com");
				Message message = Message.obtain();
				message.what = 0;
				message.obj = data;
				handler.sendMessage(message);
			};
		}.start();
	}
	
	@Override
	protected void onDestroy() {
		super.onDestroy();
		handler.removeMessages(0);
	}
}
