package request_Chaining;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import com.GenericUtility.JavaUtility;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class Create_Data_Reqres {
	@Test
	public void Create() {
        baseURI="https://reqres.in";
		
		JavaUtility jlib = new JavaUtility();
		int ran = jlib.getRandomno();
		
		JSONObject jobj = new JSONObject();
		jobj.put("name", "Cherry@265"+ran);
		jobj.put("job", "TestEngineer");
		
		//Step1: Pre-conditions
		Response resp=given()
		.body(jobj)
		.contentType(ContentType.JSON)
		
		//Step:2 Actions
	   .when().post("/api/users");
		
		String pid = resp.jsonPath().get("id");
		System.out.println(pid);
		
	   //Step:3 Validation
	  resp.then().log().all();
				
	 //Fecthing project by request chaining_by variables
	   //when().get("/api/users/"+pid).then().log().all();	
	   
	   //Fecthing project by request chaining by path parameters
	    given().pathParam("pinfo", pid).when().get("/api/users/{pinfo}").then().log().all();
	}

}
