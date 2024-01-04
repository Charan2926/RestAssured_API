package different_Ways_Post_Data_RmgYantra;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.port;

import java.io.File;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import com.GenericUtility.JavaUtility;

import io.restassured.http.ContentType;

public class Post_Data_JsonFile {
	@Test
	public void Post_JsonFile() {
		baseURI="http://rmgtestingserver";
		port=8084;
		
		JavaUtility jlib = new JavaUtility();
		int ran = jlib.getRandomno();
		
		File fi = new File(".\\src\\test\\resources\\DataPost.json");
		
		//Step1: Pre-conditions
		given()
		.body(fi)
		.contentType(ContentType.JSON)
		
		//Step:2 Actions
	   .when().post("/addProject")
		
	   //Step:3 Validation
	   .then()
	   .assertThat()
	   .statusCode(201)
	   .contentType(ContentType.JSON)
	   .time(Matchers.lessThan(5l),TimeUnit.SECONDS)
	   .log().all();
	}

}
