
import java.time.ZonedDateTime;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.google.gson.Gson;

public class Employee {
	private String name;
	@JsonFormat(shape = JsonFormat.Shape.STRING)
	private Date dateOfBirth;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM/dd/yyyy", timezone = "America/New_York")
	private Date startDate;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", dateOfBirth=" + dateOfBirth + ", startDate=" + startDate + "]";
	}

	public static void main(String[] args) {
		Employee employee = new Employee();
		employee.setName("Amy");
		employee.setDateOfBirth(Date.from(ZonedDateTime.now().minusYears(30).toInstant()));
		employee.setStartDate(Date.from(ZonedDateTime.now().minusYears(2).toInstant()));

		System.out.println("-- before serialization --");
		System.out.println(employee.getStartDate());

		System.out.println("-- after serialization --");
		try {
			String jsonString = new Gson().toJson(employee);
			System.out.println(jsonString);

			System.out.println("-- after deserialization --");
			System.out.println(new Gson().fromJson(jsonString, Employee.class).getStartDate());
		} catch (Exception e) {
			// TODO: handle exception
		}

	}
}
