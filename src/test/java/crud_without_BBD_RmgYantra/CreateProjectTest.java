package crud_without_BBD_RmgYantra;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import com.GenericUtility.JavaUtility;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CreateProjectTest {
	@Test
	public void Pos() {
		
		JavaUtility jlib = new JavaUtility();
	    int ran =jlib.getRandomno();
		
		JSONObject jobj = new JSONObject();
		jobj.put("createdBy", "Charan");
		jobj.put("projectName", "TestYantra"+ran);
		jobj.put("staus", "Created");
		jobj.put("teamSize",20);
		
	    RequestSpecification reqs = RestAssured.given();
		reqs.body(jobj);
		reqs.contentType(ContentType.JSON);
		
		Response resp = reqs.post("http://rmgtestingserver:8084/addProject");
		//System.out.println(resp.asString());  // print response body in single line
		//System.out.println(resp.prettyPrint()); // print response body two times
		System.out.println(resp.prettyPeek()); // print response body with all details
		System.out.println(resp.contentType()); // It will print the content type of the response body	
		System.out.println("The status code of the response is :" +resp.statusCode());//It will print the status code 
		System.out.println(resp.getTime());
	}
}
