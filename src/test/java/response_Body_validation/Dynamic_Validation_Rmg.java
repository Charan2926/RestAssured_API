  package response_Body_validation;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.port;
import static io.restassured.RestAssured.when;
import java.util.List;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class Dynamic_Validation_Rmg {
	@Test
	public void Dynamic_Response() {
		
		String exp ="TY_PROJ_75775";
		baseURI ="http://rmgtestingserver";
		port=8084;
	    
		//Actions
		Response resp = when().get("/projects");
	    
	    //Validations
		Boolean flag = false;
		List<String> Actual =resp.jsonPath().get("projectId");
		for (String result : Actual) 
		{
			if(result.equalsIgnoreCase(exp)) 
			{
				flag = true;
				
			}	
		}
        Assert.assertTrue(flag);
        System.out.println("Data is fetched sucessfully");
		 resp.then().log().all();
		   
		
	}

}
