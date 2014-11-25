/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package citbyui.cit260.curiousworkmanship.view;

import curiousworkmanship.CuriousWorkmanship;

/**
 *
 * @author jacksonrkj
 */
public class ErrorView  {
    

    public static void display(String className, String errorMessage) {
        
        System.out.println(
                "----------------------------------------------------------------------------");
        System.out.println("- ERROR - " + errorMessage);
        System.out.println(
                "----------------------------------------------------------------------------");
        
        // log error
        CuriousWorkmanship.getLogFile().println("\n" + className + " - "
                                                +  errorMessage); 
    }
    
}
