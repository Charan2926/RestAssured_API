package pojoClass;

public class Serialiazation_Class {
	
	//Step1:Declaring variables globally
	String name;
	int  mobileno;
	int IDno;
	
	//Step2:Intilaizing variables using constructors
	public Serialiazation_Class(String name, int mobileno, int iDno) {
		super();
		this.name = name;
		this.mobileno = mobileno;
		IDno = iDno;
	}
	
	//Step3:Creating an empty constructor for De-serialiazation
	public Serialiazation_Class() {
		
	}
	
	//Step4: Provides Public Helpers methods(Getters and Setters)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getMobileno() {
		return mobileno;
	}
	public void setMobileno(int mobileno) {
		this.mobileno = mobileno;
	}
	public int getIDno() {
		return IDno;
	}
	public void setIDno(int iDno) {
		IDno = iDno;
	}				
}
 