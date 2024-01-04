package Framework_Scripts;
 
import static io.restassured.RestAssured.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.GenericUtility.BaseClass;
import objectRepository.CreateProject;
import objectRepository.Homepage;

public class Scenario_4 extends BaseClass{
	//Create data using  gui and delete data by using api methods and validate using database
	@Test
	public void  delete() throws Throwable {
		int ran =jlib.getRandomno();
		String ProjectName="Ranarangam"+ran;

 		Homepage hp = new Homepage(driver);
 		hp.clickonproject();
 		
 		CreateProject cp = new CreateProject(driver);
 		cp.createNewProject(ProjectName, "veeresha","Created");
		String pro=cp.captureProjectId(ProjectName,driver);	
		
		//Delete created project by using rest api methods
		baseURI="http://rmgtestingserver";
		port=8084;
 		
		 when().delete("projects/"+pro);
		
		//Validate
		String query="Select *from project;";
		String actualdata = dlib.readDataFromDbVAlidate(query, 1, pro);
		Assert.assertEquals(pro,actualdata);
		System.out.println("Test case is passed");
	}
}
