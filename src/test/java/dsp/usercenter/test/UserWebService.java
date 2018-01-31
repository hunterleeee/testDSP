package dsp.usercenter.test;

import java.util.HashMap;
import java.util.Map;

import com.Interface.baseHttpClient;

public class UserWebService {
	private String testURL ="http://l-bidtest.dev.cn2.corp.agrant.cn:8086/n/user/";
	private baseHttpClient bhc = new baseHttpClient();
	public Map <String,String> headers =new HashMap<String, String>();

	public UserWebService(){
		headers.put("Content-Type", "application/json");
		headers.put("X-NAME", "junfeng.li");
		headers.put("X-TOKEN", "ce334fa1e636f1c160f7cbf46a604e29");
	}
	
	public StringBuffer  testInter(String interMedthod,String params){
		String url =testURL+interMedthod;
		StringBuffer res =bhc.doPost(url, headers, params);
		System.out.println(res);
		return res;
	}
	public StringBuffer  testInterNoHeader(String interMedthod,Map<String,String> header,String params){
		String url =testURL+interMedthod;
		StringBuffer res =bhc.doPost(url, header, params);
		System.out.println(res);
		return res;
	}
	
	/**
	 *  1对应的UserWebService接口：public LoginStatus ValidateUserWithProduct(int pid)
	 * @return 验证用户，同时返回用户可访问的客户及该用户在客户上的角色，该客户拥有的当前产品的License
	 */
	public StringBuffer  validatewithproduct(String name,String token,int pid){
		String params=null;  //6 \7\9\10\20\999
		params= String.format("{\"pid\":%d}", pid);
		System.out.println("Header : "+name+"\t"+token+"\r\nparams : "+params);
		System.out.println(testURL+"validatewithproduct.ajax");
		StringBuffer res =this.testInterNoHeader("validatewithproduct.ajax", interfaceCenter.getMap(name, token),params);
//		System.out.println(params);
		return res;
	}
	
	/**
	 * 2对应的UserWebService接口：public LoginStatus ValidateUserWithProductChain(int pid)
	 * @return 验证用户，同时返回用户可访问的客户及该用户在客户上的角色，该客户拥有的当前产品及父产品的License
	 * SQL：
	 *  SELECT t2.cid,t4.cname,t3.roleid,t3.invitestatus,t1.productid,t2.starttime,t2.endtime from USER_CENTER.ProductRel t1 
	 *   left JOIN USER_CENTER.CusProdRel t2 on t1.productid=t2.productid
	 *   	LEFT JOIN USER_CENTER.CusUserRoleRel t3 ON t3.cid=t2.cid
	 *   	LEFT JOIN USER_CENTER.CustomerInfo t4 ON t3.cid=t4.cid
	 *   	WHERE t1.childproductid=2 and t3.uid=6466 ORDER BY  t2.cid,t3.roleid,t3.invitestatus,t1.productid
 显示父子关系
	 */
	public StringBuffer  validatewithpc(String name,String token,int pid){
		String params=null;  //6 \7\9\10\20\999
		params= String.format("{\"pid\":%d}", pid);
		System.out.println(name+"\t"+token+"\n"+params);
		System.out.println(testURL+"validatewithpc.ajax");
		StringBuffer res =this.testInterNoHeader("validatewithpc.ajax",interfaceCenter.getMap(name, token), params);
		return res;
	}
	
	/**
	 * 3对应的UserWebService接口：public CheckStatus ValidateUserWithCid(int cid)
	 * @return 验证用户是否对某客户有访问权限
	 */
	public StringBuffer  validatewithcid(String name,String token,int cid){
		String params=null;  //6 \7\9\10\20\999
		params=String.format("{\"cid\":%d}",cid);  //0 905 9 201 13407
		StringBuffer res =this.testInterNoHeader("validatewithcid.ajax",interfaceCenter.getMap(name, token), params);
		return res;
	}
	
	/**
	 * 4对应的UserWebService接口：public UserAGWebserviceResp GetUserInfo()
	 * @return 获取用户信息
	 */
	public StringBuffer  getuserinfo(String name,String token){
		String params="{}"; 
		Map <String,String> header =new HashMap<String, String>();
		header.put("Content-Type", "application/json");
		header.put("X-NAME",name);
		header.put("X-TOKEN", token);
		StringBuffer res =this.testInterNoHeader("getuserinfo.ajax",header, params);
		return res;
	}
	
	/**
	 *5 对应的UserWebService接口：public StringAGWebserviceResp GetRoleName(int roleid)
	 * @param  
	 * @return获取roleId对应角色名称
	 */
	public StringBuffer  getrolename(String name, String token,int roleid){
		Map <String,String> header =new HashMap<String, String>();
		header.put("Content-Type", "application/json");
		header.put("X-NAME",name);
		header.put("X-TOKEN", token);
		String params=null;
		params =String.format("{\"roleid\":%d}", roleid);
		StringBuffer res =this.testInterNoHeader("getrolename.ajax", header,params);
		return res;
	}
	
	/**
	 * 6 对应的UserWebService接口：public CusUserRoleRelAGWebserviceResp DeleteCusUserRoleRel(int uid, int cid)
	 * @param  
	 * @return根椐cid、uid，删除"客户-用户-角色"三元关系。 删除用户-客户-角色关系，只有角色是管理员，操作员，观察员的关系才能被删除。 删除owner，dealer对应关系，会返回错误码NO_AUTHORITY（没有权限）
	 */
	public StringBuffer  deleterel(String name, String token,int cid,int uid){
		Map <String,String> header =new HashMap<String, String>();
		header.put("Content-Type", "application/json");
		header.put("X-NAME",name);
		header.put("X-TOKEN", token);
		String params=null;
		params =String.format("{\"cid\":%d,\"uid\":%d}", cid,uid);
		System.out.println("Header : "+name+"\t"+token+"\nParams : "+params);
		StringBuffer res =this.testInterNoHeader("deleterel.ajax", header,params);
		return res;
	}
	
	/**
	 * 7 对应的UserWebService接口： public UserAGWebserviceResp UpdatePassword(string password)
	 * @param  
	 * @return 更新password
	 */
	public StringBuffer  updatepassword(String name, String token,String passwd){
		Map <String,String> header =new HashMap<String, String>();
		header.put("Content-Type", "application/json");
		header.put("X-NAME",name);
		header.put("X-TOKEN", token);
		String params=null;
		params =String.format("{\"password\":%s}",passwd);
		StringBuffer res =this.testInterNoHeader("updatepassword.ajax", header,params);
		return res;
	}
	
	/**
	 * 8 对应的UserWebService接口：public UserAGWebserviceResp UpdateLastLoginTime()
	 * @param  
	 * @return 更新最后登录时间
	 */
	public StringBuffer  updatelastlogintime(String name, String token){
		Map <String,String> header =new HashMap<String, String>();
		header.put("Content-Type", "application/json");
		header.put("X-NAME",name);
		header.put("X-TOKEN", token);
		String params="{}";
		StringBuffer res =this.testInterNoHeader("updatelastlogintime.ajax", header,params);
		return res;
	}
	
	/**
	 * 9 对应的UserWebService接口：public StringAGWebserviceResp GetUserNote1(int userId)
	 * @param  
	 * @return 取出用户note1
	 */
	public StringBuffer  getusernote1(String name, String token,int uid){
		Map <String,String> header =new HashMap<String, String>();
		header.put("Content-Type", "application/json");
		header.put("X-NAME",name);
		header.put("X-TOKEN", token);
		String params=null;
		params=String.format("{\"uid\":%d}", uid);
		StringBuffer res =this.testInterNoHeader("getusernote1.ajax", header,params);
		return res;
	}
	
	/**
	 * 10 对应的UserWebService接口：public BoolAGWebserviceResp SetUserNote1(int userId, string note)
	 * @param  
	 * @return 更新UserInfo表中的note1
	 */
	public StringBuffer  updateusernote1(String name, String token,int uid,String note1){
		Map <String,String> header =new HashMap<String, String>();
		header.put("Content-Type", "application/json");
		header.put("X-NAME",name);
		header.put("X-TOKEN", token);
		String params=null;
		params=String.format("{\"uid\":%d,\"note1\":\"%s\"}", uid,note1);
		StringBuffer res =this.testInterNoHeader("updateusernote1.ajax", header,params);
		return res;
	}

	/**
	 * 11 对应的UserWebService接口：public UserListAGWebserviceResp2 GetUserInfoByUserIds(List<int> userIds)
	 * SELECT * from USER_CENTER.CusUserRoleRel WHERE cid=0 and roleid in (101,102,103) ;包头中的user符合sql的可以查看用户信息
	 * @return 管理员批量获取用户信息,
	 *  */
	public StringBuffer  getuserinfobyuids(String name, String token,String uidList){
		Map <String,String> header =new HashMap<String, String>();
		header.put("Content-Type", "application/json");
		header.put("X-NAME",name);
		header.put("X-TOKEN", token);
		String params=null;
		params=String.format("{\"userIds\":[%s]}", uidList);
		StringBuffer res =this.testInterNoHeader("getuserinfobyuids.ajax", header,params);
		return res;
	}
	
	/**
	 * 12 对应的UserWebService接口：public BoolAGWebserviceResp SetCusUserRoleRelNote1(int cid, int uid, string note)
	 * @param  
	 * @return 更新CusUserRoleRel表中的note1
	 */
	public StringBuffer  updatecurnote1(String name, String token, int cid,int uid,String note1){
		Map <String,String> header =new HashMap<String, String>();
		header.put("Content-Type", "application/json");
		header.put("X-NAME",name);
		header.put("X-TOKEN", token);
		String params=null;
		params=String.format("{\"cid\":%d,\"uid\":%d,\"note1\":\"%s\"}",cid,uid,note1);
		StringBuffer res =this.testInterNoHeader("updatecurnote1.ajax", header,params);
		return res;
	}
	
	/**
	 * 13 对应的UserWebService接口：CusUserRoleRelListWebserviceResp GetCusUserRoleRelListByCurrs(List<CusUserRoleRel> cusUserRoleRels)
	 * @param  
	 * @return 获取"客户-用户-角色"三元关系
	 */
	public StringBuffer  getcurrelbycurrs(String name, String token, String CUid){
		Map <String,String> header =new HashMap<String, String>();
		header.put("Content-Type", "application/json");
		header.put("X-NAME",name);
		header.put("X-TOKEN", token);
		String params=null;
		params=String.format("{\"cusUserRoleRels\":%s}",CUid);
		System.out.println("header : "+name+"\t"+token+"\nparams : "+params);
		StringBuffer res =this.testInterNoHeader("getcurrelbycurrs.ajax", header,params);
		return res;
	}
	
	/**
	 * 14 对应的UserWebService接口：public CusUserRoleRelListAGWebserviceResp GetCusUserRoleRelListByCid(int cid)
	 * @param  貌似需要header中的user是cid的管理员
	 * @return 根据cid，获取"客户-用户-角色"三元关系
	 */
	public StringBuffer  getcurrelbycid(String name, String token, int cid){
		Map <String,String> header =new HashMap<String, String>();
		header.put("Content-Type", "application/json");
		header.put("X-NAME",name);
		header.put("X-TOKEN", token);
		String params=null;
		params=String.format("{\"cid\":%d}",cid);
		String url = testURL+"getcurrelbycid.ajax";
		System.out.println("Header: "+name +"\t"+token+"\nparam : "+params+"\nUrl : "+url );
		StringBuffer res =this.testInterNoHeader("getcurrelbycid.ajax", header,params);
		return res;
	}
	
	/**
	 * 15 对应的UserWebService接口：public CusUserRoleRelAGWebserviceResp UpdateUserRole(int uid, int cid, int rid)
	 * @param  貌似需要header中的user该参数cid的1\2\3角色,参数中的uid可以设置为 3/4/5
	 * @return 更新user role
	 */
	public StringBuffer  updateuserrole(String name, String token, int cid,int roleid,int uid){
		Map <String,String> header =new HashMap<String, String>();
		header.put("Content-Type", "application/json");
		header.put("X-NAME",name);
		header.put("X-TOKEN", token);
		String params=null;
		params=String.format("{\"cid\":%d,\"roleid\":%d,\"uid\":%d}",cid,roleid,uid);
		StringBuffer res =this.testInterNoHeader("updateuserrole.ajax", header,params);
		return res;
	}
	
	/**
	 * 16 对应的UserWebService接口：public UserAGWebserviceResp UpdateUserInfoV1(UserInfo userInfo)
	 * @param  
	 * @return 更新用户信息，不能更新密码。
	 */
	public StringBuffer  updateuserinfo(String name, String token ,int uid,String tel){
		Map <String,String> header =new HashMap<String, String>();
		header.put("Content-Type", "application/json");
		header.put("X-NAME",name);
		header.put("X-TOKEN", token);
		String params=null;
		params=String.format("{\"userInfo\":{\"uid\":%d,\"telephone\":\"%s\"}}",uid,tel);
		System.out.println(params);
		StringBuffer res =this.testInterNoHeader("updateuserinfo.ajax", header,params);
		return res;
	}
	
	/**
	 * 17 对应的UserWebService接口：public KeyStatus ValidKeyForResetPasswordM(string key, string username)
	 * @return 验证重置密码的key是否有效 
	 *  sql :  SELECT * from USER_CENTER.FindPassword
	 */
	public StringBuffer  validkey(String user,String token,String pkey,String username){
		String params=null;
		params=String.format("{\"key\":\"%s\",\"username\":\"%s\"}",pkey,username);
		String url=testURL+"validkey.ajax";
		StringBuffer res =interfaceCenter.getInstance(url, interfaceCenter.getMap(user, token), params);
		System.out.println("body:"+params+"\n"+url+"\n"+"headerName: "+user +"\t"+"token: "+token+"\n");
		System.out.println(res);
		return res;
//		{"key":"a3a77b5b40633034c5fe9da8eb76a5fa","username":"zhangbin"}
	
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String user1="junfeng.li";
		String token1 = _getToken.getInstance(user1, "12345678", 6);
		String user2="lijunfeng149@sina.com";
		String token2 = _getToken.getInstance(user2, "12345678", 6);
		UserWebService uct =new UserWebService();
		
		uct.validatewithproduct(user1,token1,1);
//		uct.validatewithpc(user1,token1,2); //BUG使用6466的用户 
//		uct.validatewithcid(user1,token1,905);
//		uct.getuserinfo("lijunfeng149@sina.com","a5997e0685df6e7dd98d03e3021ec88c");//("junfeng.li","61b9b0ab610bd938574a5b0f35c39bac");
//		uct.getrolename("lijunfeng149@sina.com","a5997e0685df6e7dd98d03e3021ec88c",1);//SELECT * from USER_CENTER.RoleInfo; 错误输入返回null？？？
//		uct.deleterel(user2,token2,89019,6466);//("junfeng.li","ce334fa1e636f1c160f7cbf46a604e29",905,6466);
//		uct.updatepassword(user1,token1,"12345678"); 
//		uct.updatelastlogintime("junfeng.li","61b9b0ab610bd938574a5b0f35c39bac");
//		uct.getusernote1("junfeng.li","61b9b0ab610bd938574a5b0f35c39bac",10042);//6466\10042\60
//		uct.updateusernote1("junfeng.li","61b9b0ab610bd938574a5b0f35c39bac",18,"BAIDU_ACCOUNT_ADDING_UNLIMIT");
//		uct.getuserinfobyuids("junfeng.li","61b9b0ab610bd938574a5b0f35c39bac","1234");
//		uct.updatecurnote1(user1,token1,10542,6466,"TESTNote1");
//		uct.getcurrelbycurrs(user1, token1,"[{\"cid\":10542,\"uid\":6524}]");  //,{\"cid\":10542,\"uid\":6524}    bug:roleId没有获取  部分项可以包括在参数中wiki没有写：如cname、tel、email、userName、roleId
//		uct.getcurrelbycid(user1, token1, 13485); //BUG获取不到三元关系  BUG获取的项与旧接口不一致
//		uct.updateuserrole(user1, token1, 13485,3,1987915);
//		uct.updateuserinfo(user1, token1,6466,"13717607655");
//		uct.validkey(user1, token1,  "d4b5fabc0d3676d461556f73e72ee560", user1);
	}

} 
