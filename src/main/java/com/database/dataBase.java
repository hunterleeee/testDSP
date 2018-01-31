package com.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class dataBase {
	String DBurl=null;
	String deviceName="com.mysql.jdbc.Driver";
	String user=null;
	String password =null;
	Connection conn = null;
	
	
	dataBase(String dburl,String user,String password){
		this.DBurl=dburl;
		this.user=user;
		this.password=password;
	}
	
	Connection buildConnection(){
		try {
			Class.forName(deviceName);
			this.conn=DriverManager.getConnection(DBurl,user,password);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
	
	ResultSet getResult(String sql){
		ResultSet result =null;
		try {
			PreparedStatement pst =conn.prepareStatement(sql);
			result = pst.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	ResultSet getResult(String sql,ArrayList<String> parms){
		ResultSet result =null;
		try {
			PreparedStatement pst = conn.prepareStatement(sql);
			int len = parms.size();
//			System.out.println("len is"+len);
			for (int i =0; i<len; i++){
				pst.setString(i+1, parms.get(i));
			}
			result = pst.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;	
	}
	
	void showString(ResultSet result,int column){
		try {
			if(result==null){
				System.out.println("there is no data!");
			}
			else{
				while(result.next()){
					for (int i=1; i<=column; i++){
						System.out.print(result.getString(i));
						System.out.print("\t");
					}
					System.out.println();
				}
			}	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	void close(){
		try {
			this.conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[]args) throws ClassNotFoundException, InstantiationException, IllegalAccessException{
		String url="jdbc:mysql://l-db1-1.dev.cn2.corp.agrant.cn:3306/";
		String username="junfeng.li";
		String password="D2cE146vDEFzJUmSNH9ve49yKtAeLc22DY78JaFVTtVm7bziv2xz0voMucn2";
		String sql="SELECT planid,`name` from Adx.Plan WHERE cid=10542";
		dataBase db = new dataBase(url, username, password);
//		System.out.println(db.getClass());
		db.buildConnection();
//		ResultSet result = db.getResult(sql);
//		db.showString(result, 2);
		
		String sql2="SELECT planid,`name` from Adx.Plan WHERE cid=?";
		ArrayList <String> list =new ArrayList <String> ();
		list.add("10542");
		ResultSet result2=db.getResult(sql2, list) ;
		db.showString(result2, 2);
		db.close();
	}
}
