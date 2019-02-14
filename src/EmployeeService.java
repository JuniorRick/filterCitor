import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class EmployeeService {

	public void order(List<Employee> employees) {

		Collections.sort(employees, new Comparator<Employee>() {

			public int compare(Employee e1, Employee e2) {

				String x1 = e1.getFirstName();
				String x2 = e2.getFirstName();
				int sComp = x1.compareTo(x2);

				if (sComp != 0) {
					return sComp;
				}

				String y1 = e1.getLastName();
				String y2 = e2.getLastName();

				sComp = y1.compareTo(y2);

				if (sComp != 0) {
					return sComp;
				}

				LocalDate date1 = e1.getDate();
				LocalDate date2 = e2.getDate();

				if (date1.isBefore(date2))
					return -1;
				else if (date1.isAfter(date2))
					return 1;
				else
					return 0;
			}
		});

	}

	public List<Employee> filter(List<Employee> employees) {
		List<Employee> emps = new ArrayList<>();
		emps.add(employees.get(0));
		
		for (int i = 0; i < employees.size() - 2; i++) {
			Employee employee1 = employees.get(i);
			Employee employee2 = employees.get(i + 1);
			
			if(employee1.getFirstName().equals(employee2.getFirstName())
					&& employee1.getLastName().equals(employee2.getLastName())) {
				
				if(employee1.getDate().isEqual(employee2.getDate()) ) {
					continue;
				} else {
					emps.add(employee1);
					emps.add(employee2);
				}
			} else {
				emps.add(employee1);
				emps.add(employee2);
			}
			
		}
		emps.add(employees.get(employees.size() - 1));
		return emps;
	}

	
	public void writeToCsv(String fileName, List<Employee> employees) throws IOException {
		BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
		
//		for (Employee employee : employees) {
//			String str = employee.getFirstName() + ";" 
//					+ employee.getLastName() + ";"
//					+ employee.getSection() + ";"
//					+ employee.getDate().toString() + ";"
//					+ employee.getTime().toString();
//			writer.write(str);
//			writer.append('\n');
//		}
		
		for (int i = 0; i < employees.size(); i+=2) {
			String str = employees.get(i).getFirstName() + ";" 
					+ employees.get(i).getLastName() + ";"
					+ employees.get(i).getSection() + ";"
					+ employees.get(i).getDate().toString() + ";"
					+ employees.get(i).getTime().toString() + ";"
					+ employees.get(i + 1).getTime().toString();
			writer.write(str);
			writer.append('\n');
		}
			
		writer.close();
	}
}
