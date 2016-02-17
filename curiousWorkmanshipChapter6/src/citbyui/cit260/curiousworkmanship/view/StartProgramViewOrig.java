/**
 * View class for Start program end user story
 */

package citbyui.cit260.curiousworkmanship.view;

import citbyui.cit260.curiousworkmanship.control.ProgramControl;
import citbyui.cit260.curiousworkmanship.model.Player;
import java.util.Scanner;

public class StartProgramViewOrig {
    
    private String promptMessage;
    
    public StartProgramViewOrig() {
        
        this.promptMessage = "\nPlease enter your name: "; 
        this.displayBanner(); // display the banner when view is created
        
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
    
    public void displayBanner() {
        
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
 * Prompt for and get the players name
 * @return the name of the player
 */
public String getPlayersName() {

    Scanner keyboard = new Scanner(System.in); // keyboard input stream
    String value = "";

    boolean valid = false; // set flag to invalid value entered    
    while(!valid) { // while a valid name has not been retrieved

        // prompt for the player's name
        System.out.println(this.promptMessage);

        value = keyboard.nextLine(); // get the name from the keyboard
        value = value.trim(); // trim off the excess blanks

        // if the name is invalid (less than one character in length)) 
        if (value.length() < 1) {
            System.out.println("Invalid value - the value can not be blank");
            continue; // and repeat again
        }
        valid = true; // set flag to end repetition
    }

    return value; // return the value        
}

    
    
    /**
     * Create the player object and display a welcome message and the main menu
     * @param inputs The values entered by the end user
     * @return Returns true if successful. Returns false if player not created
     */ 
    public boolean doAction(Object inputs) {
        
        // type case inputs to a string
        String name = (String) inputs;
        
        // Call fthe control function to create the player
        Player player = ProgramControl.createPlayer(name);    
        
        if (player == null) {
            System.out.println("Not able to create the player");
            return false;
        }
        
        // display the next view
        this.displayWelcomeMessage(player); // display Welcome Message
        
        MainMenuView mainMenuView = new MainMenuView();
        mainMenuView.displayMenu(); // display main menu
        
        return true;

    }
    
    
    
    
    
    
    /**
     * Displays a custom welcome message
     * @param player The player object just created
     */
    public void displayWelcomeMessage(Player player) {
        System.out.println("\n\n=============================================");         
        System.out.println("\tWelcome to the game " + player.getName());
        System.out.println("\tWe hope you have a lot of fun!");
        System.out.println("=============================================");
       
    }
    
 
    
    
}
