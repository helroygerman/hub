package org.gaahoo.response;

import java.util.List;

import org.gahoo.entity.Entree;

public class EntreeItem {

    private int id;
    private List<Entree> Entrees;
    private String type;
    private String libelle;
    private double totalEntree;
    
    
    
	public EntreeItem() {
		super();
	}
	@Override
	public String toString() {
		return "EntreeItem [id=" + id + ", Entrees=" + Entrees + ", type=" + type + ", libelle=" + libelle
				+ ", totalEntree=" + totalEntree + "]";
	}
	public EntreeItem(int id, List<Entree> entrees, String type, String libelle, double totalEntree) {
		super();
		this.id = id;
		Entrees = entrees;
		this.type = type;
		this.libelle = libelle;
		this.totalEntree = totalEntree;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public List<Entree> getEntrees() {
		return Entrees;
	}
	public void setEntrees(List<Entree> entrees) {
		Entrees = entrees;
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
	public double getTotalEntree() {
		return totalEntree;
	}
	public void setTotalEntree(double totalEntree) {
		this.totalEntree = totalEntree;
	}

    
    
}
