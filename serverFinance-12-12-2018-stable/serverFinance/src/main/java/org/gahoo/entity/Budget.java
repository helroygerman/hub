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

/**
 *
 * @author user
 */
@Entity
@Table(name = "budget")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Budget.findAll", query = "SELECT b FROM Budget b"),
    @NamedQuery(name = "Budget.findById", query = "SELECT b FROM Budget b WHERE b.id = :id"),
    @NamedQuery(name = "Budget.findByUserUuid", query = "SELECT b FROM Budget b WHERE b.userUuid = :userUuid"),
    @NamedQuery(name = "Budget.findByPosteUuid", query = "SELECT b FROM Budget b WHERE b.posteUuid = :posteUuid"),
    @NamedQuery(name = "Budget.findByLibelle", query = "SELECT b FROM Budget b WHERE b.libelle = :libelle"),
    @NamedQuery(name = "Budget.findByDateDebut", query = "SELECT b FROM Budget b WHERE b.dateDebut = :dateDebut"),
    @NamedQuery(name = "Budget.findByDateFin", query = "SELECT b FROM Budget b WHERE b.dateFin = :dateFin"),
    @NamedQuery(name = "Budget.findByMontant", query = "SELECT b FROM Budget b WHERE b.montant = :montant"),
    @NamedQuery(name = "Budget.findBySeuil", query = "SELECT b FROM Budget b WHERE b.seuil = :seuil"),
    @NamedQuery(name = "Budget.findByDebit", query = "SELECT b FROM Budget b WHERE b.debit = :debit"),
    @NamedQuery(name = "Budget.findByCreatedAt", query = "SELECT b FROM Budget b WHERE b.createdAt = :createdAt"),
    @NamedQuery(name = "Budget.findByTypeBudget", query = "SELECT b FROM Budget b WHERE b.typeBudget = :typeBudget")})
public class Budget implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "uuid")
    private String uuid;
    @Column(name = "user_uuid")
    private String userUuid;
    @Column(name = "poste_uuid")
    private String posteUuid;
    @Size(max = 255)
    @Column(name = "libelle")
    
    private String libelle;
    @Column(name = "date_debut")
   
    private Date dateDebut;
    
    @Column(name = "date_fin")
    private Date dateFin;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "montant")
    private Float montant;
    @Column(name = "seuil")
    private Float seuil;
    @Basic(optional = false)
    @NotNull
    @Column(name = "debit")
    private float debit;
    
    
    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @Column(name = "type_budget")
    private Boolean typeBudget;
    
    @Column(name = "mois")
    private String mois;
    @Column(name = "is_deleted")
    private boolean isDeleted;
    
    @Column(name = "updated_at")
    private Date updatedAt;
    @ManyToOne(optional=false)
    @JoinColumn(name="poste_uuid",referencedColumnName="uuid",insertable=false, updatable=false)
    private PosteDepense poste;
    
    
    
    public boolean isDeleted() {
		return isDeleted;
	}

	public void setDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
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

	public void setUserUuid(String userUuid) {
		this.userUuid = userUuid;
	}

	public String getPosteUuid() {
		return posteUuid;
	}

	public void setPosteUuid(String posteUuid) {
		this.posteUuid = posteUuid;
	}

	public String getMois() {
		return mois;
	}

	public void setMois(String mois) {
		this.mois = mois;
	}

	public PosteDepense getPoste() {
		return poste;
	}

	public void setPoste(PosteDepense poste) {
		this.poste = poste;
	}

	public Budget() {
    }

   
    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

   

	public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    public Float getMontant() {
        return montant;
    }

    public void setMontant(Float montant) {
        this.montant = montant;
    }

    public Float getSeuil() {
        return seuil;
    }

    public void setSeuil(Float seuil) {
        this.seuil = seuil;
    }

    public float getDebit() {
        return debit;
    }

    public void setDebit(float debit) {
        this.debit = debit;
    }
    
    public void addDebit(float debit) {
        this.debit += debit;
        
    }
    
    public void cancelDebit(float debit) {
        this.debit -= debit;
        
    }
    

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Boolean getTypeBudget() {
        return typeBudget;
    }

    public void setTypeBudget(Boolean typeBudget) {
        this.typeBudget = typeBudget;
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
        if (!(object instanceof Budget)) {
            return false;
        }
        Budget other = (Budget) object;
        if ((this.uuid == null && other.uuid != null) || (this.uuid != null && !this.uuid.equals(other.uuid))) {
            return false;
        }
        return true;
    }

	public void setDebit(Double double1) {
		// TODO Auto-generated method stub
		this.debit=double1.intValue();
		
	}

	

    
    
}
