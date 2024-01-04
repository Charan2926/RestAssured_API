package response_Body_validation;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.when;
import java.util.List;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.response.Response;

public class Dynamic_VAlidation_Reqres {
	@Test
	public void Validation_id() {
		int exp =7;
		baseURI="https://reqres.in";
		
		//Actions
		Response resp = when().get("/api/users?page=2");
		
		//Validations
		Boolean flag = false;
		List<Integer> Actual =resp.jsonPath().get("data.id");
		for (Integer result : Actual) 
		{
			if(result==exp) 
			{
				flag = true;
				
			}	
		}
        Assert.assertTrue(flag);
        System.out.println("Data is fetched sucessfully");
		 resp.then().log().all();   		
	}
	
	@Test
	public void Validation_Email() {
		
		String exp="rachel.howell@reqres.in";
		baseURI="https://reqres.in";
		
		//Actions
		Response resp = when().get("/api/users?page=2");
		
		//Validations
		Boolean flag = false;
		List<String> Actual =resp.jsonPath().get("data.email");
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
