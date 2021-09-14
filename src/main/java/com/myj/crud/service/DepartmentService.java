package com.myj.crud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myj.crud.bean.Department;
import com.myj.crud.dao.DepartmentMapper;

@Service
public class DepartmentService {
	@Autowired
	private DepartmentMapper departmentMapper;
	public List<Department> getDepts() {
		return departmentMapper.selectByExample(null);
	}

}
