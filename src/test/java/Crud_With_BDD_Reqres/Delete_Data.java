package Crud_With_BDD_Reqres;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.when;
import org.testng.annotations.Test;
import io.restassured.http.ContentType;

public class Delete_Data {
	@Test
	public void Delete() {
		baseURI="https://reqres.in";
		
	    //Actions
	    when().get("/api/users/2")
			    
	    //Validations
	    .then()
		.assertThat()
		.statusCode(204)
		.log().all();
	}

}
