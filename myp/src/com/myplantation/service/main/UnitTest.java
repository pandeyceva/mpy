package com.myplantation.service.main;

import org.json.JSONException;
import org.json.JSONObject;

import com.myplantation.service.manager.ProcessManager;

public class UnitTest {
	
public static void main(String[] args) {

	try {
		
		/**
		 * 0. Error code Management 		||->
		 
		 */
		System.out.println(run(cussignup()));
		
		
	} catch (Exception e) {
		e.printStackTrace();
	}
}

public static JSONObject run(JSONObject jrequest) throws JSONException
{

	return ProcessManager.call(jrequest,null);
}

public static JSONObject cussignup()
{
	JSONObject jrequest = new JSONObject();
	try {
		JSONObject jheader = new JSONObject();
		JSONObject jbody = new JSONObject();
		
		
		jheader.put("mobileno", "2348186016608");
		jheader.put("flowid", "1234567890");
		jheader.put("serviceid", "CUSSIGNUP");
		jheader.put("timestamp", "25082018140430");//ddMMyyyyhhmmss

		jbody.put("fname", "Rajkumar");
		jbody.put("lname", "Pandey");
		jbody.put("email", "rajkumarpandey786@gmail.com");
		jbody.put("address", "Plot:64, Sector-12, MVP Colony");
		jbody.put("City", "Visakhapatnam"); // select box
		jbody.put("state", "Andhra Pradesh"); // select box
		jbody.put("country", "India"); // Fixed for now
		jbody.put("pincode", "530017");
		jbody.put("mobileno", "8121522667");
		
		jrequest.put("jheader", jheader);
		jrequest.put("jbody", jbody);
		
		System.out.println("Request-"+jrequest);
		
	} catch (JSONException e) {
		e.printStackTrace();
	}
	return jrequest;
}


}
