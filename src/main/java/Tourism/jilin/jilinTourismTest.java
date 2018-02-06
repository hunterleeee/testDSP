package Tourism.jilin;

import junit.framework.TestCase;

public class jilinTourismTest extends TestCase {
	jilinTourismServer jilinS=null;
	public jilinTourismTest(){
		jilinS= new jilinTourismServer();
		
	}
	
	void testAreaList(){
		StringBuffer res =jilinS.test_areaList();
		System.out.println(res);
	}
	void testViewPoint(){

		StringBuffer res =jilinS.test_ViewPoint();
//		System.out.println(res);
	}
	void testTrendArea(){//
		StringBuffer res =jilinS.test_searchTrendArea("9","2018-01-01 00:00:00","2018-01-02 00:00:00","0");
		System.out.println(res);
	}
	void testSeachCrowdPortraitArea_HotSpotsDistribution(){//搜索人群画像-地域-热点景点分布
		StringBuffer res =jilinS.test_seachCrowdPortraitArea("9", "2018-01-01 00:00:00", "4", "1", "5", "131", null, null);
		System.out.println(res);
	}
	void testTouristsCrowdPortraitArea_HotSpotsDistribution(){ //访客人群画像-地域-热点景点分布
		StringBuffer res =jilinS.test_TouristsCrowdPortraitArea("9", "2018-01-01 00:00:00", "4", "1", "5", "131", null, null);
		System.out.println(res);
	}
	void testSearchFocusArea_keyWordAnalysis(){//搜索关注点-地域-搜索词明细分析
		StringBuffer res =jilinS.test_searchTrendArea("9","2018-01-01 00:00:00","2018-01-02 00:00:00","0");
		System.out.println(res);
	}
	void testTouristsTraceArea_TouristsTraceAreaAnalysis(){//游客游览路径-地域-游客游览路径分析
		StringBuffer res =jilinS.test_searchTrendArea("9","2018-01-01 00:00:00","2018-01-02 00:00:00","0");
		System.out.println(res);
	}

	public static void main(String[] args) {
		jilinTourismTest test =new jilinTourismTest();
		test.testTouristsTraceArea_TouristsTraceAreaAnalysis();
	}

}
