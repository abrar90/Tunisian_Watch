/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;

import DAO.ResponsableDAO;



/**
 *
 * @author abrar
 */
import Entities.Responsable;
public class TesterFindResponsableByCin {
    public static void main(String[] args) {
        ResponsableDAO res = new ResponsableDAO();
        
        Responsable r= new Responsable();
       r= res.findResponsabletByCin(12345678);
      
       if(r!=null)
           
       {  System.out.println("true");}
        
        
    }
    
}
