/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.gahoo.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
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
@Table(name = "operation")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Operation.findAll", query = "SELECT o FROM Operation o"),
    @NamedQuery(name = "Operation.findById", query = "SELECT o FROM Operation o WHERE o.uuid = :uuid"),
    @NamedQuery(name = "Operation.findByLibelle", query = "SELECT o FROM Operation o WHERE o.libelle = :libelle"),
    @NamedQuery(name = "Operation.findByEtat", query = "SELECT o FROM Operation o WHERE o.etat = :etat"),
    @NamedQuery(name = "Operation.findByCreatedAt", query = "SELECT o FROM Operation o WHERE o.createdAt = :createdAt")})
public class Operation implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "uuid")
    private String uuid;
    @Size(max = 255)
    @Column(name = "libelle")
    private String libelle;
    @Column(name = "image")
    private String image;
    @Column(name = "etat")
    private Boolean etat;
    @Column(name = "is_deleted")
    private Boolean isDeleted;
    
    
    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    
    @Column(name = "updated_at")
    private Date updatedAt;
    
    /*/@OneToMany
    @JoinColumn(name="operation_id")
    private Set<PosteDepense> postes = new HashSet<PosteDepense>();
    
    
	

	

	public Set<PosteDepense> getPostes() {
		return postes;
	}

	public void setPostes(Set<PosteDepense> postes) {
		this.postes = postes;
	}*/

	public Operation() {
    }

    public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}



	public String getUuid() {
		return uuid;
	}


	public void setUuid(String uuid) {
		this.uuid = uuid;
	}


	public Boolean getIsDeleted() {
		return isDeleted;
	}


	public void setIsDeleted(Boolean isDeleted) {
		this.isDeleted = isDeleted;
	}


	public Date getUpdatedAt() {
		return updatedAt;
	}


	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}


	public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public Boolean getEtat() {
        return etat;
    }

    public void setEtat(Boolean etat) {
        this.etat = etat;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
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
        if (!(object instanceof Operation)) {
            return false;
        }
        Operation other = (Operation) object;
        if ((this.uuid == null && other.uuid != null) || (this.uuid != null && !this.uuid.equals(other.uuid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.seller.Operation[ id=" + uuid + " ]";
    }
    
}
