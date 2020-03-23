package com.apiconsumer.serviceImpl;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.apiconsumer.model.Employee;
import com.apiconsumer.service.RestService;

@Service
public class RestServiceImpl implements RestService {
	private static final String SERVICE_URL = "http://localhost:7070/employee/";

	@Override
	public List<Employee> getAllEmployees() {
		RestTemplate restTemplate = new RestTemplate();
		Employee[] employees = restTemplate.getForObject(SERVICE_URL + "getAll", Employee[].class);
		return Arrays.asList(employees);

	}

	@Override
	public Employee getByEmployeeCode(int code) {
		RestTemplate restTemplate = new RestTemplate();
		return restTemplate.getForObject(SERVICE_URL + "getByEmployeeCode/" + code, Employee.class);

	}

	@Override
	public void addEmployee(Employee employee) {
		RestTemplate restTemplate = new RestTemplate();
		HttpEntity<Employee> request = new HttpEntity<>(employee);

		restTemplate.postForObject(SERVICE_URL + "addEmployee", request, Employee.class);

	}

}
