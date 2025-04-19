package com.heaptrace.user.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserRegisterResponseDto {
	private LocalDateTime timeStamp;
	private String message;
	private Long userId;
	
	public UserRegisterResponseDto(String message, Long userId) {
		this.timeStamp = LocalDateTime.now();
		this.message = message;
		this.userId = userId;
	}
}
