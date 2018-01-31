package com.realtime.advertising;

import java.util.HashMap;
import java.util.Map;

import com.Interface.baseHttpClient;

public class advertisingDemo {
	private  String urlPost="http://adxwsng1.prod.cn2.corp.agrant.cn:39519/AdxRS/AdPreview";
//	private  String urlPost="http://test9.dev.cn2.corp.agrant.cn:25640/AdxRS/AdPreview";

	public void test_728_90(String mid,int width,int height){
		Map< String, String> headers=new HashMap< String, String>();
		headers.put("Content-Type", "application/json");
		String params =null;
		params=String.format("{\"ip\":\"219.143.185.195\","+
				"\"mid\":\"%s\","+
				"\"width\":\"%d\","+
				"\"height\":\"%d\"}"
				, mid,width,height);

		baseHttpClient bhc =new baseHttpClient();
		StringBuffer res = bhc.doPost(urlPost, headers, params);
		System.out.println("header: "+headers.toString()+"\nURL :"+urlPost+"\nparm : "+params.toString());
		System.out.println(res);
	}
	public void testAdvertising(String mid,int width,int height){
		Map< String, String> headers=new HashMap< String, String>();
		headers.put("Content-Type", "application/json");
		String params =null;
		params=String.format("{\"ip\":\"219.143.185.195\","+
				"\"mid\":\"%s\","+
				"\"width\":\"%d\","+
				"\"height\":\"%d\"}"
				, mid,width,height);

		baseHttpClient bhc =new baseHttpClient();
		StringBuffer res = bhc.doPost(urlPost, headers, params);
		System.out.println("header: "+headers.toString()+"\nURL :"+urlPost+"\nparm : "+params.toString());
		System.out.println(res);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		advertisingDemo ad =new advertisingDemo();
		 //打开的url仅显示广告不显示网站其他内容；刷出几率低
//		ad.test_728_90("17514_c58b58a2b3d66160",728,90);
//		ad.test_728_90("2616_36ae6068830b8dd5",728,90); 
		ad.test_728_90("17514_d874563f8214bcee",728,90); 
//		ad.test_728_90("17048_c91f50d736967632",728,90); 
//		ad.test_728_90("14696_28cb198fb18cbbc6",728,90); 
//		ad.test_728_90("17384_4a0fe673ced31607",728,90); 
//		ad.test_728_90("3726_b8467c0e1e04d7ab",728,90); 
//		ad.test_728_90("2299_859a39d9df4cdbd3",728,90); 
		
//		ad.testAdvertising("15172_b2f8ce41b11d6963",950,90); //投放后尺寸变小
//		ad.testAdvertising("17514_3d54ec1a442390eb",950,90); //不显示图片
//		ad.testAdvertising("2616_e17c134461d4c3a3",950,90); //显示一半
		
		
//		ad.testAdvertising("2616_19108159b6877a36",160,600); 
//		ad.testAdvertising("3726_48b2edb4b1564cbc",160,600); 
//		ad.testAdvertising("17384_7b5a0a05344a54a7",160,600); 
//		ad.testAdvertising("13047_2b08d529cf6b5fb3",160,600); 
//		ad.testAdvertising("15172_dcd943e19c2699ab",160,600); 
//		ad.testAdvertising("2299_b4a	ce1f4fa8d71d9",160,600); 

		
//		ad.testAdvertising("2616_d3317f23e2b22a21",120,600); //投放不出去
//		ad.testAdvertising("3726_78206b44265e26ff",120,600); //投放不出去
//		ad.testAdvertising("17384_253e99bc49ae910d",120,600);  //投放不出去
//		ad.testAdvertising("15172_8c9edb0af41b6820",120,600);  //投放不出去
		
	
//Test环境
//		ad.testAdvertising("10542_0bef7ec77e3bfd87",300,250); 
	}

}
