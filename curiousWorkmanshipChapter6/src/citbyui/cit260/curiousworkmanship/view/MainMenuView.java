/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package citbyui.cit260.curiousworkmanship.view;

import citbyui.cit260.curiousworkmanship.control.GameControl;
import citbyui.cit260.curiousworkmanship.control.ProgramControl;
import citbyui.cit260.curiousworkmanship.view.GameMenuView;
import citbyui.cit260.curiousworkmanship.view.HelpMenuView;
import citbyui.cit260.curiousworkmanship.view.MenuView;
import curiousworkmanship.CuriousWorkmanship;

/**
 *
 * @author jacksonrkj
 */
// public class MainMenuView extends MenuView 

public class MainMenuView 
{

   /*  
    public MainMenuView() {
        super("\n"
              + "\n-----------------------------------------"
              + "\n| Main Menu                             |"
              + "\n-----------------------------------------"
              + "\nN - Start new game"
              + "\nG - Get and start saved game"
              + "\nH - Get help on how to play the game"
              + "\nS - Save game"
              + "\nQ - Quit"
              + "\n-----------------------------------------");
    }
    
    
    public void doAction(char choice) {

        switch (choice) {
            case 'N': // create and start a new game
                this.startNewGame();
                break;
            case 'G': // get and start an existing game
                this.startExistingGame();
                break;
            case 'H': // display the help menu
                this.displayHelpMenu();
                break;
            case 'S': // save the current game
                this.saveGame();               
                break;
            case 'Q': // Exit the program
                return;
            default:
                System.out.println("\n*** Invalid selection *** Try again");
                break;
        }
    }
     

    private void startNewGame() {
        // create a new game
        GameControl.createNewGame(CuriousWorkmanship.getPlayer());

        // display the game menu
        GameMenuView gameMenu = new GameMenuView();
        gameMenu.displayMenu();
    }

    private void startExistingGame() {
        // start a saved game
        GameControl.startSavedGame();

        // display the game menu
        GameMenuView gameMenu = new GameMenuView();
        gameMenu.displayMenu();
    }

    private void saveGame() {
        // prompt for and get the name of the file to save the game in
        System.out.println("\n\nEnter the file path for file where the game "
                           + "is to be saved.");
        String filePath = super.getInput();
        
        // save the game to the speciried file
        ProgramControl.saveGame(CuriousWorkmanship.getCurrentGame(), filePath);
    }

    private void displayHelpMenu() {
        HelpMenuView helpMenu = new HelpMenuView();
        helpMenu.displayMenu();
    }
*/
    
    void displayMainMenuView() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


}
