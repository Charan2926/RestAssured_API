package different_Ways_Post_Data_Reqres;

import static io.restassured.RestAssured.given;
import java.util.HashMap;
import org.testng.annotations.Test;
import com.GenericUtility.JavaUtility;
import io.restassured.http.ContentType;

public class Post_Data_HashMap {
	@Test
	public void Post_Hashmap() {
		JavaUtility jlib = new JavaUtility();
		int ran = jlib.getRandomno();

		HashMap<String, Object> jobj = new HashMap<String, Object>();
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
