/**
 * View class for Start program end user story
 */

package citbyui.cit260.curiousworkmanship.view;

import citbyui.cit260.curiousworkmanship.control.Controls;
import citbyui.cit260.curiousworkmanship.model.Player;
import java.util.Scanner;

public class StartProgramView {
    
    public StartProgramView() {       
    }

    
    public void startProgram() {
        
        
        // Display the banner screen
        this.displayBanner();
        
        // prompt the player to enter their name Retrieve the name of the player
        String playersName = this.getPlayersName();
        if (playersName == null) // user wants to quit
            return; // exit the game
        
        // Create the player object and save it in the ProgramControl class
        Player player = new Player();
        player.setName(playersName);
        Controls.getProgramControl().setPlayer(player);
       
        // Display a personalized welcome message
        this.displayWelcomeMessage(playersName);
        
        // Display the Main menu.
        MainMenuView mainMenuView = new MainMenuView();
        mainMenuView.displayMainMenu();
        
    }
    
    public void displayBanner() {
        System.out.println("\n\n*********************************************");
        
        System.out.println("*                                           *"
                       + "\n* This is the game of Curious Workmanship   *"
                       + "\n* In this game you will help Nephi build a  *"
                       + "\n* shiop of curious workmanship to travel to *"
                       + "\n* the promised land.                        *");
        
        System.out.println("*                                           *"
                       + "\n* You and your family will need to first    *"
                       + "\n* plan for your trip determining and        *"
                       + "\n*and estimating the amount of resources     *"
                       + "\n*needed for the trip. Then you will have    *"
                       + "\n*to go out and search for and harvest       *"
                       + "\n*the needed resources and deliver them      *"
                       + "\n*to the warehouse where you will store      *"
                       + "\n*then until the ship is completed. Then     *"
                       + "\n* You will also need to build the ship,     *"
                       + "\n* load the ship and then set sail for       *"
                       + "\n* the promised land. You will first need    *"
                       + "\n* to find the resources and manufacture the *"
                       + "\n* tools need to build the ship.             *");
     
        System.out.println("*                                           *"
                       + "\n* Good luck and have fun in this adventure. *"
                       + "\n*                                           *");
        
        System.out.println("*********************************************");
        
    }
    
    public String getPlayersName() {
        boolean valid = false;
        String playersName = null;
        Scanner keyboard = new Scanner(System.in);
        
        // while a valid name has not been retrieved
        while( !valid) {
            
            // prompt for the player's name
            System.out.println("Enter the player's name below:");
        
            // get the name from the keyboard
            playersName = keyboard.nextLine();
            
            // if the name is invalid (non-blank and > two characters) then
            if (playersName.trim().length() < 2) {
                // display and error
                System.out.println("Invalid name - the name must be non blank "
                                 + "and greater than two characters");
            }
            
            if (playersName.toUpperCase().charAt(0) == 'Q') {
                return null;
            }
            
            // signal that a valid name was entered
            valid = true;            
        }
        
        return playersName; // return the name        
    }
    
    public void displayWelcomeMessage(String name) {
        System.out.println("\n\n=============================================");         
        System.out.println("\tWelcome to the game " + name);
        System.out.println("\tWe hope you have a lot of fun!");
        System.out.println("=============================================");
    }
    
 
    
    
}
