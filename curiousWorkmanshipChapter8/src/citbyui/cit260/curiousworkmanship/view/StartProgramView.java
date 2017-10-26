/**
 * View class for Start program end user story
 */
package citbyui.cit260.curiousworkmanship.view;

import citbyui.cit260.curiousworkmanship.control.ProgramControl;
import citbyui.cit260.curiousworkmanship.model.Player;
import java.util.Scanner;

public class StartProgramView extends View {

    public StartProgramView() {
    }

    @Override
    public String[] getInputs() {
        String[] inputs = new String[1];

        System.out.println(
                "\n\n*********************************************"
                + "\n*                                           *"
                + "\n* This is the game of Curious Workmanship   *"
                + "\n* In this game you will help Nephi build a  *"
                + "\n* shiop of curious workmanship to travel to *"
                + "\n* the promised land.                        *"
                + "\n*                                           *"
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
                + "\n* tools need to build the ship.             *"
                + "\n*                                           *"
                + "\n* Good luck and have fun in this adventure. *"
                + "\n*                                           *"
                + "\n*********************************************"
        );
        
        inputs[0] = this.getInput("Enter the playes name");
        
        return inputs;
                
    }



    @Override
    public boolean doAction(String[] inputs) {
        String playersName = inputs[0];
        if (playersName.toUpperCase().equals("Q")) // user wants to quit
        {
            return true; // exit the game
        }
        // Create the player object and save it in the ProgramControl class
        Player player = ProgramControl.createPlayer(playersName);

        // Display a personalized welcome message
        this.displayWelcomeMessage(player);

        // Display the Main menu.
        MainMenuView mainMenuView = new MainMenuView();
        mainMenuView.display();

        return true;
    }

    public void displayWelcomeMessage(Player player) {
        System.out.println("\n\n=============================================");
        System.out.println("\tWelcome to the game " + player.getName());
        System.out.println("\tWe hope you have a lot of fun!");
        System.out.println("=============================================");

    }


}
