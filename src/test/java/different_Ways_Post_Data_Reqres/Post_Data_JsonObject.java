package different_Ways_Post_Data_Reqres;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import com.GenericUtility.JavaUtility;

import io.restassured.http.ContentType;

public class Post_Data_JsonObject {
	@Test
	public void Post_JsonObj() {

		baseURI = "https://reqres.in";

		JavaUtility jlib = new JavaUtility();
		int ran = jlib.getRandomno();

		JSONObject jobj = new JSONObject();
		jobj.put("name", "Cherry@265" + ran);
		jobj.put("job", "TestEngineer");

		// Step1: Pre-conditions
		given().body(jobj).contentType(ContentType.JSON)

		// Step:2 Actions
		.when().post("/api/users")

		// Step:3 Validation
		.then().assertThat().statusCode(201).contentType(ContentType.JSON).log().all();		
	}

}
