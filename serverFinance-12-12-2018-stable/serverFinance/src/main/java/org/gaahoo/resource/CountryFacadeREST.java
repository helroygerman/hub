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

import org.gaahoo.service.CountryService;
import org.gahoo.entity.Abonnement;
import org.gahoo.entity.TypeEntree;
import org.gahoo.entity.Country;

/**
 *
 * @author user
 */

@Path("country")
public class CountryFacadeREST  {
	@GET
	@Path("{uuid}")
    @Produces(MediaType.APPLICATION_JSON)
    public Country find(@PathParam("uuid") String uuid) {
    	 
    	 Country  ss=new CountryService().find(uuid);
    	 return ss;
		
	
    }
	
	@GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Country> all() {
    	 List<Country>  ss= (List<Country>) new CountryService().all();
    	 return ss;
	
    }
	
	@GET
	@Path("{from}/{to}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Country> allPaginate(@PathParam("from") int from,@PathParam("to") int to) {
    	 
    	 List<Country>  ss= (List<Country>) new CountryService().allPaginate(from, to);
    	 return ss;
		
	
    }
	
	@GET
    @Path("count")
	@Produces(MediaType.APPLICATION_JSON)
    public String count() {
        return String.valueOf(new CountryService().count());
    }
	
	@DELETE
	@Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String delete(@PathParam("id") int id) {
    	 
    	 int  ss=new CountryService().delete(id);
    	 return String.valueOf(ss) ;
		
	
    }
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Country save(Country user) {
    	 
    	Country  ss=new CountryService().save(user);
    	 return ss ;
		
	
    }
	
	
	
	@PUT
	@Path("{id}")
	@Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Country edit(Country user,@PathParam("id") int id) {
    	 
    	 Country  ss=new CountryService().edit(user);
    	 return ss ;
		
	}
    
	
	
}
