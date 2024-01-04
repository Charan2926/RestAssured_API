package pojoClass;

public class Create_Data {
	
	//Step1:Declaring variables globally
	String name;
	String job;
	
	//Step2:Intilaizing variables using constructors
	public Create_Data(String name, String job) {
		super();
		this.name = name;
		this.job = job;
	}
	//Step3: Provides Public Helpers methods(Getters and Setters)

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}	
}
