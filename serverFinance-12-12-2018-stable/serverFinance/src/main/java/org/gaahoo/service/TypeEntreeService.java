package org.gaahoo.service;

import java.util.Date;
import java.util.List;

import org.gahoo.entity.TypeEntree;


public class TypeEntreeService extends ServiceParent<TypeEntree> {

	public String table="student";
	public TypeEntreeService() {
		super(TypeEntree.class);
		
		// TODO Auto-generated constructor stub
	}
	

	
	public TypeEntree find(String uuid) {
		// TODO Auto-generated method stub
		
		return super.find(uuid);
		
	}
	
	public  List<TypeEntree> user(int id) {
		// TODO Auto-generated method stub
		
		return super.allMapping(id, "user_id");
		
	}
	public  List<TypeEntree> userPaginate(int id,int from,int number) {
		// TODO Auto-generated method stub
		
		return super.allPaginateMapping(id, "user_id",from,number);
		
	}

	@Override
	public void search() {
		// TODO Auto-generated method stub
		
	}


	public List<TypeEntree> all() {
		return super.all();
		// TODO Auto-generated method stub
		
	}
	public List<TypeEntree> allPaginate(int from, int to) {
		return super.allPaginate(from, to);
		// TODO Auto-generated method stub
		
	}

	@Override
	public TypeEntree save(TypeEntree entity) {
		
		// TODO Auto-generated method stub
		if(entity.getLibelle().isEmpty()){
			return new TypeEntree();
		}else{
			entity.setCreatedAt(new Date());
			return super.save(entity);
			
		}
		
		
	}
	public TypeEntree edit(TypeEntree entity) {
		
		// TODO Auto-generated method stub
		return super.edit(entity);
		
		
	}

	@Override
	public int delete(int id) {
		return super.delete(id);
		// TODO Auto-generated method stub
		
	}
}
