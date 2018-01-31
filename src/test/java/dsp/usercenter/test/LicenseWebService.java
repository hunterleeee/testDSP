package dsp.usercenter.test;

public class LicenseWebService {
	private String testURL="http://l-bidtest.dev.cn2.corp.agrant.cn:8086/n/license/";
	
	
	/**
	 * 1 对应的LicenseWebService接口：public LicenseAGWebserviceResp GetLicenseInfoM(int productId, int cid)
	 * @return 后台管理员获取某个客户对于某个产品的使用权限.   
	 *  SQL : SELECT * from USER_CENTER.CusProdRel WHERE cid =89019 and productid=1;
	 */
	public StringBuffer  getlicenseinfom(String name,String token,int pid,int cid){
		String params=null;
		params=String.format("{\"productid\":%d,\"cid\":%d}",pid,cid);
		String url=testURL+"getlicenseinfom.ajax";
		StringBuffer res =interfaceCenter.getInstance(url, interfaceCenter.getMap(name, token), params);
		System.out.println("body:"+params+"\n"+url+"\n"+"headerName: "+name +"\t"+"token: "+token+"\n");
		System.out.println(res);
		return res;
//		{"productid":1,"cid":1}
	}
	
	/**
	 * 2 ( 已废除 ) 对应的LicenseWebService接口： public CommodityListAGWebserviceResp GetAllCommodity()
	 * @return 获取所有商品信息
	 *  SQL : 
	 */
	public StringBuffer  getallcommodity(String name,String token){
		String params=null;
		params=String.format("{}");
		String url=testURL+"getallcommodity.ajax";
		StringBuffer res =interfaceCenter.getInstance(url, interfaceCenter.getMap(name, token), params);
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
		String token2 ="a5997e0685df6e7dd98d03e3021ec88c";
		String userS="smanage";
		String tokenS ="158bb50020ff3b7b95f603c1a6d40b20";	
		
		LicenseWebService lws = new LicenseWebService();
		lws.getlicenseinfom(user1,token1,1,89019);   //(userS,tokenS,6,89019); 返回effecit 一直等于false
//		lws.getallcommodity(userS, tokenS);
	}

}
