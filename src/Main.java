import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	static EmployeeService employeeService;
	
	public static void main(String[] args) throws IOException {
		
		employeeService = new EmployeeService();
		System.out.println("columns example: Date | Hour | First Name | Last Name | Section");
		System.out.println("Enter csv file name: ");
		Scanner scanner = new Scanner(System.in);
		String fileName = scanner.nextLine();
		
		List<String> lines = new ArrayList<>();
		String strLine;
		try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)))) {
			while ((strLine = reader.readLine()) != null) {
				lines.add(strLine);
			}

		} catch (Exception e) {

			System.out.println("Error: " + e.getMessage());
			scanner.next();
			scanner.close();
			return;
		}

		List<Employee> employees = new ArrayList<>();

		for (int i = 0; i < lines.size(); i++) {
			if(lines.get(i).split(";").length < 5) {
				continue;
			}
			String firstName = lines.get(i).split(";")[2].trim();
			
			if (firstName.length() == 0) {
				continue;
			}
			String line = lines.get(i);
			String lastName = line.split(";")[3].trim();
			String section = line.split(";")[4].trim();

			String[] dateString = line.split(";")[0].split("\\.");
			String[] timeString = line.split(";")[1].split(":");
			if(timeString[0].length() == 1) timeString[0] = "0" + timeString[0];

			LocalDate date = LocalDate.parse(dateString[2] + "-" + dateString[1] + "-" + dateString[0]);
			LocalTime time = LocalTime.parse(timeString[0] + ":" + timeString[1]);
			Employee employee = new Employee(firstName, lastName, section, date, time);
			employees.add(employee);

		}
		
		employeeService.order(employees);
		employees = employeeService.filter(employees);
		employeeService.writeToCsv("report.csv", employees);
		
		employees.forEach(System.out::println);
		System.out.println("\n\n");
		System.out.println("Data saved in report.csv");
		scanner.next();
		scanner.close();
	}
	

}
