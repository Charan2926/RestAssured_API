package request_Chaining;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.port;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import com.GenericUtility.JavaUtility;
import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
public class Create_Project_Rmg {
	@Test
	public void Create_Chaining() {
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
		Response resp=given()
		.body(jobj)
		.contentType(ContentType.JSON)
		
		//Step:2 Actions
	    .when().post("/addProject");  
		
		String pid = resp.jsonPath().get("projectId");
		System.out.println(pid);
		
		//Step3: validation
		resp.then().log().all();
		
		//Fecthing project by request chaining_by variables
	    when().get("/projects/"+pid).then().log().all();
	    
	    //Fecthing project by request chaining by path parameters
	    given().pathParam("pinfo", pid).when().get("/projects/{pinfo}").then().log().all();
	    	
	}
}
