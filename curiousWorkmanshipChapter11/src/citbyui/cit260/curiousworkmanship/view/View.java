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
    
    protected String promptMessage;
    private boolean input = true;
    
    protected final BufferedReader keyboard = CuriousWorkmanship.getInFile();
    protected final PrintWriter console = CuriousWorkmanship.getOutFile();

    public View() {
        this.input = true;
    }
    
    public View(boolean input, String message) {
        this.input = input;
        this.promptMessage = message;
    }

    public View(String message) {
        this.promptMessage = message;
        this.input = true;
    }

    public String getPromptMessage() {
        return promptMessage;
    }

    public void setPromptMessage(String message) {
        this.promptMessage = message;
    }
    
    
    public void display() {
        String value = "";
        boolean done = false;
        
        do { 
            
            if (this.input) {
                value = this.getInput(); // get the user's selection
            }
            if (value.toUpperCase().equals("Q")) // user wants to quit
                return; // exit the view
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
                this.console.println(this.promptMessage); // display the prompt promptMessage
                
                // get the value entered from the keyboard
                selection = this.keyboard.readLine();
                selection = selection.trim();

                if (selection.length() < 1) { // blank value entered
                    ErrorView.display(this.getClass().getName(), 
                                      "You must enter a value.");
                    continue;
                }

                break;
            }
        } catch (Exception e) {
            ErrorView.display(this.getClass().getName(), 
                              "Error reading input: " + e.getMessage());
            return null;
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
   
    
    public String getBlockedMessage(String message) {
        String newMessage = "";
        int noOfLines = (message.length() / 81) + 1;
        String[] words = message.split(" ");
        String line = "";
        
        for (String word : words) {
            
            if (line.length() + word.length() < 80) {
                line += word.trim() + " ";
            }
            else {
                newMessage += line + "\n";
                line = word.trim() + " ";
            }
        }
        newMessage += line;
        
        
        return newMessage;
        
        
    }
    
    
}
