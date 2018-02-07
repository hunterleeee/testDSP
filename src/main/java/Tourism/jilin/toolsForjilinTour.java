package Tourism.jilin;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;

public class toolsForjilinTour {
	
	public static String currentTimeTOStamp(){
		return Long.toString(new Date().getTime());
	}
	/**
	 * 
	 * @param time fomat =yyyy-MM-dd HH:mm:ss
	 * @return
	 */
	public  String timeTOStamp(String time){
		 String res;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = null;
		try {
			date = simpleDateFormat.parse(time);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        long ts = date.getTime();
        res = String.valueOf(ts);
        return res;
	}
	/**
	 * 
	 * @param time fomat =yyyy-MM-dd HH:mm:ss
	 * @return
	 */
	public  String timeTOUnixStamp(String time){
		 String res;
       SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
       Date date = null;
		try {
			date = simpleDateFormat.parse(time);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
       long ts = date.getTime()/1000;
       res = String.valueOf(ts);
       return res;
	}
	
	public  String getSk(String ak,String aid,String apiKey,String ts) {
		String before_sk=ak+aid+apiKey+ts;
		String base64_sk=getBase64(before_sk);
		return getMD5(base64_sk);
	}	
	
	private String getBase64(String str){
		byte[] byteBefore_sk = null;
		try {
			byteBefore_sk = str.getBytes("UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Base64.getEncoder().encodeToString(byteBefore_sk);
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
}
