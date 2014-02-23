/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author abrar
 */
@Entity
@Table(name = "reclamation")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Reclamation.findAll", query = "SELECT r FROM Reclamation r"),
    @NamedQuery(name = "Reclamation.findByIdReclamation", query = "SELECT r FROM Reclamation r WHERE r.idReclamation = :idReclamation"),
    @NamedQuery(name = "Reclamation.findByEtat", query = "SELECT r FROM Reclamation r WHERE r.etat = :etat"),
    @NamedQuery(name = "Reclamation.findByDegreUrgence", query = "SELECT r FROM Reclamation r WHERE r.degreUrgence = :degreUrgence"),
    @NamedQuery(name = "Reclamation.findBySujet", query = "SELECT r FROM Reclamation r WHERE r.sujet = :sujet"),
    @NamedQuery(name = "Reclamation.findByDateReclamation", query = "SELECT r FROM Reclamation r WHERE r.dateReclamation = :dateReclamation")})
public class Reclamation implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_reclamation")
    private Integer idReclamation;
    @Basic(optional = false)
    @Column(name = "etat")
    private String etat;
    @Basic(optional = false)
    @Column(name = "degre_urgence")
    private int degreUrgence;
    @Basic(optional = false)
    @Column(name = "sujet")
    private String sujet;
    @Basic(optional = false)
    @Column(name = "date_reclamation")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateReclamation;
    @Column(name = "text")
   
    private String text;
    @Column(name = "type")
   
    private String type;
    @JoinColumn(name = "responsable_id_responsable", referencedColumnName = "id_responsable")
    @ManyToOne(optional = false)
    private Responsable responsableIdResponsable;
    @JoinColumn(name = "id_citoyen", referencedColumnName = "id_citoyen")
    @ManyToOne(optional = false)
    private Citoyen idCitoyen;
    @JoinColumn(name = "etablissement_id_etablissement", referencedColumnName = "id_etablissement")
    @ManyToOne(optional = false)
    private Etablissement etablissement_id_etablissement;

    public Reclamation() {
    }

    public Reclamation(Integer idReclamation) {
        this.idReclamation = idReclamation;
    }

    public Reclamation(Integer idReclamation, String etat, int degreUrgence, String sujet, Date dateReclamation) {
        this.idReclamation = idReclamation;
        this.etat = etat;
        this.degreUrgence = degreUrgence;
        this.sujet = sujet;
        this.dateReclamation = dateReclamation;
    }

    public Integer getIdReclamation() {
        return idReclamation;
    }

    public void setIdReclamation(Integer idReclamation) {
        this.idReclamation = idReclamation;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public int getDegreUrgence() {
        return degreUrgence;
    }

    public void setDegreUrgence(int degreUrgence) {
        this.degreUrgence = degreUrgence;
    }

    public String getSujet() {
        return sujet;
    }

    public void setSujet(String sujet) {
        this.sujet = sujet;
    }

    public Date getDateReclamation() {
        return dateReclamation;
    }

    public void setDateReclamation(Date dateReclamation) {
        this.dateReclamation = dateReclamation;
    }
     public String gettext() {
        return text;
    }

    public void settext(String text) {
        this.text = text;
    }
    public String gettype() {
        return text;
    }

    public void settype(String type) {
        this.type= type;
    }

    public Responsable getResponsableIdResponsable() {
        return responsableIdResponsable;
    }

    public void setResponsableIdResponsable(Responsable responsableIdResponsable) {
        this.responsableIdResponsable = responsableIdResponsable;
    }

    public Citoyen getIdCitoyen() {
        return idCitoyen;
    }
    public void setIdCitoyen(Citoyen idCitoyen) {
        this.idCitoyen = idCitoyen;
    }

    public void setetbalissement_id_etablissement(Etablissement etablissement_id_etablissement) {
        this.etablissement_id_etablissement = etablissement_id_etablissement;
    }

    public Etablissement getetablissement_id_etablissement() {
        return etablissement_id_etablissement;
    }

    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idReclamation != null ? idReclamation.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Reclamation)) {
            return false;
        }
        Reclamation other = (Reclamation) object;
        if ((this.idReclamation == null && other.idReclamation != null) || (this.idReclamation != null && !this.idReclamation.equals(other.idReclamation))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.Reclamation[ idReclamation=" + idReclamation + " ]";
    }
    
}
