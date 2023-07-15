package edbms;

import java.util.Scanner;

import customexception.InvalidChoiceException;

public class Solution {
	public static void main(String[] args) {
		System.out.println("Welcome to Employee Database System");
		System.out.println("-----------------------------------");	

		/**
		 * 1.Scanner
		 * 2.SMS=SMSImpl()->Upcasting->Abstraction
		 * 3.Infinite Loop->While(true)
		 * 4.Menu Driven Program->Display->1:Add Employee 2:.......11:Exit
		 * 5.Switch->case1:...................case11:....Default:........
		 */

		Scanner scan=new Scanner(System.in);

		//Upcasting For Achieving Abstraction
		EmployeeManagementSystem E=new EmployeeManagementSystemImpl();

		//Infinite Loop
		while(true) {

			//Menu Driven Program
			System.out.println("1:AddEmployee\n"
					+ "2:DisplayEmployee\n"
					+ "3:DisplayAllEmployees\n"
					+ "4:RemoveEmployee\n"
					+ "5:RemoveAllEmployees\n"
					+ "6:UpdateEmployee\n"
					+ "7:CountEmployee\n"
					+ "8:SortEmployee\n"
					+ "9:FindEmployeeWithHighestSalary\n"
					+ "10:FindEmployeeWithLowestSalary\n"+"11:Exit\nEnter your Choice\n");
			int choice=scan.nextInt();

			switch(choice) {
			case 1:
				E.addEmployee();
				break;

			case 2:
				E.displayEmployee();
				break;

			case 3:
				E.displayAllEmployees();
				break;

			case 4:
				E.removeEmployee();
				break;

			case 5:
				E.removeAllEmployees();
				break;

			case 6:
				E.updateEmployee();
				break;

			case 7:
				E.countEmployee();
				break;

			case 8:
				E.sortEmployee();
				break;

			case 9:
				E.findEmployeeWithHighestSalary();
				break;

			case 10:
				E.findEmployeeWithLowestSalary();
				break;

			case 11:System.out.println("Thank You!!!");
			System.exit(0);

			default:try{//InvalidChoice
				String message="Invalid Choice,Please Enter Valid Choice";
				throw new InvalidChoiceException(message);
			}
			catch(Exception e) {
				System.out.println(e.getMessage());
			}

			}//End of Switch 

			System.out.println("---------------------------------");

		}//End Of While Loop

	}//End of Main()
}
