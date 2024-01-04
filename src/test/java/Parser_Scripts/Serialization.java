package Parser_Scripts;

import java.io.File;
import org.codehaus.jackson.map.ObjectMapper;
import org.testng.annotations.Test;
import pojoClass.Serialiazation_Class;


public class Serialization {
	@Test
	public void employee() throws Throwable, Throwable, Throwable {
		ObjectMapper omap = new ObjectMapper();
		Serialiazation_Class sc = new Serialiazation_Class("Ramcharan",982154544,2926);
		omap.writeValue(new File("./charan.json"), sc);
	}
}
