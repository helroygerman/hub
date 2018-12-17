package org.gaahoo.finance.serverFinance;

import java.util.List;

import javax.persistence.EntityManager;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.persistence.internal.libraries.asm.tree.analysis.Value;
import org.gaahoo.resource.AbstractFacade;
import org.gaahoo.resource.DataBase;
import org.gaahoo.service.StudentService;
import org.gahoo.entity.Depense;
import org.gahoo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("myresource")
public class MyResource {

    

	/**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
    
	@GET
	@Path("{uuid}")
    @Produces(MediaType.APPLICATION_JSON)
    public Student find(@PathParam("uuid") String uuid) {
    	 
    	 Student  ss=new StudentService().find(uuid);
    	 return ss;
		
	
    }
	
	@GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Student> all() {
    	 List<Student>  ss= (List<Student>) new StudentService().all();
    	 return ss;
	
    }
	
	@GET
	@Path("{from}/{to}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Student> allPaginate(@PathParam("from") int from,@PathParam("to") int to) {
    	 
    	 List<Student>  ss= (List<Student>) new StudentService().allPaginate(from, to);
    	 return ss;
		
	
    }
	
	@GET
    @Path("count")
	@Produces(MediaType.APPLICATION_JSON)
    public String count() {
        return String.valueOf(new StudentService().count());
    }
	
	@DELETE
	@Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String delete(@PathParam("id") int id) {
    	 
    	 int  ss=new StudentService().delete(id);
    	 return String.valueOf(ss) ;
		
	
    }
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Student save(Student student) {
    	 
    	 Student  ss=new StudentService().save(student);
    	 return ss ;
		
	
    }
	
	@PUT
	@Path("{id}")
	@Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Student edit(Student student,@PathParam("id") int id) {
    	 
    	 Student  ss=new StudentService().edit(student);
    	 return ss ;
		
	
    }

	
}
