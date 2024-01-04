package json_validation;

import static io.restassured.RestAssured.when;
import java.io.File;
import org.testng.annotations.Test;
import io.restassured.module.jsv.JsonSchemaValidator;

public class Json_Schema_Validation {
	@Test
	public void SchemaValidation() {
	File file = new File("./Schema.json");	
	 when().get("https://reqres.in/api/users?page=2")
	.then().assertThat()
	.body(JsonSchemaValidator.matchesJsonSchema(file))
	.log().all();
	
}

}
