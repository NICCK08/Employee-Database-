package customsorting;

import java.util.Comparator;

import edbms.Employee;

public class SortEmployeeByID implements Comparator<Employee>{ 
	@Override
	public int compare(Employee x, Employee y) {
		String i=x.getId();
		String j=y.getId();
		return i.compareTo(j);
	}
}//x->Object to be inserted & y->Already existing Object
//For string comparison,we need to call comapareTo() of String Class
