package crud_with_BBD_RmgYantra;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import com.GenericUtility.JavaUtility;

import io.restassured.http.ContentType;

public class Create_Project {
	@Test
	public void Create_Post() {
		baseURI="http://rmgtestingserver";
		port=8084;
		
		JavaUtility jlib = new JavaUtility();
		int ran = jlib.getRandomno();
		
		JSONObject jobj = new JSONObject();
		jobj.put("createdBy", "Chakh");
		jobj.put("projectName", "TestYantra"+ran);
		jobj.put("staus", "Allocated");
		jobj.put("teamSize",4);
		
		//Step1: Pre-conditions
		given()
		.body(jobj)
		.contentType(ContentType.JSON)
		
		//Step:2 Actions
	   .when().post("/addProject")
		
	   //Step:3 Validation
	   .then()
	   .assertThat()
	   .statusCode(201)
	   .contentType(ContentType.JSON)
	   .log().all();
	
	   
		
	}

}
