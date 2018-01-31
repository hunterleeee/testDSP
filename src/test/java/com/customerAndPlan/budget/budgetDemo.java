package com.customerAndPlan.budget;

import java.util.HashMap;
import java.util.Map;

import com.Interface.baseHttpClient;

public class budgetDemo {
	private static String getBudgetByCids="http://test9.dev.cn2.corp.agrant.cn:25640/AdxAuditRS/budgetServlet?method=getBudgetByCids";
	private static String getBudgetByPlanids="http://test9.dev.cn2.corp.agrant.cn:25640/AdxAuditRS/budgetServlet?method=getBudgetByPlanids";
	private static  Map header =  new HashMap();
	static {
	header.put("token","web:doushishuaige");
	}
	
	/**
	 *  取AdxCertStatus预算如果为-1 则取CustomerBudgetCalendar表的预算（去小于等于日期参数的最近的预算值）
	 *  SELECT cid,dspbudget from Adx.AdxCertStatus WHERE cid in(2616,905);
	 *  SELECT * from Adx.CustomerBudgetCalendar WHERE cid =7755 and dateline<='2017-09-03' ORDER BY dateline DESC LIMIT 1;
	 */
	public void getBudgetByCids(String url,String params){
		baseHttpClient bhc = new baseHttpClient();
		String getBudgetByCidsParams = params;
		StringBuffer res =bhc.doPost(url,header , getBudgetByCidsParams);
		System.out.println("header: "+header.toString()+"\nURL :"+url+"\nparm : "+params);
		System.out.println("Response : " + res);
	}
	
	/**
	 * 取plan表里的tbudget，如果-1 则取PlanBudgetCalendar里离参数日期最近的一天的预算
	 * SELECT planid,tbudget from Adx.Plan WHERE  planid in ('7755_3c5e0d3c127eedca','905_d9f35ee52dd24ff5');
	 * SELECT * from Adx.PlanBudgetCalendar WHERE  planid='7755_3c5e0d3c127eedca' and dateline<='2017-08-08 00:00:00' ORDER BY dateline DESC LIMIT 1;
	 * 
	 */
	public void getBudgetByPlanids(String url,String params){
		baseHttpClient bhc = new baseHttpClient();
		String getBudgetByPlanidsParams = params;
		StringBuffer res =bhc.doPost(url,header , getBudgetByPlanidsParams);
		System.out.println("header: "+header.toString()+"\nURL :"+url+"\nparm : "+params);
		System.out.println("Response : " + res);
	}

	public static void main(String[] args) {
		budgetDemo test =new budgetDemo();
		String getBudgetByCidsParams = " {cids:[905,7755,90501],dateline:\"2017-09-03\"}";
//		test.getBudgetByCids(getBudgetByCids, getBudgetByCidsParams);
		
		String getBudgetByPlanidsParams = "{planids:[\"7755_f53ef86241081aa2\",\"10542_671dfdcf989b26f9\"],dateline:\"2017-04-08\"}";
		test.getBudgetByPlanids(getBudgetByPlanids, getBudgetByPlanidsParams);

	}

}
