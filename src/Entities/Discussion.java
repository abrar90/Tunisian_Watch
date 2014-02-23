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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "discussion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Discussion.findAll", query = "SELECT d FROM Discussion d"),
    @NamedQuery(name = "Discussion.findByIdDiscussion", query = "SELECT d FROM Discussion d WHERE d.idDiscussion = :idDiscussion"),
    @NamedQuery(name = "Discussion.findByState", query = "SELECT d FROM Discussion d WHERE d.state = :state"),
    @NamedQuery(name = "Discussion.findBySubject", query = "SELECT d FROM Discussion d WHERE d.subject = :subject")})
public class Discussion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_discussion")
    private Integer idDiscussion;
    @Basic(optional = false)
    @Column(name = "state")
    private String state;
    @Basic(optional = false)
    @Column(name = "subject")
    private String subject;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "discussionIdDiscussion")
    private Collection<Message> messageCollection;
    @JoinColumn(name = "id_responsable", referencedColumnName = "id_responsable")
    @ManyToOne(optional = false)
    private Responsable idResponsable;

    public Discussion() {
    }

    public Discussion(Integer idDiscussion) {
        this.idDiscussion = idDiscussion;
    }

    public Discussion(Integer idDiscussion, String state, String subject) {
        this.idDiscussion = idDiscussion;
        this.state = state;
        this.subject = subject;
    }

    public Integer getIdDiscussion() {
        return idDiscussion;
    }

    public void setIdDiscussion(Integer idDiscussion) {
        this.idDiscussion = idDiscussion;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    @XmlTransient
    public Collection<Message> getMessageCollection() {
        return messageCollection;
    }

    public void setMessageCollection(Collection<Message> messageCollection) {
        this.messageCollection = messageCollection;
    }

    public Responsable getIdResponsable() {
        return idResponsable;
    }

    public void setIdResponsable(Responsable idResponsable) {
        this.idResponsable = idResponsable;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDiscussion != null ? idDiscussion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Discussion)) {
            return false;
        }
        Discussion other = (Discussion) object;
        if ((this.idDiscussion == null && other.idDiscussion != null) || (this.idDiscussion != null && !this.idDiscussion.equals(other.idDiscussion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.Discussion[ idDiscussion=" + idDiscussion + " ]";
    }
    
}
