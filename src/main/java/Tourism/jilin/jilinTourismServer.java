package Tourism.jilin;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;

import java.security.MessageDigest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

import com.Interface.baseHttpClient;
import com.gargoylesoftware.htmlunit.javascript.host.intl.Collator;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import dsp.usercenter.test.interfaceCenter;
import dsp.usercenter.test.newRegister;
import test.log.server.logHandler;


public class jilinTourismServer {
	private baseHttpClient bhc =null;
	private jilinParams jlParams=null;
	private String url=null;
	private Logger logger =LogManager.getLogger(jilinTourismServer.class.getName());
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
	/**
	 * 将json格式转化为obj
	 * @param res
	 * @return
	 */
		public resClass  jsonToObj(String res){
			Gson gs = new Gson();
			resClass resclass =new resClass();
			resclass = gs.fromJson(res, resClass.class);
			return resclass;
		}
		/**
		 * 将json格式转化为obj
		 * @param res
		 * @return
		 */
			public resClassForArea  jsonToObj_area(String res){
				Gson gs = new Gson();
				resClassForArea resclass =new resClassForArea();
				resclass = gs.fromJson(res, resClassForArea.class);
				return resclass;
			}
		/**
		 * 将obj格式转化为String
		 * @param resclass
		 * @return
		 */
		public String  ObjToJson(resClass resclass){
			Gson gs = new Gson();
			return gs.toJson(resclass);
		}
		/**
		 * 汇总搜索量，将搜索趋势的string结果为参数
		 * @param res
		 * @return
		 */
		public int sumSearchCounts(StringBuffer res){
			resClass resclass =new resClass();
			resclass =jsonToObj(res.toString());
			int sum=0;
			for(Items item:resclass.getData().getItems()){
				int s =new Integer(item.getSearchCount()) ;
				sum+=s;
			}
			return sum;
		}
		/**
		 * 返回该省所有城市 城市id 景点 景点ID
		 * @param itemId  省id 吉林为9
		 * @return 返回该省级所有的景点  map: areaNameList areaIDList viewNameList  viewIDlist
		 */
		public Map<String, List<String>> summaryView(String itemId ){
			if(test_areaList()==null){
	    		return null;
	    	}
			String res1 =test_areaList().toString();
			String res2 =test_ViewPoint().toString();

			resClassForArea areaList= jsonToObj_area(res1);
			resClassForArea viewList= jsonToObj_area(res2);
			
			Map<String,List<String>> map =new HashMap<String, List<String>>();
			List<String> cityNameList=new ArrayList<String>();
			List<String> cityIDlist=new ArrayList<String>();
			List<String> viewNameList=new ArrayList<String>();
			List<String>viewIDlist=new ArrayList<String>();
			for(Data data: areaList.getData()){  //拿到该省的所有城市名称和城市ID
				if(data.getId() ==Integer.valueOf(itemId)){
					for (Children children:data.getChildren()){
						cityIDlist.add(Integer.toString(children.getId()));
						cityNameList.add(children.getName());
					}
				}	
			}

			String cityID=null;
			for(Data dataView:viewList.getData()){
				cityID=Integer.toString(dataView.getCityId());
				if(cityIDlist.contains(cityID)){
					viewNameList.add(dataView.getName());
					viewIDlist.add(Integer.toString(dataView.getId()));
				}
			}
			map.put("cityNameList", cityNameList);
			map.put("cityIDList", cityNameList);
			map.put("viewNameList", viewNameList);
			map.put("viewIDlist", viewIDlist);

			return map;
		}
			
	
	/**
	 * 返回该省的所有景点及对应的全网搜索占比
	 * @param itemId  省id 吉林为9
	 * @param time 开始时间unix时间戳
	 * @param gran 粒度：3,周; 4,月
	 * @param datasource 终端类型：1,PC;2,无线;其他0,全部
	 * @param districtId 页面选择省市 131北京，9吉林省，为空则全国
	 * @return
	 */
		public Map<String, Double> checkJLviews(String itemId,String time,String gran,String datasource ,String districtId ){
			//返回吉林的所有城市和景点汇总，为空则null
			Map<String, List<String>> viewlist= summaryView(itemId);
			if(viewlist==null){
				return null;
			}
			//执行搜索人群画布接口获取信息
			StringBuffer res =test_seachCrowdPortraitArea(itemId,time, gran, datasource, "5", districtId, "0,1", "0,1,2,3,4,5,6"); 
			resClass resclass =jsonToObj(res.toString());
			//创建返回类型map
			 Map<String, Double> areaView=new HashMap<String, Double>();
			
			//将所有是吉林省内景点的汇总到一起
			for(Items item:resclass.getData().getItems()){
				String viewName =item.getTag();
				if(viewlist.get("viewNameList").contains(viewName)){
					areaView.put(viewName, item.getRatio());
				}
			}
				return areaView;
		}
		/**
		 * 返回域名和点击量的列表
		 * @param itemId  省id 吉林为9
		 * @param startTime
		 * @param endTime
		 * @param datasource 终端类型：1,PC;2,无线;其他0,全部
		 * @return
		 */
		public ArrayList<Map<String,Integer>> searchClick(String itemId,String startTime,String endTime ,String datasource){
			StringBuffer res =test_searchClickdDirectionArea(itemId, startTime,endTime, datasource, "0", "10");
//			System.out.println(res);
			resClass resc=jsonToObj(res.toString());
			ArrayList<Map<String, Integer>> webList=new ArrayList<Map<String,Integer>>();
			for(Items item:resc.getData().getItems()){
				Map<String, Integer> newMap =new HashMap<String, Integer>();
				newMap.put(item.getDomain(), item.getClickCount());
				webList.add(newMap);
			}
			return webList;
		}
		
		/**
		 * 
		 * @param itemId  省id 吉林为9
		 * @param startTime
		 * @param endTime
		 * @param ViewName 查询的景点名称
		 * @param step （int） 首选 =1或 第二选择的=2
		 *  @param 路线中排第一的景点名称，打印uv总数
		 *  @param 路线中排第二的景点名称，打印uv总数
		 */
		public void touristsPath(String itemId,String startTime,String endTime,String viewName,int step,String firstAreaName,String secodAreaName){
			StringBuffer res =test_touristsTraceArea("9",startTime, endTime, "0", "10000");
//			logger.warn(res.toString());
			resClass resclass =jsonToObj(res.toString());
			if(resclass.getErrno()==102){
	    		return;
	    	}
			Map<String, Integer> pathlist=new TreeMap<String, Integer>();
			Map<String,Integer> firstViewList=new TreeMap<String, Integer>();
			Map<String,Integer>secondViewList=new TreeMap<String, Integer>();
			for(Items item : resclass.getData().getItems()){
				String firstView =item.getPath().get(0);
				String secodView =item.getPath().get(1);
				int uv=item.getUv();
				if(!firstViewList.containsKey((String)firstView)){
					firstViewList.put(firstView, uv);
				}else{
					firstViewList.put(firstView, firstViewList.get(firstView)+uv);  //可能出现null+1
				}
				
				if(!secondViewList.containsKey((String)secodView)){
					secondViewList.put(secodView, uv);
				}else{
					secondViewList.put(secodView, secondViewList.get(secodView)+uv);  //可能出现null+1
				}
				
				
//				secondViewList.put(item.getPath().get(1), secondViewList.get(item.getPath().get(1))+item.getUv());  //可能出现null+1
				if(item.getPath().get(step-1).equals(viewName)){
					pathlist.put(item.getPath().toString(),item.getUv());
					
				}
			}
			sortMapValue(pathlist);
			System.out.println(pathlist);
			System.out.println("1sumUV="+firstViewList.get(firstAreaName));
			System.out.println("2sumUV="+secondViewList.get(secodAreaName));
		}
		
		
		
		public void sortMapValue(Map<String, Integer> map){
//			Map<String, Integer> map = new TreeMap<String, Integer>();
//	        map.put("a",2);
//	        map.put("c", 3);
//	        map.put("d", 1);
//	        map.put("b", 4);
	        
	        //这里将map.entrySet()转换成list
	        List<Map.Entry<String,Integer>> list = new ArrayList<Map.Entry<String,Integer>>(map.entrySet());
	        //然后通过比较器来实现排序
	        Collections.sort(list,new Comparator<Map.Entry<String,Integer>>() {
	            //升序排序
	            public int compare(Map.Entry<String, Integer> o1,Map.Entry<String, Integer> o2) {
	                return o2.getValue().compareTo(o1.getValue());
	            }
	        });
	        
	        for(Map.Entry<String,Integer> mapping:list){ 
	               System.out.println(mapping.getKey()+":"+mapping.getValue()); 
	          } 
	    }
		
			
			
		/**
		 * 返回所有省市及ID
		 * @return
		 */
	    public StringBuffer test_areaList(){   	
//	    	this.setTs(Long.toString(new Date().getTime()));
	    	jlParams.setAid("1");
	    	jlParams.setSk();
	    	setUrl(jlParams.getUrl_base()+"?ak="+jlParams.getAk()+"&sk="+jlParams.getSk() +"&ts="+jlParams.getTs()+"&aid="+jlParams.getAid());
	    	System.out.println(url);
	    	StringBuffer res = bhc.doGet(getUrl());
	    	System.out.println(res);
	    	if(jsonToObj_area(res.toString()).getErrno()==102){
	    		return null;
	    	}
			return res;
	    }
	    public StringBuffer test_ViewPoint(){	
	    	jlParams.setAid("2");
	    	jlParams.setSk();
	    	setUrl(jlParams.getUrl_base()+"?ak="+jlParams.getAk()+"&sk="+jlParams.getSk()+"&ts="+jlParams.getTs()+"&aid="+jlParams.getAid());
	    	System.out.println(url);
	    	StringBuffer res = bhc.doGet(url);
	    	if(jsonToObj_area(res.toString()).getErrno()==102){
	    		return null;
	    	}
			return res;
	    }
	    /**
	     * 搜索趋势-地域 aid=1
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
	 * 搜索人群画像-地域 aid=2
	 * @param  itemId 地域id 吉林id=9  北京id=131
	 * @param time 开始时间unix时间戳
	 * @param gran 粒度：3,周; 4,月
	 * @param datasource 终端类型：1,PC;2,无线;其他0,全部
	 * @param tagType 画像类型：1,行业分布;2,消费水平;3 旅行方式；4,旅途出行方式;5,旅游偏好地;6,人生阶段;7,性别分布;8,年龄分布;9,所在省份;10,所在城市;11,资产情况;12,景点类型;13,出国目的地;14,旅游网站偏好;15,酒店类型;16,口味偏好;17,菜系偏好;18,菜品偏好
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
		 * 游客人群画像-地域 aid=49
		 * @param  itemId 地域id 吉林id=9  北京id=131
		 * @param time 开始时间unix时间戳
		 * @param gran 粒度：3,周; 4,月
		 * @param tagType 画像类型：1,行业分布;2,消费水平;4,旅途出行方式;5,旅游偏好地;6,人生阶段;7,性别分布;8,年龄分布;9,所在省份;10,所在城市;11,资产情况;12,景点类型;13,出国目的地;14,旅游网站偏好;15,酒店类型;16,口味偏好;17,菜系偏好;18,菜品偏好
		 * @param districtId 地域筛选,可使用省份或者城市id进行筛选
		 * @param gender 性别筛选：0,女;1,男。可多选，多选时以逗号分割，如："0,1"表示"男和女"
		 * @param age 年龄段筛选：0,18以下;1,18-24;2,25-34;3,35-44;4,45-54;5,55-64;6,65以上。可多选，多选时以逗号分割，如"0,2,3"表示"18岁以下或者25~44岁之间"
		 * @return
		 */
	    public StringBuffer test_TouristsCrowdPortraitArea(String itemId,String strTime,String gran,String tagType,String districtId,String gender ,String age){
	    	jlParams.setAid("49");
	    	jlParams.setSk();
	    	jlParams.setTime(strTime);
	    	
	    	setUrl(jlParams.getUrl_base()+"?ak="+jlParams.getAk()+"&sk="+jlParams.getSk()+"&ts="+jlParams.getTs()+"&aid="+jlParams.getAid()+"&itemId="+itemId+"&time="+jlParams.getTime()+"&gran="+gran+"&tagType="+tagType+"&districtId="+districtId+"&gender="+gender+"&age="+age);
			System.out.println(url);
	    	StringBuffer res = bhc.doGet(url);
	    	return res;
	    }
	    /**
	     * 搜索关注点-地域 aid=9
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
	     *游客轨迹-地域 aid=42
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
	   /**
	    * 搜索点击去向-地域 aid=11
	    * @param itemId 地域ID
	    * @param startTimeunix 时间戳, 起始时间
	    * @param endTime 时间戳, 结束时间
	    * @param datasource 终端类型：1,PC;2, 无线; 其他0, 全部
	    * @param offset 分页参数：偏移量
	    * @param pageSize 分页参数：返回数据条数，最⼤为1000
	    * @return
	    */
	    public StringBuffer test_searchClickdDirectionArea(String itemId,String startTime,String endTime,String datasource,String offset,String pageSize){	   
	    	jlParams.setAid("11");
	    	jlParams.setSk();
	    	jlParams.setSt(startTime);
	    	jlParams.setEt(endTime);
	    	setUrl(jlParams.getUrl_base()+"?ak="+jlParams.getAk()+"&sk="+jlParams.getSk()+"&ts="+jlParams.getTs()+"&aid="+jlParams.getAid()+"&itemId="+itemId+"&st="+jlParams.getSt()+"&et="+jlParams.getEt()+"&datasource="+datasource+"&offset="+offset+"&pageSize="+pageSize);
	    	System.out.println(url);
	    	StringBuffer res = bhc.doGet(url);
			return res;
		    }
	    /**
	     * 游客来源-地域
	     * @param itemId
	     * @param startTime
	     * @param endTime
	     * @return
	     */
	    public StringBuffer test_TouristSourceArea(String itemId,String startTime,String endTime ){	   
	    	jlParams.setAid("38");
	    	jlParams.setSk();
	    	jlParams.setSt(startTime);
	    	jlParams.setEt(endTime);

	    	setUrl(jlParams.getUrl_base()+"?ak="+jlParams.getAk()+"&sk="+jlParams.getSk()+"&ts="+jlParams.getTs()+"&aid="+jlParams.getAid()+"&itemId="+itemId+"&st="+jlParams.getSt()+"&et="+jlParams.getEt());
	    	System.out.println(url);
	    	StringBuffer res = bhc.doGet(url);
			return res;
		    }
	    /**
	     * 游客去向-地域  
	     * @param itemId
	     * @param startTime
	     * @param endTime
	     * @return
	     */
	    public StringBuffer test_TouristDestinationArea(String itemId,String startTime,String endTime ){	   
	    	jlParams.setAid("40");
	    	jlParams.setSk();
	    	jlParams.setSt(startTime);
	    	jlParams.setEt(endTime);

	    	setUrl(jlParams.getUrl_base()+"?ak="+jlParams.getAk()+"&sk="+jlParams.getSk()+"&ts="+jlParams.getTs()+"&aid="+jlParams.getAid()+"&itemId="+itemId+"&st="+jlParams.getSt()+"&et="+jlParams.getEt());
	    	System.out.println(url);
	    	StringBuffer res = bhc.doGet(url);
			return res;
		    }
	/**
	 * 入库测试 一致占比，计算搜索量
	 * @param startdate 格式如2018-01-01 00:00:00
	 * @param enddate 格式如2018-01-01 00:00:00
	 * @param datasource 终端类型：1,PC;2, 无线; 其他0, 全部
	 * @param tagType  9是省 10是city
	 * @param areaName查看那个城市
	 * @param gran 粒度：3,周; 4,月  注意enddate的时间 否则测试结果是错误的
	 * @return
	 */
	    public Map<String, String> test_data_BdSearchCrowdPItem(String startdate,String enddate,String datasource,String tagType ,String areaName,String gran  ){
	    	StringBuffer res_searchTrend=test_searchTrendArea("9",startdate,enddate,datasource);
			StringBuffer res =test_seachCrowdPortraitArea("9", startdate, gran, datasource, tagType , "", "", "");
			Map<String, String>resMap=new HashMap<String, String>();
			int allCount =sumSearchCounts(res_searchTrend);	
			resMap.put("gran",gran);
			resMap.put("areaName",areaName);
			resMap.put("allCount", Integer.toString(allCount));
			for(Items item :jsonToObj(res.toString()).getData().getItems()){
				if(item.getTag().equals(areaName)){ //选择地域
					double searchCount =(item.getRatio()*allCount);
					resMap.put("ration", Double.toString(item.getRatio()));
					resMap.put("searchCount", Double.toString(searchCount));
					return resMap;
				}
			}
			return null;
	    }
	    
	    

	    
	public static void main(String[] args) throws ParseException {
		
	}
}
