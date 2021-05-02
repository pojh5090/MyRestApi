package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.demo.model.UserModel;

@Mapper    
public interface UserModelMapper {
	
	// MainController에 있는 5개 메소드들에 매칭 
	
	// Get- 특정 사용자 불러오기
	@Select("SELECT * FROM UserModel WHERE id=#{id}")
	UserModel getUserModel(@Param("id") String id);
	
	
	// Get - 모든 사용자 불러오기
	@Select("SELECT * FROM UserModel")
	List<UserModel> getUserModeList();
	
	// Put - 사용자 수정하기
	@Update("UPDATE UserModel SET name=#{name}, password=#{password} WHERE id=#{id}")
	int updateUserModel(@Param("id") String id, @Param("name") String name, @Param("password") String password);
	
	// Post - 사용자 등록하기
	@Insert("INSERT INTO UserModel VALUES(#{id}, #{name}, #{password})")
	int insertUserMode(@Param("id") String id, @Param("name") String name, @Param("password") String password);
	
	// Delete - 사용자 삭제하기
	@Delete("DELETE FROM UserModel WHERE id=#{id}")
	int deleteUserModel(@Param("id") String id);
	
	
}
