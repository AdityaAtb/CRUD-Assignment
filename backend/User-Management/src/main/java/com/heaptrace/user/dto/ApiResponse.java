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
public class ApiResponse {
	private LocalDateTime timeStamp;
	private String message;
	
	public ApiResponse(String message) {
		this.message = message;
		this.timeStamp = LocalDateTime.now();
	}
}
