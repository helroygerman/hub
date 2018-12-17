package org.gaahoo.service;

import java.util.List;

import org.gahoo.entity.Operation;
import org.gahoo.entity.TypeEntree;

public class OperationService extends ServiceParent<Operation>{

	
	public String table="student";
	public OperationService() {
		super(Operation.class);
		
		// TODO Auto-generated constructor stub
	}
	
	

	
	public Operation find(String uuid) {
		// TODO Auto-generated method stub
		
		return super.find(uuid);
		
	}

	@Override
	public void search() {
		// TODO Auto-generated method stub
		
	}


	public List<Operation> all() {
		return super.all();
		// TODO Auto-generated method stub
		
	}
	public List<Operation> allPaginate(int from, int to) {
		return super.allPaginate(from, to);
		// TODO Auto-generated method stub
		
	}
	public List<Operation> user(int id) {
		return super.allMapping(id, "user_id");
		// TODO Auto-generated method stub
		
	}

	@Override
	public Operation save(Operation entity) {
		
		// TODO Auto-generated method stub
		if(entity==null){
			return null;
		}else{
			return super.save(entity);
		}
		
		
	}
	public Operation edit(Operation entity) {
		
		// TODO Auto-generated method stub
		return super.edit(entity);
		
		
	}

	@Override
	public int delete(int id) {
		return super.delete(id);
		// TODO Auto-generated method stub
		
	}



	public Operation login(Operation entity) {
		// TODO Auto-generated method stub
		Operation u=new Operation();
		if(entity!=null){
			//return null;
			//u.setMessage("Success!");
			//u.setStatus("200");
			return u;
		}else{
			
		
			//String p=entity.getPassword();
			//entity.setPassword(MD5helper.hash(p));
			//return null;
			return new Operation();
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