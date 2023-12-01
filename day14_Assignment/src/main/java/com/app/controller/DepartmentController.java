package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.app.pojos.Department;
import com.app.service.DepartmentService;

@Controller
public class DepartmentController {
	@Autowired
	private DepartmentService deptService;
	public DepartmentController() 
	{
		System.out.println("in ctr of"+getClass());
	}
	@RequestMapping("/dept_list")
	public String listAllDept(Model modelAttrMap) {
		System.out.println("in list ALL DEPTS"+modelAttrMap);
		List<Department> listAllDepartments = deptService.listAllDepartments();	
		modelAttrMap.addAttribute("dept_list",listAllDepartments);
		return "/list";
	}
}
