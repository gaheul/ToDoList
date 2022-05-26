package com.springboot.todolist.service;

import org.springframework.stereotype.Service;

import com.springboot.todolist.domain.todolist.ToDoListMst;
import com.springboot.todolist.domain.todolist.ToDoListRepository;
import com.springboot.todolist.web.dto.ToDoListInsertReqDto;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ToDoListServiceImpl implements ToDoListService {
	
	private final ToDoListRepository toDoListRepository;
	
	@Override
	public int createToDoList(ToDoListInsertReqDto toDoListInsertReqDto) {

		ToDoListMst toDoListMst = toDoListInsertReqDto.toEntity();
		
		int result = toDoListRepository.insertToDoList(toDoListMst);
		
		if(result > 0) {
			return toDoListMst.getId();
		}
		
		return 0;
	}
}
