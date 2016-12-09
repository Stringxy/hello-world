package com.xy.dao;

import java.util.List;

import com.xy.entity.Student;

public interface StudentDao extends CommonDao<Student> {

	public List<Student> findAll();
}
