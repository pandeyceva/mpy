package com.myplantation.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONException;
import org.json.JSONObject;

import com.myplantation.engine.ServiceDescriptorParser;
import com.myplantation.service.manager.ProcessManager;

@WebServlet("/noauth/token/*")
public class NonAuthenticationService extends HttpServlet  {
	private static final long serialVersionUID = 1L;
	public static List<Map<String, String>> MP_SERVICES=null;
	public NonAuthenticationService() {
		super();
		System.out.println("pandey....");
	}
	@Override
	public void init() throws ServletException {
		super.init();
		MP_SERVICES=ServiceDescriptorParser.parseXML("noauth");
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Server@").append("echo");
		System.out.println("server@echo");
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BufferedReader reader = null;
		PrintWriter out = null;
		try {
			out = response.getWriter();
			JSONObject jresponse =new JSONObject();
			String pathInfo = request.getPathInfo(); // /{value}/test
			String[] pathParts = pathInfo.split("/");
			String jtoken = pathParts[1]; //token
			HttpSession session= request.getSession(false);
			System.out.println("jtoken["+jtoken+"]");
			reader = new BufferedReader(new InputStreamReader(request.getInputStream()));

			StringBuilder sb= new StringBuilder();
			String line="";
			while((line=reader.readLine())!=null)
			{
				if(line.trim().length()>0)
				{
					sb.append(line);
				}
			}
			JSONObject jrequest = new JSONObject(sb.toString());
			jrequest.put("jtoken", jtoken);
			System.out.println("request-"+jrequest);
			
			
			jresponse =ProcessManager.call(jrequest,session);
			
			
			String ptoken=UUID.randomUUID().toString().replaceAll("-", "");
			jresponse.getJSONObject("jheader").put("jtoken", ptoken);
			session.setAttribute("ptoken", ptoken);
			out.write(jresponse.toString());
			out.flush();

		} catch (Exception e) {
			e.printStackTrace();
			JSONObject jresponse =new JSONObject();
			try {
				jresponse.put("rc", "97");
				jresponse.put("rd", e.getMessage());
				
				out.write(jresponse.toString());
				out.flush();
			} catch (JSONException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			
		}
		finally
		{
			if(reader !=null)
			{
				reader.close();
			}
			if(out !=null)
			{
				out.close();
			}
		}


	}

	private String getType(String status)
	{
		String type="4";

		switch (status) {
		case "start":
		{
			type="1";
		}
		break;
		case "response":
		{
			type="2";
		}
		break;
		case "end":
		{
			type="4";
		}
		break;

		default:
			break;
		}

		return type;
	}
	
	private static String getNetwork(String networkName)
	{
		String network="0";
		networkName=networkName.toLowerCase();
		switch (networkName) {
		case "africell":
		{
			network="1";
		}
		break;
		case "vodacom":
		{
			network="2";
		}
		break;
		

		default:
			break;
		}

		return network;
	}
	
	public static void main(String[] args) {
		System.out.println(getNetwork("vodacom"));
	}

}
