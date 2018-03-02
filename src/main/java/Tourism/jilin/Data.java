package Tourism.jilin;

import java.util.List;

import com.google.gson.Gson;

public class Data {
	public String item;
	public String timeRange;
	public int total;
	public String gran;
	public String datasource;
	public String tagType;
	public String district;
	public String gender;
	public String age;
	public List<Items> items;
	
	//返回信息是地域景点方面时使用
	public int id;
	public String name;
	public List<Children>children;
	public String level;
	public int cityId;
	
	public String toString(){
		Gson gs = new Gson();
		return gs.toJson(this);
	}
	
	
	
	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public int getCityId() {
		return cityId;
	}

	public void setCityId(int cityId) {
		this.cityId = cityId;
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Children> getChildren() {
		return children;
	}
	public void setChildren(List<Children> children) {
		this.children = children;
	}

	public String getItem() {
		return item;
	}
	public void setItem(String item) {
		this.item = item;
	}
	public String getTimeRange() {
		return timeRange;
	}
	public void setTimeRange(String timeRange) {
		this.timeRange = timeRange;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public List<Items> getItems() {
		return items;
	}
	public void setItems(List<Items> items) {
		this.items = items;
	}
	
}
