package crud_with_BBD_RmgYantra;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class Get_Particular_Project {
	@Test
	public void Get() {
		
		baseURI ="http://rmgtestingserver";
		port=8084;
		
		//Actions
		when().get("projects/TY_PROJ_9938")
		
		//Validations
		.then()
		.assertThat()
		.statusCode(200)
		.contentType(ContentType.JSON)
		.log().all();		
				   
		
	}

}
