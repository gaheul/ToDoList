package com.springboot.todolist.domain.todolist;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ToDoListRepository {
	public int insertToDoList(ToDoListMst toDoListMst);
	public int updateToDoList(ToDoListMst toDoListMst);
	public int deleteToDoList(int id);
	public List<ToDoListMst> getListAll();
}
