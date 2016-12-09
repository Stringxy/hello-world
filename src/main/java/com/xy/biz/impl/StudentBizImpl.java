package com.xy.biz.impl;

import java.util.List;

import com.xy.biz.StudentBiz;
import com.xy.dao.StudentDao;
import com.xy.dao.impl.StudentDaoImpl;
import com.xy.entity.Student;

public class StudentBizImpl extends CommonBizImpl<Student> implements StudentBiz {

	private StudentDao sd=new StudentDaoImpl();
	public StudentBizImpl(){
		super.setCommonDao(sd);
	}
	@Override
	public List<Student> findAll() {
		// TODO Auto-generated method stub
		return sd.findAll();
	}
	
}
