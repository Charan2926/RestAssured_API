 package Framework_Scripts;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.port;
import static io.restassured.RestAssured.when;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.GenericUtility.BaseClass;
import com.GenericUtility.DataBaseUtility;
import com.GenericUtility.JavaUtility;
import com.GenericUtility.RestAssuredLibrary;

import io.restassured.response.Response;


public class Create_Fetch_Validate_HardCoded {
	@Test
	public void System() throws Throwable {
		
		
		JavaUtility jlib = new JavaUtility();
		int ran =jlib.getRandomno();
		
		String ProjectName="RestAssures"+ran;

		System.setProperty("webdriver.chrome.driver","./src/main/resources/chromedriver.exe");
 		WebDriver  driver= new ChromeDriver( );
 		driver.manage().window().maximize();
		
		//Launch the application
		driver.get("http://rmgtestingserver:8084/");
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		
		//Login to the application
		driver.findElement(By.id("usernmae")).sendKeys("rmgyantra");
		driver.findElement(By.id("inputPassword")).sendKeys("rmgy@9999");
		driver.findElement(By.xpath("//button[text()='Sign in']")).click();
		Thread.sleep(4000);
		
		//Click on projects
		driver.findElement(By.xpath("//a[text()='Projects']")).click();
		driver.findElement(By.xpath("//span[text()='Create Project']")).click();
		
		//Create a project
		driver.findElement(By.name("projectName")).sendKeys(ProjectName);
		driver.findElement(By.name("createdBy")).sendKeys("RamCharan");
		WebElement element =driver.findElement(By.name("status"));
		Select s= new Select(element);
		s.selectByValue("Created");
		driver.findElement(By.xpath("//input[@type='submit']")).click();	
		Thread.sleep(4000);
		
		//Capture the projectID 
		WebElement pid = driver.findElement(By.xpath("//td[.='"+ProjectName+"']/preceding-sibling::td"));
		String pro =pid.getText();
		//System.out.println(pro);
		
		driver.close();
		
		//fecthing Captured projectID  using rest api method
		baseURI="http://rmgtestingserver";
		port=8084;
		
		Response resp = when().get("projects/"+pro);
		
		RestAssuredLibrary rlib = new RestAssuredLibrary();
		String expdata = rlib.getJsonData(resp, "projectId");
		System.out.println(expdata);
		
		
		//Validate the created data /project in the database
		DataBaseUtility dlib = new DataBaseUtility();
		dlib.connectToDb();
		
		String query="Select *from project;";
		String actualdata = dlib.readDataFromDbVAlidate(query, 1, expdata);
		Assert.assertEquals(expdata,actualdata);
		resp.then().log().all();
		System.out.println("Test case is passed");
		
		dlib.disConnectFromDb();
	}
}
