package interview_Practice;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.response.Response;



public class Get_Response {
	@Test
	public void Get() throws IOException {
		
    baseURI="https://reqres.in";
	Response res= given().contentType("application/json").when().get("/api/users/2");
	res.then().log().all(); 
	String response=res.asString();
    
    
    FileWriter file = new FileWriter("C:\\Users\\Nani\\eclipse-workspace\\com.RestAssured\\schema.json");	
    file.write(response);
    file.close();

  }
	@Test
	public void Getjsondata() throws JsonGenerationException, JsonMappingException, IOException {
		
    baseURI="https://reqres.in";
    ObjectMapper omp = new ObjectMapper();
	Response res= given().contentType("application/json").when().get("/api/users/2");
	res.then().log().all(); 
	String response=res.getBody().asString();
    omp.writeValue(new File("C:\\Users\\Nani\\eclipse-workspace\\com.RestAssured\\schema.json"), response);
    
  }
	
}