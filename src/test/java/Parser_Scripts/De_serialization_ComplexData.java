package Parser_Scripts;

import java.io.File;
import org.codehaus.jackson.map.ObjectMapper;
import org.testng.annotations.Test;
import pojoClass.Serialization_Complex_Data;

public class De_serialization_ComplexData {
	@Test
	public void de_Serialization() throws Throwable, Throwable, Throwable{
		
		ObjectMapper omap = new ObjectMapper();
		Serialization_Complex_Data scd=omap.readValue(new File("./ComplexData"),Serialization_Complex_Data.class );
		System.out.println(scd.getName());
		System.out.println(scd.getIdno());
		System.out.println(scd.getPhno()[0]);	
		System.out.println(scd.getSpouse().getName());
		System.out.println(scd.getSpouse().getAge());
		System.out.println(scd.getSpouse().getMobno()[0]);
		
	}
}