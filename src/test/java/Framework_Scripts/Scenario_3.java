package Framework_Scripts;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.port;
import java.io.IOException;
import java.sql.ResultSet;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.GenericUtility.BaseClass;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import objectRepository.CreateProject;
import objectRepository.Homepage;

public class Scenario_3 extends BaseClass{
	
	//Create data using  gui and update data by using api methods and validate using database
	@Test
	public void Create_Update() throws IOException, Throwable {
		
		
		int ran =jlib.getRandomno();
		String ProjectName="Thaggedeledu"+ran;
		
 		Homepage hp = new Homepage(driver);
 		hp.clickonproject();
 		
 		CreateProject cp = new CreateProject(driver);
 		cp.createNewProject(ProjectName, "veeresha","Created");
 		String result =cp.captureProjectId(ProjectName, driver);
 		Thread.sleep(2000);
 		
 		//update the data by using api put method
 		baseURI="http://rmgtestingserver";
		port=8084;
 		
		JSONObject jobj = new JSONObject();
		jobj.put("createdBy", "Chacherry");
		jobj.put("projectName", "TestYantra");
		jobj.put("staus", "Planned");
		jobj.put("teamSize",6);
		
	    Response resp= given().body(jobj).contentType(ContentType.JSON)
		.when().put("/projects/"+result);
        
		//Validate and fecth the data from the database
	    String expdata="'"+result+"'";
	    String query="Select *from project where Project_Id="+expdata+";";
	    ResultSet res=dlib.fetchDataFromDataBase(query);
	    while(res.next()) 
	    {
	    	System.out.println(res.getString(1)+"---"+res.getString(2)+"---"+res.getString(3)+"---"+res.getString(4));
	    }
		String actualdata = dlib.readDataFromDbVAlidate(query, 1, result);
		Assert.assertEquals(result,actualdata);
		resp.then().log().all();
		System.out.println("Test case is passed");		

	}
}
