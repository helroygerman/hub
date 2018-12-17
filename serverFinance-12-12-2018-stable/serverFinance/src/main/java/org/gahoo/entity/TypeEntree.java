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
@Table(name = "type_entree")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TypeEntree.findAll", query = "SELECT t FROM TypeEntree t"),
    @NamedQuery(name = "TypeEntree.findById", query = "SELECT t FROM TypeEntree t WHERE t.id = :id"),
    @NamedQuery(name = "TypeEntree.findByUserId", query = "SELECT t FROM TypeEntree t WHERE t.userId = :userId"),
    @NamedQuery(name = "TypeEntree.findByLibelle", query = "SELECT t FROM TypeEntree t WHERE t.libelle = :libelle"),
    @NamedQuery(name = "TypeEntree.findByIsDeleted", query = "SELECT t FROM TypeEntree t WHERE t.isDeleted = :isDeleted"),
    @NamedQuery(name = "TypeEntree.findByCreatedAt", query = "SELECT t FROM TypeEntree t WHERE t.createdAt = :createdAt")})
public class TypeEntree implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "user_id")
    private Integer userId;
    @Size(max = 255)
    @Column(name = "libelle")
    private String libelle;
    @Column(name = "is_deleted")
    private Boolean isDeleted;
    @Basic(optional = false)
    @NotNull
    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    
    
    public TypeEntree() {
    }

    public TypeEntree(Integer id) {
        this.id = id;
    }

    public TypeEntree(Integer id, Date createdAt) {
        this.id = id;
        this.createdAt = createdAt;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public Boolean getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Boolean isDeleted) {
        this.isDeleted = isDeleted;
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
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TypeEntree)) {
            return false;
        }
        TypeEntree other = (TypeEntree) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.seller.TypeEntree[ id=" + id + " ]";
    }
    
}
