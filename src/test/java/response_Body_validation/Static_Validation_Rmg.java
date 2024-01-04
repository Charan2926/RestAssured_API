package response_Body_validation;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.port;
import static io.restassured.RestAssured.when;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.response.Response;


public class Static_Validation_Rmg {
	@Test
	public void Static_Response() {
		
		String exp ="TY_PROJ_1755";
		baseURI ="http://rmgtestingserver";
		port=8084;
	    
		//Actions
		Response resp = when().get("/projects");
	    
	    //Validations
		String Actual =resp.jsonPath().get("[0].projectId");
        Assert.assertEquals(Actual, exp);
        System.out.println("Data is fetched sucessfully");
		resp.then().log().all();
		   
	}

}
