import java.time.LocalDate;
import java.time.LocalTime;

public class Employee {
	private String firstName;
	private String lastName;
	private String section;
	private LocalDate date;
	private LocalTime Time;

	public Employee(String firstName, String lastName, String section, LocalDate date, LocalTime time) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.section = section;
		this.date = date;
		Time = time;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getSection() {
		return section;
	}

	public void setSection(String section) {
		this.section = section;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public LocalTime getTime() {
		return Time;
	}

	public void setTime(LocalTime time) {
		Time = time;
	}

	@Override
	public String toString() {
		return "Employee [firstName=" + firstName + ", lastName=" + lastName + ", section=" + section + ", date=" + date
				+ ", Time=" + Time + "]";
	}

	
	
}
