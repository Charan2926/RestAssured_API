package Crud_With_BDD_Reqres;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.when;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;

public class Get_all_Data {
	@Test
	public void GetAll() {
		baseURI="https://reqres.in";
		
		//Actions
	    when().get("/api/users?page=2")
			    
	    //Validations
	    .then()
		.assertThat()
		.statusCode(200)
		.contentType(ContentType.JSON)
		.log().all();
		   		
		
	}

}
