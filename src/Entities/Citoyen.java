/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author abrar
 */
@Entity
@Table(name = "citoyen")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Citoyen.findAll", query = "SELECT c FROM Citoyen c"),
    @NamedQuery(name = "Citoyen.findByIdCitoyen", query = "SELECT c FROM Citoyen c WHERE c.idCitoyen = :idCitoyen"),
    @NamedQuery(name = "Citoyen.findByLastName", query = "SELECT c FROM Citoyen c WHERE c.lastName = :lastName"),
    @NamedQuery(name = "Citoyen.findByFirstName", query = "SELECT c FROM Citoyen c WHERE c.firstName = :firstName"),
    @NamedQuery(name = "Citoyen.findByCin", query = "SELECT c FROM Citoyen c WHERE c.cin = :cin"),
    @NamedQuery(name = "Citoyen.findByDateOfBirth", query = "SELECT c FROM Citoyen c WHERE c.dateOfBirth = :dateOfBirth"),
    @NamedQuery(name = "Citoyen.findByAdresse", query = "SELECT c FROM Citoyen c WHERE c.adresse = :adresse"),
    @NamedQuery(name = "Citoyen.findByPassword", query = "SELECT c FROM Citoyen c WHERE c.password = :password"),
    @NamedQuery(name = "Citoyen.findByAdresseMail", query = "SELECT c FROM Citoyen c WHERE c.adresseMail = :adresseMail"),
    @NamedQuery(name = "Citoyen.findByPhone", query = "SELECT c FROM Citoyen c WHERE c.phone = :phone"),
    @NamedQuery(name = "Citoyen.findByLogin", query = "SELECT c FROM Citoyen c WHERE c.login = :login"),
    @NamedQuery(name = "Citoyen.findByEtatCompte", query = "SELECT c FROM Citoyen c WHERE c.etatCompte = :etatCompte")})
public class Citoyen implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_citoyen")
    private Integer idCitoyen;
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
    @Column(name = "date_of_birth")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateOfBirth;
    @Basic(optional = false)
    @Column(name = "adresse")
    private String adresse;
    @Basic(optional = false)
    @Column(name = "password")
    private String password;
    @Basic(optional = false)
    @Column(name = "adresse_mail")
    private String adresseMail;
    @Basic(optional = false)
    @Column(name = "phone")
    private int phone;
    @Basic(optional = false)
    @Column(name = "login")
    private String login;
    @Basic(optional = false)
    @Column(name = "etat_compte")
    private String etatCompte;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "citoyenIdCitoyen")
    private Collection<Message> messageCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCitoyen")
    private Collection<Reclamation> reclamationCollection;

    public Citoyen() {
    }

    public Citoyen(Integer idCitoyen) {
        this.idCitoyen = idCitoyen;
    }

    public Citoyen(Integer idCitoyen, String lastName, String firstName, int cin, Date dateOfBirth, String adresse, String password, String adresseMail, int phone, String login, String etatCompte) {
        this.idCitoyen = idCitoyen;
        this.lastName = lastName;
        this.firstName = firstName;
        this.cin = cin;
        this.dateOfBirth = dateOfBirth;
        this.adresse = adresse;
        this.password = password;
        this.adresseMail = adresseMail;
        this.phone = phone;
        this.login = login;
        this.etatCompte = etatCompte;
    }

    public Integer getIdCitoyen() {
        return idCitoyen;
    }

    public void setIdCitoyen(Integer idCitoyen) {
        this.idCitoyen = idCitoyen;
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

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAdresseMail() {
        return adresseMail;
    }

    public void setAdresseMail(String adresseMail) {
        this.adresseMail = adresseMail;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getEtatCompte() {
        return etatCompte;
    }

    public void setEtatCompte(String etatCompte) {
        this.etatCompte = etatCompte;
    }

    @XmlTransient
    public Collection<Message> getMessageCollection() {
        return messageCollection;
    }

    public void setMessageCollection(Collection<Message> messageCollection) {
        this.messageCollection = messageCollection;
    }

    @XmlTransient
    public Collection<Reclamation> getReclamationCollection() {
        return reclamationCollection;
    }

    public void setReclamationCollection(Collection<Reclamation> reclamationCollection) {
        this.reclamationCollection = reclamationCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCitoyen != null ? idCitoyen.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Citoyen)) {
            return false;
        }
        Citoyen other = (Citoyen) object;
        if ((this.idCitoyen == null && other.idCitoyen != null) || (this.idCitoyen != null && !this.idCitoyen.equals(other.idCitoyen))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.Citoyen[ idCitoyen=" + idCitoyen + " ]";
    }
    
}
