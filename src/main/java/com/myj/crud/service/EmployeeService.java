package com.myj.crud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myj.crud.bean.Employee;
import com.myj.crud.bean.EmployeeExample;
import com.myj.crud.bean.EmployeeExample.Criteria;
import com.myj.crud.dao.EmployeeMapper;

@Service
public class EmployeeService {
	@Autowired
	EmployeeMapper employeeMapper;

	//��ѯ����Ա���������ţ�
	public List<Employee> getAll() {
		return employeeMapper.selectByExampleWithDept(null);
	}
	
	//Ա������
	public void saveEmp(Employee employee) {
		employeeMapper.insertSelective(employee);
	}

	//�����û����Ƿ����
	public boolean checkuser(String empName) {
		EmployeeExample example = new EmployeeExample();
		Criteria criteria = example.createCriteria();
		criteria.andEmpNameEqualTo(empName);
		long count = employeeMapper.countByExample(example);
		return count == 0;
	}

	//����Ա��id��ѯԱ��
	public Employee getEmp(Integer id) {
		Employee employee = employeeMapper.selectByPrimaryKey(id);
		return employee;
	}
	//����Ա��
	public void updateEmp(Employee employee) {
		employeeMapper.updateByPrimaryKeySelective(employee);
	}
	//ɾ������Ա��
	public void deleteEmp(Integer id) {
		employeeMapper.deleteByPrimaryKey(id);
	}
	//����ɾ��Ա��
	public void deleteBatch(List<Integer> ids) {
		// TODO Auto-generated method stub
		EmployeeExample example = new EmployeeExample();
		Criteria criteria = example.createCriteria();
		//delete from xxx where emp_id in(1,2,3)
		criteria.andEmpIdIn(ids);
		employeeMapper.deleteByExample(example);
	}

}
