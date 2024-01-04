package interview_Questions;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.port;
import java.util.Map;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;
import java.util.List;
import static io.restassured.RestAssured.*;

public class Checking_Response_data_format {
	@Test
	public void ResponseObject() {
		baseURI="http://rmgtestingserver";
		port=8084;
		
		when().get("projects/TY_PROJ_76281")
		.then().assertThat().body("", Matchers.instanceOf(Map.class)).log().all();
	}
	@Test
	public void ResponseArrayObject() {
		baseURI="http://rmgtestingserver";
		port=8084;
		
		when().get("/projects")
		.then().assertThat().body("", Matchers.instanceOf(List.class)).log().all();
  }
}