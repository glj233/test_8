package com.lijun.android_json;

import com.lijun.android_json.http.HttpUtils;


import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity implements OnClickListener {
	private  Button person,listperson,liststring,listmap;
	private TextView text;
	private String jsonString="";

	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		text = (TextView) findViewById(R.id.text1);
		person = (Button) findViewById(R.id.person);
		listperson = (Button) findViewById(R.id.listperson);
		liststring = (Button) findViewById(R.id.liststring);
		listmap = (Button) findViewById(R.id.listmap);
		person.setOnClickListener(this);
		listperson.setOnClickListener(this);
		liststring.setOnClickListener(this);
		listmap.setOnClickListener(this);
		
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.person:
			new Thread(new Runnable() {
				@Override
				public void run() {
					// TODO Auto-generated method stub
					String path = "http://192.168.1.110:8080/JsonProject/JsonAction?action_flag=person";
					jsonString = HttpUtils.getJsonString(path);
					Message msg = new Message();
					Bundle bundle = new Bundle();
					bundle.putString("jsonstring", jsonString);
					msg.setData(bundle);
					handler3.sendMessage(msg);
					}
			}).start();
			break;
		case R.id.listperson:
			new Thread(new Runnable() {
				@Override
				public void run() {
					// TODO Auto-generated method stub
					String path = "http://192.168.1.110:8080/JsonProject/JsonAction?action_flag=listperson";
					jsonString = HttpUtils.getJsonString(path);
					Message msg = new Message();
					Bundle bundle = new Bundle();
					bundle.putString("jsonstring", jsonString);
					msg.setData(bundle);
					handler3.sendMessage(msg);
					}
			}).start();
			break;
		case R.id.liststring:
			new Thread(new Runnable() {
				@Override
				public void run() {
					// TODO Auto-generated method stub
					String path = "http://192.168.1.110:8080/JsonProject/JsonAction?action_flag=liststring";
					jsonString = HttpUtils.getJsonString(path);
					Message msg = new Message();
					Bundle bundle = new Bundle();
					bundle.putString("jsonstring", jsonString);
					msg.setData(bundle);
					handler3.sendMessage(msg);
					}
			}).start();
			
			break;
		case R.id.listmap:
			new Thread(new Runnable() {
				@Override
				public void run() {
					// TODO Auto-generated method stub
					String path = "http://192.168.1.110:8080/JsonProject/JsonAction?action_flag=listmap";
					jsonString = HttpUtils.getJsonString(path);
					Message msg = new Message();
					Bundle bundle = new Bundle();
					bundle.putString("jsonstring", jsonString);
				
					msg.setData(bundle);
					handler3.sendMessage(msg);
					}
			}).start();
			break;

		default:
			break;
		}
	}
	
	 Handler handler3 = new Handler(){
				public void handleMessage(Message msg) {
					String  budd = msg.getData().getString("jsonstring");
					text.setText(budd);
				};
	};
	
}
