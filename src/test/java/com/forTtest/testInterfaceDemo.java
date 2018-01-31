package com.forTtest;

import java.util.HashMap;
import java.util.Map;

import com.Interface.baseHttpClient;

public class testInterfaceDemo {

	
	
	public static void main(String[] args) {
		String url="http://l-ws23.dev.cn2.corp.agrant.cn:8021/Ad/GetVideoConvertStatus";
		Map<String,String> headers =new HashMap<String, String>();
		String params ="{\"mid\":\"100372_e788ad9270aadc8b\"}";
		
		baseHttpClient bhc =new baseHttpClient();
		StringBuffer res =bhc.doPost(url, headers, params);
		System.out.println(res);
	}

}
