package Parser_Scripts;

import java.io.File;
import org.codehaus.jackson.map.ObjectMapper;
import org.testng.annotations.Test;
import pojoClass.Serialization_ArrayData;

public class Serialization_Array_Data {
	@Test
	public void employee() throws Throwable, Throwable, Throwable {
		
		int []phno = {966626365,756918613};
		Serialization_ArrayData scd = new Serialization_ArrayData("Nani", 2926, phno);
		ObjectMapper omap = new ObjectMapper();
		omap.writeValue(new File("./arrayData.json"), scd);
  }
}
