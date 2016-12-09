package com.xy.dao.impl;

import java.util.List;
import java.util.Map;

import com.xy.dao.StudentDao;
import com.xy.entity.Student;
import com.xy.util.PageUtil;

public class StudentDaoImpl extends CommonDaoImpl<Student> implements StudentDao {


	@Override
	public List<Student> searchPaging(Map<String, Object> params,
			PageUtil<Student> paging) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int searchPagingCount(Map<String, Object> params) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Student> findAll() {
		String hql="from Student";
		return HQLTemplate.searchHql(hql, null);
	}

}
