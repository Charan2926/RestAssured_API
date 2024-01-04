package Framework_Scripts;

import static io.restassured.RestAssured.given;

import java.sql.SQLException;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.GenericUtility.BaseClass;
import com.GenericUtility.EndpointsLibrary;
import com.GenericUtility.JavaUtility;
import io.restassured.response.Response;

public class CreateProject extends BaseClass{
	@Test
	public void create() throws SQLException {
		JavaUtility jlib =new JavaUtility();
		int ran = jlib.getRandomno();
		
		//Step 1:Create pre-condtions  
		pojoClass.Create_Project cp = new pojoClass.Create_Project("nani","RestAssured"+ran, "mock", 20);
		
		//Step 2:Send the request
		Response resp = given().spec(reqst).body(cp)
				        .when().post(EndpointsLibrary.createproject);
		
		//Step 3: Capture the ProjectId
		String expdata = rlib.getJsonData(resp, "projectId");
		System.out.println(expdata);
		
		
		//Step 4:Validate the created data /project in the database
		String query="Select *from project;";
		String actualdata = dlib.readDataFromDbVAlidate(query, 1, expdata);
		Assert.assertEquals(expdata,actualdata);
		resp.then().log().all();
		System.out.println("Test case is passed");

	}
	
	
}
