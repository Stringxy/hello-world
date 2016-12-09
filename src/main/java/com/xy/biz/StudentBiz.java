package com.xy.biz;

import java.util.List;

import com.xy.entity.Student;

public interface StudentBiz extends CommonBiz<Student> {

	public List<Student> findAll();
}
