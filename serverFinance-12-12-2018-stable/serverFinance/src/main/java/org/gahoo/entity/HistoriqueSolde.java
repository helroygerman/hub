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
@Table(name = "historique_solde")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HistoriqueSolde.findAll", query = "SELECT h FROM HistoriqueSolde h"),
    @NamedQuery(name = "HistoriqueSolde.findByUuid", query = "SELECT h FROM HistoriqueSolde h WHERE h.uuid = :uuid"),
    @NamedQuery(name = "HistoriqueSolde.findByTableUuid", query = "SELECT h FROM HistoriqueSolde h WHERE h.tableUuid = :tableUuid"),
    @NamedQuery(name = "HistoriqueSolde.findByEntityUuid", query = "SELECT h FROM HistoriqueSolde h WHERE h.entityUuid = :entityUuid"),
    @NamedQuery(name = "HistoriqueSolde.findByTableName", query = "SELECT h FROM HistoriqueSolde h WHERE h.tableName = :tableName"),
    @NamedQuery(name = "HistoriqueSolde.findByLibelle", query = "SELECT h FROM HistoriqueSolde h WHERE h.libelle = :libelle"),
    @NamedQuery(name = "HistoriqueSolde.findByPropriete", query = "SELECT h FROM HistoriqueSolde h WHERE h.propriete = :propriete"),
    @NamedQuery(name = "HistoriqueSolde.findByMontant", query = "SELECT h FROM HistoriqueSolde h WHERE h.montant = :montant"),
    @NamedQuery(name = "HistoriqueSolde.findByMontantAfter", query = "SELECT h FROM HistoriqueSolde h WHERE h.montantAfter = :montantAfter"),
    @NamedQuery(name = "HistoriqueSolde.findByType", query = "SELECT h FROM HistoriqueSolde h WHERE h.type = :type"),
    @NamedQuery(name = "HistoriqueSolde.findByIsDeleted", query = "SELECT h FROM HistoriqueSolde h WHERE h.isDeleted = :isDeleted"),
    @NamedQuery(name = "HistoriqueSolde.findByCreatedAt", query = "SELECT h FROM HistoriqueSolde h WHERE h.createdAt = :createdAt"),
    @NamedQuery(name = "HistoriqueSolde.findByUpdatedAt", query = "SELECT h FROM HistoriqueSolde h WHERE h.updatedAt = :updatedAt")})
public class HistoriqueSolde implements Serializable {
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
    @Column(name = "user_uuid")
    private String userUuid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "table_uuid")
    private String tableUuid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "entity_uuid")
    private String entityUuid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "entity_name")
    private String entityName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "table_name")
    private String tableName;
    @Size(max = 255)
    @Column(name = "libelle")
    private String libelle;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "propriete")
    private String propriete;
    @Basic(optional = false)
    @NotNull
    @Column(name = "montant")
    private float montant;
    @Basic(optional = false)
    @NotNull
    @Column(name = "montantAfter")
    private float montantAfter;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 9)
    @Column(name = "type")
    private String type;
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
    @JoinColumn(name = "user_uuid", referencedColumnName = "uuid",insertable=false,updatable=false)
    @ManyToOne(optional = false)
    private User user;

    public HistoriqueSolde() {
    }

    public HistoriqueSolde(String uuid) {
        this.uuid = uuid;
    }

    public HistoriqueSolde(String uuid, String tableUuid, String entityUuid, String tableName, String propriete, float montant, float montantAfter, String type, boolean isDeleted, Date createdAt, Date updatedAt) {
        this.uuid = uuid;
        this.tableUuid = tableUuid;
        this.entityUuid = entityUuid;
        this.tableName = tableName;
        this.propriete = propriete;
        this.montant = montant;
        this.montantAfter = montantAfter;
        this.type = type;
        this.isDeleted = isDeleted;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
    public HistoriqueSolde(String uuid, String tableUuid, String entityUuid, String tableName, String propriete, float montant, float montantAfter, String type, boolean isDeleted) {
        this.uuid = uuid;
        this.tableUuid = tableUuid;
        this.entityUuid = entityUuid;
        this.tableName = tableName;
        this.propriete = propriete;
        this.montant = montant;
        this.montantAfter = montantAfter;
        this.type = type;
        this.isDeleted = isDeleted;
        //this.timestampAll();
        
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getTableUuid() {
        return tableUuid;
    }

    public void setTableUuid(String tableUuid) {
        this.tableUuid = tableUuid;
    }

    public String getEntityUuid() {
        return entityUuid;
    }

    public void setEntityUuid(String entityUuid) {
        this.entityUuid = entityUuid;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getPropriete() {
        return propriete;
    }

    public void setPropriete(String propriete) {
        this.propriete = propriete;
    }

    public float getMontant() {
        return montant;
    }

    public void setMontant(float montant) {
        this.montant = montant;
    }

    public float getMontantAfter() {
        return montantAfter;
    }

    public void setMontantAfter(float montantAfter) {
        this.montantAfter = montantAfter;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    

    public boolean isDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(boolean isDeleted) {
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
    

    public String getUserUuid() {
		return userUuid;
	}

	public void setUserUuid(String userUuid) {
		this.userUuid = userUuid;
	}

	public void setDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	public String getEntityName() {
		return entityName;
	}

	public void setEntityName(String entityName) {
		this.entityName = entityName;
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
        if (!(object instanceof HistoriqueSolde)) {
            return false;
        }
        HistoriqueSolde other = (HistoriqueSolde) object;
        if ((this.uuid == null && other.uuid != null) || (this.uuid != null && !this.uuid.equals(other.uuid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "data.HistoriqueSolde[ uuid=" + uuid + " ]";
    }
    public void timestampAll(){
    	this.setCreatedAt(new Date());
    	this.setUpdatedAt(new Date());
    }
    public void timestampAll(Date date){
    	this.setCreatedAt(date);
    	this.setUpdatedAt(new Date());
    }

	public void setMontantAfter(Double montantAfter) {
		this.montantAfter=montantAfter.floatValue();
		
	}
    
}
