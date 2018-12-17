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
import javax.persistence.Lob;
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
@Table(name = "abonnement")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Abonnement.findAll", query = "SELECT a FROM Abonnement a"),
    @NamedQuery(name = "Abonnement.findById", query = "SELECT a FROM Abonnement a WHERE a.id = :id"),
    @NamedQuery(name = "Abonnement.findByLibelle", query = "SELECT a FROM Abonnement a WHERE a.libelle = :libelle"),
    @NamedQuery(name = "Abonnement.findByMontant", query = "SELECT a FROM Abonnement a WHERE a.montant = :montant"),
    @NamedQuery(name = "Abonnement.findByDuree", query = "SELECT a FROM Abonnement a WHERE a.duree = :duree"),
    @NamedQuery(name = "Abonnement.findByEtat", query = "SELECT a FROM Abonnement a WHERE a.etat = :etat"),
    @NamedQuery(name = "Abonnement.findByCreatedAt", query = "SELECT a FROM Abonnement a WHERE a.createdAt = :createdAt")})
public class Abonnement implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 255)
    @Column(name = "libelle")
    private String libelle;
    @Column(name = "montant")
    private Integer montant;
    @Column(name = "duree")
    private Integer duree;
    @Lob
    @Size(max = 65535)
    @Column(name = "description")
    private String description;
    @Column(name = "etat")
    private Short etat;
    @Basic(optional = false)
    @NotNull
    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    public Abonnement() {
    }

    public Abonnement(Integer id) {
        this.id = id;
    }

    public Abonnement(Integer id, Date createdAt) {
        this.id = id;
        this.createdAt = createdAt;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public Integer getMontant() {
        return montant;
    }

    public void setMontant(Integer montant) {
        this.montant = montant;
    }

    public Integer getDuree() {
        return duree;
    }

    public void setDuree(Integer duree) {
        this.duree = duree;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Short getEtat() {
        return etat;
    }

    public void setEtat(Short etat) {
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
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Abonnement)) {
            return false;
        }
        Abonnement other = (Abonnement) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.seller.Abonnement[ id=" + id + " ]";
    }
    
}
