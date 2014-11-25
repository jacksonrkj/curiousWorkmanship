/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package citbyui.cit260.curiousworkmanship.view;

import citbyui.cit260.curiousworkmanship.enums.Item;
import citbyui.cit260.curiousworkmanship.exceptions.ViewException;
import java.awt.Dimension;

/**
 *
 * @author jacksonrkj
 */
public class DesignBarrelsView extends View {
   
    public DesignBarrelsView() {
        super("\n"
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
            + "\n---------------------------------------------------------------");
    }


    @Override
    public boolean doAction(String choice) {
        Item item; 
        
        choice = choice.trim().toUpperCase(); // trim blanks and uppercase
        
        // check for valid actor
        switch (choice) {
            case "G":
                item = Item.grain;
                break;
            case "L":
                item = Item.legume;
                break;   
            case "O":
                item = Item.oil;
                break;  
            case "W":
                item = Item.water;
                break; 
            case "H":
                item = Item.honey;
                break; 
            case "S":
                item = Item.salt;
                break; 
            case "Q":
                return true;
            default:
                ErrorView.display("DesignBarrelsView", "Invalid selection. Try again");
                return false;
        }
        
        boolean returnValue = this.designBarrels(item); 

        return returnValue;  
    }
    
    private boolean designBarrels(Item item) {
        try {
            // prompt for and get the dimension of the barrel
            Dimension dimensions = this.getDimensions(); // get the dimensions
            if (dimensions == null) // entered "Q" to quit
                return false;

            // get the number of barrels to be built
            Double numberOfBarrels = this.getNumberOfBarrels();
            if (numberOfBarrels == null)  // entered "Q" to quit
                return false;

            // call control function to build barrels and add to inventory

            System.out.println("\n" + numberOfBarrels + " " + item 
                               + " barrels were successfully built and "
                               + "added to the warehouse inventory.");

        } catch (Exception ex) {
                ErrorView.display("DesignBarrelsView", ex.getMessage());
                return false;
        }       
        
        return true;
    }
    
    public Dimension getDimensions() throws ViewException {
        Dimension dimensions = null;
        
        do {  
            // prompt for and get the dimension of the barrel
            System.out.println("\nEnter the diameter and heigth  of the barrel in inches (e.g., 12 18)");
            
            String value = this.getInput();
            value = value.trim().toUpperCase();
            if (value.equals("Q"))
                return null;

            //tokenize values int string
            String[] values = value.split(" ");

            if (values.length < 2) {
                ErrorView.display("DesignBarrelsView", 
                      "You must enter the diameter and height of the barrel .");
                continue;
            }

            // parse out row and column numbers
            try {
                int diameter = Integer.parseInt(values[0]);
                int height = Integer.parseInt(values[1]);
                if (diameter <= 0 || height <= 0) {
                    ErrorView.display("DesignBarrelsView", 
                          "The diameter and height must be greater than zero.");
                    continue;
                }
                
                dimensions = new Dimension(diameter, height);

            } catch (NumberFormatException nf) {
                ErrorView.display("DesignBarrelsView", 
                        "The diamter or height is not a  number.");
            } 
        
        } while(dimensions == null);

        return dimensions;
    }
    
    public Double getNumberOfBarrels() throws ViewException {
        Double number = null;
        
        while (number == null) {
            System.out.println("\nEnter the number of barrels to be built");
            
            String value = this.getInput();
            value = value.trim().toUpperCase();
            
            if (value.equals("Q")) 
                return null;

            try {
                // parse and convert number from text to a double
                double dblValue = Double.parseDouble(value);
                if (dblValue < 1) {
                    ErrorView.display("DesignBarrelsView", 
                      "The number of barrels must be greater than or equal to one");
                    continue;
                }
                
                number = dblValue;
                
            } catch (NumberFormatException nf) {
                ErrorView.display("DesignBarrelsView", 
                        "You must enter a valid number greater than zero.");
            }        
        }
        
        return number;
    }
    
}
