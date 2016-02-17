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
public abstract class MenuView implements MenuInterface {
    
    private String menu;

    public MenuView() {
    }

    public MenuView(String menu) {
        this.menu = menu;
    }
    
    public void displayMenu() {

        char selection = ' ';
        do { 
            
            System.out.println(this.menu); // display the main menu

            String input = this.getInput(); // get the user's selection
            selection = input.charAt(0); // get first character of string

            this.doAction(selection); // do action based on selection
            
        } while (selection != 'Q'); // an selection is not "Exit"

    }
    
    
    public String getInput() {

        Scanner keyboard = new Scanner(System.in);
        boolean valid = false;
        String selection = null;

        // while a valid name has not been retrieved
        while (!valid) {

            // prompt for the player's name
            System.out.println("\t\nEnter your selection below:");

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
