package dsp.usercenter.test;

import java.util.HashMap;
import java.util.Map;

import com.Interface.baseHttpClient;

public class interfaceCenter {
	public static StringBuffer getInstance(String url,Map<String,String> header,String params){
		baseHttpClient bhc = new baseHttpClient();
		StringBuffer res =bhc.doPost(url, header, params);
		return res;
	}
	public static Map<String,String> getMap(String name,String token){
		Map <String,String> header =new HashMap<String, String>();
		header.put("Content-Type", "application/json");
		header.put("X-NAME",name);
		header.put("X-TOKEN", token);
		return header;
	}
	
}
