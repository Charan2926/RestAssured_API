package parameters;

import org.testng.annotations.Test;
import static  io.restassured.RestAssured.*;

public class Query_Parameter {
	@Test
	public void Query() {
		
		baseURI ="https://reqres.in";
		given().queryParam("page", 2)
		.when().get("/api/users")
		.then().log().all();
	}

}
