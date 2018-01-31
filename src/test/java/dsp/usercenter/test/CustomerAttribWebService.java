package dsp.usercenter.test;

public class CustomerAttribWebService {
	private String testURL="http://l-bidtest.dev.cn2.corp.agrant.cn:8086/n/cusattrib/";
	
	/**
	 * 1 对应CustomerAttribWebService接口：public CustomerAttribAGWebserviceResp AddCustomerAttrib(CustomerAttrib attrib)
	 * @return 增加CustomerAttrib   
	 *  SQL :SELECT * from USER_CENTER.CusAttrib WHERE cid =89019;
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
	} 
	
	/**
	 * 2 对应CustomerAttribWebService接口：public CustomerAttribAGWebserviceResp RemoveCustomerAttrib(CustomerAttrib attrib)；
	 * @return 删除CustomerAttrib   
	 *  SQL : SELECT * from USER_CENTER.CusAttrib WHERE cid =89019
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
	} 
	
	/**
	 * 3 对应CustomerAttribWebService接口：public CustomerAttribAGWebserviceResp UpdateCustomerAttrib(CustomerAttrib attrib)；
	 * @return 更新CustomerAttrib   
	 *  SQL : SELECT * from USER_CENTER.CusAttrib WHERE cid =89019;
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
	} 
	
	/**
	 * 4 对应CustomerAttribWebService接口：public CustomerAttribAGWebserviceResp UpdateCustomerAttribV1(CustomerAttrib attrib)；
	 * @return 根据updatelog 更新CustomerAttrib  ,只更改updateLog参数中的值，name、value、comment,可多选。   
	 *  SQL : SELECT * from USER_CENTER.CusAttrib WHERE cid =89019;
	 */
	public StringBuffer  updatecusattribv1(String user,String token,String parm){
		String params=null;
		params=String.format("{\"cusAttrib\":%s}",parm);
		String url=testURL+"updatecusattribv1.ajax";
		StringBuffer res =interfaceCenter.getInstance(url, interfaceCenter.getMap(user, token), params);
		System.out.println("body:"+params+"\n"+url+"\n"+"headerName: "+user +"\t"+"token: "+token+"\n");
		System.out.println(res);
		return res;
//		{"cusAttrib":{"cid":99878,"prodid":889,"key":"Test","group":"Testg","name":"Tname","value":"Tvalue","comment":"Tcomment"}}
	} 
	
	/**
	 * 5 对应CustomerAttribWebService接口：public CustomerAttribListAGWebserviceResp GetCustomerAttribListByProduct(int cid, int productId, string group)；
	 * @return  根椐cid，pid，group获取CustomerAttrib   
	 *  SQL : SELECT * from USER_CENTER.CusAttrib WHERE cid =89019;
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
	} 
	
	/**
	 * 6 对应CustomerAttribWebService接口：public CustomerAttribAGWebserviceResp[] AddCustomerAttribs(CustomerAttrib[] attribs)
	 * @return  批量添加CustomerAttrib ,如果添加多个有成功又有失败，则分别显示
	 *  SQL : SELECT * from USER_CENTER.CusAttrib WHERE cid =89019;
	 */
	public StringBuffer  addcusattribs(String user,String token,String parm){
		String params=null;
		params=String.format("{\"cusAttribDtos\":%s}",parm);
		String url=testURL+"addcusattribs.ajax";
		StringBuffer res =interfaceCenter.getInstance(url, interfaceCenter.getMap(user, token), params);
		System.out.println("body:"+params+"\n"+url+"\n"+"headerName: "+user +"\t"+"token: "+token+"\n");
		System.out.println(res);
		return res;
//		{"cusAttribDtos":[{"cid":99878,"prodid":889,"key":"Test","group":"Test1g","name":"Tname1","value":"Tvalue1","comment":"Tcomment1"},{"cid":99878,"prodid":8879,"key":"Test1","group":"Testg1","name":"Tname2","value":"Tvalue2","comment":"Tcomment2"}]}
//		parm = [{"cid":99878,"prodid":889,"key":"Test","group":"Test1g","name":"Tname1","value":"Tvalue1","comment":"Tcomment1"},{"cid":99878,"prodid":8879,"key":"Test1","group":"Testg1","name":"Tname2","value":"Tvalue2","comment":"Tcomment2"}]
	} 

	/**
	 * 7 对应CustomerAttribWebService接口：public CustomerAttribAGWebserviceResp[] UpdateCustomerAttribs(CustomerAttrib[] attribs);
	 * @return  批量更新CustomerAttrib 
	 *  SQL : 
	 */
	public StringBuffer  updatecusattribs(String user,String token,String parm){
		String params=null;
		params=String.format("{\"cusAttribDtos\":%s}",parm);
		String url=testURL+"updatecusattribs.ajax";
		StringBuffer res =interfaceCenter.getInstance(url, interfaceCenter.getMap(user, token), params);
		System.out.println("body:"+params+"\n"+url+"\n"+"headerName: "+user +"\t"+"token: "+token+"\n");
		System.out.println(res);
		return res;
//		{"cusAttribDtos":[{"cid":99878,"prodid":889,"key":"Test","group":"Test1g","name":"Tname1","value":"Tvalue1","comment":"Tcomment1"},{"cid":99878,"prodid":8879,"key":"Test1","group":"Testg1","name":"Tname2","value":"Tvalue2","comment":"Tcomment2"}]}
//		parm = [{"cid":99878,"prodid":889,"key":"Test","group":"Test1g","name":"Tname1","value":"Tvalue1","comment":"Tcomment1"},{"cid":99878,"prodid":8879,"key":"Test1","group":"Testg1","name":"Tname2","value":"Tvalue2","comment":"Tcomment2"}]
	} 

	/**
	 * 8 对应CustomerAttribWebService接口：public CustomerAttribAGWebserviceResp[] UpdateCustomerAttribsV1(CustomerAttrib[] attribs)
	 * @return  批量根据updatelog更新CustomerAttrib。   updatelog所选择的参数将被更新。  
	 *  SQL : SELECT * from USER_CENTER.CusAttrib WHERE cid =89019; 
	 */
	public StringBuffer  updatecusattribsv1(String user,String token,String parm){
		String params=null;
		params=String.format("{\"cusAttribDtos\":%s}",parm);
		String url=testURL+"updatecusattribsv1.ajax";
		StringBuffer res =interfaceCenter.getInstance(url, interfaceCenter.getMap(user, token), params);
		System.out.println("body:"+params+"\n"+url+"\n"+"headerName: "+user +"\t"+"token: "+token+"\n");
		System.out.println(res);
		return res;
//		{"cusAttribDtos":[{"cid":99878,"prodid":889,"key":"Test","group":"Test1g","name":"Tname1","value":"Tvalue1","comment":"Tcomment1"},{"cid":99878,"prodid":8879,"key":"Test1","group":"Testg1","name":"Tname2","value":"Tvalue2","comment":"Tcomment2"}]}
//		parm = [{"cid":99878,"prodid":889,"key":"Test","group":"Test1g","name":"Tname1","value":"Tvalue1","comment":"Tcomment1"},{"cid":99878,"prodid":8879,"key":"Test1","group":"Testg1","name":"Tname2","value":"Tvalue2","comment":"Tcomment2"}]
	} 
	
	/**
	 * 9 对应CustomerAttribWebService接口：public CustomerAttribListResp GetAgentProduct(int cid)
	 * @return  根据cid 取“agent”CustomerAttrib
	 *  SQL : SELECT * from USER_CENTER.CusAttrib WHERE cid =89019 and `group`='agent';
	 */
	public StringBuffer  getagentprod(String user,String token,int cid){
		String params=null;
		params=String.format("{\"cid\":%d}",cid);
		String url=testURL+"getagentprod.ajax";
		StringBuffer res =interfaceCenter.getInstance(url, interfaceCenter.getMap(user, token), params);
		System.out.println("body:"+params+"\n"+url+"\n"+"headerName: "+user +"\t"+"token: "+token+"\n");
		System.out.println(res);
		return res;
//		{"cid":96939}
	} 
	
	/**
	 * 10 对应CustomerAttribWebService接口：public SetDomainListResponse SetDomainList(SetDomainListRequest request)
	 * @return  更新“domain”CustomerAttrib
	 *  SQL : SELECT * from USER_CENTER.CusAttrib WHERE cid =89019 and `group`='domain';
	 */
	public StringBuffer  updatedomainlist(String user,String token,int cid,int pid,String param){
		String params=null;
		params=String.format("{\"cid\":%d,\"productId\":%d,\"cidDomainList\":%s}",cid,pid,param);
		String url=testURL+"updatedomainlist.ajax";
		StringBuffer res =interfaceCenter.getInstance(url, interfaceCenter.getMap(user, token), params);
		System.out.println("body:"+params+"\n"+url+"\n"+"headerName: "+user +"\t"+"token: "+token+"\n");
		System.out.println(res);
		return res;
//		{"cid":97989,"productId":9769,"cidDomainList":[{"domain":"tt","domainIndex":"DLTI0" ,"verified":"tt"},{"domain":"nn" ,"domainIndex":"DLTI1" ,"verified":"huhu" }]}
//		[{"domain":"tt","domainIndex":"DLTI0" ,"verified":"tt"},{"domain":"nn" ,"domainIndex":"DLTI1" ,"verified":"huhu" }]
	} 
	
	/**
	 * 11 对应CustomerAttribWebService接口：public GetDomainListResponse GetDomainList(GetDomainListRequest request)
	 * @return  根据cid，pid 取“domain”CustomerAttrib
	 *  SQL : SELECT * from USER_CENTER.CusAttrib WHERE cid =89019 and `group`='domain';
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
	 * 12 对应CustomerAttribWebService接口：public CustomerAttribListAGWebserviceResp GetAgentCustomerAttribListByCid(int cid)
	 * @return  根据cid 取“agent”CustomerAttrib
	 *  SQL : SELECT * from USER_CENTER.CusAttrib WHERE cid =554 and `group`='semclient'
	 */
	public StringBuffer  getagcuslist(String user,String token,int cid ){
		String params=null;
		params=String.format("{\"cid\":%d}",cid);
		String url=testURL+"getagcuslist.ajax";
		StringBuffer res =interfaceCenter.getInstance(url, interfaceCenter.getMap(user, token), params);
		System.out.println("body:"+params+"\n"+url+"\n"+"headerName: "+user +"\t"+"token: "+token+"\n");
		System.out.println(res);
		return res;
//		{"cid":99889}
	} 
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String user1="junfeng.li";
		String token1 = _getToken.getInstance("junfeng.li", "12345678", 6);
//		String user2="lijunfeng149@sina.com";
//		String token2 =_getToken.getInstance(user2, "123456", 6);
//		String user3 ="lijunfeng6@sina.com";
//		String token3=_getToken.getInstance(user3, "123456", 6);
		String userS="smanage";
		String tokenS =_getToken.getInstance(userS, "71ad3b8f53491648d4074bdebdda7ab0", 6);
		
		CustomerAttribWebService caws= new CustomerAttribWebService();
		
//		caws.addcusattrib(user1,token1,"{\"cid\":89019,\"prodid\":6,\"key\":\"4\",\"group\":\"domain\",\"name\":\"nnn\",\"value\":\"http://www.baidu.com\" ,\"comment\":\"\",\"updateLog\":[\"name\"]}");
//		caws.rmcusattrib(user3,token3,"{\"cid\":89019,\"prodid\":6,\"key\":\"4\",\"group\":\"domain\",\"name\":\"\",\"value\":\"http://www.baidu11.com\" ,\"comment\":\"\"}");
		caws.updatecusattrib(user1,token1,"{\"cid\":89019,\"prodid\":6,\"key\":\"5\",\"group\":\"domain\",\"name\":\"http://test.com\",\"value\":\"12\",\"comment\":\"123\"}");
//		caws.updatecusattribv1(user1, token1,"{\"cid\":89019,\"prodid\":6,\"key\":\"5\",\"group\":\"domain\",\"name\":\"http://test.com\",\"value\":\"0\",\"comment\":\"123\",\"updateLog\":[\"name\",\"value\",\"comment\"]}");
//		caws.getcuslistbyprod(user1, token1, 89019, 6, "domain");
		
		String parmcusattrib="[{\"cid\":89019,\"prodid\":6,\"key\":\"5\",\"group\":\"domain\",\"name\":\"name5\",\"value\":\"http://5abc.com\",\"comment\":\"Tcomment5\",\"updateLog\":[\"name\",\"value\",\"comment\"]},"
				+ "{\"cid\":89019,\"prodid\":6,\"key\":\"6\",\"group\":\"domain\",\"name\":\"name6\",\"value\":\"www.6bcd.com\",\"comment\":\"Tcomment6\",\"updateLog\":[\"name\"]}]";
		String parmcusattrib1="[{\"cid\":89019,\"prodid\":6,\"key\":\"5\",\"group\":\"domain\",\"name\":\"name555\",\"value\":\"http://a5bc.com\",\"updateLog\":[\"name\",\"value\",\"comment\"]},"
				+ "{\"cid\":89019,\"prodid\":6,\"key\":\"6\",\"group\":\"domain\",\"comment\":\"Tcomment66\",\"updateLog\":[\"name\"]}]";
		String parmcusattrib2="[{\"cid\":89019,\"prodid\":6,\"key\":\"5\",\"group\":\"domain\",\"name\":\"name5\",\"value\":\"http://abc.com5\",\"comment\":\"Tcomment5\",\"updateLog\":[\"comment\"]}]";
		String parmcusattrib3 ="[{\"cid\":89019,\"prodid\":4,\"key\":\"1\",\"group\":\"agent\",\"name\":\"AG广告系统旗舰版\",\"value\":\"1\",\"comment\":\"代理商\",\"updateLog\":[\"comment\"]}]";
//		caws.addcusattribs(user2, token2, parmcusattrib3);
//		caws.updatecusattribs(user2, token2, parmcusattrib2);
//		caws.updatecusattribsv1(user2, token2, parmcusattrib2);
		
//		caws.getagentprod(user1, token1, 89019); 
		
		String parmdomain ="[{\"domain\":\"name1\",\"domainIndex\":\"7\" ,\"verified\":\"www.baidu1.com\"},{\"domain\":\"name2\" ,\"domainIndex\":\"8\" ,\"verified\":\"www.test1.com\" }]";
		String parmdomain1 ="[{\"domain\":\"name8\",\"domainIndex\":\"8\",\"verified\":\"www.baidu8.com\"}]";
//		caws.updatedomainlist(user2, token2, 89019, 6, parmdomain1);
//		caws.getdomainlist(user2, token2, 89019, 6);
//		caws.getagcuslist(user1, token1, 89019);
//		

	}

}
