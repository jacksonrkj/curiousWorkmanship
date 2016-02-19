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
import java.util.Scanner;

/**
 *
 * @author jacksonrkj
 */
// public class MainMenuView extends MenuView 

public class MainMenuView 
{
    private String menu;
    
    
    public MainMenuView() {
        this.menu = "\n"
                  + "\n-----------------------------------------"
                  + "\n| Main Menu                             |"
                  + "\n-----------------------------------------"
                  + "\nN - Start new game"
                  + "\nG - Get and start saved game"
                  + "\nH - Get help on how to play the game"
                  + "\nS - Save game"
                  + "\nQ - Quit"
                  + "\n-----------------------------------------";
    }
    

    /**
     * displays the start program view
     */
    public void displayMainMenuView() {
        
        boolean done = false; // set flag to not done
        do { 
            // prompt for and get players name
            String menuOption = this.getMenuOption();
            if (menuOption.toUpperCase().equals("Q")) // user wants to quit
                return; // exit the game

            // do the requested action and display the next view
            done = this.doAction(menuOption); 

        } while (!done);

    }

 
    private String getMenuOption() {
        
        Scanner keyboard = new Scanner(System.in); // get infile for keyboard
        String value = ""; // value to be returned
        boolean valid = false; // initialize to not valid
        
        while (!valid) { // loop while an invalid value is enter
            System.out.println("\n" + this.menu);
            
            value = keyboard.nextLine(); // get next line typed on keyboard
            value = value.trim(); // trim off leading and trailing blanks
            
            if (value.length() < 1) { // value is blank
                System.out.println("\nInvalid value: value can not be blank");
                continue;
            }
            
            break;  // end the loop 
        }
        
        return value; // return the value entered
    }    
    
    
    
    public boolean doAction(String choice) {
        
        choice = choice.toUpperCase(); // convert choice to upper case
        
        switch (choice) {
            case "N": // create and start a new game
                this.startNewGame();
                break;
            case "G": // get and start an existing game
                this.startExistingGame();
                break;
            case "H": // display the help menu
                this.displayHelpMenu();
                break;
            case "S": // save the current game
                this.saveGame();               
                break;
            default:
                System.out.println("\n*** Invalid selection *** Try again");
                break;
        }
        
        return false;
    }
     

    private void startNewGame() {
        
        System.out.println("\n *** startNewGame() function called ***");
//        // create a new game
//        GameControl.createNewGame(CuriousWorkmanship.getPlayer());
//
//        // display the game menu
//        GameMenuView gameMenu = new GameMenuView();
//        gameMenu.displayMenu();
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
        String filePath = this.getMenuOption();
        
        // save the game to the speciried file
        ProgramControl.saveGame(CuriousWorkmanship.getCurrentGame(), filePath);
    }

    private void displayHelpMenu() {
        HelpMenuView helpMenu = new HelpMenuView();
        helpMenu.displayMenu();
    }


 

}
