package Framework_Scripts;

import static io.restassured.RestAssured.given;
import java.sql.SQLException;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.GenericUtility.BaseClass;
import com.GenericUtility.EndpointsLibrary;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import objectRepository.Homepage;
import pojoClass.Create_Project;

public class Scenario_2 extends BaseClass{
	//Create data using api and fetch data by using gui and validate using database
	@Test
	public void fetchdata() throws SQLException, InterruptedException {
		
		int ran =jlib.getRandomno();
		Create_Project cp = new Create_Project("ramanna", "Api-mock"+ran, "P1*", 1);
		Response resp = given().spec(reqst).body(cp).contentType(ContentType.JSON).when().post(EndpointsLibrary.createproject);
		resp.then().log().all();
		Thread.sleep(2000);
		String expdata = rlib.getJsonData(resp, "projectId");
		
		Homepage hp = new Homepage(driver);
		 hp.clickonproject();
		 hp.GetProjectDetails(expdata, driver);
		 Thread.sleep(2000);
		 
	//Validate
		 String query="Select *from project;";
		 String actualdata = dlib.readDataFromDbVAlidate(query, 1, expdata);
		 Assert.assertEquals(expdata,actualdata);
		 System.out.println("Test case is passed");
	}
}
