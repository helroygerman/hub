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
@Table(name = "rattacher")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Rattacher.findAll", query = "SELECT r FROM Rattacher r"),
    @NamedQuery(name = "Rattacher.findById", query = "SELECT r FROM Rattacher r WHERE r.id = :id"),
    @NamedQuery(name = "Rattacher.findByCompteId", query = "SELECT r FROM Rattacher r WHERE r.compteId = :compteId"),
    @NamedQuery(name = "Rattacher.findByDateDebut", query = "SELECT r FROM Rattacher r WHERE r.dateDebut = :dateDebut"),
    @NamedQuery(name = "Rattacher.findByDateFin", query = "SELECT r FROM Rattacher r WHERE r.dateFin = :dateFin"),
    @NamedQuery(name = "Rattacher.findByEtat", query = "SELECT r FROM Rattacher r WHERE r.etat = :etat"),
    @NamedQuery(name = "Rattacher.findByCreatedAt", query = "SELECT r FROM Rattacher r WHERE r.createdAt = :createdAt")})
public class Rattacher implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "compte_id")
    @Temporal(TemporalType.TIMESTAMP)
    private Date compteId;
    @Column(name = "date_debut")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateDebut;
    @Column(name = "date_fin")
    private Integer dateFin;
    @Basic(optional = false)
    @NotNull
    @Column(name = "etat")
    private boolean etat;
    @Basic(optional = false)
    @NotNull
    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    public Rattacher() {
    }

    public Rattacher(Integer id) {
        this.id = id;
    }

    public Rattacher(Integer id, boolean etat, Date createdAt) {
        this.id = id;
        this.etat = etat;
        this.createdAt = createdAt;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getCompteId() {
        return compteId;
    }

    public void setCompteId(Date compteId) {
        this.compteId = compteId;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Integer getDateFin() {
        return dateFin;
    }

    public void setDateFin(Integer dateFin) {
        this.dateFin = dateFin;
    }

    public boolean getEtat() {
        return etat;
    }

    public void setEtat(boolean etat) {
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
        if (!(object instanceof Rattacher)) {
            return false;
        }
        Rattacher other = (Rattacher) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.seller.Rattacher[ id=" + id + " ]";
    }
    
}
