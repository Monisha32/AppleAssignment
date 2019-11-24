package com.assignment.solution;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import org.json.JSONObject;
import javax.ws.rs.client.Invocation.Builder;


public class Util 
{
    
	public static JSONObject executeGetRequest(String url) {
		
			Client client = ClientBuilder.newClient();
			WebTarget resource = client.target(url);
			Builder request = resource.request();

			Response response = request.get();
			String responseAsString = response.readEntity(String.class);
			return new JSONObject(responseAsString);					
	}
}
