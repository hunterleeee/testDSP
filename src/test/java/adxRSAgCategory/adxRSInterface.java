package adxRSAgCategory;

import java.util.HashMap;
import java.util.Map;

import com.Interface.baseHttpClient;

public class adxRSInterface {
	/*	
	SELECT t1.planid,t1.src2,t1.mid,t1.`name`,t1.agstatus,t1.agauditstatus,t1.bidenable,t1.syncflag,t1.file,t1.format,t2.grouptype,t1.adncategory,t1.width,t1.height,t1.pause as ad3pause,t4.pause as planpause,t1.autopause as ad3autopause,t4.autopause as planautopause,t6.interestswitch as verticalTagEnabled ,t1.`mode`,t1.sentag,IFNULL(t3.`value`,'CPM') as pricetype_customer,IFNULL(t5.`value`,'CPM') as pricetype_bid,t7.`value` as TANXchannelcid,t10.`value` as JTXchannelcid,t1.baseprice,IFNULL(t8.`value`, t1.baseprice) as priceparam,t1.clickthrough,t1.fixed_clickthrough,t1.clickurl,t1.createtime,t1.updatetime,t9.id as baiduChannelID from Adx.Ad3 t1 
		LEFT JOIN Ad2 t2 on t1.src2=t2.src2
		LEFT JOIN Adx.AdGroupKVSetting t3 ON t1.src2=t3.src2 and t3.`name`='PRICETYPE_CUSTOMER'
	LEFT JOIN Adx.AdGroupKVSetting t5 ON t1.src2=t5.src2 and t5.`name`='PRICETYPE_BID'
	LEFT JOIN Plan t4 ON t1.planid=t4.planid
		left JOIN Adx.AdxCertStatus t6 ON t1.cid=t6.cid
		LEFT JOIN Adx.CustomerKVSetting t7 ON t1.cid=t7.cid and t7.`name` ='TANX_CID'
		LEFT JOIN Adx.CustomerKVSetting t10 ON t1.cid=t10.cid and t10.`name` ='JTX_CID'
		LEFT JOIN Adx.Ad3KVSetting t8 ON t1.mid=t8.mid and t8.`name`='PRICEPARAM'
	LEFT JOIN Adx.Ad3ExtSetting t9 ON t1.mid=t9.mid
	WHERE t1.mid ='7755_b5566bdc3d5473e6';
	SELECT * from Ad3KVSetting WHERE  mid ='7755_b5566bdc3d5473e6' and `name` like 'SOHU%' ;
*/
	
	static String Ad3ExchangeURL="http://l-test9.dev.cn2.corp.agrant.cn:8080/AdxRS/Ad3Exchange";
	static String Ad3ExtSettingExchangeURL="http://l-test9.dev.cn2.corp.agrant.cn:8080/AdxRS/Ad3ExtSettingExchange";
//	各渠道编号 ： ADX:0;BAIDU:1;SAX:2;TANX:3,TADE:4,CTX:5,AGX=6,ZDM=7;ZDD=8;QAX=9,AMAX=10;GDT=11;YOUKU=12;APPX=13;BAICHUAN=14;WAX=15;JTX=16;SOHU=17;ADVIEW=18;XTX=19;WINA=20
	
	static String AdGroupExchange ="http://l-test9.dev.cn2.corp.agrant.cn:8080/AdxRS/AdGroupKVSettingExchange";
	static String Ad3Exchange_OnLine="http://adxwsng1.prod.cn2.corp.agrant.cn:39519/AdxRS/Ad3Exchange";
	static String Ad3ExtSettingExchangeURL_OnLine="http://adxwsng1.prod.cn2.corp.agrant.cn:39519/AdxRS/Ad3ExtSettingExchange";

	static String adCategoryMap="http://l-test9.dev.cn2.corp.agrant.cn:8080/AdxRS/AdCategoryMap";
	
	
	
	
	public StringBuffer doPost(String url,Map<String,String> header,String params){
	baseHttpClient bhc =new baseHttpClient();
	StringBuffer res =bhc.doPost(url,header,params);
	System.out.println("url : "+url+"\nheader : "+header.toString()+"\nparam : "+params);
	System.out.println("\n"+res);
	return res;
	}
	
	public StringBuffer doPostTest(String url,Map<String,String> header,String params){
		testDoPost bhc =new testDoPost();
		StringBuffer  res =bhc.doPost(url,header,params);
		System.out.println("url : "+url+"\nheader : "+header.toString()+"\nparam : "+params);
		System.out.println("\n"+res);
		return res;
	}

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		adxRSInterface rs = new adxRSInterface();  //实例化
		
		//第一部分 关于adxRS的
		Map<String,String> head =new HashMap<String, String>();
		head.put("adx", "agrantsem659");
		head.put("Content-Type", "text/plain");
		head.put("Accept", "text/plain");
		// 获取某渠道可投放mid的ad3kvsetting设置
//		rs.doPost(Ad3ExchangeURL, head, "{\"channel\":\"BAIDU\"}");
//		rs.doPost(Ad3ExtSettingExchangeURL, head, "{\"channel\":\"12\"}");

//		渠道对一个的数字ADX:0;BAIDU:1;SAX:2;TANX:3,TADE:4,CTX:5,AGX=6,ZDM=7;ZDD=8;QAX=9,AMAX=10;GDT=11;YOUKU=12;APPX=13;BAICHUAN=14;WAX=15;JTX=16;SOHU(SOHUPORTAL)=17;ADVIEW=18;XTX=19;WINA=20

		// 获取某渠道可投放mid的ad3extsetting设置
//		rs.doPost(Ad3Exchange_OnLine, head, "{\"channel\":\"GDT\"}");
//		rs.doPost(Ad3ExtSettingExchangeURL_OnLine, head, "{\"channel\":\"9\"}");
	
		
//		--rs.doPost(adxRSURL_OnLine, head, params);
//		rs.doPostTest(adxRSURL,head,params); //测试失败依然有乱码
		
		
		
		//第二部分 webservice迁移到json
		//设置header
		Map<String,String> header =new HashMap<String, String>();
		header.put("token", "AdxSynchronizerSmart:haoduomeinv");
		
		//1 获取mid的baidu、adx、agx、tanx渠道的showurl示例 用于运营支撑系统的预览功能 getAd3ShowURL
		String getAd3ShowUrlTest ="http://l-test9.dev.cn2.corp.agrant.cn:8080/AdxAuditRS/ForAutoAuditServlet?method=getAd3ShowURL";	
		String getad3showUrlParam="{\"mid\":[\"100372_2dfe92fc77df6917\",\"100372_62e7ed1985dd9713\"]}";
//		rs.doPost(getAd3ShowUrlTest, header,getad3showUrlTest);  //返回url打不开
		
		//2 获取mid可投放的渠道有哪些 getAd3AllowChannels
		String getAd3AllowChannelsTest ="http://l-test9.dev.cn2.corp.agrant.cn:8080/AdxAuditRS/ForAutoAuditServlet?method=getAd3AllowChannels";
		String getAd3AllowChannelsPar="{\"mid\":[\"100372_a20e0e8b25465a9c\",\"100372_06385c8c4e9ed41b\",\"100372_4f9e9e196aca291b\"]}";		
//		rs.doPost(getAd3AllowChannelsTest, header,getAd3AllowChannelsPar);  //很多问题 
		
		
		//更改广告主状态
		String test_urlAuToAuditingAdvertiser2 ="http://l-test9.dev.cn2.corp.agrant.cn:8080/AdxAuditRS/ForAutoAuditServlet?method=updateCustomerStatus&channelName=BAIDU";
		String AdverParamds =
				"[{\"cid\":\"100372\","
				+ "\"ADX_CHANNELENABLE\":1,"
//				+ "\"YOUKU_ADVERTISER\":\"苏酒集团贸易股份有限公司\","
				+ "\"ADX_STATUS\":0"
				+ "}]";
//		rs.doPost(test_urlAuToAuditingAdvertiser2, header, AdverParamds);
		
//		接口迁移前的 更新素材状态及渠道状态方法迁移测试 updateAd3AndKvStatus （ Ad3.agauditstatus可以修改）
		String updateAd3AndKvStatusTest =	"http://l-test9.dev.cn2.corp.agrant.cn:8080/AdxAuditRS/ForAutoAuditServlet?method=updateCreativeStatus&channelName=JTX";
		String updateAd3AndKvStatusPamam1 =
				"[{\"mid\":\"100372_06385c8c4e9ed41b1\",\"ADX_CHANNELENABLE\":\"0\",\"ADX_STATUS\":\"1\",\"ADX_BIDENABLE\":\"1\"}]";
//				+ ",{\"mid\":\"100372_06385c8c4e9ed41b\",\"BAIDU_CHANNELENABLE\":\"0\",\"BAIDU_STATUS\":\"-1\",\"BAIDU_REFUSEREASON\":\"reason123\"}]";
//		rs.doPost(updateAd3AndKvStatusTest, header, updateAd3AndKvStatusPamam1);		

		
		//3 接口迁移后的 更新素材状态及渠道状态方法迁移测试 updateAd3AndKvStatus （ Ad3.agauditstatus可以修改）
		String AutoAuditupdateAd3AndKvStatusTest =	"http://l-test9.dev.cn2.corp.agrant.cn:8080/AdxAuditRS/ForAutoAuditServlet?method=updateAd3AndKvStatus";
		String AutoAuditupdateAd3AndKvStatusPamam1 =
				"[{\"mid\":\"100372_fa949d4f8429758d\",\"ADX_CHANNELENABLE\":\"0\",\"ADX_STATUS\":\"1\",\"ADX_BIDENABLE\":\"1\"}]";
//				+ ",{\"mid\":\"100372_06385c8c4e9ed41b\",\"BAIDU_CHANNELENABLE\":\"0\",\"BAIDU_STATUS\":\"-1\",\"BAIDU_REFUSEREASON\":\"reason123\"}]";
		String AutoAuditupdateAd3AndKvStatusPamam2 ="{\"mid\":[\"100372_fa949d4f8429758d\",\"100372_06385c8c4e9ed41b1\"],\"BAIDU_STATUS\":\"0\", \"BAIDU_BIDENABLE\":\"1\",\"agauditstatus\":\"0\"}";
//		rs.doPost(AutoAuditupdateAd3AndKvStatusTest, header, AutoAuditupdateAd3AndKvStatusPamam1);
		
		//4 webserice重置渠道状态接口方法迁移测试resetAd3Status
		String resetAd3StatusTest ="http://l-test9.dev.cn2.corp.agrant.cn:8080/AdxAuditRS/WebUpdateServlet?method=resetAd3Status";
		String resetAd3StatusTestParam ="{\"mid\":\"100372_fa949d4f8429758d\",\"aliass\":\"14567\",\"actionType\":\"add\"}";
//		rs.doPost(resetAd3StatusTest, header, resetAd3StatusTestParam);

		// 添加、修改素材insertOrUpdateAd3AndKV。小写的入 ad3和ad3extsetting表 大写的话入ad3kvsetting
		String insertOrUpdateAd3AndKV ="http://l-test9.dev.cn2.corp.agrant.cn:8080/AdxAuditRS/WebUpdateServlet?method=insertOrUpdateAd3AndKV";
		String insertOrUpdateAd3AndKVParam ="["
				+ "{\"cid\":\"100372\",\"planid\":\"100372_ba8be1b226a7c785\",\"src2\":\"100372_4255114bc7561526\",\"mid\":\"100372_4f9e9e196aca2914\","
				+ "\"name\":\"abc 名称\",\"width\":\"300\",\"height\":\"250\",\"file\":\"1231314532.jpg\",\"baseprice\":\"10\","
				+ "\"clickthrough\":\"www.baidu.com\",\"clickurl\":\"www.baidu.com?ag=click\",\"monurl\":\"www.baidu.com?ag=mon\","
				+ "\"BAIDU_CHANNELENABLE\":\"1\"}]";

		rs.doPost(insertOrUpdateAd3AndKV, header, insertOrUpdateAd3AndKVParam);

	}

}
