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

@Path("depense")
public class DepenseFacadeREST {
	
	
@GET
@Path("/{uuid}")
@Produces(MediaType.APPLICATION_JSON)
public Depense find(@PathParam("uuid") String uuid) {
	 
	 Depense  ss=new DepenseService().find(uuid);
	 return ss;
	

}
/*
@GET
@Path("/associate/{id}/{user_id}")
@Produces(MediaType.APPLICATION_JSON)
public DepenseAssociate findAssociate(@PathParam("id") int id,@PathParam("user_id") int user_id) {
	List<PosteDepense> p=null;
	User u=null;
	DepenseAssociate oa=new DepenseAssociate();
	 Depense  ss=new DepenseService().find(id);
	 if(ss!=null){
		  p=(List<PosteDepense>)new PosteDepenseService().allPosteDepenseDepense(ss.getId());
		
	 }
	 if(p!=null){
		  u=new UserService().find(user_id);
		
		 
	 }
	 oa.setUser(u);
	 oa.setDepense(ss);
	 oa.setPoste(p);
	 return oa;
	

}*/

@PUT
@Path("/paid/archive")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public Depense archiverEntreePaid(Depense depense) {
	 
	Depense  ss=new DepenseService().archive(depense);
	//System.out.println(entree);
	 return ss ;
	

}

@GET
@Produces(MediaType.APPLICATION_JSON)
public List<Depense> all() {
	 List<Depense>  ss= (List<Depense>) new DepenseService().all();
	 return ss;

}

@GET
@Path("user/{user_uuid}")
@Produces(MediaType.APPLICATION_JSON)
public List<DepenseItem> allgroupByDate(@PathParam("user_uuid") String user_uuid,@QueryParam("libelle") String libelle
		,@QueryParam("date_debut") String debut,@QueryParam("date_fin") String fin,@QueryParam("archived") String archived) {
	 List<DepenseItem>  ss= (List<DepenseItem>) new DepenseService().allGroupByDate(user_uuid,"is_paid",libelle,debut,fin,archived);
	 return ss;

}

@GET
@Path("planified/user/{user_uuid}")
@Produces(MediaType.APPLICATION_JSON)
public List<DepenseItem> allPlanifiedGroupByDate(@PathParam("user_uuid") String user_uuid,@QueryParam("libelle") String libelle
		,@QueryParam("date_debut") String debut,@QueryParam("date_fin") String fin,@QueryParam("archived") String archived) {
	 List<DepenseItem>  ss= (List<DepenseItem>) new DepenseService().allGroupByDate(user_uuid,"is_planified",libelle,debut,fin,archived);
	 return ss;

}

@GET
@Path("late/user/{user_uuid}")
@Produces(MediaType.APPLICATION_JSON)
public List<DepenseItem> allLateGroupByDate(@PathParam("user_uuid") String user_uuid,@QueryParam("libelle") String libelle
		,@QueryParam("date_debut") String debut,@QueryParam("date_fin") String fin,@QueryParam("archived") String archived) {
	 List<DepenseItem>  ss= (List<DepenseItem>) new DepenseService().allGroupByDate(user_uuid,"is_late",libelle,debut,fin,archived);
	 return ss;

}

@GET
@Path("{from}/{to}")
@Produces(MediaType.APPLICATION_JSON)
public List<Depense> allPaginate(@PathParam("from") int from,@PathParam("to") int to) {
	 
	 List<Depense>  ss= (List<Depense>) new DepenseService().allPaginate(from, to);
	 return ss;
	

}

@GET
@Path("count")
@Produces(MediaType.APPLICATION_JSON)
public String count() {
    return String.valueOf(new DepenseService().count());
}

@DELETE
@Path("{id}")
@Produces(MediaType.APPLICATION_JSON)
public String delete(@PathParam("id") int id) {
	 
	 int  ss=new DepenseService().delete(id);
	 return String.valueOf(ss) ;
	

}


@POST
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public Depense save(Depense depense) {
	 
	Depense  ss=new DepenseService().save(depense);
	System.out.println(depense);
	 return ss ;
	

}

@PUT
@Path("/paid/edit")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public Depense save(List<Depense> depenses) {
	 
	Depense  ss=new DepenseService().editDepensePaid(depenses);
	//System.out.println(depense);
	 return ss ;
	

}
@PUT
@Path("/planning/edit")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public Depense editDepensePlanified(List<Depense> depenses) {
	 
	Depense  ss=new DepenseService().editDepensePlanified(depenses);
	//System.out.println(depense);
	 return ss ;
	

}

@PUT
@Path("/planning/reporter")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public Depense reporterDepensePlanified(Depense depense) {
	 
	Depense  ss=new DepenseService().reporter(depense);
	//System.out.println(depense);
	 return ss ;
	

}


@POST
@Path("/planning/confirm")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public Depense saveDepensePlanning(Depense depense) {
	 
	Depense  ss=new DepenseService().saveDepensePlanning(depense);
	System.out.println(depense);
	 return ss ;
	

}


/*
@POST
@Path("/login")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public Depense login(Depense user) {
	 
	Depense  ss=new DepenseService().login(user);
	 return ss ;
	

}*/

@PUT
@Path("/user")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public Depense edit(Depense depense) {
	 
	 Depense  ss=new DepenseService().edit(depense);
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
	 
	 List<TypeEntree>  ss= (List<TypeEntree>) new DepenseService().allPaginateTypeEntree(id, from, number);
	return ss ;
	

}*/
    
}
