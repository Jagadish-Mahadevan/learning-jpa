package jm.javademo.core;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import jm.javademo.core.entity.Employee;
import jm.javademo.core.service.EmployeeService;

@SpringBootApplication
public class GetEmployeeApp implements CommandLineRunner {
	
	@Autowired
	private EmployeeService service;
	
	public static void main(String[] args) {
		SpringApplication.run(GetEmployeeApp.class);
	}

	@Override
	public void run(String... args) throws Exception {
		Optional<Employee> emp = service.getEmployee(6L);
		emp.ifPresent(System.out::println);
		
	}

}
