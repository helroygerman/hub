package org.gaahoo.service;

import java.lang.reflect.Field;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.List;

import org.gaahoo.helper.DataHelper;
import org.gaahoo.helper.MD5helper;
import org.gaahoo.response.UserResponse;
import org.gahoo.entity.Profile;
import org.gahoo.entity.TypeEntree;
import org.gahoo.entity.User;
import org.gahoo.entity.UserProfile;
import org.hibernate.query.Query;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.hasProperty;


public class UserService extends ServiceParent<User>{

	
	public String table="student";
	public UserService() {
		super(User.class);
		
		// TODO Auto-generated constructor stub
	}
	

	
	public User find(String uuid) {
		// TODO Auto-generated method stub
		
		return super.find(uuid);
		
	}

	@Override
	public void search() {
		// TODO Auto-generated method stub
		
	}


	public List<User> all() {
		return super.all();
		// TODO Auto-generated method stub
		
	}
	public List<User> allPaginate(int from, int to) {
		return super.allPaginate(from, to);
		// TODO Auto-generated method stub
		
	}

	@Override
	public User save(User entity) {
		
		// TODO Auto-generated method stub
		if(entity==null){
			return null;
		}else{
			return super.save(entity);
		}
		
		
	}
	
	public boolean exist(User user){
		User u=checkUser(user);
		if(u!=null){
			return true;
		}else{
			return false;
		}
		
	}
	
	
	public User createAccount(User entity) {
		@SuppressWarnings("unused")
		Profile p=new Profile();
		boolean is_ok=false;
		
		// TODO Auto-generated method stub
		if(entity==null){
			System.out.println("Ce compte existe deja!");
			return null;
		}else{
			try{	
				this.s.beginTransaction();
				Query q= this.s.createQuery("from User WHERE email='"+entity.getEmail()+"'" );
				List st = q.getResultList();
				System.out.println(st);
				if(st!=null && st.size()==0){
					entity.setPassword(MD5helper.hash(entity.getPassword()));
					entity.setUuid(DataHelper.uuid());
					entity.setCreatedAt(new Date());
					entity.setUpdatedAt(new Date());
					 this.s.save(entity);
					p=entity.getProfile();
					p.setCreatedAt(new Date());
					p.setUpdatedAt(new Date());
					p.setUserUuid(entity.getUuid());
					p.setUuid(DataHelper.uuid());
					this.s.save(p);
					is_ok=true;
				}else{
					is_ok=false;
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
			if(is_ok){
				entity.setProfile(p);
				User u=entity;
				return u;
			}else{
				return  null;
			}
			

			
		}
			
		
		
	}
	
	
	public User updateProfile(User entity) {
		@SuppressWarnings("unused")
		Profile p=new Profile();
		
		boolean is_ok=false;
		
		// TODO Auto-generated method stub
		if(entity==null){
			System.out.println("Ce compte existe deja!");
			return null;
		}else{
			try{
				p=entity.getProfile();
				this.s.beginTransaction();
				//Query q= this.s.createQuery("from User WHERE uuid='"+entity.getUuid()+"'" );
				List st = null;
				System.out.println(st);
				
					
					
					
					entity.setUpdatedAt(new Date());
					 this.s.saveOrUpdate(entity);
					
					
					p.setUpdatedAt(new Date());
					this.s.saveOrUpdate(p);
					is_ok=true;
				
				
				this.s.getTransaction().commit();
			}catch (Exception e) {
				// TODO: handle exception
				System.out.println(e.getMessage());
				this.s.getTransaction().rollback();
				is_ok=false;
				return  null;
			}finally {
				this.f.close();
			}
			if(is_ok){
				entity.setProfile(p);
				User u=entity;
				return u;
			}else{
				return  null;
			}
			

			
		}
			
		
		
	}
	
	public User edit(User entity) {
		
		// TODO Auto-generated method stub
		return super.edit(entity);
		
		
	}

	@Override
	public int delete(int id) {
		return super.delete(id);
		// TODO Auto-generated method stub
		
	}



	public User login(User entity) {
		// TODO Auto-generated method stub
		User u=new User();
		if(entity!=null){
			//return null;
			//u.setMessage("Success!");
			//u.setStatus("200");
			
			String password=MD5helper.hash(entity.getPassword());
			
			List<User> st = null;
			List<Profile> st1 = null;
			try{	
				this.s.beginTransaction();
				Query q= this.s.createQuery("from User WHERE email='"+entity.getEmail()+"' AND password='"+password+"'" );
				
				 st= q.getResultList();
				 
				 Query q1= this.s.createQuery("from Profile WHERE user_uuid='"+st.get(0).getUuid()+"'" );
					
				 st1= q1.getResultList();
				this.s.getTransaction().commit();
			}catch (Exception e) {
				// TODO: handle exception
				System.out.println(e.getMessage());
			}finally {
				this.f.close();
			}
			if(st!=null && st.size()>0){
				st.get(0).setProfile(st1.get(0));
				return  st.get(0);
				
			}else{
				return null;
			}
			

			
			
		}else{
			
		
			//String p=entity.getPassword();
			//entity.setPassword(MD5helper.hash(p));
			//return null;
			return new User();
			//return super.save(entity);
		}
	}
	
	
	public User checkUser(User entity) {
		// TODO Auto-generated method stub
		User u=new User();
		if(entity!=null){
			List<User> st = null;
			try{	
				this.s.beginTransaction();
				Query q= this.s.createQuery("from User WHERE email='"+entity.getEmail()+"'" );
				
				 st= q.getResultList();
				this.s.getTransaction().commit();
			}catch (Exception e) {
				// TODO: handle exception
				System.out.println(e.getMessage());
			}finally {
				this.f.close();
			}
			if(st!=null && st.size()>0){
				return  st.get(0);
				
			}else{
				return null;
			}
			
		}else{
			
			return new User();
			//return super.save(entity);
		}
	}

	public List<TypeEntree> allTypeEntree(int id) {
		return new TypeEntreeService().user(id);
		// TODO Auto-generated method stub
		
	}
	public List<TypeEntree> allPaginateTypeEntree(int id,int from,int number) {
		return new TypeEntreeService().userPaginate(id, from, number);
		// TODO Auto-generated method stub
		
	}
	
}
