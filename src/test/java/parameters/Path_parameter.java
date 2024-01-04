package parameters;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.port;
import org.testng.annotations.Test;
import static  io.restassured.RestAssured.*;

public class Path_parameter {
	@Test
	public void Path() {
		baseURI="http://rmgtestingserver";
		port=8084;
		
		given().pathParam("pid", "TY_PROJ_75917")
		.when().get("/projects/{pid}")
		.then().log().all();
		
	}

}
