package dsp.usercenter.test;

import java.util.HashMap;
import java.util.Map;

public class ProductMgrWebService {
	private String testURL="http://l-bidtest.dev.cn2.corp.agrant.cn:8086/m/productmgr/";
	public Map<String,String> getMap(String name,String token){
		Map <String,String> header =new HashMap<String, String>();
		header.put("Content-Type", "application/json");
		header.put("X-NAME",name);
		header.put("X-TOKEN", token);
		return header;
	}
	
	/**
	 * 1 对应ProductMgrWebService接口：public ProductAGWebserviceResp AddProductForCustomerM(int productId, int cid, LicenseInfo licInfo)。
	 * @return 后台管理员为某个客户添加产品使用权限。
	 * 1 SELECT * from USER_CENTER.CusUserRoleRel WHERE cid =0 and roleid in (101,102) ;  这些用户有权限。
	 * 2 SELECT * FROM USER_CENTER.CusProdRel where cid=89019;添加到此表中。
	 */
	public StringBuffer  addcustomerm(String name,String token,int cid,int pid,String start,String end){
		String params=null;
		params=String.format("{\"cid\":%d,\"productId\":%d,\"license\":{\"startDatetime\":%s,\"endDatetime\":%s}}",cid,pid,start,end);
		String url=testURL+"addcustomerm.ajax";
		StringBuffer res =interfaceCenter.getInstance(url, this.getMap(name, token), params);
		System.out.println("addcustomerm:\n"+"body: "+params+"\n"+url+"\n"+"headerName: "+name +"\t"+"token: "+token);
		System.out.println(res);
		return res;
//		20160801-1469980800
//		20160901-1472659200
//		{"cid":89045,"productId":89045,"license":{"startDatetime":400000000,"endDatetime":500000000}}
	}

	/**
	 * 2 对应ProductMgrWebService接口：public ProductAGWebserviceResp UpdateProductForCustomerM(int productId, int cid, LicenseInfo licInfo)
	 * @return  后台管理员为某个客户更新产品使用权限
	 *  SELECT * from USER_CENTER.CusUserRoleRel WHERE cid =0 and roleid in (101,102) ;  这些用户有权限.
	 *  SELECT * FROM USER_CENTER.CusProdRel where cid=89019;.
	 */
	public StringBuffer  updatecustomerm(String name,String token,int cid,int pid,String start,String end){
		String params=null;
		params=String.format("{\"cid\":%d,\"productId\":%d,\"license\":{\"startDatetime\":%s,\"endDatetime\":%s}}",cid,pid,start,end);
		String url=testURL+"updatecustomerm.ajax";
		StringBuffer res =interfaceCenter.getInstance(url, this.getMap(name, token), params);
		System.out.println("body:"+params+"\n"+url+"\n"+"headerName: "+name +"\t"+"token: "+token+"\n");
		System.out.println(res);
		return res;
//		20160801-1469980800
//		20160901-1472659200
//		{"cid":89030,"productId":89031,"license":{"startDatetime":400000000,"endDatetime":500000000}}
	}
	
	/**
	 * 3 对应ProductMgrWebService接口：public ProductAGWebserviceResp AddProductM(ProductInfo productInfo)
	 * @return  后台管理员添加产品信息
	 *  SQL : SELECT * from ProductInfo ORDER BY id DESC;。
	 *  参数除了productName，其他都可以选填，price可以添加Null
	 */
	public StringBuffer  addproductm(String name,String token,String pro){
		String params=null;
		params=String.format("{\"product\":%s}",pro);
		String url=testURL+"addproductm.ajax";
		StringBuffer res =interfaceCenter.getInstance(url, this.getMap(name, token), params);
		System.out.println("body:"+params+"\n"+url+"\n"+"headerName: "+name +"\t"+"token: "+token+"\n");
		System.out.println(res);
		return res;
//		{"product":{"productName":"Test","note1":"Test"}}
	}
	
	/**
	 * 4 对应ProductMgrWebService接口：public ProductAGWebserviceResp UpdateProductM(ProductInfo productInfo)
	 * @return  后台管理员更新产品信息
	 * deleteFlag 变更为0  ;  Update note1 无效
	 *  SQL : SELECT * from USER_CENTER.ProductInfo ORDER BY id DESC;
	 */
	public StringBuffer  updateproductm(String name,String token,String pro){
		String params=null;
		params=String.format("{\"product\":%s}",pro);
		String url=testURL+"updateproductm.ajax";
		StringBuffer res =interfaceCenter.getInstance(url, this.getMap(name, token), params);
		System.out.println("body:"+params+"\n"+url+"\n"+"headerName: "+name +"\t"+"token: "+token+"\n");
		System.out.println(res);
		return res;
//		{"product":{"productName":"Test","productId":100010,"sysid":1,"note1":"Test"}}
	}
		
	/**
	 * 5 对应ProductMgrWebService接口：public ProductAGWebserviceResp DeleteProductM(int productId)；
	 * @return  后台管理员删除产品信息
	 *  SQL : 
	 */
	public StringBuffer  deleteproductm(String name,String token,int pid){
		String params=null;
		params=String.format("{\"productId\":%d}",pid);
		String url=testURL+"deleteproductm.ajax";
		StringBuffer res =interfaceCenter.getInstance(url, this.getMap(name, token), params);
		System.out.println("body:"+params+"\n"+url+"\n"+"headerName: "+name +"\t"+"token: "+token+"\n");
		System.out.println(res);
		return res;
//		{"productId":99999}
	}
	
	/**
	 * 6 对应ProductMgrWebService接口：public ProductListAGWebserviceResp GetAllProductBySidM(int sysId)
	 * @return  后台管理员，根椐sysid，获取所有产品信息
	 *  SQL : SELECT * from USER_CENTER.ProductInfo WHERE sysid=2;
	 */
	public StringBuffer  getallbysysid(String name,String token,int sysid){
		String params=null;
		params=String.format("{\"sysid\":%d}",sysid);
		String url=testURL+"getallbysysid.ajax";
		StringBuffer res =interfaceCenter.getInstance(url, this.getMap(name, token), params);
		System.out.println("body:"+params+"\n"+url+"\n"+"headerName: "+name +"\t"+"token: "+token+"\n");
		System.out.println(res);
		return res;
//		{"sysid":5}
	}
	
	/**
	 * 7 对应ProductMgrWebService接口：public ProductListAGWebserviceResp GetProductByCidM(int cid)
	 * @return 后台管理员获取某一客户所有产品信息.  
	 *  SQL1:  SELECT * from USER_CENTER.ProductInfo;
	 *  SQL2:  SELECT * from USER_CENTER.CusProdRel WHERE cid =89019;
	 */
	public StringBuffer  getproductbycid(String name,String token,int cid){
		String params=null;
		params=String.format("{\"cid\":%d}",cid);
		String url=testURL+"getproductbycid.ajax";
		StringBuffer res =interfaceCenter.getInstance(url, this.getMap(name, token), params);
		System.out.println("body:"+params+"\n"+url+"\n"+"headerName: "+name +"\t"+"token: "+token+"\n");
		System.out.println(res);
		return res;
//		{"cid":89030}
	}	
	
	/**
	 * 8 对应ProductMgrWebService接口：public ProductListAGWebserviceResp GetAllProductM()
	 * @return 后台管理员获取所有产品信息.  
	 *  SQL :  SELECT * from USER_CENTER.ProductInfo 
	 */
	public StringBuffer  getallproductm(String name,String token){
		String params=null;
		params=String.format("{}");
		String url=testURL+"getallproductm.ajax";
		StringBuffer res =interfaceCenter.getInstance(url, this.getMap(name, token), params);
		System.out.println("body:"+params+"\n"+url+"\n"+"headerName: "+name +"\t"+"token: "+token+"\n");
		System.out.println(res);
		return res;
//		{}
	}	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String user1="junfeng.li";
		String token1 = _getToken.getInstance("junfeng.li", "12345678", 6);
		String user2="lijunfeng149@sina.com";
		String token2 = _getToken.getInstance(user2, "12345678", 6);
		String userS="smanage";
		String tokenS = _getToken.getInstance(userS, "71ad3b8f53491648d4074bdebdda7ab0", 6);
		
		ProductMgrWebService pmws =new ProductMgrWebService();
		
//		pmws.addcustomerm(user1, token1, 15,6,"1469980800","1472659200");  //对103客户返回错误——OK
//		pmws.updatecustomerm(userS, tokenS, 89019, 999, "1469980800000", "4625654400000");
//		pmws.addproductm(userS, tokenS, "{\"productName\":\"TestProduct24\",\"price\":\"\" ,\"sysid\":99,\"note1\":\"Not1Test\"}");//处理名称 "{\"productName\":\"TestProduct\",\"note1\":\"Not1Test\",\"price\":5.6,\"sysid\":99,\"deleteFlag\":0}"
//		pmws.updateproductm(userS, tokenS, "{\"productName\":\"Teest\",\"productId\":100097,\"sysid\":0,\"price\":\"\"}");
//		pmws.deleteproductm(user1,token1,100097);
		pmws.getallbysysid(userS,tokenS,2);
//		pmws.getproductbycid(userS,tokenS,89019);  // bug:id和note1显示为null;(user2,token2,89019);
//		pmws.getallproductm(user2,token2); 
	}

}
