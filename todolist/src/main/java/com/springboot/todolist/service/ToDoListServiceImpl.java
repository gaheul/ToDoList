package com.springboot.todolist.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.springboot.todolist.domain.todolist.ToDoListMst;
import com.springboot.todolist.domain.todolist.ToDoListRepository;
import com.springboot.todolist.web.dto.ToDoListInsertReqDto;
import com.springboot.todolist.web.dto.ToDoListUpdateReqDto;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ToDoListServiceImpl implements ToDoListService {
	
	private final ToDoListRepository toDoListRepository;
	
	@Override
	public List<ToDoListMst> getTodolistAll() {
		List<ToDoListMst> toDoListMsts = toDoListRepository.getListAll();
		
		return toDoListMsts;
	}
	
	@Override
	public int createToDoList(ToDoListInsertReqDto toDoListInsertReqDto) {

		ToDoListMst toDoListMst = toDoListInsertReqDto.toEntity();
		
		int result = toDoListRepository.insertToDoList(toDoListMst);
		
		if(result > 0) {
			return toDoListMst.getId();
		}
		
		return 0;
	}
	
	@Override
	public int updateToDoLiST(int id, ToDoListUpdateReqDto toDoListUpdateReqDto) {
		ToDoListMst toDoListMst = toDoListUpdateReqDto.toUpdateEntity(id);
		toDoListRepository.updateToDoList(toDoListMst);
		return toDoListRepository.updateToDoList(toDoListMst) > 0 ? id : 0;
	}
	
	@Override
	public int deleteToDoLIST(int id) {
		
		return toDoListRepository.deleteToDoList(id) > 0 ? id : 0;
	}
}
