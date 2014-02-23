/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entities.Citoyen;
import conn.MyConnection;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

/**
 *
 * @author FC
 */
public class CitoyenDAO {

    public Citoyen findCitoyentByCin(int cin) {
        Citoyen cit = new Citoyen();
        String requete = "select last_name,first_name,cin from Citoyen where cin=?";
        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
            ps.setInt(1, cin);
            ResultSet resultat = ps.executeQuery();
            while (resultat.next()) {
                  cit.setLastName(resultat.getString(1));
                  cit.setFirstName(resultat.getString(2));
                cit.setCin(resultat.getInt(3));
                
                
            }
            return cit;

        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la recherche du depot " + ex.getMessage());
            return null;
        }
    }
     public Citoyen findCitoyentByLogin(String login) {
        Citoyen cet = new Citoyen();
        String requete = "select * from citoyen where login=?";
        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
            ps.setString(1,login);
            ResultSet resultat = ps.executeQuery();
            while (resultat.next()) {
                cet.setIdCitoyen(resultat.getInt(1));
                 cet.setLastName(resultat.getString(2));
                 cet.setFirstName(resultat.getString(3));
               
                cet.setCin(resultat.getInt(4));
                cet.setDateOfBirth(resultat.getDate(5));
                cet.setAdresse(resultat.getString(6));
                 cet.setPassword(resultat.getString(7));
                cet.setAdresseMail(resultat.getString(8));
                cet.setPhone(resultat.getInt(9));
                cet.setLogin(resultat.getString(10));
               
                cet.setEtatCompte(resultat.getString(11));
                
            }
            return cet;

        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la recherche du depot " + ex.getMessage());
            return null;
        }
    }

    public List<Citoyen> DisplayAllCitoyen() {



       List<Citoyen> listeCitoyen = new ArrayList<Citoyen>();

        String requete = "select * from citoyen";
        try {
            Statement statement = MyConnection.getInstance().createStatement();
            ResultSet resultat = statement.executeQuery(requete);

            while (resultat.next()) {
                Citoyen cet = new Citoyen();
              cet.setIdCitoyen(resultat.getInt(1));
                 cet.setLastName(resultat.getString(2));
                 cet.setFirstName(resultat.getString(3));
               
                cet.setCin(resultat.getInt(4));
                cet.setDateOfBirth(resultat.getDate(5));
                cet.setAdresse(resultat.getString(6));
                 cet.setPassword(resultat.getString(7));
                cet.setAdresseMail(resultat.getString(8));
                cet.setPhone(resultat.getInt(9));
                cet.setLogin(resultat.getString(10));
               
                cet.setEtatCompte(resultat.getString(11));




                listeCitoyen.add(cet);
            }
            return listeCitoyen;
        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors du chargement des depots " + ex.getMessage());
            return null;
        }
    }
    //deleteCitoyen---


}
