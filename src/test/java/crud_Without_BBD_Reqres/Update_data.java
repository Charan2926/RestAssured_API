package crud_Without_BBD_Reqres;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Update_data {
	@Test
	public void Update() {
		
		JSONObject jobj = new JSONObject();
		jobj.put("name", "Cherrycharan");
		jobj.put("job", "Automation TestEngineer");
		
		 RequestSpecification reqs = RestAssured.given();
		 reqs.body(jobj);
		 reqs.contentType(ContentType.JSON);
		 
		 Response resp = reqs.put("https://reqres.in/api/users/2");
		 System.out.println(resp.statusCode());
		 System.out.println(resp.prettyPeek());
		 
	}

}
