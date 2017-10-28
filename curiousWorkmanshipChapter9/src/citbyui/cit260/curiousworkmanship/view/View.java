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


    public View() {
    }
    
    @Override
    public void display() {
        String[] inputs = null;
        boolean endOfView = false;

        do {
            inputs = this.getInputs(); // get the user's selection
            if (  inputs == null
               || inputs.length < 1
               || inputs[0].toUpperCase().equals("Q")) {
                return;
            }
            endOfView = this.doAction(inputs); // do action based on selection

        } while (!endOfView);

    }

    @Override
    public String getInput(String promptMessage) {

        Scanner keyboard = new Scanner(System.in);
        boolean valid = false;
        String selection = null;

        // while a valid name has not been retrieved
        while (!valid) {
            System.out.println(promptMessage);
            
            // get the value entered from the keyboard
            selection = keyboard.nextLine();
            selection = selection.trim();

            if (selection.length() < 1) { // blank value entered
                System.out.println("\n*** You must enter a non-blank value");
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
