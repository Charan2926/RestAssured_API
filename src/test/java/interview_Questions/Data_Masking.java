package interview_Questions;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.port;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import com.GenericUtility.JavaUtility;
import io.restassured.RestAssured;
import io.restassured.config.LogConfig;
import io.restassured.http.ContentType;

public class Data_Masking {
	@Test
	public void hideData() {
		
		baseURI="http://rmgtestingserver";
		port=8084;
		
		JavaUtility jlib = new JavaUtility();
	    int ran =jlib.getRandomno();
		
		JSONObject jobj = new JSONObject();
		jobj.put("createdBy", "Charan");
		jobj.put("projectName", "TestYantra"+ran);
		jobj.put("staus", "Created");
		jobj.put("teamSize",20);
		
		//Pre-conditions
		given().config(RestAssured.config.logConfig(LogConfig.logConfig()
				.blacklistHeader("Content-Type")))
		        .body(jobj)
		        .contentType(ContentType.JSON)
		        .log().all()
		 //Actions       
		.when().post("/addproject")
		
		//Validation
		.then()
		.assertThat()
		.log()
		.all();
		        
	}
}
