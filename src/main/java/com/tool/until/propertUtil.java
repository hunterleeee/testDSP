package com.tool.until;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;


public final class propertUtil {
	private static Properties props = null;
	private static FileReader fr = null;
	
	public static void properBase(String filename){
		try {
			fr =new FileReader(new File(filename));
			props =new Properties();
			props.load(fr);
		}catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
					}
		finally {
			if(filename!=null){
				try {
					fr.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	public static String getString(String filename,String key){
		properBase(filename);
		String value=null;
		if(props.containsKey(key))
			value= props.getProperty(key);
		return value;
	}
	

}
