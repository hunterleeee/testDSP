package test.audit;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.ConfigurationSource;
import org.apache.logging.log4j.core.config.Configurator;

import com.Interface.baseHttpClient;
import com.auto.test.auditTest;

public class auditCenter {
	private   baseHttpClient bhc=null;
	public  boolean environment= false;
	private final Logger logger =LogManager.getLogger(auditCenter.class.getName());
	
	private final String test_urlAuToAuditingAdvertiser = "http://l-test9.dev.cn2.corp.agrant.cn:8080/AdxAuditRS/ForAutoAuditServlet?method=updateCustomerStatus&channelName=BAIDU";
	private final String test_urlAuditingAdvertisement="http://l-test9.dev.cn2.corp.agrant.cn:8080/AdxAuditRS/ForAutoAuditServlet?method=updateCreativeStatus&channelName=JTX";
//	private final String test_urlAuditingAdvertisement_howToUse="http://l-test9.dev.cn2.corp.agrant.cn:8080/AdxAuditRS/WebUpdateServlet?method=updateAd3AndKvStatus";
	private final String urlAuToAuditingAdvertiser ="http://l-adxwsng.prod.cn2.corp.agrant.cn:39519/AdxAuditRS/ForAutoAuditServlet?method=updateCustomerStatus&channelName=JTX";
	private final String urlAuditingAdvertisement="http://l-adxwsng.prod.cn2.corp.agrant.cn:39519/AdxAuditRS/ForAutoAuditServlet?method=updateCreativeStatus&channelName=JTX";
	private  Map<String, String> header =new HashMap<String, String>();
	private String AdvertiserParam=null;
	private String AdvertisermentParam=null;
	private String urlAdvertiser=null;
	private String urlAdvertisement=null; 
	
	public String getUrlAdvertiser() {
		return urlAdvertiser;
	}
	public void setUrlAdvertiser(String urlAdvertiser) {
		this.urlAdvertiser = urlAdvertiser;
	}
	public String getUrlAdvertisement() {
		return urlAdvertisement;
	}
	public void setUrlAdvertisement(String urlAdvertisement) {
		this.urlAdvertisement = urlAdvertisement;
	}
	
	
	public Map<String, String> getHeader() {
		return header;
	}
	public void setHeader(Map<String, String> header) {
		this.header = header;
	}

	
	public auditCenter(baseHttpClient bhc){
		this.bhc=bhc;
//		header.put("Content-Type", "application/json");
//		header.put("token","web:doushishuaige");

	}
	public String getAdvertiserParam() {
		return AdvertiserParam;
	}
	public void setAdvertiserParamr(String advertiserParam) {
		AdvertiserParam = advertiserParam;
	}
	public String getAdvertisermentParam() {
		return AdvertisermentParam;
	}
	public void setAdvertisermentParam(String advertisermentParam) {
		AdvertisermentParam = advertisermentParam;
	}
	public boolean isEnvironment() {
		return environment;
	}
	public void setEnvironment(boolean environment) {
		this.environment = environment;
		setUrlAdvertiser(environment?urlAuToAuditingAdvertiser:test_urlAuToAuditingAdvertiser);
		setUrlAdvertisement(environment?urlAuditingAdvertisement:test_urlAuditingAdvertisement);
	}
	
	
	public StringBuffer modifyAdvertiser(){
		StringBuffer res =bhc.doPost(urlAdvertiser, header, AdvertiserParam);
		return res;
	}
	public StringBuffer modifyAdvertisment(){
		StringBuffer res =bhc.doPost(urlAdvertisement, header, AdvertiserParam);
		return res;
	}
}
