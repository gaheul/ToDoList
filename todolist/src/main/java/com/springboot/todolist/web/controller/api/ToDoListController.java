package com.springboot.todolist.web.controller.api;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.todolist.domain.todolist.ToDoListMst;
import com.springboot.todolist.service.ToDoListService;
import com.springboot.todolist.web.dto.CMRespDto;
import com.springboot.todolist.web.dto.ToDoListInsertReqDto;
import com.springboot.todolist.web.dto.ToDoListUpdateReqDto;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class ToDoListController {
	
	private final ToDoListService toDoListService;
	
	//리스트 전체 들고오기
	@GetMapping("/todo/list")
	public ResponseEntity<?> getListAll(){
		List<ToDoListMst> toList= toDoListService.getTodolistAll();
		return new ResponseEntity<>(toList,HttpStatus.OK);
	}
	
	//내용추가
	@PostMapping("/todo")
	public ResponseEntity<?> addToDO(@Valid @RequestBody ToDoListInsertReqDto todoListInsertReqDto,BindingResult bindingResult){
		if(bindingResult.hasErrors()) {
			Map<String, String> errorMap = new HashMap<String, String>();
			for(FieldError error : bindingResult.getFieldErrors()) {
				errorMap.put(error.getField(), error.getDefaultMessage());
			}
			return new ResponseEntity<>(new CMRespDto<Map<String, String>>(-1,"추가실패",errorMap) ,HttpStatus.BAD_REQUEST);
		}
		int id =toDoListService.createToDoList(todoListInsertReqDto);
		return new ResponseEntity<>(new CMRespDto<Integer>(1,"추가성공",id) ,HttpStatus.OK);
	}
	
	//내용수정
	@PutMapping("/todo/{id}")
	public ResponseEntity<?> modifiToDO(@PathVariable int id,@Valid @RequestBody ToDoListUpdateReqDto toDoListUpdateReqDto,BindingResult bindingResult){
		if(bindingResult.hasErrors()) {
			Map<String, String> errorMap = new HashMap<String, String>();
			for(FieldError error : bindingResult.getFieldErrors()) {
				errorMap.put(error.getField(), error.getDefaultMessage());
			}
			return new ResponseEntity<>(errorMap,HttpStatus.BAD_REQUEST);
		}
		
		int resultId =toDoListService.updateToDoLiST(id, toDoListUpdateReqDto);
		return new ResponseEntity<>(resultId, HttpStatus.OK);
	}
	
	//내용삭제
	@DeleteMapping("/todo/{id}")
	public ResponseEntity<?> removeToDO(@PathVariable int id){
		int resultId =toDoListService.deleteToDoLIST(id);
		return new ResponseEntity<>(new CMRespDto<Integer>(1,"삭제성공",resultId), HttpStatus.OK);
	} 
}
