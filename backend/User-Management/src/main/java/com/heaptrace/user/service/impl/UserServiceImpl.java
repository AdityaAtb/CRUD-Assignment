package com.heaptrace.user.service.impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.heaptrace.user.dao.UserDao;
import com.heaptrace.user.dto.ApiResponse;
import com.heaptrace.user.dto.UserRegisterDto;
import com.heaptrace.user.dto.UserRegisterResponseDto;
import com.heaptrace.user.dto.UserUpdateDto;
import com.heaptrace.user.entity.User;
import com.heaptrace.user.exception.FieldNotAvailableException;
import com.heaptrace.user.exception.ResourceNotFoundException;
import com.heaptrace.user.service.UserService;

import lombok.AllArgsConstructor;

@Service
@Transactional
@AllArgsConstructor
public class UserServiceImpl implements UserService {
	private UserDao userDao;
	private ModelMapper modelMapper;
	
	@Override
	public UserRegisterResponseDto registerUser(UserRegisterDto userRegisterDto) {
		if(userDao.existsByEmail(userRegisterDto.getEmail()))
			throw new FieldNotAvailableException("Email already exists!");
		
		User user = modelMapper.map(userRegisterDto, User.class);
		User u = userDao.save(user);
		
		return new UserRegisterResponseDto("User registered successfully!", u.getId());
	}

	@Override
	public List<User> listUsers() {
		List<User> uList = userDao.findAll();
		
		if(uList.isEmpty()) {
			throw new ResourceNotFoundException("No users exists!");
		}
		
		return uList;
	}

	@Override
	public User getSpecificUser(Long id) {
		User u = userDao.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("User does not exists!"));
		
		return u;
	}

	@Override
	public ApiResponse updateUserDetails(Long id, UserUpdateDto userUpdateDto) {
		User u = userDao.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("User does not exists!"));
		
		if(userDao.existsByEmail(userUpdateDto.getEmail())) {
			throw new FieldNotAvailableException("Email id already exists!");
		}
		
		if(userUpdateDto.getFirstName().length() != 0)
			u.setFirstName(userUpdateDto.getFirstName());
		
		if(userUpdateDto.getLastName().length() != 0)
			u.setLastName(userUpdateDto.getLastName());
		
		if(userUpdateDto.getEmail().length() != 0)
			u.setEmail(userUpdateDto.getEmail());
		
		if(userUpdateDto.getPhoneNumber().length() != 0)
			u.setPhoneNumber(userUpdateDto.getPhoneNumber());
		
		return new ApiResponse("User details updated successfully!");
	}

	@Override
	public ApiResponse deleteUser(Long id) {
		User u = userDao.findById(id)
				.orElseThrow(() ->  new ResourceNotFoundException("User does not exists!"));
		
		userDao.delete(u);
		
		return new ApiResponse("User deleted successfully!");
	}

}
