package Parser_Scripts;

import java.io.File;
import org.codehaus.jackson.map.ObjectMapper;
import org.testng.annotations.Test;
import pojoClass.Serialiazation_Class;

public class De_Serialization {
	@Test
	public void  Details() throws Throwable, Throwable, Throwable {
		
		ObjectMapper omap = new ObjectMapper();
		Serialiazation_Class data = omap.readValue(new File("./charan.json"), Serialiazation_Class.class);
		System.out.println(data.getName());
		System.out.println(data.getMobileno());
		System.out.println(data.getIDno());
		
	}

}
