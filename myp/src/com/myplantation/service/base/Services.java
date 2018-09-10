package com.myplantation.service.base;

import javax.servlet.http.HttpSession;

import org.json.JSONObject;

public interface Services {

	JSONObject cussignup(JSONObject jrequest, HttpSession session);
	JSONObject investorinterestedsignup(JSONObject jrequest, HttpSession session);
	JSONObject investorsignup(JSONObject jrequest, HttpSession session);
	JSONObject cussignupotp(JSONObject jrequest, HttpSession session);
	JSONObject invintsignupfinal(JSONObject jrequest, HttpSession session);
	JSONObject invsignupfinal(JSONObject jrequest, HttpSession session);
	
}
