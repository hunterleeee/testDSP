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
	String url_base ="http://bdplus.baidu.com/commonapi";
	private String ak="48114bfdc3f5449a22ae46c2127f301c";
	private String aid=null;
	private String apiKey="88c9b35cbd893962b4f28561c0b70dfa";
	private String ts=Long.toString(new Date().getTime());
	private String sk=null;
	baseHttpClient bhc =new baseHttpClient();
	
	public jilinTourismServer(){		
		
	}
	
	public String getSk() {
		return sk;
	}

	public void setSk(String sk) {
		this.sk = sk;
	}
	public void setSk() {
		String before_sk=this.ak+getAid()+this.apiKey+getTs();
		byte[] byteBefore_sk = null;
		try {
			byteBefore_sk = before_sk.getBytes("UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		final Base64.Encoder encoder = Base64.getEncoder();
		final String base64_sk = encoder.encodeToString(byteBefore_sk);
		this.sk =getMD5(base64_sk);
	}	

	
	public String getAid() {
		return aid;
	}

	public void setAid(String aid) {
		this.aid = aid;
	}

	public String getTs() {
		return ts;
	}

	public void setTs(String ts) {
		this.ts = ts;
	}
	
	
		
		private  String getMD5(String str) {
	        try {
	            // 生成一个MD5加密计算摘要
	            MessageDigest md = MessageDigest.getInstance("MD5");
	            // 计算md5函数
	            md.update(str.getBytes());
	            // digest()最后确定返回md5 hash值，返回值为8为字符串。因为md5 hash值是16位的hex值，实际上就是8位的字符
	            // BigInteger函数则将8位的字符串转换成16位hex值，用字符串来表示；得到字符串形式的hash值
	            String md5=new BigInteger(1, md.digest()).toString(16);
	            //BigInteger会把0省略掉，需补全至32位
	            return fillMD5(md5);
	        } catch (Exception e) {
	            throw new RuntimeException("MD5加密错误:"+e.getMessage(),e);
	        }
	    }

	    private String fillMD5(String md5){
	        return md5.length()==32?md5:fillMD5("0"+md5);
	    }
	    
	    public  String dateToStamp(String s) throws ParseException{
	        String res;
	        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	        Date date = simpleDateFormat.parse(s);
	        long ts = date.getTime();
	        res = String.valueOf(ts);
	        return res;
	    } 
	    public  String dateToStartEndStamp(String s) throws ParseException{
	        String res;
	        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	        Date date = simpleDateFormat.parse(s);
	        long ts = date.getTime()/1000;
	        res = String.valueOf(ts);
	        return res;
	    } 
	    public StringBuffer test_areaList(){   	
//	    	this.setTs(Long.toString(new Date().getTime()));
	    	this.setAid("1");
	    	this.setSk();
	    	String url =this.url_base+"?ak="+ak+"&sk="+getSk()+"&ts="+getTs()+"&aid="+getAid();
	    	System.out.println(url);
	    	StringBuffer res = bhc.doGet(url);
			return res;
	    }
	    public StringBuffer test_ViewPoint(){	    
	    	this.setAid("2");
	    	this.setSk();
	    	String url =this.url_base+"?ak="+ak+"&sk="+getSk()+"&ts="+getTs()+"&aid="+getAid();
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
	    	this.setAid("5");
	    	this.setSk();
	    	String st=null;
	    	String et=null;
			try {
				st = dateToStartEndStamp(startTime);
				et = dateToStartEndStamp(endTime);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	String url =this.url_base+"?ak="+ak+"&sk="+getSk()+"&ts="+getTs()+"&aid="+getAid()+"&itemId="+itemId+"&st="+st+"&et="+et+"&datasource="+datasource;
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
	    public StringBuffer test_seachCrowdPortraitArea(String itemId,String time,String gran,String datasource,String tagType,String districtId,String gender ,String age){
	    	this.setAid("13");
	    	this.setSk();
	    	try {
				time = dateToStartEndStamp(time);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String url =this.url_base+"?ak="+ak+"&sk="+getSk()+"&ts="+getTs()+"&aid="+getAid()+"&itemId="+itemId+"&time="+time+"&gran="+gran+"&datasource="+datasource+"&tagType="+tagType+"&districtId="+districtId+"&gender="+gender+"&age="+age;
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
	    public StringBuffer test_TouristsCrowdPortraitArea(String itemId,String time,String gran,String datasource,String tagType,String districtId,String gender ,String age){
	    	this.setAid("49");
	    	this.setSk();
	    	try {
				time = dateToStartEndStamp(time);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String url =this.url_base+"?ak="+ak+"&sk="+getSk()+"&ts="+getTs()+"&aid="+getAid()+"&itemId="+itemId+"&time="+time+"&gran="+gran+"&datasource="+datasource+"&tagType="+tagType+"&districtId="+districtId+"&gender="+gender+"&age="+age;
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
		    	this.setAid("9");
		    	this.setSk();
		    	String st=null;
		    	String et=null;
				try {
					st = dateToStartEndStamp(startTime);
					et = dateToStartEndStamp(endTime);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		    	String url =this.url_base+"?ak="+ak+"&sk="+getSk()+"&ts="+getTs()+"&aid="+getAid()+"&itemId="+itemId+"&st="+st+"&et="+et+"&datasource="+datasource;
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
	    	this.setAid("42");
	    	this.setSk();
	    	String st=null;
	    	String et=null;
			try {
				st = dateToStartEndStamp(startTime);
				et = dateToStartEndStamp(endTime);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	String url =this.url_base+"?ak="+ak+"&sk="+getSk()+"&ts="+getTs()+"&aid="+getAid()+"&itemId="+itemId+"&st="+st+"&et="+et+"&offset="+offset+"&pageSize="+pageSize;
	    	System.out.println(url);
	    	StringBuffer res = bhc.doGet(url);
			return res;
	    }
	    
	    
	    
	public static void main(String[] args) throws ParseException {
		
		jilinTourismServer test =new jilinTourismServer();
		String ts1 =test.dateToStamp("2018-01-24 10:30:40");
		System.out.println("时间戳="+ts1);
		String ts2 =test.dateToStartEndStamp("2018-01-24 10:30:40");
		System.out.println("时间戳="+ts2);

	}
}
