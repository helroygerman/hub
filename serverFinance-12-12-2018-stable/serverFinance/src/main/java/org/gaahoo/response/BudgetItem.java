package org.gaahoo.response;



import java.io.Serializable;
import java.util.List;

import org.gahoo.entity.Budget;

public class BudgetItem implements Serializable {

    private int id;
   
    private List<Budget> budgets;
    private String type;
    private String libelle;
    private double totalBudget;

    public BudgetItem(int id, List<Budget> budgets, String type, String libelle, double totalBudget) {
        this.id = id;
        this.budgets = budgets;
        this.type = type;
        this.libelle = libelle;
        this.totalBudget = totalBudget;
    }

    public BudgetItem() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Budget> getBudgets() {
        return budgets;
    }

    public void setBudgets(List<Budget> budgets) {
        this.budgets = budgets;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public double getTotalBudget() {
        return totalBudget;
    }

    public void setTotalBudget(double totalBudget) {
        this.totalBudget = totalBudget;
    }
}
