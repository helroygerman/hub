package org.gaahoo.service;

import java.text.ParseException;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import org.apache.commons.lang3.time.DateUtils;
import org.gaahoo.helper.DataHelper;
import org.gaahoo.helper.DateHelper;
import org.gaahoo.helper.SelectedHelper;
import org.gaahoo.response.DepenseItem;
import org.gahoo.entity.Budget;
import org.gahoo.entity.Compte;
import org.gahoo.entity.Depense;
import org.gahoo.entity.Entree;
import org.gahoo.entity.HistoriqueSolde;
import org.gahoo.entity.Planning;
import org.hibernate.query.Query;
import org.joda.time.Days;

public class DepenseService extends ServiceParent<Depense> {

	public String table = "student";
	public HistoriqueSolde historiqueSoldeCompte1 = new HistoriqueSolde();
	public Budget budget1 = new Budget();
	public HistoriqueSolde historiqueDebitBudget1 = new HistoriqueSolde();
	public Compte compte1;

	public DepenseService() {
		super(Depense.class);
		TimeZone.setDefault(TimeZone.getTimeZone("UTC"));

		// TODO Auto-generated constructor stub
	}

	public Depense find(String uuid) {
		// TODO Auto-generated method stub

		return super.find(uuid);

	}

	@Override
	public void search() {
		// TODO Auto-generated method stub

	}

	public List<Depense> all() {
		return super.all();
		// TODO Auto-generated method stub

	}
	public Depense archive(Depense entity) {
		if(exist(entity)) {
			entity.setUpdatedAt(new Date());
			return super.edit(entity);
		}else {
			return null;
		}
	
	}
	

	public List<DepenseItem> allGroupByDate(String user_uuid, String etat,String libelle,String debut,String fin,String archived) {

		// return super.all();
		List<Depense> st = null;
		List<Depense> depenseGroupe = new ArrayList<>();
		List<DepenseItem> depenseItems = new ArrayList<>();
		float totalDepense = 0;
		int i = 0;
		int nombre = 0;
		Date now = DateHelper.getDateFormat(new Date());
		int ecart = 0;
		Query q = null;
		String search=" 1=1 ";
		String searchdebut=" AND 1=1";
		String searchfin=" AND 1=1";
		String searcharchived=" AND is_archived=0 ";
		if(exist(libelle))search=" libelle LIKE '%"+libelle+"%'";
		if(exist(debut))searchdebut=" AND date >= '"+debut+"' ";
		if(exist(fin))searchfin=" AND date <='"+fin+"' ";
		if(exist(archived))searcharchived=" AND is_archived="+archivedAction(archived)+" ";
		if(exist(archived)) {
			if(archivedAction(archived)==2)searcharchived=" AND 1=1 ";
		}
		

		try {
			this.s.beginTransaction();
			// st= this.s.createQuery("from Depense ORDER BY date DESC " ).getResultList();
			if (etat.contains("is_late")) {
				System.out.println("is_late");
				q = this.s.createQuery(
						"from Depense  WHERE (DATE(date) < DATE(NOW()) AND is_planified=1 AND is_paid=0) AND user_uuid='"
								+ user_uuid +"' AND "+search+searchdebut+searchfin+searcharchived+ " ORDER BY date ASC ");
			}
			if (etat.contains("is_planified")) {
				
				q = this.s
						.createQuery("from Depense WHERE (is_planified=1 AND is_paid=0 AND DATE(date) >= DATE(NOW())) AND user_uuid='"
								+ user_uuid +"' AND "+search+searchdebut+searchfin+searcharchived+" ORDER BY date ASC ");
			}
			if (etat.contains("is_paid")) {
				
				System.out.println();
				System.out.println(searchdebut);
				System.out.println(searchfin);
				q = this.s.createQuery(
						"from Depense WHERE is_paid=1 AND user_uuid='" + user_uuid + "' AND "+search+searchdebut+searchfin+searcharchived+"  ORDER BY date DESC ");
			}
			System.out.println();
			System.out.println(searchdebut);
			System.out.println(searchfin);
			// q.setFirstResult(0);
			// q.setMaxResults(5);
			st = q.getResultList();
			this.s.getTransaction().commit();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		} finally {
			this.f.close();
		}
		float b = DateHelper.numberDay("2022-09-12", "2019-09-12");
		if (exist(st)) {
			nombre = st.size();
			Date dateCourante = st.get(0).getDate();
			System.out.println("nombre" + String.valueOf(nombre));
			for (Depense depense : st) {
				i++;
				System.out.println("i" + String.valueOf(i));
				System.out.println("dateCourant" + String.valueOf(dateCourante));
				depense.setEtat(etat);

				if (DateUtils.isSameDay(DateHelper.getDateFormat(dateCourante),
						DateHelper.getDateFormat(depense.getDate()))) {
					depenseGroupe.add(depense);
					totalDepense = totalDepense + depense.getMontant();
					System.out.println("totalMontant" + String.valueOf(totalDepense));
					if (i == nombre) {

						DepenseItem element = new DepenseItem();
						element.setDepenses(depenseGroupe);
						element.setTotalDepense(totalDepense);
						element.setLibelle(DateHelper.toDate(dateCourante));
						depenseItems.add(element);
					} else {
						if (!DateUtils.isSameDay(DateHelper.getDateFormat(dateCourante),
								DateHelper.getDateFormat(st.get(i).getDate()))) {
							System.out.println("Different:totalMontant" + String.valueOf(totalDepense));
							DepenseItem element = new DepenseItem();
							element.setDepenses(depenseGroupe);
							element.setTotalDepense(totalDepense);
							element.setLibelle(DateHelper.toDate(depense.getDate()));
							depenseItems.add(element);
							dateCourante = st.get(i).getDate();
							depenseGroupe = new ArrayList<>();
							totalDepense = 0;

						}
					}

				}

				// TODO Auto-generated catch block

			}
		}

		// TODO Auto-generated method stub

		return depenseItems;

	}

	public List<Depense> allPaginate(int from, int to) {
		return super.allPaginate(from, to);
		// TODO Auto-generated method stub

	}

	public Depense saveDepensePlanning(Depense entity) {
		Budget budget = new Budget();
		Planning planning = new Planning();
		HistoriqueSolde historiqueSoldeCompte = new HistoriqueSolde();
		HistoriqueSolde historiqueDebitBudget = new HistoriqueSolde();
		if (entity.getIsPlanified()) {
			planning = (Planning) new PlanningService().findMappingUuid(entity.getUserUuid(), "user_uuid",
					entity.getUuid(), "depense_uuid", entity.getUserUuid(), "user_uuid");
			if (planning != null) {
				if (planning.getUuid() != null) {
					planning.setUpdatedAt(new Date());
					planning.setDateRappel(DateHelper.getDateFormat(new Date()));
					planning.setRecalled(true);
				}
			}
		}
		if (entity.getIsPlanified()) {
			int[] monthyear = DateHelper.getDayMonthYear(entity.getDate());
			String dateDepense = DateHelper.firstDayOfMonth(monthyear[1], monthyear[2]);
			budget = (Budget) new BudgetService().findMappingUuid(entity.getUserUuid(), "user_uuid",
					entity.getPosteUuid(), "poste_uuid", dateDepense, "date_debut");
			if (budget != null) {
				if (budget.getUuid() != null) {
					budget.addDebit(entity.getMontant());
					historiqueDebitBudget.setUserUuid(entity.getUserUuid());
					historiqueDebitBudget.setUuid(DataHelper.uuid());
					historiqueDebitBudget.timestampAll();
					historiqueDebitBudget.setLibelle("Consommation Budget");
					historiqueDebitBudget.setMontant(entity.getMontant());
					historiqueDebitBudget.setMontantAfter(budget.getDebit());
					historiqueDebitBudget.setPropriete("debit");
					historiqueDebitBudget.setTableName("budget");
					historiqueDebitBudget.setTableUuid(budget.getUuid());
					historiqueDebitBudget.setEntityUuid(entity.getUuid());
					historiqueDebitBudget.setType("substract");
					historiqueDebitBudget.setEntityName("depense");
				}

			}
		}

		Compte compte = new CompteService().find(entity.getCompteUuid());
		compte.addDepense(entity.getMontant());
		historiqueSoldeCompte.setUuid(DataHelper.uuid());
		historiqueSoldeCompte.timestampAll();
		historiqueSoldeCompte.setLibelle("Ajout Dépense");
		historiqueSoldeCompte.setMontant(entity.getMontant());
		historiqueSoldeCompte.setMontantAfter(compte.getSolde());
		historiqueSoldeCompte.setPropriete("solde");
		historiqueSoldeCompte.setTableName("compte");
		historiqueSoldeCompte.setTableUuid(compte.getUuid());
		historiqueSoldeCompte.setEntityUuid(entity.getUuid());
		historiqueSoldeCompte.setType("substract");
		historiqueSoldeCompte.setEntityName("depense");
		historiqueSoldeCompte.setUserUuid(entity.getUserUuid());
		System.out.println(compte);
		if (entity.getUuid().isEmpty()) {
			return new Depense();
		} else {

			try {
				this.s.beginTransaction();

				if (budget != null) {
					if (budget.getUuid() != null) {
						this.s.saveOrUpdate(budget);
						this.s.saveOrUpdate(historiqueDebitBudget);
					}
					System.out.println(budget.getMois());
					// budget.addDebit(entity.getMontant());

				}
				if (planning != null) {
					if (planning.getUuid() != null) {
						this.s.saveOrUpdate(planning);

					}
					System.out.println(planning);
					// budget.addDebit(entity.getMontant());

				}
				System.out.println("reussie");
				this.s.saveOrUpdate(compte);
				this.s.saveOrUpdate(historiqueSoldeCompte);

				// entity.timestampAll();

				if (entity.getUuid() != null) {
					entity.setDate(DateHelper.getDateFormat(entity.getDate()));
					entity.setPaid(true);
					entity.setPlanified(false);
					this.s.saveOrUpdate(entity);
					System.out.println("Une seule fois");

				}
				this.s.getTransaction().commit();
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println(e.getMessage());

				this.s.getTransaction().rollback();
				return null;
			} finally {
				this.f.close();
			}
			System.out.println("Apres " + entity);
			return entity;
			// return super.save(entity);
		}

	}

	@Override
	public Depense save(Depense entity) {

		System.out.println(entity);
		entity.setUuid(DataHelper.uuid());
		Budget budget = new Budget();
		HistoriqueSolde historiqueSoldeCompte = new HistoriqueSolde();
		HistoriqueSolde historiqueDebitBudget = new HistoriqueSolde();
		if (entity.getIsPaid()) {
			int[] monthyear = DateHelper.getDayMonthYear(entity.getDate());
			String dateDepense = DateHelper.firstDayOfMonth(monthyear[1], monthyear[2]);
			budget = (Budget) new BudgetService().findMappingUuid(entity.getUserUuid(), "user_uuid",
					entity.getPosteUuid(), "poste_uuid", dateDepense, "date_debut");
			if (budget != null) {
				if (budget.getUuid() != null) {
					budget.addDebit(entity.getMontant());
					historiqueDebitBudget.setUserUuid(entity.getUserUuid());
					historiqueDebitBudget.setUuid(DataHelper.uuid());
					historiqueDebitBudget.timestampAll();
					historiqueDebitBudget.setLibelle("Consommation Budget");
					historiqueDebitBudget.setMontant(entity.getMontant());
					historiqueDebitBudget.setMontantAfter(budget.getDebit());
					historiqueDebitBudget.setPropriete("debit");
					historiqueDebitBudget.setTableName("budget");
					historiqueDebitBudget.setTableUuid(budget.getUuid());
					historiqueDebitBudget.setEntityUuid(entity.getUuid());
					historiqueDebitBudget.setType("substract");
					historiqueDebitBudget.setEntityName("depense");
				}

			}
		}

		Compte compte = new CompteService().find(entity.getCompteUuid());
		compte.addDepense(entity.getMontant());
		historiqueSoldeCompte.setUuid(DataHelper.uuid());
		historiqueSoldeCompte.timestampAll();
		historiqueSoldeCompte.setLibelle("Ajout Dépense");
		historiqueSoldeCompte.setMontant(entity.getMontant());
		historiqueSoldeCompte.setMontantAfter(compte.getSolde());
		historiqueSoldeCompte.setPropriete("solde");
		historiqueSoldeCompte.setTableName("compte");
		historiqueSoldeCompte.setTableUuid(compte.getUuid());
		historiqueSoldeCompte.setEntityUuid(entity.getUuid());
		historiqueSoldeCompte.setType("substract");
		historiqueSoldeCompte.setEntityName("depense");
		historiqueSoldeCompte.setUserUuid(entity.getUserUuid());
		System.out.println(compte);

		// TODO Auto-generated method stub
		int frequence = entity.getFrequence().getNombre();
		if (entity.getLibelle().isEmpty()) {
			return new Depense();
		} else {

			try {
				this.s.beginTransaction();

				if (budget != null) {
					if (budget.getUuid() != null) {
						this.s.saveOrUpdate(budget);
						this.s.saveOrUpdate(historiqueDebitBudget);
						entity.setBudgetUuid(budget.getUuid());
					}
					System.out.println(budget.getMois());
					// budget.addDebit(entity.getMontant());

				}
				System.out.println("reussie");
				this.s.saveOrUpdate(compte);
				this.s.saveOrUpdate(historiqueSoldeCompte);

				entity.timestampAll();

				if (entity.getIsPaid() && entity.getNombre()==0) {
					entity.setDate(DateHelper.getDateFormat(entity.getDate()));
					entity.setFrequenceUuid("f76a9b5b-e40c-11e8-a49d-00ff82b1e37d");
					entity.setPaid(true);
					entity.setPlanified(false);
					entity.setEtat("is_paid");
					this.s.save(entity);
					System.out.println("Une seule fois");
				} else {
					// Planning planning1=new Planning();
					Planning planning2 = new Planning();
					List<Planning> planings = new ArrayList<>();
					List<Depense> depenses = new ArrayList<>();

					// recuperation des prochaines depenses pour la plannification
					// Depense depense1=new Depense();
					//Depense depense2 = new Depense();

					// depense1.copy(entity);
					// depense2.copy(entity);

					// depense1.timestampAll();
					// depense2.timestampAll();
					entity.setPaid(true);
					entity.setPlanified(true);
					entity.setEtat("is_paid");
					this.s.save(entity);
					Date date = entity.getDate();
					for (int i = 1; i <= entity.getNombre(); i++) {
						Depense depense1 = new Depense();
						Planning planning1 = new Planning();
						depense1.setUuid(DataHelper.uuid());
						depense1.copy(entity);
						depense1.timestampAll();
						depense1.setFrequenceUuid(entity.getFrequenceUuid());
						depense1.setOrdre(i);
						String type = entity.getFrequence().getType();

						Date date1 = DateHelper.addHelper(type, date, frequence);
						depense1.setDate(date1);
						depense1.setPaid(false);
						depense1.setParentUuid(entity.getUuid());
						depense1.setPlanified(true);
						depense1.setEtat("is_planified");
						this.s.save(depense1);

						planning1.setUuid(DataHelper.uuid());
						planning1.setType(SelectedHelper.PlanningType("depense"));
						planning1.setUserUuid(entity.getUserUuid());
						planning1.setFrequenceUuid(entity.getFrequenceUuid());
						planning1.setDatePrevu(date1);
						planning1.setDateRappel(date1);
						planning1.setDepenseUuid(depense1.getUuid());
						planning1.timestampAll();
						this.s.save(planning1);

						date = date1;

					}

					// depense2.setFrequenceUuid(entity.getFrequenceUuid());

					// this.s.save(depense1);
					// this.s.save(depense2);

					// Ajout des dates pour les prochaines depenses

					// Date date1=DateHelper.addHelper(type, date, frequence);
					// Date date2=DateHelper.addHelper(type, date1, frequence);

					// planning1.setType(SelectedHelper.PlanningType("depense"));
					// planning1.setUserUuid(entity.getUserUuid());
					// planning1.setFrequenceUuid(entity.getFrequenceUuid());
					// planning1.setDatePrevu(date1);
					// planning1.setDateRappel(date1);

					// planning2.setType(SelectedHelper.PlanningType("depense"));
					// planning2.setUserUuid(entity.getUserUuid());
					// planning2.setFrequenceUuid(entity.getFrequenceUuid());
					// planning2.setDatePrevu(date2);
					// planning2.setDateRappel(date2);

					// depense1.setDate(date1);
					// depense2.setDate(date2);

					// depense1.setPaid(false);
					// depense2.setPaid(false);

					// sauvegarde des prochaines depenses plannifiées

					// depense1.setParentUuid(entity.getUuid());
					// depense2.setParentUuid(entity.getUuid());

					// depense1.setPlanified(true);
					// depense2.setPlanified(true);

					// this.s.save(depense1);
					// this.s.save(depense2);

					// planning1.setUuid(DataHelper.uuid());
					// planning2.setUuid(DataHelper.uuid());

					// planning2.setDepenseUuid(depense2.getUuid());
					// planning1.setDepenseUuid(depense1.getUuid());

					// planning1.timestampAll();
					// planning2.timestampAll();

					// this.s.save(planning1);
					// this.s.save(planning2);
				}
				this.s.getTransaction().commit();
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println(e.getMessage());

				this.s.getTransaction().rollback();
				return null;
			} finally {
				this.f.close();
			}
			System.out.println("Apres " + entity);
			return entity;
			// return super.save(entity);
		}

	}
	
	//Cette methode permet d'annuler une transaction sauvegardé
	public void annulerDepensePaid(Depense entity,HistoriqueSolde historiqueSoldeCompte,HistoriqueSolde historiqueDebitBudget,Budget budget,Compte compte) {
		
		//Depense entity = new Depense();
		//entity = depenses.get(1);
		//Depense depense = depenses.get(0);
		
		System.out.println("Debut annulation***************************");
		if (entity.getIsPaid() && budget != null) {
			/*int[] monthyear = DateHelper.getDayMonthYear(entity.getDate());
			String dateDepense = DateHelper.firstDayOfMonth(monthyear[1], monthyear[2]);
			System.out.println("monthYear annulation***************************"+dateDepense);
			budget = (Budget) new BudgetService().findMappingUuid(entity.getUserUuid(), "user_uuid",
					entity.getPosteUuid(), "poste_uuid", dateDepense, "date_debut");*/
			//System.out.println("buget annulation***************************"+budget.getUuid());
			if (budget != null) {
				if (budget.getUuid() != null && entity.getBudgetUuid()!=null) {
					System.out.println("buget annulation***************************"+entity.getBudgetUuid());
					budget.cancelDebit(entity.getMontant());
					historiqueDebitBudget.setUserUuid(entity.getUserUuid());
					historiqueDebitBudget.setUuid(DataHelper.uuid());
					historiqueDebitBudget.timestampAll();
					historiqueDebitBudget.setLibelle("Annulation Consommation Budget");
					historiqueDebitBudget.setMontant(entity.getMontant());
					historiqueDebitBudget.setMontantAfter(budget.getDebit());
					historiqueDebitBudget.setPropriete("debit");
					historiqueDebitBudget.setTableName("budget");
					historiqueDebitBudget.setTableUuid(budget.getUuid());
					historiqueDebitBudget.setEntityUuid(entity.getUuid());
					historiqueDebitBudget.setType("add");
					historiqueDebitBudget.setEntityName("depense");
				}

			}
		}

		//compte = new CompteService().find(entity.getCompteUuid());
		compte.cancelDepense(entity.getMontant());
		historiqueSoldeCompte.setUuid(DataHelper.uuid());
		historiqueSoldeCompte.timestampAll();
		historiqueSoldeCompte.setLibelle("Annulation Ajout Dépense");
		historiqueSoldeCompte.setMontant(entity.getMontant());
		historiqueSoldeCompte.setMontantAfter(compte.getSolde());
		historiqueSoldeCompte.setPropriete("solde");
		historiqueSoldeCompte.setTableName("compte");
		historiqueSoldeCompte.setTableUuid(compte.getUuid());
		historiqueSoldeCompte.setEntityUuid(entity.getUuid());
		historiqueSoldeCompte.setType("add");
		historiqueSoldeCompte.setEntityName("depense");
		historiqueSoldeCompte.setUserUuid(entity.getUserUuid());
		System.out.println(historiqueSoldeCompte+ " Annulation");

		
			// return super.save(entity);
		

	}
	public Depense editDepensePaid(List<Depense> depenses) {

		// TODO Auto-generated method stub

		// l'index 0 de la liste represente la depense avant la modification
		// l'index 1 de la liste represente la depense apres la modification
		Depense entity = new Depense();
		entity = depenses.get(1);
		Depense depense = depenses.get(0);
		System.out.println("toto");
		entity.setDate(DateHelper.getDateFormat(entity.getDate()));
		//HistoriqueSolde historiqueSoldeCompte1 = new HistoriqueSolde();
		//HistoriqueSolde historiqueDebitBudget1 = new HistoriqueSolde();
		

		
		Budget budget = new Budget();
		
		
		HistoriqueSolde historiqueSoldeCompte = new HistoriqueSolde();
		HistoriqueSolde historiqueDebitBudget = new HistoriqueSolde();
		if (entity.getIsPaid()) {
			int[] monthyear = DateHelper.getDayMonthYear(entity.getDate());
			String dateDepense = DateHelper.firstDayOfMonth(monthyear[1], monthyear[2]);
			budget = (Budget) new BudgetService().findMappingUuid(entity.getUserUuid(), "user_uuid",
					entity.getPosteUuid(), "poste_uuid", dateDepense, "date_debut");
			if (budget != null) {
				if (budget.getUuid() != null) {
					budget.addDebit(entity.getMontant());
					historiqueDebitBudget.setUserUuid(entity.getUserUuid());
					historiqueDebitBudget.setUuid(DataHelper.uuid());
					historiqueDebitBudget.timestampAll();
					historiqueDebitBudget.setLibelle("Consommation Budget");
					historiqueDebitBudget.setMontant(entity.getMontant());
					historiqueDebitBudget.setMontantAfter(budget.getDebit());
					historiqueDebitBudget.setPropriete("debit");
					historiqueDebitBudget.setTableName("budget");
					historiqueDebitBudget.setTableUuid(budget.getUuid());
					historiqueDebitBudget.setEntityUuid(entity.getUuid());
					historiqueDebitBudget.setType("substract");
					historiqueDebitBudget.setEntityName("depense");
				}

			}
		}

		Compte compte = new CompteService().find(entity.getCompteUuid());
		
		compte1 = new CompteService().find(depense.getCompteUuid());
		System.out.println(depense);
		compte.addDepense(entity.getMontant());
		historiqueSoldeCompte.setUuid(DataHelper.uuid());
		historiqueSoldeCompte.timestampAll();
		historiqueSoldeCompte.setLibelle("Modification Dépense");
		historiqueSoldeCompte.setMontant(entity.getMontant());
		//historiqueSoldeCompte.setMontantAfter(compte.getSolde());
		historiqueSoldeCompte.setPropriete("solde");
		historiqueSoldeCompte.setTableName("compte");
		historiqueSoldeCompte.setTableUuid(compte.getUuid());
		historiqueSoldeCompte.setEntityUuid(entity.getUuid());
		historiqueSoldeCompte.setType("substract");
		historiqueSoldeCompte.setEntityName("depense");
		historiqueSoldeCompte.setUserUuid(entity.getUserUuid());
		System.out.println(compte1);
		
		int[] monthyear1 = DateHelper.getDayMonthYear(depense.getDate());
		String dateDepense1 = DateHelper.firstDayOfMonth(monthyear1[1], monthyear1[2]);
		System.out.println("monthYear annulation***************************"+dateDepense1);
		budget1 = (Budget) new BudgetService().findMappingUuid(depense.getUserUuid(), "user_uuid",
				depense.getPosteUuid(), "poste_uuid", dateDepense1, "date_debut");
		
		//if(entity.getMontant()!=depense.getMontant() && !DateHelper.isSameMonthYear(entity.getDate(),depense.getDate())) {
		System.out.println("encours d'annulation");
			annulerDepensePaid(depense, historiqueSoldeCompte1, historiqueDebitBudget1, budget1, compte1);
			System.out.println("annulation terminé");
			//System.out.println("débit budget"+budget1.getMois());

		// TODO Auto-generated method stub
		int frequence = entity.getFrequence().getNombre();
		if (entity.getLibelle().isEmpty()) {
			return new Depense();
		} else {

			try {
				this.s.beginTransaction();

				if (budget != null) {
					if (budget.getUuid() != null) {
						this.s.saveOrUpdate(budget);
						this.s.saveOrUpdate(historiqueDebitBudget);
						entity.setBudgetUuid(budget.getUuid());
					}else {
						entity.setBudgetUuid(null);
					}
					System.out.println(budget.getMois());
					// budget.addDebit(entity.getMontant());

				}
				if(budget==null)entity.setBudgetUuid(null);
				if (budget1 != null) {
					if (budget1.getUuid() != null) {
						this.s.saveOrUpdate(budget1);
						this.s.saveOrUpdate(historiqueDebitBudget1);
						//entity.setBudgetUuid(budget.getUuid());
					}
					//System.out.println(budget.getMois());
					// budget.addDebit(entity.getMontant());

				}

				System.out.println("reussie");
				
				if(compte1!=null) {
					System.out.println("historiqueSoldeCompte1"+historiqueSoldeCompte1);
					if(compte1.getUuid().contains(compte.getUuid())) {
						System.out.println("Meme compte****************************************************");
						compte1.addDepense(entity.getMontant());
						historiqueSoldeCompte.setMontantAfter(compte1.getSolde());
						this.s.update(compte1);
					}else {
						historiqueSoldeCompte.setMontantAfter(compte.getSolde());
						this.s.update(compte1);
						this.s.update(compte);
					}
					historiqueSoldeCompte1.setMontant(depense.getMontant());
					this.s.saveOrUpdate(historiqueSoldeCompte1);
					System.out.println("historiqueSoldeCompte1"+historiqueSoldeCompte1);
				}
				
				System.out.println("compte reussie");
				this.s.saveOrUpdate(historiqueSoldeCompte);
				System.out.println(" historique reussie");
				entity.setUpdatedAt(new Date());;
				entity.setDate(DateHelper.getDateFormat(entity.getDate()));
				
				this.s.update(entity);
				//this.s.update(compte);
				System.out.println("Une seule fois");
				

					
				this.s.getTransaction().commit();
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println(e.getMessage());

				this.s.getTransaction().rollback();
				return null;
			} finally {
				this.f.close();
			}
			System.out.println("Apres " + entity);
			System.out.println("Apres1**** " + depense);

			return entity;
			// return super.save(entity);
		}


	}
	
	public Depense editDepensePlanified(List<Depense> depenses) {

		// TODO Auto-generated method stub

		// l'index 0 de la liste represente la depense avant la modification
		// l'index 1 de la liste represente la depense apres la modification
		Depense entity = new Depense();
		entity = depenses.get(1);
		Depense depense = depenses.get(0);
		System.out.println("toto");
		entity.setDate(DateHelper.getDateFormat(entity.getDate()));
		//HistoriqueSolde historiqueSoldeCompte1 = new HistoriqueSolde();
		//HistoriqueSolde historiqueDebitBudget1 = new HistoriqueSolde();
		Planning planning =new  Planning();
		Compte compte = new CompteService().find(entity.getCompteUuid());
		
		compte1 = new CompteService().find(depense.getCompteUuid());
		System.out.println(depense);
		
		
		planning = (Planning) new PlanningService().findMappingUuid(depense.getUserUuid(), "user_uuid",
				depense.getUuid(), "depense_uuid", "1", "1");
		if(exist(planning)) {
			planning.setDatePrevu(DateHelper.getDateFormat(entity.getDate()));
			planning.setDateRappel(DateHelper.getDateFormat(entity.getDate()));
			
		}
		
		int frequence = entity.getFrequence().getNombre();
		if (entity.getLibelle().isEmpty()) {
			return new Depense();
		} else {

			try {
				this.s.beginTransaction();

				if (exist(planning)) {
					this.s.update(planning);
				}
				
				System.out.println("reussie");
				
				entity.setPlanified(true);
				entity.setPaid(false);
				entity.setUpdatedAt(new Date());;
				entity.setDate(DateHelper.getDateFormat(entity.getDate()));
				
				this.s.update(entity);
				
				System.out.println("Une seule fois");
				this.s.getTransaction().commit();
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println(e.getMessage());

				this.s.getTransaction().rollback();
				return null;
			} finally {
				this.f.close();
			}
			System.out.println("Apres " + entity);
			System.out.println("Apres1**** " + depense);

			return entity;
			// return super.save(entity);
		}


	}
	
	public Depense reporter(Depense entity) {
		if(exist(entity)) {
			return super.edit(entity);
		}else {
			return null;
		}
	
	}

	public Depense edit(List<Depense> depenses) {

		// TODO Auto-generated method stub

		// l'index 0 de la liste represente la depense avant la modification
		// l'index 1 de la liste represente la depense apres la modification
		Depense entity = new Depense();
		entity = depenses.get(1);
		Depense depense = depenses.get(0);
		Budget budget = new Budget();
		HistoriqueSolde historiqueSoldeCompte = new HistoriqueSolde();
		HistoriqueSolde historiqueDebitBudget = new HistoriqueSolde();
		if (entity.getIsPaid()) {
			int[] monthyear = DateHelper.getDayMonthYear(entity.getDate());
			String dateDepense = DateHelper.firstDayOfMonth(monthyear[1], monthyear[2]);
			budget = (Budget) new BudgetService().findMappingUuid(entity.getUserUuid(), "user_uuid",
					entity.getPosteUuid(), "poste_uuid", dateDepense, "date_debut");
			if (budget != null) {
				if (budget.getUuid() != null) {
					budget.addDebit(entity.getMontant());
					historiqueDebitBudget.setUserUuid(entity.getUserUuid());
					historiqueDebitBudget.setUuid(DataHelper.uuid());
					historiqueDebitBudget.timestampAll();
					historiqueDebitBudget.setLibelle("Consommation Budget");
					historiqueDebitBudget.setMontant(entity.getMontant());
					historiqueDebitBudget.setMontantAfter(budget.getDebit());
					historiqueDebitBudget.setPropriete("debit");
					historiqueDebitBudget.setTableName("budget");
					historiqueDebitBudget.setTableUuid(budget.getUuid());
					historiqueDebitBudget.setEntityUuid(entity.getUuid());
					historiqueDebitBudget.setType("substract");
					historiqueDebitBudget.setEntityName("depense");
				}

			}
		}

		Compte compte = new CompteService().find(entity.getCompteUuid());
		compte.addDepense(entity.getMontant());
		historiqueSoldeCompte.setUuid(DataHelper.uuid());
		historiqueSoldeCompte.timestampAll();
		historiqueSoldeCompte.setLibelle("Ajout Dépense");
		historiqueSoldeCompte.setMontant(entity.getMontant());
		historiqueSoldeCompte.setMontantAfter(compte.getSolde());
		historiqueSoldeCompte.setPropriete("solde");
		historiqueSoldeCompte.setTableName("compte");
		historiqueSoldeCompte.setTableUuid(compte.getUuid());
		historiqueSoldeCompte.setEntityUuid(entity.getUuid());
		historiqueSoldeCompte.setType("substract");
		historiqueSoldeCompte.setEntityName("depense");
		historiqueSoldeCompte.setUserUuid(entity.getUserUuid());
		System.out.println(compte);

		// TODO Auto-generated method stub
		int frequence = entity.getFrequence().getNombre();
		if (entity.getLibelle().isEmpty()) {
			return new Depense();
		} else {

			try {
				this.s.beginTransaction();

				if (budget != null) {
					if (budget.getUuid() != null) {
						this.s.saveOrUpdate(budget);
						this.s.saveOrUpdate(historiqueDebitBudget);
					}
					System.out.println(budget.getMois());
					// budget.addDebit(entity.getMontant());

				}
				System.out.println("reussie");
				this.s.saveOrUpdate(compte);
				this.s.saveOrUpdate(historiqueSoldeCompte);

				entity.timestampAll();

				if (frequence == 0) {
					entity.setDate(DateHelper.getDateFormat(entity.getDate()));

					this.s.save(entity);
					System.out.println("Une seule fois");
				} else {
					// Planning planning1=new Planning();
					Planning planning2 = new Planning();
					List<Planning> planings = new ArrayList<>();
					// List<Depense> depenses=new ArrayList<>();

					// recuperation des prochaines depenses pour la plannification
					// Depense depense1=new Depense();
					Depense depense2 = new Depense();

					// depense1.copy(entity);
					// depense2.copy(entity);

					// depense1.timestampAll();
					// depense2.timestampAll();
					entity.setPaid(true);
					entity.setPlanified(true);
					this.s.save(entity);
					Date date = entity.getDate();
					for (int i = 1; i <= entity.getNombre(); i++) {
						Depense depense1 = new Depense();
						Planning planning1 = new Planning();
						depense1.setUuid(DataHelper.uuid());
						depense1.copy(entity);
						depense1.timestampAll();
						depense1.setFrequenceUuid(entity.getFrequenceUuid());
						depense1.setOrdre(i);
						String type = entity.getFrequence().getType();

						Date date1 = DateHelper.addHelper(type, date, frequence);
						depense1.setDate(date1);
						depense1.setPaid(false);
						depense1.setParentUuid(entity.getUuid());
						depense1.setPlanified(true);
						this.s.save(depense1);

						planning1.setUuid(DataHelper.uuid());
						planning1.setType(SelectedHelper.PlanningType("depense"));
						planning1.setUserUuid(entity.getUserUuid());
						planning1.setFrequenceUuid(entity.getFrequenceUuid());
						planning1.setDatePrevu(date1);
						planning1.setDateRappel(date1);
						planning1.setDepenseUuid(depense1.getUuid());
						planning1.timestampAll();
						this.s.save(planning1);

						date = date1;

					}

					// depense2.setFrequenceUuid(entity.getFrequenceUuid());

					// this.s.save(depense1);
					// this.s.save(depense2);

					// Ajout des dates pour les prochaines depenses

					// Date date1=DateHelper.addHelper(type, date, frequence);
					// Date date2=DateHelper.addHelper(type, date1, frequence);

					// planning1.setType(SelectedHelper.PlanningType("depense"));
					// planning1.setUserUuid(entity.getUserUuid());
					// planning1.setFrequenceUuid(entity.getFrequenceUuid());
					// planning1.setDatePrevu(date1);
					// planning1.setDateRappel(date1);

					// planning2.setType(SelectedHelper.PlanningType("depense"));
					// planning2.setUserUuid(entity.getUserUuid());
					// planning2.setFrequenceUuid(entity.getFrequenceUuid());
					// planning2.setDatePrevu(date2);
					// planning2.setDateRappel(date2);

					// depense1.setDate(date1);
					// depense2.setDate(date2);

					// depense1.setPaid(false);
					// depense2.setPaid(false);

					// sauvegarde des prochaines depenses plannifiées

					// depense1.setParentUuid(entity.getUuid());
					// depense2.setParentUuid(entity.getUuid());

					// depense1.setPlanified(true);
					// depense2.setPlanified(true);

					// this.s.save(depense1);
					// this.s.save(depense2);

					// planning1.setUuid(DataHelper.uuid());
					// planning2.setUuid(DataHelper.uuid());

					// planning2.setDepenseUuid(depense2.getUuid());
					// planning1.setDepenseUuid(depense1.getUuid());

					// planning1.timestampAll();
					// planning2.timestampAll();

					// this.s.save(planning1);
					// this.s.save(planning2);
				}
				this.s.getTransaction().commit();
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println(e.getMessage());

				this.s.getTransaction().rollback();
				return null;
			} finally {
				this.f.close();
			}
			System.out.println("Apres " + entity);
			return entity;
			// return super.save(entity);
		}

	}

	@Override
	public int delete(int id) {
		return super.delete(id);
		// TODO Auto-generated method stub

	}
	public boolean exist(Planning p) {
		boolean val=false;
		if(p!=null) {
			if(p.getUuid()!=null) {
				val=true;
			}
		}
		return val;
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
	public int archivedAction(String s) {
		int val=0;
		if(s!=null) {
			if(!s.isEmpty()) {
				val=Integer.parseInt(s);
			}
		}
		return val;
	}
	public boolean exist(Depense d) {
		boolean val=false;
		if(d!=null) {
			if(d.getUuid()!=null) {
				val=true;
			}
		}
		return val;
	}
	public boolean exist(List<Depense> st) {
		boolean val=false;
		if(st!=null) {
			if(st.size()>0) {
				val=true;
			}
		}
		return val;
	}
}
