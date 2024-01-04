package com.GenericUtility;

import io.restassured.response.Response;

public class RestAssuredLibrary {
	
	public String getJsonData(Response resp,String path) {
		
	    String jsondata = resp.jsonPath().getString(path);
	    return jsondata;
	}

}
