package different_Ways_Post_Data_RmgYantra;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.port;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.hamcrest.Matchers;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import com.GenericUtility.JavaUtility;

import io.restassured.http.ContentType;

public class Post_Data_Hashmap {
	@Test
	public void Post_Hashmap() {
		baseURI="http://rmgtestingserver";
		port=8084;
		
		JavaUtility jlib = new JavaUtility();
		int ran = jlib.getRandomno();
		
		HashMap<String, Object> jobj = new HashMap<String, Object>();
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
	   .time(Matchers.lessThan(5l),TimeUnit.SECONDS)
	   .log().all();
	}

}
