package dsp.usercenter.test;

public class CustomerMgrWebService {
	private String testURL="http://l-bidtest.dev.cn2.corp.agrant.cn:8086/m/customermgr/";
	
	/**
	 * 1 对应的CustomerMgrWebService接口：public CustomerAGWebserviceResp AddCustomerM(CustomerInfocustomer)
	 * @return 后台管理员添加客户cid
	 *  sql :
	 *  param : {"opuid":1,"oproleid":101,"customerInfoDto":
	 *  {"address":"abc","agent":123,"cid":0,"cname":"abc","company":"abc","companytype":"abc","contact":"abc","contactaddress":"abc","deleteflag":1,"domain":"abc","email":"abc","modifier":1,"note1":"abc","status":1,"tel":"abc","url":"abc",
	 *  "domainList":[{"domain":"123","domainIndex":"123","verified":"123"}],
	 *  "updateLog":["cname"]}}
	 */
	public StringBuffer  addcustomerm(String user,String token,String param){
		String params=null;
		params=String.format("%s",param);
		String url=testURL+"addcustomerm.ajax";
		StringBuffer res =interfaceCenter.getInstance(url, interfaceCenter.getMap(user, token), params);
		System.out.println("body:"+params+"\n"+url+"\n"+"headerName: "+user +"\t"+"token: "+token+"\n");
		System.out.println(res);
		return res;	
	}
	
	/**
	 * 2 对应的CustomerMgrWebService接口：public EmailConfigCustomerWebserviceResp AddEmailConfigM(List<string> emailList, int cid, int type)
	 * @return 功能：后台管理员添加email配置信息
	 *  sql :SELECT * from USER_CENTER.EmailConfig WHERE cid=13485;
	 *  param : {"emailList":["abc","def","xyz"],"cid":"100","type":"1"}
	 */
	public StringBuffer  addemailconfigm(String user,String token,String param){
		String params=null;
		params=String.format("%s",param);
		String url=testURL+"addemailconfigm.ajax";
		StringBuffer res =interfaceCenter.getInstance(url, interfaceCenter.getMap(user, token), params);
		System.out.println("body:"+params+"\n"+url+"\n"+"headerName: "+user +"\t"+"token: "+token+"\n");
		System.out.println(res);
		return res;
	}
	
	/**
	 * 3 对应的CustomerMgrWebService接口： public EmailConfigCustomerWebserviceResp AddSubscribeEmailOrPhone(List<EmailPhoneInfo> emailList, int cid, int type)
	 * @return 功能：后天管理员添加email配置信息(email or phone)
	 *  sql :SELECT * from USER_CENTER.EmailConfig WHERE cid=13485;
	 *  param : {"emailList":[{"email":"123456@123","emailindex":"123456"}],"cid":1,"type":1}
	 */
	public StringBuffer  addsubscribeemailorphone(String user,String token,String param){
		String params=null;
		params=String.format("%s",param);
		String url=testURL+"addsubscribeemailorphone.ajax";
		StringBuffer res =interfaceCenter.getInstance(url, interfaceCenter.getMap(user, token), params);
		System.out.println("body:"+params+"\n"+url+"\n"+"headerName: "+user +"\t"+"token: "+token+"\n");
		System.out.println(res);
		return res;
	}
	/**
	 * 4 对应的CustomerMgrWebService接口：public CustomerAGWebserviceResp DeleteCustomerM(int cid)
	 * @return 功能：后台管理员删除客户(实际删除下表中的记录)
	 *  sql : SELECT * from USER_CENTER.CusUserRoleRel WHERE cid=15; 
	 *  sql : SELECT * from USER_CENTER.CusProdRel WHERE cid=15;
	 *  param : {"cid":201}
	 */
	public StringBuffer  deletecustomerm(String user,String token,String param){
		String params=null;
		params=String.format("%s",param);
		String url=testURL+"deletecustomerm.ajax";
		StringBuffer res =interfaceCenter.getInstance(url, interfaceCenter.getMap(user, token), params);
		System.out.println("body:"+params+"\n"+url+"\n"+"headerName: "+user +"\t"+"token: "+token+"\n");
		System.out.println(res);
		return res;
	}
	/**
	 * 5 对应的CustomerMgrWebService接口：public EmailConfigCustomerWebserviceResp DeleteEmailConfigM(int cid, int type)
	 * @return 功能：后台管理员删除emailConfig
	 *  sql :SELECT * from USER_CENTER.EmailConfig WHERE cid=13485;
	 *  param : {"cid":100,"type":1}
	 */
	public StringBuffer  deleteemailconfigm(String user,String token,String param){
		String params=null;
		params=String.format("%s",param);
		String url=testURL+"deleteemailconfigm.ajax";
		StringBuffer res =interfaceCenter.getInstance(url, interfaceCenter.getMap(user, token), params);
		System.out.println("body:"+params+"\n"+url+"\n"+"headerName: "+user +"\t"+"token: "+token+"\n");
		System.out.println(res);
		return res;
	}
	/**
	 * 6 对应的CustomerMgrWebService接口： public CustomerListAGWebserviceResp GetAllCustomerM()
	 * @return 功能：后台管理员获取所有客户
	 *  sql : SELECT * from USER_CENTER.CustomerInfo
	 *  param : {}
	 */
	public StringBuffer  getallcustomerm(String user,String token,String param){
		String params=null;
		params=String.format("%s",param);
		String url=testURL+"getallcustomerm.ajax";
		StringBuffer res =interfaceCenter.getInstance(url, interfaceCenter.getMap(user, token), params);
		System.out.println("body:"+params+"\n"+url+"\n"+"headerName: "+user +"\t"+"token: "+token+"\n");
		System.out.println(res);
		return res;
	}
	/**
	 * 7 对应的CustomerMgrWebService接口： public IntegerListAGWebserviceResp GetCidListByUnameM (string userName)
	 * @return 后台管理员通过用户名获取cid列表
	 *  sql :SELECT * from USER_CENTER.CusUserRoleRel; SELECT * from USER_CENTER.UserInfo 
	 *  param :{"username":"nan.wei"}
	 */
	public StringBuffer  getcidListbyunamem(String user,String token,String param){
		String params=null;
		params=String.format("%s",param);
		String url=testURL+"getcidListbyunamem.ajax";
		StringBuffer res =interfaceCenter.getInstance(url, interfaceCenter.getMap(user, token), params);
		System.out.println("body:"+params+"\n"+url+"\n"+"headerName: "+user +"\t"+"token: "+token+"\n");
		System.out.println(res);
		return res;
	}
	/**
	 * 8 对应的CustomerMgrWebService接口： public CusProdRelListAGWebserviceResp GetCusProdRelByCidM(int cid)
	 * @return 后台管理员通过cid获取 CusProRel表内容
	 *  sql : SELECT * from USER_CENTER.CusProdRel WHERE cid =13485 
	 *  param :{"cid":1}
	 */
	public StringBuffer  getcusprodrelbycidm(String user,String token,String param){
		String params=null;
		params=String.format("%s",param);
		String url=testURL+"getcusprodrelbycidm.ajax";
		StringBuffer res =interfaceCenter.getInstance(url, interfaceCenter.getMap(user, token), params);
		System.out.println("body:"+params+"\n"+url+"\n"+"headerName: "+user +"\t"+"token: "+token+"\n");
		System.out.println(res);
		return res;
	}
	/**
	 * 9 对应的CustomerMgrWebService接口： public CustomerAGWebserviceResp GetCustomerByCidM(int cid)
	 * @return功能：后台管理员获取某客户信息
	 *  sql : SELECT * from USER_CENTER.CustomerInfo WHERE cid=99895;
	 *  param :{"cid":1}
	 */
	public StringBuffer  getcustomerbycidm(String user,String token,String param){
		String params=null;
		params=String.format("%s",param);
		String url=testURL+"getcustomerbycidm.ajax";
		StringBuffer res =interfaceCenter.getInstance(url, interfaceCenter.getMap(user, token), params);
		System.out.println("body:"+params+"\n"+url+"\n"+"headerName: "+user +"\t"+"token: "+token+"\n");
		System.out.println(res);
		return res;
	}
	/**
	 * 10 对应的CustomerMgrWebService接口： public CustomerAGWebserviceResp GetCustomerByCustomerNameM(string customerName)
	 * @return功能：后台管理员通过客户名获取客户信息
	 *  sql : SELECT * from USER_CENTER.CustomerInfo WHERE cid=13405;
	 *  param :{"username":"nan.wei"}
	 */
	public StringBuffer  getcustomerbycustomernamem(String user,String token,String param){
		String params=null;
		params=String.format("%s",param);
		String url=testURL+"getcustomerbycustomernamem.ajax";
		StringBuffer res =interfaceCenter.getInstance(url, interfaceCenter.getMap(user, token), params);
		System.out.println("body:"+params+"\n"+url+"\n"+"headerName: "+user +"\t"+"token: "+token+"\n");
		System.out.println(res);
		return res;
	}
	/**
	 * 11 对应的CustomerMgrWebService接口： public CustomerAGWebserviceResp GetCustomerByEmailM (string email)
	 * @return功能：后台管理员通过email获取客户信息
	 *  sql : SELECT * from USER_CENTER.CustomerInfo WHERE email="junfeng.li@agrent.cn"; 
	 *  param :{"email":"12"}
	 */
	public StringBuffer  getcustomerbyemailm(String user,String token,String param){
		String params=null;
		params=String.format("%s",param);
		String url=testURL+"getcustomerbyemailm.ajax";
		StringBuffer res =interfaceCenter.getInstance(url, interfaceCenter.getMap(user, token), params);
		System.out.println("body:"+params+"\n"+url+"\n"+"headerName: "+user +"\t"+"token: "+token+"\n");
		System.out.println(res);
		return res;
	}
	/**
	 * 12 对应的CustomerMgrWebService接口： public CustomerAGWebserviceResp GetCustomerByPhoneM (string phone)
	 * @return功能：后台管理员通过phone获取客户信息
	 *  sql : SELECT * from USER_CENTER.CustomerInfo WHERE tel="13717607700"; 
	 *  param :{"phone":"12"}
	 */
	public StringBuffer  getcustomerbyphonem(String user,String token,String param){
		String params=null;
		params=String.format("%s",param);
		String url=testURL+"getcustomerbyphonem.ajax";
		StringBuffer res =interfaceCenter.getInstance(url, interfaceCenter.getMap(user, token), params);
		System.out.println("body:"+params+"\n"+url+"\n"+"headerName: "+user +"\t"+"token: "+token+"\n");
		System.out.println(res);
		return res;
	}
	/**
	 * 13 对应的CustomerMgrWebService接口： public CustomerListResp GetCustomerInfoByAgencyCidM(int cid)
	 * @return 功能：后天管理员通过 agencycid 获取客户信息
	 *  sql : SELECT * from USER_CENTER.CustomerInfo WHERE agent=13405; 
	 *  param :{"cid":1}
	 */
	public StringBuffer  getcustomerinfobyagencycidm(String user,String token,String param){
		String params=null;
		params=String.format("%s",param);
		String url=testURL+"getcustomerinfobyagencycidm.ajax";
		StringBuffer res =interfaceCenter.getInstance(url, interfaceCenter.getMap(user, token), params);
		System.out.println("body:"+params+"\n"+url+"\n"+"headerName: "+user +"\t"+"token: "+token+"\n");
		System.out.println(res);
		return res;
	}
	/**
	 * 14 对应的CustomerMgrWebService接口： public GetCustomerLicenseByPidMResponse GetCustomerLicenseByPidM(GetCustomerLicenseByPidMRequest request)
	 * @return 功能：后台管理员通过产品ID 获取 customerLicense信息
	 *  sql : SELECT * from USER_CENTER.CusProdRel WHERE productid=7;
	 *  sql开放给 : SELECT * FROM ( (SELECT * FROM USER_CENTER.CusProdRel where productid IN(2,7)) AA LEFT JOIN USER_CENTER.CustomerInfo BB ON AA.cid=BB.cid) ORDER BY AA.cid;

	 *  param :{"pidList":[2,6]}
	 */
	public StringBuffer  getcustomerlicensebypidm(String user,String token,String param){
		String params=null;
		params=String.format("%s",param);
		String url=testURL+"getcustomerlicensebypidm.ajax";
		StringBuffer res =interfaceCenter.getInstance(url, interfaceCenter.getMap(user, token), params);
//		System.out.println("body:"+params+"\n"+url+"\n"+"headerName: "+user +"\t"+"token: "+token+"\n");
		System.out.println(res);
		return res;
	}
	/**
	 * 15 对应的CustomerMgrWebService接口：public CustomerListAGWebserviceResp GetCustomerListByCidListM(List<int> cidList)
	 * @return 功能：后台管理员通过多个cid 获取客户信息
	 *  sql : SELECT * from USER_CENTER.CustomerInfo WHERE cid=13485; 
	 *  param : {"cidList":[0,1,11,15]}
	 */
	public StringBuffer  getcustomerlistbycidlistm(String user,String token,String param){
		String params=null;
		params=String.format("%s",param);
		String url=testURL+"getcustomerlistbycidlistm.ajax";
		StringBuffer res =interfaceCenter.getInstance(url, interfaceCenter.getMap(user, token), params);
		System.out.println("body:"+params+"\n"+url+"\n"+"headerName: "+user +"\t"+"token: "+token+"\n");
		System.out.println(res);
		return res;
	}
	/**
	 * 16 对应的CustomerMgrWebService接口：public CustomerListAGWebserviceResp GetCustomerListByUserNameM(string userName)
	 * @return 功能：后台管理员通过客户名称获取客户信息
	 *  sql : SELECT * from USER_CENTER.CustomerInfo WHERE cname="nan.wei";
	 *  param : {"cname":"nan.wei"}
	 */
	public StringBuffer  getcustomerlistbycustomernamem(String user,String token,String param){
		String params=null;
		params=String.format("%s",param);
		String url=testURL+"getcustomerlistbycustomernamem.ajax";
		StringBuffer res =interfaceCenter.getInstance(url, interfaceCenter.getMap(user, token), params);
		System.out.println("body:"+params+"\n"+url+"\n"+"headerName: "+user +"\t"+"token: "+token+"\n");
		System.out.println(res);
		return res;
	}
	/**
	 * 17 对应的CustomerMgrWebService接口：public CustomerAGWebserviceResp GetCustomerByEmailM (string email)
	 * @return 功能：后台管理员通过email 获取客户信息
	 *  sql : SELECT * from USER_CENTER.CustomerInfo WHERE email="nan.wei@agrant.cn";
	 *  param : {"email":"12"} 
	 */
	public StringBuffer  getcustomerlistbymailm(String user,String token,String param){
		String params=null;
		params=String.format("%s",param);
		String url=testURL+"getcustomerlistbymailm.ajax";
		StringBuffer res =interfaceCenter.getInstance(url, interfaceCenter.getMap(user, token), params);
		System.out.println("body:"+params+"\n"+url+"\n"+"headerName: "+user +"\t"+"token: "+token+"\n");
		System.out.println(res);
		return res;
	}
	/**
	 * 18 对应的CustomerMgrWebService接口： public CustomerAGWebserviceResp GetCustomerByPhoneM (string phone)
	 * @return功能：后台管理员通过phone获取客户信息
	 *  sql : SELECT * from USER_CENTER.CustomerInfo WHERE email="nan.wei@agrant.cn";
	 *  param : {"phone":"12"}
	 */
	public StringBuffer  getcustomerlistbyphonem(String user,String token,String param){
		String params=null;
		params=String.format("%s",param);
		String url=testURL+"getcustomerlistbyphonem.ajax";
		StringBuffer res =interfaceCenter.getInstance(url, interfaceCenter.getMap(user, token), params);
		System.out.println("body:"+params+"\n"+url+"\n"+"headerName: "+user +"\t"+"token: "+token+"\n");
		System.out.println(res);
		return res;
	}
	/**
	 * 19 对应的CustomerMgrWebService接口：public CustomerListAGWebserviceResp GetCustomerListByUserIdAndRodIdM(int userId,int roseId)
	 * @return 功能：后台管理员通过userid和roleid获取客户信息
	 *  sql : SELECT * from USER_CENTER.CusUserRoleRel WHERE uid=6466 and roleid=3;
	 *  param : {"userId":1,"roleId":101}
	 */
	public StringBuffer  getcustomerlistbyuseridandroleidm(String user,String token,String param){
		String params=null;
		params=String.format("%s",param);
		String url=testURL+"getcustomerlistbyuseridandroleidm.ajax";
		StringBuffer res =interfaceCenter.getInstance(url, interfaceCenter.getMap(user, token), params);
		System.out.println("body:"+params+"\n"+url+"\n"+"headerName: "+user +"\t"+"token: "+token+"\n");
		System.out.println(res);
		return res;
	}
	/**
	 * 20 对应的CustomerMgrWebService接口： public CustomerListAGWebserviceResp GetCustomerListByUserIdM(int userId)
	 * @return 功能：后台管理员通过用户ID获取客户列表信息
	 *  sql : SELECT * from USER_CENTER.CusUserRoleRel WHERE uid=10179;
	 *  param：{"userId":1}
	 */
	public StringBuffer  getcustomerlistbyuseridm(String user,String token,String param){
		String params=null;
		params=String.format("%s",param);
		String url=testURL+"getcustomerlistbyuseridm.ajax";
		StringBuffer res =interfaceCenter.getInstance(url, interfaceCenter.getMap(user, token), params);
		System.out.println("body:"+params+"\n"+url+"\n"+"headerName: "+user +"\t"+"token: "+token+"\n");
		System.out.println(res);
		return res;
	}
	/**
	 * 21 对应的CustomerMgrWebService接口： public CusUserRoleRelListAGWebserviceResp GetCustomerListByUserManagerAndRoseIdM(int userId, int roseId)
	 * @return 功能：后台管理员通过manager和roleid获取客户信息
	 * 逻辑 :roid=132、134、139、140 客服或销售主管；roid=137、138  只有这几个cid可以使用其他都获取空
	 *  sql :  SELECT * from USER_CENTER.CusUserRoleRel WHERE roleid=137;
	 *  param：{"userId":1,"roleId":101}
	 */
	public StringBuffer  getcustomerlistbyusermanagerandroleidm(String user,String token,String param){
		String params=null;
		params=String.format("%s",param);
		String url=testURL+"getcustomerlistbyusermanagerandroleidm.ajax";
		StringBuffer res =interfaceCenter.getInstance(url, interfaceCenter.getMap(user, token), params);
		System.out.println("body:"+params+"\n"+url+"\n"+"headerName: "+user +"\t"+"token: "+token+"\n");
		System.out.println(res);
		return res;
	}
	/**
	 * 22 对应的CustomerMgrWebService接口：public CustomerListAGWebserviceResp GetCustomerListByUserNameM(string userName)
	 * @return 功能：后台管理员通过用户名获取客户列表信息
	 *  sql :SELECT t1.*,t2.uname from USER_CENTER.CusUserRoleRel t1 LEFT JOIN USER_CENTER.UserInfo t2 on t1.uid=t2.uid WHERE t2.uname='junfeng.li';
	 *  param：{"username":"nan.wei"}
	 */
	public StringBuffer  getcustomerlistbyusernamem(String user,String token,String param){
		String params=null;
		params=String.format("%s",param);
		String url=testURL+"getcustomerlistbyusernamem.ajax";
		StringBuffer res =interfaceCenter.getInstance(url, interfaceCenter.getMap(user, token), params);
		System.out.println("body:"+params+"\n"+url+"\n"+"headerName: "+user +"\t"+"token: "+token+"\n");
		System.out.println(res);
		return res;
	}
	/**
	 * 23 对应的CustomerMgrWebService接口：public CusUserRoleRelListAGWebserviceResp GetCusUserRoleRelByUserNameM(string userName)
	 * @return 功能：后台管理员通过用户名获取"客户-用户-角色"三元关系
	 *  sql : SELECT t1.*,t2.uname from USER_CENTER.CusUserRoleRel t1 LEFT JOIN USER_CENTER.UserInfo t2 on t1.uid=t2.uid WHERE t2.uname='junfeng.li' ;
	 *  param：{"username":"nan.wei"}
	 */
	public StringBuffer  getcususerrolerelbyusernamem(String user,String token,String param){
		String params=null;
		params=String.format("%s",param);
		String url=testURL+"getcususerrolerelbyusernamem.ajax";
		StringBuffer res =interfaceCenter.getInstance(url, interfaceCenter.getMap(user, token), params);
		System.out.println("body:"+params+"\n"+url+"\n"+"headerName: "+user +"\t"+"token: "+token+"\n");
		System.out.println(res);
		return res;
	}
	/**
	 * 24 对应的CustomerMgrWebService接口： public EmailConfigListResp GetEmailConfigListByCidAndTypeM(int cid,int type)
	 * @return 功能：后台管理员通过cid和type 获取email配置信息
	 *  sql : SELECT * from USER_CENTER.EmailConfig WHERE cid=13485 and type=1;
	 *  param：{"cid":211,"type":1}
	 */
	public StringBuffer  getemailconfiglistbycidandtypem(String user,String token,String param){
		String params=null;
		params=String.format("%s",param);
		String url=testURL+"getemailconfiglistbycidandtypem.ajax";
		StringBuffer res =interfaceCenter.getInstance(url, interfaceCenter.getMap(user, token), params);
		System.out.println("body:"+params+"\n"+url+"\n"+"headerName: "+user +"\t"+"token: "+token+"\n");
		System.out.println(res);
		return res;
	}
	/**
	 * 25 对应的CustomerMgrWebService接口： public BoolAGWebserviceResp IsCnameExistM(string customerName)
	 * @return 功能：以后台管理员身份，检测客户名是否存在
	 *  sql : 
	 *  param：{"customername":"nan.wei"}
	 */
	public StringBuffer  iscnameexistm(String user,String token,String param){
		String params=null;
		params=String.format("%s",param);
		String url=testURL+"iscnameexistm.ajax";
		StringBuffer res =interfaceCenter.getInstance(url, interfaceCenter.getMap(user, token), params);
		System.out.println("body:"+params+"\n"+url+"\n"+"headerName: "+user +"\t"+"token: "+token+"\n");
		System.out.println(res);
		return res;
	}
	/**
	 * 26 对应的CustomerMgrWebService接口： public UpdateCustomerMV1Response UpdateCustomerMV2 (UpdateCustomerMV1Request customerReq)
	 * @return 功能：更新客户信息
	 *  sql : SELECT * from USER_CENTER.CustomerInfo WHERE cid =211;  SELECT * from USER_CENTER.CusAttrib WHERE cid =211;
	 *  param："customerInfoV1Dto":{"address":"abc","agent":123,"cid":0,"cname":"abc","company":"abc","companytype":"abc","contact":"abc","contactaddress":"abc","deleteflag":1,"domain":"abc","email":"abc","modifier":1,"note1":"abc","status":1,"tel":"abc","url":"abc","domainList":[{"domain":"123","domainIndex":"123","verified":"123"}],"updateLog":["cname"]}}
	 */
	public StringBuffer  updatecustomermv2(String user,String token,String param){
		String params=null;
		params=String.format("%s",param);
		String url=testURL+"updatecustomermv2.ajax";
		StringBuffer res =interfaceCenter.getInstance(url, interfaceCenter.getMap(user, token), params);
		System.out.println("body:"+params+"\n"+url+"\n"+"headerName: "+user +"\t"+"token: "+token+"\n");
		System.out.println(res);
		return res;
	}
	/**
	 * 27 对应的CustomerMgrWebService接口： public EmailConfigCustomerWebserviceResp UpdateSubscribeEmailOrPhone(List<EmailPhoneInfo> emailList, int cid, int type)
	 * @return 功能：后台管理员更新email配置信息
	 *  sql : SELECT * from USER_CENTER.EmailConfig WHERE cid=13485 and type=1
	 *  param：{"emailPhoneInfoDtoList":[{"email":"tyhjklkjhg","emailindex":0}],"cid":0,"type":1}
	 */
	public StringBuffer  updatesubscribeemailorphone(String user,String token,String param){
		String params=null;
		params=String.format("%s",param);
		String url=testURL+"updatesubscribeemailorphone.ajax";
		StringBuffer res =interfaceCenter.getInstance(url, interfaceCenter.getMap(user, token), params);
		System.out.println("body:"+params+"\n"+url+"\n"+"headerName: "+user +"\t"+"token: "+token+"\n");
		System.out.println(res);
		return res;
	}
	
	
	

	public static void main(String[] args) {
		CustomerMgrWebService cmws = new CustomerMgrWebService();
		String user1="junfeng.li";
		String token1 =_getToken.getInstance("junfeng.li", "12345678", 6);
		String user2="lijunfeng149@sina.com";
		String token2 =_getToken.getInstance(user2, "12345678", 6);
		String user3 ="lijunfeng6@sina.com";
		String token3=_getToken.getInstance(user3, "12345678", 6);
		String userS="smanage";
		String tokenS =_getToken.getInstance(userS, "71ad3b8f53491648d4074bdebdda7ab0", 6);
//   1~10		
//		String paramAddcustomerm ="{\"opuid\":10032,\"oproleid\":101,\"customerInfoDto\":{\"address\":\"公司地址\",\"agent\":10,\"cid\":17000,\"cname\":\"lijunfengTest\",\"company\":\"公司名称\",\"companytype\":\"广告主\",\"contact\":\"联系人\",\"contactaddress\":\"联系人地址\",\"deleteflag\":1,\"domain\":\"www.test.com\",\"email\":\"lijunfengTest@sina.com\",\"modifier\":6466,\"note1\":\"NOT1\",\"status\":0,\"tel\":\"13717607755\",\"url\":\"www.url.com\",\"domainList\":[{\"domain\":\"www.domain1.com\",\"domainIndex\":\"1\",\"verified\":\"0\"}],\"updateLog\":[\"cname\"]}}";
//		cmws.addcustomerm(userS, tokenS, paramAddcustomerm);//??????????????
//		String paramAddemaileonfigm="{\"emailList\":[\"lijunfeng1\",\"lijunfeng2\",\"lijunfeng3\"],\"cid\":\"13485\",\"type\":\"1\"}" ;
//		cmws.addemailconfigm(user1, token1, paramAddemaileonfigm); 
//		String paramAddsubscribeemailorphone="{\"emailList\":[{\"email\":\"lijunfeng1@sina.com\",\"emailindex\":\"0\"}],\"cid\":13485,\"type\":2}";
//		cmws.addsubscribeemailorphone(user1, token1, paramAddsubscribeemailorphone);
		
		cmws.deletecustomerm(userS, tokenS, "{\"cid\":15 }");
//		cmws.deleteemailconfigm(user1, token1,"{\"cid\":13485,\"type\":1}");
//		cmws.getallcustomerm(user1, token1, "{}");
//		cmws.getcidListbyunamem(user1, token1, "{\"username\":\"mengping.lin\"}");
//		cmws.getcusprodrelbycidm(user1, token1, "{\"cid\":13485}"); 
//		cmws.getcustomerbycidm(user1, token1, "{\"cid\":998951}");
//		cmws.getcustomerbycustomernamem(user1, token1, "{\"customer\":\"OEM代理商_test_百度退\"}");//BUG 参数错误
//        11 ~20
//		cmws.getcustomerbyemailm(user1, token1, "{\"email\":\"junfeng.li2@agrant.cn\"}"); 
//		cmws.getcustomerbyphonem(user1, token1,"{\"phone\":\"13717607755\"}");
//		cmws.getcustomerinfobyagencycidm(user1, token1, "{\"cid\":-1}"); 
//		cmws.getcustomerlicensebypidm(user1, token1, "{\"pidList\":[2,4,7]}");
//		cmws.getcustomerlistbycidlistm(user1, token1,"{\"cidList\":[1348511,90511,1340511]}");
//		cmws.getcustomerlistbycustomernamem(userS, tokenS, "{\"cname\":\"lijunfeng50@sina.com\"}");
//		cmws.getcustomerlistbymailm(userS, tokenS, "{\"email\":\"junfeng.li@agrant.cn\"}");
//		cmws.getcustomerlistbyphonem(user1, token1, "{\"phone\":\"13717607755\"}");
//		cmws.getcustomerlistbyuseridandroleidm(user1, token1, "{\"userId\":6466,\"roleId\":3}");
//		cmws.getcustomerlistbyuseridm(user1, token1, "{\"userId\":10179}");
//21~30		
//		cmws.getcustomerlistbyusermanagerandroleidm(user1, token1, "{\"userId\":5913,\"roleId\":131}");  //BUG 获取的cid和webservice的cid、数据项不一致、 当roleId=137则数据库错误
//		cmws.getcustomerlistbyusernamem(user1, token1, "{\"username\":\"junfeng.li\"}");//????BUG使用该username拿不到cid 但是webserivce接口可以
//		cmws.getcususerrolerelbyusernamem(user1, token1, "{\"username\":\"junfeng.li\"}");//BUG  roleId获取不到
//		cmws.getemailconfiglistbycidandtypem(user1, token1, "{\"cid\":13485,\"type\":1}");
//		cmws.iscnameexistm(user1, token1, "{\"customername\":\"乐蜂\"}");
		
//		String paramUpdatecustomermv2 ="{\"customerInfoV1Dto\":{\"address\":\"addresss\",\"agent\":-1,\"cid\":211,\"cname\":\"cnamee12321\",\"company\":\"companyyyy\",\"companytype\":\"广告主\",\"contact\":\"contactt\",\"contactaddress\":\"contactaddresss\",\"deleteflag\":0,\"domain\":\"www.domainzTESD.com\",\"email\":\"email@sina.com\",\"modifier\":6466,\"note1\":\"note1\",\"status\":0,\"tel\":\"13717607789\",\"url\":\"www.url.com\",\"domainList\":[{\"domain\":\"www.111.com\",\"domainIndex\":\"1\",\"verified\":\"11110\"}],\"updateLog\":[\"cname\",\"agent\"]}}";
//		cmws.updatecustomermv2(userS, tokenS, paramUpdatecustomermv2); //???????BUG deleteflag不能修改； domain参数不应该存在  domainlist不能插入，只能修改
		
//		cmws.updatesubscribeemailorphone(user1, token1, "{\"emailPhoneInfoDtoList\":[{\"email\":\"lijunfeng4@sina.com\",\"emailindex\":0}],\"cid\":13485,\"type\":1}");
	
	}
}
