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

import org.gaahoo.entity.associate.OperationAssociate;
import org.gaahoo.service.OperationService;
import org.gaahoo.service.PosteDepenseService;
import org.gaahoo.service.UserService;
import org.gahoo.entity.Operation;
import org.gahoo.entity.PosteDepense;
import org.gahoo.entity.TypeEntree;
import org.gahoo.entity.User;




/**
 *
 * @author user
 */

@Path("operation")
public class OperationFacadeREST{
	
@GET
@Path("/{uuid}")
@Produces(MediaType.APPLICATION_JSON)
public Operation find(@PathParam("uuid") String uuid) {
	 
	 Operation  ss=new OperationService().find(uuid);
	 return ss;
	

}


@GET
@Produces(MediaType.APPLICATION_JSON)
public List<Operation> all() {
	 List<Operation>  ss= (List<Operation>) new OperationService().all();
	 return ss;

}

@GET
@Path("{from}/{to}")
@Produces(MediaType.APPLICATION_JSON)
public List<Operation> allPaginate(@PathParam("from") int from,@PathParam("to") int to) {
	 
	 List<Operation>  ss= (List<Operation>) new OperationService().allPaginate(from, to);
	 return ss;
	

}

@GET
@Path("count")
@Produces(MediaType.APPLICATION_JSON)
public String count() {
    return String.valueOf(new OperationService().count());
}

@DELETE
@Path("{id}")
@Produces(MediaType.APPLICATION_JSON)
public String delete(@PathParam("id") int id) {
	 
	 int  ss=new OperationService().delete(id);
	 return String.valueOf(ss) ;
	

}


@POST
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public Operation save(Operation user) {
	 
	Operation  ss=new OperationService().save(user);
	 return ss ;
	

}



@POST
@Path("/login")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public Operation login(Operation user) {
	 
	Operation  ss=new OperationService().login(user);
	 return ss ;
	

}

@PUT
@Path("{id}")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public Operation edit(Operation user,@PathParam("id") int id) {
	 
	 Operation  ss=new OperationService().edit(user);
	 return ss ;
	
}

@GET
@Path("/{id}/typeentree")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public List<TypeEntree> allTypeEntree(@PathParam("id") int id) {
	 
	 List<TypeEntree>  ss= (List<TypeEntree>) new OperationService().allTypeEntree(id);
	 return ss ;
	

}
@GET
@Path("/{id}/typeentree/{from}/{number}")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public List<TypeEntree> allPaginateTypeEntree(@PathParam("id") int id,@PathParam("from") int from,@PathParam("number") int number) {
	 
	 List<TypeEntree>  ss= (List<TypeEntree>) new OperationService().allPaginateTypeEntree(id, from, number);
	return ss ;
	

}
}