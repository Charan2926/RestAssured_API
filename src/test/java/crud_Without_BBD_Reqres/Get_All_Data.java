package crud_Without_BBD_Reqres;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Get_All_Data {
	@Test
	public void Getall() {
		Response resp = RestAssured.get("https://reqres.in/api/users?page=2");
		 System.out.println(resp.statusCode());
		 System.out.println(resp.prettyPeek());
	}

}
