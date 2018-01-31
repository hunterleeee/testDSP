package dsp.usercenter.test;

public class UserMgrWebService {
	private String testURL="http://l-bidtest.dev.cn2.corp.agrant.cn:8086/m/usermgr/";

	/**
	 * 1 对应的UserMgrWebService接口：public UserAGWebserviceResp AddUserM(UserInfo userInfo)
	 * @return 后台管理员添加用户信息
	 *  sql : SELECT * from USER_CENTER.UserInfo WHERE uname='testjunfeng1';
	 *  {"userInfo":{\"uname\":\"testjunfeng1\",\"password\":\"123456\",\"contact\":\"Contact\",\"email\":\"lijunfeng@sina.com\",\"telephone\":13717607755,\"manager\":999}}
	 */
	public StringBuffer  adduserm(String user,String token,String param){
		String params=null;
		params=String.format("{\"userInfo\":%s}",param);
		String url=testURL+"adduserm.ajax";
		StringBuffer res =interfaceCenter.getInstance(url, interfaceCenter.getMap(user, token), params);
		System.out.println("body:"+params+"\n"+url+"\n"+"headerName: "+user +"\t"+"token: "+token+"\n");
		System.out.println(res);
		return res;
		
	}
	/**
	 * 2 对应的UserMgrWebService接口：public InviteResult AcceptInviteM(string domain, string invitecode, int uid)
	 * @return 以后台管理员身份，接受邀请三元关系要求
	 *  sql : ?????  SELECT * from AGWeb.InviteUserInfo
	 *  {"uid":123,"invitecode":"test","domain":"wwwww"}
	 */
	public StringBuffer  acceptinvitem(String user,String token,int uid, String invitecode,String domain){
		String params=null;
		params=String.format("{\"uid\":%d,\"invitecode\":\"%s\",\"domain\":\"%s\"}",uid,invitecode,domain);
		String url=testURL+"acceptinvitem.ajax";
		StringBuffer res =interfaceCenter.getInstance(url, interfaceCenter.getMap(user, token), params);
		System.out.println("body:"+params+"\n"+url+"\n"+"headerName: "+user +"\t"+"token: "+token+"\n");
		System.out.println(res);
		return res;
//		{"uid":123,"invitecode":"test","domain":"wwwww"}
	}
	/**
	 * 3 对应的UserMgrWebService接口：public CusUserRoleRelAGWebserviceResp AssignUserM(int uid, int cid, int rid)
	 * @return 后台管理员添加"客户-用户-角色"三元关系
	 *  sql : SELECT * from USER_CENTER.CusUserRoleRel WHERE uid=6524;
	 */
	public StringBuffer  assignuserm(String user,String token,int cid,int uid,int rid){
		String params=null;
		params=String.format("{\"cid\":%d,\"uid\":%d,\"rid\":%d}",cid,uid,rid);
		String url=testURL+"assignuserm.ajax";
		StringBuffer res =interfaceCenter.getInstance(url, interfaceCenter.getMap(user, token), params);
		System.out.println("body:"+params+"\n"+url+"\n"+"headerName: "+user +"\t"+"token: "+token+"\n");
		System.out.println(res);
		return res;
//		{"cid":4,"uid":123,"rid":6}
	}
	/**
	 * 4 对应的UserMgrWebService接口：public CusUserRoleRelAGWebserviceResp AssignUserListM(int userId, int[] cidList, int roleId)
	 * @return 后台管理员批量添加"客户-用户-角色"三元关系
	 * @param {"cids":[1,2,3],"uid":123,"rid":6}
	 *  sql : SELECT * from USER_CENTER.CusUserRoleRel WHERE uid=6524;
	 */
	public StringBuffer  assignuserlistm(String user,String token,String cids,int uid,int rid){
		String params=null;
		params=String.format("{\"cids\":%s,\"uid\":%d,\"rid\":%d}",cids,uid,rid);
		String url=testURL+"assignuserlistm.ajax";
		StringBuffer res =interfaceCenter.getInstance(url, interfaceCenter.getMap(user, token), params);
		System.out.println("body:"+params+"\n"+url+"\n"+"headerName: "+user +"\t"+"token: "+token+"\n");
		System.out.println(res);
		return res;
	}
	/**
	 * 5 对应的UserMgrWebService接口：public BoolAGWebserviceResp CheckEmailM(string email)
	 * @return 以后台管理员身份，查看邮箱是否存在
	 * @param {"email":"wahaha"}
	 *  sql : SELECT * from USER_CENTER.UserInfo WHERE email ='lijunfeng6@sina.com'
	 *  roleid= 101 102  103 
	 */
	public StringBuffer  checkemailm(String user,String token,String email){
		String params=null;
		params=String.format("{\"email\":\"%s\"}",email);
		String url=testURL+"checkemailm.ajax";
		StringBuffer res =interfaceCenter.getInstance(url, interfaceCenter.getMap(user, token), params);
		System.out.println("body:"+params+"\n"+url+"\n"+"headerName: "+user +"\t"+"token: "+token+"\n");
		System.out.println(res);
		return res;
	}
	/**
	 * 6 对应的UserMgrWebService接口： public BoolAGWebserviceResp CheckUserMobileM(string mobileNumber)
	 * @return 以后台管理员身份，查看手机号码是否存在
	 * @param {"mobileNumber":"110"}
	 *  sql : SELECT * from USER_CENTER.UserInfo WHERE tel='13717607789';

	 */
	public StringBuffer  checkmobilem(String user,String token,String mobileNumber){
		String params=null;
		params=String.format("{\"mobileNumber\":\"%s\"}",mobileNumber);
		String url=testURL+"checkmobilem.ajax";
		StringBuffer res =interfaceCenter.getInstance(url, interfaceCenter.getMap(user, token), params);
		System.out.println("body:"+params+"\n"+url+"\n"+"headerName: "+user +"\t"+"token: "+token+"\n");
		System.out.println(res);
		return res;
	}
	/**
	 * 7 对应的UserMgrWebService接口：  public BoolAGWebserviceResp CheckUserNameM(string userName)
	 * @return 以后台管理员身份，查看用户是否存在
	 * @param {"userName":"zhangbin"}
	 *  sql : SELECT * from USER_CENTER.UserInfo WHERE uname='lijunfeng6';
	 */
	public StringBuffer  checkusernamem(String user,String token,String userName){
		String params=null;
		params=String.format("{\"userName\":\"%s\"}",userName);
		String url=testURL+"checkusernamem.ajax";
		StringBuffer res =interfaceCenter.getInstance(url, interfaceCenter.getMap(user, token), params);
		System.out.println("body:"+params+"\n"+url+"\n"+"headerName: "+user +"\t"+"token: "+token+"\n");
		System.out.println(res);
		return res;
	}
	/**
	 * 8 对应的UserMgrWebService接口：public CusUserRoleRelAGWebserviceResp DelAssignUserM(int uid, int cid)
	 * @return 后台管理员删除"客户-用户-角色"三元关系
	 * @param {"cid":4,"uid":123}
	 *  sql : SELECT * from USER_CENTER.CusUserRoleRel WHERE uid=6524;
	 */
	public StringBuffer  delassignuserm(String user,String token,int cid,int uid){
		String params=null;
		params=String.format("{\"cid\":%d,\"uid\":%d}",cid,uid);
		String url=testURL+"delassignuserm.ajax";
		StringBuffer res =interfaceCenter.getInstance(url, interfaceCenter.getMap(user, token), params);
		System.out.println("body:"+params+"\n"+url+"\n"+"headerName: "+user +"\t"+"token: "+token+"\n");
		System.out.println(res);
		return res;
	}
	/**
	 * 9 对应的UserMgrWebService接口：public CusUserRoleRelAGWebserviceResp DeleteUserM(int uid)
	 * @return 后台管理员删除"客户-用户-角色"三元关系
	 * @param {"userId":123456}
	 *  sql : SELECT * from USER_CENTER.CusUserRoleRel WHERE uid=1987894;
	 */
	public StringBuffer  deluserm(String user,String token,int uid){
		String params=null;
		params=String.format("{\"userId\":%d}",uid);
		String url=testURL+"deluserm.ajax";
		StringBuffer res =interfaceCenter.getInstance(url, interfaceCenter.getMap(user, token), params);
		System.out.println("body:"+params+"\n"+url+"\n"+"headerName: "+user +"\t"+"token: "+token+"\n");
		System.out.println(res);
		return res;
	}
	/**
	 * 10 对应的UserMgrWebService接口：public BoolAGWebserviceResp DelInviteRelM(string invitecode)
	 * @return 后台管理员通过邀请码删除处于邀请状态的"客户-用户-角色"三元关系
	 * @param {"invitecode":1}
	 *  sql : SELECT * from USER_CENTER.CusUserRoleRel WHERE uid=1987894 invitestatus=1 and invitecode='???';  invitestatus要是1等待状态
	 */
	public StringBuffer  delinviterelm(String user,String token,String invitecode){
		String params=null;
		params=String.format("{\"invitecode\":\"%s\"}",invitecode);
		String url=testURL+"delinviterelm.ajax";
		StringBuffer res =interfaceCenter.getInstance(url, interfaceCenter.getMap(user, token), params);
		System.out.println("body:"+params+"\n"+url+"\n"+"headerName: "+user +"\t"+"token: "+token+"\n");
		System.out.println(res);
		return res;
	}
	/**
	 * 11 对应的UserMgrWebService接口：public IntegerListAGWebserviceResp GetUidArrayByCidM(int cid)
	 * @return 后台管理员根据某客户Id获取所有有访问权限的用户Id
	 * @param {"cid":0}
	 *  sql : SELECT * from USER_CENTER.CusUserRoleRel WHERE cid=89019;
	 */
	public StringBuffer  getuidsbycidm(String user,String token,int cid){
		String params=null;
		params=String.format("{\"cid\":%d}",cid);
		String url=testURL+"getuidsbycidm.ajax";
		StringBuffer res =interfaceCenter.getInstance(url, interfaceCenter.getMap(user, token), params);
		System.out.println("body:"+params+"\n"+url+"\n"+"headerName: "+user +"\t"+"token: "+token+"\n");
		System.out.println(res);
		return res;
	}
	/**
	 * 12 对应的UserMgrWebService接口：public UserAGWebserviceResp GetUserInfoByUserNameM(string username)
	 * @return 后台管理员根据用户名获取用户信息
	 * @param {"username":"hnyuanshi"}
	 *  sql : SELECT * from USER_CENTER.UserInfo WHERE uname='aguser';
	 */
	public StringBuffer  getuserbynamem(String user,String token,String username){
		String params=null;
		params=String.format("{\"username\":\"%s\"}",username);
		String url=testURL+"getuserbynamem.ajax";
		StringBuffer res =interfaceCenter.getInstance(url, interfaceCenter.getMap(user, token), params);
		System.out.println("body:"+params+"\n"+url+"\n"+"headerName: "+user +"\t"+"token: "+token+"\n");
		System.out.println(res);
		return res;
	}
	/**
	 * 13 对应的UserMgrWebService接口：public UserAGWebserviceResp GetUserInfoByEmailM(string email)
	 * @return 后台管理员根据注册邮箱名获取用户信息
	 * @param {"email":"342989952@qq.com"}
	 *  sql : SELECT * from USER_CENTER.UserInfo WHERE email ='lijunfeng6@sina.com';
	 */
	public StringBuffer  getuserbyemailm(String user,String token,String email){
		String params=null;
		params=String.format("{\"email\":\"%s\"}",email);
		String url=testURL+"getuserbyemailm.ajax";
		StringBuffer res =interfaceCenter.getInstance(url, interfaceCenter.getMap(user, token), params);
		System.out.println("body:"+params+"\n"+url+"\n"+"headerName: "+user +"\t"+"token: "+token+"\n");
		System.out.println(res);
		return res;
	}
	/**
	 * 14 对应的UserMgrWebService接口：public UserListAGWebserviceResp GetUserInfoByCidM(int cid)
	 * @return 后台管理员根据客户Id获取关联用户信息
	 * @param {"cid":0}
	 *  sql : SELECT * from USER_CENTER.UserInfo WHERE uid in (SELECT uid from USER_CENTER.CusUserRoleRel WHERE cid=89019);
	 */
	public StringBuffer  getuserbycidm(String user,String token,int cid){
		String params=null;
		params=String.format("{\"cid\":%d}",cid);
		String url=testURL+"getuserbycidm.ajax";
		StringBuffer res =interfaceCenter.getInstance(url, interfaceCenter.getMap(user, token), params);
		System.out.println("body:"+params+"\n"+url+"\n"+"headerName: "+user +"\t"+"token: "+token+"\n");
		System.out.println(res);
		return res;
	}
	/**
	 * 15 对应的UserMgrWebService接口：public UserAGWebserviceResp GetUserInfoByUidM(int userid)
	 * @return 后台管理员通过uid获取用户信息
	 * @param {"uid":123}
	 *  sql : SELECT * from USER_CENTER.UserInfo WHERE uid=6466; 
	 */
	public StringBuffer  getuserbyuidm(String user,String token,int uid){
		String params=null;
		params=String.format("{\"uid\":%d}",uid);
		String url=testURL+"getuserbyuidm.ajax";
		StringBuffer res =interfaceCenter.getInstance(url, interfaceCenter.getMap(user, token), params);
		System.out.println("body:"+params+"\n"+url+"\n"+"headerName: "+user +"\t"+"token: "+token+"\n");
		System.out.println(res);
		return res;
	}
	/**
	 * 16 对应的UserMgrWebService接口：public UserAGWebserviceResp GetUserInfoByUidM(int userid)
	 * @return 后台管理员通过uid获取用户信息
	 * @param{"userIds":[123,0,1,2]}
	 *  sql : SELECT * from USER_CENTER.UserInfo WHERE uid in (6466,1987894); 
	 */
	public StringBuffer  getuserbyuidlistm(String user,String token,String userIds){
		String params=null;
		params=String.format("{\"userIds\":%s}",userIds);
		String url=testURL+"getuserbyuidlistm.ajax";
		StringBuffer res =interfaceCenter.getInstance(url, interfaceCenter.getMap(user, token), params);
		System.out.println("body:"+params+"\n"+url+"\n"+"headerName: "+user +"\t"+"token: "+token+"\n");
		System.out.println(res);
		return res;
	}
	/**
	 * 17 对应的UserMgrWebService接口：   public UserListAGWebserviceResp GetUserListByManagerM(int userid,int roleId)
	 * @return  
	 * @param{"uid":123,"roleId":6}
	 *  sql : SELECT * from USER_CENTER.UserInfo WHERE uid=6466';  

	 */
	public StringBuffer  getuserbymanagerm(String user,String token,String username){
		String params=null;
		params=String.format("%s",username);
		String url=testURL+"getuserbymanagerm.ajax";
		StringBuffer res =interfaceCenter.getInstance(url, interfaceCenter.getMap(user, token), params);
		System.out.println("body:"+params+"\n"+url+"\n"+"headerName: "+user +"\t"+"token: "+token+"\n");
		System.out.println(res);
		return res;
	}
	/**
	 * 18 对应的UserMgrWebService接口：public UserListAGWebserviceResp GetUserInfoListLikeUserNameM(string username)
	 * @return   后台管理员根据用户名称模糊匹配用户信息
	 * @param {"username":"zhang"}
	 *  sql : SELECT * from USER_CENTER.UserInfo WHERE uname like 'junfeng.li';  
	 */
	public StringBuffer  getuserlikenamem(String user,String token,String userIds){
		String params=null;
		params=String.format("{\"username\":\"%s\"}",userIds);
		String url=testURL+"getuserlikenamem.ajax";
		StringBuffer res =interfaceCenter.getInstance(url, interfaceCenter.getMap(user, token), params);
		System.out.println("body:"+params+"\n"+url+"\n"+"headerName: "+user +"\t"+"token: "+token+"\n");
		System.out.println(res);
		return res;
	}
	/**
	 * 19 对应的UserMgrWebService接口：public CusUserRoleRelListAGWebserviceResp GetCusUserRoleRelListByCidM(int cid)
	 * @return   后台管理员根据cid，获取"客户-用户-角色"三元关系
	 * @param {"cid":"0"}
	 *  sql : SELECT * from USER_CENTER.CusUserRoleRel WHERE cid=13485;
	 */
	public StringBuffer  getcurrbycidm(String user,String token,int cid){
		String params=null;
		params=String.format("{\"cid\":%d}",cid);
		String url=testURL+"getcurrbycidm.ajax";
		StringBuffer res =interfaceCenter.getInstance(url, interfaceCenter.getMap(user, token), params);
		System.out.println("body:"+params+"\n"+url+"\n"+"headerName: "+user +"\t"+"token: "+token+"\n");
		System.out.println(res);
		return res;
	}
	/**
	 * 20 对应的UserMgrWebService接口： public CusUserRoleRelListAGWebserviceResp GetCusUserRoleRelListByCidListM(List<int> cidList)
	 * @return   后台管理员根据cid，批量获取"客户-用户-角色"三元关系
	 * @param {"cidList":[0,1]}
	 *  sql : SELECT * from USER_CENTER.CusUserRoleRel WHERE cid in (10542,13485);
	 */
	public StringBuffer  getcurrbycidlistm(String user,String token,String cids){
		String params=null;
		params=String.format("{\"cidList\":%s}",cids);
		String url=testURL+"getcurrbycidlistm.ajax";
		StringBuffer res =interfaceCenter.getInstance(url, interfaceCenter.getMap(user, token), params);
		System.out.println("body:"+params+"\n"+url+"\n"+"headerName: "+user +"\t"+"token: "+token+"\n");
		System.out.println(res);
		return res;
	}
	/**
	 * 21 对应的UserMgrWebService接口：public RoleListAGWebserviceResp GetAllRoleM()
	 * @return    后台管理员获取所有角色ID的信息
	 * @param {}
	 *  sql : SELECT * from USER_CENTER.RoleInfo 
	 */
	public StringBuffer  getallrolem(String user,String token){
		String params=null;
		params=String.format("{}");
		String url=testURL+"getallrolem.ajax";
		StringBuffer res =interfaceCenter.getInstance(url, interfaceCenter.getMap(user, token), params);
		System.out.println("body:"+params+"\n"+url+"\n"+"headerName: "+user +"\t"+"token: "+token+"\n");
		System.out.println(res);
		return res;
	}
	/**
	 * 22 对应的UserMgrWebService接口： public UserListAGWebserviceResp GetAllUserM()
	 * @return   后台管理员根据cid，批量获取"客户-用户-角色"三元关系
	 * @param {}
	 *  sql : SELECT * from USER_CENTER.UserInfo
	 */
	public StringBuffer  getalluserm(String user,String token){
		String params=null;
		params=String.format("{}");
		String url=testURL+"getalluserm.ajax";
		StringBuffer res =interfaceCenter.getInstance(url, interfaceCenter.getMap(user, token), params);
		System.out.println("body:"+params+"\n"+url+"\n"+"headerName: "+user +"\t"+"token: "+token+"\n");
		System.out.println(res);
		return res;
	}
	/**
	 * 23 对应的UserMgrWebService接口：public RoleListAGWebserviceResp GetRoleInfoListBySysIdM(int sysId)
	 * @return  后台管理员根据systemId获取角色列表
	 * @param {"sysId":1}
	 *  sql : SELECT * from USER_CENTER.RoleInfo WHERE sysid =1;
	 */
	public StringBuffer  getrolebysysidm(String user,String token,int sysId){
		String params=null;
		params=String.format("{\"sysId\":%d}",sysId);
		String url=testURL+"getrolebysysidm.ajax";
		StringBuffer res =interfaceCenter.getInstance(url, interfaceCenter.getMap(user, token), params);
		System.out.println("body:"+params+"\n"+url+"\n"+"headerName: "+user +"\t"+"token: "+token+"\n");
		System.out.println(res);
		return res;
	}
	/**
	 * 24 对应的UserMgrWebService接口：public RoleAGWebserviceResp GetRoleInfoByInvitecodeM(string invitecode)
	 * @return  后台管理员通过邀请码获取用户角色信息
	 * @param {"invitecode":"f6c4972fe88f2d0bf7d67a525a5d70f3"}
	 *  sql : SELECT * from USER_CENTER.CusUserRoleRel WHERE invitecode!='';
	 */
	public StringBuffer  getrolebyinvitecodem(String user,String token,String invitecode){
		String params=null;
		params=String.format("{\"invitecode\":\"%s\"}",invitecode);
		String url=testURL+"getrolebyinvitecodem.ajax";
		StringBuffer res =interfaceCenter.getInstance(url, interfaceCenter.getMap(user, token), params);
		System.out.println("body:"+params+"\n"+url+"\n"+"headerName: "+user +"\t"+"token: "+token+"\n");
		System.out.println(res);
		return res;
	}
	/**
	 * 25 对应的UserMgrWebService接口：public InviteResult InviteUserM(string domain, int modifyUid, string unameOrEmail, int cid, int rid)
	 * @return  后台管理员邀请用户加入"客户-用户-角色"三元关系
	 * @param {"domain":"110","modifyUid":11,"unameOrEmail":"bin.zhang@agrant.cn","cid":1,"rid":6}
	 *  sql : SELECT * from USER_CENTER.CusUserRoleRel WHERE cid=89019;
	 */
	public StringBuffer  inviteuserm(String user,String token,String param){
		String params=param;
		String url=testURL+"inviteuserm.ajax";
		StringBuffer res =interfaceCenter.getInstance(url, interfaceCenter.getMap(user, token), params);
		System.out.println("body:"+params+"\n"+url+"\n"+"headerName: "+user +"\t"+"token: "+token+"\n");
		System.out.println(res);
		return res;
	}
	/**
	 * 26 对应的UserMgrWebService接口：public InviteResult ModifyUserInvitM(int uid1, int uid2, int cid, int roleid)
	 * @return  
	 * @param{"uid1":123,"uid2":0,"cid":0,"roleid":6}
	 *  sql : 
	 */
	public StringBuffer  modifyuserinvitm(String user,String token,String param){
		String params=param;
//		params=String.format(param);
		String url=testURL+"modifyuserinvitm.ajax";
		StringBuffer res =interfaceCenter.getInstance(url, interfaceCenter.getMap(user, token), params);
		System.out.println("body:"+params+"\n"+url+"\n"+"headerName: "+user +"\t"+"token: "+token+"\n");
		System.out.println(res);
		return res;
	}
	/**
	 * 27 对应的UserMgrWebService接口：public BoolAGWebserviceResp ResetPasswordByKeyM(string username, string key, string newPsd)
	 * @return  以后台管理员身份，重置密码
	 * key的由来 发送修改密码的邮件同时在USER_CENTER.FindPassword 中生成key（sentvalidemailm），拿到key再次接口中使用
	 * @param{"username":"冰冰小蚂蚁","key":"123","newPsd":"123"}
	 *  sql : SELECT * from USER_CENTER.FindPassword ；  SELECT * from USER_CENTER.UserInfo WHERE uname='349094467'；
	 */
	public StringBuffer  resetpasswordm(String user,String token,String username,String key,String newPsd){
		String params=null;
		params=String.format("{\"username\":\"%s\",\"key\":\"%s\",\"newPsd\":\"%s\"}",username,key,newPsd);
		String url=testURL+"resetpasswordm.ajax";
		StringBuffer res =interfaceCenter.getInstance(url, interfaceCenter.getMap(user, token), params);
		System.out.println("body:"+params+"\n"+url+"\n"+"headerName: "+user +"\t"+"token: "+token+"\n");
		System.out.println(res);
		return res;
	}
	/**
	 * 28 对应的UserMgrWebService接口：public string SentValidEmail(string email, string username, string title, string content,string emailAddress, string emailAddressName, string password)
	 * @return  以后台管理员身份，通过email或用户名申请修改密码，发送修改密码连接的邮件
	 * @param{"email":"bin.zhang@agrant.cn","username":"zhangbin","title":"test","content":"测试邮件","emailAddress":"agsem.mailagent@agrant.cn","emailAddressName":"AnG广告管理平台","password":"3241t123T"}
	 *  sql : SELECT * from USER_CENTER.FindPassword ；
	 */
	public StringBuffer  sentvalidemailm(String user,String token,String param){
		String params=param;
//		params=String.format("{\"username\":\"%s\",\"key\":\"%s\",\"newPsd\":\"%s\"}",username,key,newPsd);
		String url=testURL+"sentvalidemailm.ajax";
		StringBuffer res =interfaceCenter.getInstance(url, interfaceCenter.getMap(user, token), params);
		System.out.println("body:"+params+"\n"+url+"\n"+"headerName: "+user +"\t"+"token: "+token+"\n");
		System.out.println(res);
		return res;
	}
	/**
	 * 29 对应的UserMgrWebService接口：public UserAGWebserviceResp UpdateUserInfoM(UserInfo userInfo)
	 * @return  后台管理员修改用户信息（uname，tel，updatetime，deleteflag，modifier，contact，email），不能修改密码，若想更新密码，请调用ResetUserPasswordM。
	 * @param {"userInfo":{"uname":"zhangbin",”"uid":123,"telephone":"111110"}}
	 *  {"userInfo":{\"uname\":\"349094467\",\"uid\":6685,\"telephone\":\"13717607777\",\"deleteflag\":1,\"contact\":\"李俊峰\",\"manager\":1,\"email\":\"349094467@qq.com\"}}
	 *  sql : SELECT * from USER_CENTER.UserInfo WHERE uname='349094467';
	 */
	public StringBuffer  updateuserinfom(String user,String token,String param){
		String params=null;
		params=String.format("{\"userInfo\":%s}",param);
		String url=testURL+"updateuserinfom.ajax";
		StringBuffer res =interfaceCenter.getInstance(url, interfaceCenter.getMap(user, token), params);
		System.out.println("body:"+params+"\n"+url+"\n"+"headerName: "+user +"\t"+"token: "+token+"\n");
		System.out.println(res);
		return res;
	}
	/**
	 * 30 对应的UserMgrWebService接口：public CusUserRoleRelAGWebserviceResp UpdateUserRoleM(int cid, int userid, int rid)
	 * @return   后台管理员修改"客户-用户-角色"三元关系
	 * @param  {"cid":0,"roleid":6,"uid":123}
	 */
	public StringBuffer  updateuserrolem(String user,String token,int cid, int roleid, int uid){
		String params=null;
		params=String.format("{\"cid\":%d,\"roleid\":%d,\"uid\":%d}",cid,roleid,uid);
		String url=testURL+"updateuserrolem.ajax";
		StringBuffer res =interfaceCenter.getInstance(url, interfaceCenter.getMap(user, token), params);
		System.out.println("body:"+params+"\n"+url+"\n"+"headerName: "+user +"\t"+"token: "+token+"\n");
		System.out.println(res);
		return res;
	}
	/**
	 * 31 对应的UserMgrWebService接口：  public CusUserRoleRelAGWebserviceResp AssignUserWithCreateCustomerM(int uid, int cid, int rid)
	 * @return   
	 * sql：SELECT * from USER_CENTER.CusUserRoleRel WHERE cid=89019 ; 
	 * @param  {"cid":4,"uid":123,"rid":6}
	 */
	public StringBuffer  assignuserrwccm(String user,String token,int cid, int uid, int rid){
		String params=null;
		params=String.format("{\"cid\":%d,\"uid\":%d,\"rid\":%d}",cid,uid,rid);
		String url=testURL+"assignuserrwccm.ajax";
		StringBuffer res =interfaceCenter.getInstance(url, interfaceCenter.getMap(user, token), params);
		System.out.println("body:"+params+"\n"+url+"\n"+"headerName: "+user +"\t"+"token: "+token+"\n");
		System.out.println(res);
		return res;
	}
	/**
	 * 32 对应的UserMgrWebService接口：  public BoolAGWebserviceResp ResetUserPasswordM(string username, string newPsd)
	 * @return  后台管理员重置用户密码  
	 * sql：SELECT * from USER_CENTER.UserInfo WHERE uname='349094467';
	 * @param {"username":"%s","newPsd":"%s"}
	 */
	public StringBuffer  resetuserpasswordm(String user,String token,String username,String newPsd){
		String params=null;
		params=String.format("{\"username\":\"%s\",\"newPsd\":\"%s\"}",username,newPsd);
		String url=testURL+"resetuserpasswordm.ajax";
		StringBuffer res =interfaceCenter.getInstance(url, interfaceCenter.getMap(user, token), params);
		System.out.println("body:"+params+"\n"+url+"\n"+"headerName: "+user +"\t"+"token: "+token+"\n");
		System.out.println(res);
		return res;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String user1="junfeng.li";
		String token1 =_getToken.getInstance("junfeng.li", "12345678", 6);
		String user2="lijunfeng149@sina.com";
		String token2 =_getToken.getInstance(user2, "12345678", 6);
		String user3 ="lijunfeng6@sina.com";
		String token3=_getToken.getInstance(user3, "12345678", 6);
		String userS="smanage";
		String tokenS =_getToken.getInstance(userS, "71ad3b8f53491648d4074bdebdda7ab0", 6);
		
		UserMgrWebService umws = new UserMgrWebService();
//		umws.adduserm(user1, tokenS, "{\"uname\":\"testjunfeng1\",\"password\":\"123456\",\"contact\":\"Contact\",\"email\":\"lijunfeng@sina.com\",\"telephone\":13717607755,\"manager\":999}");
//		umws.acceptinvitem(userS, tokenS, 6466, "test", "www"); ?????未收到邮件 什么功能不确定
		umws.assignuserm(userS, tokenS, 13485, 10110,4);  
//		umws.assignuserlistm(userS, tokenS, "[89019,905]", 1987894, 3); 
//		umws.checkemailm(user1, token1, "junfeng.li@agrant.cn");
//		umws.checkmobilem(user1, token1, "1371760775");
//		umws.checkusernamem(user1, token1, "lijunfeng6@sina.com");
//		umws.delassignuserm(userS, tokenS, 905,6524); //与添加接口配合测试
//		umws.deluserm(userS, tokenS, 1987894);
//		umws.delinviterelm(user1, token1, "AB001");  //与邀请用户配合测试
		
//		umws.getuidsbycidm(user2, token2, 89019);  //bug：使用没有权限的 报401
//		umws.getuserbynamem(user1, token1, "aguser");
//		umws.getuserbyemailm(user1, token1, "junfeng.li@agrant.cn"); 
//		umws.getuserbycidm(user1, token1, 905);
//		umws.getuserbyuidm(user1, token1, 1987894);
//		umws.getuserbyuidlistm(user1, token1, "[6466,1987894]");
//		umws.getuserbymanagerm(userS, tokenS, "{\"uid\":6466,\"roleId\":0}"); 
//		umws.getuserlikenamem(user1, token1, "abc123"); 
//		umws.getcurrbycidm(user1, token1, 13485);
//		umws.getcurrbycidlistm(user1, token1, "[13485]");
		 
//		umws.getallrolem(user1, token1);
//		umws .getalluserm(user1, token1); //BUGBUGBUGBUGBUGBUG java版搜索到1000个  webservice版搜到5266 
//		umws.getrolebysysidm(user1, token1, 1);
//		umws.getrolebyinvitecodem(user1, token1, "e22c88db0f259a322c2092b1790eb16d"); //roleId获取不到数据
//
//		String paramInviteuserm ="{\"domain\":\"www.agrant.cn\",\"modifyUid\":6466,\"unameOrEmail\":\"349094467\",\"cid\":89019,\"rid\":3}";
//		umws.inviteuserm(user1, token1, paramInviteuserm);
//	????????????????????? uid1 uid2
//		String paramModifyuserinvitm ="{\"uid1\":10204,\"uid2\":6466,\"cid\":89019,\"roleid\":3}";
//		umws.modifyuserinvitm(userS, tokenS, paramModifyuserinvitm);

//		umws.resetpasswordm(user1, token1, "349094467", "1f5c5dbb1e52a31d0a44a0f27b482bdd", "12345678"); 

//		String paramSentvalidemailm = "{\"email\":\"349094467@qq.com\",\"username\":\"349094467\",\"title\":\"test5\",\"content\":\"测试邮件5\",\"emailAddress\":\"agsem.mailagent@agrant.cn\",\"emailAddressName\":\"AnG广告管理平台\",\"password\":\"3241t123T\"}";
//		String paramSentvalidemailm="{\"email\":\"junfeng.li@agrant.cn\",\"username\":\"junfeng.li\",\"title\":\"标题了\",\"content\":\"<div style=\\\"float: left; width:100%; \\\"><div style=\\\"float: left; width:100% \\\"><img alt=\\\"\\\" src=\\\"http://localhost/View/image/findpassword/email_logo.jpg\\\" /></div><div style=\\\"float: left; width:100% \\\" ><br/>亲爱的用户：<br />您好！<br />您在2016年09月05日 15:22:08提交了邮箱找回密码请求，请点击下面的链接修改密码。<br /><a href=\\\"http://localhost/View/userinfo/findpasswordstep3.aspx?key={0}&uname={1}\\\">http://localhost/View/userinfo/findpasswordstep3.aspx?key={0}&uname={1}</a><br />(如果您无法点击此链接，请将它复制到浏览器地址栏后访问)<br />为了保证您用户名的安全，该链接有效期为24小时，并且点击一次后失效！<br /><br /><br />AnG团队敬上<br />http://www.agrant.cn<br />2016年09月05日</div></div>\",\"emailAddress\":\"agsem.mailagent@agrant.cn\",\"emailAddressName\":\"AnG广告管理平台\",\"password\":\"3241t123T\"}";
//		umws.sentvalidemailm(user1, token1, paramSentvalidemailm);
		
//		String paramUpdateuserinfom ="{\"uname\":\"349094467\",\"uid\":6685,\"telephone\":\"13717607777\",\"deleteflag\":0,\"contact\":\"李俊峰\",\"manager\":-1,\"email\":\"349094467@qq.com\"}";
//		umws.updateuserinfom(userS, tokenS, paramUpdateuserinfom);
//		umws.updateuserrolem(userS, tokenS, 89019, 4, 6685); 
		
//		umws.assignuserrwccm(userS, tokenS, 7623, 10179, 3); //BUG?????????????????????????????
//		umws.resetuserpasswordm(user1, token1, "3490944670", "123345678");
	}

}
