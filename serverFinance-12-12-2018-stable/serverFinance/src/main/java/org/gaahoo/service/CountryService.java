package org.gaahoo.service;

import java.util.List;

import org.gahoo.entity.Country;

public class CountryService extends ServiceParent<Country> {

	public String table="student";
	public CountryService() {
		super(Country.class);
		
		// TODO Auto-generated constructor stub
	}
	

	
	public Country find(String  uuid) {
		// TODO Auto-generated method stub
		
		return super.find(uuid);
		
	}

	@Override
	public void search() {
		// TODO Auto-generated method stub
		
	}


	public List<Country> all() {
		return super.all();
		// TODO Auto-generated method stub
		
	}
	public List<Country> allPaginate(int from, int to) {
		return super.allPaginate(from, to);
		// TODO Auto-generated method stub
		
	}

	@Override
	public Country save(Country entity) {
		
		// TODO Auto-generated method stub
		if(entity.getName().isEmpty()){
			return new Country();
		}else{
			return super.save(entity);
		}
		
		
	}
	public Country edit(Country entity) {
		
		// TODO Auto-generated method stub
		return super.edit(entity);
		
		
	}

	@Override
	public int delete(int id) {
		return super.delete(id);
		// TODO Auto-generated method stub
		
	}
}
