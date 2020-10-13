package poc.transformer.csv.function;

import java.util.StringJoiner;
import java.util.function.Function;

import poc.transformer.csv.beans.Employee;
public class TransformToCSV implements  Function<Employee, String>{

	public static final String FIELD_SEPERATOR = ",";
	public static final String ESCAPE_CHAR = "\""; 
	public String getHeader() {
		StringJoiner header = new StringJoiner(FIELD_SEPERATOR);
		header.add("name").add("department").add("location").add("age");
		return header.toString();
	}
	public String apply(Employee t) {
		StringJoiner employeeCSV = new StringJoiner(FIELD_SEPERATOR);
		employeeCSV.add(escape(t.getName()))
			.add(escape(t.getDepartment()))
			.add(escape(t.getLocation()))
			.add(t.getAge().toString());
		return employeeCSV.toString();
	}
	
	private String escape(String field) {
		if(field.contains(FIELD_SEPERATOR)) {
			return ESCAPE_CHAR+field+ESCAPE_CHAR;
		} else {
			return field;
		}
	}
	
}
