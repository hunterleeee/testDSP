package com.auto.test;

import static org.junit.Assert.assertTrue;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import junit.framework.TestCase;
import net.sourceforge.htmlunit.corejs.javascript.tools.debugger.Main;
import test.audit.auditCenter;

public class auditTest extends TestCase {
	private auditCenter  auditCenter_connect=null;

	/**
	 * 使用构造函数执行bean注入失败
	 */
	public  auditTest(){
		ApplicationContext context1 = new FileSystemXmlApplicationContext("E:\\Project\\Java\\testDSP\\config\\autoTest.xml");
		this.auditCenter_connect= (auditCenter) context1.getBean("auditcenter");
	}
	
//	public void initauditTest(){
//		ApplicationContext context1 = new FileSystemXmlApplicationContext("E:\\Project\\Java\\testDSP\\config\\autoTest.xml");
//		auditCenter testConnect= (auditCenter) context1.getBean("auditcenter");
//	}
	/**
	 * 测试1：
	 */

	public void testAdvte1(){
		String AdverParamds =
				"[{\"cid\":\"100372\","
				+ "\"ADVIEW_CHANNELENABLE\":0,"
//				+ "\"YOUKU_ADVERTISER\":\"苏酒集团贸易股份有限公司\","
				+ "\"ADVIEW_STATUS\":-1"
				+ "}]";
		auditCenter_connect.setAdvertiserParamr(AdverParamds);
		StringBuffer res =auditCenter_connect.modifyAdvertiser();
//		System.out.println("Working Directory = " + System.getProperty("user.dir")); 

		assertTrue(res.toString().contentEquals("{}"));
	}
	public static void main(String[] args) {
	      Result result = JUnitCore.runClasses(auditTest.class);
	      for (Failure failure : result.getFailures()) {
	         System.out.println(failure.toString());
	      }
	      System.out.println(result.wasSuccessful());
	   }

}
