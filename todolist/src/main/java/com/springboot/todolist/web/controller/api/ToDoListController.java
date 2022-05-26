package com.springboot.todolist.web.controller.api;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.todolist.service.ToDoListService;
import com.springboot.todolist.web.dto.CMRespDto;
import com.springboot.todolist.web.dto.ToDoListInsertReqDto;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class ToDoListController {
	
	private final ToDoListService toDoListService;
	
	//리스트 전체 들고오기
	@GetMapping("/todo/list")
	public ResponseEntity<?> getListAll(){
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	//내용추가
	@PostMapping("/todo")
	public ResponseEntity<?> addToDO(@RequestBody ToDoListInsertReqDto todoListInsertReqDto){
		toDoListService.createToDoList(todoListInsertReqDto);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	//내용수정
	@PutMapping("/todo/{id}")
	public ResponseEntity<?> modifiToDO(@PathVariable int id){
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	//내용삭제
	@DeleteMapping("/todo/{id}")
	public ResponseEntity<?> removeToDO(@PathVariable int id){
		return new ResponseEntity<>(HttpStatus.OK);
	} 
}
