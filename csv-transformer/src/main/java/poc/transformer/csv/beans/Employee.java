package poc.transformer.csv.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
	private String name;
	private String department;
	private String location;
	private Integer age;
}
