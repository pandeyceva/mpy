package com.myplantation.service.main;

import org.json.JSONException;
import org.json.JSONObject;

public class LandingPageStaticCode {
public static void main(String[] args) throws JSONException {
	
//cussignup();
System.out.println("---------------------------------");
//cussignupotp();

investorsignup();
System.out.println("---------------------------------");
invsignupfinal();
	
}

public static JSONObject cussignup() throws JSONException
{
	JSONObject jrequest = new JSONObject();
	JSONObject jheader = new JSONObject();
	JSONObject jbody = new JSONObject();
	
	
	jheader.put("mobileno", "2348186016608");
	jheader.put("flowid", "1234567890");
	jheader.put("serviceid", "CUSSIGNUP");
	jheader.put("timestamp", "25082018140430");//ddMMyyyyhhmmss

	jbody.put("fname", "Rajkumar");
	jbody.put("lname", "Pandey");
	jbody.put("email", "rajkumarpandey786@gmail.com");
	jbody.put("adress", "Plot:64, Sector-12, MVP Colony");
	jbody.put("City", "Visakhapatnam"); // select box
	jbody.put("state", "Andhra Pradesh"); // select box
	jbody.put("country", "India"); // Fixed for now
	jbody.put("pincode", "530017");
	jbody.put("mobileno", "8121522667");
	
	jrequest.put("jheader", jheader);
	jrequest.put("jbody", jbody);
	
	System.out.println("Request-"+jrequest);
	
	JSONObject jresponse = new JSONObject();
	jresponse.put("respcode", "00");
	jresponse.put("respdesc", "OTP sent to Mobile Number.");
	System.out.println("Success Response -"+jresponse);
	
	JSONObject unjresponse = new JSONObject();
	unjresponse.put("respcode", "01");
	unjresponse.put("respdesc", "You are already a registered Customer to My plantation");
	System.out.println("unSuccess Response -"+unjresponse);
	
	JSONObject exjresponse = new JSONObject();
	exjresponse.put("respcode", "02");
	exjresponse.put("respdesc", "Sorry, We regret, something went wrong.");
	System.out.println("Exception Response -"+exjresponse);
	
	return jrequest;
}

public static JSONObject investorsignup() throws JSONException
{
	JSONObject jrequest = new JSONObject();
	JSONObject jheader = new JSONObject();
	JSONObject jbody = new JSONObject();
	
	
	jheader.put("mobileno", "2348186016608");
	jheader.put("flowid", "1234567890");
	jheader.put("serviceid", "INVINTSIGNUP");
	jheader.put("timestamp", "25082018140430");//ddMMyyyyhhmmss

	
	jbody.put("mobileno", "8121522667");
	jbody.put("activationcode", "898989");
	
	jrequest.put("jheader", jheader);
	jrequest.put("jbody", jbody);
	
	System.out.println("Request-"+jrequest);
	
	JSONObject jresponse = new JSONObject();
	jresponse.put("respcode", "00");
	jresponse.put("respdesc", "OTP sent to Mobile Number.");
	System.out.println("Success Response -"+jresponse);
	
	JSONObject unjresponse = new JSONObject();
	unjresponse.put("respcode", "01");
	unjresponse.put("respdesc", "You are already a registered Investor to My plantation");
	System.out.println("unSuccess Response -"+unjresponse);
	
	JSONObject exjresponse = new JSONObject();
	exjresponse.put("respcode", "02");
	exjresponse.put("respdesc", "Sorry, We regret, something went wrong.");
	System.out.println("Exception Response -"+exjresponse);
	
	return jrequest;
}

public static JSONObject investorinterestedsignup() throws JSONException
{
	JSONObject jrequest = new JSONObject();
	JSONObject jheader = new JSONObject();
	JSONObject jbody = new JSONObject();
	
	
	jheader.put("mobileno", "2348186016608");
	jheader.put("flowid", "1234567890");
	jheader.put("serviceid", "INVINTSIGNUP");
	jheader.put("timestamp", "25082018140430");//ddMMyyyyhhmmss

	jbody.put("fname", "Rajkumar");
	jbody.put("lname", "Pandey");
	jbody.put("email", "rajkumarpandey786@gmail.com");
	jbody.put("mobileno", "8121522667");
	
	jrequest.put("jheader", jheader);
	jrequest.put("jbody", jbody);
	
	System.out.println("Request-"+jrequest);
	
	JSONObject jresponse = new JSONObject();
	jresponse.put("respcode", "00");
	jresponse.put("respdesc", "OTP sent to Mobile Number.");
	System.out.println("Success Response -"+jresponse);
	
	JSONObject unjresponse = new JSONObject();
	unjresponse.put("respcode", "01");
	unjresponse.put("respdesc", "You are already a registered Investor to My plantation");
	System.out.println("unSuccess Response -"+unjresponse);
	
	JSONObject exjresponse = new JSONObject();
	exjresponse.put("respcode", "02");
	exjresponse.put("respdesc", "Sorry, We regret, something went wrong.");
	System.out.println("Exception Response -"+exjresponse);
	
	return jrequest;
}


public static JSONObject cussignupotp() throws JSONException
{
	JSONObject jrequest = new JSONObject();
	JSONObject jheader = new JSONObject();
	JSONObject jbody = new JSONObject();
	
	
	jheader.put("mobileno", "2348186016608");
	jheader.put("flowid", "1234567890");
	jheader.put("serviceid", "CUSSIGNUPOTP");
	jheader.put("timestamp", "25082018140430");//ddMMyyyyhhmmss

	jbody.put("otp", "123456");
	jbody.put("pwd", "sha512(password)");
	
	
	jrequest.put("jheader", jheader);
	jrequest.put("jbody", jbody);
	
	System.out.println("Request-"+jrequest);
	
	JSONObject jresponse = new JSONObject();
	jresponse.put("respcode", "00");
	jresponse.put("respdesc", "We have been succesfully registered. Thank you, Welcome to My Plantation Family");
	System.out.println("Success Response -"+jresponse);
	
	JSONObject unjresponse = new JSONObject();
	unjresponse.put("respcode", "01");
	unjresponse.put("respdesc", "Invalid OTP, Please Try Enter Again");
	
	System.out.println("UnSuccess Response -"+unjresponse);
	
	JSONObject exjresponse = new JSONObject();
	exjresponse.put("respcode", "02");
	exjresponse.put("respdesc", "Sorry, We regret, something went wrong.");
	
	System.out.println("Exception Response -"+exjresponse);
	
	return jrequest;
}


public static JSONObject invsignupfinal() throws JSONException
{
	JSONObject jrequest = new JSONObject();
	JSONObject jheader = new JSONObject();
	JSONObject jbody = new JSONObject();
	
	
	jheader.put("mobileno", "2348186016608");
	jheader.put("flowid", "1234567890");
	jheader.put("serviceid", "INVSIGNUPFINAL");
	jheader.put("timestamp", "25082018140430");//ddMMyyyyhhmmss

	jbody.put("otp", "123456");
	jbody.put("pwd", "sha512(password)");
	
	
	jrequest.put("jheader", jheader);
	jrequest.put("jbody", jbody);
	
	System.out.println("Request-"+jrequest);
	
	JSONObject jresponse = new JSONObject();
	jresponse.put("respcode", "00");
	jresponse.put("respdesc", "We have been succesfully registered. Thank you, Welcome to My Plantation Family");
	System.out.println("Success Response -"+jresponse);
	
	JSONObject unjresponse = new JSONObject();
	unjresponse.put("respcode", "01");
	unjresponse.put("respdesc", "Invalid OTP, Please Try Enter Again");
	
	System.out.println("UnSuccess Response -"+unjresponse);
	
	JSONObject exjresponse = new JSONObject();
	exjresponse.put("respcode", "02");
	exjresponse.put("respdesc", "Sorry, We regret, something went wrong.");
	
	System.out.println("Exception Response -"+exjresponse);
	
	return jrequest;
}

public static JSONObject invintsignupfinal() throws JSONException
{
	JSONObject jrequest = new JSONObject();
	JSONObject jheader = new JSONObject();
	JSONObject jbody = new JSONObject();
	
	
	jheader.put("mobileno", "2348186016608");
	jheader.put("flowid", "1234567890");
	jheader.put("serviceid", "INVINTSIGNUPFINAL");
	jheader.put("timestamp", "25082018140430");//ddMMyyyyhhmmss

	jbody.put("otp", "123456");
	
	
	jrequest.put("jheader", jheader);
	jrequest.put("jbody", jbody);
	
	System.out.println("Request-"+jrequest);
	
	JSONObject jresponse = new JSONObject();
	jresponse.put("respcode", "00");
	jresponse.put("respdesc", "We have been succesfully registered. Thank you, Welcome to My Plantation Family");
	System.out.println("Success Response -"+jresponse);
	
	JSONObject unjresponse = new JSONObject();
	unjresponse.put("respcode", "01");
	unjresponse.put("respdesc", "Invalid OTP, Please Try Enter Again");
	
	System.out.println("UnSuccess Response -"+unjresponse);
	
	JSONObject exjresponse = new JSONObject();
	exjresponse.put("respcode", "02");
	exjresponse.put("respdesc", "Sorry, We regret, something went wrong.");
	
	System.out.println("Exception Response -"+exjresponse);
	
	return jrequest;
}


}
