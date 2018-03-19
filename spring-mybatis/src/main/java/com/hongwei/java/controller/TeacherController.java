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
	
	//所有教师方法定义
	@RequestMapping(value="/findAll")
	public ModelAndView findAll(HttpServletResponse response){
		response.setCharacterEncoding("utf-8");
		
		List<Teacher> teachers = teacherService.getTeachers();
		ModelAndView modelAndView = new ModelAndView("showinfo");
		modelAndView.addObject("teachers", teachers);
		
		return modelAndView;
	}
	//寻找某一个教师
	@RequestMapping(value="/find")
	public ModelAndView find(@RequestParam String id,HttpServletResponse response){
		response.setCharacterEncoding("utf-8");
		
		Teacher teacher = teacherService.getUserUsingId(id);
		ModelAndView modelAndView = new ModelAndView("singleTeacher");
		modelAndView.addObject("teacher", teacher);
		
		return modelAndView;
	}
	//根据id号删除教师
	@RequestMapping(value="/delete")
	public String delete(@RequestParam String id,HttpServletResponse response){
		response.setCharacterEncoding("utf-8");
		
		teacherService.deleteTeacherUsingId(id);
		return "redirect:http://127.0.0.1:8080/spring-mybatis/teacher/findAll";
	}
	
	//根据id号修改教师信息
	@RequestMapping(value="/modify",method=RequestMethod.POST)
    public String  modify(@RequestParam("id") String id,HttpServletResponse response,@RequestParam("name") String name,@RequestParam("password") String password){
		response.setCharacterEncoding("utf-8");
		
		teacherService.updateTeacherUsingId(id, name, password);
		return "redirect:http://127.0.0.1:8080/spring-mybatis/teacher/findAll";
	}
	//进入添加页面的方法定义
	@RequestMapping(value="/add")
	public ModelAndView add(HttpServletResponse response){
		response.setCharacterEncoding("utf-8");
		
		return new ModelAndView("addinfo");
	}
	//执行用户添加
	@RequestMapping(value="/addinfo",method=RequestMethod.POST)
	public String addinfo(@RequestParam("id") String id,HttpServletResponse response,@RequestParam("name") String name,@RequestParam("password") String password){
		response.setCharacterEncoding("utf-8");
		
		teacherService.insertTeacher(name, password);
		
		//采用重定向的方法，可以防止数据重复插入
		return "redirect:http://127.0.0.1:8080/spring-mybatis/teacher/findAll";
	}	
}
