package com.xy.dao.impl;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.xy.dao.CommonDao;
import com.xy.util.HibernateUtil;

public abstract class CommonDaoImpl<T> implements CommonDao<T> {

	private Class<T> entity=null;
	
	public CommonDaoImpl(){
		Type tp=this.getClass().getGenericSuperclass();
		if(tp instanceof ParameterizedType){
			Type[] arr=((ParameterizedType)tp).getActualTypeArguments();
			entity=(Class<T>)arr[0];
		}
	}
	@Override
	public void insert(T obj) {
		Session session=HibernateUtil.getSession();
		Transaction trans=session.beginTransaction();
		
		try {
			session.save(obj);
			trans.commit();
		} catch (Exception e) {
			trans.rollback();
			e.printStackTrace();
			
		}
		
	}

	@Override
	public void update(T obj) {
		Session session=HibernateUtil.getSession();
		Transaction trans=session.beginTransaction();
		
		try {
			session.update(obj);
			trans.commit();
		} catch (Exception e) {
			trans.rollback();
			e.printStackTrace();
		}
		
	}

	@Override
	public void delete(T obj) {
		Session session =HibernateUtil.getSession();
		Transaction trans=session.beginTransaction();
		
		try {
			session.delete(obj);
			trans.commit();
		} catch (Exception e) {
			trans.rollback();
			e.printStackTrace();
		}
		
	}

	@Override
	public void delete(int id) {
		Object obj=null;
		Session session=HibernateUtil.getSession();
		Transaction trans=session.beginTransaction();
		
		try {
			obj=session.load(this.entity, id);
			session.delete(obj);
			trans.commit();
		} catch (Exception e) {
			trans.rollback();
			e.printStackTrace();
		}
		
		
	}

	@Override
	public T findById(int id) {
		Object obj=null;
		Session session=HibernateUtil.getSession();
		Transaction trans=session.beginTransaction();
		try {
			obj=session.get(this.entity,id);
			trans.commit();
			return (T)obj;
		} catch (Exception e) {
			trans.rollback();
			e.printStackTrace();
		}
		return null;
	}



}
