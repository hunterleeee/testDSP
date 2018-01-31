package com.Interface;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.json.JSONWriter;

import com.google.gson.Gson;


public class baseHttpClient {
	
	public StringBuffer doGet(String url) {
        URLConnection connection=null;
        StringBuffer resBuffer = new StringBuffer();
		try {
			connection = new URL(url).openConnection();
	        connection.connect();
	        BufferedReader read = new BufferedReader(new InputStreamReader(connection.getInputStream()));
	        String templine =null;
	        
	        while((templine = read.readLine())!=null){
	             resBuffer.append(templine);
	        }
	        read.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
      return resBuffer;
   }

	/**
	 * @return
	 */
	public StringBuffer doPost(String url, Map< String, String> headers,String params){
		 StringBuffer res = null ;
		try {
			URLConnection connection = new URL(url).openConnection();
//			HttpURLConnection connection = (HttpURLConnection)connection;
			connection.setDoOutput(true);
			connection.setDoInput(true);
			for (String x:headers.keySet()){
				connection.setRequestProperty(x, headers.get(x));
			}
//			connection.setRequestProperty("Content-Type", "application/json"); //SET header
			OutputStreamWriter outputstreamwriter = new OutputStreamWriter(connection.getOutputStream(),"utf-8"); 
			outputstreamwriter.write(params.toString());
			outputstreamwriter.flush();

			BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream(),"utf-8"));
	        String templine =null;
	        res = new StringBuffer();
	        while((templine = reader.readLine())!=null){
	             res.append(templine);
	        }
	        reader.close();	
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
	}
	
	
	public StringBuffer doPost2(String url, Map< String, String> headers,String params, String encode){
		 StringBuffer res = null ;
		try {
			URLConnection connection = new URL(url).openConnection();
//			HttpURLConnection connection = (HttpURLConnection)connection;
			connection.setDoOutput(true);
			connection.setDoInput(true);
			for (String x:headers.keySet()){
				connection.setRequestProperty(x, headers.get(x));
			}
//			connection.setRequestProperty("Content-Type", "application/json"); //SET header
			OutputStreamWriter outputstreamwriter = new OutputStreamWriter(connection.getOutputStream(),encode); 
			outputstreamwriter.write(params.toString());
			outputstreamwriter.flush();

			InputStreamReader reader = new InputStreamReader(connection.getInputStream(),encode);
	        res = new StringBuffer();
	        int c;
			char [] buffer = new char [8*1024];
			while((c=reader.read(buffer,0, buffer.length))!=-1){
	            System.out.println(buffer);
	            res.append(buffer);
	        }
	        reader.close();	
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
	}
	/**
	 * 返回信息为gzip格式 直接显示是乱码 需要是GZIPOutputStream、GZIPInputStream
	 * @param url
	 * @param headers
	 * @param params
	 * @return
	 */
	public StringBuffer doPostForGzip(String url, Map<String,String> headers, String params){
		StringBuffer res = new  StringBuffer();
		try {
			URLConnection connection = new URL(url).openConnection();
			connection.setDoOutput(true);
			connection.setDoInput(true);

			for (String x:headers.keySet()){
				connection.setRequestProperty(x, headers.get(x));
			}
    
	        GZIPOutputStream gzipOut = new GZIPOutputStream(connection.getOutputStream()); 
	        gzipOut.write(params.getBytes(Charset.forName("UTF-8")));
	        gzipOut.flush();
	        gzipOut.finish(); 

			GZIPInputStream reader = new GZIPInputStream(connection.getInputStream());
			int c;
			byte[] buffer = new byte [1024];
			while((c=reader.read(buffer, 0, buffer.length))!=-1){
				res.append(new String(buffer,"UTF-8"));
			}
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
		
		
	}
	
	public static void main(String[] args) throws MalformedURLException {
		// TODO Auto-generated method stub
		String url1="http://www.baidu.com";
		String url2="http://qshell.prod.ud2.corp.agrant.cn:8080/doquery";
		String url3="";
		baseHttpClient bhc = new baseHttpClient();
		
//		------------------------------test doGet function
//		StringBuffer getResult =bhc.doGet(url1);
//		System.out.println(getResult);
//		-------------------------
		
		String data_device ="{\"dimensions\": [\"device\",\"cid\"],"+
		           "\"havings\":[],"+
		           "\"values\":" +
		           "[\"impression\",\"click\",\"cost\",\"ctr\",\"cpm\",\"cpc\",\"orev\",\"rev8\",\"rev7\",\"rev9\",\"rev4\",\"rev3\",\"rev6\",\"rev5\",\"rev14\",\"rev15\",\"rev12\",\"rev13\",\"rev10\",\"rev11\",\"rev20\",\"rev2\",\"rev1\",\"rev18\",\"rev19\",\"rev16\",\"rev17\"],"+
		           "\"hint\":\"kudu\","+
		           "\"conditions\": ["+
		            "{\"lhs\":\"cid\",\"op\":\"=\",\"rhs\":\"8654\"},"+
		            "{\"lhs\": \"5000000\",\"op\": \"#limit\"},"+
		            "{\"lhs\": \"dateline\",\"op\": \">=\",\"rhs\": \"20160725\"},"+
		            "{\"lhs\": \"dateline\",\"op\": \"<=\",\"rhs\": \"20160727\"},"+
		            "{\"lhs\":\"impression\",\"op\":\"#orderby\",\"rhs\":\"desc\"}"+
		            "]}";
		Map< String,String> head =new HashMap<String, String>();
		head.put("Content-Type", "application/json");
 		StringBuffer postResulut = bhc.doPost(url2, head,data_device);
		System.out.println(postResulut);

				
				
				
				
				
				
		          
		
		
	}



}
