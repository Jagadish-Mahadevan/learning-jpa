package jm.javademo.core;

import static java.time.LocalDate.parse;
import static java.time.format.DateTimeFormatter.ofPattern;

import java.time.LocalDate;
import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import jm.javademo.core.dao.EmployeeRepository;
import jm.javademo.core.entity.Address;
import jm.javademo.core.entity.Employee;

@SpringBootApplication
public class CreateEmployeeApp {
	
	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(CreateEmployeeApp.class, args);
		EmployeeRepository repository = context.getBean(EmployeeRepository.class);
		
		Address resAddress = new Address();
		resAddress.setLine1("3 Stratton Lawn");
		resAddress.setLine2("Adamstown Castle");
		resAddress.setLine3("Lucan");
		resAddress.setLine4("Co. Dublin");
		Employee emp = new Employee();
		emp.setFirstName("Pavithra");
		emp.setFamilyName("Veeramani");
		emp.setDateOfBirth(getDateOfBirth("05/12/1985"));
		emp.setGender("F");
		emp.setAddresses(Arrays.asList(resAddress));
		System.out.println("Employee Created Successgfully : "+ repository.save(emp));
	}
	
	static LocalDate getDateOfBirth(String dob) {
		return parse(dob, ofPattern("dd/MM/yyyy"));
	}

}
