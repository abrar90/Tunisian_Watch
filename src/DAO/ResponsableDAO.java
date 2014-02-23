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
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author FC
 */
public class ResponsableDAO {

    public Responsable findResponsabletByCin(int cin) {
        Responsable res = new Responsable();
        String requete = "select  * from Responsable where cin=?";
        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
            ps.setInt(1, cin);
            ResultSet resultat = ps.executeQuery();
            while (resultat.next()) {


                res.setLastName(resultat.getString(1));
                res.setFirstName(resultat.getString(2));
                res.setCin(resultat.getInt(3));

                res.setAdress(resultat.getString(4));
                res.setAdressMail(resultat.getString(5));
                res.setLogin(resultat.getString(6));
                res.setPassword(resultat.getString(7));
                res.setPhone(resultat.getInt(8));


            }
            return res;

        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la recherche du depot " + ex.getMessage());
            return null;
        }
    }
public Responsable findResponsabletByID(int ID) {
        Responsable res = new Responsable();
        String requete = "select  * from Responsable where id_responsable=?";
        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
            ps.setInt(1, ID);
            ResultSet resultat = ps.executeQuery();
            while (resultat.next()) {


                res.setLastName(resultat.getString(1));
                res.setFirstName(resultat.getString(2));
                res.setCin(resultat.getInt(3));

                res.setAdress(resultat.getString(4));
                res.setAdressMail(resultat.getString(5));
                res.setLogin(resultat.getString(6));
                res.setPassword(resultat.getString(7));
                res.setPhone(resultat.getInt(8));


            }
            return res;

        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la recherche du depot " + ex.getMessage());
            return null;
        }
    }
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
    }

    public void deleteResponsable(int cin) {
        String requete = "delete from Responsable where cin=?";
        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
            ps.setInt(1, cin);
            ps.executeUpdate();
            System.out.println("Compte responsable supprimée");
        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la suppression " + ex.getMessage());
        }
    }

    public void updateActiverResponsable(int cin) {

        String requete = "update Responsable set etat_compte=? where cin=?";
        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
            ps.setInt(1, 0);
            ps.executeUpdate();
            System.out.println("le compte est activé");
        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la mise à jour " + ex.getMessage());
        }
    }

    public List<Responsable> selectAllResponsables() {
        List<Responsable> listeresp = new ArrayList<Responsable>();

        String requete = "select nom,prenom,cin,adress,adress_email,login,phone from responsable";
        //String query = "select * from responsable";
        try {
            Statement statement = MyConnection.getInstance().createStatement();
            ResultSet resultat = statement.executeQuery(requete);
            //Responsable r = new Responsable();


            while (resultat.next()) {
                Responsable resp = new Responsable();
                resp.setLastName(resultat.getString(1));
                resp.setFirstName(resultat.getString(2));
                resp.setCin(resultat.getInt(3));
                resp.setAdress(resultat.getString(4));
                resp.setAdressMail(resultat.getString(5));
                resp.setLogin(resultat.getString(6));
               
                resp.setPhone(resultat.getInt(7));


                listeresp.add(resp);
            }

            //System.out.println("Responsables Affichés");
            return listeresp;

        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Erreur lors de la selection des responsables : " + ex.getMessage());
            return null;
        }
    }
}
