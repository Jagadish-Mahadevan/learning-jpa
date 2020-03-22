package jm.javademo.core;

import java.util.Optional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import jm.javademo.core.dao.EmployeeRepository;
import jm.javademo.core.entity.Employee;

@SpringBootApplication
public class UpdateEmployeeApp {
	
	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(UpdateEmployeeApp.class, args);
		EmployeeRepository repository = context.getBean(EmployeeRepository.class);
		Optional<Employee> emp = repository.findById(1L);
		
		if(emp.isPresent()) {
			emp.get().setFirstName("Jaag");
		}
		System.out.println("Employee updated successfully : "+ emp);
	}

}
