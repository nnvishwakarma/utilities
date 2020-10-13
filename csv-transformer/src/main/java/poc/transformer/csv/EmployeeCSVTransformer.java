package poc.transformer.csv;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

import lombok.extern.slf4j.Slf4j;
import poc.transformer.csv.beans.Employee;
import poc.transformer.csv.function.CSVWriter;
import poc.transformer.csv.function.TransformToCSV;

@Slf4j
public class EmployeeCSVTransformer {
	public static void main(String[] args) throws Exception {
		log.info("Starting Employee CSV Transformer...");
		List<Employee> emps = Arrays.asList(
					new Employee("John, Clay", "CS,IT","BLR", 35 ), 
					new Employee("Mike, Beny", "ACCOUNT,IT","BLR", 35),
					new Employee("Willy, Black", "CS,IT","NA", 31 )
				);
		Path csvPath = Paths.get("employee.csv");
		TransformToCSV transformToCSV = new TransformToCSV();

		try(CSVWriter writer = new CSVWriter(csvPath)) {
			writer.accept(transformToCSV.getHeader());
			emps.stream()
				.map(transformToCSV)
				.forEach(writer);
		}
		
		log.info("Employee CSV file at: {}", csvPath.toString());
			
	}
}
