package org.gaahoo.service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.gaahoo.helper.DataHelper;
import org.gaahoo.helper.DateHelper;
import org.gahoo.entity.Compte;
import org.gahoo.entity.HistoriqueSolde;
import org.gahoo.entity.Student;
import org.gahoo.entity.TypeEntree;


public class CompteService extends ServiceParent<Compte>{

	
	public String table="student";
	public CompteService() {
		super(Compte.class);
		
		// TODO Auto-generated constructor stub
	}
	
	

	
	public Compte find(String  uuid) {
		// TODO Auto-generated method stub
		
		return super.find(uuid);
		
	}

	@Override
	public void search() {
		// TODO Auto-generated method stub
		
	}


	public List<Compte> all() {
		return super.all();
		// TODO Auto-generated method stub
		
	}
	public List<Compte> allPaginate(int from, int to) {
		return super.allPaginate(from, to);
		// TODO Auto-generated method stub
		
	}
	public List<Compte> user(String  uuid) {
		return super.allMappingUuid(uuid, "user_uuid");
		// TODO Auto-generated method stub
		
	}

	@Override
	public Compte save(Compte entity) {
		
		// TODO Auto-generated method stub
		if(entity==null){
			return null;
		}else{
			UUID uuid = UUID.randomUUID();
            String randomUUIDString = uuid.toString();
            entity.setUuid(randomUUIDString);
			return super.save(entity);
		}
		
		
	}
	
	public Compte transfert(List<Compte> entity,String userUuid,float montant,String date) {
		
		// TODO Auto-generated method stub
		if(entity==null){
			return null;
		}else{
			//UUID uuid = UUID.randomUUID();
            //String randomUUIDString = uuid.toString();
            //entity.setUuid(randomUUIDString);
			Compte compteDebit=entity.get(0);
			Compte compteCredit=entity.get(1);
			compteDebit.addDepense(montant);
			compteCredit.addCredit(montant);
			HistoriqueSolde historiqueSoldeCompteDebit=new HistoriqueSolde();
			historiqueSoldeCompteDebit.setUuid(DataHelper.uuid());
			historiqueSoldeCompteDebit.timestampAll(DateHelper.parseDate(date,""));
			historiqueSoldeCompteDebit.setLibelle("Transfert d'argent@"+date.toString().replace("-", "/"));
			historiqueSoldeCompteDebit.setMontant(montant);
			historiqueSoldeCompteDebit.setMontantAfter(compteDebit.getSolde());
			historiqueSoldeCompteDebit.setPropriete("solde");
			historiqueSoldeCompteDebit.setTableName("compte");
			historiqueSoldeCompteDebit.setTableUuid(compteDebit.getUuid());
			historiqueSoldeCompteDebit.setEntityUuid(compteCredit.getUuid());
			historiqueSoldeCompteDebit.setType("substract");
			historiqueSoldeCompteDebit.setEntityName("compte");
			historiqueSoldeCompteDebit.setUserUuid(compteCredit.getUserUuid());
			
			HistoriqueSolde historiqueSoldeCompteCredit=new HistoriqueSolde();
			historiqueSoldeCompteCredit.setUuid(DataHelper.uuid());
			historiqueSoldeCompteCredit.timestampAll(DateHelper.parseDate(date,""));
			historiqueSoldeCompteCredit.setLibelle("Depot d'argent@"+date.toString().replace("-", "/"));
			historiqueSoldeCompteCredit.setMontant(montant);
			historiqueSoldeCompteCredit.setMontantAfter(compteCredit.getSolde());
			historiqueSoldeCompteCredit.setPropriete("solde");
			historiqueSoldeCompteCredit.setTableName("compte");
			historiqueSoldeCompteCredit.setTableUuid(compteCredit.getUuid());
			historiqueSoldeCompteCredit.setEntityUuid(compteDebit.getUuid());
			historiqueSoldeCompteCredit.setType("add");
			historiqueSoldeCompteCredit.setEntityName("compte");
			historiqueSoldeCompteCredit.setUserUuid(compteDebit.getUserUuid());
			
			try{	
				this.s.beginTransaction();
				
				 this.s.saveOrUpdate(compteDebit);
				 this.s.saveOrUpdate(compteCredit);
				 this.s.saveOrUpdate(historiqueSoldeCompteCredit);
				 this.s.saveOrUpdate(historiqueSoldeCompteDebit);
				 //t1=this.s.get(entityClass, entity.getClass().)
				this.s.getTransaction().commit();
			}catch (Exception e) {
				// TODO: handle exception
				System.out.println(e.getMessage());
				this.s.getTransaction().rollback();
				return  null;
			}finally {
				this.f.close();
			}
			//super.edit(entity.get(0));
			return compteDebit;
		}
		
		
	}
	
public Compte operation(Compte entity,String userUuid,float montant,String date,String type) {
		
		// TODO Auto-generated method stub
	//le parametre 'type' represente la nature de l'operation un depot ou un retrait.
		if(entity==null){
			return null;
		}else{
			//UUID uuid = UUID.randomUUID();
            //String randomUUIDString = uuid.toString();
            //entity.setUuid(randomUUIDString);
			HistoriqueSolde historiqueSoldeCompteDebit=new HistoriqueSolde();
			Compte compteDebit=entity;
			if(type.contains("depot")) {
				compteDebit.addCredit(montant);
				historiqueSoldeCompteDebit.setLibelle("Depôt d'argent@"+date.toString().replace("-", "/"));
				historiqueSoldeCompteDebit.setType("add");
			}else {
				compteDebit.addDepense(montant);
				historiqueSoldeCompteDebit.setLibelle("Retrait d'argent@"+date.toString().replace("-", "/"));
				historiqueSoldeCompteDebit.setType("substract");
			}
			
			
			
			
			historiqueSoldeCompteDebit.setUuid(DataHelper.uuid());
			historiqueSoldeCompteDebit.timestampAll(DateHelper.parseDate(date,""));
			
			historiqueSoldeCompteDebit.setMontant(montant);
			historiqueSoldeCompteDebit.setMontantAfter(compteDebit.getSolde());
			historiqueSoldeCompteDebit.setPropriete("solde");
			historiqueSoldeCompteDebit.setTableName("compte");
			historiqueSoldeCompteDebit.setTableUuid(compteDebit.getUuid());
			historiqueSoldeCompteDebit.setEntityUuid(compteDebit.getUuid());
			
			historiqueSoldeCompteDebit.setEntityName("compte");
			historiqueSoldeCompteDebit.setUserUuid(compteDebit.getUserUuid());
			
			
			
			try{	
				this.s.beginTransaction();
				
				 this.s.saveOrUpdate(compteDebit);
				 this.s.saveOrUpdate(historiqueSoldeCompteDebit);
				 //t1=this.s.get(entityClass, entity.getClass().)
				this.s.getTransaction().commit();
			}catch (Exception e) {
				// TODO: handle exception
				System.out.println(e.getMessage());
				this.s.getTransaction().rollback();
				return  null;
			}finally {
				this.f.close();
			}
			//super.edit(entity.get(0));
			return compteDebit;
		}
		
		
	}
	
	public List<Compte> saveAllToOnline(List<Compte> entity) {
		
		// TODO Auto-generated method stub
		if(entity==null){
			return null;
		}else{
			
			return super.saveAll(entity);
		}
		
		
	}
	
	public Compte edit(Compte entity) {
		
		// TODO Auto-generated method stub
		return super.edit(entity);
		
		
	}

	@Override
	public int delete(int id) {
		return super.delete(id);
		// TODO Auto-generated method stub
		
	}



	public Compte login(Compte entity) {
		// TODO Auto-generated method stub
		Compte u=new Compte();
		if(entity!=null){
			//return null;
			//u.setMessage("Success!");
			//u.setStatus("200");
			return u;
		}else{
			
		
			//String p=entity.getPassword();
			//entity.setPassword(MD5helper.hash(p));
			//return null;
			return new Compte();
			//return super.save(entity);
		}
	}

	public List<TypeEntree> allTypeEntree(int id) {
		return new TypeEntreeService().user(id);
		// TODO Auto-generated method stub
		
	}
	public List<TypeEntree> allPaginateTypeEntree(int id,int from,int number) {
		return new TypeEntreeService().userPaginate(id, from, number);
		// TODO Auto-generated method stub
		
	}
}
