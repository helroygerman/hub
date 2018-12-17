package org.gaahoo.service;

import java.util.List;
import java.util.UUID;

import org.gaahoo.resource.DataBase;
import org.gahoo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public abstract class ServiceParent<T> {
	public Session s=null;
	public SessionFactory f=null;
	private Class<T> entityClass;
	
	
	public ServiceParent(Class<T> entityClass){
		DataBase d = new DataBase();
		this.f=d.factory(entityClass);
    	this.s=f.getCurrentSession();
    	this.entityClass = entityClass;
	}
	
	public int count(){
		return this.all().size();
	}
	
	@SuppressWarnings("finally")
	public T find(String uuid) {
		List<T> st = null;
		Transaction tx=null;
		this.f.openSession();
		tx=this.s.beginTransaction();
		try{
			
			
			st=this.s.createQuery("from " + entityClass.getName()+" WHERE uuid='"+uuid+"'").getResultList();
			tx.commit();
		}catch (Exception e) {
			// TODO: handle exception
			tx.rollback();
			
			System.out.println(e.getMessage());
			return null;
		}finally {
			this.f.close();
		}
		if(st.size()>0){
			return st.get(0);
		}else{
			return null;
		}
		

		
	}
	
	public void search() {
		// TODO Auto-generated method stub
		
	}
	
	public List<T> all() {
		// TODO Auto-generated method stub
		List<T> st = null;
		
		try{	
			this.s.beginTransaction();
			 st= this.s.createQuery("from " + entityClass.getName()).getResultList();;
			this.s.getTransaction().commit();
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}finally {
			this.f.close();
		}

		return st;
		
	}
	
	public List<T> allMapping(int id,String column) {
		// TODO Auto-generated method stub
		List<T> st = null;
		
		try{	
			this.s.beginTransaction();
			 st= this.s.createQuery("from " + entityClass.getName()+" WHERE "+column+"="+id).getResultList();;
			this.s.getTransaction().commit();
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}finally {
			this.f.close();
			
		}

		return st;
		
	}
	
	public List<T> allMappingUuid(String uuid,String column) {
		// TODO Auto-generated method stub
		List<T> st = null;
		
		try{	
			this.s.beginTransaction();
			 st= this.s.createQuery("from " + entityClass.getName()+" WHERE "+column+"='"+uuid+"' AND is_deleted=0").getResultList();;
			this.s.getTransaction().commit();
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}finally {
			this.f.close();
		}

		return st;
		
	}
	
	public List<T> allMappingUuid(String uuid,String column1,int etat) {
		// TODO Auto-generated method stub
		List<T> st = null;
		
		try{	
			this.s.beginTransaction();
			 st= this.s.createQuery("from " + entityClass.getName()+" WHERE ("+column1+"='"+uuid+"' OR etat="+etat+ ") AND is_deleted=0").getResultList();
			this.s.getTransaction().commit();
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}finally {
			this.f.close();
		}

		return st;
		
	}
	
	public List<T> allMappingUuid(String value1,String column1,String value2,String column2,String value3,String column3) {
		// TODO Auto-generated method stub
		List<T> st = null;
		
		try{	
			this.s.beginTransaction();
			 st= this.s.createQuery("from " + entityClass.getName()+" WHERE ("+column1+"='"+value1+"' AND "+column2+"='"+value2+ "') AND is_deleted=0").getResultList();;
			this.s.getTransaction().commit();
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}finally {
			this.f.close();
		}

		return st;
		
	}
	public T findMappingUuid(String value1,String column1,String value2,String column2,String value3,String column3) {
		// TODO Auto-generated method stub
		List<T> st = null;
		Transaction tx=null;
		this.f.openSession();
		tx=this.s.beginTransaction();
		try{	
			
			 st= this.s.createQuery("from " + entityClass.getName()+" WHERE ("+column1+"='"+value1+"' AND "+column2+"='"+value2+ "' AND "+column3+"='"+value3+ "') AND is_deleted=0 ").getResultList();;
			 tx.commit();
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			tx.rollback();
		}finally {
			this.f.close();
		}
		if(st!=null){
			if(st.size()>0){
				return st.get(0);
			}
		}
		

		return null;
		
	}
	
	public List<T> allPaginateMapping(int id,String column,int from,int number) {
		// TODO Auto-generated method stub
		List<T> st = null;
		
		try{	
			this.s.beginTransaction();
			Query q= this.s.createQuery("from " + entityClass.getName()+" WHERE "+column+"="+id);
			q.setFirstResult(from);
			q.setMaxResults(number);
			 st= q.getResultList();
			this.s.getTransaction().commit();
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}finally {
			this.f.close();
		}

		return st;
		
	}
	
	public List<T> allPaginate(int from,int to) {
		// TODO Auto-generated method stub
		List<T> st = null;
		
		try{	
			this.s.beginTransaction();
			Query q= this.s.createQuery("from " + entityClass.getName());
			q.setFirstResult(from);
			q.setMaxResults(to);
			 st= q.getResultList();
			this.s.getTransaction().commit();
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}finally {
			this.f.close();
		}

		return st;
		
	}
	
	public T save(T entity) {
		// TODO Auto-generated method stub
		//T t1=null;
		if(entity!=null){
			try{	
				this.s.beginTransaction();
				
				 this.s.saveOrUpdate(entity);
				 //t1=this.s.get(entityClass, entity.getClass().)
				this.s.getTransaction().commit();
			}catch (Exception e) {
				// TODO: handle exception
				System.out.println(e.getMessage());
				this.s.getTransaction().rollback();
				return  null;
			}finally {
				this.f.close();
			}

			return entity;
		}else{
			return null;
		}
		
		
	}
	
	public List<T> saveAll(List<T> entity) {
		// TODO Auto-generated method stub
		if(entity!=null){
			try{	
				this.s.beginTransaction();
				for(T e:entity){
					this.s.saveOrUpdate(e);
				}
				 
				this.s.getTransaction().commit();
			}catch (Exception e) {
				// TODO: handle exception
				System.out.println(e.getMessage());
				this.s.getTransaction().rollback();
				return  null;
			}finally {
				this.f.close();
			}

			return entity;
		}else{
			return null;
		}
		
		
	}
	
	public T edit(T entity) {
		// TODO Auto-generated method stub
		Transaction tx = null;

		tx=this.s.beginTransaction();
		try{	
			
			 
			
				 this.s.saveOrUpdate(entity);
			tx.commit();
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			
				tx.rollback();
			
			
			return  null;
		}finally {
			this.f.close();
		}

		return entity;
		
	}
	
	
	
	public int  delete(int id) {
		// TODO Auto-generated method stub
		T st = null;
		try{	
			this.s.beginTransaction();
			st=this.s.get(entityClass, id);
			if(st==null){
				return 0;
			}else{
				this.s.delete(st);
			}
			
			this.s.getTransaction().commit();
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			this.s.getTransaction().rollback();
			return -1;
		}finally {
			this.f.close();
		}

		return 1;
		
	}
}
