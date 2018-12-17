package org.gahoo.entity;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.print.attribute.standard.DateTimeAtCreation;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "frequence")
public class Frequence implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "uuid")
    private String uuid;
    @Size(max = 255)
    @Column(name = "user_uuid")
    private String userUuid;
    @Size(max = 255)
    @Column(name = "libelle")
    private String libelle;
    @Column(name = "nombre")
    private Integer nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 7)
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

	

	public Frequence() {
		super();
	}



	public Frequence(String uuid, String userUuid, String libelle, Integer nombre, String type, boolean isDeleted,
			Date createdAt, Date updatedAt) {
		super();
		this.uuid = uuid;
		this.userUuid = userUuid;
		this.libelle = libelle;
		this.nombre = nombre;
		this.type = type;
		this.isDeleted = isDeleted;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}


	@Override
	public String toString() {
		return "Frequence [uuid=" + uuid + ", userUuid=" + userUuid + ", libelle=" + libelle + ", nombre=" + nombre
				+ ", type=" + type + ", isDeleted=" + isDeleted + ", createdAt=" + createdAt + ", updatedAt="
				+ updatedAt + "]";
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



	public String getLibelle() {
		return libelle;
	}



	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}



	public Integer getNombre() {
		return nombre;
	}



	public void setNombre(Integer nombre) {
		this.nombre = nombre;
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



	public void setDeleted(boolean isDeleted) {
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

	
    
}
