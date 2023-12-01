package com.app.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.DepartmentDaoImpl;
import com.app.pojos.Department;
@Service
@Transactional
public class DepartmentServiceImpl extends DepartmentService{

	@Autowired
	DepartmentDaoImpl dao;
	@Override
	public List<Department> listAllDepartments() {
		
		return dao.getAllDepartments();
	}

}
