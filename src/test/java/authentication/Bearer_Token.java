package authentication;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import com.GenericUtility.JavaUtility;
import io.restassured.http.ContentType;

public class Bearer_Token {
	@Test
	public void Bearer() {
		baseURI="https://api.github.com";
		JavaUtility jlib =new JavaUtility();
		int ran = jlib.getRandomno();
		
		JSONObject jobj = new JSONObject();
		jobj.put("name", "Ram_Veer"+ran);
		
		//Step1: Pre-conditions
		given()
		.auth()
		.oauth2("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")
		.body(jobj)
		.contentType(ContentType.JSON)
		
		//Step:2 Actions
	   .when().post("/user/repos")
		
	   //Step:3 Validation
	   .then().statusCode(201)
	   .log().all();		
	
	}

}
