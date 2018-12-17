package org.gaahoo.service;

import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import org.gaahoo.helper.DataHelper;
import org.gahoo.entity.PosteDepense;

public class PosteDepenseService extends ServiceParent<PosteDepense> {

	public String table="student";
	public PosteDepenseService() {
		super(PosteDepense.class);
		TimeZone.setDefault( TimeZone.getTimeZone( "UTC" ) );
		
		// TODO Auto-generated constructor stub
	}
	

	
	public PosteDepense find(String uuid) {
		// TODO Auto-generated method stub
		System.out.println(uuid);
		return super.find(uuid);
		
	}

	@Override
	public void search() {
		// TODO Auto-generated method stub
		
	}


	public List<PosteDepense> all() {
		return super.all();
		// TODO Auto-generated method stub
		
	}
	
	public List<PosteDepense> allPosteDepenseUser(String  user_uuid) {
			List<PosteDepense> st = null;
		
		try{	
			this.s.beginTransaction();
			 st= this.s.createQuery("from PosteDepense WHERE (user_uuid='"+user_uuid+"' OR etat=1)").getResultList();;
			this.s.getTransaction().commit();
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}finally {
			this.f.close();
		}

		return st;
		// TODO Auto-generated method stub
		
	}
	public List<PosteDepense> allPosteDepenseUser(String  user_uuid,String operation_uuid) {
		List<PosteDepense> st = null;
	
	try{	
		this.s.beginTransaction();
		 st= this.s.createQuery("from PosteDepense WHERE (user_uuid='"+user_uuid+"' AND operation_uuid='"+operation_uuid+"' OR etat=1)").getResultList();;
		this.s.getTransaction().commit();
	}catch (Exception e) {
		// TODO: handle exception
		System.out.println(e.getMessage());
	}finally {
		this.f.close();
	}

	return st;
	// TODO Auto-generated method stub
	
}
public List<PosteDepense> allPosteDepenseOperation(int user_id) {
		
		return super.allMapping(user_id, "operation_id");
		// TODO Auto-generated method stub
		
	}
public List<PosteDepense> allPosteDepenseOperationUuid(String operation_uuid) {
	
	return super.allMappingUuid(operation_uuid, "operation_uuid");
	// TODO Auto-generated method stub
	
}
	
	public List<PosteDepense> allPaginate(int from, int to) {
		return super.allPaginate(from, to);
		// TODO Auto-generated method stub
		
	}

	@Override
	public PosteDepense save(PosteDepense entity) {
		
		
		// TODO Auto-generated method stub
		if(entity!=null){
			if(entity.getLibelle()==null){
				return new PosteDepense();
			}else{
					
				entity.setUuid(DataHelper.uuid());
				entity.setCreatedAt(new Date());
				entity.setUpdatedAt(new Date());
				System.out.println(entity);
				return super.save(entity);
			}
		}else{
			return new PosteDepense();
		}
		
		
		
	}
	public PosteDepense edit(PosteDepense entity) {
		
		// TODO Auto-generated method stub
		return super.edit(entity);
		
		
	}

	@Override
	public int delete(int id) {
		return super.delete(id);
		// TODO Auto-generated method stub
		
	}
}
