package jm.javademo.core;

import java.util.Optional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import jm.javademo.core.dao.EmployeeRepository;
import jm.javademo.core.entity.Employee;

@SpringBootApplication
public class GetEmployeeApp {
	
	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(GetEmployeeApp.class, args);
		EmployeeRepository repository = context.getBean(EmployeeRepository.class);
		Optional<Employee> emp = repository.findById(1L);
		emp.ifPresent(System.out::println);
	}

}
