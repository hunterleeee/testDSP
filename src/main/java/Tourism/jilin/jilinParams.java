package Tourism.jilin;

import java.util.Date;

import com.Interface.baseHttpClient;

public class jilinParams extends toolsForjilinTour{
	private String url_base =null;
	private String ak=null;
	private String aid=null;
	private String apiKey=null;
	private String ts=null;
	private String sk=null;
	private String itemId=null;
	private String time=null;
	private String gran=null;
	private String datasource=null;
	private String tagType=null;
	private String districtId=null;
	private String gender=null;
	private String age=null;
	private String st=null;
	private String et=null;
	
	public jilinParams(String ak,String apiKey){
		this.ak=ak;
		this.apiKey=apiKey;
		this.ts=currentTimeTOStamp();
	}
	public jilinParams(String ak,String apiKey,String aid ){
		this.ak=ak;
		this.apiKey=apiKey;
		this.aid=aid;
		this.ts=currentTimeTOStamp();
		this.sk=getSk(ak, aid, apiKey, this.ts);
	}

	
	
	public String getUrl_base() {
		return url_base;
	}
	public void setUrl_base(String url_base) {
		this.url_base = url_base;
	}
	public String getAk() {
		return ak;
	}
	public void setAk(String ak) {
		this.ak = ak;
	}
	public String getApiKey() {
		return apiKey;
	}
	public void setApiKey(String apiKey) {
		this.apiKey = apiKey;
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
	public void setTs() {
		this.ts = currentTimeTOStamp();
	}
	public String getSk() {
		return sk;
	}
	public void setSk() {
		this.sk = getSk(ak, aid, apiKey, ts);
	}
	public String getItemId() {
		return itemId;
	}
	public void setItemId(String itemId) {
		this.itemId = itemId;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String strTime) {
		this.time = timeTOUnixStamp(strTime);
	}
	public String getGran() {
		return gran;
	}
	public void setGran(String gran) {
		this.gran = gran;
	}
	public String getDatasource() {
		return datasource;
	}
	public void setDatasource(String datasource) {
		this.datasource = datasource;
	}
	public String getTagType() {
		return tagType;
	}
	public void setTagType(String tagType) {
		this.tagType = tagType;
	}
	public String getDistrictId() {
		return districtId;
	}
	public void setDistrictId(String districtId) {
		this.districtId = districtId;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getSt() {
		return st;
	}
	public void setSt(String stTime) {
		this.st = timeTOUnixStamp(stTime);
	}
	public String getEt() {
		return et;
	}
	public void setEt(String etTime) {
		this.et = timeTOUnixStamp(etTime);
	}
	



}
