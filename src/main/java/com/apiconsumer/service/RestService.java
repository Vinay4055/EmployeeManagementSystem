package com.apiconsumer.service;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.apiconsumer.model.Employee;

@Service
public interface RestService  { 

	public List<Employee> getAllEmployees();
	public Employee getByEmployeeCode(int code);
	void editEmployee(int code, String name, String location, String emailId, String dobInString);

}
