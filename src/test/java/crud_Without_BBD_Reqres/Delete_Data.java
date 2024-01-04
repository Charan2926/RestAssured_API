package crud_Without_BBD_Reqres;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Delete_Data {
	@Test
	public void Delete() {
		Response resp = RestAssured.delete("https://reqres.in/api/users/2");
		 System.out.println(resp.statusCode());
	}

}
