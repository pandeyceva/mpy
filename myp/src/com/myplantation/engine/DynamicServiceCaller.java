package com.myplantation.engine;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.json.JSONException;
import org.json.JSONObject;

import com.myplantation.service.manager.RequestManager;
import com.myplantation.service.manager.ResponseManager;
import com.myplantation.service.manager.ServiceManager;
import com.myplantation.servlet.CoreService;

public class DynamicServiceCaller {

	public static JSONObject loadService(JSONObject jrequest, HttpSession session)
	{
		JSONObject jresponse = null;
		List<Map<String, String>> MP_SERVICES=CoreService.MP_SERVICES;
		/*List<Map<String, String>> MP_SERVICES=ServiceDescriptorParser.parseXML("noauth");
		System.out.println("noauth is hardcoded for testing...");*/
	    try {
	    	System.out.println(MP_SERVICES);
	    	JSONObject jheader = jrequest.getJSONObject("jheader");
	    	String servicecode= jheader.getString("serviceid");
	    	
	    	Method requestMethod= RequestManager.class.getMethod(getServiceMethodName(MP_SERVICES, servicecode), JSONObject.class, HttpSession.class);
	    	RequestManager requestManager = new RequestManager();
			JSONObject reqjson= (JSONObject) requestMethod.invoke(requestManager,jrequest);
			
			Method serviceMethod= ServiceManager.class.getMethod(getServiceMethodName(MP_SERVICES, servicecode), JSONObject.class, HttpSession.class);
			ServiceManager serviceManager = new ServiceManager();
			JSONObject servicejson= (JSONObject) serviceMethod.invoke(serviceManager,reqjson);
			
			Method responseMethod= ResponseManager.class.getMethod(getServiceMethodName(MP_SERVICES, servicecode), JSONObject.class, HttpSession.class);
			ResponseManager responseManager = new ResponseManager();
			jresponse= (JSONObject) responseMethod.invoke(responseManager,servicejson);
			
			
			
			
			System.out.println(jresponse);
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException | JSONException e) {
			e.printStackTrace();
		}
		return jresponse;
		
	}
	
	
	public static String getServiceMethodName(List<Map<String, String>> mplist, String servicecode)
	{
		String name="nomethodmatch";
		
		for(Map<String, String> service : mplist)
		{
			if(service.get("service-code").equals(servicecode))
			{
				return service.get("service-method");
			}
		}
		
		return name;
	}
	
}
