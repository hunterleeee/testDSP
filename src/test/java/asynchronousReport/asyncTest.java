package asynchronousReport;

/**
 * 异步报表测试设置报文 返回taskID
 *
 */
import java.util.HashMap;
import java.util.Map;

import com.Interface.baseHttpClient;

public class asyncTest {
	private static String urlgetRev_test="http://l-test12.dev.cn2.corp.agrant.cn:8080/core-mysql/mysql/revconfigquery";  //{"cid":"905"}
	private static String urlgetRev="http://qcoreimpala.prod.qd1.corp.agrant.cn:8080/mysql/revconfigquery";
	private static String urlCanQuery_test="http://l-test12.dev.cn2.corp.agrant.cn:8080/core-mysql/mysql/candoquery";
	private static String urlCanQuery="http://qcoreimpala.prod.qd1.corp.agrant.cn:8080/mysql/candoquery";
	private static String urlMysqlQuery_test="http://l-test12.dev.cn2.corp.agrant.cn:8080/core-mysql/mysql/doquery";
	private static String urlMysqlQuery="http://qcoreimpala.prod.qd1.corp.agrant.cn:8080/impala/doquery ";

	private static String urlImpalaQuery_test="http://l-test12.dev.cn2.corp.agrant.cn:8080/core-impala/impala/doquery";
	private static String urlImpalaQuery="http://qcoreimpala.prod.qd1.corp.agrant.cn:8080/impala/doquery"; //线上接口URL
	
	public void canQuery(String urlCanQuery,String params){
		Map< String, String> headers=new HashMap< String, String>();
		headers.put("Content-Type", "application/json");
		baseHttpClient bhc =new baseHttpClient();
		StringBuffer res = bhc.doPost(urlCanQuery, headers, params);
		System.out.println("header: "+headers.toString()+"\nURL :"+urlCanQuery+"\nparm : "+params.toString());
		System.out.println(res);
	}
	
	public void costReport(String urlQuery,String cid,String startDate, String endDate){
		Map< String, String> headers=new HashMap< String, String>();
		headers.put("Content-Type", "application/json");
		String params =null;
		params=String.format("{\"dimensions\":[\"year\",\"month\",\"day\",\"cid\",\"planid\",\"mid\"],\"values\":[\"impression\",\"click\",\"cost\",\"ctr\",\"cpm\",\"cpc\",\"rev1\",\"rev2\",\"rev3\",\"rev4\",\"rev5\",\"rev6\",\"rev7\",\"rev8\",\"rev9\",\"rev10\",\"rev11\",\"rev12\",\"rev13\",\"rev14\",\"rev15\",\"rev16\",\"rev17\",\"rev18\",\"rev19\",\"rev20\",\"rev21\",\"rev22\",\"rev23\",\"rev24\",\"orev\"],\"conditions\":[{\"lhs\":\"cid\",\"op\":\"=\",\"rhs\":\"%s\"},{\"lhs\":\"dateline\",\"op\":\">=\",\"rhs\":\"%s\"},{\"lhs\":\"dateline\",\"op\":\"<=\",\"rhs\":\"%s\"},{\"lhs\":\"ymd\",\"op\":\"#orderby\",\"rhs\":\"desc\"},{\"lhs\":\"impression\",\"op\":\"#orderby\",\"rhs\":\"desc\"},{\"lhs\":\"65500\",\"op\":\"#limit\",\"rhs\":\"\"}],\"havings\":[],\"async\":true,\"hint\":\"\",\"user\":\"junfeng.li\"}",cid,startDate,endDate);
		baseHttpClient bhc =new baseHttpClient();
		StringBuffer res = bhc.doPost(urlQuery, headers, params);
		System.out.println("header: "+headers.toString()+"\nURL :"+urlQuery+"\nparm : "+params.toString());
		System.out.println(res);
	}
	public void costReport(String urlQuery,String params){
		Map< String, String> headers=new HashMap< String, String>();
		headers.put("Content-Type", "application/json");
		baseHttpClient bhc =new baseHttpClient();
		StringBuffer res = bhc.doPost(urlQuery, headers, params);
		System.out.println("header: "+headers.toString()+"\nURL :"+urlQuery+"\nparm : "+params.toString());
		System.out.println(res);
	}
	
	public void websiteReport(String urlQuery,String cid,String startDate, String endDate){
		Map< String, String> headers=new HashMap< String, String>();
		headers.put("Content-Type", "application/json");
		String params =null;
		params=String.format("{\"dimensions\":[\"cid\",\"site\",\"agcode1\",\"agcode\"],\"values\":[\"impression\",\"click\",\"cost\",\"ctr\",\"cpm\",\"cpc\",\"rev1\",\"rev2\",\"rev3\",\"rev4\",\"rev5\",\"rev6\",\"rev7\",\"rev8\",\"rev9\",\"rev10\",\"rev11\",\"rev12\",\"rev13\",\"rev14\",\"rev15\",\"rev16\",\"rev17\",\"rev18\",\"rev19\",\"rev20\",\"rev21\",\"rev22\",\"rev23\",\"rev24\",\"orev\"],\"conditions\":[{\"lhs\":\"cid\",\"op\":\"=\",\"rhs\":\"%s\"},{\"lhs\":\"dateline\",\"op\":\">=\",\"rhs\":\"%s\"},{\"lhs\":\"dateline\",\"op\":\"<=\",\"rhs\":\"%s\"},{\"lhs\":\"impression\",\"op\":\"#orderby\",\"rhs\":\"desc\"},{\"lhs\":\"65500\",\"op\":\"#limit\",\"rhs\":\"\"}],\"havings\":[],\"async\":true,\"hint\":\"\",\"user\":\"junfeng.li\"}",cid,startDate,endDate);
		baseHttpClient bhc =new baseHttpClient();
		StringBuffer res = bhc.doPost(urlQuery, headers, params);
		System.out.println("header: "+headers.toString()+"\nURL :"+urlQuery+"\nparm : "+params.toString());
		System.out.println(res);
	}
	public void websiteReport(String urlQuery,String params){
		Map< String, String> headers=new HashMap< String, String>();
		headers.put("Content-Type", "application/json");
		baseHttpClient bhc =new baseHttpClient();
		StringBuffer res = bhc.doPost(urlQuery, headers, params);
		System.out.println("header: "+headers.toString()+"\nURL :"+urlQuery+"\nparm : "+params.toString());
		System.out.println(res);
	}
	
	
	
	public void regionReport(String urlQuery,String cid,String startDate, String endDate){
		Map< String, String> headers=new HashMap< String, String>();
		headers.put("Content-Type", "application/json");
		String params =null;
//		params=String.format("{\"dimensions\":[\"year\",\"month\",\"cid\",\"planid\",\"region1\",\"region2\"],\"values\":[\"impression\",\"click\",\"cost\",\"ctr\",\"cpm\",\"cpc\",\"rev1\",\"rev2\",\"rev3\",\"rev4\",\"rev5\",\"rev6\",\"rev7\",\"rev8\",\"rev9\",\"rev10\",\"rev11\",\"rev12\",\"rev13\",\"rev14\",\"rev15\",\"rev16\",\"rev17\",\"rev18\",\"rev19\",\"rev20\",\"rev21\",\"rev22\",\"rev23\",\"rev24\",\"orev\"],\"conditions\":[{\"lhs\":\"cid\",\"op\":\"=\",\"rhs\":\"%s\"},{\"lhs\":\"dateline\",\"op\":\">=\",\"rhs\":\"%s\"},{\"lhs\":\"dateline\",\"op\":\"<=\",\"rhs\":\"%s\"},{\"lhs\":\"ym\",\"op\":\"#orderby\",\"rhs\":\"desc\"},{\"lhs\":\"impression\",\"op\":\"#orderby\",\"rhs\":\"desc\"},{\"lhs\":\"65500\",\"op\":\"#limit\",\"rhs\":\"\"}],\"havings\":[],\"async\":true,\"hint\":\"\",\"user\":\"junfeng.li\"}",cid,startDate,endDate);
		params=String.format("{\"dimensions\":[\"year\",\"week\",\"cid\",\"planid\",\"region1\",\"region2\"],\"values\":[\"impression\",\"click\",\"cost\",\"ctr\",\"cpm\",\"cpc\",\"rev1\",\"rev2\",\"rev3\",\"rev4\",\"rev5\",\"rev6\",\"rev7\",\"rev8\",\"rev9\",\"rev10\",\"rev11\",\"rev12\",\"rev13\",\"rev14\",\"rev15\",\"rev16\",\"rev17\",\"rev18\",\"rev19\",\"rev20\",\"rev21\",\"rev22\",\"rev23\",\"rev24\",\"orev\"],\"conditions\":[{\"lhs\":\"cid\",\"op\":\"=\",\"rhs\":\"%s\"},{\"lhs\":\"dateline\",\"op\":\">=\",\"rhs\":\"%s\"},{\"lhs\":\"dateline\",\"op\":\"<=\",\"rhs\":\"%s\"},{\"lhs\":\"yw\",\"op\":\"#orderby\",\"rhs\":\"desc\"},{\"lhs\":\"impression\",\"op\":\"#orderby\",\"rhs\":\"desc\"},{\"lhs\":\"65500\",\"op\":\"#limit\",\"rhs\":\"\"}],\"havings\":[],\"async\":true,\"hint\":\"\",\"user\":\"junfeng.li\"}",cid,startDate,endDate);
		baseHttpClient bhc =new baseHttpClient();
		StringBuffer res = bhc.doPost(urlQuery, headers, params);
		System.out.println("header: "+headers.toString()+"\nURL :"+urlQuery+"\nparm : "+params.toString());
		System.out.println(res);
	}
	public void regionReport(String urlQuery,String params){
		Map< String, String> headers=new HashMap< String, String>();
		headers.put("Content-Type", "application/json");
		baseHttpClient bhc =new baseHttpClient();
		StringBuffer res = bhc.doPost(urlQuery, headers, params);
		System.out.println("header: "+headers.toString()+"\nURL :"+urlQuery+"\nparm : "+params.toString());
		System.out.println(res);
	}
	
	public void deviceReport(String urlQuery,String cid,String startDate, String endDate){  
		Map< String, String> headers=new HashMap< String, String>();
		headers.put("Content-Type", "application/json");
		String params =null;
		params=String.format("{\"dimensions\":[\"year\",\"week\",\"cid\",\"planid\",\"device\"],\"values\":[\"impression\",\"click\",\"cost\",\"ctr\",\"cpm\",\"cpc\",\"rev1\",\"rev2\",\"rev3\",\"rev4\",\"rev5\",\"rev6\",\"rev7\",\"rev8\",\"rev9\",\"rev10\",\"rev11\",\"rev12\",\"rev13\",\"rev14\",\"rev15\",\"rev16\",\"rev17\",\"rev18\",\"rev19\",\"rev20\",\"rev21\",\"rev22\",\"rev23\",\"rev24\",\"orev\"],\"conditions\":[{\"lhs\":\"cid\",\"op\":\"=\",\"rhs\":\"%s\"},{\"lhs\":\"dateline\",\"op\":\">=\",\"rhs\":\"%s\"},{\"lhs\":\"dateline\",\"op\":\"<=\",\"rhs\":\"%s\"},{\"lhs\":\"yw\",\"op\":\"#orderby\",\"rhs\":\"desc\"},{\"lhs\":\"impression\",\"op\":\"#orderby\",\"rhs\":\"desc\"},{\"lhs\":\"65500\",\"op\":\"#limit\",\"rhs\":\"\"}],\"havings\":[],\"async\":true,\"hint\":\"\",\"user\":\"junfeng.li\"}",cid,startDate,endDate);
		baseHttpClient bhc =new baseHttpClient();
		StringBuffer res = bhc.doPost(urlQuery, headers, params);
		System.out.println("header: "+headers.toString()+"\nURL :"+urlQuery+"\nparm : "+params.toString());
		System.out.println(res);
	}
	public void deviceReport(String urlQuery,String params){  
		Map< String, String> headers=new HashMap< String, String>();
		headers.put("Content-Type", "application/json");
		baseHttpClient bhc =new baseHttpClient();
		StringBuffer res = bhc.doPost(urlQuery, headers, params);
		System.out.println("header: "+headers.toString()+"\nURL :"+urlQuery+"\nparm : "+params.toString());
		System.out.println(res);
	}
	
	public void KWReport(String urlQuery,String cid,String startDate, String endDate){
		Map< String, String> headers=new HashMap< String, String>();
		headers.put("Content-Type", "application/json");
		String params =null;
		params=String.format("{\"dimensions\":[\"year\",\"week\",\"cid\",\"planid\",\"mid\",\"kw\"],\"values\":[\"impression\",\"click\",\"cost\",\"ctr\",\"cpm\",\"cpc\",\"rev1\",\"rev2\",\"rev3\",\"rev4\",\"rev5\",\"rev6\",\"rev7\",\"rev8\",\"rev9\",\"rev10\",\"rev11\",\"rev12\",\"rev13\",\"rev14\",\"rev15\",\"rev16\",\"rev17\",\"rev18\",\"rev19\",\"rev20\",\"rev21\",\"rev22\",\"rev23\",\"rev24\",\"orev\"],\"conditions\":[{\"lhs\":\"cid\",\"op\":\"=\",\"rhs\":\"%s\"},{\"lhs\":\"dateline\",\"op\":\">=\",\"rhs\":\"%s\"},{\"lhs\":\"dateline\",\"op\":\"<=\",\"rhs\":\"%s\"},{\"lhs\":\"yw\",\"op\":\"#orderby\",\"rhs\":\"desc\"},{\"lhs\":\"impression\",\"op\":\"#orderby\",\"rhs\":\"desc\"},{\"lhs\":\"65500\",\"op\":\"#limit\",\"rhs\":\"\"}],\"havings\":[],\"async\":true,\"hint\":\"\",\"user\":\"junfeng.li\"}",cid,startDate,endDate);
//		params=String.format("{\"dimensions\":[\"cid\",\"planid\",\"mid\",\"kw\"],\"values\":[\"impression\",\"click\",\"cost\",\"ctr\",\"cpm\",\"cpc\",\"rev1\",\"rev2\",\"rev3\",\"rev4\",\"rev5\",\"rev6\",\"rev7\",\"rev8\",\"rev9\",\"rev10\",\"rev11\",\"rev12\",\"rev13\",\"rev14\",\"rev15\",\"rev16\",\"rev17\",\"rev18\",\"rev19\",\"rev20\",\"rev21\",\"rev22\",\"rev23\",\"rev24\",\"orev\"],\"conditions\":[{\"lhs\":\"cid\",\"op\":\"=\",\"rhs\":\"%s\"},{\"lhs\":\"dateline\",\"op\":\">=\",\"rhs\":\"%s\"},{\"lhs\":\"dateline\",\"op\":\"<=\",\"rhs\":\"%s\"},{\"lhs\":\"impression\",\"op\":\"#orderby\",\"rhs\":\"desc\"},{\"lhs\":\"65500\",\"op\":\"#limit\",\"rhs\":\"\"}],\"havings\":[],\"async\":true,\"hint\":\"\",\"user\":\"junfeng.li\"}",cid,startDate,endDate);		
		baseHttpClient bhc =new baseHttpClient();
		StringBuffer res = bhc.doPost(urlQuery, headers, params);
		System.out.println("header: "+headers.toString()+"\nURL :"+urlQuery+"\nparm : "+params.toString());
		System.out.println(res);
	}
	public void KWReport(String urlQuery,String params){
		Map< String, String> headers=new HashMap< String, String>();
		headers.put("Content-Type", "application/json");
		baseHttpClient bhc =new baseHttpClient();
		StringBuffer res = bhc.doPost(urlQuery, headers, params);
		System.out.println("header: "+headers.toString()+"\nURL :"+urlQuery+"\nparm : "+params.toString());
		System.out.println(res);
	}
	
	public static void main(String[] args) {
		// test Can query 
		asyncTest asycnt=new asyncTest();
		//判断报表来源测试 : impala or mysql
//		String paramsCost="{\"dimensions\":[\"year\",\"month\",\"day\",\"cid\",\"planid\",\"src2\",\"mid\"],\"values\":[\"impression\",\"click\",\"cost\",\"ctr\",\"cpm\",\"cpc\",\"rev1\",\"rev2\",\"rev3\",\"rev4\",\"rev5\",\"rev6\",\"rev7\",\"rev8\",\"rev9\",\"rev10\",\"rev11\",\"rev12\",\"rev13\",\"rev14\",\"rev15\",\"rev16\",\"rev17\",\"rev18\",\"rev19\",\"rev20\",\"rev21\",\"rev22\",\"rev23\",\"rev24\",\"orev\"],\"conditions\":[{\"lhs\":\"cid\",\"op\":\"=\",\"rhs\":\"13485\"},{\"lhs\":\"dateline\",\"op\":\">=\",\"rhs\":\"20170605\"},{\"lhs\":\"dateline\",\"op\":\"<=\",\"rhs\":\"20170606\"},{\"lhs\":\"ymd\",\"op\":\"#orderby\",\"rhs\":\"desc\"},{\"lhs\":\"impression\",\"op\":\"#orderby\",\"rhs\":\"desc\"},{\"lhs\":\"65500\",\"op\":\"#limit\",\"rhs\":\"\"}],\"havings\":[],\"async\":true,\"hint\":\"\",\"user\":\"junfeng.li\",\"ip\":\"119.254.5.10\"}";
//		String paramWeb="{\"dimensions\":[\"cid\",\"site\",\"agcode1\",\"agcode\"],\"values\":[\"impression\",\"click\",\"cost\",\"ctr\",\"cpm\",\"cpc\",\"rev1\",\"rev2\",\"rev3\",\"rev4\",\"rev5\",\"rev6\",\"rev7\",\"rev8\",\"rev9\",\"rev10\",\"rev11\",\"rev12\",\"rev13\",\"rev14\",\"rev15\",\"rev16\",\"rev17\",\"rev18\",\"rev19\",\"rev20\",\"rev21\",\"rev22\",\"rev23\",\"rev24\",\"orev\"],\"conditions\":[{\"lhs\":\"cid\",\"op\":\"=\",\"rhs\":\"905\"},{\"lhs\":\"dateline\",\"op\":\">=\",\"rhs\":\"20161201\"},{\"lhs\":\"dateline\",\"op\":\"<=\",\"rhs\":\"20161204\"},{\"lhs\":\"ymd\",\"op\":\"#orderby\",\"rhs\":\"desc\"},{\"lhs\":\"impression\",\"op\":\"#orderby\",\"rhs\":\"desc\"},{\"lhs\":\"65500\",\"op\":\"#limit\",\"rhs\":\"\"}],\"havings\":[],\"async\":true,\"hint\":\"\",\"user\":\"junfeng.li\"}";
//		String paramRegion="{\"dimensions\":[\"year\",\"month\",\"cid\",\"planid\",\"region1\",\"region2\"],\"values\":[\"impression\",\"click\",\"cost\",\"ctr\",\"cpm\",\"cpc\",\"rev1\",\"rev2\",\"rev3\",\"rev4\",\"rev5\",\"rev6\",\"rev7\",\"rev8\",\"rev9\",\"rev10\",\"rev11\",\"rev12\",\"rev13\",\"rev14\",\"rev15\",\"rev16\",\"rev17\",\"rev18\",\"rev19\",\"rev20\",\"rev21\",\"rev22\",\"rev23\",\"rev24\",\"orev\"],\"conditions\":[{\"lhs\":\"cid\",\"op\":\"=\",\"rhs\":\"905\"},{\"lhs\":\"dateline\",\"op\":\">=\",\"rhs\":\"20161201\"},{\"lhs\":\"dateline\",\"op\":\"<=\",\"rhs\":\"20161204\"},{\"lhs\":\"ymd\",\"op\":\"#orderby\",\"rhs\":\"desc\"},{\"lhs\":\"impression\",\"op\":\"#orderby\",\"rhs\":\"desc\"},{\"lhs\":\"65500\",\"op\":\"#limit\",\"rhs\":\"\"}],\"havings\":[],\"async\":true,\"hint\":\"\",\"user\":\"junfeng.li\"}";
//		String paramDevice="{\"dimensions\":[\"year\",\"week\",\"cid\",\"planid\",\"src2\",\"device\"],\"values\":[\"impression\",\"click\",\"cost\",\"ctr\",\"cpm\",\"cpc\",\"rev1\",\"rev2\",\"rev3\",\"rev4\",\"rev5\",\"rev6\",\"rev7\",\"rev8\",\"rev9\",\"rev10\",\"rev11\",\"rev12\",\"rev13\",\"rev14\",\"rev15\",\"rev16\",\"rev17\",\"rev18\",\"rev19\",\"rev20\",\"rev21\",\"rev22\",\"rev23\",\"rev24\",\"orev\"],\"conditions\":[{\"lhs\":\"cid\",\"op\":\"=\",\"rhs\":\"905\"},{\"lhs\":\"dateline\",\"op\":\">=\",\"rhs\":\"20161201\"},{\"lhs\":\"dateline\",\"op\":\"<=\",\"rhs\":\"20161204\"},{\"lhs\":\"yw\",\"op\":\"#orderby\",\"rhs\":\"desc\"},{\"lhs\":\"impression\",\"op\":\"#orderby\",\"rhs\":\"desc\"},{\"lhs\":\"65500\",\"op\":\"#limit\",\"rhs\":\"\"}],\"havings\":[],\"async\":true,\"hint\":\"\",\"user\":\"junfeng.li\"}";
//		String paramKW="{\"dimensions\":[\"cid\",\"planid\",\"mid\",\"kw\"],\"values\":[\"impression\",\"click\",\"cost\",\"ctr\",\"cpm\",\"cpc\",\"rev1\",\"rev2\",\"rev3\",\"rev4\",\"rev5\",\"rev6\",\"rev7\",\"rev8\",\"rev9\",\"rev10\",\"rev11\",\"rev12\",\"rev13\",\"rev14\",\"rev15\",\"rev16\",\"rev17\",\"rev18\",\"rev19\",\"rev20\",\"rev21\",\"rev22\",\"rev23\",\"rev24\",\"orev\"],\"conditions\":[{\"lhs\":\"cid\",\"op\":\"=\",\"rhs\":\"905\"},{\"lhs\":\"dateline\",\"op\":\">=\",\"rhs\":\"20161201\"},{\"lhs\":\"dateline\",\"op\":\"<=\",\"rhs\":\"20161204\"},{\"lhs\":\"ymd\",\"op\":\"#orderby\",\"rhs\":\"desc\"},{\"lhs\":\"impression\",\"op\":\"#orderby\",\"rhs\":\"desc\"},{\"lhs\":\"65500\",\"op\":\"#limit\",\"rhs\":\"\"}],\"havings\":[],\"async\":true,\"hint\":\"\",\"user\":\"junfeng.li\"}";
//		asycnt.canQuery(urlCanQuery_test,paramsCost);
//		asycnt.canQuery(urlCanQuery_test,paramWeb);
//		asycnt.canQuery(urlCanQuery_test,paramRegion);
//		asycnt.canQuery(urlCanQuery_test,paramDevice);
//		asycnt.canQuery(urlCanQuery_test,paramKW);
		
		//各个报表测试
//		asycnt.costReport(urlImpalaQuery_test,"905", "20161219", "20161220");
//		asycnt.websiteReport(urlImpalaQuery_test,"905", "20161218", "20161219");
//		asycnt.regionReport(urlImpalaQuery_test,"905", "20170314", "20170314");
//		asycnt.deviceReport(urlImpalaQuery_test,"2299", "20161118", "20161220");
//		asycnt.KWReport(urlImpalaQuery_test,"905", "20161217", "20161219");

		
		//日常问题处理使用 直接将报文作为参数传入
		String paramRegion="{\"dimensions\":[\"year\",\"week\",\"cid\",\"planid\",\"src2\",\"agcode\",\"agcode1\",\"site\",\"sitename\"],\"values\":[\"impression\",\"click\",\"cost\",\"ctr\",\"cpm\",\"cpc\",\"orev\",\"rev8\",\"rev7\",\"rev9\",\"rev4\",\"rev3\",\"rev6\",\"rev5\",\"rev2\",\"rev1\"],\"conditions\":[{\"lhs\":\"cid\",\"op\":\"\u003d\",\"rhs\":\"2616\"},{\"lhs\":\"dateline\",\"op\":\"\u003e\u003d\",\"rhs\":\"20171231\"},{\"lhs\":\"dateline\",\"op\":\"\u003c\u003d\",\"rhs\":\"20180101\"},{\"lhs\":\"yw\",\"op\":\"#orderby\",\"rhs\":\"asc\"},{\"lhs\":\"impression\",\"op\":\"#orderby\",\"rhs\":\"desc\"},{\"lhs\":\"100000\",\"op\":\"#limit\",\"rhs\":\"\"}],\"havings\":[{\"lhs\":\"impression\",\"op\":\"\u003e\",\"rhs\":\"0\"}],\"async\":true,\"hint\":\"\",\"user\":\"licong\",\"ip\":\"119.254.5.25\"}";
//		asycnt.costReport(urlImpalaQuery,paramRegion);
		asycnt.costReport(urlImpalaQuery_test,paramRegion);


	}

}
