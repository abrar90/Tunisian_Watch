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
@Table(name = "fichier")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Fichier.findAll", query = "SELECT f FROM Fichier f"),
    @NamedQuery(name = "Fichier.findByIdFichier", query = "SELECT f FROM Fichier f WHERE f.idFichier = :idFichier")})
public class Fichier implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_fichier")
    private Integer idFichier;
    @JoinColumn(name = "message_id_message", referencedColumnName = "id_message")
    @ManyToOne(optional = false)
    private Message messageIdMessage;

    public Fichier() {
    }

    public Fichier(Integer idFichier) {
        this.idFichier = idFichier;
    }

    public Integer getIdFichier() {
        return idFichier;
    }

    public void setIdFichier(Integer idFichier) {
        this.idFichier = idFichier;
    }

    public Message getMessageIdMessage() {
        return messageIdMessage;
    }

    public void setMessageIdMessage(Message messageIdMessage) {
        this.messageIdMessage = messageIdMessage;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idFichier != null ? idFichier.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Fichier)) {
            return false;
        }
        Fichier other = (Fichier) object;
        if ((this.idFichier == null && other.idFichier != null) || (this.idFichier != null && !this.idFichier.equals(other.idFichier))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.Fichier[ idFichier=" + idFichier + " ]";
    }
    
}
