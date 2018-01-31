package dsp.usercenter.test;

import java.util.HashMap;
import java.util.Map;

import com.Interface.baseHttpClient;
/**
 * 3步开户 注册 —— 完善信息 —— 购买产品套餐
 * @author think
 */
public class newRegister {
	private String testURL ="http://l-bidtest.dev.cn2.corp.agrant.cn:8086/m/customermgr/";

	/**
	 * 1 功能：开户页阶段一，创建CustomerInfo，UserInfo，基础配置等
	 * SELECT * FROM USER_CENTER.CustomerInfo where cid in (99924,88936);    -- 新版有---客户信息表：开户时公司地址和行业分类customerInfo和adxcertstatus一致
	 * SELECT * FROM USER_CENTER.CusUserRoleRel where cid in (99924,88936);    -- 新版有---客户用户权限关系表roleid-1和2
	 * SELECT * FROM USER_CENTER.UserInfo where uid in (10087,1987951);  -- 新版有---用户信息表---
	 * SELECT * FROM USER_CENTER.CusProdRel where cid in (99923,88936);  --  新版有---客户产品关系表: 新版只开6和999，产品6加注册步骤字段
	 * SELECT * FROM Adx.AdxCertStatus where cid in (99924,13496);-- 新版有---投放使用的客户信息表: 开户时公司地址和行业分类customerInfo和adxcertstatus一致---
	 * SELECT * FROM AGUsers.Registry where cid in (99924,88936);   -- 新版有---客户基本配置表：待确定是否有用？8条
	 * SELECT * FROM AGUsers.RevConfig where cid in (99924,88936);  -- 新版有---客户收益配置表---
	 */
	public StringBuffer registerstep1m(String user,String token,String param){
		String params=null;
		params=String.format("%s",param);
		String url=testURL+"registerstep1m.ajax";
		StringBuffer res =interfaceCenter.getInstance(url, interfaceCenter.getMap(user, token), params);
		System.out.println("body:"+params+"\n"+url+"\n"+"headerName: "+user +"\t"+"token: "+token+"\n");
		System.out.println(res);
		return res;	
	}
	
	/**
	 * 2 步骤2 开户页阶段二，完善CustomerInfo和adxcertstatus
	 * SELECT * FROM USER_CENTER.CustomerInfo where cid in (99924,88936);    -- 新版有---客户信息表：开户时公司地址和行业分类customerInfo和adxcertstatus一致
	 * SELECT * FROM USER_CENTER.CusProdRel where cid in (99923,88936);   -- 新版有---客户产品关系表: 新版只开6和999，产品6加注册步骤字段
	 * SELECT * FROM USER_CENTER.CusAttrib where cid in (99924,88936);  -- 新版有---客户属性表：不要ag_contest。完善信息时添加domain
	 */
	public StringBuffer registerstep2m(String user,String token,String param){
		String params=null;
		params=String.format("%s",param);
		String url=testURL+"registerstep2m.ajax";
		StringBuffer res =interfaceCenter.getInstance(url, interfaceCenter.getMap(user, token), params);
		System.out.println("body:"+params+"\n"+url+"\n"+"headerName: "+user +"\t"+"token: "+token+"\n");
		System.out.println(res);
		return res;	
	}
	
	/**
	 * 3 步骤3 开户页阶段三，更新开户阶段状态
	 * 	SELECT * FROM USER_CENTER.CusProdRel where cid in (99923,88936);   -- 新版有---客户产品关系表: 新版只开6和999，产品6加注册步骤字段
	 */
	public StringBuffer registerstep3m(String user,String token,String param){
		String params=null;
		params=String.format("%s",param);
		String url=testURL+"registerstep3m.ajax";
		StringBuffer res =interfaceCenter.getInstance(url, interfaceCenter.getMap(user, token), params);
		System.out.println("body:"+params+"\n"+url+"\n"+"headerName: "+user +"\t"+"token: "+token+"\n");
		System.out.println(res);
		return res;	
	}
	
	/**
	 * 4 根据cid 获取客户开户阶段
	 * SELECT * FROM USER_CENTER.CusProdRel where cid in (99923);   -- 新版有---客户产品关系表: 新版只开6和999，产品6加注册步骤字段
	 * param ={"cid":99916}
	 */
	public StringBuffer getregstatusbycidm(String user,String token,String param){
		String params=null;
		params=String.format("%s",param);
		String url=testURL+"getregstatusbycidm.ajax";
		StringBuffer res =interfaceCenter.getInstance(url, interfaceCenter.getMap(user, token), params);
		System.out.println("body:"+params+"\n"+url+"\n"+"headerName: "+user +"\t"+"token: "+token+"\n");
		System.out.println(res);
		return res;	
	}
	
	/**
	 *5 功能 以后台管理员身份，检测客户名是否存在
	 * @param user
	 * SELECT * FROM USER_CENTER.CustomerInfo where cid in (99924) and cname =???;
	 * @param  = {"customername":"zhangbintest12222"}
	 * @return {"code": 0,"message": "成功","value": false}       // value值为true，代表存在，false代表不存在。
	 */
	public StringBuffer checkcnamem(String user,String token,String param){
		String params=null;
		params=String.format("%s",param);
		String url=testURL+"checkcnamem.ajax";
		StringBuffer res =interfaceCenter.getInstance(url, interfaceCenter.getMap(user, token), params);
		System.out.println("body:"+params+"\n"+url+"\n"+"headerName: "+user +"\t"+"token: "+token+"\n");
		System.out.println(res);
		return res;	
	}
	
	/**
	 *  6 功能：以后台管理员身份，检测客户邮箱是否存在
	 * @param param={"email":"ab000c"}
	 * SELECT * FROM USER_CENTER.CustomerInfo where cid in (99924,88936) and email=???;   
	 */
	public StringBuffer checkcemailm(String user,String token,String param){
		String params=null;
		params=String.format("%s",param);
		String url=testURL+"checkcemailm.ajax";
		StringBuffer res =interfaceCenter.getInstance(url, interfaceCenter.getMap(user, token), params);
		System.out.println("body:"+params+"\n"+url+"\n"+"headerName: "+user +"\t"+"token: "+token+"\n");
		System.out.println(res);
		return res;	
	}
	
	/**
	 *  7 功能：以后台管理员身份，添加用户客户关系
	 * @param user
	 * SQL  SELECT * FROM USER_CENTER.CusUserRoleRel where cid =??? and uid=??? and rid=??;
	 * @param {"cid":99919,"uid":2236,"rid":2}
	 * @return {"code": 0,"message": "成功","cusUserRoleRel": {"cid": 99919,"createtime": null,"uid": 2236,"userName": null,"roleId": 2,"invitestatus": -1,"invitecode": null,"inviteuid": -1,"invitedatetime": null,"modifier": null,"note1": null,"updatetime":null,"cname": null}}
	 */
	public StringBuffer assignuserrwccm(String user,String token,String param){
		String params=null;
		params=String.format("%s",param);
		String url="http://l-bidtest.dev.cn2.corp.agrant.cn:8086/m/usermgr/assignuserrwccm.ajax ";
		StringBuffer res =interfaceCenter.getInstance(url, interfaceCenter.getMap(user, token), params);
		System.out.println("body:"+params+"\n"+url+"\n"+"headerName: "+user +"\t"+"token: "+token+"\n");
		System.out.println(res);
		return res;	
	}
	
	public static void main(String[] args) {
		String user1="junfeng.li";
		String token1 = _getToken.getInstance("junfeng.li", "12345678", 6);
		String userS="smanage";
		String tokenS = _getToken.getInstance(userS, "71ad3b8f53491648d4074bdebdda7ab0", 6);
		
		newRegister nr = new newRegister();
		String param_registerstep1m="{\"customerInfoDto\":{\"cname\":\"lijunfengNew7\",\"email\":\"lijunfengNew7@sina.com\",\"tel\":\"13717607755\",\"status\":0,\"agent\":554,\"contact\":\"lijunfengNew7\"},\"userInfoDto\":{\"uname\":\"lijunfengNew7\",\"telephone\":13717607755,\"contact\":\"lijunfengNew7\",\"email\":\"lijunfengNew7@sina.com\",\"password\":\"123456\"}}}";
//		nr.registerstep1m(userS, tokenS, param_registerstep1m);

		String param_registerstep2m=
				"{\"customerInfoDto\":{\"cid\":99931,\"company\":\"lijunfengNew7的公司1\",\"address\":\"公司地址爱爱爱\",\"domain\":\"www.domain.com\",\"category\":\"1623\",\"subcategory\":\"03\",\"websitename\":\"test网站\",\"domainList\":[{\"domain\":\"www.test.com\",\"domainIndex\":\"1\",\"verified\":\"0\"}],\"updateLog\":[\"company\",\"domain\",\"category\",\"websitename\",\"subcategory\",\"address\"]}}";
		nr.registerstep2m(userS, tokenS, param_registerstep2m);
		
		String param_registerstep3m="{\"customerInfoDto\":{\"cid\":999204}}";
//		nr.registerstep3m(userS, tokenS, param_registerstep3m);
		
		String param_getregstatusbycidm="{\"cid\":99924,\"uid\":2236,\"rid\":2}";
//		nr.getregstatusbycidm(userS, tokenS, param_getregstatusbycidm);
		
		String param_checkcnamem = "{\"customername\":\"lijunfengNew1\"}";
//		nr.checkcnamem(userS, tokenS, param_checkcnamem);
		
		String param_checkcemailm = "{\"email\":\"lijunfengNew1@sina.com\"}";
//		nr.checkcemailm(userS, tokenS, param_checkcemailm);
		
		String param_assignuserrwccm = "{\"cid\":999204,\"uid\":22306,\"rid\":2}";
//		nr.assignuserrwccm(userS, tokenS, param_assignuserrwccm);
	}

}
