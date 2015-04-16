package com.lijun.android_json.http;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;



public class HttpUtils {

	public HttpUtils() {
		// TODO Auto-generated constructor stub
	}
	
	public static String getJsonString(String url_path){
		try {
			URL url = new URL(url_path);
			try {
				HttpURLConnection connection = (HttpURLConnection) url.openConnection();
				connection.setReadTimeout(3000);
				connection.setRequestMethod("GET");
				connection.setDoInput(true);
				
				int  responsecode = connection.getResponseCode();
				if (responsecode == 200) {
					return  changeInputStream(connection.getInputStream());
					
				}
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}

	private static String changeInputStream(InputStream inputStream) {
		// TODO Auto-generated method stub
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		String jsonString="";
		int len = -1;
		byte[] data = new byte[1024];
		try {
			while ((len = inputStream.read(data)) != -1) {
				outputStream.write(data, 0, len);
			}
			jsonString =new  String(outputStream.toByteArray());
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return jsonString;
	}

}
