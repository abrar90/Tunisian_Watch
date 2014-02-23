/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import Entities.Etablissement;
import conn.MyConnection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import Entities.Responsable;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author abrar
 */
public class EtablissementDAO {
    public void insertComptEtablissement(Etablissement Etab){
        Responsable res = new Responsable();

        String requeteUser = "insert into etablissement (name,type,ville,gouvernerat,responsable_id_responsable) values (?,?,?,?,?)";
        
        try {

            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requeteUser);
            
            ps.setString(1, Etab.getName());
            ps.setString(2, Etab.getType());
            ps.setString(3, Etab.getVille());
            ps.setString(4, Etab.getGouvernerat());
            res  =Etab.getResponsableIdResponsable();
           
            ps.setInt(5, res.getIdResponsable());
            
            
            ps.executeUpdate();
            
            System.out.println("Ajout effectuée avec succès");
        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de l'insertion "+ex.getMessage());
        }
    }
    public Etablissement findEtablissementtByName(String name) {
       Etablissement Etab = new Etablissement();
        String requete = "select * from etablissement where name=?";
        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
            ps.setString(1, name);
            ResultSet resultat = ps.executeQuery();
            while (resultat.next()) {
                Etab.setIdEtablissement(resultat.getInt(1));
                Etab.setName(resultat.getString(2));
                Etab.setType(resultat.getString(3));
                Etab.setVille(resultat.getString(4));
                Etab.setGouvernerat(resultat.getString(5));

                 


            }
            return Etab;

        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la recherche du depot " + ex.getMessage());
            return null;
        }
    }
    public List<Etablissement> DisplayAllEtablissement (){


        List<Etablissement> listeetab = new ArrayList<Etablissement>();

        String requete = "select * from etablissement";
        try {
           Statement statement = MyConnection.getInstance()
                   .createStatement();
            ResultSet resultat = statement.executeQuery(requete);
           
            CompteDAO C= new CompteDAO();
            
            while(resultat.next()){
               Etablissement Etab =new Etablissement();
               Etab.setName(resultat.getString(2));
               Etab.setType(resultat.getString(3));
               Etab.setVille(resultat.getString(4));
               Etab.setGouvernerat(resultat.getString(5));
               Etab.setResponsableIdResponsable(C.findResponsabletByID(resultat.getInt(6)));

                listeetab.add(Etab);
            }
            return listeetab;
        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors du chargement des stocks "+ex.getMessage());
            return null;
        }
    }
    
}
