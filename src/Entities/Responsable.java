/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author abrar
 */
@Entity
@Table(name = "responsable")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Responsable.findAll", query = "SELECT r FROM Responsable r"),
    @NamedQuery(name = "Responsable.findByIdResponsable", query = "SELECT r FROM Responsable r WHERE r.idResponsable = :idResponsable"),
    @NamedQuery(name = "Responsable.findByLastName", query = "SELECT r FROM Responsable r WHERE r.lastName = :lastName"),
    @NamedQuery(name = "Responsable.findByFirstName", query = "SELECT r FROM Responsable r WHERE r.firstName = :firstName"),
    @NamedQuery(name = "Responsable.findByCin", query = "SELECT r FROM Responsable r WHERE r.cin = :cin"),
    @NamedQuery(name = "Responsable.findByAdress", query = "SELECT r FROM Responsable r WHERE r.adress = :adress"),
    @NamedQuery(name = "Responsable.findByAdressMail", query = "SELECT r FROM Responsable r WHERE r.adressMail = :adressMail"),
    @NamedQuery(name = "Responsable.findByLogin", query = "SELECT r FROM Responsable r WHERE r.login = :login"),
    @NamedQuery(name = "Responsable.findByPassword", query = "SELECT r FROM Responsable r WHERE r.password = :password"),
    @NamedQuery(name = "Responsable.findByPhone", query = "SELECT r FROM Responsable r WHERE r.phone = :phone"),
    @NamedQuery(name = "Responsable.findByResponsablecol", query = "SELECT r FROM Responsable r WHERE r.responsablecol = :responsablecol")})
public class Responsable implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_responsable")
    private Integer idResponsable;
    @Basic(optional = false)
    @Column(name = "last_name")
    private String lastName;
    @Basic(optional = false)
    @Column(name = "first_name")
    private String firstName;
    @Basic(optional = false)
    @Column(name = "cin")
    private int cin;
    @Basic(optional = false)
    @Column(name = "adress")
    private String adress;
    @Basic(optional = false)
    @Column(name = "adress_mail")
    private String adressMail;
    @Basic(optional = false)
    @Column(name = "login")
    private String login;
    @Basic(optional = false)
    @Column(name = "password")
    private String password;
    @Basic(optional = false)
    @Column(name = "phone")
    private int phone;
    @Column(name = "responsablecol")
    private String nom_etblissement;
    @Column(name="nom_etablissement")
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "responsableIdResponsable")
    private Collection<Message> messageCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idResponsable")
    private Collection<Discussion> discussionCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "responsableIdResponsable")
    private Collection<Reclamation> reclamationCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "responsableIdResponsable")
    private Collection<Etablissement> etablissementCollection;

    public Responsable() {
    }

    public Responsable(Integer idResponsable) {
        this.idResponsable = idResponsable;
    }

    public Responsable(Integer idResponsable, String lastName, String firstName, int cin, String adress, String adressMail, String login, String password, int phone) {
        this.idResponsable = idResponsable;
        this.lastName = lastName;
        this.firstName = firstName;
        this.cin = cin;
        this.adress = adress;
        this.adressMail = adressMail;
        this.login = login;
        this.password = password;
        this.phone = phone;
    }

    public Integer getIdResponsable() {
        return idResponsable;
    }

    public void setIdResponsable(Integer idResponsable) {
        this.idResponsable = idResponsable;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public int getCin() {
        return cin;
    }

    public void setCin(int cin) {
        this.cin = cin;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getAdressMail() {
        return adressMail;
    }

    public void setAdressMail(String adressMail) {
        this.adressMail = adressMail;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

   

    @XmlTransient
    public Collection<Message> getMessageCollection() {
        return messageCollection;
    }

    public void setMessageCollection(Collection<Message> messageCollection) {
        this.messageCollection = messageCollection;
    }

    @XmlTransient
    public Collection<Discussion> getDiscussionCollection() {
        return discussionCollection;
    }

    public void setDiscussionCollection(Collection<Discussion> discussionCollection) {
        this.discussionCollection = discussionCollection;
    }

    @XmlTransient
    public Collection<Reclamation> getReclamationCollection() {
        return reclamationCollection;
    }

    public void setReclamationCollection(Collection<Reclamation> reclamationCollection) {
        this.reclamationCollection = reclamationCollection;
    }

    @XmlTransient
    public Collection<Etablissement> getEtablissementCollection() {
        return etablissementCollection;
    }

    public void setEtablissementCollection(Collection<Etablissement> etablissementCollection) {
        this.etablissementCollection = etablissementCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idResponsable != null ? idResponsable.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Responsable)) {
            return false;
        }
        Responsable other = (Responsable) object;
        if ((this.idResponsable == null && other.idResponsable != null) || (this.idResponsable != null && !this.idResponsable.equals(other.idResponsable))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.Responsable[ idResponsable=" + idResponsable + " ]";
    }
    
}
