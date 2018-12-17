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

import org.gaahoo.service.ProfileService;
import org.gahoo.entity.Profile;
import org.gahoo.entity.Profile;

/**
 *
 * @author user
 */

@Path("profile")
public class ProfileFacadeREST  {
	@GET
	@Path("{uuid}")
    @Produces(MediaType.APPLICATION_JSON)
    public Profile find(@PathParam("uuid") String uuid) {
    	 
    	 Profile  ss=new ProfileService().find(uuid);
    	 return ss;
		
	
    }
	
	@GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Profile> all() {
    	 List<Profile>  ss= (List<Profile>) new ProfileService().all();
    	 return ss;
	
    }
	
	@GET
	@Path("{from}/{to}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Profile> allPaginate(@PathParam("from") int from,@PathParam("to") int to) {
    	 
    	 List<Profile>  ss= (List<Profile>) new ProfileService().allPaginate(from, to);
    	 return ss;
		
	
    }
	
	@GET
    @Path("count")
	@Produces(MediaType.APPLICATION_JSON)
    public String count() {
        return String.valueOf(new ProfileService().count());
    }
	
	@DELETE
	@Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String delete(@PathParam("id") int id) {
    	 
    	 int  ss=new ProfileService().delete(id);
    	 return String.valueOf(ss) ;
		
	
    }
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Profile save(Profile user) {
    	 
    	Profile  ss=new ProfileService().save(user);
    	 return ss ;
		
	
    }
	
	
	
	@PUT
	@Path("{uuid}")
	@Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Profile edit(Profile user,@PathParam("uuid") int id) {
    	 
    	 Profile  ss=new ProfileService().edit(user);
    	 return ss ;
		
	}
	
	
	
	@GET
	@Path("user/{user_uuid}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Profile> allProfileUser(@PathParam("user_uuid") int user_id) {
		
    	 int default_user_id=0;
    	 List<Profile>  ss= (List<Profile>) new ProfileService().allProfileUser(user_id);
    	 if(user_id!=0){
    		 List<Profile>  ss1= (List<Profile>) new ProfileService().allProfileUser(default_user_id);
        	 ss.addAll(ss1);
    	 }
    	 System.out.println(ss.size());
    	 return ss;
		
	
    }
    
}
