package com.test.Audit;

import java.util.HashMap;
import java.util.Map;

import com.Interface.baseHttpClient;

public class DSPauditCenter {
	
//	private static String urlAuToAuditingAdvertiser = "http://l-ws23.dev.cn2.corp.agrant.cn:9527/AdxAuditRS/WebUpdateServlet?method=insertOrUpdateAdxCertAndKV";
//	private String urlAuditingAdvertisement ="http://l-ws23.dev.cn2.corp.agrant.cn:9527/AdxAuditRS/WebUpdateServlet?method=insertOrUpdateAd3AndKV";
	private static String test_urlAuToAuditingAdvertiser2 = "http://l-test9.dev.cn2.corp.agrant.cn:8080/AdxAuditRS/ForAutoAuditServlet?method=updateCustomerStatus&channelName=BAIDU";
	private static String test_urlAuditingAdvertisement2="http://l-test9.dev.cn2.corp.agrant.cn:8080/AdxAuditRS/ForAutoAuditServlet?method=updateCreativeStatus&channelName=JTX";
	private static String test_urlAuditingAdvertisement3="http://l-test9.dev.cn2.corp.agrant.cn:8080/AdxAuditRS/WebUpdateServlet?method=updateAd3AndKvStatus";

	private static String urlAuToAuditingAdvertiser2 ="http://l-adxwsng.prod.cn2.corp.agrant.cn:39519/AdxAuditRS/ForAutoAuditServlet?method=updateCustomerStatus&channelName=JTX";
	private static String urlAuditingAdvertisement2="http://l-adxwsng.prod.cn2.corp.agrant.cn:39519/AdxAuditRS/ForAutoAuditServlet?method=updateCreativeStatus&channelName=JTX";

	private static Map<String, String> header =new HashMap<String, String>();
	public DSPauditCenter() {

		header.put("Content-Type", "application/json");
		header.put("token","web:doushishuaige");
//		header.put("token","AdxSynchronizerSmart:haoduomeinv");
	}

	public StringBuffer fastDoPost(String url,Map<String,String>headers,String params){
		baseHttpClient bhc = new baseHttpClient();
		StringBuffer res =bhc.doPost(url,header , params);
		System.out.println("header: "+header.toString()+"\nURL :"+url+"\nparm : "+params);
		System.out.println(res);
		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DSPauditCenter dc =new DSPauditCenter();


//		testAuditAdvertise
		String AdverParamds =
				"[{\"cid\":\"100411\","
				+ "\"BAIDU_CHANNELENABLE\":1,"
//				+ "\"YOUKU_ADVERTISER\":\"苏酒集团贸易股份有限公司\","
				+ "\"BAIDU_STATUS\":0"
				+ "}]";
		dc.fastDoPost(test_urlAuToAuditingAdvertiser2, header, AdverParamds);
//		dc.fastDoPost(urlAuToAuditingAdvertiser2, header, AdverParamds);
		
		//testAuditAdvertisement

 		
		String updateAd3AndKvStatusPamam1 =
				"["
				+ "{\"mid\":\"100372_fa949d4f8429758d\",\"TANX1_BIDENABLE\":\"1\",\"BAIDU_STATUS\":\"1\",\"BAIDU_REFUSEREASON\":\"reason123\",\"agauditstatus\":\"1\"},"
				+ "{\"mid\":\"100372_06385c8c4e9ed41b1\",\"BAIDU_CHANNELENABLE\":\"0\",\"BAIDU_STATUS\":\"-1\",\"BAIDU_REFUSEREASON\":\"reason123\"}"
				+ "]";
		String updateAd3AndKvStatusPamam2 =
				"{\"mid\":[\"100372_fa949d4f8429758d\",\"100372_06385c8c4e9ed41b1\"]"
				+ ",\"AGX_STATUS\":\"1\", \"AGX_BIDENABLE\":\"-1\",\"agauditstatus\":\"0\"}";

		String AdvertisementParamds = //不好用啊
	 			"[{\"mid\":\"100411_11ffcbcdc879f0ff\","
	 				+ "\"BAIDU_CHANNELENABLE\":\"1\","
//	 			+ "\"GDT_BIDENABLE\":\"1\","
//	 				+"\"ZCM_REFUSEREASON\":\"HZX拒绝测试\","
	 			+ "\"BAIDU_STATUS\":\"1\""
	 				+ "}]";
		dc.fastDoPost(test_urlAuditingAdvertisement2, header, AdvertisementParamds);
//		dc.fastDoPost(urlAuditingAdvertisement2, header, AdvertisementParamds);
	}
}
