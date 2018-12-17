package org.gaahoo.service;

import java.util.List;

import org.gahoo.entity.Student;

public class StudentService extends ServiceParent<Student>{

	
	public String table="student";
	public StudentService() {
		super(Student.class);
		
		// TODO Auto-generated constructor stub
	}
	

	
	

	@Override
	public void search() {
		// TODO Auto-generated method stub
		
	}


	public List<Student> all() {
		return super.all();
		// TODO Auto-generated method stub
		
	}
	public List<Student> allPaginate(int from, int to) {
		return super.allPaginate(from, to);
		// TODO Auto-generated method stub
		
	}

	@Override
	public Student save(Student entity) {
		
		// TODO Auto-generated method stub
		if(entity.getFirstName().isEmpty()){
			return new Student();
		}else{
			return super.save(entity);
		}
		
		
	}
	public Student edit(Student entity) {
		
		// TODO Auto-generated method stub
		return super.edit(entity);
		
		
	}

	@Override
	public int delete(int id) {
		return super.delete(id);
		// TODO Auto-generated method stub
		
	}

	
}
