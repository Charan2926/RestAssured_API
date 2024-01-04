package Framework_Scripts;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.port;
import static io.restassured.RestAssured.when;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.GenericUtility.DataBaseUtility;
import com.GenericUtility.FileUtility;
import com.GenericUtility.JavaUtility;
import com.GenericUtility.RestAssuredLibrary;
import com.GenericUtility.WebDriverUtility;

import io.restassured.response.Response;
import objectRepository.CreateProject;
import objectRepository.Homepage;
import objectRepository.Loginpage;

public class Create_Project_Generics_Pom {
	@Test
	public void Create() throws IOException, Throwable {
		JavaUtility jlib = new JavaUtility();
		WebDriverUtility wlib = new WebDriverUtility();
		FileUtility flib = new FileUtility();
		
		int ran =jlib.getRandomno();
		
		//Fecthing data from property file
		String url = flib.ReadDataFromPropertyFile("Url");
		//String username=flib.ReadDataFromPropertyFile("Username");
		//String password=flib.ReadDataFromPropertyFile("Password");
		
		String ProjectName="Zimbambre"+ran;

		System.setProperty("webdriver.chrome.driver","./src/main/resources/chromedriver.exe");
 		WebDriver  driver= new ChromeDriver( );
 		
 		wlib.maximizebrowser(driver);
 		driver.get(url);
 		wlib.waituntillpageload(driver);
 		
 		Loginpage lp = new Loginpage(driver);
 		lp.Logindata("rmgyantra", "rmgy@9999");
 		
 		Homepage hp = new Homepage(driver);
 		hp.clickonproject();
 		
 		CreateProject cp = new CreateProject(driver);
 		cp.createNewProject(ProjectName, "veeresha","Created");
		String pro=cp.captureProjectId(ProjectName,driver);	
		
		driver.close();
		
		//Fetch created project by using rest api methods
	    baseURI="http://rmgtestingserver";
		port=8084;
		
		Response resp = when().get("projects/"+pro);
		
		RestAssuredLibrary rlib = new RestAssuredLibrary();
		
		String expdata = rlib.getJsonData(resp, "projectId");
		System.out.println(expdata);
		
		
		//Validate
		DataBaseUtility dlib = new DataBaseUtility();
		dlib.connectToDb();
		
		String query="Select *from project;";
		String actualdata = dlib.readDataFromDbVAlidate(query, 1, expdata);
		Assert.assertEquals(expdata,actualdata);
		resp.then().log().all();
		System.out.println("Test case is passed");		
				
 	}

}
