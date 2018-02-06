package Tourism.jilin;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;

import java.security.MessageDigest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;

import com.Interface.baseHttpClient;


public class jilinTourismServer {
	private baseHttpClient bhc =null;
	private jilinParams jlParams=null;
	private String url=null;
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public jilinTourismServer(baseHttpClient bhc,jilinParams jlParams){		
		this.bhc=bhc;
		this.jlParams=jlParams;
	}
	
	    public StringBuffer test_areaList(){   	
//	    	this.setTs(Long.toString(new Date().getTime()));
	    	jlParams.setAid("1");
	    	jlParams.setSk();
	    	setUrl(jlParams.getUrl_base()+"?ak="+jlParams.getAk()+"&sk="+jlParams.getSk() +"&ts="+jlParams.getTs()+"&aid="+jlParams.getAid());
	    	System.out.println(url);
	    	StringBuffer res = bhc.doGet(getUrl());
			return res;
	    }
	    public StringBuffer test_ViewPoint(){	
	    	jlParams.setAid("2");
	    	jlParams.setSk();
	    	setUrl(jlParams.getUrl_base()+"?ak="+jlParams.getSk()+"&sk="+jlParams.getSk()+"&ts="+jlParams.getTs()+"&aid="+jlParams.getAid());
	    	System.out.println(url);
	    	StringBuffer res = bhc.doGet(url);
			return res;
	    }
	    /**
	     * 搜索趋势-地域
	     * @param itemId 地域id 吉林id=9  北京id=131
	     * @param startTime
	     * @param endTime
	     * @param datasource 终端类型：1,PC;2,无线;其他0,全部
	     * @return
	     */
	    public StringBuffer test_searchTrendArea(String itemId,String startTime,String endTime,String datasource ){	   
	    	jlParams.setAid("5");
	    	jlParams.setSk();
	    	jlParams.setSt(startTime);;
	    	jlParams.setEt(endTime);
			
	    	setUrl(jlParams.getUrl_base()+"?ak="+jlParams.getAk()+"&sk="+jlParams.getSk()+"&ts="+jlParams.getTs()+"&aid="+jlParams.getAid()+"&itemId="+itemId+"&st="+jlParams.getSt()+"&et="+jlParams.getEt()+"&datasource="+datasource);
	    	System.out.println(url);
	    	StringBuffer res = bhc.doGet(url);
			return res;
	    }
	/**
	 * 搜索人群画像-地域
	 * @param  itemId 地域id 吉林id=9  北京id=131
	 * @param time 开始时间unix时间戳
	 * @param gran 粒度：3,周; 4,月
	 * @param datasource 终端类型：1,PC;2,无线;其他0,全部
	 * @param tagType 画像类型：1,行业分布;2,消费水平;4,旅途出行方式;5,旅游偏好地;6,人生阶段;7,性别分布;8,年龄分布;9,所在省份;10,所在城市;11,资产情况;12,景点类型;13,出国目的地;14,旅游网站偏好;15,酒店类型;16,口味偏好;17,菜系偏好;18,菜品偏好
	 * @param districtId 地域筛选,可使用省份或者城市id进行筛选
	 * @param gender 性别筛选：0,女;1,男。可多选，多选时以逗号分割，如："0,1"表示"男和女"
	 * @param age 年龄段筛选：0,18以下;1,18-24;2,25-34;3,35-44;4,45-54;5,55-64;6,65以上。可多选，多选时以逗号分割，如"0,2,3"表示"18岁以下或者25~44岁之间"
	 * @return
	 */
	    public StringBuffer test_seachCrowdPortraitArea(String itemId,String strTime,String gran,String datasource,String tagType,String districtId,String gender ,String age){
	    	jlParams.setAid("13");
	    	jlParams.setSk();
	    	jlParams.setTime(strTime);
	    	
	    	setUrl(jlParams.getUrl_base()+"?ak="+jlParams.getAk()+"&sk="+jlParams.getSk()+"&ts="+jlParams.getTs()+"&aid="+jlParams.getAid()+"&itemId="+itemId+"&time="+jlParams.getTime()+"&gran="+gran+"&datasource="+datasource+"&tagType="+tagType+"&districtId="+districtId+"&gender="+gender+"&age="+age);
			System.out.println(url);
	    	StringBuffer res = bhc.doGet(url);
	    	return res;
	    }
		/**
		 * 游客人群画像-地域
		 * @param  itemId 地域id 吉林id=9  北京id=131
		 * @param time 开始时间unix时间戳
		 * @param gran 粒度：3,周; 4,月
		 * @param datasource 终端类型：1,PC;2,无线;其他0,全部
		 * @param tagType 画像类型：1,行业分布;2,消费水平;4,旅途出行方式;5,旅游偏好地;6,人生阶段;7,性别分布;8,年龄分布;9,所在省份;10,所在城市;11,资产情况;12,景点类型;13,出国目的地;14,旅游网站偏好;15,酒店类型;16,口味偏好;17,菜系偏好;18,菜品偏好
		 * @param districtId 地域筛选,可使用省份或者城市id进行筛选
		 * @param gender 性别筛选：0,女;1,男。可多选，多选时以逗号分割，如："0,1"表示"男和女"
		 * @param age 年龄段筛选：0,18以下;1,18-24;2,25-34;3,35-44;4,45-54;5,55-64;6,65以上。可多选，多选时以逗号分割，如"0,2,3"表示"18岁以下或者25~44岁之间"
		 * @return
		 */
	    public StringBuffer test_TouristsCrowdPortraitArea(String itemId,String strTime,String gran,String datasource,String tagType,String districtId,String gender ,String age){
	    	jlParams.setAid("49");
	    	jlParams.setSk();
	    	jlParams.setTime(strTime);
	    	
	    	setUrl(jlParams.getUrl_base()+"?ak="+jlParams.getAk()+"&sk="+jlParams.getSk()+"&ts="+jlParams.getTs()+"&aid="+jlParams.getAid()+"&itemId="+itemId+"&time="+jlParams.getTime()+"&gran="+gran+"&datasource="+datasource+"&tagType="+tagType+"&districtId="+districtId+"&gender="+gender+"&age="+age);
			System.out.println(url);
	    	StringBuffer res = bhc.doGet(url);
	    	return res;
	    }
	    /**搜索关注点-地域
	     * @param itemId 地域id 吉林id=9  北京id=131
	     * @param startTime
	     * @param endTime
	     * @param datasource 终端类型：1,PC;2,无线;其他0,全部
	     * @return
	     */
	    public StringBuffer test_searchFocusArea(String itemId,String startTime,String endTime,String datasource ){	   
	    	jlParams.setAid("9");
	    	jlParams.setSk();
	    	jlParams.setSt(startTime);
	    	jlParams.setEt(endTime);

	    	setUrl(jlParams.getUrl_base()+"?ak="+jlParams.getAk()+"&sk="+jlParams.getSk()+"&ts="+jlParams.getTs()+"&aid="+jlParams.getAid()+"&itemId="+itemId+"&st="+jlParams.getSt()+"&et="+jlParams.getEt()+"&datasource="+datasource);
	    	System.out.println(url);
	    	StringBuffer res = bhc.doGet(url);
			return res;
		    }
	    /**
	     *游客轨迹-地域
	     * @param itemId 地域ID
	     * @param startTime  unix时间戳,起始时间
	     * @param endTime   unix时间戳,结束时间
	     * @param offset 分页参数：偏移量
	     * @param pageSize  分页参数：返回数据条数，最大为10000
	     * @return
	     */
	    public StringBuffer test_touristsTraceArea(String itemId,String startTime,String endTime,String offset,String pageSize){
	    	jlParams.setAid("42");
	    	jlParams.setSk();
	    	jlParams.setSt(startTime);
	    	jlParams.setEt(endTime);
	    	setUrl(jlParams.getUrl_base()+"?ak="+jlParams.getAk()+"&sk="+jlParams.getSk()+"&ts="+jlParams.getTs()+"&aid="+jlParams.getAid()+"&itemId="+itemId+"&st="+jlParams.getSt()+"&et="+jlParams.getEt()+"&offset="+offset+"&pageSize="+pageSize);
	    	System.out.println(url);
	    	StringBuffer res = bhc.doGet(url);
			return res;
	    } 
	    
	public static void main(String[] args) throws ParseException {
		
	}
}
