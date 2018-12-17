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
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author user
 */
@Entity
@Table(name = "profile")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Profile.findAll", query = "SELECT p FROM Profile p"),
    @NamedQuery(name = "Profile.findByUuid", query = "SELECT p FROM Profile p WHERE p.uuid = :uuid"),
    @NamedQuery(name = "Profile.findByUserUuid", query = "SELECT p FROM Profile p WHERE p.userUuid = :userUuid"),
    @NamedQuery(name = "Profile.findByTypeUuid", query = "SELECT p FROM Profile p WHERE p.typeUuid = :typeUuid"),
    @NamedQuery(name = "Profile.findByNumero1", query = "SELECT p FROM Profile p WHERE p.numero1 = :numero1"),
    @NamedQuery(name = "Profile.findByNumero2", query = "SELECT p FROM Profile p WHERE p.numero2 = :numero2"),
    @NamedQuery(name = "Profile.findByEmail1", query = "SELECT p FROM Profile p WHERE p.email1 = :email1"),
    @NamedQuery(name = "Profile.findByEmail2", query = "SELECT p FROM Profile p WHERE p.email2 = :email2"),
    @NamedQuery(name = "Profile.findByLinkFacebook", query = "SELECT p FROM Profile p WHERE p.linkFacebook = :linkFacebook"),
    @NamedQuery(name = "Profile.findByLinkWebsite", query = "SELECT p FROM Profile p WHERE p.linkWebsite = :linkWebsite"),
    @NamedQuery(name = "Profile.findByPays", query = "SELECT p FROM Profile p WHERE p.pays = :pays"),
    @NamedQuery(name = "Profile.findByVille", query = "SELECT p FROM Profile p WHERE p.ville = :ville"),
    @NamedQuery(name = "Profile.findByApropos", query = "SELECT p FROM Profile p WHERE p.apropos = :apropos"),
    @NamedQuery(name = "Profile.findBySexe", query = "SELECT p FROM Profile p WHERE p.sexe = :sexe"),
    @NamedQuery(name = "Profile.findByDateNaissance", query = "SELECT p FROM Profile p WHERE p.dateNaissance = :dateNaissance"),
    @NamedQuery(name = "Profile.findByProfession", query = "SELECT p FROM Profile p WHERE p.profession = :profession"),
    @NamedQuery(name = "Profile.findByIp", query = "SELECT p FROM Profile p WHERE p.ip = :ip"),
    @NamedQuery(name = "Profile.findByOsVersion", query = "SELECT p FROM Profile p WHERE p.osVersion = :osVersion"),
    @NamedQuery(name = "Profile.findByModele", query = "SELECT p FROM Profile p WHERE p.modele = :modele"),
    @NamedQuery(name = "Profile.findByFabriquant", query = "SELECT p FROM Profile p WHERE p.fabriquant = :fabriquant"),
    @NamedQuery(name = "Profile.findByIsDeleted", query = "SELECT p FROM Profile p WHERE p.isDeleted = :isDeleted"),
    @NamedQuery(name = "Profile.findByCreatedAt", query = "SELECT p FROM Profile p WHERE p.createdAt = :createdAt"),
    @NamedQuery(name = "Profile.findByUpdatedAt", query = "SELECT p FROM Profile p WHERE p.updatedAt = :updatedAt")})
public class Profile implements Serializable {
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
    @Size(max = 255)
    @Column(name = "type_uuid")
    private String typeUuid;
    @Size(max = 255)
    @Column(name = "numero1")
    private String numero1;
    @Size(max = 255)
    @Column(name = "numero2")
    private String numero2;
    @Size(max = 255)
    @Column(name = "email1")
    private String email1;
    @Size(max = 255)
    @Column(name = "email2")
    private String email2;
    @Size(max = 255)
    @Column(name = "link_facebook")
    private String linkFacebook;
    @Size(max = 255)
    @Column(name = "link_website")
    private String linkWebsite;
    @Size(max = 255)
    @Column(name = "pays")
    private String pays;
    @Size(max = 255)
    @Column(name = "ville")
    private String ville;
    @Size(max = 255)
    @Column(name = "apropos")
    private String apropos;
    @Size(max = 255)
    @Column(name = "sexe")
    private String sexe;
    @Column(name = "date_naissance")
    @Temporal(TemporalType.DATE)
    private Date dateNaissance;
    @Size(max = 255)
    @Column(name = "profession")
    private String profession;
    @Size(max = 255)
    @Column(name = "ip")
    private String ip;
    @Size(max = 255)
    @Column(name = "os_version")
    private String osVersion;
    @Size(max = 255)
    @Column(name = "modele")
    private String modele;
    @Size(max = 255)
    @Column(name = "fabriquant")
    private String fabriquant;
    
    @Column(name = "is_deleted")
    private boolean isDeleted;
    @Basic(optional=false)
    @NotNull
    @Column(name = "created_at")
    private Date createdAt;
    @Basic(optional=false)
    @NotNull
    @Column(name = "updated_at")
    private Date updatedAt;
    
    
    
    

    public Profile() {
    }

    public Profile(String uuid) {
        this.uuid = uuid;
    }

    public Profile(String uuid, String userUuid, boolean isDeleted, Date createdAt, Date updatedAt) {
        this.uuid = uuid;
        this.userUuid = userUuid;
        this.isDeleted = isDeleted;
        this.createdAt = createdAt;
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

    public String getTypeUuid() {
        return typeUuid;
    }

    public void setTypeUuid(String typeUuid) {
        this.typeUuid = typeUuid;
    }

    public String getNumero1() {
        return numero1;
    }

    public void setNumero1(String numero1) {
        this.numero1 = numero1;
    }

    public String getNumero2() {
        return numero2;
    }

    public void setNumero2(String numero2) {
        this.numero2 = numero2;
    }

    public String getEmail1() {
        return email1;
    }

    public void setEmail1(String email1) {
        this.email1 = email1;
    }

    public String getEmail2() {
        return email2;
    }

    public void setEmail2(String email2) {
        this.email2 = email2;
    }

    public String getLinkFacebook() {
        return linkFacebook;
    }

    public void setLinkFacebook(String linkFacebook) {
        this.linkFacebook = linkFacebook;
    }

    public String getLinkWebsite() {
        return linkWebsite;
    }

    public void setLinkWebsite(String linkWebsite) {
        this.linkWebsite = linkWebsite;
    }

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getApropos() {
        return apropos;
    }

    public void setApropos(String apropos) {
        this.apropos = apropos;
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getOsVersion() {
        return osVersion;
    }

    public void setOsVersion(String osVersion) {
        this.osVersion = osVersion;
    }

    public String getModele() {
        return modele;
    }

    public void setModele(String modele) {
        this.modele = modele;
    }

    public String getFabriquant() {
        return fabriquant;
    }

    public void setFabriquant(String fabriquant) {
        this.fabriquant = fabriquant;
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
    
    

  

	public boolean isDeleted() {
		return isDeleted;
	}

	public void setDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
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
        if (!(object instanceof Profile)) {
            return false;
        }
        Profile other = (Profile) object;
        if ((this.uuid == null && other.uuid != null) || (this.uuid != null && !this.uuid.equals(other.uuid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "data.Profile[ uuid=" + uuid + " ]";
    }
    
}
