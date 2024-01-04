package different_Ways_Post_Data_RmgYantra;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.port;

import java.util.concurrent.TimeUnit;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import com.GenericUtility.JavaUtility;

import io.restassured.http.ContentType;
import pojoClass.Create_Project;

public class Post_Data_PojoClass {
	@Test
	public void Post_PojoClass() {
		
		baseURI="http://rmgtestingserver";
		port=8084;
		
		JavaUtility jlib = new JavaUtility();
		int ran = jlib.getRandomno();
		
		Create_Project cp = new Create_Project("RamVeersha", "Dosthu123"+ran, "Friends", 6);
		
		//Step1: Pre-conditions
		given()
		.body(cp)
		.contentType(ContentType.JSON)
		
		//Step:2 Actions
	   .when().post("/addProject")
		
	   //Step:3 Validation
	   .then()
	   .assertThat()
	   .statusCode(201)
	   .contentType(ContentType.JSON)
	   .time(Matchers.lessThan(6l),TimeUnit.SECONDS)
	   .log().all();		
	}

}
