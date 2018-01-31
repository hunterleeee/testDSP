package dsp.usercenter.test;

public class CustomerAttrMgrWebservice {
	private String testURL="http://l-bidtest.dev.cn2.corp.agrant.cn:8086/m/cusattribmgr/";
	
	/**
	 * 1 对应CustomerAttrMgrWebservice接口：public CustomerAttribAGWebserviceResp AddCustomerAttribM(CustomerAttrib attrib)
	 * @return 管理员增加CustomerAttrib
	 *  sql : SELECT * from USER_CENTER.CusAttrib WHERE cid =89019 
	 */
	public StringBuffer  addcusattrib(String user,String token,String param){
		String params=null;
		params=String.format("{\"cusAttrib\":%s}",param);
		String url=testURL+"addcusattrib.ajax";
		StringBuffer res =interfaceCenter.getInstance(url, interfaceCenter.getMap(user, token), params);
		System.out.println("body:"+params+"\n"+url+"\n"+"headerName: "+user +"\t"+"token: "+token+"\n");
		System.out.println(res);
		return res;
//		{"cusAttrib":{"cid":99878,"prodid":889,"key":"Test","group":"Testg","name":"Tname","value":"Tvalue","comment":"Tcomment"}}
//		param = {"cid":99878,"prodid":889,"key":"Test","group":"Testg","name":"Tname","value":"Tvalue","comment":"Tcomment"}
	}
	
	/**
	 * 2 对应CustomerAttrMgrWebservice接口：public CustomerAttribAGWebserviceResp RemoveCustomerAttribM(CustomerAttrib attrib)；
	 * @return 管理员删除CustomerAttrib
	 *   sql : SELECT * from USER_CENTER.CusAttrib WHERE cid =89019 
	 */
	public StringBuffer  rmcusattrib(String user,String token,String param){
		String params=null;
		params=String.format("{\"cusAttrib\":%s}",param);
		String url=testURL+"rmcusattrib.ajax";
		StringBuffer res =interfaceCenter.getInstance(url, interfaceCenter.getMap(user, token), params);
		System.out.println("body:"+params+"\n"+url+"\n"+"headerName: "+user +"\t"+"token: "+token+"\n");
		System.out.println(res);
		return res;
//		{"cusAttrib":{"cid":99878,"prodid":889,"key":"Test","group":"Testg","name":"Tname","value":"Tvalue","comment":"Tcomment"}}
//		param = {"cid":99878,"prodid":889,"key":"Test","group":"Testg","name":"Tname","value":"Tvalue","comment":"Tcomment"}
	}

	/**
	 * 3 对应CustomerAttrMgrWebservice接口：public CustomerAttribAGWebserviceResp UpdateCustomerAttribM(CustomerAttrib attrib)；
	 * @return 管理员删除CustomerAttrib
	 *  sql : SELECT * from USER_CENTER.CusAttrib WHERE cid =89019 
	 */
	public StringBuffer  updatecusattrib(String user,String token,String param){
		String params=null;
		params=String.format("{\"cusAttrib\":%s}",param);
		String url=testURL+"updatecusattrib.ajax";
		StringBuffer res =interfaceCenter.getInstance(url, interfaceCenter.getMap(user, token), params);
		System.out.println("body:"+params+"\n"+url+"\n"+"headerName: "+user +"\t"+"token: "+token+"\n");
		System.out.println(res);
		return res;
//		{"cusAttrib":{"cid":99878,"prodid":889,"key":"Test","group":"Testg","name":"Tname","value":"Tvalue","comment":"Tcomment"}}
//		param = {"cid":99878,"prodid":889,"key":"Test","group":"Testg","name":"Tname","value":"Tvalue","comment":"Tcomment"}
	}
	
	/**
	 * 4 对应CustomerAttrMgrWebservice接口：public CustomerAttribAGWebserviceResp UpdateCustomerAttribMV1(CustomerAttrib attrib)；
	 * @return 管理员根据updatelog 更新CustomerAttrib
	 *  sql : SELECT * from USER_CENTER.CusAttrib WHERE cid =89019 
	 */
	public StringBuffer  updatecusattribv1(String user,String token,String param){
		String params=null;
		params=String.format("{\"cusAttrib\":%s}",param);
		String url=testURL+"updatecusattribv1.ajax";
		StringBuffer res =interfaceCenter.getInstance(url, interfaceCenter.getMap(user, token), params);
		System.out.println("body:"+params+"\n"+url+"\n"+"headerName: "+user +"\t"+"token: "+token+"\n");
		System.out.println(res);
		return res;
//		{"cusAttrib":{"cid":99878,"prodid":889,"key":"Test","group":"Testg","name":"Tname1","value":"Tvalue1","comment":"Tcomment1","updateLog":["name"]}}
//		param = {"cid":99878,"prodid":889,"key":"Test","group":"Testg","name":"Tname1","value":"Tvalue1","comment":"Tcomment1","updateLog":["name"]}
	}
	
	/**
	 * 5 对 应CustomerAttrMgrWebservice接口：public CustomerAttribListAGWebserviceResp GetCustomerAttribListByProductM(int cid, int productId, string group)；
	 * @return 管理员根椐cid，pid，group获取CustomerAttrib
	 *  sql : SELECT * from USER_CENTER.CusAttrib WHERE cid =89019 
	 */
	public StringBuffer  getcuslistbyprod(String user,String token,int cid,int pid,String group){
		String params=null;
		params=String.format("{\"cid\":%d,\"productId\":%d,\"group\":\"%s\"}",cid,pid,group);
		String url=testURL+"getcuslistbyprod.ajax";
		StringBuffer res =interfaceCenter.getInstance(url, interfaceCenter.getMap(user, token), params);
		System.out.println("body:"+params+"\n"+url+"\n"+"headerName: "+user +"\t"+"token: "+token+"\n");
		System.out.println(res);
		return res;
//		{"cid":97889,"productId":9779,"group":"domain"}
//		param = {"cid":99878,"prodid":889,"key":"Test","group":"Testg","name":"Tname1","value":"Tvalue1","comment":"Tcomment1","updateLog":["name"]}
	}
	
	/**
	 * 6 对应CustomerAttrMgrWebservice接口：public SetDomainListResponse SetDomainListM(SetDomainListRequest request)
	 * @return 管理员更新“domain”CustomerAttrib
	 *  sql : SELECT * from USER_CENTER.CusAttrib WHERE cid =89019 and `group` ='domain'
	 */
	public StringBuffer  updatedomainlist(String user,String token,int cid,int pid,String param){
		String params=null;
		params=String.format("{\"cid\":%d,\"productId\":%d,\"cidDomainList\": %s}",cid,pid,param);
		String url=testURL+"updatedomainlist.ajax";
		StringBuffer res =interfaceCenter.getInstance(url, interfaceCenter.getMap(user, token), params);
		System.out.println("body:"+params+"\n"+url+"\n"+"headerName: "+user +"\t"+"token: "+token+"\n");
		System.out.println(res);
		return res;
//		{"cid":97989,"productId":9769,"cidDomainList": [{"domain":"tt","domainIndex":"DLTI0" ,"verified":"tt"},{"domain":"nn" ,"domainIndex":"DLTI1" ,"verified":"huhu" },{"domain":"vv" ,"domainIndex":"DLTI2" ,"verified":"vv" }]}
	}	
	
	/**
	 * 7 对应CustomerAttrMgrWebservice接口：public GetDomainListResponse GetDomainListM(GetDomainListRequest request); 
	 * @return 根据cid，pid 取“domain”CustomerAttrib
	 *  sql : SELECT * from USER_CENTER.CusAttrib WHERE cid =89019 and `group` ='domain'
	 */
	public StringBuffer  getdomainlist(String user,String token,int cid,int pid){
		String params=null;
		params=String.format("{\"cid\":%d,\"productId\":%d}",cid,pid);
		String url=testURL+"getdomainlist.ajax";
		StringBuffer res =interfaceCenter.getInstance(url, interfaceCenter.getMap(user, token), params);
		System.out.println("body:"+params+"\n"+url+"\n"+"headerName: "+user +"\t"+"token: "+token+"\n");
		System.out.println(res);
		return res;
//		{"cid":97989,"productId":9769}
	}	

	/**
	 * 8 对应CustomerAttrMgrWebservice接口：public GetAllCidDomainListMResponse GetAllCidDomainListM(GetAllCidDomainListMRequest request) 
	 * @return 管理员根据pid取“domain” CustomerAttrib
	 *  sql : SELECT * from USER_CENTER.CusAttrib WHERE `group` ='domain' and prodid=6
	 */
	public StringBuffer  getallcdmlist(String user,String token,int pid){
		String params=null;
		params=String.format("{\"productId\":%d}",pid);
		String url=testURL+"getallcdmlist.ajax";
		StringBuffer res =interfaceCenter.getInstance(url, interfaceCenter.getMap(user, token), params);
		System.out.println("body:"+params+"\n"+url+"\n"+"headerName: "+user +"\t"+"token: "+token+"\n");
		System.out.println(res);
		return res;
//		{"productId":9769}
	}	
	
	/**
	 * 9 管理员根据pid，group、cid序列取“domain” CustomerAttrib 
	 * @return 对应CustomerAttrMgrWebservice接口：public CustomerAttribListAGWebserviceResp GetCustomerAttribListByProductAndCidListM(List<int> cidList, int productId, string group)
	 *  sql : SELECT * from USER_CENTER.CusAttrib WHERE cid in (89019,905) and `group`='domain'
	 */
	public StringBuffer  getcusatbcidl(String user,String token,int pid,String group,String cidlist){
		String params=null;
		params=String.format("{\"productId\":%d,\"group\":\"%s\",\"cidList\":%s}",pid,group,cidlist);
		String url=testURL+"getcusatbcidl.ajax";
		StringBuffer res =interfaceCenter.getInstance(url, interfaceCenter.getMap(user, token), params);
		System.out.println("body:"+params+"\n"+url+"\n"+"headerName: "+user +"\t"+"token: "+token+"\n");
		System.out.println(res);
		return res;
//		{"productId":9749,"group":"domain","cidList":[94321,94322,94323,94324]}
	}	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String user1="junfeng.li";
		String token1 = _getToken.getInstance("junfeng.li", "123456", 6);
		String user2="lijunfeng149@sina.com";
		String token2 =_getToken.getInstance(user2, "12345678", 6);
		String user3 ="lijunfeng6@sina.com";
		String token3=_getToken.getInstance(user3, "12345678", 6);
		String userS="smanage";
		String tokenS =_getToken.getInstance(userS, "71ad3b8f53491648d4074bdebdda7ab0", 6);
		
		CustomerAttrMgrWebservice camw= new CustomerAttrMgrWebservice();
		
		String paramCusattrib1 = "{\"cid\":89019,\"prodid\":6,\"key\":\"4\",\"group\":\"domain\",\"name\":\"name4\",\"value\":\"http://value4.com\",\"comment\":\"Tcomment4\",\"updateLog\":[\"name\"]}";
		String paramCusattrib2 = "{\"cid\":89019,\"prodid\":6,\"key\":\"5\",\"group\":\"domain\",\"updateLog\":[\"name\"]}";
		String paramCusattrib3 = "{\"cid\":89019,\"prodid\":6,\"key\":\"4\",\"group\":\"domain\",\"name\":\"name4\",\"value\":\"http://value4.com\",\"comment\":\"Tcomment4\",\"updateLog\":[\"name\",\"value\",\"comment\"]}";
		String paramDomain1="[{\"domain\":\"name1\",\"domainIndex\":\"4\" ,\"verified\":\"www.baidu4.com\"},"
				+ "{\"domain\":\"name2\" ,\"domainIndex\":\"5\" ,\"verified\":\"www.baidu5.com\"},"
				+  "{\"domainIndex\":\"6\",\"comment\":\"111\"}]";

//		camw.addcusattrib(userS, tokenS, paramCusattrib1);
//		camw.rmcusattrib(userS, tokenS, paramCusattrib2);
//		camw.updatecusattrib(userS, tokenS, paramCusattrib2);
//		camw.updatecusattribv1(userS, tokenS, paramCusattrib2);
//		camw.getcuslistbyprod(user1, token1, 89019, 0, "adxCert");
		
//		camw.updatedomainlist(userS, tokenS, 89019, 6, paramDomain1);
//		camw.getdomainlist(userS, tokenS, 89019, 7);
//		camw.getallcdmlist(user1, token1, 6);
//		camw.getcusatbcidl(user1, token1, 6, "domain", "[89019,905]");
		
		
		
	}

}
