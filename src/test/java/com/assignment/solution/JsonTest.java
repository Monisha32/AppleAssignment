package com.assignment.solution;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import org.json.JSONObject;
import org.junit.Test;
import junit.framework.Assert;

public class JsonTest {


    @Test
	public void test() throws MalformedURLException {
        String url = "https://istheapplestoredown.com/api/v1/status/worldwide";
        JSONObject json = Util.executeGetRequest(url);
        String country = "";

	      Iterator<String> keys = json.keys();
	        while( keys.hasNext() )
	        {
	            String key = keys.next();
	            JSONObject innerJObject = json.getJSONObject(key);
	            Iterator<String> innerKeys = innerJObject.keys();
	            while( innerKeys.hasNext() )
	            {
	                String innerKey = innerKeys.next();
	                String value = innerJObject.getString(innerKey);
	                if (innerKey.equalsIgnoreCase("name")) {
	                	country = value;
	                }
	                if (innerKey.equalsIgnoreCase("status") && value.equalsIgnoreCase("y")) {
	                	Assert.fail("Country found with status <y>: " + country);
	                }
	            }
	        }    	
    }
}
