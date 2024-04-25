package com.crud.CrudDemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crud.CrudDemo.model.Employee;
import com.crud.CrudDemo.model.EmployeeNotFoundException;
import com.crud.CrudDemo.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	EmployeeService service;

	@GetMapping
	public ResponseEntity<List<Employee>> getAllEmployees() {
		List<Employee> employees = service.getAllEmployees();
		return new ResponseEntity<List<Employee>>(employees, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Employee> getAllEmployeeByID(@PathVariable int id) throws EmployeeNotFoundException {
		Employee employee = service.getAllEmployeeByID(id);
		return new ResponseEntity<Employee>(employee, HttpStatus.OK);
	}

	@PostMapping
	public HttpStatus createEmployee(@RequestBody Employee employee) {
		service.createEmployee(employee);
		return HttpStatus.OK;
	}

	@PutMapping("/{id}")
	public HttpStatus updateEmployee(@PathVariable int id, @RequestBody Employee employee) throws EmployeeNotFoundException {
		service.updateEmployee(id, employee);
		return HttpStatus.OK;
	}

	@DeleteMapping("/{id}")
	public HttpStatus deleteEmployee(@PathVariable int id) {
		service.deleteEmployee(id);
		return HttpStatus.OK;
	}

}
