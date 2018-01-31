package AgHomePage.com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;




public class testDemo {
    private static String DBurl=null;
    private static String deviceName="com.mysql.jdbc.Driver";
    private static String user=null;
    private static String password =null;
    private static Connection conn = null;
    private static PreparedStatement  pst = null;
    private static ResultSet result =null;
    /**
 * 构造函数，且创建Connection，数据库url、用户名和密码在配置文件中读取，配置文件路径“config/DBConfig.properties"
     * @return
     */

    public  void buildConnection(){
    	String DBurl="jdbc:mysql://l-db1-1.dev.cn2.corp.agrant.cn:3306/";
    	String user = "junfeng.li";
    	String password="D2cE146vDEFzJUmSNH9ve49yKtAeLc22DY78JaFVTtVm7bziv2xz0voMucn2";

        try{
            Class.forName(deviceName);//加载
            conn=DriverManager.getConnection(DBurl, user, password);//获取连接
        }catch(SQLException e){
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
    public ResultSet getResult(String sql){
        try {
            pst = conn.prepareStatement(sql);
            result = pst.executeQuery();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return result;    	
    }
    
    
    public void showResult(){
    	String customerCostSQL="SELECT cid,dateline ,DATE_FORMAT(dateline,'%Y %v') as yw,DATE_FORMAT(dateline,'%Y %m') as ym,sum(cost)/1000000 as COST,sum(impression) as IMP,sum(click) as CLICK,(sum(cost)/sum(impression))/1000 as CPM,sum(cost)/SUM(click)/1000000 AS CPC,SUM(click)*100/SUM(impression) AS CTR from Adx.CustomerCost_201707 WHERE dateline>='20170701000000' and dateline<='20170718000000' and cid=2616 group by dateline";
    	String customerRevSQL="select * from Adx.CustomerRev where  dateline>='20170701000000' and dateline<='20170718000000' and cid=2616 group by dateline";
    	String pvSournSQL="SELECT dateline,cid,SUM(entryvisit) as sumentryvisit FROM TRACKING.PvSourceDay_201707 WHERE cid=2616 group by dateline";
    	this.buildConnection();
    	ResultSet resCost =this.getResult(customerCostSQL);
    	
    	
    	
    	this.closeConn();
    }
    
    public void closeConn(){
    	try {
    		pst.close();
			conn.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		testDemo td =new testDemo();

	}

}
