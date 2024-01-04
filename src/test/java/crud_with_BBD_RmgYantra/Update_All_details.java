package crud_with_BBD_RmgYantra;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.port;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import com.GenericUtility.JavaUtility;

import io.restassured.http.ContentType;

public class Update_All_details {
	@Test
	public void Put() {
		
		baseURI="http://rmgtestingserver";
		port=8084;
		
		JavaUtility jlib = new JavaUtility();
		int ran = jlib.getRandomno();
		
		JSONObject jobj = new JSONObject();
		jobj.put("createdBy", "Chacherry");
		jobj.put("projectName", "TestYantra"+ran);
		jobj.put("staus", "Planned");
		jobj.put("teamSize",6);
		
		//Step1: Pre-conditions
		given()
		.body(jobj)
		.contentType(ContentType.JSON)
		
		//Step:2 Actions
	   .when().put("/projects/TY_PROJ_75562")
		
	   //Step:3 Validation
	   .then()
	   .assertThat()
	   .statusCode(200)
	   .contentType(ContentType.JSON)
	   .log().all();
		System.out.println("Test is passed");
	
		
	}

}
