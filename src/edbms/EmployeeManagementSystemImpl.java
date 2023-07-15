package edbms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import customexception.InvalidChoiceException;
import customsorting.SortEmployeeByAge;
import customsorting.SortEmployeeByID;
import customsorting.SortEmployeeBySalary;
import customsorting.SortEmployeeByName;
import customexception.EmployeeNotFoundException;
import edbms.Employee;

public class EmployeeManagementSystemImpl implements EmployeeManagementSystem {

	Scanner scan=new Scanner(System.in);

	//Key->Student ID and Value->Student Object
	Map<String,Employee> db=new LinkedHashMap<String,Employee>();

	@Override
	public void displayEmployee() {

		//Accept Employee ID
		System.out.println("Enter the Employee ID: ");
		String id=scan.next();//.toUppercase()

		//Convert toUpperCase()
		id=id.toUpperCase();

		//Check if ID is present or not-> containskey()->(id==key)
		if(db.containsKey(id)) {//If-> get the Student Object->get()->getAge(),getName()...............
			System.out.println("Employee Record Found!!!");
			System.out.println("------------------------");
			Employee emp=db.get(id);//Getting Employee Object Based on ID
			System.out.println("ID: "+emp.getId());
			System.out.println("Age: "+emp.getAge());
			System.out.println("Name: "+emp.getName());
			System.out.println("Salary: "+emp.getSalary());
			//printing reference variable as toString() is Overridden
			//System.out.println(emp);
		}
		else {//else->EmployeeNotFoundException
			try{
				String message="Employee with ID "+id+" is not found!!!";
				throw new EmployeeNotFoundException(message);
			}
			catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}

	@Override
	public void displayAllEmployees() {
		if(!db.isEmpty()) {//Checking if DB is Not Empty
			System.out.println("Employee Records are as follows");
			System.out.println("------------------------------");
			Set<String> keys=db.keySet();
			for(String key:keys) {
				Employee emp=db.get(key);//Getting Employee Object
				System.out.println(emp);//toString() is Overridden
				//System.out.println(db.get(key));
			}
		}
		else {
			//EmployeeNotFoundException
			try{
				String message="Employee Not Found";
				throw new EmployeeNotFoundException(message);
			}
			catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}

	@Override
	public void addEmployee() {
		//Accepting Age
		System.out.println("Enter Age:");
		int age=scan.nextInt();

		//Accepting Name
		System.out.println("Enter Name:");
		String name=scan.next();

		//Accepting Salary
		System.out.println("Enter Salary:");
		double salary=scan.nextDouble();

		//Creating A Employee Instance(Object)
		Employee emp=new Employee(age,name,salary);

		//db->Map->put()->id,emp
		db.put(emp.getId(),emp );

		//Print the Student ID
		System.out.println(" Record Inserted Successfully!!!");
		System.out.println("Your Employee Id is "+emp.getId());

	}

	@Override
	public void removeEmployee() {
		//Accept Student ID
		System.out.println("Enter the Employee ID: ");
		String id=scan.next();//.toUppercase()

		//Convert toUpperCase()
		id=id.toUpperCase();

		//Check if ID is present or not-> containskey()->(id==key)
		if(db.containsKey(id)) {//If-> get the Employee Object->get()->getAge(),getName()...............
			System.out.println("Employee Record Found!!!");
			System.out.println("------------------------");
			System.out.println(db.get(id));//Printing Employee Object
			db.remove(id);//Removing Employee Object Based on ID(Key & Value)
			System.out.println("Employee ID: "+id+" has been deleted successfully!!!");
		}
		else {//else->EmployeeNotFoundException
			try{
				String message="Employee with ID: "+id+" is not found!!!";
				throw new EmployeeNotFoundException(message);
			}
			catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}

	@Override
	public void removeAllEmployees() {
		if(!db.isEmpty()) {
			System.out.println("Number of Employee Record"+db.size());
			db.clear();
			System.out.println("All Employees Records are Deleted Successfully!!!");
		}
		else {
			try{
				String message="No Employee Records to Delete!!!";
				throw new EmployeeNotFoundException(message);
			}
			catch(Exception e) {
				System.out.println(e.getMessage());
			} 
		}
	}

	@Override
	public void updateEmployee() {
		System.out.println("Enter Employee ID: ");
		String id=scan.next().toUpperCase();

		if(db.containsKey(id)) {
			System.out.println("Student Record Found");
			Employee emp=db.get(id);//Getting Value(Employee Object)

			System.out.println("1:Update Age\n2:Update Name\n3:Update Salary\nEnter Choice:");
			int choice=scan.nextInt();

			switch(choice) {
			case 1:
				System.out.println("Enter Age:");
				int age=scan.nextInt();
				emp.setAge(age);//std.setAge(scan.nextInt());
				System.out.println("Age Updated Successfully");
				break;
			case 2:
				System.out.println("Enter Name:");
				String Name=scan.next();
				emp.setName(Name);//std.setName(scan.next());
				System.out.println("Name Updated Successfully");
				break;
			case 3:
				System.out.println("Enter Marks:");
				double salary=scan.nextDouble();
				emp.setSalary(salary);//std.setSalary(scan.nextDouble());
				System.out.println("Salary Updated Successfully");
				break;

			default:
				try {//InvalidChoice
					String message="Invalid Choice,Please Enter Valid Choice";
					throw new InvalidChoiceException(message);
				}
				catch(Exception e) {
					System.out.println(e.getMessage());
				}
			}
		}
		else {
			try{
				String message="Employee with ID:"+id+" Record Found!!!";
				throw new EmployeeNotFoundException(message);
			}
			catch(Exception e) {
				System.out.println(e.getMessage());
			} 
		}
	}

	@Override
	public void countEmployee() {
		System.out.println("Number of Employee Records: "+db.size());
	}

	@Override
	public void sortEmployee() {
		/**
		 * We cannot sort Map based on values,therefore we are getting
		 * the values from Map & storing it inside list so that we can sort
		 * list using-> Collections.sort(list,sorting logic Object);
		 */

		//Reference of list and Object of Arraylist storing Employee Objects
		List<Employee> list=new ArrayList<Employee>();

		//Converting Map into Set,which stores keys(Id)
		Set<String> keys=db.keySet();

		//Traversing Keys(Id)
		for (String key:keys) {
			//Getting value(Employee Object)& adding it into list
			list.add(db.get(key));
		}
		System.out.println("1:Sort Employee Age\n2:Sort Employee Name\n3:Sort Employee Salary\n4:Sort Employee ID\nEnter Choice:");
		int choice=scan.nextInt();

		switch(choice) {
		case 1:
			Collections.sort(list,new SortEmployeeByAge());
			for(Employee e:list) {
				System.out.println(e);
			}
			break;
		case 2:
			Collections.sort(list,new SortEmployeeByName());
			for(Employee e:list) {
				System.out.println(e);
			}
			break;
		case 3:
			Collections.sort(list,new SortEmployeeBySalary());
			for(Employee e:list) {
				System.out.println(e);
			}
			break;
		case 4:
			Collections.sort(list,new SortEmployeeByID());
			for(Employee e:list) {
				System.out.println(e);
			}
			break;
		default:
			try {//InvalidChoice
				String message="Invalid Choice,Please Enter Valid Choice";
				throw new InvalidChoiceException(message);
			}
			catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}

	@Override
	public void findEmployeeWithHighestSalary() {
		List<Employee> list=new ArrayList<Employee>();

		//Converting Map into Set,which stores keys(Id)
		Set<String> keys=db.keySet();

		//Traversing Keys(Id)
		for (String key:keys) {
			//Getting value(Employee Object)& adding it into list
			list.add(db.get(key));
		}
		Collections.sort(list,new SortEmployeeBySalary());
		System.out.println("Employee with Highest Salary: ");
		System.out.println(list.get(list.size()-1));
	}

	@Override
	public void findEmployeeWithLowestSalary() {
		List<Employee> list=new ArrayList<Employee>();

		//Converting Map into Set,which stores keys(Id)
		Set<String> keys=db.keySet();

		//Traversing Keys(Id)
		for (String key:keys) {
			//Getting value(Employee Object)& adding it into list
			list.add(db.get(key));
		}
		Collections.sort(list,new SortEmployeeBySalary());
		System.out.println("Employee with Lowest Salary: ");
		System.out.println(list.get(0));
	}
}
