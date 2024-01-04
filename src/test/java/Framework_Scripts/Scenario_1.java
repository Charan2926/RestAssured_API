    package Framework_Scripts;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.port;
import static io.restassured.RestAssured.when;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.GenericUtility.BaseClass;
import io.restassured.response.Response;
import objectRepository.CreateProject;
import objectRepository.Homepage;

public class Scenario_1 extends BaseClass {
	//Create data using gui and fetch data by using api methods and validate using database
	@Test
	public void create() throws Throwable {
		
		int ran =jlib.getRandomno();
		String ProjectName="Ranarangam"+ran;

 		Homepage hp = new Homepage(driver);
 		hp.clickonproject();
 		
 		CreateProject cp = new CreateProject(driver);
 		cp.createNewProject(ProjectName, "veeresha","Created");
		String pro=cp.captureProjectId(ProjectName,driver);		
		
    
		//Fetch created project by using rest api methods
		baseURI="http://rmgtestingserver";
		port=8084;
 		
		Response resp = when().get("projects/"+pro);
		String expdata = rlib.getJsonData(resp, "projectId");
		System.out.println(expdata);
		
		
		//Validate
		String query="Select *from project;";
		String actualdata = dlib.readDataFromDbVAlidate(query, 1, expdata);
		Assert.assertEquals(expdata,actualdata);
		resp.then().log().all();
		System.out.println("Test case is passed");
	}
}
