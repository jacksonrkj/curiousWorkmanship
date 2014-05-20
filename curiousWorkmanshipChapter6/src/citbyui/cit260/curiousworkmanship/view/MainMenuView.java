/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package citbyui.cit260.curiousworkmanship.view;

import citbyui.cit260.curiousworkmanship.control.Controls;
import citbyui.cit260.curiousworkmanship.control.GameControl;
import citbyui.cit260.curiousworkmanship.control.ProgramControl;
import java.util.Scanner;

/**
 *
 * @author jacksonrkj
 */
public class MainMenuView {
    
    private static final String MENU = "\n"
            + "\n-----------------------------------------"
            + "\n| Main Menu                             |"
            + "\n-----------------------------------------"
            + "\nG - Start game" 
            + "\nH - Get help on how to play the game" 
            + "\nS - Save game" 
            + "\nE - Exit"
            + "\n-----------------------------------------";
    

    public void displayMenu() {
        
        boolean done = false;
        do {
            // display menu
            System.out.println(MENU);
            
            char selection = this.getInput();

            // get selection and take the appropriate action
            done = this.doAction(selection);
        } while(!done);
        
        
        
    }
    
    
    public boolean doAction(char selection) {
 
        switch (selection) {
            case 'G': // display the game menu
                GameMenuView gameMenu = new GameMenuView();
                gameMenu.displayMenu();
                break;
            case 'H': // display the help menu
                HelpMenuView helpMenu = new HelpMenuView();
                helpMenu.displayMenu();
                break;
            case 'S': // save the current game to disk
                Controls.getProgramControl().saveGame();                    
                break;
            case 'E':
                return true;

            default:
                System.out.println("\n*** Invalid selection *** Try again");
        }
       
        return false;
        
    }
    
    private char getInput() {
        
        Scanner keyboard = new Scanner(System.in);
        boolean valid = false;
        String strValue = null;
        char selection = ' ';    
        
        // while a valid name has not been retrieved
        while(!valid) {
            
            // prompt for the player's name
            System.out.println("\t\nEnter your selection below:");
        
            // get the value entered from the keyboard
            strValue = keyboard.nextLine(); 
            
            if (strValue.trim().length() < 1) { // blank value entered
                // display and error
                System.out.println("\n*** Invalid selection *** Try again");
            }
            
            selection = strValue.trim().toUpperCase().charAt(0);
            
            // signal that a valid name was entered
            valid = true;            
        }
        
        return selection; // return the name        
    }
    
}
