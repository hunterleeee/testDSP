package dsp.usercenter.test;

public class CustomerWebService {
	private String testURL="http://l-bidtest.dev.cn2.corp.agrant.cn:8086/n/customer/";
	/**
	 * 1 对应的CustomerWebService接口：public CustomerAGWebserviceResp GetCustomerByCid(int cid)
	 * @return 通过cid获取某客户信息
	 *  sql : SELECT * from USER_CENTER.CustomerInfo WHERE cid =13405;
	 *  param : {"cid':"0"}
	 */
	public StringBuffer  getcustomerbycid(String user,String token,String param){
		String params=null;
		params=String.format("%s",param);
		String url=testURL+"getcustomerbycid.ajax";
		StringBuffer res =interfaceCenter.getInstance(url, interfaceCenter.getMap(user, token), params);
		System.out.println("body:"+params+"\n"+url+"\n"+"headerName: "+user +"\t"+"token: "+token+"\n");
		System.out.println(res);
		return res;	
	}
	/**
	 * 2 对应的CustomerWebService接口：public CustomerListResp GetCustomerInfoByAgencyCid(int cid)
	 * @return 根据AgencyCid获取客户信息
	 *  sql :SELECT * from USER_CENTER.CustomerInfo WHERE agent =13405;
	 *  param : {"cid':"0"}
	 */
	public StringBuffer  getcustomerinfobyagencycid(String user,String token,String param){
		String params=null;
		params=String.format("%s",param);
		String url=testURL+"getcustomerinfobyagencycid.ajax";
		StringBuffer res =interfaceCenter.getInstance(url, interfaceCenter.getMap(user, token), params);
		System.out.println("body:"+params+"\n"+url+"\n"+"headerName: "+user +"\t"+"token: "+token+"\n");
		System.out.println(res);
		return res;	
	}
	/**
	 * 3 对应的CustomerWebService接口： public CustomerListAGWebserviceResp GetCustomerListByHeader()
	 * @return 获取验证用户对应的客户列表
	 *  sql :SELECT t2.* from USER_CENTER.CusUserRoleRel t1 LEFT JOIN USER_CENTER.CustomerInfo t2 on t1.cid=t2.cid WHERE t1.uid=6466 ;
	 *  param : {}
	 */
	public StringBuffer  getcustomerlistbyheader(String user,String token,String param){
		String params=null;
		params=String.format("%s",param);
		String url=testURL+"getcustomerlistbyheader.ajax";
		StringBuffer res =interfaceCenter.getInstance(url, interfaceCenter.getMap(user, token), params);
		System.out.println("body:"+params+"\n"+url+"\n"+"headerName: "+user +"\t"+"token: "+token+"\n");
		System.out.println(res);
		return res;	
	}
	/**
	 * 4 对应的CustomerWebService接口： public CusProdRelListAGWebserviceResp GetCusProdRelByAgentCid(int cid)
	 * @return 根据 agentcid 获取表中信息
	 *  sql :
	 *  param :{"cid":"1"}
	 */
	public StringBuffer  getcusprodrelbyagentcid(String user,String token,String param){
		String params=null;
		params=String.format("%s",param);
		String url=testURL+"getcusprodrelbyagentcid.ajax";
		StringBuffer res =interfaceCenter.getInstance(url, interfaceCenter.getMap(user, token), params);
		System.out.println("body:"+params+"\n"+url+"\n"+"headerName: "+user +"\t"+"token: "+token+"\n");
		System.out.println(res);
		return res;	
	}
	/**
	 * 5 对应的CustomerWebService接口：public CusProdRelListAGWebserviceResp GetCusProdRelByAllStatusCid(int cid)
	 * @return 通过cid获取客户产品权限二元关系但验证时忽略cid状态
	 *  sql :
	 *  param :{"cid':"1"}
	 */
	public StringBuffer  getcusprodrelbyallstatuscid(String user,String token,String param){
		String params=null;
		params=String.format("%s",param);
		String url=testURL+"getcusprodrelbyallstatuscid.ajax";
		StringBuffer res =interfaceCenter.getInstance(url, interfaceCenter.getMap(user, token), params);
		System.out.println("body:"+params+"\n"+url+"\n"+"headerName: "+user +"\t"+"token: "+token+"\n");
		System.out.println(res);
		return res;	
	}
	/**
	 * 6 对应的CustomerWebService接口：public CusProdRelListAGWebserviceResp GetCusProdRelByCid(int cid)
	 * @return 根据 cid 获取 表信息
	 *  sql :SELECT t1.*,t2.productname from USER_CENTER.CusProdRel t1 LEFT JOIN USER_CENTER.ProductInfo t2 on t1.productid=t2.productid WHERE t1.cid =13485;
	 *  param :{"cid':"1"}
	 */
	public StringBuffer  getcusprodrelbycid(String user,String token,String param){
		String params=null;
		params=String.format("%s",param);
		String url=testURL+"getcusprodrelbycid.ajax";
		StringBuffer res =interfaceCenter.getInstance(url, interfaceCenter.getMap(user, token), params);
		System.out.println("body:"+params+"\n"+url+"\n"+"headerName: "+user +"\t"+"token: "+token+"\n");
		System.out.println(res);
		return res;	
	}
	/**
	 * 7 对应的CustomerWebService接口： public CustomerAGWebserviceResp UpdateCustomer(CustomerInfo customerInfo)
	 * @return 更新客户信息
	 *  sql :
	 *  param :{"customerInfoDto":{"address":"abc","agent":123,"cid":0,"cname":"abc","company":"abc","companytype":"abc","contact":"abc","contactaddress":"abc","deleteflag":1,"domain":"abc","email":"abc","modifier":1,"note1":"abc","status":1,"tel":"abc","url":"abc"}}
	 */
	public StringBuffer  updatecustomer(String user,String token,String param){
		String params=null;
		params=String.format("%s",param);
		String url=testURL+"updatecustomer.ajax";
		StringBuffer res =interfaceCenter.getInstance(url, interfaceCenter.getMap(user, token), params);
		System.out.println("body:"+params+"\n"+url+"\n"+"headerName: "+user +"\t"+"token: "+token+"\n");
		System.out.println(res);
		return res;	
	}
	/**
	 * 8 对应的CustomerWebService接口：public UpdateCustomerV1Response UpdateCustomerV2(UpdateCustomerV1Request customerReq)
	 * @return 更新客户信息
	 *  sql :
	 *  param :{"address":"abc","agent":123,"cid":0,"cname":"abc","company":"abc","companytype":"abc","contact":"abc","contactaddress":"abc","deleteflag":1,"domain":"abc","email":"abc","modifier":1,"note1":"abc","status":1,"tel":"abc","url":"abc","domainList":[{"domain":"123","domainIndex":"123","verified":"123"}],"updateLog":["cname"]}}
	 */
	public StringBuffer  updatecustomerv2(String user,String token,String param){
		String params=null;
		params=String.format("%s",param);
		String url=testURL+"updatecustomerv2.ajax";
		StringBuffer res =interfaceCenter.getInstance(url, interfaceCenter.getMap(user, token), params);
		System.out.println("body:"+params+"\n"+url+"\n"+"headerName: "+user +"\t"+"token: "+token+"\n");
		System.out.println(res);
		return res;	
	}
	/**
	 * 9 对应的CustomerWebService接口：public EmailConfigCustomerWebserviceResp AddEmailConfig(List<string> emailList, int cid, int type)
	 * @return根据 email,cid,type 插入数据
	 *  sql :
	 *  param :{"emailList":["abc","def","xyz"],"cid":"100","type":"1"}
	 */
	public StringBuffer  addemailconfig(String user,String token,String param){
		String params=null;
		params=String.format("%s",param);
		String url=testURL+"addemailconfig.ajax";
		StringBuffer res =interfaceCenter.getInstance(url, interfaceCenter.getMap(user, token), params);
		System.out.println("body:"+params+"\n"+url+"\n"+"headerName: "+user +"\t"+"token: "+token+"\n");
		System.out.println(res);
		return res;	
	}
	/**
	 * 10 对应的CustomerWebService接口： public EmailConfigCustomerWebserviceResp DeleteEmailConfig(int cid, int type)
	 * @return根据cid 和 type 删除数
	 *  sql :
	 *  param :{"cid":0,"type":1}
	 */
	public StringBuffer  deleteemailconfig(String user,String token,String param){
		String params=null;
		params=String.format("%s",param);
		String url=testURL+"deleteemailconfig.ajax";
		StringBuffer res =interfaceCenter.getInstance(url, interfaceCenter.getMap(user, token), params);
		System.out.println("body:"+params+"\n"+url+"\n"+"headerName: "+user +"\t"+"token: "+token+"\n");
		System.out.println(res);
		return res;	
	}
	/**
	 * 11 对应的CustomerWebService接口： public EmailConfigCustomerWebserviceResp DeleteEmailConfig(int cid, int type)
	 * @return 根据 cid和 type 获取 email配置信息
	 *  sql :
	 *  param :{"cid":0,"type":1}
	 */
	public StringBuffer  getemailconfiglistbycidandtype(String user,String token,String param){
		String params=null;
		params=String.format("%s",param);
		String url=testURL+"getemailconfiglistbycidandtype.ajax";
		StringBuffer res =interfaceCenter.getInstance(url, interfaceCenter.getMap(user, token), params);
		System.out.println("body:"+params+"\n"+url+"\n"+"headerName: "+user +"\t"+"token: "+token+"\n");
		System.out.println(res);
		return res;	
	}
		
	public static void main(String[] args) {
		String user1="junfeng.li";
		String token1 =_getToken.getInstance("junfeng.li", "12345678", 6);
		String user2="lijunfeng149@sina.com";
		String token2 =_getToken.getInstance(user2, "12345678", 6);
		String user3 ="lijunfeng6@sina.com";
		String token3=_getToken.getInstance(user3, "12345678", 6);
		String userS="smanage";
		String tokenS =_getToken.getInstance(userS, "71ad3b8f53491648d4074bdebdda7ab0", 6);
		CustomerWebService cws = new CustomerWebService();
//1-10
//		cws.getcustomerbycid(user2, token2, "{\"cid\":13485}"); 
//		cws.getcustomerinfobyagencycid(user1, token1, "{\"cid\":10593}");
//		cws.getcustomerlistbyheader(user1, token1, "{}");  //BUg获取cid数量不一致????????????????????
//		cws.getcusprodrelbyagentcid(user1, token1, "{\"cid\":13405}"); //????????????????不会用？
//		cws.getcusprodrelbyallstatuscid(user1, token1, "{\"cid\":13405}");//????????????????不会用？
		
//		cws.getcusprodrelbycid(user1, token1, "{\"cid\":13485}");//BUG 获取不到CusProdRel信息
//		String parmUpdatecustomer = "{\"customerInfoDto\":{\"address\":\"河北省||石家庄市||行唐县||AGBC11\",\"agent\":-1,\"cid\":1348511,\"cname\":\"lijunfeng50@sina.com1\",\"company\":\"company1\",\"companytype\":\"companytype1\",\"contact\":\"contact1\",\"contactaddress\":\"contactaddress1\",\"deleteflag\":0,\"domain\":\"domain1\",\"email\":\"lijunfeng50@sina.com\",\"modifier\":6466,\"note1\":\"NOTE11\",\"status\":0,\"tel\":\"13717607751\",\"url\":\"url1\"}}";
//		cws.updatecustomer(user1, token1,parmUpdatecustomer);
//		String parmUpdatecustomerv2="{\"customerInfoDto\":{\"address\":\"address\",\"agent\":6466,\"cid\":13485,\"cname\":\"lijunfeng50@sina\",\"company\":\"companyy\",\"companytype\":\"companytype\",\"contact\":\"contact\",\"contactaddress\":\"contactaddress\",\"deleteflag\":0,\"domain\":\"domain\",\"email\":\"email@sina.com\",\"modifier\":-1,\"note1\":\"NOTE1\",\"status\":0,\"tel\":\"13717607755\",\"url\":\"abc\",\"domainList\":[{\"domain\":\"www.test4.com\",\"domainIndex\":\"5\",\"verified\":\"1\"}],\"updateLog\":[\"url\"]}}";
//		cws.updatecustomerv2(user1, token1, parmUpdatecustomerv2); //BUG 3个参数无效可以不添加，不能插入USER_CENTER.CusAttribdomain
//		cws.addemailconfig(user1, token1, "{\"emailList\":[\"abc\",\"def\",\"xyz\"],\"cid\":\"13485\",\"type\":\"2\"}"); 
//		cws.deleteemailconfig(user1, token1, "{\"cid\":13485,\"type\":2}");
//		11
//		cws.getemailconfiglistbycidandtype(user1, token1, "{\"cid\":13485,\"type\":2}");
	}
}
