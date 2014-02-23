/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;

import DAO.AdministrateurDAO;
import Entities.Admin;

/**
 *
 * @author abrar
 */
public class TesterFindAdmin {
    public static void main(String[] args) {
          Admin a = new Admin();
   AdministrateurDAO adao = new AdministrateurDAO();
   a=adao.findAdminbyloginandpassword("root", "root");
  if(a!=null)
  {
      System.out.println("true");
     
  }
        
    }
    
}
