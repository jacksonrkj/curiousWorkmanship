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
    
    private static final String menu =  "\n\n"
            + "G - Start game\n" 
            + "H - Get help on how to play the game\n" 
            + "S - Save game\n" 
            + "E - Exit";
    
    public void displayMainMenu() {
        boolean invalidSelection = true;
        Scanner keyboard = new Scanner(System.in);
        
        do {
            
            System.out.println(MainMenuView.menu);
            String value = keyboard.nextLine();
            
            // strip off blanks and make upper case
            value = value.trim().toUpperCase(); 
            char selection = value.charAt(0); // get first character
            
            switch (selection) {
                case 'G':
                    GameMenuView gameMenu = new GameMenuView();
                    gameMenu.displayGameMenu();
                    break;
                case 'H':
                    HelpMenuView helpMenu = new HelpMenuView();
                    helpMenu.displayHelpMenu();
                    break;
                case 'S':
                    Controls.getProgramControl().saveGame();                    
                    break;
                case 'E':    
                    return;  
                    
                default:
                    System.out.println("Invalid selection - try again.");
            }
  
            
        } while(invalidSelection);
        
    }
    
}
