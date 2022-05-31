package com.springboot.todolist.service;

import com.springboot.todolist.web.dto.auth.SignupReqDto;

public interface AuthService {
	public boolean checkUsername(String username) throws Exception;
	public boolean signup(SignupReqDto signupReqDto) throws Exception;
}
