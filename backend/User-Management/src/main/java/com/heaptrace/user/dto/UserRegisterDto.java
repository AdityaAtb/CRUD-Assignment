package com.heaptrace.user.dto;

import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserRegisterDto {
	
	private String firstName;
	
	private String lastName;
	
    @Email(message = "Email should be valid")
	private String email;
	
	private String phoneNumber;
}
