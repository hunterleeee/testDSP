package com.clone.advs;

import java.util.HashMap;
import java.util.Map;

import com.Interface.baseHttpClient;

public class interfaceDemo {
	private static String test_Ad3Exchange ="http://l-test9.dev.cn2.corp.agrant.cn:8080/AdxRS/Ad3Exchange ";
	private static String Ad3Exchange ="http://l-adxwsng.prod.cn2.corp.agrant.cn:39519/AdxRS/Ad3Exchange ";
	
	private static String  test_Ad3ExtSettingExchange ="http://l-test9.dev.cn2.corp.agrant.cn:8080/AdxRS/Ad3ExtSettingExchange ";
	private static String  Ad3ExtSettingExchange ="http://l-adxwsng.prod.cn2.corp.agrant.cn:39519/AdxRS/Ad3ExtSettingExchange ";

	private static String  test_PlanExchange="http://l-test9.dev.cn2.corp.agrant.cn:8080/AdxRS/PlanExchange";
	private static String  PlanExchange="http://l-adxwsng.prod.cn2.corp.agrant.cn:39519/AdxRS/PlanExchange";

	private static  String test_PlanExtSettingExchange="http://l-test9.dev.cn2.corp.agrant.cn:8080/AdxRS/PlanExtSettingExchange";
	private static  String PlanExtSettingExchange="http://l-adxwsng.prod.cn2.corp.agrant.cn:39519//AdxRS/PlanExtSettingExchange";

	
	public void customInterface(Map<String,String> header,String url,String params){
		baseHttpClient bhc =new baseHttpClient();
		StringBuffer res = bhc.doPost(url, header, params);
//		System.out.println("header: "+header.toString()+"\nURL :"+url+"\nparm : "+params.toString());
		System.out.println(res);
	}
	
	
	public void Ad3Exchange(String url,String params){
		Map< String, String> headers=new HashMap< String, String>();
		headers.put("Content-Type", "application/json");
		headers.put("adx", "agrantsem659");
		this.customInterface(headers, url, params);
	}
	public void Ad3ExtSettingExchange(String url,String params){
		Map< String, String> headers=new HashMap< String, String>();
		headers.put("Content-Type", "application/json");
		headers.put("token", "AdxSynchronizerSmart:haoduomeinv");
		this.customInterface(headers, url, params);
	}
	public void PlanExchange(String url,String params){
		Map< String, String> headers=new HashMap< String, String>();
		headers.put("Content-Type", "application/json");
		headers.put("adx", "agrantsem659");
		this.customInterface(headers, url, params);
	}
	public void PlanExtSettingExchange(String url,String params){
		Map< String, String> headers=new HashMap< String, String>();
		headers.put("Content-Type", "application/json;charset=UTF-8");
		headers.put("adx", "agrantsem659");
		this.customInterface(headers, url, params);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		interfaceDemo ifd= new interfaceDemo();
		String params_Ad3Exchange="{\"channel\":\"GDT\"}";   //BAIDU,TANX,ADX,JTX,AGX,SOHU?
//		ifd.Ad3Exchange(test_Ad3Exchange, params_Ad3Exchange); 
//		ifd.Ad3Exchange(Ad3Exchange, params_Ad3Exchange); 		
		
		
		String params_Ad3ExtSettingExchange="{\"channel\":\"11\"}";
		//ADX:0;BAIDU:1;SAX:2;TANX:3,TADE:4,CTX:5,AGX=6,ZDM=7;ZDD=8;QAX=9,AMAX=10;GDT=11;YOUKU=12;BAICHUAN=14;WAX=15;JTX=16;SOHU=17;ADVIEW=18;XTX=19
//		ifd.Ad3ExtSettingExchange(test_Ad3ExtSettingExchange, params_Ad3ExtSettingExchange);
		ifd.Ad3ExtSettingExchange(Ad3ExtSettingExchange, params_Ad3ExtSettingExchange);
		
		
		String params_PlanExchange="{\"channel\":\"BAIDU\"}";  //BAIDU,TANX,ADX,JTX,AGX,
//		ifd.PlanExchange(test_PlanExchange, params_PlanExchange);  //乱码.....
		
		String params_PlanExtSettingExchange="{\"channel\":\"BAIDU\"}";  //BAIDU,TANX,ADX,JTX,AGX,
//		ifd.PlanExtSettingExchange(test_PlanExtSettingExchange, params_PlanExtSettingExchange); //乱码.....
		





		
	}

}
