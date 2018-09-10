package com.myplantation.utils;

import org.json.JSONException;
import org.json.JSONObject;

public class Validator {

	public static boolean isValidToken(JSONObject jrequest, String ptoken)
	{
		boolean isvalid= false;
		try {
			JSONObject jheader= jrequest.getJSONObject("jheader");
			JSONObject jbody= jrequest.getJSONObject("jbody");
			String jtoken = jrequest.getString("jtoken");
			String stoken= "";
			if(ptoken==null)
			{
				stoken=CommonUtil.b64_sha256(CommonUtil.b64_sha256(jheader.toString())+"+"+CommonUtil.b64_sha256(jbody.toString()));
			}
			else
			{
				stoken=CommonUtil.b64_sha256(CommonUtil.b64_sha256(ptoken)+"+"+CommonUtil.b64_sha256(jheader.toString())+"+"+CommonUtil.b64_sha256(jbody.toString()));
			}
			
			
			if(jtoken.equals(stoken))
			{
				isvalid= true;
			}
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return isvalid;
	}
}
