package test.log.server;

import java.lang.reflect.Modifier;

//import org.aopalliance.intercept.Joinpoint;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

import test.audit.auditCenter;

public class logHandler {
	private final Logger logger =LogManager.getLogger(logHandler.class.getName());
	
	public void modifysAuditBefore(JoinPoint joinpoint){ // JoinPoint有两个用那个？
		logger.info("execute class= ["+joinpoint.getTarget()+"],and funtion= ["+joinpoint.getSignature().getName()+"] Environment default [false for test]");
	}
	public void modifyAuditAfter(JoinPoint joinpoint,Object retValue){ // JoinPoint有两个用那个？
		logger.info("execute class= ["+joinpoint.getTarget()+"],and funtion=["+joinpoint.getSignature().getName()+"],and return= ["+retValue+"]");
	}

//	public void setBefore(){}
	public void setAuditAfter(JoinPoint joinpoint){
		Object [] args = joinpoint.getArgs();
		for (int i = 0; i < args.length; i++) {
          logger.info("class ["+joinpoint.getTarget()+"],and funtion ["+joinpoint.getSignature()+" and args_" + (i+1) + "change to:" + args[i]);
        }
	}
	public void jilinTourisemBeforeSet(JoinPoint joinpoint){
		Object [] args = joinpoint.getArgs();
		for (int i = 0; i < args.length; i++) {
          logger.info("class ["+joinpoint.getTarget()+"],and funtion ["+joinpoint.getSignature()+" and args_" + (i+1) + "change to:" + args[i]);
        }
	}
	public void jilinTourisemAfter(JoinPoint joinpoint,Object retValue){
		Object [] args = joinpoint.getArgs();
		for (int i = 0; i < args.length; i++) {
          logger.info("class ["+joinpoint.getSignature()+"] and args_" + (i+1) + "change to:" + args[i]);
        }
		logger.info("execute class= ["+joinpoint.getTarget()+"],and funtion=["+joinpoint.getSignature().getName()+"],and return= ["+retValue+"]");
	}

}
