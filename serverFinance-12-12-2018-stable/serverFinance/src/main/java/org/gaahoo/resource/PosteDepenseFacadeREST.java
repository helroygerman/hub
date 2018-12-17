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
import org.gaahoo.service.PosteDepenseService;
import org.gahoo.entity.PosteDepense;
import org.gahoo.entity.Student;
import org.gahoo.entity.PosteDepense;

/**
 *
 * @author user
 */

@Path("postedepense")
public class PosteDepenseFacadeREST {
	@GET
	@Path("{uuid}")
    @Produces(MediaType.APPLICATION_JSON)
    public PosteDepense find(@PathParam("uuid") String uuid) {
    	 
		PosteDepense  ss=new PosteDepenseService().find(uuid);
    	 return ss;
		
	
    }
	
	@GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<PosteDepense> all() {
    	 List<PosteDepense>  ss= (List<PosteDepense>) new PosteDepenseService().all();
    	 return ss;
	
    }
	
	@GET
	@Path("{from}/{to}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<PosteDepense> allPaginate(@PathParam("from") int from,@PathParam("to") int to) {
    	 
    	 List<PosteDepense>  ss= (List<PosteDepense>) new PosteDepenseService().allPaginate(from, to);
    	 return ss;
		
	
    }
	
	@GET
	@Path("user/{user_uuid}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<PosteDepense> allPosteDepenseUser(@PathParam("user_uuid") String user_uuid) {
		
    	 int default_user_id=0;
    	 List<PosteDepense>  ss= (List<PosteDepense>) new PosteDepenseService().allPosteDepenseUser(user_uuid);
    	 
    	 return ss;
		
	
    }
	
	@GET
	@Path("user/{user_uuid}/{operation_uuid}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<PosteDepense> allPosteDepenseUserOperation(@PathParam("user_uuid") String user_uuid,@PathParam("operation_uuid") String operation_uuid) {
		
		List<PosteDepense>  ss= (List<PosteDepense>) new PosteDepenseService().allPosteDepenseUser(user_uuid,operation_uuid);
   	 
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
    	 
    	 int  ss=new PosteDepenseService().delete(id);
    	 return String.valueOf(ss) ;
		
	
    }
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public PosteDepense save(PosteDepense poste) {
    	 
    	 PosteDepense  ss=new PosteDepenseService().save(poste);
    	 return ss ;
		
	
    }
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public PosteDepense update(PosteDepense poste) {
    	 
    	 PosteDepense  ss=new PosteDepenseService().edit(poste);
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
