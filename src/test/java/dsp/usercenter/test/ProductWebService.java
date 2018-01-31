package dsp.usercenter.test;

import java.util.HashMap;
import java.util.Map;

public class ProductWebService {
	private String testURL="http://l-bidtest.dev.cn2.corp.agrant.cn:8086/n/product/";
	public Map<String,String> getMap(String name,String token){
		Map <String,String> header =new HashMap<String, String>();
		header.put("Content-Type", "application/json");
		header.put("X-NAME",name);
		header.put("X-TOKEN", token);
		return header;
	}
	/**
	 * 1 对应ProductWebService接口：public ProductListAGWebserviceResp GetChildProductListByProductId(int productId)；
	 * @return 根据产品id得到子产品序列 
	 * SQL : SELECT * from ProductRel
	 */
	public StringBuffer  getchildproducts(String name,String token,int productid){
		String params=null;
		params=String.format("{\"productId\":%d}", productid);
		String url=testURL+"getchildproducts.ajax";
		StringBuffer res =interfaceCenter.getInstance(url, this.getMap(name, token), params);
//		System.out.println(params+"\n"+url);
		System.out.println(res);
		return res;
	}
	
	
	public static void main(String[] args) {
		ProductWebService pws =new ProductWebService();
		String user1="junfeng.li";
		String token1 = _getToken.getInstance("junfeng.li", "123456", 6);
		String user2="lijunfeng149@sina.com";
		String token2 ="a5997e0685df6e7dd98d03e3021ec88c";
		
		pws.getchildproducts(user2,token2,5); //1/2/3/4/
	}

}
