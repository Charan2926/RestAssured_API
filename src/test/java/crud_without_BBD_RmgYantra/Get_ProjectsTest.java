package crud_without_BBD_RmgYantra;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Get_ProjectsTest {
	@Test
	public void GetAll() {
		Response resp = RestAssured.get("http://rmgtestingserver:8084/projects");
		System.out.println(resp.prettyPeek());
		
	}
}
