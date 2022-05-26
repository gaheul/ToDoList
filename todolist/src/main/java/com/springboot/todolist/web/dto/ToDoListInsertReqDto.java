package com.springboot.todolist.web.dto;

import com.springboot.todolist.domain.todolist.ToDoListMst;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ToDoListInsertReqDto {
	private String content;
	
	public ToDoListMst toEntity() {
		return ToDoListMst.builder()
				
				.content(content)
				.build();
	}
}
