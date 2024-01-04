package crud_without_BBD_RmgYantra;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Delete_Projects {
	@Test
	public void Delete() {
		Response resp = RestAssured.delete("http://rmgtestingserver:8084/projects/TY_PROJ_75335");
		System.out.println(resp.statusCode());
	}

}
