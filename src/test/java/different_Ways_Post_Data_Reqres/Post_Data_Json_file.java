package different_Ways_Post_Data_Reqres;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import java.io.File;
import org.testng.annotations.Test;

import com.GenericUtility.JavaUtility;

import io.restassured.http.ContentType;

public class Post_Data_Json_file {
	@Test
	public void post() {
        baseURI="https://reqres.in";
		
		JavaUtility jlib = new JavaUtility();
		int ran = jlib.getRandomno();
		
		File fi = new File(".\\src\\test\\resources\\Data.json");
		//Step1: Pre-conditions
		given()
		.body(fi)
		.contentType(ContentType.JSON)
		
		//Step:2 Actions
	   .when().post("/api/users")
		
	   //Step:3 Validation
	   .then()
	   .assertThat()
	   .statusCode(201)
	   .contentType(ContentType.JSON)
	   .log().all();
	}

}
