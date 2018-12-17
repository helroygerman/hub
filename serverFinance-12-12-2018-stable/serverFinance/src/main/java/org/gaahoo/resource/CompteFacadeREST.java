/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.gaahoo.resource;

import java.util.ArrayList;
import java.util.Date;
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

import org.gaahoo.service.CompteService;
import org.gaahoo.service.UserService;
import org.gahoo.entity.Compte;
import org.gahoo.entity.User;

/**
 *
 * @author user
 */

@Path("/compte")
public class CompteFacadeREST {
    

   

   /* @POST
    @Override
    @Consumes({"application/xml", "application/json"})
    public void create(Compte entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({"application/xml", "application/json"})                                      
    public void edit(@PathParam("id") Integer id, Compte entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("{id}")
    @Produces({"application/xml", "application/json"})
    public Compte find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({"application/xml", "application/json"})
    public List<Compte> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({"application/xml", "application/json"})
    public List<Compte> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }
    */
    @GET
    @Path("/user/{uuid}")
    @Produces( "application/json")
    public List<Compte> allCompteUser( @PathParam("uuid") String uuiid) {
    	List<Compte>  ss= (List<Compte>) new CompteService().user(uuiid);
   	 return ss;
       
    }
    
    @POST
	@Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Compte save(Compte compte) {
    	 System.out.println(compte.toString());
    	Compte  ss=new CompteService().save(compte);
    	 return ss ;
		
	
    }
    
    @POST
    @Path("/tranfert/user/{user_uuid}/{montant}/{date}/")
	@Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Compte tranfert(List<Compte> comptes,@PathParam("user_uuid") String userUuid,@PathParam("montant") float montant,@PathParam("date") String date) {
    	
    	//index 0 represente le compte qui initie le transfert
    	//index 1 represnete le compte qui recoit le transfert.
    	 System.out.println("rrr");
    	
    	Compte  ss=new CompteService().transfert(comptes,userUuid,montant,date);
    	 return ss ;
		
	
    }
    
    
    @POST
    @Path("/operation/user/{user_uuid}/{montant}/{date}/{type}")
	@Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Compte retrait(Compte compte,@PathParam("user_uuid") String userUuid,@PathParam("montant") float montant,@PathParam("date") String date,@PathParam("type") String type) {
    	
    	
    	Compte  ss=new CompteService().operation(compte,userUuid,montant,date,type);
    	 return ss ;
		
	
    }
    
    @POST
    @Path("/sync/")
	@Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public List<Compte> saveAllToOnline(List<Compte> comptes) {
    	 System.out.println(comptes.toString());
    	List<Compte>  ss=(List<Compte>)new CompteService().saveAllToOnline(comptes);
    	 return ss ;
		
	
    }
    
    @PUT
	@Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Compte update(Compte compte) {
    	 System.out.println(compte.toString());
    	Compte  ss=new CompteService().edit(compte);
    	 return ss ;
		
	
    }
/*
    @GET
    @Path("count")
    @Produces("text/plain")
    public String countREST() {
        return String.valueOf(super.count());
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }*/
    
}
