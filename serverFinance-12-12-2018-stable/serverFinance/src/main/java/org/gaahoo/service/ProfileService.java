package org.gaahoo.service;

import java.util.List;

import org.gahoo.entity.Profile;
import org.gahoo.entity.User;

public class ProfileService extends ServiceParent<Profile> {

	public String table="student";
	public ProfileService() {
		super(Profile.class);
		
		// TODO Auto-generated constructor stub
	}
	
public List<Profile> allProfileUser(int user_id) {
		
		return super.allMapping(user_id, "user_id");
		// TODO Auto-generated method stub
		
	}
	
	public Profile find(String uuid) {
		// TODO Auto-generated method stub
		
		return super.find(uuid);
		
	}

	@Override
	public void search() {
		// TODO Auto-generated method stub
		
	}


	public List<Profile> all() {
		return super.all();
		// TODO Auto-generated method stub
		
	}
	public List<Profile> allPaginate(int from, int to) {
		return super.allPaginate(from, to);
		// TODO Auto-generated method stub
		
	}

	@Override
	public Profile save(Profile entity) {
		
		// TODO Auto-generated method stub
		if(entity.getUserUuid().isEmpty()){
			return new Profile();
		}else{
			return super.save(entity);
		}
		
		
	}
	public Profile edit(Profile entity) {
		
		// TODO Auto-generated method stub
		return super.edit(entity);
		
		
	}
	
	

	@Override
	public int delete(int id) {
		return super.delete(id);
		// TODO Auto-generated method stub
		
	}
}