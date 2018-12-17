package org.gaahoo.service;

import java.util.List;

import org.gahoo.entity.Depense;
import org.gahoo.entity.Frequence;

public class FrequenceService extends ServiceParent<Frequence> {

	public String table="student";
	public FrequenceService() {
		super(Frequence.class);
		
		// TODO Auto-generated constructor stub
	}
	
public List<Frequence> allFrequenceUser(String user_uuid) {
		
		return super.allMappingUuid(user_uuid, "user_uuid",1);
		// TODO Auto-generated method stub
		
	}
	
	public Frequence find(String uuid) {
		// TODO Auto-generated method stub
		
		return super.find(uuid);
		
	}

	@Override
	public void search() {
		// TODO Auto-generated method stub
		
	}


	public List<Frequence> all() {
		return super.all();
		// TODO Auto-generated method stub
		
	}
	public List<Frequence> allPaginate(int from, int to) {
		return super.allPaginate(from, to);
		// TODO Auto-generated method stub
		
	}

	@Override
	public Frequence save(Frequence entity) {
		
		// TODO Auto-generated method stub
		if(entity.getLibelle().isEmpty()){
			return new Frequence();
		}else{
			return super.save(entity);
		}
		
		
	}
	public Frequence edit(Frequence entity) {
		
		// TODO Auto-generated method stub
		return super.edit(entity);
		
		
	}

	@Override
	public int delete(int id) {
		return super.delete(id);
		// TODO Auto-generated method stub
		
	}
}