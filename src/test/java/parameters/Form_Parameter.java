package parameters;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.port;
import org.testng.annotations.Test;

public class Form_Parameter {
	@Test
	public void Form() {
		
		baseURI="http://rmgtestingserver";
		port=8084;
		
		given().formParam("CreatedBy", "NAni")
		.formParam("ProjectName", "RUnwaysales")
		.formParam("status", "Created")
		.formParam("teamSize", 10)
		.when().post("/addProject")
		.then().log().all();
	}

}
