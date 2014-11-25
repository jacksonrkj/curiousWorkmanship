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
public abstract class View implements ViewInterface {
    
    private String message;
    private final Scanner keyboard = new Scanner(System.in);

    public View() {
    }

    public View(String menu) {
        this.message = menu;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    
    
    public void display() {
        String value;
        boolean done = false;
        
        do { 
            System.out.println(this.message); // display the prompt message
            value = this.getInput(); // get the user's selection
            done = this.doAction(value); // do action based on selection        
        } while (!done);
            
        

    }
    
    
    public String getInput() {

        boolean valid = false;
        String selection = null;

        // while a valid name has not been retrieved
        while (!valid) {

            // get the value entered from the keyboard
            selection = keyboard.nextLine();
            selection = selection.trim();

            if (selection.length() < 1) { // blank value entered
                ErrorView.display(this.getClass().getName(), "You must enter a value.");
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
