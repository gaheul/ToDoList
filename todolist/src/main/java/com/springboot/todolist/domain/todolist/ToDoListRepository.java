package com.springboot.todolist.domain.todolist;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ToDoListRepository {
	public int insertToDoList(ToDoListMst toDoListMst);
}
