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
	
	//��ѯ������ʦ
	public List<Teacher> getTeachers(){
		
		return teacherMapper.getTeahcers();
	}
	//ɾ��ĳһ����ʦ
	public int deleteTeacherUsingId(String id){
		
		return teacherMapper.deleteTeacherUsingId(Integer.parseInt(id));
	}
	//����ĳһ����ʦ��Ϣ
	public int updateTeacherUsingId(String id,String name,String password){
		
		return teacherMapper.updateTeacherUsingId(Integer.parseInt(id), name, password);
	}
	//��ѯĳһ����ʦ�Ľӿ�ʵ��
	public Teacher getUserUsingId(String id){
		
		//System.out.println(teacherMapper.getTeacherUsingId(Integer.parseInt(id)).toString());
		
		return teacherMapper.getTeacherUsingId(Integer.parseInt(id));
	}
	//������Ϣ�Ľӿ�ʵ��
	public int insertTeacher(String name,String password){
		
		return teacherMapper.insertTeacher(name, password);
	}
	
}
