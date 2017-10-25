/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package citbyui.cit260.curiousworkmanship.view;

import citbyui.cit260.curiousworkmanship.control.GameControl;
import citbyui.cit260.curiousworkmanship.model.Location;
import citbyui.cit260.curiousworkmanship.model.SceneType;
import citbyui.cit260.curiousworkmanship.model.Player;
import citbyui.cit260.curiousworkmanship.model.Scene;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author jacksonrkj
 */
public class StartProgramView extends View {
        
    

    public StartProgramView() {
        super( 
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
              + "\n\nPlease enter your name:                    "
              );
    }




    
    @Override
    public boolean doAction(String playersName) {
        
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
        mainMenuView.display();    
    }


}
