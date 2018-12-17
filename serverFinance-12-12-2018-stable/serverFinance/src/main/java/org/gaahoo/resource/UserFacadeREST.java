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

import org.gaahoo.service.UserService;
import org.gaahoo.response.UserResponse;
import org.gaahoo.service.TypeUserService;
import org.gahoo.entity.User;
import org.gahoo.entity.UserProfile;
import org.gahoo.entity.TypeEntree;
import org.gahoo.entity.TypeUser;


/**
 *
 * @author user
 */

@Path("user")
public class UserFacadeREST  {
	@GET
	@Path("{uuid}")
    @Produces(MediaType.APPLICATION_JSON)
    public User find(@PathParam("uuid") String uuid) {
    	 
    	 User  ss=new UserService().find(uuid);
    	 return ss;
		
	
    }
	
	@GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<User> all() {
    	 List<User>  ss= (List<User>) new UserService().all();
    	 //System.out.println(ss.get(0).getPosteDepenseList().size());
    	 return ss;
	
    }
	
	@GET
	@Path("{from}/{to}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<User> allPaginate(@PathParam("from") int from,@PathParam("to") int to) {
    	 
    	 List<User>  ss= (List<User>) new UserService().allPaginate(from, to);
    	 return ss;
		
	
    }
	
	@GET
    @Path("count")
	@Produces(MediaType.APPLICATION_JSON)
    public String count() {
        return String.valueOf(new UserService().count());
    }
	
	@DELETE
	@Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String delete(@PathParam("id") int id) {
    	 
    	 int  ss=new UserService().delete(id);
    	 return String.valueOf(ss) ;
		
	
    }
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public User save(User user) {
    	 
    	User  ss=new UserService().save(user);
    	 return ss ;
		
	
    }
	
	@PUT
	@Path("/profile")
	@Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public User updateProfileUser(User user) {
    	 
    	User  ss=new UserService().updateProfile(user);
    	 return ss ;
		
	
    }
	
	@POST
	@Path("/register")
	@Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public User createAccount(User user) {
    	 
    	User  ss=new UserService().createAccount(user);
    	 return ss ;
		
	
    }
	
	@POST
	@Path("/login")
	@Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public User login(User user) {
    	 
    	User  ss=new UserService().login(user);
    	 return ss ;
		
	
    }
	
	@PUT
	@Path("{id}")
	@Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public User edit(User user,@PathParam("id") int id) {
    	 
    	 User  ss=new UserService().edit(user);
    	 return ss ;
		
	}
    
	@GET
	@Path("/{id}/typeentree")
	@Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public List<TypeEntree> allTypeEntree(@PathParam("id") int id) {
    	 
		 List<TypeEntree>  ss= (List<TypeEntree>) new UserService().allTypeEntree(id);
    	 return ss ;
		
	
    }
	@GET
	@Path("/{id}/typeentree/{from}/{number}")
	@Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public List<TypeEntree> allPaginateTypeEntree(@PathParam("id") int id,@PathParam("from") int from,@PathParam("number") int number) {
    	 
		 List<TypeEntree>  ss= (List<TypeEntree>) new UserService().allPaginateTypeEntree(id, from, number);
    	return ss ;
		
	
    }
}
