package customsorting;

import java.util.Comparator;

import edbms.Employee;

public class SortEmployeeBySalary implements Comparator<Employee>  {
	@Override
	public int compare(Employee x, Employee y) {
		Double i=x.getSalary();
		Double j=y.getSalary();
		return i.compareTo(j);
	}
}//x->Object to be inserted & y->Already existing Object 

