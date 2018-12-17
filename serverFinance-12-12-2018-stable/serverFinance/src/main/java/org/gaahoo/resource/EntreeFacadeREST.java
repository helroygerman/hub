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
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.gaahoo.response.DepenseItem;
import org.gaahoo.response.EntreeItem;
import org.gaahoo.service.DepenseService;
import org.gaahoo.service.EntreeService;
import org.gaahoo.service.PosteDepenseService;
import org.gaahoo.service.TypeEntreeService;
import org.gaahoo.service.UserService;
import org.gahoo.entity.Depense;
import org.gahoo.entity.Entree;
import org.gahoo.entity.Depense;
import org.gahoo.entity.PosteDepense;
import org.gahoo.entity.TypeEntree;
import org.gahoo.entity.User;

/**
 *
 * @author user
 */

@Path("entree")
public class EntreeFacadeREST {
	
	
@GET
@Path("/{uuid}")
@Produces(MediaType.APPLICATION_JSON)
public Entree find(@PathParam("uuid") String uuid) {
	 
	 Entree  ss=new EntreeService().find(uuid);
	 return ss;
	

}
/*
@GET
@Path("/associate/{id}/{user_id}")
@Produces(MediaType.APPLICATION_JSON)
public EntreeAssociate findAssociate(@PathParam("id") int id,@PathParam("user_id") int user_id) {
	List<PosteEntree> p=null;
	User u=null;
	EntreeAssociate oa=new EntreeAssociate();
	 Entree  ss=new EntreeService().find(id);
	 if(ss!=null){
		  p=(List<PosteEntree>)new PosteEntreeService().allPosteEntreeEntree(ss.getId());
		
	 }
	 if(p!=null){
		  u=new UserService().find(user_id);
		
		 
	 }
	 oa.setUser(u);
	 oa.setEntree(ss);
	 oa.setPoste(p);
	 return oa;
	

}*/

@GET
@Produces(MediaType.APPLICATION_JSON)
public List<Entree> all() {
	 List<Entree>  ss= (List<Entree>) new EntreeService().all();
	 return ss;

}

@GET
@Path("user/{user_uuid}")
@Produces(MediaType.APPLICATION_JSON)
public List<EntreeItem> allgroupByDate(@PathParam("user_uuid") String user_uuid,@QueryParam("libelle") String libelle
		,@QueryParam("date_debut") String debut,@QueryParam("date_fin") String fin,@QueryParam("archived") String archived) {
	 List<EntreeItem>  ss= (List<EntreeItem>) new EntreeService().allGroupByDate(user_uuid,"is_paid",libelle,debut,fin,archived);
	 return ss;

}

@GET
@Path("planified/user/{user_uuid}")
@Produces(MediaType.APPLICATION_JSON)
public List<EntreeItem> allPlanifiedGroupByDate(@PathParam("user_uuid") String user_uuid,@QueryParam("libelle") String libelle
		,@QueryParam("date_debut") String debut,@QueryParam("date_fin") String fin,@QueryParam("archived") String archived) {
	 List<EntreeItem>  ss= (List<EntreeItem>) new EntreeService().allGroupByDate(user_uuid,"is_planified",libelle,debut,fin,archived);
	 return ss;

}

@GET
@Path("late/user/{user_uuid}")
@Produces(MediaType.APPLICATION_JSON)
public List<EntreeItem> allLateGroupByDate(@PathParam("user_uuid") String user_uuid,@QueryParam("libelle") String libelle
		,@QueryParam("date_debut") String debut,@QueryParam("date_fin") String fin,@QueryParam("archived") String archived) {
	 List<EntreeItem>  ss= (List<EntreeItem>) new EntreeService().allGroupByDate(user_uuid,"is_late",libelle,debut,fin,archived);
	 return ss;

}

@GET
@Path("{from}/{to}")
@Produces(MediaType.APPLICATION_JSON)
public List<Entree> allPaginate(@PathParam("from") int from,@PathParam("to") int to) {
	 
	 List<Entree>  ss= (List<Entree>) new EntreeService().allPaginate(from, to);
	 return ss;
	

}

@GET
@Path("count")
@Produces(MediaType.APPLICATION_JSON)
public String count() {
    return String.valueOf(new EntreeService().count());
}

@DELETE
@Path("{id}")
@Produces(MediaType.APPLICATION_JSON)
public String delete(@PathParam("id") int id) {
	 
	 int  ss=new EntreeService().delete(id);
	 return String.valueOf(ss) ;
	

}


@POST
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public Entree save(Entree entree) {
	 
	Entree  ss=new EntreeService().save(entree);
	System.out.println(entree);
	 return ss ;
	

}

@PUT
@Path("/paid/edit")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public Entree save(List<Entree> entrees) {
	 
	Entree  ss=new EntreeService().editEntreePaid(entrees);
	//System.out.println(entree);
	 return ss ;
	

}
@PUT
@Path("/planning/edit")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public Entree editEntreePlanified(List<Entree> entrees) {
	 
	Entree  ss=new EntreeService().editEntreePlanified(entrees);
	//System.out.println(entree);
	 return ss ;
	

}

@PUT
@Path("/planning/reporter")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public Entree reporterEntreePlanified(Entree entree) {
	 
	Entree  ss=new EntreeService().reporter(entree);
	//System.out.println(entree);
	 return ss ;
	

}

@PUT
@Path("/paid/archive")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public Entree archiverEntreePaid(Entree entree) {
	 
	Entree  ss=new EntreeService().archive(entree);
	//System.out.println(entree);
	 return ss ;
	

}


@POST
@Path("/planning/confirm")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public Entree saveEntreePlanning(Entree entree) {
	 
	Entree  ss=new EntreeService().saveEntreePlanning(entree);
	System.out.println(entree);
	 return ss ;
	

}


/*
@POST
@Path("/login")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public Entree login(Entree user) {
	 
	Entree  ss=new EntreeService().login(user);
	 return ss ;
	

}*/

@PUT
@Path("/user")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public Entree edit(Entree entree) {
	 
	 Entree  ss=new EntreeService().edit(entree);
	 return ss ;
	
}
/*
@GET
@Path("/{id}/typeentree")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public List<TypeEntree> allTypeEntree(@PathParam("id") int id) {
	 
	 List<TypeEntree>  ss= (List<TypeEntree>) new TypeEntreeService().allTypeEntree(id);
	 return ss ;
	

}*/
/*
@GET
@Path("/{id}/typeentree/{from}/{number}")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public List<TypeEntree> allPaginateTypeEntree(@PathParam("id") int id,@PathParam("from") int from,@PathParam("number") int number) {
	 
	 List<TypeEntree>  ss= (List<TypeEntree>) new EntreeService().allPaginateTypeEntree(id, from, number);
	return ss ;
	

}*/
    
}
