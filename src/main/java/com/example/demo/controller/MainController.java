package com.example.demo.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.mapper.UserModelMapper;
import com.example.demo.model.UserModel;

@RestController    //--> 이 클래스를 Rest api 컨트롤러로 인식
public class MainController {
	
	private UserModelMapper mapper;
	
	public MainController(UserModelMapper mapper) {
		this.mapper = mapper;  //전달받은 mapper를 내부 mapper로 저장해줌
	}

	// 연습용
	@RequestMapping(value="/api/all", method = RequestMethod.GET)
	@ResponseStatus(value = HttpStatus.OK)
	public String getApi() {
		return "Hello!";
	}
		
	/*
	 	Get : 검색, 조회   
	 	POST : 데이터 생성
	 	PUT : 데이터 수정
	 	DELETE : 데이터 삭제  
	*/
	
	
	// 특정 아이디로 유저 불러오기
	@GetMapping("/user/{id}")  
	public UserModel getUserModel(@PathVariable("id") String id) {
		return mapper.getUserModel(id);
	}
	
	// 모든 유저 불러오기
	@GetMapping("/user/all")
	public List<UserModel> getUserModelList() {
		return mapper.getUserModeList();
	}
	
	// 사용자 수정
	@PutMapping("/user/{id}")
	public void putUserModel(@PathVariable("id") String id, @RequestParam("name") String name, @RequestParam("password") String password) {		
		mapper.updateUserModel(id, name, password);
	}
	
	// 사용자 등록
	@PostMapping("/user/{id}")
	public void postUserModel(@PathVariable("id") String id, @RequestParam("name") String name, @RequestParam("password") String password) {
		mapper.insertUserMode(id, name, password);
	}
	
	// 사용자 삭제
	@DeleteMapping("/user/{id}")
	public void deleteUserModel(@PathVariable("id") String id) {
		mapper.deleteUserModel(id);
	}
	
}
