package com.xy.dao.impl;

import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.xy.util.HibernateUtil;
import com.xy.util.PageUtil;

public final class HQLTemplate {

	
	public static List searchHql(String hql,Map<String,Object>params,PageUtil page){
		List arr=null;
		Session session =HibernateUtil.getSession();
		Transaction trans=session.beginTransaction();
		
		try {
			Query query=session.createQuery(hql);
			if(params!=null){
				for(String key:params.keySet()){
					query.setParameter(key,params.get(key));
				}
			}
			if(page!=null){
				query.setFirstResult(page.getBegin());
				query.setMaxResults(page.getEnd());
			}
			arr=query.list();
			trans.commit();
		} catch (Exception e) {
			trans.rollback();
			e.printStackTrace();
		}
		return arr;
	}
	public static List searchHql(String hql,Map<String,Object>params){
		return searchHql(hql, params,null);
	}
	
	public static Object searchUnique(String hql,Map<String,Object> params){
		Object obj=null;
		Session session =HibernateUtil.getSession();
		Transaction trans=session.beginTransaction();
		
		try {
			Query query=session.createQuery(hql);
			if(params!=null){
				for(String key:params.keySet()){
					query.setParameter(key,params.get(key));
				}
			}
			obj=query.uniqueResult();
			trans.commit();
		} catch (Exception e) {
			trans.rollback();
			e.printStackTrace();
		}
		return obj;
	}
	
	public static int searchCount(String hql,Map<String,Object> params){
		Object obj=searchUnique(hql, params);
		if(obj!=null){
		return ((Long)obj).intValue();
		}
		return 0;
	}
}
