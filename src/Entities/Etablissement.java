/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.io.Serializable;
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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author abrar
 */
@Entity
@Table(name = "etablissement")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Etablissement.findAll", query = "SELECT e FROM Etablissement e"),
    @NamedQuery(name = "Etablissement.findByIdEtablissement", query = "SELECT e FROM Etablissement e WHERE e.idEtablissement = :idEtablissement"),
    @NamedQuery(name = "Etablissement.findByName", query = "SELECT e FROM Etablissement e WHERE e.name = :name"),
    @NamedQuery(name = "Etablissement.findByType", query = "SELECT e FROM Etablissement e WHERE e.type = :type"),
    @NamedQuery(name = "Etablissement.findByVille", query = "SELECT e FROM Etablissement e WHERE e.ville = :ville"),
    @NamedQuery(name = "Etablissement.findByGouvernerat", query = "SELECT e FROM Etablissement e WHERE e.gouvernerat = :gouvernerat")})
public class Etablissement implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_etablissement")
    private Integer idEtablissement;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @Column(name = "type")
    private String type;
    @Basic(optional = false)
    @Column(name = "ville")
    private String ville;
    @Basic(optional = false)
    @Column(name = "gouvernerat")
    private String gouvernerat;
    @JoinColumn(name = "responsable_id_responsable", referencedColumnName = "id_responsable")
    @ManyToOne(optional = false)
    private Responsable responsableIdResponsable;

    public Etablissement() {
    }

    public Etablissement(Integer idEtablissement) {
        this.idEtablissement = idEtablissement;
    }

    public Etablissement(Integer idEtablissement, String name, String type, String ville, String gouvernerat) {
        this.idEtablissement = idEtablissement;
        this.name = name;
        this.type = type;
        this.ville = ville;
        this.gouvernerat = gouvernerat;
    }

    public Integer getIdEtablissement() {
        return idEtablissement;
    }

    public void setIdEtablissement(Integer idEtablissement) {
        this.idEtablissement = idEtablissement;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getGouvernerat() {
        return gouvernerat;
    }

    public void setGouvernerat(String gouvernerat) {
        this.gouvernerat = gouvernerat;
    }

    public Responsable getResponsableIdResponsable() {
        return responsableIdResponsable;
    }

    public void setResponsableIdResponsable(Responsable responsableIdResponsable) {
        this.responsableIdResponsable = responsableIdResponsable;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEtablissement != null ? idEtablissement.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Etablissement)) {
            return false;
        }
        Etablissement other = (Etablissement) object;
        if ((this.idEtablissement == null && other.idEtablissement != null) || (this.idEtablissement != null && !this.idEtablissement.equals(other.idEtablissement))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.Etablissement[ idEtablissement=" + idEtablissement + " ]";
    }
    
}
