package org.gaahoo.response;

import java.util.List;

import org.gahoo.entity.Depense;

public class DepenseItem {

    private int id;
    private List<Depense> Depenses;
    private String type;
    private String libelle;
    private double totalDepense;
    
    
    
	public DepenseItem() {
		super();
	}
	@Override
	public String toString() {
		return "DepenseItem [id=" + id + ", Depenses=" + Depenses + ", type=" + type + ", libelle=" + libelle
				+ ", totalDepense=" + totalDepense + "]";
	}
	public DepenseItem(int id, List<Depense> depenses, String type, String libelle, double totalDepense) {
		super();
		this.id = id;
		Depenses = depenses;
		this.type = type;
		this.libelle = libelle;
		this.totalDepense = totalDepense;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public List<Depense> getDepenses() {
		return Depenses;
	}
	public void setDepenses(List<Depense> depenses) {
		Depenses = depenses;
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
	public double getTotalDepense() {
		return totalDepense;
	}
	public void setTotalDepense(double totalDepense) {
		this.totalDepense = totalDepense;
	}

    
    
}
