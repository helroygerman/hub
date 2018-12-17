package org.gaahoo.service;

import java.util.List;

import org.gahoo.entity.Budget;
import org.gahoo.entity.Planning;

public class PlanningService extends ServiceParent<Planning> {

	public String table="student";
	public PlanningService() {
		super(Planning.class);
		
		// TODO Auto-generated constructor stub
	}
	

	
	public Planning find(String uuid) {
		// TODO Auto-generated method stub
		
		return super.find(uuid);
		
	}

	@Override
	public void search() {
		// TODO Auto-generated method stub
		
	}


	public List<Planning> all() {
		return super.all();
		// TODO Auto-generated method stub
		
	}
	public List<Planning> allPaginate(int from, int to) {
		return super.allPaginate(from, to);
		// TODO Auto-generated method stub
		
	}
	
	public Planning findMappingUuid(String value1,String column1,String value2,String column2,String value3,String column3){
		
		return super.findMappingUuid(value1,column1,value2,column2,value3,column3);
	}

	@Override
	public Planning save(Planning entity) {
		
		// TODO Auto-generated method stub
		if(entity.getFrequenceUuid().isEmpty()){
			return new Planning();
		}else{
			return super.save(entity);
		}
		
		
	}
	public Planning edit(Planning entity) {
		
		// TODO Auto-generated method stub
		return super.edit(entity);
		
		
	}

	@Override
	public int delete(int id) {
		return super.delete(id);
		// TODO Auto-generated method stub
		
	}
}
