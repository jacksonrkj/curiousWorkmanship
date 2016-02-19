/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package citbyui.cit260.curiousworkmanship.view;

import citbyui.cit260.curiousworkmanship.control.GameControl;
import citbyui.cit260.curiousworkmanship.model.Player;
import java.util.Scanner;

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
        
        System.out.println( 
                "\n***********************************************"
              + "\n*                                             *"
              + "\n* This is the game of Curious Workmanship     *"
              + "\n* In this game you will help Nephi build a    *"
              + "\n* shiop of curious workmanship to travel to   *"
              + "\n* the promised land.                          *"
              + "\n*                                             *"
              + "\n* You and your family will need to first      *"
              + "\n* plan for your trip determining and          *"
              + "\n* and estimating the amount of resources      *"
              + "\n* needed for the trip. Then you will have     *"
              + "\n* to go out and search for and harvest        *"
              + "\n* the needed resources and deliver them       *"
              + "\n* to the warehouse where you will store       *"
              + "\n* then until the ship is completed. Then      *"
              + "\n* You will also need to build the ship,       *"
              + "\n* load the ship and then set sail for         *"
              + "\n* the promised land. You will first need      *"
              + "\n* to find the resources and manufacture the   *"
              + "\n* tools need to build the ship.               *"
              + "\n                                              *"
              + "\n* Good luck and have fun in this adventure.   *"
              + "\n*                                             *"
              + "\n***********************************************"
              );
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
        
        Scanner keyboard = new Scanner(System.in); // get infile for keyboard
        String value = ""; // value to be returned
        boolean valid = false; // initialize to not valid
        
        while (!valid) { // loop while an invalid value is enter
            System.out.println("\n" + this.promptMessage);
            
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
