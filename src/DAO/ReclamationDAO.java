/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entities.Reclamation;
import conn.MyConnection;
import java.sql.Date;

import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author abrar
 */
public class ReclamationDAO {
    
    public void insertReclamation(Reclamation rec){

        String requeteUser = "insert into reclamation (etat,degre_urgence,sujet,date_reclamation,id_citoyen,text,type_reclamation,etablissement_id_etablissement) values (?,?,?,?,?,?,?,?)";
        
        try {

            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requeteUser);
           ps.setString(1, rec.getEtat());
           ps.setInt(2, rec.getDegreUrgence());
            ps.setString(3, rec.getSujet());
            java.util.Date date = new java.util.Date();
            date= rec.getDateReclamation();
            java.sql.Date sqlDate = new java.sql.Date(date.getTime());
            
            ps.setDate(4, sqlDate);
            ps.setInt(5, rec.getIdCitoyen().getIdCitoyen());
         // ps.setInt(7,rec.getResponsableIdResponsable().getIdResponsable());
            ps.setString(6, rec.gettext());
            ps.setString(7, rec.gettype());
            ps.setInt(8, rec.getetablissement_id_etablissement().getIdEtablissement());
           
            
            ps.executeUpdate();
            
            System.out.println("Ajout effectuée avec succès");
        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de l'insertion "+ex.getMessage());
        }
    
    
}
}