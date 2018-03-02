package Tourism.jilin;

import java.util.List;

import com.google.gson.Gson;

public class resClass {
	public int status;
	public String msg;
	public Data data;
	public List<Data> datalist;
	public int errno;
	
	public String toString(){
		Gson gs = new Gson();
		String res= gs.toJson(this);
		return res;
	}
	
	public int getErrno() {
		return errno;
	}

	public void setErrno(int errno) {
		this.errno = errno;
	}

	public List<Data> getDatalist() {
		return datalist;
	}

	public void setDatalist(List<Data> datalist) {
		this.datalist = datalist;
	}

	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Data getData() {
		return data;
	}
	public void setData(Data data) {
		this.data = data;
	}

}
