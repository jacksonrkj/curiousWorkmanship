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
public abstract class ViewNew implements ViewInterfaceNew {
    
    protected final BufferedReader keyboard = CuriousWorkmanship.getInFile();
    protected final PrintWriter console = CuriousWorkmanship.getOutFile();

    public ViewNew() {
    }
    
    public void display() {
        boolean endView = false;
        
        do {   
            // get inputs
            String[] inputs = this.getInputs();
            
            if (inputs[0] == null || inputs[0].equals("Q")) {
                return;
            }
            
            // doAction
            endView = this.doAction(inputs); // do action based on selection  
            
        } while (!endView);

    }
    
    public String getInput(String promptMessage) {

        boolean valid = false;
        String value = null;
        try {
            // while a valid name has not been retrieved
            while (!valid) {
                this.console.println(promptMessage); // display the prompt promptMessage
                
                // get the value entered from the keyboard
                value = this.keyboard.readLine();
                value = value.trim();

                if (value.length() < 1) { // blank value entered
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

        return value; // return the name        
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
