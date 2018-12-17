package org.gaahoo.response;

import java.util.ArrayList;
import java.util.List;

import org.gahoo.entity.Budget;
import org.gahoo.entity.Compte;
import org.gahoo.entity.Depense;
import org.gahoo.entity.Entree;

public class Statistique {

	private List<Depense> depenses=new ArrayList<>();
	private List<Entree> entrees=new ArrayList<>();
	public List<Budget> budgets=new ArrayList<>();
	public List<Compte> comptes=new ArrayList<>();
	public Float totalDepense=(float) 0;
	public Float totalEntree=(float) 0;
	public Float totalBudget=(float) 0;
	
	public Statistique(List<Depense> depenses, List<Entree> entrees, List<Budget> budgets, List<Compte> comptes) {
		super();
		this.depenses = depenses;
		this.entrees = entrees;
		this.budgets = budgets;
		this.comptes = comptes;
	}
	public Statistique() {
		super();
	}
	public List<Depense> getDepenses() {
		return depenses;
	}
	public void setDepenses(List<Depense> depenses) {
		this.depenses = depenses;
	}
	public List<Entree> getEntrees() {
		return entrees;
	}
	public void setEntrees(List<Entree> entrees) {
		this.entrees = entrees;
	}
	public List<Budget> getBudgets() {
		return budgets;
	}
	public void setBudgets(List<Budget> budgets) {
		this.budgets = budgets;
	}
	public List<Compte> getComptes() {
		return comptes;
	}
	public void setComptes(List<Compte> comptes) {
		this.comptes = comptes;
	}
	
	
	public Float getTotalDepense() {
		return totalDepense;
	}
	public void setTotalDepense(Float totalDepense) {
		this.totalDepense = totalDepense;
	}
	public Float getTotalEntree() {
		return totalEntree;
	}
	public void setTotalEntree(Float totalEntree) {
		this.totalEntree = totalEntree;
	}
	public void addTotalEntree(Float totalEntree) {
		this.totalEntree += totalEntree;
	}
	
	public void addTotalDepense(Float totalDepense) {
		this.totalDepense += totalDepense;
	}
	
	public void addTotalBudget(Float totalBudget) {
		this.totalBudget += totalBudget;
	}
	public Float getTotalBudget() {
		return totalBudget;
	}
	public void setTotalBudget(Float totalBudget) {
		this.totalBudget = totalBudget;
	}
	@Override
	public String toString() {
		return "Statistique [depenses=" + depenses + ", entrees=" + entrees + ", budgets=" + budgets + ", comptes="
				+ comptes + "]";
	}
	
	
	
	
	
}
