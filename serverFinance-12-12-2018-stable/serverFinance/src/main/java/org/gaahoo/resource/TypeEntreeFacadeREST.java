/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.gaahoo.resource;

import java.util.List;


import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.gaahoo.service.TypeEntreeService;

import org.gahoo.entity.TypeEntree;



/**
 *
 * @author user
 */

@Path("com.seller.typeentree")
public class TypeEntreeFacadeREST  {
    
	@GET
	@Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public TypeEntree find(@PathParam("uuid") String uuid) {
    	 
    	 TypeEntree  ss=new TypeEntreeService().find(uuid);
    	 return ss;
		
	
    }
	
	@GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<TypeEntree> all() {
    	 List<TypeEntree>  ss= (List<TypeEntree>) new TypeEntreeService().all();
    	 return ss;
	
    }
	
	@GET
	@Path("{from}/{to}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<TypeEntree> allPaginate(@PathParam("from") int from,@PathParam("to") int to) {
    	 
    	 List<TypeEntree>  ss= (List<TypeEntree>) new TypeEntreeService().allPaginate(from, to);
    	 return ss;
		
	
    }
	
	@GET
    @Path("count")
	@Produces(MediaType.APPLICATION_JSON)
    public String count() {
        return String.valueOf(new TypeEntreeService().count());
    }
	
	@DELETE
	@Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String delete(@PathParam("id") int id) {
    	 
    	 int  ss=new TypeEntreeService().delete(id);
    	 return String.valueOf(ss) ;
		
	
    }
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public TypeEntree save(TypeEntree typeEntree) {
    	 
    	 TypeEntree  ss=new TypeEntreeService().save(typeEntree);
    	 return ss ;
		
	
    }
	
	@PUT
	@Path("{id}")
	@Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public TypeEntree edit(TypeEntree student,@PathParam("id") int id) {
    	 
    	 TypeEntree  ss=new TypeEntreeService().edit(student);
    	 return ss ;
		
	
    }
}
