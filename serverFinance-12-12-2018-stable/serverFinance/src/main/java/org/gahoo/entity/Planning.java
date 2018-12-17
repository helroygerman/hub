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
@Table(name = "planning")
@XmlRootElement
@NamedQueries({
	 @NamedQuery(name = "Planning.findAll", query = "SELECT p FROM Planning p"),
	    @NamedQuery(name = "Planning.findByUuid", query = "SELECT p FROM Planning p WHERE p.uuid = :uuid"),
	    @NamedQuery(name = "Planning.findByEntreeUuid", query = "SELECT p FROM Planning p WHERE p.entreeUuid = :entreeUuid"),
	    @NamedQuery(name = "Planning.findByDepenseUuid", query = "SELECT p FROM Planning p WHERE p.depenseUuid = :depenseUuid"),
	    @NamedQuery(name = "Planning.findByUserUuid", query = "SELECT p FROM Planning p WHERE p.userUuid = :userUuid"),
	    @NamedQuery(name = "Planning.findByDatePrevu", query = "SELECT p FROM Planning p WHERE p.datePrevu = :datePrevu"),
	    @NamedQuery(name = "Planning.findByDateRappel", query = "SELECT p FROM Planning p WHERE p.dateRappel = :dateRappel"),
	    @NamedQuery(name = "Planning.findByType", query = "SELECT p FROM Planning p WHERE p.type = :type"),
	    @NamedQuery(name = "Planning.findByFrequenceUuid", query = "SELECT p FROM Planning p WHERE p.frequenceUuid = :frequenceUuid"),
	    @NamedQuery(name = "Planning.findByModeRappel", query = "SELECT p FROM Planning p WHERE p.modeRappel = :modeRappel"),
	    @NamedQuery(name = "Planning.findByIsRecalled", query = "SELECT p FROM Planning p WHERE p.isRecalled = :isRecalled"),
	    @NamedQuery(name = "Planning.findByCreatedAt", query = "SELECT p FROM Planning p WHERE p.createdAt = :createdAt")})
	public class Planning implements Serializable {
	    private static final long serialVersionUID = 1L;
	    @Id
	    @Basic(optional = false)
	    @NotNull
	    @Size(min = 1, max = 255)
	    @Column(name = "uuid")
	    private String uuid;
	    @Size(max = 255)
	    @Column(name = "entree_uuid")
	    private String entreeUuid;
	    @Size(max = 255)
	    @Column(name = "depense_uuid")
	    private String depenseUuid;
	    @Basic(optional = false)
	    @NotNull
	    @Size(min = 1, max = 255)
	    @Column(name = "user_uuid")
	    private String userUuid;
	    @Basic(optional = false)
	    @NotNull
	    @Column(name = "date_prevu")
	    @Temporal(TemporalType.DATE)
	    private Date datePrevu;
	    @Basic(optional = false)
	    @NotNull
	    @Column(name = "date_rappel")
	    @Temporal(TemporalType.TIMESTAMP)
	    private Date dateRappel;
	    @Basic(optional = false)
	    @NotNull
	    @Column(name = "type")
	    private int type;
	    @Basic(optional = false)
	    @NotNull
	    @Size(min = 1, max = 255)
	    @Column(name = "frequence_uuid")
	    private String frequenceUuid;
	    @Column(name = "mode_rappel")
	    private Boolean modeRappel;
	    @Basic(optional = false)
	    @NotNull
	    @Column(name = "is_recalled")
	    private boolean isRecalled;
	    
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
    @JoinColumn(name="frequence_uuid",referencedColumnName="uuid",insertable=false, updatable=false)
    private Frequence frequence;
    
    
    
    public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Frequence getFrequence() {
		return frequence;
	}

	public void setFrequence(Frequence frequence) {
		this.frequence = frequence;
	}

	
	
	

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getEntreeUuid() {
		return entreeUuid;
	}

	public void setEntreeUuid(String entreeUuid) {
		this.entreeUuid = entreeUuid;
	}

	public String getDepenseUuid() {
		return depenseUuid;
	}

	public void setDepenseUuid(String depenseUuid) {
		this.depenseUuid = depenseUuid;
	}

	public String getUserUuid() {
		return userUuid;
	}

	public void setUserUuid(String userUuid) {
		this.userUuid = userUuid;
	}

	public Date getDatePrevu() {
		return datePrevu;
	}

	public void setDatePrevu(Date datePrevu) {
		this.datePrevu = datePrevu;
	}

	public Date getDateRappel() {
		return dateRappel;
	}

	public void setDateRappel(Date dateRappel) {
		this.dateRappel = dateRappel;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getFrequenceUuid() {
		return frequenceUuid;
	}

	public void setFrequenceUuid(String frequenceUuid) {
		this.frequenceUuid = frequenceUuid;
	}

	public Boolean getModeRappel() {
		return modeRappel;
	}

	public void setModeRappel(Boolean modeRappel) {
		this.modeRappel = modeRappel;
	}

	public boolean isRecalled() {
		return isRecalled;
	}

	public void setRecalled(boolean isRecalled) {
		this.isRecalled = isRecalled;
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

	public Planning() {
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
        if (!(object instanceof Planning)) {
            return false;
        }
        Planning other = (Planning) object;
        if ((this.uuid == null && other.uuid != null) || (this.uuid != null && !this.uuid.equals(other.uuid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.seller.Planning[ uuid=" + uuid + " ]";
    }
    public void timestampAll(){
    	this.setCreatedAt(new Date());
    	this.setUpdatedAt(new Date());
    }

}
