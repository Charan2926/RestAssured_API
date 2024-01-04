 package com.GenericUtility;

import java.io.IOException;
import java.sql.SQLException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import objectRepository.Homepage;
import objectRepository.Loginpage;


public class BaseClass {
	
	public DataBaseUtility dlib = new DataBaseUtility();
	public JavaUtility jlib = new JavaUtility();
	public WebDriverUtility wlib = new WebDriverUtility();
	public FileUtility flib = new FileUtility();
	public RestAssuredLibrary rlib = new RestAssuredLibrary();
	public RequestSpecification reqst;
	public ResponseSpecification resp;
	public WebDriver driver;
	
	@BeforeSuite
	public void bsconfig() throws Throwable  {
		String url = flib.ReadDataFromPropertyFile("Url");	
		dlib.connectToDb();
	
		reqst = new RequestSpecBuilder().setBaseUri(url)
				.setContentType(ContentType.JSON).build();
		
		resp = new ResponseSpecBuilder().expectContentType(ContentType.JSON).
				build();	
		System.out.println("----connect to the database-----");
	}
	@BeforeClass 
	public void bcconfig() throws IOException {
		String browser = flib.ReadDataFromPropertyFile("Browser");
		
		if(browser.equalsIgnoreCase("chrome"))
		{  
			System.setProperty("webdriver.chrome.driver","./src/main/resources/chromedriver.exe");
	 		  driver= new ChromeDriver( );
		}
		else if(browser.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			WebDriver driver= new FirefoxDriver();
		}
		else 
		{
			WebDriverManager.edgedriver().setup();
			driver= new EdgeDriver();
		}	
		wlib.maximizebrowser(driver);
		System.out.println("------open the browser----");
	}
	@BeforeMethod(alwaysRun = true)
	public void config_BM() throws Throwable {
		String USERNAME= flib.ReadDataFromPropertyFile("Username");
		String PASSWORD = flib.ReadDataFromPropertyFile("Password");
		String URL = flib.ReadDataFromPropertyFile("Url");
		
		driver.get(URL);
		wlib.waituntillpageload(driver);
		
		Loginpage lp = new Loginpage(driver);
		lp.Logindata(USERNAME, PASSWORD);
		System.out.println("------Login into the aplication-------");
	}
	
	@AfterMethod(alwaysRun = true)
	public void config_AM() {
		Homepage hp = new Homepage(driver);
		hp.logout(driver);
		System.out.println("----logout of the application----");
	}
	
	@AfterClass
	public void acConfig() {
		driver.close();
		System.out.println("-----close the browser-----");
	}
	
	@AfterSuite
	public void asconfig() throws SQLException {
		dlib.disConnectFromDb();
		System.out.println("-----close the database connection---");
	}

}
