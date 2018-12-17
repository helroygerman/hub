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

import org.gaahoo.service.FrequenceService;
import org.gaahoo.service.PosteDepenseService;
import org.gahoo.entity.Frequence;
import org.gahoo.entity.PosteDepense;

@Path("frequence")
public class FrequenceFacadeREST {
	@GET
	@Path("{uuid}")
    @Produces(MediaType.APPLICATION_JSON)
    public Frequence find(@PathParam("uuid") String uuid) {
    	 
    	 Frequence  ss=new FrequenceService().find(uuid);
    	 return ss;
		
	
    }
	
	@GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Frequence> all() {
    	 List<Frequence>  ss= (List<Frequence>) new FrequenceService().all();
    	 return ss;
	
    }
	
	@GET
	@Path("{from}/{to}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Frequence> allPaginate(@PathParam("from") int from,@PathParam("to") int to) {
    	 
    	 List<Frequence>  ss= (List<Frequence>) new FrequenceService().allPaginate(from, to);
    	 return ss;
		
	
    }
	
	@GET
    @Path("count")
	@Produces(MediaType.APPLICATION_JSON)
    public String count() {
        return String.valueOf(new FrequenceService().count());
    }
	
	@DELETE
	@Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String delete(@PathParam("id") int id) {
    	 
    	 int  ss=new FrequenceService().delete(id);
    	 return String.valueOf(ss) ;
		
	
    }
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Frequence save(Frequence user) {
    	 
    	Frequence  ss=new FrequenceService().save(user);
    	 return ss ;
		
	
    }
	
	
	
	@PUT
	@Path("{id}")
	@Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Frequence edit(Frequence user,@PathParam("id") int id) {
    	 
    	 Frequence  ss=new FrequenceService().edit(user);
    	 return ss ;
		
	}
	
	@GET
	@Path("user/{user_uuid}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Frequence> allFrequenceUser(@PathParam("user_uuid") String user_uuid) {
		
    	 int default_user_id=0;
    	 List<Frequence>  ss= (List<Frequence>) new FrequenceService().allFrequenceUser(user_uuid);
    	 
    	 System.out.println(ss.size());
    	 return ss;
		
	
    }
    
}
