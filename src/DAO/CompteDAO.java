/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entities.Citoyen;
import Entities.Responsable;
import conn.MyConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author user
 */
public class CompteDAO {
    public void insertComptResponsable(Responsable res){

        String requeteUser = "insert into Responsable (last_name,first_name,cin,adress,adress_mail,login,password,phone) values (?,?,?,?,?,?,?,?)";
        
        try {

            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requeteUser);
            
            ps.setString(1, res.getLastName());
            ps.setString(2, res.getFirstName());
            ps.setInt(3, res.getCin());
            ps.setString(4, res.getAdress());
            ps.setString(5, res.getAdressMail());
            ps.setString(6, res.getLogin());
            ps.setString(7, res.getPassword());
            ps.setInt(8, res.getPhone());
            
            ps.executeUpdate();
            
            System.out.println("Ajout effectuée avec succès");
        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de l'insertion "+ex.getMessage());
        }
    }public Responsable findResponsabletByID(int ID) {
        Responsable res = new Responsable();
        String requete = "select  * from Responsable where id_responsable=?";
        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
            ps.setInt(1, ID);
            ResultSet resultat = ps.executeQuery();
            while (resultat.next()) {

                res.setIdResponsable(resultat.getInt(1));
                res.setLastName(resultat.getString(2));
                res.setFirstName(resultat.getString(3));
                res.setCin(resultat.getInt(4));

                res.setAdress(resultat.getString(5));
                res.setAdressMail(resultat.getString(6));
                res.setLogin(resultat.getString(7));
                res.setPassword(resultat.getString(8));
                res.setPhone(resultat.getInt(9));
               


            }
            return res;

        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la recherche du depot " + ex.getMessage());
            return null;
        }
    }
    
    
   public void deleetComptResponsable(int id)
   {
       String requette ="delete from responsable where id=?";
         try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requette);
            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("responsable supprimé");
        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la suppression "+ex.getMessage());
        }
    }
   public void deleetComptCitoyen(int id)
   {
       String requette ="delete from citoyen where id=?";
         try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requette);
            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("citoyen supprimé");
        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la suppression "+ex.getMessage());
        }
    }
   }

    

