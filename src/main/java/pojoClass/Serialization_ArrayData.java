package pojoClass;

public class Serialization_ArrayData {
	//Step1:Declaring variables globally
		String name;
		int  age;
		int []mobno;

		
		//Step2:Intilaizing variables using constructors
		public Serialization_ArrayData(String name, int age , int[] mobno) {
			super();
			this.name = name;
			this.age = age;
			this.mobno = mobno;
		}
		
		//Step3:Creating an empty constructor for De-serialiazation
		public Serialization_ArrayData() {
			
		}
		
		//Step4: Provides Public Helpers methods(Getters and Setters)
		public String getName() {
			return name;
		}
		
		public void setName(String name) {
			this.name = name;
		}
		
		public int getAge() {
			return age;
		}

		public void setAge(int age) {
			this.age = age;
		}

		public int[] getMobno() {
			return mobno;
		}

		public void setMobno(int[] mobno) {
			this.mobno = mobno;
		}

		
}
