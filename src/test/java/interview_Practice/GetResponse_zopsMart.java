package interview_Practice;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class GetResponse_zopsMart {
	
	 @Test
	 public void givenUrl_whenSuccessOnGetsResponseAndJsonHasRequiredKV_thenCorrect()
	 {
	
	  get("http://localhost:8080/events?id=390").then().statusCode(200);
	      
	 }

}
