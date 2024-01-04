 package Crud_With_BDD_Reqres;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.when;
import java.util.concurrent.TimeUnit;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;
import io.restassured.http.ContentType;

public class Get_Single_data {
	@Test
	public void Get() {
    baseURI="https://reqres.in";
		
    //Actions
    when().get("/api/users/2")
		    
    //Validations
    .then()
	.assertThat()
	.statusCode(200)
	.contentType(ContentType.JSON)
	.time(Matchers.lessThan(2l),TimeUnit.SECONDS)
	.log().all();
	
	}
}
