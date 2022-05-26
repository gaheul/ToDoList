package com.springboot.todolist.service;

import com.springboot.todolist.web.dto.ToDoListInsertReqDto;

public interface ToDoListService {
	public int createToDoList(ToDoListInsertReqDto toDoListInsertReqDto);
}
