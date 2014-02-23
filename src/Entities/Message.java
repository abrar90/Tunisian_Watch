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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "message")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Message.findAll", query = "SELECT m FROM Message m"),
    @NamedQuery(name = "Message.findByIdMessage", query = "SELECT m FROM Message m WHERE m.idMessage = :idMessage"),
    @NamedQuery(name = "Message.findByText", query = "SELECT m FROM Message m WHERE m.text = :text"),
    @NamedQuery(name = "Message.findByDate", query = "SELECT m FROM Message m WHERE m.date = :date")})
public class Message implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_message")
    private Integer idMessage;
    @Column(name = "text")
    private String text;
    @Column(name = "date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    @JoinColumn(name = "responsable_id_responsable", referencedColumnName = "id_responsable")
    @ManyToOne(optional = false)
    private Responsable responsableIdResponsable;
    @JoinColumn(name = "citoyen_id_citoyen", referencedColumnName = "id_citoyen")
    @ManyToOne(optional = false)
    private Citoyen citoyenIdCitoyen;
    @JoinColumn(name = "discussion_id_discussion", referencedColumnName = "id_discussion")
    @ManyToOne(optional = false)
    private Discussion discussionIdDiscussion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "messageIdMessage")
    private Collection<Fichier> fichierCollection;

    public Message() {
    }

    public Message(Integer idMessage) {
        this.idMessage = idMessage;
    }

    public Integer getIdMessage() {
        return idMessage;
    }

    public void setIdMessage(Integer idMessage) {
        this.idMessage = idMessage;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Responsable getResponsableIdResponsable() {
        return responsableIdResponsable;
    }

    public void setResponsableIdResponsable(Responsable responsableIdResponsable) {
        this.responsableIdResponsable = responsableIdResponsable;
    }

    public Citoyen getCitoyenIdCitoyen() {
        return citoyenIdCitoyen;
    }

    public void setCitoyenIdCitoyen(Citoyen citoyenIdCitoyen) {
        this.citoyenIdCitoyen = citoyenIdCitoyen;
    }

    public Discussion getDiscussionIdDiscussion() {
        return discussionIdDiscussion;
    }

    public void setDiscussionIdDiscussion(Discussion discussionIdDiscussion) {
        this.discussionIdDiscussion = discussionIdDiscussion;
    }

    @XmlTransient
    public Collection<Fichier> getFichierCollection() {
        return fichierCollection;
    }

    public void setFichierCollection(Collection<Fichier> fichierCollection) {
        this.fichierCollection = fichierCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMessage != null ? idMessage.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Message)) {
            return false;
        }
        Message other = (Message) object;
        if ((this.idMessage == null && other.idMessage != null) || (this.idMessage != null && !this.idMessage.equals(other.idMessage))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.Message[ idMessage=" + idMessage + " ]";
    }
    
}
