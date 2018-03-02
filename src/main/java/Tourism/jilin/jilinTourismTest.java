package Tourism.jilin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JInternalFrame;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import dsp.usercenter.test.interfaceCenter;
import junit.framework.TestCase;
import test.audit.auditCenter;

public class jilinTourismTest  {
	jilinTourismServer jilinS=null;
	resClass resclass=null;

	public jilinTourismTest(){
		ApplicationContext context1 = new FileSystemXmlApplicationContext("E:\\Project\\Java\\testDSP\\config\\autoTest.xml");
		this.jilinS= (jilinTourismServer) context1.getBean("jilintourismserver");
		resclass =new resClass();
	}
	//区域列表，BdZone表
	@Test
	public void testAreaList(){
		StringBuffer res =jilinS.test_areaList();
		System.out.println(res);
	}
	//景点列表，BdScenic表
	@Test
	public void testViewPoint(){

		StringBuffer res =jilinS.test_ViewPoint();
		System.out.println(res);
	}
	
	//搜索人群画像-地域-热点景点分布
	public void testSeachCrowdPortraitArea_HotSpotsDistribution(){
		StringBuffer res =jilinS.test_seachCrowdPortraitArea("9", "2018-01-01 00:00:00", "4", "1", "5", "131", null, null);
		System.out.println(res);
	}
	//访客人群画像-地域-热点景点分布
	public void testTouristsCrowdPortraitArea_HotSpotsDistribution(){ 
		StringBuffer res =jilinS.test_TouristsCrowdPortraitArea("9", "2018-01-01 00:00:00", "4", "5", "131", null, null);
		System.out.println(res);
	}
	//搜索关注点-地域-搜索词明细分析
	public void testSearchFocusArea_keyWordAnalysis(){
		StringBuffer res =jilinS.test_searchFocusArea("9","2018-01-01 00:00:00","2018-01-02 00:00:00","0");
		System.out.println(res);
	}
	//游客游览路径-地域-游客游览路径分析
	public void testTouristsTraceArea_TouristsTraceAreaAnalysis(){
		StringBuffer res =jilinS.test_touristsTraceArea("9","2018-01-01 00:00:00","2018-01-02 00:00:00", "10", "25");
		System.out.println(res);
	}
	//入库BdSearchItem - 搜索趋势-地域-接口 - 全部
		@Test
			public void testTrendArea_database(){//
				StringBuffer res =jilinS.test_searchTrendArea("9","2018-02-01 00:00:00","2018-02-10 00:00:00","2");
				System.out.println(res);
//				System.out.println(jilinS.sumSearchCounts(res));
			}
	//入库BdSearchCrowdPItem - 搜索人群地域 - 省级（all pc 和 移动）
	@Test
	public void testSeachCrowdPortraitArea_BdSearchCrowdPItem_database_province(){
//		StringBuffer res =jilinS.test_seachCrowdPortraitArea("9", "2018-01-01 00:00:00", "4", "1", "9", "", "", ""); //看接口返回
		Map<String,String>res = jilinS.test_data_BdSearchCrowdPItem("2018-01-01 00:00:00", "2018-01-31 00:00:00", "1", "9", "吉林", "4");

		System.out.println(res.toString());
	}
	//入库BdSearchCrowdPItem - 搜索人群地域 - 市级（all pc 和 移动）
	@Test
	public void testSeachCrowdPortraitArea_BdSearchCrowdPItem_database_city_all(){
//		StringBuffer res =jilinS.test_seachCrowdPortraitArea("9", "2018-01-01 00:00:00", "4", "0", "10", "", "", "");
		Map<String,String>res = jilinS.test_data_BdSearchCrowdPItem("2018-01-01 00:00:00", "2018-01-31 00:00:00", "2", "10", "乌鲁木齐", "4");

		System.out.println(res.toString());
	}
	//page：概述-搜索指数概况-全国 - 接口： 搜索趋势-地域-接口 （all pc 和 移动）
		@Test
		public void testTrendArea_overviewIndex_country(){ 
			StringBuffer res =jilinS.test_searchTrendArea("9","2017-02-04 00:00:00","2017-02-10 00:00:00","2");
//			System.out.println(res);
			System.out.println((double)jilinS.sumSearchCounts(res)/7);
//			可以用sql：SELECT SUM(searchcount)/30 from Adx.BdSearchItem WHERE time >= '20180112' and time <= '20180210' and datasource=0; -- 搜索趋势-地域接口入库
		}
		//page：概述-搜索指数概况-省级 - 接口：搜索人群画布-地域
		@Test
		public void testTrendArea_overviewIndex_city(){
//			StringBuffer res =jilinS.test_seachCrowdPortraitArea("9", "2018-01-01 00:00:00", "4", "0", "10", null, "0,1", "0,1,2,3,4,5,6"); // 月颗粒 北京
			Map<String,String>res = jilinS.test_data_BdSearchCrowdPItem("2018-01-01 00:00:00", "2018-01-31 00:00:00", "1", "9", "北京", "4");
			Double res_per=new Double( res.get("searchCount"));
			System.out.println(res.toString()+"月均量="+res_per/1);  //3个月则除以3
			//SELECT * from Adx.BdSearchCrowdPItem WHERE daterange='20180101 ~ 20180131' and tag='北京';
		}
		
		
	//page：概述-搜索指数趋势-全国 - 接口： 搜索趋势-地域-接口 （all pc 和 移动）
	@Test
	public void testTrendArea_overviewIndexTrends_country(){ 
		StringBuffer res =jilinS.test_searchTrendArea("9","2018-01-12 00:00:00","2018-02-10 00:00:00","0");
		System.out.println(res);
//		可以用sql： SELECT time,SUM(searchcount) from Adx.BdSearchItem WHERE datasource=2 and time>='20180204' and time<='20180210' GROUP BY time；

	}
	//page：概述-搜索指数趋势-市级 - 接口：搜索人群画布-地域
	@Test
	public void testTrendArea_overviewIndexTrends_city(){
//		StringBuffer res =jilinS.test_seachCrowdPortraitArea("9", "2018-01-01 00:00:00", "4", "0", "10", null, "0,1", "0,1,2,3,4,5,6"); // 月颗粒 北京
		Map<String,String>res = jilinS.test_data_BdSearchCrowdPItem("2017-11-01 00:00:00", "2017-11-30 00:00:00", "1", "9", "北京", "4");
		System.out.println(res.toString());
		//SELECT * from Adx.BdSearchCrowdPItem WHERE daterange='20180101 ~ 20180131' and tag='北京';
	}
	//page：概述-热门景区分布 - 搜索用户 - 接口：搜索人群画像-地域
	@Test
	public void testTrendArea_overviewHotView_search(){
		//全国热门景区的占比
//		StringBuffer res =jilinS.test_seachCrowdPortraitArea("9", "2018-01-01 00:00:00", "4", "1", "5", "131", "0,1", "0,1,2,3,4,5,6"); // 月颗粒 北京
//		System.out.println(res);
		//吉林热门景区占比情况（没有排序）
		Map<String,Double>test =jilinS.checkJLviews("9", "2018-01-01 00:00:00", "4", "0",null);
		System.out.println("test="+test.toString());
	}
	//page：概述-热门景区分布 - 搜索用户-省市级 - 接口：搜索人群画像-地域
	@Test
	public void testTrendArea_overviewHotView_search_province(){
		StringBuffer res =jilinS.test_seachCrowdPortraitArea("9", "2017-12-01 00:00:00", "4", "1", "5", null, "0,1", "0,1,2,3,4,5,6"); // 月颗粒 北京
		System.out.println(res);
	}
	//page：概述-热门景区分布 - 游客 - 接口：游客画像-地域
	@Test
	public void testTrendArea_overviewHotView_tourists(){
		StringBuffer res =jilinS.test_TouristsCrowdPortraitArea("9", "2018-01-01 00:00:00", "4", "5", null,  "0,1", "0,1,2,3,4,5,6");
		System.out.println(res);
	}
	//page：搜索行为分布-搜索词明细分析 - 接口：搜索关注点-地域
	@Test
	public void testBehaviorDistributed_searchKeyAnalysis(){
		StringBuffer res =jilinS.test_searchFocusArea("9","2018-02-01 00:00:00","2018-02-11 00:00:00","0");
		System.out.println(res);
	}
	
	//page：搜索行为分布-搜索点击去向分析 - 接口：搜索关注点-地域
	@Test
	public void testSearchBehaviorDistributed_searchClickDirectionAnalysis(){ 
		StringBuffer res =jilinS.test_searchClickdDirectionArea("9", "2018-02-12 00:00:00","2018-02-12 00:00:00", "1", "0", "10");
		System.out.println(res);
//		ArrayList<Map<String,Integer>>  clickMap= jilinS.searchClick("9", "2018-02-12 00:00:00","2018-02-12 00:00:00", "0");
//		for(int i=0;i<clickMap.size();i++){
//			System.out.println(clickMap.get(i).toString());
//		}
		
	}

	//page：搜索行为分布-搜索人群地域分布 - 省级/市级 - 表名BdSearchCrowdPItem
	@Test
	public void testSearchBehaviorDistributed_searchCrowdAreaDistributed_province(){ //需要显示搜索量
		StringBuffer res =jilinS.test_seachCrowdPortraitArea("9", "2018-01-01 00:00:00", "4", "1", "10", null,  "0,1", "0,1,2,3,4,5,6");
		System.out.println(res);
		//online database= PassengerAnalysisiSys
//SELECT * from Adx.BdSearchCrowdPItem WHERE daterange='20180101 ~ 20180131' and datasource=1 ORDER BY searchcount DESC; -- 搜索人群画像--地域(省份)接口入库
//SELECT * from Adx.BdSearchCrowdCItem WHERE daterange='20180101 ~ 20180131' and datasource=0 ORDER BY searchcount DESC; -- 搜索人群画像--地域(城市)接口入库

	}
	
	
	//page：搜索人群分析-搜索人群属性分析 - 接口：搜索人群画像(如性别)
	//page：搜索人群分析-搜索人群偏好分析 - 接口：搜索人群画像-接口
	/**
	 * tagType 画像类型：7,性别分布-6,人生阶段-8,年龄分布-2,消费水平-1,行业分布
	 * 3 旅行方式-4,旅途出行方式-15,酒店类型-;12,景点类型  
	 */
	@Test
	public void testSearchCrowdAnalysis_searchCrowAnalysis(){
		String tagType="12";
		StringBuffer res =jilinS.test_seachCrowdPortraitArea("9", "2018-01-01 00:00:00", "4", "0", tagType, "131","0,1", "0,1,2,3,4,5,6");
		System.out.println(res);
	}
	
	//page：游客人群属性-游客人群属性分析 - 接口：游客画像-月度(如人生阶段)
	//page：游客旅游偏好-游客人群偏好分析 - 接口：游客人群画像(如 出行方式)
	/**
	 * tagType 画像类型：7,性别分布-6,人生阶段-8,年龄分布-2,消费水平-1,行业分布
	 * 3 旅行方式-4,旅途出行方式-15,酒店类型-;12,景点类型  
	 */
	@Test
	public void test_touristsCrowdAttributes_touristsCrowdAnalysis(){
		String tagType="3";
		StringBuffer res =jilinS.test_TouristsCrowdPortraitArea("9", "2018-01-01 00:00:00", "4",tagType , "6", "0,1", "0,1,2,3,4,5,6");
		System.out.println(res);
	}
	
	//page：游客人群属性-游客来源地域分析 - 省级 - 接口：游客画像-地域
	@Test
	public void test_touristsCrowdAttributes_touristsSourceAreaAnalysis_province(){
		StringBuffer res =jilinS.test_TouristsCrowdPortraitArea("9", "2017-12-01 00:00:00", "4",  "10", null, "0,1", "0,1,2,3,4,5,6");
		System.out.println(res);
	}
	//page：游客浏览路径分析
	@Test
	public void test_touristsPreference_touristsPathAnalysis1(){
		StringBuffer res =jilinS.test_touristsTraceArea("9",  "2018-02-01 00:00:00", "2018-02-06 00:00:00", "0","10000");
		System.out.println(res);
	}

	//page：游客旅游偏好-游客游览路径分析- 接口：游客游览路径-地域
	@Test
	public void test_touristsPreference_touristsPathAnalysis2(){
		String visitorsName="长白山";
		int num=1;
		StringBuffer res =jilinS.test_touristsTraceArea("9", "2018-02-05 00:00:00", "2018-02-11 00:00:00", "0", "10000");
//		System.out.println(res.toString());
		resclass =jilinS.jsonToObj(res.toString());
		Map<String, Integer> visitorMap =new HashMap<String, Integer>();
//		visitorsSum.put(visitorsName, 0);
		String Scenic=null;
		Integer Snum=null;
		List<List<String>> pathlist=new ArrayList<List<String>>();
		for( Items item:resclass.getData().getItems()){
			Scenic=item.getPath().get(num-1);
			if(Scenic.equals(visitorsName)){
				pathlist.add(item.getPath());
			}
			if (!visitorMap.containsKey(Scenic)){
				visitorMap.put(Scenic, item.getUv());
			}else {
				Snum=visitorMap.get(Scenic);
				visitorMap.put(Scenic, Snum+item.getUv());
			}
		}
		if (visitorMap.containsKey(visitorsName)){
			System.out.println(visitorsName +"="+visitorMap.get(visitorsName));
			System.out.println("pathlist = "+pathlist.toString());
		}else{
			System.out.println(visitorsName +"is not exist");
		}
		
	}
	/**
	 * 未经过测试 传入景点及是路线中的第一个或第二个，打印所有该景点为第一/二个的景点路线，及uv
	 * 传入路线是第一个景点的名称，打印该景点是路线第一个的uv总数
	 * 传入路线是第二个景点的名称，打印该景点是路线第一个的uv总数
	 */
	@Test
	public void test_touristsPreference_touristsPathAnalysis3(){
		jilinS.touristsPath("9", "2018-02-05 00:00:00",  "2018-02-11 00:00:00", "长白山", 1,"长白山","长白山");
	}
	
	public static void main(String[] args) {
		jilinTourismTest test =new jilinTourismTest();
//		test.testTrendArea_pc();
//		test.testTrendArea_mobile();
//		test.testTrendArea_database_mobile();//搜索趋势-地域-接口 - 无线端
//		test.testSeachCrowdPortraitArea_BdSearchCrowdPItem_database_province_pc();
//		test.testSeachCrowdPortraitArea_BdSearchCrowdPItem_database_province_moblile();
//		test.testSeachCrowdPortraitArea_BdSearchCrowdPItem_database_city_pc();
//		test.testSeachCrowdPortraitArea_BdSearchCrowdPItem_database_city_moble();
//		test.testTrendArea_overviewIndexTrends_country();//page：概述-搜索指数趋势-全国
//		test.testTrendArea_overviewIndexTrends_city(); //概述-搜索指数趋势-市级
//		test.testTrendArea_overviewHotView_search(); //概述-人们景区分布-全体网名

	}

}
