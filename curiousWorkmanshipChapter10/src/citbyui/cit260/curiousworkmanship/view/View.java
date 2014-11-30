/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package citbyui.cit260.curiousworkmanship.view;

import curiousworkmanship.CuriousWorkmanship;
import java.io.BufferedReader;
import java.io.PrintWriter;

/**
 *
 * @author jacksonrkj
 */
public abstract class View implements ViewInterface {
    
    private String message;
    protected final BufferedReader keyboard = CuriousWorkmanship.getInFile();
    protected final PrintWriter console = CuriousWorkmanship.getOutFile();

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
            console.println(this.message); // display the prompt message
            value = this.getInput(); // get the user's selection
            done = this.doAction(value); // do action based on selection        
        } while (!done);
            
        

    }
    
    
    @Override
    public String getInput() {

        boolean valid = false;
        String selection = null;
        try {
            // while a valid name has not been retrieved
            while (!valid) {

                // get the value entered from the keyboard
                selection = keyboard.readLine();
                selection = selection.trim();

                if (selection.length() < 1) { // blank value entered
                    ErrorView.display(this.getClass().getName(), "You must enter a value.");
                    continue;
                }

                break;
            }
        } catch (Exception e) {
            ErrorView.display(this.getClass().getName(), 
                              "Error reading input: " + e.getMessage());
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
            ErrorView.display(this.getClass().getName(), 
                              "Error clearing the console: " + e.getMessage());
        }
    }
   
    
}
