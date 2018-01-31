package com.clone.AddOrUpdate;

import java.util.HashMap;
import java.util.Map;

import com.Interface.baseHttpClient;

public class addUpdateCloneAdvs {

	private static String test_AddandUpdateAd3URL ="http://l-test9.dev.cn2.corp.agrant.cn:8080/AdxAuditRS/ForCloneAd3Servlet?method=insertOrUpdateCloneAd";
	private static String AddandUpdateAd3URL ="http://l-adxwsng1.prod.cn2.corp.agrant.cn:39519/AdxAuditRS/ForCloneAd3Servlet?method=insertOrUpdateCloneAd";

	private static String test_ModifyAd3URL="http://l-test9.dev.cn2.corp.agrant.cn:8080/AdxAuditRS/WebUpdateServlet?method=insertOrUpdateAd3AndKV";
	private static String ModifyAd3URL="http://l-adxwsng.prod.cn2.corp.agrant.cn:39519/AdxAuditRS/WebUpdateServlet?method=insertOrUpdateAd3AndKV";;

	
	public void customInterface(Map<String,String> header,String url,String params){
		baseHttpClient bhc =new baseHttpClient();
		StringBuffer res = bhc.doPost(url, header, params);
		System.out.println("header: "+header.toString()+"\nURL :"+url+"\nparm : "+params.toString());
		System.out.println(res);
	}
	 /**
	  * 新建克隆广告
	  * @param url
	  * @param params
	  */
	public void AddCloneAd3(String url,String params){
		Map< String, String> headers=new HashMap< String, String>();
		headers.put("Content-Type", "application/json");
		headers.put("token", "web:doushishuaige");  //测试token
//		headers.put("token", "AdxSynchronizerSmart:haoduomeinv");      //线上token

		this.customInterface(headers, url, params);
	}
	
	/**
	 * 使用旧接口修改，只穿单一参数
	 * @param url
	 * @param params
	 */
	public void modifyCloneAd3(String url,String params){
		Map< String, String> headers=new HashMap< String, String>();
		headers.put("Content-Type", "application/json");
		headers.put("token", "web:doushishuaige");
		this.customInterface(headers, url, params);
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		addUpdateCloneAdvs aca=new addUpdateCloneAdvs();
		
		String test_addCloneParams="[{\"mid\":\"13485_73df7a3f856b50a5\",\"n_mid\":\"13485_7b95ce07f9c6f9ee\",\"name\":\"克隆接口测试1\",\"price\":\"3000000\",\"plan_id\":\"13485_f6d1f83d68baa223\",\"clickurl\":\"http://ad.agrantsem.com/AdServer/Tt?cus=13039&eid=1&src=ADX&reqid={requestid}&p=13485-1-493f18a8bd9d710982590b56c18fdc70&d=http%3a%2f%2fwww.zcdog.com%2f%3fag_mid%3d13485-1-493f18a8bd9d710982590b56c18fdc70\"}]";
//		String addCloneParams="[{\"mid\":\"13039_e1d921d37f52f59a\",\"n_mid\":\"13039_e1d921d37f52f58b\",\"name\":\"320x250克隆\",\"price\":\"2500000\",\"plan_id\":\"13039_c80ed3cbc6be12b4\",\"clickurl\":\"http://ad.agrantsem.com/AdServer/Tt?cus=13039&eid=1&src=ADX&reqid={requestid}&p=13039-1-c8417d7b6177219562245f0484306933&d=http%3a%2f%2fwww.zcdog.com%2f%3fag_mid%3d13039-1-c8417d7b6177219562245f0484306933\"}]";
//		aca.AddCloneAd3(AddandUpdateAd3URL,test_addCloneParams);
		
		
		String test_modifyCloneParams="[{\"mid\":\"13485_7b95ce07f9c6f9ee\",\"pause\":\"0\"}]";
//		String modifyCloneParams="[{\"mid\":\"13485_7b95ce07f9c6f9ee\",\"pause\":\"0\"}]";
//		aca.modifyCloneAd3(ModifyAd3URL,test_modifyCloneParams);

		//创建普通广告
		String test_AddParams="[{\"name\":\"创建素材接口测试12\",\"mid\":\"14397_7b95ce07f9c6f9e1\",\"cid\":\"14397\",\"pause\":\"-1\",\"planid\":\"14397_63dbc88af19b177d\",\"src2\":\"14397_4bfbc469c279a6b3\",\"width\":\"580\",\"height\":\"90\",\"tid\":\"14397-1-62a8d61d10fbb17d0c5e032fac06ef00\",\"filecheck\":\"-1\",\"BAIDU_STATUS\":\"-1\"},{\"name\":\"创建素材接口测试22\",\"mid\":\"14397_7b95ce07f9c6f911\",\"cid\":\"14397\",\"pause\":\"-1\",\"planid\":\"14397_63dbc88af19b177d\",\"src2\":\"14397_4bfbc469c279a6b3\",\"width\":\"640\",\"height\":\"270\",\"tid\":\"14397-1-62a8d61d10fbb17d0c5e032fac066f00\",\"filecheck\":\"a\",\"GDT_STATUS\":\"-1\"}]";
		aca.modifyCloneAd3(ModifyAd3URL,test_AddParams); // 测试url  test_ModifyAd3URL，线上url  ModifyAd3URL
	}

}
