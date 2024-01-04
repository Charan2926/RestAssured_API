package interview_Practice;

import static io.restassured.RestAssured.*;
import java.io.File;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import com.google.gson.JsonObject;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;


public class Petsore_Practice {
   @Test
   public void Fetching_PetDetails() { 
	   
	   baseURI="http://petstore.swagger.io";
	    Response res=given().queryParam("status","available, pending,sold")
		.when().get("/v2/pet/findByStatus");
	    res.then().log().all();
   }

   @Test
   public void AddPet() {
	   JSONObject Jobj=new JSONObject();
	   Jobj.put("id", 2926);
	   Jobj.put("id", 26594);
	   Jobj.put("name", "puppypilla");
	   
	   given().body(Jobj).contentType(ContentType.JSON)
	   
	   .when().post("/pet")
	   
	   .then().log().all();  
   }
   @Test
   public void AddImageToNewPet() {
	   File image=new File("C:\\Users\\Nani\\Desktop\\exit.png");
	   
	   Response resp=given().multiPart("img",image)
			         .when().post("/v2/pet/26594/UploadImage");
	   resp.getStatusCode();
	   System.out.println(resp.asString());
			        
  }
}
