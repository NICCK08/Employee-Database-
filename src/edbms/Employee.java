package edbms;

public class Employee {

	private String id;
	private int age;
	private String name;
	private double salary;
	private static int count=101;

	public Employee(int age,String name,double salary) {
		this.id="JSP"+count;
		count++;
		this.name=name;
		this.salary=salary;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public String getId() {
		return id;
	}

}
