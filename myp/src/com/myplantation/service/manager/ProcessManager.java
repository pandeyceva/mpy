package com.myplantation.service.manager;

import java.util.Enumeration;

import javax.servlet.http.HttpSession;

import org.json.JSONObject;

import com.myplantation.engine.DynamicServiceCaller;
import com.myplantation.utils.Validator;

public class ProcessManager extends ServiceManager{


	public  static JSONObject call(JSONObject jrequest, HttpSession session)
	{
		JSONObject jresponse = new JSONObject();

		try {
			jresponse.put("respcode", "99");
			jresponse.put("respdesc", "Service Calling Exception");
			
			String ptoken = null;
			if(!"SIGNIN".equals(jrequest.getJSONObject("jheader").getString("serviceid")))
			{
				ptoken=(String)session.getAttribute("ptoken");
			}
			
			if(!Validator.isValidToken(jrequest, ptoken))
			{
				jresponse.put("respcode", "98");
				jresponse.put("respdesc", "Invalid Token");
			}
			else
			{
				jresponse =DynamicServiceCaller.loadService(jrequest,session);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		return jresponse;
	}
}
