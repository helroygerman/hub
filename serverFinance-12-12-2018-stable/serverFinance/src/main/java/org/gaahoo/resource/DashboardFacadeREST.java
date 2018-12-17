package org.gaahoo.resource;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.gaahoo.response.Statistique;
import org.gaahoo.service.DashboardService;
import org.gaahoo.service.DepenseService;
import org.gahoo.entity.Depense;

@Path("/dashboard")
public class DashboardFacadeREST {

	@GET
	@Path("/detail/{user_uuid}")
	@Produces(MediaType.APPLICATION_JSON)
	public Statistique find(@PathParam("user_uuid") String userUuid,@QueryParam("type") String type) {
		 
		Statistique ss=new DashboardService().overview(userUuid,type);
		 return ss;
		

	}
	
	@GET
	@Path("/stat/daily/{user_uuid}")
	@Produces(MediaType.APPLICATION_JSON)
	public Statistique dailyStat(@PathParam("user_uuid") String userUuid,@QueryParam("type") String type,
			@QueryParam("month")  String month,@QueryParam("year") String year,@QueryParam("compte") String compte) {
		 
		Statistique ss=new DashboardService().dailyStat(userUuid,type,compte,month,year);
		 return ss;
		

	}
	
	@GET
	@Path("/stat/monthly/category/{user_uuid}")
	@Produces(MediaType.APPLICATION_JSON)
	public Statistique dailyStatPie(@PathParam("user_uuid") String userUuid,@QueryParam("type") String type,
			@QueryParam("month")  String month,@QueryParam("year") String year,@QueryParam("compte") String compte) {
		 
		Statistique ss=new DashboardService().dailyGategoryStat(userUuid,type,compte,month,year);
		 return ss;
		

	}
	
}
