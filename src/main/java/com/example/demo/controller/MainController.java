package com.example.demo.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

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

import com.example.demo.model.UserModel;

@RestController    //--> 이 클래스를 Rest api 컨트롤러로 인식
public class MainController {
	
	
	// 연습용
	@RequestMapping(value="/api/all", method = RequestMethod.GET)
	@ResponseStatus(value = HttpStatus.OK)
	public String getApi() {
		return "Hello!";
	}
	
	private Map<String, UserModel> userMap;
	
	@PostConstruct  //--> 데이터들 초기화 할 때 사용 (맨 처음 픽스됨)
	public void init() {
		userMap = new HashMap<String, UserModel>();
		//userMap.put(1, "kjh", "1234", "123@123", Date(), 'Y');
	}
	
	/*
	 	Get : 검색, 조회   
	 	POST : 데이터 수정   
	 	PUT : 데이터 입력 (생성)
	 	DELETE : 데이터 삭제  
	*/
	
	
	// 특정 아이디로 유저 불러오기
	@GetMapping("/user/{id}")  
	public UserModel getUserModel(@PathVariable("id") String id) {
		return userMap.get(id);
	}
	
	// 모든 유저 불러오기
	@GetMapping("/user/all")
	public List<UserModel> getUserProfileList() {
		return new ArrayList<UserModel>(userMap.values());
	}
	
	// 사용자 입력
	@PutMapping("/user/{id}")
	public void putUserModel(@PathVariable("id") String id, @RequestParam("name") String name, @RequestParam("password") String password) {
		int pid = Integer.parseInt(id);		
		UserModel userModel = new UserModel(pid, name, password);
		userMap.put(id, userModel);
	}
	
	// 사용자 수정
	@PostMapping("/user/{id}")
	public void postUserModel(@PathVariable("id") String id, @RequestParam("name") String name, @RequestParam("password") String password) {
		UserModel userModel = userMap.get(id);  // 사용자를 먼저 찾아준 뒤에
		userModel.setName(name);
		userModel.setPassword(password);
	}
	
	// 사용자 삭제
	@DeleteMapping("/user/{id}")
	public void deleteUserModel(@PathVariable("id") String id) {
		userMap.remove(id);
	}
	
}
