package json_validation;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.port;
import static io.restassured.RestAssured.when;
import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.Headers;
import io.restassured.response.Response;

public class Response_Header_Validation {
	@Test
	public void Header_Validaton() {
		baseURI ="http://rmgtestingserver";
		port=8084;
		
		String exp_status="HTTP/1.1 200 ";
		String exp_vary="Access-Control-Request-Headers";
		String exp_contentTypr="application/json";
		String exp_pragma="no-cache";
		String exp_connection="keep-alive";
		
		//Actions
		Response resp=when().get("projects/TY_PROJ_9938");
		
		String statusline = resp.statusLine();
		System.out.println(statusline);
		Assert.assertEquals(statusline, exp_status);
		
		Headers header= resp.headers();
		System.out.println(header);
		
		String actual_content=resp.getHeader("Content-Type");
		Assert.assertEquals(actual_content, exp_contentTypr);
		
		String actual_vary = resp.getHeader("Vary");
		Assert.assertEquals(actual_vary, exp_vary);
		
		String actual_pragma = resp.getHeader("Pragma");
	    Assert.assertEquals(actual_pragma, exp_pragma);
		
		String actual_connection=resp.getHeader("Connection");
		Assert.assertEquals(actual_connection, exp_connection);
		
	
		
		
	}

}
