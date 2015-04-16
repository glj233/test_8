package com.json.test;


import com.json.service.JsonService;
import com.json.tools.JsonTools;

public class JsonTest {

	public JsonTest() {
		// TODO Auto-generated constructor stub
	}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String  msg = "";
		JsonService service = new JsonService();
	/*	Person person = service.getPerson();
		msg = JsonTools.createJsonString("person", person);
		System.out.println(msg);*/
	
		/*msg = JsonTools.createJsonString("listperson", service.getListPerson());
		System.out.println(msg);*/
		
		/*msg = JsonTools.createJsonString("list", service.getListString());
		System.out.println(msg);*/
		
		msg = JsonTools.createJsonString("listmap", service.getListMap());
		System.out.println(msg);
	}

}
