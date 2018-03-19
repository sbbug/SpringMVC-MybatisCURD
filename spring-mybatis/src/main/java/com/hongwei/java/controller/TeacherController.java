package com.hongwei.java.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.hongwei.java.service.TeacherService;
import com.hongwei.java.vo.Teacher;


@Controller
@RequestMapping(value="/teacher")
public class TeacherController {

	@Autowired
	private TeacherService teacherService;
	
	//���н�ʦ��������
	@RequestMapping(value="/findAll")
	public ModelAndView findAll(HttpServletResponse response){
		response.setCharacterEncoding("utf-8");
		
		List<Teacher> teachers = teacherService.getTeachers();
		ModelAndView modelAndView = new ModelAndView("showinfo");
		modelAndView.addObject("teachers", teachers);
		
		return modelAndView;
	}
	//Ѱ��ĳһ����ʦ
	@RequestMapping(value="/find")
	public ModelAndView find(@RequestParam String id,HttpServletResponse response){
		response.setCharacterEncoding("utf-8");
		
		Teacher teacher = teacherService.getUserUsingId(id);
		ModelAndView modelAndView = new ModelAndView("singleTeacher");
		modelAndView.addObject("teacher", teacher);
		
		return modelAndView;
	}
	//����id��ɾ����ʦ
	@RequestMapping(value="/delete")
	public String delete(@RequestParam String id,HttpServletResponse response){
		response.setCharacterEncoding("utf-8");
		
		teacherService.deleteTeacherUsingId(id);
		return "redirect:http://127.0.0.1:8080/spring-mybatis/teacher/findAll";
	}
	
	//����id���޸Ľ�ʦ��Ϣ
	@RequestMapping(value="/modify",method=RequestMethod.POST)
    public String  modify(@RequestParam("id") String id,HttpServletResponse response,@RequestParam("name") String name,@RequestParam("password") String password){
		response.setCharacterEncoding("utf-8");
		
		teacherService.updateTeacherUsingId(id, name, password);
		return "redirect:http://127.0.0.1:8080/spring-mybatis/teacher/findAll";
	}
	//�������ҳ��ķ�������
	@RequestMapping(value="/add")
	public ModelAndView add(HttpServletResponse response){
		response.setCharacterEncoding("utf-8");
		
		return new ModelAndView("addinfo");
	}
	//ִ���û����
	@RequestMapping(value="/addinfo",method=RequestMethod.POST)
	public String addinfo(@RequestParam("id") String id,HttpServletResponse response,@RequestParam("name") String name,@RequestParam("password") String password){
		response.setCharacterEncoding("utf-8");
		
		teacherService.insertTeacher(name, password);
		
		//�����ض���ķ��������Է�ֹ�����ظ�����
		return "redirect:http://127.0.0.1:8080/spring-mybatis/teacher/findAll";
	}	
}
