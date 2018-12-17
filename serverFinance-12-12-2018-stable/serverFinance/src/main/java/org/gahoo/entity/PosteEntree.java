
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
@Table(name = "poste_entree")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PosteEntree.findAll", query = "SELECT p FROM PosteEntree p"),
    @NamedQuery(name = "PosteEntree.findByUuid", query = "SELECT p FROM PosteEntree p WHERE p.uuid = :uuid"),
    @NamedQuery(name = "PosteEntree.findByLibelle", query = "SELECT p FROM PosteEntree p WHERE p.libelle = :libelle"),
    @NamedQuery(name = "PosteEntree.findByImage", query = "SELECT p FROM PosteEntree p WHERE p.image = :image"),
    @NamedQuery(name = "PosteEntree.findByEtat", query = "SELECT p FROM PosteEntree p WHERE p.etat = :etat"),
    @NamedQuery(name = "PosteEntree.findByIsDeleted", query = "SELECT p FROM PosteEntree p WHERE p.isDeleted = :isDeleted"),
    @NamedQuery(name = "PosteEntree.findByCreatedAt", query = "SELECT p FROM PosteEntree p WHERE p.createdAt = :createdAt"),
    @NamedQuery(name = "PosteEntree.findByUpdatedAt", query = "SELECT p FROM PosteEntree p WHERE p.updatedAt = :updatedAt")})
public class PosteEntree implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "uuid")
    private String uuid;
    @Column(name = "user_uuid")
    private String userUuid;
    @Column(name = "operation_uuid")
    private String operationUuid;
    
    @Size(max = 255)
    @Column(name = "libelle")
    private String libelle;
    @Size(max = 40)
    @Column(name = "image")
    private String image;
    @Column(name = "etat")
    private Boolean etat;
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
    @JoinColumn(name = "operation_uuid", referencedColumnName = "uuid",insertable=false,updatable=false)
    @ManyToOne(optional = false)
    private Operation operation;
    @JoinColumn(name = "user_uuid", referencedColumnName = "uuid", insertable=false,updatable=false)
    @ManyToOne(optional = false)
    private User user;

    public PosteEntree() {
    }

    public PosteEntree(String uuid) {
        this.uuid = uuid;
    }

    public PosteEntree(String uuid, boolean isDeleted, Date createdAt, Date updatedAt) {
        this.uuid = uuid;
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

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Boolean isEtat() {
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

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Operation getOperation() {
        return operation;
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (uuid != null ? uuid.hashCode() : 0);
        return hash;
    }
    
    

    public String getUserUuid() {
		return userUuid;
	}

	public void setUserUuid(String userUuid) {
		this.userUuid = userUuid;
	}

	public String getOperationUuid() {
		return operationUuid;
	}

	public void setOperationUuid(String operationUuid) {
		this.operationUuid = operationUuid;
	}

	public void setDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	@Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PosteEntree)) {
            return false;
        }
        PosteEntree other = (PosteEntree) object;
        if ((this.uuid == null && other.uuid != null) || (this.uuid != null && !this.uuid.equals(other.uuid))) {
            return false;
        }
        return true;
    }

	@Override
	public String toString() {
		return "PosteEntree [uuid=" + uuid + ", userUuid=" + userUuid + ", operationUuid=" + operationUuid
				+ ", libelle=" + libelle + ", image=" + image + ", etat=" + etat + ", isDeleted=" + isDeleted
				+ ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + ", operation=" + operation + ", user="
				+ user + "]";
	}

    
    
}
