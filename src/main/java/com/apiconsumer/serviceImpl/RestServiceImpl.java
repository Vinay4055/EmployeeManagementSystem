package com.apiconsumer.serviceImpl;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.apiconsumer.model.Employee;
import com.apiconsumer.service.RestService;

@Service
public class RestServiceImpl implements RestService { //EmployeeServiceClient put it in client package
	private static final String SERVICE_URL = "http://localhost:7070/employee/";//Put it in application.properties
	RestTemplate restTemplate = new RestTemplate();
	@Override
	public List<Employee> getAllEmployees() {
		
		Employee[] employees = this.restTemplate.getForObject(SERVICE_URL + "getAll", Employee[].class);
		return Arrays.asList(employees);

	}

	@Override
	public Employee getByEmployeeCode(int code) {

		return this.restTemplate.getForObject(SERVICE_URL + "getByEmployeeCode/" + code, Employee.class);

	}

	@Override
	public void addEmployee(Employee employee) {

		HttpEntity<Employee> request = new HttpEntity<>(employee);

		this.restTemplate.postForObject(SERVICE_URL + "addEmployee", request, Employee.class);

	}

}
