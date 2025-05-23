package com.heaptrace.user.service;

import java.util.List;

import com.heaptrace.user.dto.ApiResponse;
import com.heaptrace.user.dto.UserRegisterDto;
import com.heaptrace.user.dto.UserRegisterResponseDto;
import com.heaptrace.user.dto.UserUpdateDto;
import com.heaptrace.user.entity.User;

public interface UserService {

	UserRegisterResponseDto registerUser(UserRegisterDto userRegisterDto);

	List<User> listUsers();

	User getSpecificUser(Long id);

	ApiResponse updateUserDetails(Long id, UserUpdateDto userUpdateDto);

	ApiResponse deleteUser(Long id);
	
}
