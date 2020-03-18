package com.apiconsumer.serviceImpl;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.apiconsumer.model.Employee;
import com.apiconsumer.service.RestService;

@Service
public class RestServiceImpl implements RestService {
	private static final String CONTEXT_URL="http://localhost:7070/employee/";

	@Override
	public List<Employee> getAllEmployees() {
		RestTemplate restTemplate = new RestTemplate();
		Employee[] employees = restTemplate.getForObject(CONTEXT_URL+"getAll", Employee[].class);
		return Arrays.asList(employees);

	}

	@Override
	public Employee getByEmployeeCode(int code) {
		RestTemplate restTemplate = new RestTemplate();
		return restTemplate.getForObject(CONTEXT_URL+"getByEmployeeCode/" + code, Employee.class);

	}

	@Override
	public void editEmployee(int code,String name,String location,String emailId,String dateOfBirth) {
		RestTemplate restTemplate = new RestTemplate();
		String pathParameters=code+"/"+name+"/"+location+"/"+emailId+"/"+dateOfBirth;
		restTemplate.put(CONTEXT_URL+"editEmployee/"+pathParameters,null);
		
		System.out.println("Successfull Commit");
		
		//restTemplate.postForObject(CONTEXT_URL+"editEmployee/"+pathParameters,null,null);
	}

}
