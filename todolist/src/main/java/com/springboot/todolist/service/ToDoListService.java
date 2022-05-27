package com.springboot.todolist.service;

import java.util.List;

import com.springboot.todolist.domain.todolist.ToDoListMst;
import com.springboot.todolist.web.dto.ToDoListInsertReqDto;
import com.springboot.todolist.web.dto.ToDoListUpdateReqDto;

public interface ToDoListService {
	public int createToDoList(ToDoListInsertReqDto toDoListInsertReqDto);
	public int updateToDoLiST(int id, ToDoListUpdateReqDto toDoListUpdateReqDto);
	public int deleteToDoLIST(int id);
	public List<ToDoListMst> getTodolistAll();
}
