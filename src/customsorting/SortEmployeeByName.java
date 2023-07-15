package customsorting;

import java.util.Comparator;

import edbms.Employee;

public class SortEmployeeByName implements Comparator<Employee>  {
	@Override
	public int compare(Employee x, Employee y) {
		String i=x.getName();
		String j=y.getName();
		return i.compareTo(j);
	}
}//x->Object to be inserted & y->Already existing Object
//For string comparison,we need to call comapareTo() of String Class

