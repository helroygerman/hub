package org.gaahoo.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;
import java.util.UUID;

import org.apache.commons.lang3.time.DateUtils;
import org.gaahoo.helper.DateHelper;
import org.gaahoo.response.BudgetItem;
import org.gahoo.entity.Budget;
import org.gahoo.entity.Budget;
import org.hibernate.query.Query;

public class BudgetService extends ServiceParent<Budget> {

	public String table="student";
	public BudgetService() {
		super(Budget.class);
		TimeZone.setDefault( TimeZone.getTimeZone( "UTC" ) );
		
		// TODO Auto-generated constructor stub
	}
	
public List<Budget> allBudgetUser(int user_id) {
		
		return super.allMapping(user_id, "user_id");
		// TODO Auto-generated method stub
		
	}
	
	public Budget find(String uuid) {
		// TODO Auto-generated method stub
		
		return super.find(uuid);
		
	}
	
	public Budget findMappingUuid(String value1,String column1,String value2,String column2,String value3,String column3){
		
		return super.findMappingUuid(value1,column1,value2,column2,value3,column3);
	}
	
	public Budget find(Budget budget) {
		// TODO Auto-generated method stub
		
		//Budget budget1 = super.find(uuid);
		return null;
		
	}
	
	public Budget isOk(boolean is_ok,String uuid){
		if(is_ok){
			return super.find(uuid);
		}else{
			return null;
		}
	}
	
	public Budget delete(Budget budget){
		budget.setDeleted(true);
		return super.edit(budget);
		
		
		
	}
	
	public Budget findBudgetUser(String budget_uuid,String user_uuid){
		Budget b=new Budget();
		b=super.find(budget_uuid);
		if(b!=null){
			if(b.getUserUuid()==user_uuid){
				return b;
			}else{
				return null;
			}
		}
		else{
			return null;
		}
		
	}

	@Override
	public void search() {
		// TODO Auto-generated method stub
		
	}

	public List<BudgetItem> allGroupByDate(String user_uuid,int year,String month,String libelle) {
		
		//return super.all();
		List<Budget> st = null;
		List<Budget> budgetGroupe = new ArrayList<>();
		List<BudgetItem> budgetItems = new ArrayList<>();
		float totalBudget=0;
		int i=0;
		int nombre=0;
		Date now=DateHelper.getDateFormat(new Date());
		int ecart=0;
		Query q=null;
		
		try{	
			this.s.beginTransaction();
			 //st= this.s.createQuery("from Budget ORDER BY date DESC "  ).getResultList();
				if(year==-1){
					q= (Query) this.s.createQuery("from Budget WHERE user_uuid='"+user_uuid+"' AND is_deleted=0 ORDER BY dateDebut DESC "  );
				}if(year>0){
					q= (Query) this.s.createQuery("from Budget WHERE user_uuid='"+user_uuid+"' AND   mois LIKE '%"+String.valueOf(year)+"%' AND is_deleted=0 ORDER BY dateDebut DESC "  );
				}if(!month.isEmpty()){
					q= (Query) this.s.createQuery("from Budget WHERE user_uuid='"+user_uuid+"' AND   mois LIKE '%"+month+"%' AND is_deleted=0 ORDER BY dateDebut DESC "  );
			
				}if(!libelle.isEmpty()){
					q= (Query) this.s.createQuery("from Budget WHERE user_uuid='"+user_uuid+"' AND   libelle LIKE '%"+libelle+"%' AND is_deleted=0 ORDER BY dateDebut DESC "  );
				}
				
				 
			
			 
				//q.setFirstResult(0);
				//q.setMaxResults(5);
				st= q.getResultList();
			this.s.getTransaction().commit();
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}finally {
			this.f.close();
		}
		float b=DateHelper.numberDay("2022-09-12", "2019-09-12");
		if(st!=null){
			if(st.size()>0 ){
				nombre=st.size();
				Date dateCourante=st.get(0).getDateDebut();
				System.out.println("nombre"+String.valueOf(nombre));
				for (Budget budget : st) {
					i++;
					System.out.println("i"+String.valueOf(i));
					System.out.println("dateCourant"+String.valueOf(dateCourante));
					if(DateUtils.isSameDay(DateHelper.getDateFormat(dateCourante), DateHelper.getDateFormat(budget.getDateDebut()))){
							budgetGroupe.add(budget);
							totalBudget=totalBudget+budget.getMontant();
							System.out.println("totalMontant"+String.valueOf(totalBudget));
							if(i==nombre){
								
								
								BudgetItem element=new BudgetItem();
								element.setBudgets(budgetGroupe);
								element.setTotalBudget(totalBudget);
								element.setLibelle(budget.getMois());
								budgetItems.add(element);
							}else{
								if(!DateUtils.isSameDay(DateHelper.getDateFormat(dateCourante), DateHelper.getDateFormat(st.get(i).getDateDebut()))){
									System.out.println("Different:totalMontant"+String.valueOf(totalBudget));
									BudgetItem element=new BudgetItem();
									element.setBudgets(budgetGroupe);
									element.setTotalBudget(totalBudget);
									element.setLibelle(budget.getMois());
									budgetItems.add(element);
									dateCourante=st.get(i).getDateDebut();
									budgetGroupe=new ArrayList<>();
									totalBudget=0;
									
								}
							}
							
						}
				}
		}
		
	}
		
		// TODO Auto-generated method stub
		
		return budgetItems;
		
	}
	
public List<Budget> allBudgetUser(String user_uuid) {
		
		//return super.all();
		List<Budget> st = null;
		
		float totalBudget=0;
		Query q=null;
		
		try{	
			this.s.beginTransaction();
			 //st= this.s.createQuery("from Budget ORDER BY date DESC "  ).getResultList();
				
					q= (Query) this.s.createQuery("from Budget WHERE user_uuid='"+user_uuid+"' ORDER BY dateDebut DESC "  );
			//q.setFirstResult(0);
				//q.setMaxResults(5);
				st= q.getResultList();
			this.s.getTransaction().commit();
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			return null;
		}finally {
			this.f.close();
		}
		
		
	
		
		// TODO Auto-generated method stub
		
		return st;
		
	}

	public List<Budget> all() {
		return super.all();
		// TODO Auto-generated method stub
		
	}
	public List<Budget> allPaginate(int from, int to) {
		return super.allPaginate(from, to);
		// TODO Auto-generated method stub
		
	}

	@Override
	public Budget save(Budget entity) {
		
		// TODO Auto-generated method stub
		if(entity.getLibelle().isEmpty()){
			return new Budget();
		}else{
			UUID uuid = UUID.randomUUID();
            String randomUUIDString = uuid.toString();
            entity.setUuid(randomUUIDString);
			return super.save(entity);
		}
		
		
	}
	public Budget edit(Budget entity) {
		
		// TODO Auto-generated method stub
		return super.edit(entity);
		
		
	}

	@Override
	public int delete(int id) {
		return super.delete(id);
		// TODO Auto-generated method stub
		
	}

	
}