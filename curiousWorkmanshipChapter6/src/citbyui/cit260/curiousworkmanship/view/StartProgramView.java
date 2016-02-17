/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package citbyui.cit260.curiousworkmanship.view;

import citbyui.cit260.curiousworkmanship.control.GameControl;
import citbyui.cit260.curiousworkmanship.model.Player;

/**
 *
 * @author jacksonrkj
 */
public class StartProgramView {
        
    private String promptMessage;
    
    public StartProgramView() {
        
        this.promptMessage = "\nPlease enter your name: "; 
        // display the banner when view is created
        this.displayBanner();
        
    }

    private void displayBanner() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    /**
     * displays the start program view
     */
    public void displayStartProgramView() {
        
        boolean done = false; // set flag to not done
        do { 
            // prompt for and get players name
            String playersName = this.getPlayersName();
            if (playersName.toUpperCase().equals("Q")) // user wants to quit
                return; // exit the game

            // do the requested action and display the next view
            done = this.doAction(playersName); 

        } while (!done);

    }

    private String getPlayersName() {
        return null;
        
    }
    
    

    private boolean doAction(String playersName) {
        
        if (playersName.length() < 2) {
            System.out.println("\nInvalid players name: "
                    + "The name must be greater than one character in length");
            return false;
        }
 
	// call createPlayer() control function
        Player player = GameControl.createPlayer(playersName);
        
        if (player == null) { // if unsuccessful 
            System.out.println("\nError creating the player.");
            return false;
        }
        
        // display next view
	this.displayNextView(player);

        return true; // success !  
    }

    private void displayNextView(Player player) {
        
        // display a custom welcome message
        System.out.println("\n============================================="
                          + "\n Welcome to the game " + player.getName()
                          + "\n We hope you have a lot of fun!"
                          + "\n============================================="
                          );
        
        // Create MainMenuView object
        MainMenuView mainMenuView = new MainMenuView();
                
        // Display the main menu view
        mainMenuView.displayMainMenuView();    
    }

}

