package com.AgWeb.Jurisdiction;

import java.util.HashMap;
import java.util.Map;

import com.Interface.baseHttpClient;

public class JurisdictionManage {
	static String GetAllPowerIDUrl="http://l-ws23.dev.cn2.corp.agrant.cn:8021/PowerRule/GetAllPowerID";
	static String GetPowerRuleUrl="http://l-ws23.dev.cn2.corp.agrant.cn:8021/PowerRule/GetPowerRule";
	static Map< String, String> headers=new HashMap< String, String>();
	static {
	headers.put("Content-Type", "application/json"); 
	}
	public void customInterface(Map<String,String> header,String url,String params){
		baseHttpClient bhc =new baseHttpClient();
		StringBuffer res = bhc.doPost(url, header, params);
		System.out.println("header: "+header.toString()+"\nURL :"+url+"\nparm : "+params.toString());
		System.out.println(res);
	}
	public void GetAllPowerID(String url,String params){
		JurisdictionManage jm=new JurisdictionManage();
		jm.customInterface(headers,GetAllPowerIDUrl,params);
	}
	public void GetPowerRule (String url,String params){
		JurisdictionManage jm=new JurisdictionManage();
		jm.customInterface(headers,GetPowerRuleUrl,params);
	}
	
	public static void main(String[] args) {
		JurisdictionManage jm =new JurisdictionManage();
		String params_GetPowerRuleUrl="{\"cid\":2616,\"isagrant\":1,\"roleid\":3,\"sysid\":1}";
		jm.GetPowerRule(GetPowerRuleUrl,params_GetPowerRuleUrl);

		String params_GetAllPowerIDUrl="{}";
//		jm.GSELECT * from Adx.AdxSysPowerKVSetting WHERE powerid like '%adxsyspower_lisence%';etAllPowerID(GetAllPowerIDUrl,params_GetAllPowerIDUrl);
	}

}
