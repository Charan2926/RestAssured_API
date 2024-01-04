package different_Ways_Post_Data_Reqres;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import java.util.concurrent.TimeUnit;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import com.GenericUtility.JavaUtility;

import io.restassured.http.ContentType;
import pojoClass.Create_Data;

public class Post_Data_Pojo_Class {
	@Test
	public void Pojo_class() {
		 baseURI="https://reqres.in";
		 
		 JavaUtility jlib = new JavaUtility();
		 int ran = jlib.getRandomno();
		 
		 Create_Data cd = new Create_Data("ramcharan","Automation");
		//Step1: Pre-conditions
		 given()
		.body(cd)
		.contentType(ContentType.JSON)
			
		//Step:2 Actions
		.when().post("/api/users")
		
		//Step:3 Validation
		 .then()
		 .assertThat()
		 .statusCode(201)
		 .contentType(ContentType.JSON)
		 .time(Matchers.lessThan(6l),TimeUnit.SECONDS)
		 .log().all();  	   	   		
	}

}
