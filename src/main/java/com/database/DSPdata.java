package com.database;

import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.tool.until.propertUtil;

public class DSPdata {
	static ResultSet result=null;
	static int column=1;
	static  DSPdata getResult(String host,String user,String passwd,String sql){
		dataBase db = new dataBase(host,user, passwd);
		db.buildConnection();
		result=db.getResult(sql);
		return new DSPdata();
	}
	static  DSPdata getResult(String host,String user,String passwd,String sql,int column){
		DSPdata.getResult(host,user,passwd,sql);
		DSPdata.column=column;
		return new DSPdata();
	}
	ArrayList< String> toArrayList(){
		ArrayList<String> data=new ArrayList<String> ();
		try {
			while(result.next()){
				data.add(result.getString(column));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return data;
	}
	ArrayList< ArrayList< String>> toArrayLists(){
		
		ArrayList<ArrayList<String>>datas =new ArrayList<ArrayList<String>> ();
		try {
			while(result.next()){
				ArrayList<String> data=new ArrayList<String> ();
				for(int i=1;i<=column;i++){
					data.add(result.getString(i));
				}
				datas.add(data);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return datas;
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String DBurl=propertUtil.getString("config"+File.separator+"DBConfig.properties", "test.jdbc.url");
		String user = propertUtil.getString("config"+File.separator+"DBConfig.properties", "test.jdbc.username");
		String password=propertUtil.getString("config"+File.separator+"DBConfig.properties", "test.jdbc.password");
		String sql1="SELECT mid from Adx.Ad3 WHERE cid=905";
//		ArrayList<String> alist = DSPdata.getResult(DBurl, user, password, sql).toArrayList();
//		for( String x:alist){
//			System.out.println(x);
		
		String sql2="SELECT planid,mid,name from Adx.Ad3 WHERE cid=905";
		ArrayList<ArrayList<String>> alists = DSPdata.getResult(DBurl, user, password, sql2,3).toArrayLists();
		for(int i=0;i<alists.size();i++){
			for(int j=0;j<alists.get(i).size();j++){
				System.out.print(alists.get(i).get(j));
				System.out.print("\t");
			}
			System.out.println();
		}
		
	}
	

}
