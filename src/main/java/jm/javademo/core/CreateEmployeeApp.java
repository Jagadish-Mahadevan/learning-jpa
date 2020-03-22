package jm.javademo.core;

import java.util.Date;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import jm.javademo.core.dao.EmployeeRepository;
import jm.javademo.core.entity.Employee;

@SpringBootApplication
public class CreateEmployeeApp {
	
	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(CreateEmployeeApp.class, args);
		EmployeeRepository repository = context.getBean(EmployeeRepository.class);
		Employee emp = new Employee();
		emp.setFirstName("Pav");
		emp.setFamilyName("Vee");
		emp.setDateOfBirth(new Date());
		emp.setGender("F");
		System.out.println("Employee Created Successgfully : "+ repository.save(emp));
	}

}
