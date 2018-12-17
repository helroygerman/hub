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

import org.gaahoo.service.PlanningService;
import org.gahoo.entity.Planning;
import org.gahoo.entity.Planning;

/**
 *
 * @author user
 */

@Path("planning")
public class PlanningFacadeREST  {
	@GET
	@Path("{uuid}")
    @Produces(MediaType.APPLICATION_JSON)
    public Planning find(@PathParam("id") String uuid) {
    	 
    	 Planning  ss=new PlanningService().find(uuid);
    	 return ss;
		
	
    }
	
	@GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Planning> all() {
    	 List<Planning>  ss= (List<Planning>) new PlanningService().all();
    	 return ss;
	
    }
	
	@GET
	@Path("{from}/{to}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Planning> allPaginate(@PathParam("from") int from,@PathParam("to") int to) {
    	 
    	 List<Planning>  ss= (List<Planning>) new PlanningService().allPaginate(from, to);
    	 return ss;
		
	
    }
	
	@GET
    @Path("count")
	@Produces(MediaType.APPLICATION_JSON)
    public String count() {
        return String.valueOf(new PlanningService().count());
    }
	
	@DELETE
	@Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String delete(@PathParam("id") int id) {
    	 
    	 int  ss=new PlanningService().delete(id);
    	 return String.valueOf(ss) ;
		
	
    }
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Planning save(Planning user) {
    	 
    	Planning  ss=new PlanningService().save(user);
    	 return ss ;
		
	
    }
	
	
	
	@PUT
	@Path("{id}")
	@Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Planning edit(Planning user,@PathParam("id") int id) {
    	 
    	 Planning  ss=new PlanningService().edit(user);
    	 return ss ;
		
	}
    
    
}
