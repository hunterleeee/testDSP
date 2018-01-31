package TestLogOfUserTagStat;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.xerces.impl.xpath.regex.Match;
/**
 * 入库测试：累计访客数表USER_TAG.UserTagStat 
 * 日志来源：hadoop fs -get /user/tracking/userdigest/count/count_2017-01-10.csv_c
 * @author think
 *
 */
public class testDemo {

	public void getResult(File src,File des,String pattern){
		String line=null;
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(src)));
			BufferedWriter bw =new BufferedWriter(new OutputStreamWriter(new FileOutputStream(des)));

			int num=0;
			int tagcount=0;
			while ((line=br.readLine())!=null ){
				String [] lineList = this.splitData(line);
				System.out.println(lineList[0]+regexMatch(lineList[0],pattern));
				if(regexMatch(lineList[0],pattern)){
					num++;
					int i =Integer.valueOf(lineList[1]);
					tagcount +=i;
					}
			}
			System.out.println();
			System.out.println("patternNum" +" : "+num);
			System.out.println("patternCount" +" : "+tagcount);
			bw.write(pattern+":\n"+"patternNum" +" : "+num+"\n"+"patternCount" +" : "+tagcount);
			br.close();
			bw.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	String[] splitData (String line){
		return line.split("	");
	}
	Boolean regexMatch(String line,String pattern ){
		Pattern r =Pattern.compile(pattern);
		Matcher m =r.matcher(line);
//		System.out.println(m.group());
		return( m.matches());
	}
	
	public static void main(String[] args) {
		File src =new File("C:\\Users\\think\\Desktop\\累计访客数测试\\count_2017-01-11.csv_c");
		File des =new File("C:\\Users\\think\\Desktop\\累计访客数测试\\testres.txt");
		testDemo td =new testDemo();
		String pattern_1="^\\{X:BR,C:905.*\\}" ;  //默认访客
		String pattern_2="^\\{X:BE,C:905,M:DSPTT,V:1\\}" ;  //默认点击
		String pattern_3="^\\{X:BE,C:2299,M:TT,V:([2-9]|([0-9][0-9]+))\\}" ;  //默认收益
//		String pattern_4="^\\{X:BA,C:905,V:.+\\}";
		String pattern_5="^\\{X:BA,C:905,V:003\\}";  //自定义访客分组
		 td.getResult(src,des,pattern_3);
	}

}
