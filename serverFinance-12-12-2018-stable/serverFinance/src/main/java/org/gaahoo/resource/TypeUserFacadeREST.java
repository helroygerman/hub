/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.gaahoo.resource;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.gaahoo.service.StudentService;
import org.gaahoo.service.TypeUserService;
import org.gahoo.entity.Student;
import org.gahoo.entity.TypeUser;

/**
 *
 * @author user
 */

@Path("typeuser")
public class TypeUserFacadeREST {
	
	@GET
	@Path("{uuid}")
    @Produces(MediaType.APPLICATION_JSON)
    public Student find(@PathParam("uuid") String uuid) {
    	 
    	 Student  ss=new StudentService().find(uuid);
    	 return ss;
		
	
    }
	
	@GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<TypeUser> all() {
    	 List<TypeUser>  ss= (List<TypeUser>) new TypeUserService().all();
    	 return ss;
	
    }
	
	@GET
	@Path("{from}/{to}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Student> allPaginate(@PathParam("from") int from,@PathParam("to") int to) {
    	 
    	 List<Student>  ss= (List<Student>) new StudentService().allPaginate(from, to);
    	 return ss;
		
	
    }
	
	@GET
    @Path("count")
	@Produces(MediaType.APPLICATION_JSON)
    public String count() {
        return String.valueOf(new StudentService().count());
    }
	
	@DELETE
	@Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String delete(@PathParam("id") int id) {
    	 
    	 int  ss=new TypeUserService().delete(id);
    	 return String.valueOf(ss) ;
		
	
    }
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public TypeUser save(TypeUser typeUser) {
    	 
    	 TypeUser  ss=new TypeUserService().save(typeUser);
    	 return ss ;
		
	
    }
	
	@PUT
	@Path("{id}")
	@Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Student edit(Student student,@PathParam("id") int id) {
    	 
    	 Student  ss=new StudentService().edit(student);
    	 return ss ;
		
	
    }
    
}
