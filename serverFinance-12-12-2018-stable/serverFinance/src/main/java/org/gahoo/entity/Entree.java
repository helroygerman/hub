/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.gahoo.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

import org.gaahoo.helper.DataHelper;

/**
 *
 * @author user
 */
@Entity
@Table(name = "entree")
@XmlRootElement
@NamedQueries({
	@NamedQuery(name = "Entree.findAll", query = "SELECT d FROM Entree d"),
    @NamedQuery(name = "Entree.findByUuid", query = "SELECT d FROM Entree d WHERE d.uuid = :uuid"),
    @NamedQuery(name = "Entree.findByPosteUuid", query = "SELECT d FROM Entree d WHERE d.posteUuid = :posteUuid"),
    @NamedQuery(name = "Entree.findByUserUuid", query = "SELECT d FROM Entree d WHERE d.userUuid = :userUuid"),
    @NamedQuery(name = "Entree.findByCompteUuid", query = "SELECT d FROM Entree d WHERE d.compteUuid = :compteUuid"),
    @NamedQuery(name = "Entree.findByLibelle", query = "SELECT d FROM Entree d WHERE d.libelle = :libelle"),
    @NamedQuery(name = "Entree.findByMontant", query = "SELECT d FROM Entree d WHERE d.montant = :montant"),
    @NamedQuery(name = "Entree.findByDate", query = "SELECT d FROM Entree d WHERE d.date = :date"),
    @NamedQuery(name = "Entree.findByIsPlanified", query = "SELECT d FROM Entree d WHERE d.isPlanified = :isPlanified"),
    @NamedQuery(name = "Entree.findByIsPaid", query = "SELECT d FROM Entree d WHERE d.isPaid = :isPaid"),
    @NamedQuery(name = "Entree.findByFrequenceUuid", query = "SELECT d FROM Entree d WHERE d.frequenceUuid = :frequenceUuid"),
    @NamedQuery(name = "Entree.findByIsFacture", query = "SELECT d FROM Entree d WHERE d.isFacture = :isFacture"),
    @NamedQuery(name = "Entree.findByParentUuid", query = "SELECT d FROM Entree d WHERE d.parentUuid = :parentUuid"),
    @NamedQuery(name = "Entree.findByEtat", query = "SELECT d FROM Entree d WHERE d.etat = :etat"),
    @NamedQuery(name = "Entree.findByIsDeleted", query = "SELECT d FROM Entree d WHERE d.isDeleted = :isDeleted"),
    @NamedQuery(name = "Entree.findByCreatedAt", query = "SELECT d FROM Entree d WHERE d.createdAt = :createdAt"),
    @NamedQuery(name = "Entree.findByUpdatedAt", query = "SELECT d FROM Entree d WHERE d.updatedAt = :updatedAt")})
	
public class Entree implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "uuid")
    private String uuid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "poste_uuid")
    private String posteUuid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "user_uuid")
    private String userUuid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "compte_uuid")
    private String compteUuid;
    
    @Basic(optional = true)
    @Size(min = 1, max = 255)
    @Column(name = "budget_uuid")
    private String budgetUuid;
    @Size(max = 255)
    @Column(name = "libelle")
    private String libelle;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "montant")
    private Float montant;
    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;
    
    @Column(name = "is_planified")
    private boolean isPlanified;
    @Column(name = "is_paid")
    private Boolean isPaid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "frequence_uuid")
    private String frequenceUuid;
    @Column(name = "is_facture")
    private Boolean isFacture;
    @Size(max = 255)
    @Column(name = "parent_uuid")
    private String parentUuid;
    @Size(max = 12)
    @Column(name = "etat")
    private String etat;
    
    @Column(name = "ordre")
    private int ordre;
    
    @Column(name = "nombre")
    private int nombre;
    @Basic(optional = false)
    @NotNull
    @Column(name = "is_archived")
    private boolean isArchived;
    @Basic(optional = false)
    @NotNull
    @Column(name = "is_deleted")
    private boolean isDeleted;
    @Basic(optional = false)
    @NotNull
    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @Basic(optional = false)
    @NotNull
    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;
    
    @ManyToOne(optional=false)
    @JoinColumn(name="user_uuid",referencedColumnName="uuid",insertable=false, updatable=false)
    private User user;
    
    @ManyToOne(optional=false)
    @JoinColumn(name="compte_uuid",referencedColumnName="uuid",insertable=false, updatable=false)
    private Compte compte;
    
    @ManyToOne(optional=false)
    @JoinColumn(name="poste_uuid",referencedColumnName="uuid",insertable=false, updatable=false)
    private PosteEntree poste;
    
    @ManyToOne(optional=false)
    @JoinColumn(name="frequence_uuid",referencedColumnName="uuid",insertable=false, updatable=false)
    private Frequence frequence;
    
    
    
    
    
    

   
    
    public int getOrdre() {
		return ordre;
	}

	public void setOrdre(int ordre) {
		this.ordre = ordre;
	}
	
	

	/**
	 * @return the budgetUuid
	 */
	public String getBudgetUuid() {
		return budgetUuid;
	}
	
	

	public boolean isArchived() {
		return isArchived;
	}
	
	public boolean getIsArchived() {
		return isArchived;
	}

	
	
	public void setIsArchived(boolean isArchived) {
		this.isArchived = isArchived;
	}

	/**
	 * @param budgetUuid the budgetUuid to set
	 */
	public void setBudgetUuid(String budgetUuid) {
		this.budgetUuid = budgetUuid;
	}

	public int getNombre() {
		return nombre;
	}

	public void setNombre(int nombre) {
		this.nombre = nombre;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getPosteUuid() {
		return posteUuid;
	}

	public void setPosteUuid(String posteUuid) {
		this.posteUuid = posteUuid;
	}

	public String getUserUuid() {
		return userUuid;
	}

	public void setUserUuid(String userUuid) {
		this.userUuid = userUuid;
	}

	public String getCompteUuid() {
		return compteUuid;
	}

	public void setCompteUuid(String compteUuid) {
		this.compteUuid = compteUuid;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public Float getMontant() {
		return montant;
	}

	public void setMontant(Float montant) {
		this.montant = montant;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	
	public boolean isPlanified() {
		return isPlanified;
	}
	public boolean getIsPlanified() {
		return isPlanified;
	}
	
	public boolean getIsDeleted() {
		return isDeleted;
	}

	public void setPlanified(boolean isPlanified) {
		this.isPlanified = isPlanified;
	}
	public void setIsPlanified(boolean isPlanified) {
		this.isPlanified = isPlanified;
	}
	public void setIsDeleted(boolean isDeleted) {
		this.isDeleted=isDeleted;
	}

	public Boolean getIsPaid() {
		return isPaid;
	}

	public void setIsPaid(Boolean isPaid) {
		this.isPaid = isPaid;
	}

	public void setPaid(Boolean isPaid) {
		this.isPaid = isPaid;
	}

	public String getFrequenceUuid() {
		return frequenceUuid;
	}

	public void setFrequenceUuid(String frequenceUuid) {
		this.frequenceUuid = frequenceUuid;
	}

	public Boolean getIsFacture() {
		return isFacture;
	}

	public void setIsFacture(Boolean isFacture) {
		this.isFacture = isFacture;
	}

	public String getParentUuid() {
		return parentUuid;
	}

	public void setParentUuid(String parentUuid) {
		this.parentUuid = parentUuid;
	}

	public String getEtat() {
		return etat;
	}

	public void setEtat(String etat) {
		this.etat = etat;
	}

	public boolean isDeleted() {
		return isDeleted;
	}

	public void setDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Compte getCompte() {
		return compte;
	}

	public void setCompte(Compte compte) {
		this.compte = compte;
	}

	public PosteEntree getPoste() {
		return poste;
	}

	public void setPoste(PosteEntree poste) {
		this.poste = poste;
	}

	public Frequence getFrequence() {
		return frequence;
	}

	public void setFrequence(Frequence frequence) {
		this.frequence = frequence;
	}

	@Override
    public int hashCode() {
        int hash = 0;
        hash += (uuid != null ? uuid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Entree)) {
            return false;
        }
        Entree other = (Entree) object;
        if ((this.uuid == null && other.uuid != null) || (this.uuid != null && !this.uuid.equals(other.uuid))) {
            return false;
        }
        return true;
    }
    
    public void copy(Entree entree){
    	this.uuid=DataHelper.uuid();
    	this.setMontant(entree.getMontant());
    	this.setLibelle(entree.getLibelle());
    	this.setUserUuid(entree.getUserUuid());
    	this.setPosteUuid(entree.getPosteUuid());
    	this.setCompteUuid(entree.getCompteUuid());
    	this.setNombre(entree.getNombre());
    	
    }

    @Override
	public String toString() {
		return "Entree [id=" + uuid + ", posteUuid=" + posteUuid + ", userUuid=" + userUuid + ", compteUuid=" + compteUuid
				+ ", libelle=" + libelle + ", montant=" + montant + ", date=" + date + ", isPlanified=" + isPlanified
				+ ", isPaid=" + isPaid + ", isFacture=" + isFacture + ", frequenceUuid=" + frequenceUuid + ", parentUuid="
				+ parentUuid + ", createdAt=" + createdAt + ", poste=" + poste + ", frequence=" + frequence + ", etat="
				+ etat + "]";
	}
    
    public void timestampAll(){
    	this.setCreatedAt(new Date());
    	this.setUpdatedAt(new Date());
    }

	public void setMontant(Double double1) {
		// TODO Auto-generated method stub
		this.montant = double1.floatValue();
		
	}

	public void setNombre(Long long1) {
		// TODO Auto-generated method stub
		this.nombre = long1.intValue();
		
	}
    
    
}
