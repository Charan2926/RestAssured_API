 package crud_without_BBD_RmgYantra;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Update_All_Deatails_projectTest {
	@Test
	public void Put() {
		
		JSONObject jobj = new JSONObject();
		jobj.put("createdBy", "RamCharan");
		jobj.put("projectName", "TestYantra_Qspiders");
		jobj.put("staus", "Assigned");
		jobj.put("teamSize",15);
		
		RequestSpecification reqs = RestAssured.given();
		reqs.body(jobj);
		reqs.contentType(ContentType.JSON);
		
		Response resp = reqs.put("http://rmgtestingserver:8084/projects/TY_PROJ_75335");
		System.out.println(resp.prettyPeek()); // print response body with all details
	}

}
