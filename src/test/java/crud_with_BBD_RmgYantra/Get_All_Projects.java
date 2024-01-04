package crud_with_BBD_RmgYantra;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class Get_All_Projects {
	@Test
	public void GetAll() {
		baseURI ="http://rmgtestingserver";
		port=8084;
	    
		//Actions
		when().get("/projects")
	    
	    //Validations
		.then()
		.assertThat()
		.statusCode(200)
		.contentType(ContentType.JSON)
		 .log().all();
		   
	}

}
