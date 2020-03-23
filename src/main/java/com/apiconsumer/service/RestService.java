package com.apiconsumer.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.apiconsumer.model.Employee;

@Service
public interface RestService  {   //Put it in client package

	public List<Employee> getAllEmployees();
	public Employee getByEmployeeCode(int code);
	public void addEmployee(Employee employee);
}
