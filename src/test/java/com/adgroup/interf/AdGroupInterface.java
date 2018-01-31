package com.adgroup.interf;

import java.util.HashMap;
import java.util.Map;

import com.Interface.baseHttpClient;

public class AdGroupInterface {
	private static String test_insertAdGroupKVSetting = "http://l-test9.dev.cn2.corp.agrant.cn:8080/AdxAuditRS/ForAdGroupSevlet?method=InsertAdGroupKVSetting";
	private static String test_updateAdGroupKVSetting="http://l-test9.dev.cn2.corp.agrant.cn:8080/AdxAuditRS/ForAdGroupSevlet?method=UpdateAdGroupKVSetting";
	private static String test_deletAdGroupKVSetting ="http://l-test9.dev.cn2.corp.agrant.cn:8080/AdxAuditRS/ForAdGroupSevlet?method=DeleteAdGroupKV";

	private static String insertAdGroupKVSetting = "http://l-adxwsng.prod.cn2.corp.agrant.cn:39519/AdxAuditRS/ForAdGroupSevlet?method=InsertAdGroupKVSetting";
	private static String updateAdGroupKVSetting="http://l-adxwsng.prod.cn2.corp.agrant.cn:39519/AdxAuditRS/ForAdGroupSevlet?method=UpdateAdGroupKVSetting";
	private static String deletAdGroupKVSetting ="http://l-adxwsng.prod.cn2.corp.agrant.cn:39519/AdxAuditRS/ForAdGroupSevlet?method=DeleteAdGroupKV";

	private static Map<String, String> header =new HashMap<String, String>();
	public AdGroupInterface() {
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
		AdGroupInterface adtest =new AdGroupInterface();
		
		//新建
		String test_insertAdGroupKVSettingParams = "[{\"cid\":\"13485\",\"planid\":\"13485_0fdedbcac10b4e85\",\"adgroupid\":\"13485_ee6263b72fd1c6e7\",\"EX_VERTICAL_0\":\"0\",\"fid\":\"17\",\"allow\":\"1\",\"optype\":\"0\",\"enable\":\"1\",\"des2\":\"默认组\",\"pause\":\"0\",\"grouptype\":\"101\"},{\"cid\":\"13485\",\"planid\":\"13485_0fdedbcac10b4e85\",\"adgroupid\":\"13485_ee6263b72fd1c6e7\",\"EX_VERTICAL_1\":\"0\",\"fid\":\"17\",\"allow\":\"1\",\"optype\":\"0\",\"enable\":\"1\",\"des2\":\"默认组\",\"pause\":\"0\",\"grouptype\":\"101\"}]";
		String insertAdGroupKVSettingParams = "[{\"cid\":\"14397\",\"planid\":\"14397_083f3c79a245064d\",\"adgroupid\":\"14397_09f18c1636fa1dc1\",\"DEVICE_TYPE\":\"D\",\"fid\":\"19\",\"allow\":\"1\",\"optype\":\"0\",\"enable\":\"1\",\"des2\":\"默认组\",\"pause\":\"0\",\"grouptype\":\"101\"},{\"cid\":\"14397\",\"planid\":\"14397_083f3c79a245064d\",\"adgroupid\":\"14397_09f18c1636fa1dc1\",\"DEVICE_TYPE\":\"P\",\"fid\":\"19\",\"allow\":\"1\",\"optype\":\"0\",\"enable\":\"1\",\"des2\":\"默认组\",\"pause\":\"0\",\"grouptype\":\"101\"}]";
//		adtest.fastDoPost(insertAdGroupKVSetting, header, insertAdGroupKVSettingParams);
		
		//修改 value
		String test_updateAdGroupKVSettingParams = "[{\"cid\":\"13485\",\"planid\":\"13485_0fdedbcac10b4e85\",\"adgroupid\":\"13485_ee6263b72fd1c6e7\",\"fid\":\"17\",\"EX_VERTICAL_0\":\"1\",\"allow\":\"1\",\"optype\":\"0\",\"enable\":\"1\"},{\"cid\":\"13485\",\"planid\":\"13485_0fdedbcac10b4e85\",\"adgroupid\":\"13485_ee6263b72fd1c6e7\",\"fid\":\"17\",\"EX_VERTICAL_1\":\"1\",\"allow\":\"1\",\"optype\":\"0\",\"enable\":\"1\"}]";
		String updateAdGroupKVSettingParams = "[{\"cid\":\"14397\",\"planid\":\"14397_083f3c79a245064d\",\"adgroupid\":\"14397_09f18c1636fa1dc1\",\"fid\":\"19\",\"DEVICE_TYPE\":\"T\",\"allow\":\"1\",\"optype\":\"0\",\"enable\":\"1\"}]";
//		adtest.fastDoPost(updateAdGroupKVSetting, header, updateAdGroupKVSettingParams);
		
		/**删除 
		 * 1. DeleteAdGroupKVSettingByFilterAndNameAndValue
[   {"cid":"2299","planid":"2299_015f5759e7222d20","adgroupid":"2299_07047985975ccbb2","name":"WEBSITE","values":["www.baidu.com","www.ang.com"],"fid":"3","allow":"0","optype":"0", "method":"DeleteAdGroupKVSettingByFilterAndNameAndValue" }]


2. DeleteAdGroupKVSettingByFilterAndName
[   {"cid":"2299","planid":"2299_015f5759e7222d20","adgroupid":"2299_07047985975ccbb2","name":"WEBSITE","fid":"3","method":"DeleteAdGroupKVSettingByFilterAndName" }]
DELETE FROM Adx.AdGroupKVSetting WHERE 1=1  and cid='2299' and planid='2299_015f5759e7222d20' and fid='3' and name ='WEBSITE' and optype =0 and adgroupid ='2299_07047985975ccbb2'


3.DeleteWebsiteSetting
[   {"cid":"2299","planid":"2299_015f5759e7222d20","adgroupid":"2299_07047985975ccbb2","name":"DAILY_LIMIT","fid":"23","allow":"1","method":"DeleteWebsiteSetting" }]
DELETE FROM Adx.AdGroupKVSetting WHERE 1=1  and cid='2299' and planid='2299_015f5759e7222d20' and fid='23' and name ='DAILY_LIMIT' and optype =0 and adgroupid ='2299_07047985975ccbb2' and allow ='1' and value!='www.anonymouswebsite.com'

4.DeleteAnonymousWebsiteSetting
[   {"cid":"2299","planid":"2299_24c2588d31a19749","adgroupid":"2299_07047985975ccbb2","name":"WEBSITE_DESKTOP","value","BLOCK","fid":"24","allow":"0","method":"DeleteAnonymousWebsiteSetting" }]
DELETE FROM Adx.AdGroupKVSetting WHERE 1=1  and cid='2299' and planid='2299_24c2588d31a19749' and fid='24' and name ='WEBSITE_DESKTOP' and optype =0 and adgroupid ='2299_07047985975ccbb2' and value = 'BLOCK'

5.DeleteAdGroupKVSettingByFilter
[   {"cid":"2299","planid":"2299_24c2588d31a19749","adgroupid":"2299_07047985975ccbb2","fids":["24","-9"],"allow":"0","method":"DeleteAdGroupKVSettingByFilter" }]
DELETE FROM Adx.AdGroupKVSetting WHERE 1=1  and cid='2299' and planid='2299_24c2588d31a19749' and fid in ('24','-9') and optype =0 and adgroupid ='2299_07047985975ccbb2'

6.DeleteAdGroupKVSettingByFilterNameAndAllow
[   {"cid":"2299","planid":"2299_24c2588d31a19749","adgroupid":"2299_07047985975ccbb2","fid":"15","name":"TANX_CHANNELENRATE","allow":"0","method":"DeleteAdGroupKVSettingByFilterNameAndAllow" }]
DELETE FROM Adx.AdGroupKVSetting WHERE 1=1  and cid='2299' and planid='2299_24c2588d31a19749' and fid = '15' and name ='TANX_CHANNELENRATE' and allow ='0' and optype =0 and adgroupid ='2299_07047985975ccbb2'

		 */
		String test_deleteAdGroupKVSettingParams = "[{\"cid\":\"13485\",\"planid\":\"13485_0fdedbcac10b4e85\",\"adgroupid\":\"13485_ee6263b72fd1c6e7\",\"name\":\"EX_VERTICAL_1\",\"values\":[\"0\"],\"fid\":\"17\",\"allow\":\"0\",\"optype\":\"0\", \"method\":\"DeleteAdGroupKVSettingByFilterAndNameAndValue\"}]";
		String deleteAdGroupKVSettingParams = "[{\"cid\":\"14397\",\"planid\":\"14397_083f3c79a245064d\",\"adgroupid\":\"14397_09f18c1636fa1dc1\",\"name\":\"DEVICE_TYPE\",\"values\":[\"T\"],\"fid\":\"19\",\"allow\":\"0\",\"optype\":\"0\", \"method\":\"DeleteAdGroupKVSettingByFilterAndNameAndValue\"}]";
		adtest.fastDoPost(deletAdGroupKVSetting, header, deleteAdGroupKVSettingParams);
		
		
		
		
		
		
		
	}

}
