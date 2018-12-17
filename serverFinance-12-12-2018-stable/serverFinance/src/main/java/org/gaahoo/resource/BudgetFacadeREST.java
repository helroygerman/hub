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

import org.gaahoo.response.BudgetItem;
import org.gaahoo.response.DepenseItem;
import org.gaahoo.service.BudgetService;
import org.gaahoo.service.DepenseService;
import org.gahoo.entity.Budget;


/**
 *
 * @author user
 */

@Path("budget")
public class BudgetFacadeREST {
	@GET
	@Path("{uuid}")
    @Produces(MediaType.APPLICATION_JSON)
    public Budget find(@PathParam("uuid") String uuid) {
    	 
    	 Budget  ss=new BudgetService().find(uuid);
    	 return ss;
		
	
    }
	
	@GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Budget> all() {
    	 List<Budget>  ss= (List<Budget>) new BudgetService().all();
    	 return ss;
	
    }
	
	@GET
	@Path("{from}/{to}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Budget> allPaginate(@PathParam("from") int from,@PathParam("to") int to) {
    	 
    	 List<Budget>  ss= (List<Budget>) new BudgetService().allPaginate(from, to);
    	 return ss;
		
	
    }
	
	@GET
	@Path("user/test/{user_uuid}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<DepenseItem> allLateGroupByDate(@PathParam("user_uuid") String user_uuid) {
		 //List<DepenseItem>  ss= (List<DepenseItem>) new DepenseService().allGroupByDate(user_uuid,"is_late","");
		 return null;

	}
	
	@GET
    @Path("count")
	@Produces(MediaType.APPLICATION_JSON)
    public String count() {
        return String.valueOf(new BudgetService().count());
    }
	
	@DELETE
	@Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String delete(@PathParam("id") int id) {
    	 
    	 int  ss=new BudgetService().delete(id);
    	 return String.valueOf(ss) ;
		
	
    }
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Budget save(Budget user) {
    	 
    	Budget  ss=new BudgetService().save(user);
    	System.out.println(user);
    	 return ss ;
		
	
    }
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Budget update(Budget budget) {
    	 
    	Budget  ss=new BudgetService().edit(budget);
    	System.out.println(budget);
    	 return ss ;
		
	
    }
	
	
	
	@PUT
	@Path("{id}")
	@Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Budget edit(Budget user,@PathParam("id") int id) {
    	 
    	 Budget  ss=new BudgetService().edit(user);
    	 return ss ;
		
	}
	
	@GET
	@Path("item/user/{user_uuid}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<BudgetItem> allBudgetItemUser(@PathParam("user_uuid") String user_uuid) {
		
		List<BudgetItem>  ss= (List<BudgetItem>) new BudgetService().allGroupByDate(user_uuid,-1,"","");
		 
    	 System.out.println(ss.size());
    	 return ss;
		
	
    }
	@GET
	@Path("user/{user_uuid}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Budget> allBudgetUser(@PathParam("user_uuid") String user_uuid) {
		
		List<Budget>  ss= (List<Budget>) new BudgetService().allBudgetUser(user_uuid);
		 
    	 System.out.println(ss.size());
    	 return ss;
		
	
    }
	
	@PUT
	@Path("/user/delete")
    @Produces(MediaType.APPLICATION_JSON)
    public Budget deleteBudgetUser(Budget budget) {
		
		Budget  ss= (Budget) new BudgetService().delete(budget);
		 
    	
    	 return ss;
		
	
    }
	@GET
	@Path("item/user/{user_uuid}/year/{year}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<BudgetItem> allYearBudgetUser(@PathParam("user_uuid") String user_uuid,@PathParam("year") int year) {
		
		List<BudgetItem>  ss= (List<BudgetItem>) new BudgetService().allGroupByDate(user_uuid,year,"","");
		 
    	 System.out.println(ss.size());
    	 return ss;
		
	
    }
	@GET
	@Path("item/user/{user_uuid}/month/{month}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<BudgetItem> allMonthBudgetUser(@PathParam("user_uuid") String user_uuid,@PathParam("month") String month) {
		int year=0;
		List<BudgetItem>  ss= (List<BudgetItem>) new BudgetService().allGroupByDate(user_uuid,year,month,"");
		 
    	 System.out.println(ss.size());
    	 return ss;
		
	
    }
	
	@GET
	@Path("item/user/{user_uuid}/libelle/{libelle}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<BudgetItem> allSearchUser(@PathParam("user_uuid") String user_uuid,@PathParam("libelle") String libelle) {
		int year=0;
		List<BudgetItem>  ss= (List<BudgetItem>) new BudgetService().allGroupByDate(user_uuid,year,"",libelle);
		 
    	 System.out.println(ss.size());
    	 return ss;
		
	
    }
    


@GET
@Path("/{budget_uuid}/user/{user_uuid}")
@Produces(MediaType.APPLICATION_JSON)
public Budget findBudgetUser(@PathParam("user_uuid") String user_uuid,@PathParam("budget_uuid") String budget_uuid) {
	
	@SuppressWarnings("unchecked")
	Budget  ss=  new BudgetService().findBudgetUser(budget_uuid, user_uuid);
	 
	 return ss;
	

}

}

