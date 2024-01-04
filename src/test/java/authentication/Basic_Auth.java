package authentication;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.port;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

public class Basic_Auth {
	@Test
	public void Basic()
	{
		baseURI="http://rmgtestingserver";
		port=8084;
		
		given().auth().basic("rmgyantra", "rmgy@9999")
		.when().get("/login")
		.then().assertThat().statusCode(202).log().all();
	}
	
	
	 @Test
		public void Basic_preemptive() {
		baseURI="http://rmgtestingserver";
		port=8084;
			
		given().auth().preemptive().basic("rmgyantra", "rmgy@9999")
		.when().get("/login")
		.then().assertThat().statusCode(202).log().all();   		
	}
	 
	 @Test
		public void Basic_digest() {
		baseURI="http://rmgtestingserver";
		port=8084;
			
		given().auth().digest("rmgyantra", "rmgy@9999")
		.when().get("/login")
		.then().assertThat().statusCode(202).log().all();   	
		
	}

 }

