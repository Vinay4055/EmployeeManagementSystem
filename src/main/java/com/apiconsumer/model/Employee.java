package com.apiconsumer.model;

import java.text.ParseException;
import java.util.Date;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.springframework.stereotype.Component;
import com.apiconsumer.util.DateConverter;
import lombok.Getter;
import lombok.Setter;

@Component

public class Employee {
	@Getter
	@Setter
	@NotEmpty(message = "Emp Code can not be null")
	int code;
	@NotEmpty(message = "Name can not be null")
	@Size(max = 100, message = "Name can not be 100 characters long")
	@Getter
	@Setter
	String name;
	@NotNull
	@Size(max = 500, message = "location can not be 500 characters long")
	@Getter
	@Setter
	String location;
	@NotNull
	@Size(max = 100, message = "EmailId can not be 100 characters long")
	@Getter
	@Setter
	String emailId;
	@NotNull
	@Getter
	@Setter
	Date dateOfBirth;

	String dobInString;

	public String getDobInString() throws ParseException {
		return DateConverter.convertDate(this.dateOfBirth.toString());

	}

	public void setDobInString(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

}
