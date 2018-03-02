package Tourism.jilin;

import java.util.List;

import com.google.gson.Gson;

public class Items {
	public String tag;
	public double ratio;
	public List<String> path;
	public int uv;
	public String time;
	public String searchCount;
	
	public String domain;
	public int clickCount;

	public String toString(){
		Gson gs = new Gson();
		return gs.toJson(this);
	}
	
	
	
	public String getDomain() {
		return domain;
	}



	public void setDomain(String domain) {
		this.domain = domain;
	}



	public int getClickCount() {
		return clickCount;
	}



	public void setClickCount(int clickCount) {
		this.clickCount = clickCount;
	}

	public List<String> getPath() {
		return path;
	}
	public void setPath(List<String> path) {
		this.path = path;
	}
	public int getUv() {
		return uv;
	}
	public void setUv(int uv) {
		this.uv = uv;
	}
	public String getTag() {
		return tag;
	}
	public void setTag(String tag) {
		this.tag = tag;
	}
	public double getRatio() {
		return ratio;
	}
	public void setRatio(double ratio) {
		this.ratio = ratio;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getSearchCount() {
		return searchCount;
	}
	public void setSearchCount(String searchCount) {
		this.searchCount = searchCount;
	}
	
}
