package requst_Response_Spec_Builder;

import org.testng.annotations.Test;
import com.GenericUtility.JavaUtility;
import static io.restassured.RestAssured.*;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class Create_Project {
	@Test 
	public void ProjectSpec() {
		JavaUtility jlib = new JavaUtility();
		int ran =jlib.getRandomno();

		pojoClass.Create_Project cp = new pojoClass.Create_Project("ram", "api"+ran, "ongoing", 10);
		
		RequestSpecification reqst = new RequestSpecBuilder()
		.setBaseUri("http://rmgtestingserver:8084")
		.setContentType(ContentType.JSON).build();
		
		ResponseSpecification resp = new ResponseSpecBuilder()
		.expectContentType(ContentType.JSON)
		.expectStatusCode(201).build();
		
		given().spec(reqst).body(cp)
		.when().post("/addProject")
		.then().spec(resp).log().all();
		
		
		
	
		
				
		
	}

}
