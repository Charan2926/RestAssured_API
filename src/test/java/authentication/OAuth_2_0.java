 package authentication;

import static io.restassured.RestAssured.*;
import org.testng.annotations.Test;
import io.restassured.response.Response;

public class OAuth_2_0 {
	@Test
	public void Coops_Eggs_Collect() {
	 Response resp=given()
	.formParam("client_id", "My_world")
	.formParam("client_secret", "e1d35673a1dce1a9fcf4710f3657423f")
	.formParam("grant_type", "client_credentials")
	.formParam("redirect_uri ", "http://exam.com")
	.formParam("code ", "authorization_code")
	
	.when().post("http://coop.apps.symfonycasts.com/token");
	
	//Capturing the access token from the response of the above request
	 String token = resp.jsonPath().get("access_token");
	 System.out.println(token);

	 //Create another request and use the token to access the APIs
	 given().auth().oauth2(token)
	 .pathParam("USER_ID", 4668)
	 
	 .when()
	 .post("http://coop.apps.symfonycasts.com/api/{USER_ID}/eggs-collect")
	 .then().log().all();
	}
	
	@Test
	public void Coops_Chiken_Feed() {
	 Response resp=given()
	.formParam("client_id", "My_world")
	.formParam("client_secret", "e1d35673a1dce1a9fcf4710f3657423f")
	.formParam("grant_type", "client_credentials")
	.formParam("redirect_uri ", "http://exam.com")
	.formParam("code ", "authorization_code")
	
	.when().post("http://coop.apps.symfonycasts.com/token");
	
	//Capturing the access token from the response of the above request
	 String token = resp.jsonPath().get("access_token");
	 System.out.println(token);

	 //Create another request and use the token to access the APIs
	 given().auth().oauth2(token)
	 .pathParam("USER_ID", 4668)
	 
	 .when()
	 .post("http://coop.apps.symfonycasts.com/api/{USER_ID}/chickens-feed")
	 .then().log().all();
	}
	
	@Test
	public void Coops_Chiken_Barn() {
	 Response resp=given()
	.formParam("client_id", "My_world")
	.formParam("client_secret", "e1d35673a1dce1a9fcf4710f3657423f")
	.formParam("grant_type", "client_credentials")
	.formParam("redirect_uri ", "http://exam.com")
	.formParam("code ", "authorization_code")
	
	.when().post("http://coop.apps.symfonycasts.com/token");
	
	//Capturing the access token from the response of the above request
	 String token = resp.jsonPath().get("access_token");
	 System.out.println(token);

	 //Create another request and use the token to access the APIs
	 given().auth().oauth2(token)
	 .pathParam("USER_ID", 4668)
	 
	 .when()
	 .post("http://coop.apps.symfonycasts.com/api/{USER_ID}/barn-unlock")
	 .then().log().all();
	}
	
	@Test
	public void Coops_Chiken_Seat() {
	 Response resp=given()
	.formParam("client_id", "My_world")
	.formParam("client_secret", "e1d35673a1dce1a9fcf4710f3657423f")
	.formParam("grant_type", "client_credentials")
	.formParam("redirect_uri ", "http://exam.com")
	.formParam("code ", "authorization_code")
	
	.when().post("http://coop.apps.symfonycasts.com/token");
	
	//Capturing the access token from the response of the above request
	 String token = resp.jsonPath().get("access_token");
	 System.out.println(token);

	 //Create another request and use the token to access the APIs
	 given().auth().oauth2(token)
	 .pathParam("USER_ID", 4668)
	 
	 .when()
	 .post("http://coop.apps.symfonycasts.com/api/{USER_ID}/toiletseat-down")
	 .then().log().all();
	}
	
	@Test
	public void Coops_Chiken_Eggs_Count() {
	 Response resp=given()
	.formParam("client_id", "My_world")
	.formParam("client_secret", "e1d35673a1dce1a9fcf4710f3657423f")
	.formParam("grant_type", "client_credentials")
	.formParam("redirect_uri ", "http://exam.com")
	.formParam("code ", "authorization_code")
	
	.when().post("http://coop.apps.symfonycasts.com/token");
	
	//Capturing the access token from the response of the above request
	 String token = resp.jsonPath().get("access_token");
	 System.out.println(token);

	 //Create another request and use the token to access the APIs
	 given().auth().oauth2(token)
	 .pathParam("USER_ID", 4668)
	 
	 .when()
	 .post("http://coop.apps.symfonycasts.com/api/{USER_ID}/eggs-count")
	 .then().log().all();
	}
	
	@Test
	public void Coops_Chiken_Get() {
	 Response resp=given()
	.formParam("client_id", "My_world")
	.formParam("client_secret", "e1d35673a1dce1a9fcf4710f3657423f")
	.formParam("grant_type", "client_credentials")
	.formParam("redirect_uri ", "http://exam.com")
	.formParam("code ", "authorization_code")
	
	.when().post("http://coop.apps.symfonycasts.com/token");
	
	//Capturing the access token from the response of the above request
	 String token = resp.jsonPath().get("access_token");
	 System.out.println(token);

	 //Create another request and use the token to access the APIs
	 given().auth().oauth2(token)
	 
	 .when()
	 .get("http://coop.apps.symfonycasts.com/api/me")
	 .then().log().all();
	}
}
