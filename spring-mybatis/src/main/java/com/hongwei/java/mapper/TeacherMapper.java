package com.hongwei.java.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;

import com.hongwei.java.vo.Teacher;



@Component
public interface TeacherMapper {

	//定义查询所有数据的接口
	@Select("select * from teacher")
	public List<Teacher> getTeahcers();
	
	//定义查询某个数据的接口
	@Select("select * from teacher where id=#{id}")
	public Teacher getTeacherUsingId(@Param("id") int id);
	
	//定义修改数据的接口
	@Update("update teacher set name=#{name},password=#{password} where id=#{id}")
	public int updateTeacherUsingId(@Param("id") int id,@Param("name") String name,@Param("password") String password);
	
	
	//定义删除数据的接口
	@Delete("delete from teacher where id=#{id}")
	public int deleteTeacherUsingId(@Param("id") int id);
	
	//定义插入数据接口
	@Insert("insert into teacher (name,password) value (#{name},#{password})")
	public int insertTeacher(@Param("name") String name,@Param("password") String password);
	
}	
	
	