package pojoClass;

public class Serialization_Complex_Data {
	
	//Step1:Declaring variables globally
	String name;
	int  Idno;
	int[] phno;
	 Serialization_ArrayData spouse;
	
	//Step2:Intilaizing variables using constructors
	public Serialization_Complex_Data(String name, int[] phno,int Idno,Serialization_ArrayData spouse) {
		super();
		this.name = name;
		this.Idno = Idno;
		this.phno = phno;
		this.spouse = spouse;
	}
	
	//Step3:Creating an empty constructor for De-serialiazation
	public Serialization_Complex_Data() {
		
	}
    
	//Step4: Provides Public Helpers methods(Getters and Setters)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getIdno() {
		return Idno;
	}

	public void setIdno(int Idno) {
		this.Idno= Idno;
	}

	public int[] getPhno() {
		return phno;
	}

	public void setPhno(int[] phno) {
		this.phno = phno;
	}

	public Serialization_ArrayData getSpouse() {
		return spouse;
	}

	public void setSpouse(Serialization_ArrayData spouse) {
		this.spouse = spouse;
	}
}
