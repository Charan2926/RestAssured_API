package crud_without_BBD_RmgYantra;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Get_Particular_Project {
	@Test
	public void Get() {
		Response resp = RestAssured.get("http://rmgtestingserver:8084/projects/TY_PROJ_75335");
		System.out.println(resp.prettyPeek());
		
		
	}

}
