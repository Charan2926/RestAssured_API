package response_Body_validation;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.when;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class Static_Validation_Reqres {
	@Test
	public void Validation_id() {
		int exp =7;
		baseURI="https://reqres.in";
		
		//Actions
		Response resp = when().get("/api/users?page=2");
	    
	    //Validations
		int Actual =resp.jsonPath().get("data[0].id");
        Assert.assertEquals(Actual, exp);
        System.out.println("Data is fetched sucessfully");
		resp.then().log().all();		
	}
	
	@Test
	public void Validation_email() {
		String exp="michael.lawson@reqres.in";
		baseURI="https://reqres.in";
		
		//Actions
		Response resp = when().get("/api/users?page=2");
	    
	    //Validations
		String  Actual =resp.jsonPath().get("data[0].email");
        Assert.assertEquals(Actual, exp);
        System.out.println("Data is fetched sucessfully");
		resp.then().log().all();		
	}

}
