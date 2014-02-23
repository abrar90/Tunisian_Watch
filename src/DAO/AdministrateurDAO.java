/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;


import Entities.Admin;
import Entities.Responsable;
import conn.MyConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author FC
 */
public class AdministrateurDAO  {
   
    public Admin findAdminbyloginandpassword (String login,String password) {
        
   Admin admin= new Admin();
        
        String requette= "select login,password from admin where login=? and password=?";
        
          try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requette);
            ps.setString(1, login);
            ps.setString(2, password);
            ResultSet resultat = ps.executeQuery();
             while (resultat.next())
            {
                admin.setLogin(resultat.getString(1));
                admin.setPassword(resultat.getString(2));
            }
            return admin;

        
          }
          catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la recherche de l'admin "+ex.getMessage());
            return null;
        }
        
        
    
    }

 public void insertComptAdmin(Admin admin){

        String requeteUser = "insert into admin (login,password) values (?,?)";
        
        try {

            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requeteUser);
            
//           ps.setInt(1, admin.getIdAdmin());
            ps.setString(1, admin.getLogin());
            ps.setString(2, admin.getPassword());
           
            
            ps.executeUpdate();
            
            System.out.println("Ajout effectuée avec succès");
        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de l'insertion "+ex.getMessage());
        }
    }
    


}
