/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package citbyui.cit260.curiousworkmanship.view;

import citbyui.cit260.curiousworkmanship.control.InventoryControl;

/**
 *
 * @author jacksonrkj
 */
public class DesignBarrelsViewNew extends ViewNew {
   
    public DesignBarrelsViewNew() {
    }

    @Override
    public String[] getInputs() {
        
        String[] inputs = new String[4];
        
        String promptMessage =   
              "\n"
            + "\n---------------------------------------------------------------"
            + "\n| Select inventory item that you need to build the barrels for|"
            + "\n---------------------------------------------------------------"
            + "\nG - Grain"
            + "\nL - Legumes"
            + "\nO - Oil"
            + "\nW - Water"
            + "\nH - Honey"
            + "\nS - Salt"
            + "\nQ - Quit to main main menu"
            + "\n---------------------------------------------------------------"
            + "\n\nSelect and enter a menu item: ";
            
        boolean valid = false;
        do {
            String menuItem = this.getInput(promptMessage).toUpperCase();
            switch (menuItem) {
                case "G":
                case "L":   
                case "O":  
                case "W": 
                case "H": 
                case "S": 
                    inputs[0] = menuItem;
                    valid = true;
                    break;
                case "Q":
                    inputs[0] = menuItem;
                    return inputs;
                default:
                    ErrorView.display("DesignBarrelsView", "Invalid selection. Try again");
            } 
        } while(!valid);
        
        
        promptMessage = "Enter the height of the barrel in inches: ";
        inputs[1] = this.getInput(promptMessage);
        
        promptMessage = "Enter the diameter of the barrel in inches: ";
        inputs[2] = this.getInput(promptMessage);
        
        promptMessage = "Enter the number of barrels to build: ";
        inputs[3] = this.getInput(promptMessage);
        
        return inputs;
    }
    
    
    @Override
    public boolean doAction(String[] inputs) {

        int diameter;
        int height;
        int noOfBarrels;
        
        try { // convert diameter, height and noOfBarrels to integers
            diameter = Integer.parseInt(inputs[1]);
            height = Integer.parseInt(inputs[2]);
            if (diameter <= 0 || height <= 0) {
                ErrorView.display("DesignBarrelsView", 
                      "The diameter and height must be greater than zero.");
                return false;
            }
            
            noOfBarrels = Integer.parseInt(inputs[3]);

        } catch (NumberFormatException nf) {
            ErrorView.display("DesignBarrelsView", 
                    "You must enter a valid whole number for the diameter,"
                  + " height and number of barrels.");
            return false;
        } 

        // call the control function to build the barrels
        int numberOfBarrels = InventoryControl.buildBarrels(inputs[0], diameter, height, noOfBarrels);
        
        if (numberOfBarrels <  0) {
            return false;
        }
        
        this.console.println("\n" + numberOfBarrels
                           + " barrels were successfully built and"
                           + " added to the warehouse inventory.");
        return true; 
    }

    
}
