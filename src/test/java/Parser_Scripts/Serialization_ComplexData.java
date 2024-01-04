package Parser_Scripts;

import java.io.File;
import org.codehaus.jackson.map.ObjectMapper;
import org.testng.annotations.Test;

import pojoClass.Serialization_ArrayData;
import pojoClass.Serialization_Complex_Data;

public class Serialization_ComplexData {
	@Test
	public void serialization() throws Throwable, Throwable, Throwable{
		int []mobno = {966626365,756918613};
		Serialization_ArrayData scd = new Serialization_ArrayData("Akhila",24, mobno);
		
		int phno[]= {756918613,966626365};
		Serialization_Complex_Data sa = new Serialization_Complex_Data("charan", phno, 2926, scd);
		
		ObjectMapper omap = new ObjectMapper();
		
		omap.writeValue(new File("./ComplexData"),sa);
		
	}

}
