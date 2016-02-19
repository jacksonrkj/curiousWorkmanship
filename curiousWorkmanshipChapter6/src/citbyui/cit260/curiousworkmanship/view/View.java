/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package citbyui.cit260.curiousworkmanship.view;

import java.util.Scanner;

/**
 *
 * @author jacksonrkj
 */
public abstract class View implements MenuInterface {
    
    private String message;

    public View() {
    }

    public View(String message) {
        this.message = message;
    }
    
    public void displayMenu() {
        
        boolean done = false;
        do { 
            // prompt for and get players name
            String value = this.getInput();
            if (value.toUpperCase().equals("Q")) // user wants to quit
                return; // exit the game

            // do the requested action and display the next view
            done = this.doAction(value); 

        } while (!done);

    }
    
    
    public String getInput() {

        Scanner keyboard = new Scanner(System.in);
        boolean valid = false;
        String selection = null;

        // while a valid name has not been retrieved
        while (!valid) {

            // prompt for the player's name
            System.out.println("\t" + this.message);

            // get the value entered from the keyboard
            selection = keyboard.nextLine();
            selection = selection.trim();
            selection = selection.toUpperCase(); // convert to upper case

            if (selection.length() < 1) { // blank value entered
                System.out.println("\n*** Invalid selection *** Try again");
                continue;
            }
            
            break;

        }

        return selection; // return the name        
    }
    
    public void clearConsole() {
        try {
            final String os = System.getProperty("os.name");

            if (os.contains("Windows")) {
                Runtime.getRuntime().exec("cls");
            } else {
                Runtime.getRuntime().exec("clear");
            }
        } catch (final Exception e) {
            //  Handle any exceptions.
        }

    }

   
    
}
