package org.gaahoo.service;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.gaahoo.helper.DataHelper;
import org.gahoo.entity.TypeUser;

public class TypeUserService extends ServiceParent<TypeUser> {

	public String table="student";
	public TypeUserService() {
		super(TypeUser.class);
		
		// TODO Auto-generated constructor stub
	}
	

	
	public TypeUser find(String uuid) {
		// TODO Auto-generated method stub
		
		return super.find(uuid);
		
	}

	@Override
	public void search() {
		// TODO Auto-generated method stub
		
	}


	public List<TypeUser> all() {
		return super.all();
		// TODO Auto-generated method stub
		
	}
	public List<TypeUser> allPaginate(int from, int to) {
		return super.allPaginate(from, to);
		// TODO Auto-generated method stub
		
	}

	@Override
	public TypeUser save(TypeUser entity) {
		
		// TODO Auto-generated method stub
		if(entity!=null ){
			if(entity.getLibelle()!=null){
				
				entity.setCreatedAt(new Date());
				entity.setUpdatedAt(new Date());
				entity.setUuid(DataHelper.uuid());
				
			}
			
			
		}else{
			
			return new TypeUser();
		}
		return super.save(entity);
		
	}
	public TypeUser edit(TypeUser entity) {
		
		// TODO Auto-generated method stub
		return super.edit(entity);
		
		
	}

	@Override
	public int delete(int id) {
		return super.delete(id);
		// TODO Auto-generated method stub
		
	}

	
	
}
