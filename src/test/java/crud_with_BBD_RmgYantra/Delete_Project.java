package crud_with_BBD_RmgYantra;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.port;
import static io.restassured.RestAssured.when;
import org.testng.annotations.Test;

public class Delete_Project {
	@Test
	public void Delete() {
		baseURI="http://rmgtestingserver";
		port=8084;
		
		//Actions
		when().delete("/projects/TY_PROJ_77065")
		
		//Validations
		.then()
		.assertThat()
		.statusCode(204)
		.log().all();
	}

}
