package Tourism.jilin;

import java.util.List;

import com.google.gson.Gson;

public class resClassForArea {
	public int status;
	public String msg;
	public List<Data> data;
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
	public List<Data> getData() {
		return data;
	}
	public void setData(List<Data> data) {
		this.data = data;
	}

}
