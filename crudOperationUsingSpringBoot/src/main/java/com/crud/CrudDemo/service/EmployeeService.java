package com.crud.CrudDemo.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.CrudDemo.model.Employee;
import com.crud.CrudDemo.model.EmployeeNotFoundException;
import com.crud.CrudDemo.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	EmployeeRepository repo;

	public List<Employee> getAllEmployees() {
		List<Employee> employees = repo.findAll();
		return employees;
	}

	public Employee getAllEmployeeByID(int id) throws EmployeeNotFoundException {
		Optional<Employee> employee = repo.findById(id);
		if (employee.isPresent()) {
			Employee e = employee.get();
			return e;
		} else {
			throw new EmployeeNotFoundException("The entered Employee id is not available");
		}
	}

	public void createEmployee(Employee employee) {
		employee.setDueDate(LocalDate.now());
		repo.save(employee);
	}

	public void updateEmployee(int id, Employee employee) throws EmployeeNotFoundException {
		Optional<Employee> emp = repo.findById(id);
		if (emp.isPresent()) {
			Employee e = emp.get();
			if (employee.getDescription() != null)
				e.setDescription(employee.getDescription());
			if (employee.getDueDate() != null)
				e.setDueDate(employee.getDueDate());
			if (employee.getStatus() != null)
				e.setStatus(employee.getStatus());
			if (employee.getTitle() != null)
				e.setTitle(employee.getTitle());
			repo.save(e);
		} else {
			throw new EmployeeNotFoundException("The entered Employee id is not available");
		}
	}

	public void deleteEmployee(int id) {
		repo.deleteById(id);
	}

}
