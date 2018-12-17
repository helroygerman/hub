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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author user
 */
@Entity
@Table(name = "souscrire")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Souscrire.findAll", query = "SELECT s FROM Souscrire s"),
    @NamedQuery(name = "Souscrire.findById", query = "SELECT s FROM Souscrire s WHERE s.id = :id"),
    @NamedQuery(name = "Souscrire.findByAbonnementId", query = "SELECT s FROM Souscrire s WHERE s.abonnementId = :abonnementId"),
    @NamedQuery(name = "Souscrire.findByDateDebut", query = "SELECT s FROM Souscrire s WHERE s.dateDebut = :dateDebut"),
    @NamedQuery(name = "Souscrire.findByDateFin", query = "SELECT s FROM Souscrire s WHERE s.dateFin = :dateFin"),
    @NamedQuery(name = "Souscrire.findByMontant", query = "SELECT s FROM Souscrire s WHERE s.montant = :montant"),
    @NamedQuery(name = "Souscrire.findByDur\u00e9e", query = "SELECT s FROM Souscrire s WHERE s.dur\u00e9e = :dur\u00e9e"),
    @NamedQuery(name = "Souscrire.findByEtat", query = "SELECT s FROM Souscrire s WHERE s.etat = :etat"),
    @NamedQuery(name = "Souscrire.findByCreatedAt", query = "SELECT s FROM Souscrire s WHERE s.createdAt = :createdAt")})
public class Souscrire implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "abonnement_id")
    private Integer abonnementId;
    @Column(name = "date_debut")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateDebut;
    @Column(name = "date_fin")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateFin;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "montant")
    private Float montant;
    @Column(name = "dur\u00e9e")
    private Integer durée;
    @Column(name = "etat")
    private Short etat;
    @Basic(optional = false)
    @NotNull
    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    public Souscrire() {
    }

    public Souscrire(Integer id) {
        this.id = id;
    }

    public Souscrire(Integer id, Date createdAt) {
        this.id = id;
        this.createdAt = createdAt;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAbonnementId() {
        return abonnementId;
    }

    public void setAbonnementId(Integer abonnementId) {
        this.abonnementId = abonnementId;
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

    public Integer getDurée() {
        return durée;
    }

    public void setDurée(Integer durée) {
        this.durée = durée;
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
        if (!(object instanceof Souscrire)) {
            return false;
        }
        Souscrire other = (Souscrire) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.seller.Souscrire[ id=" + id + " ]";
    }
    
}
