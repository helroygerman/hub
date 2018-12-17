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
import org.gaahoo.service.PosteEntreeService;
import org.gahoo.entity.PosteEntree;
import org.gahoo.entity.Student;
import org.gahoo.entity.PosteEntree;

/**
 *
 * @author user
 */

@Path("posteentree")
public class PosteEntreeFacadeREST {
	@GET
	@Path("{uuid}")
    @Produces(MediaType.APPLICATION_JSON)
    public PosteEntree find(@PathParam("uuid") String uuid) {
    	 
		PosteEntree  ss=new PosteEntreeService().find(uuid);
    	 return ss;
		
	
    }
	
	@GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<PosteEntree> all() {
    	 List<PosteEntree>  ss= (List<PosteEntree>) new PosteEntreeService().all();
    	 return ss;
	
    }
	
	@GET
	@Path("{from}/{to}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<PosteEntree> allPaginate(@PathParam("from") int from,@PathParam("to") int to) {
    	 
    	 List<PosteEntree>  ss= (List<PosteEntree>) new PosteEntreeService().allPaginate(from, to);
    	 return ss;
		
	
    }
	
	@GET
	@Path("user/{user_uuid}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<PosteEntree> allPosteEntreeUser(@PathParam("user_uuid") String user_uuid) {
		
    	 int default_user_id=0;
    	 List<PosteEntree>  ss= (List<PosteEntree>) new PosteEntreeService().allPosteEntreeUser(user_uuid);
    	 
    	 return ss;
		
	
    }
	
	@GET
	@Path("user/{user_uuid}/{operation_uuid}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<PosteEntree> allPosteEntreeUserOperation(@PathParam("user_uuid") String user_uuid,@PathParam("operation_uuid") String operation_uuid) {
		
		List<PosteEntree>  ss= (List<PosteEntree>) new PosteEntreeService().allPosteEntreeUser(user_uuid,operation_uuid);
   	 
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
    	 
    	 int  ss=new PosteEntreeService().delete(id);
    	 return String.valueOf(ss) ;
		
	
    }
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public PosteEntree save(PosteEntree poste) {
    	 
    	 PosteEntree  ss=new PosteEntreeService().save(poste);
    	 return ss ;
		
	
    }
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public PosteEntree update(PosteEntree poste) {
    	 
    	 PosteEntree  ss=new PosteEntreeService().edit(poste);
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
