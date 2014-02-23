/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;

import DAO.CompteDAO;
import Entities.Admin;
import Entities.Responsable;

/**
 *
 * @author abrar
 */
public class testinsertResponsable {
      public static void main(String[] args) {
         Responsable Res= new Responsable();
  CompteDAO compte = new CompteDAO();
  Res.setLastName("abrar");
  Res.setFirstName("abrar");
  Res.setCin(87654321);
  Res.setAdress("ibn sina ");
  Res.setAdressMail("abrar.mhadhbi@esprit.tn");
 
  Res.setLogin("abrar");
  Res.setPassword("azerty");
  Res.setPhone(12345678);
  
  
      
        compte.insertComptResponsable(Res);
    }
    
    
}
