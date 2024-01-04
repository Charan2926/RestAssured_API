package Crud_With_BDD_Reqres;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import io.restassured.http.ContentType;

public class Update_Single_Data {
	@Test
	public void Patch() {
		baseURI ="https://reqres.in";
		

		JSONObject jobj = new JSONObject();
		jobj.put("name", "Charan@2926");
		jobj.put("job", "SoftwareEngineer");
		
		//Step1: Pre-conditions
		 given()
		.body(jobj)
		.contentType(ContentType.JSON)
		
		//Step:2 Actions
	   .when().patch("/api/users/2")
		
	   //Step:3 Validation
	   .then()
	   .assertThat()
	   .statusCode(200)
	   .contentType(ContentType.JSON)
	   .log().all();
	}

}
