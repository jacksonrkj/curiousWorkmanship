/**
 * View class for Start program end user story
 */

package citbyui.cit260.curiousworkmanship.view;

import citbyui.cit260.curiousworkmanship.control.ProgramControl;
import citbyui.cit260.curiousworkmanship.model.Player;
import java.util.Scanner;

public class StartProgramView implements ViewInterface {
    
    
    public StartProgramView() {       
    }

    public void display() {

        // Display the banner screen
        this.displayBanner();
        
        // prompt the player to enter their name Retrieve the name of the player
        String playersName = this.getInput();
        
        this.doAction(playersName);
        
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
    
    public String getInput() {
        boolean valid = false; // indicates if the name has be retrieved
        String playersName = null;
        Scanner keyboard = new Scanner(System.in); // keyboard input stream
        
        
        while(!valid) { // while a valid name has not been retrieved
            
            // prompt for the player's name
            System.out.println("Enter the player's name below:");
        
            // get the name from the keyboard and trim off the blanks
            playersName = keyboard.nextLine();
            playersName = playersName.trim(); 
            
            // if the name is invalid (less than one character in length)) 
            if (playersName.length() < 2) {
                System.out.println("Invalid name - the name must not be blank");
                continue; // and repeat again
            }
            break; // out of the (exit) the repetition
        }
        
        return playersName; // return the name        
    }
    
    
    
    public void displayWelcomeMessage(Player player) {
        System.out.println("\n\n=============================================");         
        System.out.println("\tWelcome to the game " + player.getName());
        System.out.println("\tWe hope you have a lot of fun!");
        System.out.println("=============================================");
       
    }

    @Override
    public boolean doAction(String playersName) {
        if (playersName.toUpperCase().equals("Q")) // user wants to quit
            return true; // exit the game
        
        // Create the player object and save it in the ProgramControl class
        Player player = ProgramControl.createPlayer(playersName);
       
        // Display a personalized welcome message
        this.displayWelcomeMessage(player);
        
        // Display the Main menu.
        MainMenuView mainMenuView = new MainMenuView();
        mainMenuView.display();
        
        return true;
    }
    
 
    
    
}
