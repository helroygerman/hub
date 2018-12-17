/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.gahoo.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author user
 */
@Entity
@Table(name = "compte")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Compte.findAll", query = "SELECT c FROM Compte c"),
    @NamedQuery(name = "Compte.findById", query = "SELECT c FROM Compte c WHERE c.id = :id"),
    @NamedQuery(name = "Compte.findByUserId", query = "SELECT c FROM Compte c WHERE c.userUuid = :userUuid"),
    @NamedQuery(name = "Compte.findByLibelle", query = "SELECT c FROM Compte c WHERE c.libelle = :libelle"),
    @NamedQuery(name = "Compte.findByReference", query = "SELECT c FROM Compte c WHERE c.reference = :reference"),
    @NamedQuery(name = "Compte.findByNumero", query = "SELECT c FROM Compte c WHERE c.numero = :numero"),
    @NamedQuery(name = "Compte.findBySolde", query = "SELECT c FROM Compte c WHERE c.solde = :solde"),
    @NamedQuery(name = "Compte.findBySeuil", query = "SELECT c FROM Compte c WHERE c.seuil = :seuil"),
    @NamedQuery(name = "Compte.findByTypeCompte", query = "SELECT c FROM Compte c WHERE c.typeCompte = :typeCompte"),
    @NamedQuery(name = "Compte.findByCreatedAt", query = "SELECT c FROM Compte c WHERE c.createdAt = :createdAt")})
public class Compte implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @Basic(optional = false)
    @Column(name = "uuid")
    private String uuid;
    
    @Column(name = "user_uuid")
    private String userUuid;
    @Size(max = 255)
    @Column(name = "libelle")
    private String libelle;
    @Size(max = 255)
    @Column(name = "reference")
    private String reference;
    @Size(max = 255)
    @Column(name = "numero")
    private String numero;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "solde")
    private Double solde;
    @Basic(optional = false)
    @NotNull
    @Column(name = "seuil")
    private double seuil;
    
    
    
    @Size(max = 255)
    @Column(name = "type_compte")
    private String typeCompte;
    
    @Column(name = "is_deleted")
    private boolean isDeleted;
    
    //@Basic(optional = false)
    @Column(name = "created_at")
    private String createdAt;
    
    @Column(name = "updated_at")
    private Date updatedAt;

    public Compte() {
    }

    
    
   

	public Compte(String userUid, String libelle, String reference, String numero, Double solde, double seuil,
			boolean isDeleted, String typeCompte) {
		super();
		this.userUuid = userUid;
		this.libelle = libelle;
		this.reference = reference;
		this.numero = numero;
		this.solde = solde;
		this.seuil = seuil;
		this.isDeleted = isDeleted;
		this.typeCompte = typeCompte;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	

    

    
    

   
	
    public String getUserUuid() {
		return userUuid;
	}

	public void setUserUuid(String userUid) {
		this.userUuid = userUid;
	}

	public boolean isDeleted() {
		return isDeleted;
	}

	public void setDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Double getSolde() {
        return solde;
    }

    public void setSolde(Double solde) {
        this.solde = solde;
    }
    
    public void addDepense(Float montant) {
        this.solde -= montant;
    }
    public void addEntree(Float montant) {
        this.solde += montant;
    }
    public void cancelDepense(Float montant) {
        this.solde += montant;
    }
    
    public void cancelEntree(Float montant) {
        this.solde -= montant;
    }

    public void addCredit(Float montant) {
        this.solde += montant;
    }

    public double getSeuil() {
        return seuil;
    }

    public void setSeuil(double seuil) {
        this.seuil = seuil;
    }

    public String getTypeCompte() {
        return typeCompte;
    }

    public void setTypeCompte(String typeCompte) {
        this.typeCompte = typeCompte;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }
    

    public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
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
        if (!(object instanceof Compte)) {
            return false;
        }
        Compte other = (Compte) object;
        if ((this.uuid == null && other.uuid != null) || (this.uuid != null && !this.uuid.equals(other.uuid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.seller.Compte[ uuid=" + uuid + " ]";
    }





	public void setSolde(Float solde) {
		// TODO Auto-generated method stub
		this.solde = solde.doubleValue();
	}
    
}
