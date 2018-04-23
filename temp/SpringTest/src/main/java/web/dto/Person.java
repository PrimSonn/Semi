package web.dto;

public class Person {
	
	private String name;
	private int age;
	
	@Override
	public String toString() {
		
		return "Person [name: "+name+", age: "+age+"]";
	}
	public int getAge() {
		return age;
	}public String getName() {
		return name;
	}public void setAge(int age) {
		this.age = age;
	}public void setName(String name) {
		this.name = name;
	}
}
