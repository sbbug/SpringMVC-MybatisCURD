package com.hongwei.java.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hongwei.java.mapper.TeacherMapper;
import com.hongwei.java.vo.Teacher;


@Service
public class TeacherService {

	@Autowired
	private TeacherMapper teacherMapper;
	
	//查询所有老师
	public List<Teacher> getTeachers(){
		
		return teacherMapper.getTeahcers();
	}
	//删除某一个老师
	public int deleteTeacherUsingId(String id){
		
		return teacherMapper.deleteTeacherUsingId(Integer.parseInt(id));
	}
	//更新某一个老师信息
	public int updateTeacherUsingId(String id,String name,String password){
		
		return teacherMapper.updateTeacherUsingId(Integer.parseInt(id), name, password);
	}
	//查询某一个老师的接口实现
	public Teacher getUserUsingId(String id){
		
		//System.out.println(teacherMapper.getTeacherUsingId(Integer.parseInt(id)).toString());
		
		return teacherMapper.getTeacherUsingId(Integer.parseInt(id));
	}
	//插入信息的接口实现
	public int insertTeacher(String name,String password){
		
		return teacherMapper.insertTeacher(name, password);
	}
	
}
