package org.gaahoo.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.TimeZone;

import org.apache.commons.lang3.time.DateUtils;
import org.eclipse.persistence.jaxb.javamodel.JavaAnnotation;
import org.gaahoo.helper.DateHelper;
import org.gaahoo.response.DepenseItem;
import org.gaahoo.response.Statistique;
import org.gahoo.entity.Budget;
import org.gahoo.entity.Compte;
import org.gahoo.entity.Depense;
import org.gahoo.entity.Entree;
import org.hibernate.query.Query;

public class DashboardService extends ServiceParent<String>{

	
	public String table="student";
	public DashboardService() {
		super(String.class);
		TimeZone.setDefault( TimeZone.getTimeZone( "UTC" ) );
		
		// TODO Auto-generated constructor stub
	}
	
	
	public Statistique dailyStat(String user_uuid,String type,String compte,String month,String year){
		
		
		float totalDepense = 0;
		int i = 0;
		int nombre = 0;
		Date now = DateHelper.getDateFormat(new Date());
		int ecart = 0;
		List<Depense> depenseGroupe = new ArrayList<>();
		List<DepenseItem> depenseItems = new ArrayList<>();
		
		Query q = null;
		Query q1 = null;
		Query q2 = null;
		Query q3 = null;
		List<Object[]> result5=null;
		List<Object[]> entrees=null;
		List<Object[]> comptes=null;
		List<Object[]> budgets=null;
		
		String searchdebut=" AND 1=1";
		String searchfin=" AND 1=1";
		String searchcompte=" AND 1=1";
		List<Depense>dep=null;
		List<Entree>Ent=null;
		List<Depense> vale=new ArrayList<>();
		List<Entree> entreeStat=new ArrayList<>();
		List<Compte> compteStat=new ArrayList<>();
		
		Statistique Stat=new Statistique();
		System.out.println("*********************************"+type);

		try {
			this.s.beginTransaction();
			// st= this.s.createQuery("from Depense ORDER BY date DESC " ).getResultList();
			Date date=new Date();
			int[] monthyear=DateHelper.getDayMonthYear(date);
			//String first=DateHelper.firstDayOfMonth(monthyear[1], monthyear[2]);
			//String last=DateHelper.lastDayOfMonth(monthyear[1], monthyear[2]);
			String first=DateHelper.toDate(DateHelper.beginWeek());
			String last=DateHelper.toDate(DateHelper.endWeek());
			first=DateHelper.firstDayOfMonth();
			last=DateHelper.lastDayOfMonth();
			if(exist(month) && exist(year) ) {
				first=DateHelper.firstDayOfMonth(Integer.valueOf(month),Integer.valueOf(year));
				last=DateHelper.lastDayOfMonth(Integer.valueOf(month),Integer.valueOf(year));
			}
			
			System.out.println("*********************************"+first);
			
			if(exist(first))searchdebut=" AND date >= '"+first+"' ";
			if(exist(last))searchfin=" AND date <='"+last+"' ";
			
			if(exist(compte))searchcompte=" AND compte_uuid = '"+compte+"' ";
			
			if(type.contains("depense") || type.contains("tout")) {
				q =  this.s
						.createQuery("SELECT SUM(montant),date,COUNT(date) from Depense WHERE (is_planified=0 AND is_paid=1 AND is_deleted=0  AND user_uuid='"
								+ user_uuid +"' "+searchdebut+searchfin+searchcompte+")  GROUP BY date ORDER BY date ASC  ");
			//dep = q.getResultList();
			 result5 = q.getResultList();
			 for (Object p : result5) {
					Depense depense= new Depense();
					depense=printResultDepense(p);
				      Stat.getDepenses().add(depense);
				      Stat.addTotalDepense(depense.getMontant());
				    }
			 
			}if(type.contains("entree") || type.contains("tout")) {
				q1 =  this.s.createQuery("SELECT SUM(montant),date,COUNT(date) from Entree WHERE (is_planified=0 AND is_deleted=0 AND is_paid=1  AND user_uuid='"
						+ user_uuid +"'  "+searchdebut+searchfin+searchcompte+") GROUP BY date ORDER BY date ASC ");
				entrees = q1.getResultList();
				if(exists(entrees)) {
					for (Object p : entrees) {
						Entree entree=new Entree();
						entree=printResultEntree(p);
					      Stat.getEntrees().add(entree);
					      Stat.addTotalEntree(entree.getMontant());
					    }
				}
			}
				
			
		
			
			this.s.getTransaction().commit();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		} finally {
			this.f.close();
		}
		
		
		
		return Stat;
	}
	
	
	
	
	
	
	
	
	
	
	
	
public Statistique dailyGategoryStat(String user_uuid,String type,String compte,String month,String year){
		
		
		float totalDepense = 0;
		int i = 0;
		int nombre = 0;
		Date now = DateHelper.getDateFormat(new Date());
		int ecart = 0;
		List<Depense> depenseGroupe = new ArrayList<>();
		List<DepenseItem> depenseItems = new ArrayList<>();
		
		Query q = null;
		Query q1 = null;
		Query q2 = null;
		Query q3 = null;
		List<Object[]> result5=null;
		List<Object[]> entrees=null;
		List<Object[]> comptes=null;
		List<Object[]> budgets=null;
		
		String searchdebut=" AND 1=1";
		String searchfin=" AND 1=1";
		String searchcompte=" AND 1=1";
		List<Depense>dep=null;
		List<Entree>Ent=null;
		List<Depense> vale=new ArrayList<>();
		List<Entree> entreeStat=new ArrayList<>();
		List<Compte> compteStat=new ArrayList<>();
		
		Statistique Stat=new Statistique();
		System.out.println("*********************************"+type);

		try {
			this.s.beginTransaction();
			// st= this.s.createQuery("from Depense ORDER BY date DESC " ).getResultList();
			Date date=new Date();
			int[] monthyear=DateHelper.getDayMonthYear(date);
			//String first=DateHelper.firstDayOfMonth(monthyear[1], monthyear[2]);
			//String last=DateHelper.lastDayOfMonth(monthyear[1], monthyear[2]);
			String first=DateHelper.toDate(DateHelper.beginWeek());
			String last=DateHelper.toDate(DateHelper.endWeek());
			first=DateHelper.firstDayOfMonth();
			last=DateHelper.lastDayOfMonth();
			if(exist(month) && exist(year) ) {
				first=DateHelper.firstDayOfMonth(Integer.valueOf(month),Integer.valueOf(year));
				last=DateHelper.lastDayOfMonth(Integer.valueOf(month),Integer.valueOf(year));
			}
			
			System.out.println("*********************************"+first);
			
			if(exist(first))searchdebut=" AND d.date >= '"+first+"' ";
			if(exist(last))searchfin=" AND d.date <='"+last+"' ";
			
			if(exist(compte))searchcompte=" AND d.compteUuid = '"+compte+"' ";
			
			if(type.contains("depense") || type.contains("tout")) {
				q =  this.s
						.createQuery("SELECT SUM(d.montant),d.date,COUNT(d.posteUuid),p.libelle from Depense d left join d.poste p  WHERE (is_planified=0 AND is_paid=1 AND d.isDeleted=0  AND d.userUuid='"
								+ user_uuid +"' "+searchdebut+searchfin+searchcompte+")  GROUP BY d.posteUuid ORDER BY d.date ASC  ");
			//dep = q.getResultList();
			 result5 = q.getResultList();
			 List l = q.list();
			 Iterator it=l.iterator();
		        while(it.hasNext())
		        {	System.out.println("cool******************");
		            Object rows[] = (Object[])it.next();
		            System.out.println(rows[0]+ " -- " +rows[1]+"****"+rows[2]+"****"+rows[3]);
		            Depense depense= new Depense();
		            depense.setMontant((Double)rows[0]);
		            depense.setLibelle((String)rows[3]);
		            depense.setNombre((Long)rows[2]);
		            depense.setDate((Date)rows[1]);
		            Stat.getDepenses().add(depense);
				      Stat.addTotalDepense(depense.getMontant());
		        }
			 for (Object p : result5) {
					Depense depense= new Depense();
					depense=printResultDepense(p);
				      //Stat.getDepenses().add(depense);
				      //Stat.addTotalDepense(depense.getMontant());
				    }
			 
			}if(type.contains("entree") || type.contains("tout")) {
				q1 =  this.s.createQuery("SELECT SUM(montant),date,COUNT(poste_uuid) from Entree WHERE (is_planified=0 AND is_deleted=0 AND is_paid=1  AND user_uuid='"
						+ user_uuid +"'  "+searchdebut+searchfin+searchcompte+") GROUP BY poste_uuid ORDER BY date ASC ");
				entrees = q1.getResultList();
				if(exists(entrees)) {
					for (Object p : entrees) {
						Entree entree=new Entree();
						entree=printResultEntree(p);
					      Stat.getEntrees().add(entree);
					      Stat.addTotalEntree(entree.getMontant());
					    }
				}
			}
				
			
		
			
			this.s.getTransaction().commit();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		} finally {
			this.f.close();
		}
		
		
		
		return Stat;
	}
	
	
	
	
	
	
	
	
	 
	public Statistique overview(String user_uuid,String type){
		
		
		float totalDepense = 0;
		int i = 0;
		int nombre = 0;
		Date now = DateHelper.getDateFormat(new Date());
		int ecart = 0;
		List<Depense> depenseGroupe = new ArrayList<>();
		List<DepenseItem> depenseItems = new ArrayList<>();
		
		Query q = null;
		Query q1 = null;
		Query q2 = null;
		Query q3 = null;
		List<Object[]> result5=null;
		List<Object[]> entrees=null;
		List<Object[]> comptes=null;
		List<Object[]> budgets=null;
		
		String searchdebut=" AND 1=1";
		String searchfin=" AND 1=1";
		List<Depense>dep=null;
		List<Entree>Ent=null;
		List<Depense> vale=new ArrayList<>();
		List<Entree> entreeStat=new ArrayList<>();
		List<Compte> compteStat=new ArrayList<>();
		
		Statistique Stat=new Statistique();
		System.out.println("*********************************"+type);

		try {
			this.s.beginTransaction();
			// st= this.s.createQuery("from Depense ORDER BY date DESC " ).getResultList();
			Date date=new Date();
			int[] monthyear=DateHelper.getDayMonthYear(date);
			//String first=DateHelper.firstDayOfMonth(monthyear[1], monthyear[2]);
			//String last=DateHelper.lastDayOfMonth(monthyear[1], monthyear[2]);
			String first=DateHelper.toDate(DateHelper.beginWeek());
			String last=DateHelper.toDate(DateHelper.endWeek());
			if(type.contains("mois")) {
				first=DateHelper.firstDayOfPastMonth();
				last=DateHelper.lastDayOfPastMonth();
			}else {
				
			}
			System.out.println("*********************************"+first);
			
			if(exist(first))searchdebut=" AND date >= '"+first+"' ";
			if(exist(last))searchfin=" AND date <='"+last+"' ";
			
				q =  this.s
						.createQuery("SELECT SUM(montant),date from Depense WHERE (is_planified=0 AND is_paid=1 AND is_deleted=0  AND user_uuid='"
								+ user_uuid +"' "+searchdebut+searchfin+")  GROUP BY DAYNAME(date) ORDER BY date ASC  ");
			//dep = q.getResultList();
			 result5 = q.getResultList();
			
			q1 =  this.s.createQuery("SELECT SUM(montant),date from Entree WHERE (is_planified=0 AND is_deleted=0 AND is_paid=1  AND user_uuid='"
							+ user_uuid +"'  "+searchdebut+searchfin+") GROUP BY DAYNAME(date) ORDER BY date ASC ");
		entrees = q1.getResultList();
		
		q2 =  this.s.createQuery("SELECT SUM(solde) from Compte WHERE (is_deleted=0   AND user_uuid='"
				+ user_uuid +"') ");
		comptes = q2.getResultList();
		
		q3 =  this.s.createQuery("SELECT SUM(montant),date from Depense WHERE (is_planified=0 AND budget_uuid IS NOT NULL  AND is_deleted=0 AND is_paid=1  AND user_uuid='"
				+ user_uuid +"'  "+searchdebut+searchfin+") GROUP BY date ORDER BY date ASC ");
		budgets = q3.getResultList();
			
			this.s.getTransaction().commit();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		} finally {
			this.f.close();
		}
		
		if(exists(entrees)) {
			for (Object p : entrees) {
				Entree entree=new Entree();
				entree=printResultEntree(p);
			      Stat.getEntrees().add(entree);
			      Stat.addTotalEntree(entree.getMontant());
			    }
		}
		
		for (Object p : result5) {
			Depense depense= new Depense();
			depense=printResultDepense(p);
		      Stat.getDepenses().add(depense);
		      Stat.addTotalDepense(depense.getMontant());
		    }
		
		for (Object p : comptes) {
		      Stat.getComptes().add(printResultCompte(p));
		    }
		
		for (Object p : budgets) {
			Budget budget=new Budget();
			budget=printResultBudget(p);
		      Stat.getBudgets().add(budget);
			Stat.addTotalBudget(budget.getDebit());
		    }
		//List<Float> add=new ArrayList<>();
		//Float[] test =initList();
		//add=initList();
		
		for( Depense d: Stat.getDepenses()) {
			int index=index(d.getDate());
			System.out.println("mon index"+index);
			//Float total=add.get(index)+d.getMontant();
			//test[i]=total;
			
		}
		
		

				
		
		
		//System.out.println(test);
		System.out.println(budgets);
		
		//result5.toArray()[0].
		
		return Stat;
	}
	
	public boolean exist(String s) {
		boolean val=false;
		if(s!=null) {
			if(!s.isEmpty()) {
				val=true;
			}
		}
		return val;
	}
	
	
	
	public boolean exist(Statistique s) {
		boolean val=false;
		if(s!=null) {
			
				val=true;
			
		}
		return val;
	}
	
	public boolean exist(List<Depense> s) {
		boolean val=false;
		if(s!=null) {
			if(!s.isEmpty()) {
				val=true;
			}
		}
		return val;
	}
	public boolean exists(List<Object[]> s) {
		boolean val=false;
		if(s!=null) {
			if(!s.isEmpty()) {
				val=true;
			}
		}
		return val;
	}
	
	public int index(Date date) {
		int i = 0;
		if(DateHelper.getDay(date).contains("Dimanche")) i=0;
		if(DateHelper.getDay(date).contains("Lundi")) i=1;
		if(DateHelper.getDay(date).contains("Mardi")) i=2;
		if(DateHelper.getDay(date).contains("Mercredi")) i=3;
		if(DateHelper.getDay(date).contains("Jeudi")) i=4;
		if(DateHelper.getDay(date).contains("Vendredi")) i=5;
		if(DateHelper.getDay(date).contains("Samedi")) i=6;
		
		
		return i;
	}
	
	public Float[] initList(){
		Float[] f=null;
		for(int i=0;i<8;i++) {
			System.out.println(i+"fois");
			f[i]=(float) 0;
		}
		
		return f;
	}
	
	private static void printResult(Object result) {
		List<String> test=new ArrayList<>();
	    if (result == null) {
	      System.out.print("NULL");
	    } else if (result instanceof Object[]) {
	      Object[] row = (Object[]) result;
	      System.out.print("[");
	      for (int i = 0; i < row.length; i++) {
	        printResult(row[i]);
	      }
	      System.out.print("]");
	    } else if (result instanceof Long || result instanceof Double
	        || result instanceof String) {
	      System.out.print(result.getClass().getName() + ": " + result);
	    } else {
	    	if(result instanceof java.sql.Date) {
	    		System.out.println("Je suis une date");
	    	}
	    	
	      System.out.print(result.getClass().getName()+"@"+result+"#");
	    }
	    System.out.println();
	  }
	
	private static Entree printResultEntree(Object result) {
		Entree test=new Entree();
	    if (result == null) {
	      System.out.print("NULL");
	    } else if (result instanceof Object[]) {
	      Object[] row = (Object[]) result;
	      //System.out.print("[");
	      for (int i = 0; i < row.length; i++) {
	    	  if(row[i] instanceof java.sql.Date) {
		    		
	    		  test.setDate((java.sql.Date)row[i]);
	    		  test.setLibelle(DateHelper.getDay(test.getDate()));
		    	}
	    	  if(row[i] instanceof Float) {
		    		;
	    		  test.setMontant((Float) row[i]);
		    	}
	    	  if(row[i] instanceof Double) test.setMontant((Double) row[i]);
	    	  if(row[i] instanceof Long) test.setNombre((Long)row[i]);
	      }
	      //System.out.print("]");
	    } else if (result instanceof Long || result instanceof Double
	        || result instanceof String) {
	      //System.out.print(result.getClass().getName() + ": " + result);
	    } else {
	    	if(result instanceof java.sql.Date) {
	    		//System.out.println("Je suis une date");
	    	}
	    	
	      //System.out.print(result.getClass().getName()+"@"+result+"#");
	    }
	    //System.out.println();
	    
	    return test;
	  }
	
	private static Depense printResultDepense(Object result) {
		Depense test=new Depense();
	    if (result == null) {
	      System.out.print("NULL");
	    } else if (result instanceof Object[]) {
	      Object[] row = (Object[]) result;
	      //System.out.print("[");
	      for (int i = 0; i < row.length; i++) {
	    	  
	    	  //System.out.println(row[i].getClass().getName());
	    	 
	    	  if(row[i] instanceof java.sql.Date) {
		    		
	    		  test.setDate((java.sql.Date)row[i]);
	    		  test.setLibelle(DateHelper.getDay(test.getDate()));
		    	}
	    	  if(row[i] instanceof Float) {
		    		;
	    		  test.setMontant((Float) row[i]);
	    		  //System.out.println((Float)row[i]);
		    	}
	    	  if(row[i] instanceof Double) {
	    		  test.setMontant((Double) row[i]);
	    		  //System.out.println((Double)row[i]);
	    	  }
	    	  if(row[i] instanceof Long) test.setNombre((Long)row[i]);
	    	  
	  	      
	  	      //}
	        //printResult(row[i]);
	      }
	      //System.out.print("]");
	    } 
	    return test;
	  }
	
	private static Compte printResultCompte(Object result) {
		Compte test=new Compte();
	    if (result == null) {
	      System.out.print("NULL");
	    } else if (result instanceof Object[]) {
	      Object[] row = (Object[]) result;
	      //System.out.print("[");
	      for (int i = 0; i < row.length; i++) {
	    	 
	    	  if(row[i] instanceof java.sql.Date) {
		    		
	    		  //test.setDate((java.sql.Date)row[i]);
	    		  //test.setLibelle(DateHelper.getDay(test.getDate()));
		    	}
	    	  if(row[i] instanceof Float) {
		    		;
	    		  test.setSolde((Float) row[i]);
		    	}
	    	  if(row[i] instanceof Double) test.setSolde((Double) row[i]);
	    	  
	  	      
	  	      //}
	        //printResult(row[i]);
	      }
	      //System.out.print("]");
	    }
	    if(result instanceof Double) test.setSolde((Double) result);
	    return test;
	  }
	
	private static Budget printResultBudget(Object result) {
		Budget test=new Budget();
	    if (result == null) {
	      System.out.print("NULL");
	    } else if (result instanceof Object[]) {
	      Object[] row = (Object[]) result;
	      //System.out.print("[");
	      for (int i = 0; i < row.length; i++) {
	    	  System.out.print(""+row[i]);
	    	  if(row[i] instanceof java.sql.Date) {
		    		
	    		  test.setDateDebut((java.sql.Date)row[i]);
	    		  test.setLibelle(DateHelper.getDay(test.getDateDebut()));
		    	}
	    	  
	    	  if(row[i] instanceof Float) {
		    		;
	    		  test.setMontant((Float) row[i]);
		    	}
	    	  if(row[i] instanceof Double) test.setDebit((Double) row[i]);
	    	  
	  	      
	  	      //}
	        //printResult(row[i]);
	      }
	     
	    } 
	    return test;
	  }

	
	
}
