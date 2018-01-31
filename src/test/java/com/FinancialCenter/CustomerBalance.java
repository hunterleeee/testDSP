package com.FinancialCenter;

import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

import dsp.usercenter.test._getToken;
import dsp.usercenter.test.interfaceCenter;

public class CustomerBalance {
	private String burl="http://l-ws21.dev.cn2.corp.agrant.cn:6188/api/CustomerBalance/";
	private HashMap<String, String> header=new HashMap<String, String>(); //创建headers参数

	
/** 1 有问题，过不去
 * 获取所有客户流水的信息：
 * @param startTime
 * @param endTime
 * @return
 */
	public StringBuffer  GetAllCidBalanceChangeLog(String startTime,String endTime){
		String params=null;
		params=String.format("{\"startTime\":%s,\"endTime\":%s}",startTime,endTime);
		String url=burl+"GetAllCidBalanceChangeLog";
		StringBuffer res =interfaceCenter.getInstance(url,header, params);
		System.out.println("body:"+params+"\n"+url+"\n"+"headerName: "+header.get("username") +"\t"+"password: "+header.get("password") +"\n");
		System.out.println(res);
		return res;
//		{"startTime":????,"endTime":?????}
	}
	
	/**2 过不去
	 * 获取指定CID的流水信息
	 * @param cid
	 * @param startTime
	 * @param endTime
	 * @return
	 */
		public StringBuffer  GetBalanceChangeLog(String cid,String startTime,String endTime){
			String params=null;
			params=String.format("{\"cid\":%s,\"startTime\":%s,\"endTime\":%s}",cid,startTime,endTime);
			String url=burl+"GetBalanceChangeLog";
			StringBuffer res =interfaceCenter.getInstance(url,header, params);
			System.out.println("body:"+params+"\n"+url+"\n"+"headerName: "+header.get("username") +"\t"+"password: "+header.get("password") +"\n");
			System.out.println(res);
			return res;
//			{"cid":????,""startTime":????,"endTime":?????}
		}
	
	/**3 过不去
	 * 给客户充值接口
	 * @param cid
	 * @param amount
	 * @return
	 */
		public StringBuffer RechargeBalance(int cid,int amount){
			String url=burl+"RechargeBalance"; //url参数
			String params=null;
//			params=String.format("{\"cid\":%d,\"amount\":%d}",cid,amount); //body参数
			StringBuffer res =interfaceCenter.getInstance(url,header, params); //执行接口
			System.out.println("body:"+params+"\n"+url+"\n"+"headerName: "+header.get("username") +"\t"+"password: "+header.get("password") +"\n");
			System.out.println(res);
			return res;
//			{"cid":1,"amount":100}  -- amount返还金额
		}
		
		
		
		
		private String getAuthorization(String token){
			String Authorization="finance_revrobot:"+token;
			byte[] s =Base64.getEncoder().encode(Authorization.getBytes());
			return ("Basic "+new String (s));
		}

	

		/**7.获取客户余额信息
		 * @param cid
		 * @param amount
		 * @param get token sql  : SELECT * from USER_CENTER.AccessToken WHERE username='finance_revrobot' ORDER BY createtime DESC;
		 * @return
		 */
		public StringBuffer GetBalances(String cids,String token){
			String url=burl+"GetBalances"; //url参数
			String params=null;
			params=String.format("{\"cids\":%s}",cids); //body参数
			HashMap<String, String> header1=new HashMap<String, String>(); //创建headers参数
			header1.put("Content-Type", "application/json");
//			header1.put("Authorization","Basic ZmluYW5jZV9yZXZyb2JvdDo4ZDc5NDkzYzY2NzIyZGE2NzEyNWJiNDA2MGM3MDlmMQ==");
			header1.put("Authorization",getAuthorization(token));
			header1.put("ProductId", "102");
			StringBuffer res =interfaceCenter.getInstance(url,header1, params); //执行接口
			System.out.println("body:"+params+"\n"+url+"\n"+"Authorization: "+header1.get("Authorization") +"\t"+"ProductId: "+header1.get("ProductId") +"\n");
			System.out.println(res);
			return res;
//			{"cids":[905,2616]}  
		}
		
	/**8 
	 * 返还某cid的金额
	 * @param cid
	 * @param amount
	 * @return
	 * 1 有效测试
	 * 2 无效测试 cid不存在 金额是错误的
	 */
	public StringBuffer ReturnBalance(String cid,String amount,String date){
		String url=burl+"ReturnBalance"; //url参数
		String params=null;
		params=String.format("{\"cid\":%s,\"amount\":%s,\"dateline\":\"%s\"}",cid,amount,date); //body参数
//		params=String.format("{\"cid\":13485,\"amount\":1}"); //body参数

		HashMap<String, String> header1=new HashMap<String, String>(); //创建headers参数
		header1.put("Content-Type", "application/json");
		header1.put("username","tmanager");
		header1.put("password", "tmanager123321");
		StringBuffer res =interfaceCenter.getInstance(url,header1, params); //执行接口
		System.out.println("body:"+params+"\n"+url+"\n"+"headerName: "+header1.get("username") +"\t"+"password: "+header1.get("password") +"\n");
		System.out.println(res);
		return res;
//		{"cid":1,"amount":100}  -- amount返还金额
	}
	
	public static void main(String[]args){
		CustomerBalance cb=new CustomerBalance();
//		cb.GetAllCidBalanceChangeLog("2017-12-28 00:00:00","2016-12-29 00:00:00"); //获取所有客户流水的信息：
		
//		cb.GetBalances("[13485,905]","8d79493c66722da67125bb4060c709f1"); //返还某cid的金额
		cb.ReturnBalance("18787","10046.710000","2017-05-10T00:00:00"); //返还某cid的金额
//		cb.getAuthorization("8d79493c66722da67125bb4060c709f1");
	}
}
