package com.apiconsumer.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Component
@Getter
@Setter
public class User {
	@NotEmpty(message = "Id is mandatory")
	@Size(min = 5, max = 50, message = "Range of id should be between 5 to 50")
	private String id;
	@NotEmpty(message = "Name is mandatory")
	String name;
	@NotEmpty(message = "Password is mandatory")
	String password;

	public com.apiconsumer.entity.User userModelToUserEntity(User source) {
		ModelMapper modelMapper = new ModelMapper();

		return modelMapper.map(source, com.apiconsumer.entity.User.class);

	}
}
