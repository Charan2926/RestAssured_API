 package data_Driven;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.port;
import java.util.concurrent.TimeUnit;
import org.hamcrest.Matchers;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.GenericUtility.JavaUtility;
import io.restassured.http.ContentType;
import pojoClass.Create_Project;

public class Data_Providers {
	
	@DataProvider
	public Object[][] Data() {
		Object[][] obj = new Object[3][4];
		
		obj[0][0]="qspiders";
		obj[0][1]="manual_testing";
		obj[0][2]="completed";
		obj[0][3]=12;
		
		obj[1][0]="pyspiders";
		obj[1][1]="Automation_testing";
		obj[1][2]="Completed";
		obj[1][3]=14;
		
		obj[2][0]="Jspiders";
		obj[2][1]="Java_python";
		obj[2][2]="Not-started";
		obj[2][3]=16;
    
		return obj;
	}
	
	@Test(dataProvider = "Data")
	public void fetchData(String createdBy ,String projectName,String staus,int teamSize ) {
		
		baseURI="http://rmgtestingserver";
		port=8084;
		
		JavaUtility jlib = new JavaUtility();
		int ran = jlib.getRandomno();
		
		//Creating an object for pojo class
		Create_Project cp = new Create_Project(createdBy, projectName+ran, staus,teamSize);
		
		//Step1: Pre-conditions
		 given()
		.body(cp)
		.contentType(ContentType.JSON)
		
		//Step:2 Actions
	    .when().post("/addProject")
		
	   //Step:3 Validation
	   .then()
	   .assertThat()
	   .statusCode(201)
	   .contentType(ContentType.JSON)
	   .time(Matchers.lessThan(6l),TimeUnit.SECONDS)
	   .log().all();		
		
	}

}
