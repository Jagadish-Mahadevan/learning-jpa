package jm.javademo.core.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jm.javademo.core.dao.EmployeeRepository;
import jm.javademo.core.entity.Employee;

@Transactional
@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository repository;
	
	public Optional<Employee> getEmployee(long id) {
		return repository.findById(6L);
	}
}
