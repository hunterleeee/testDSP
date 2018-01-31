package dsp.usercenter.test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;
import org.json.JSONTokener;

import com.google.gson.Gson;

public  class _getToken {
	
	public static String getInstance(String name,String passwd,int pid){
		Map<String,String> header = getMap(name, passwd);
		String url ="http://l-bidtest.dev.cn2.corp.agrant.cn:8086/p/gettoken.ajax";
		String params =null;
		params = String.format("{\"pid\":%d}", pid);
		StringBuffer res =interfaceCenter.getInstance(url, header,params);

		//		gson方式 获取不到token 简单json格式可行 如{"id":100,"name":"abc"},复杂格式不可行 如{data:{"token":"adsjfkjal"}} 已经解决 复杂情况需要写多个类.......
		Gson gosn= new Gson();

		Root resJson=new Root();
		resJson =gosn.fromJson(res.toString(), Root.class);
//		System.out.println("from Gson get Token : "+resJson.getData());
		return resJson.getData();
		
		
//		json
//		InputStream resIS = new ByteArrayInputStream(res.toString().getBytes());//先将StringBuffer转化为InputStream
//		JSONTokener jt = new JSONTokener(new InputStreamReader(resIS)); //将InputStream转化为JsonTokener
//		JSONObject jb =  new JSONObject(jt); //将jsontoken转化为json格式
//		System.out.println("from json : "+jb.toString());
		
//		System.out.println(((JSONObject)jb.get("data")).get("token"));
//		return (((JSONObject)jb.get("data")).get("token")).toString();
		

		
	}
	public static Map<String,String> getMap(String name,String passwd){
		Map <String,String> header =new HashMap<String, String>();
		header.put("Content-Type", "application/json");
		header.put("X-NAME",name);
		header.put("X-PASSWORD", passwd);
		return header;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String user1 ="junfeng.li";
		String token1= _getToken.getInstance(user1, "12345678", 6);
		System.out.println(user1+" : "+token1);
		
		String userS="smanage";
		String tokenS= _getToken.getInstance("smanage", "71ad3b8f53491648d4074bdebdda7ab0", 6);
		System.out.println("smanage : "+tokenS);
		

	}
}








//===================================================================
class Data {
private String token;

public void setToken(String token){
this.token = token;
}
public String getToken(){
return this.token;
}

}


class Root {
private int code;

private Data data;

private String valueType;

private String message;

private String value;

private String errors;

public void setCode(int code){
this.code = code;
}
public int getCode(){
return this.code;
}
public void setData(Data data){
this.data = data;
}
public String getData(){
return this.data.getToken();
}
public void setValueType(String valueType){
this.valueType = valueType;
}
public String getValueType(){
return this.valueType;
}
public void setMessage(String message){
this.message = message;
}
public String getMessage(){
return this.message;
}
public void setValue(String value){
this.value = value;
}
public String getValue(){
return this.value;
}
public void setErrors(String errors){
this.errors = errors;
}
public String getErrors(){
return this.errors;
}
}


