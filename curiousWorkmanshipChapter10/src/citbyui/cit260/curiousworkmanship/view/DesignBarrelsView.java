/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package citbyui.cit260.curiousworkmanship.view;

import citbyui.cit260.curiousworkmanship.enums.Item;
import citbyui.cit260.curiousworkmanship.exceptions.ViewException;
import java.awt.Point;

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
                System.out.println("Invalid selection");
                return false;
        }
        
        
        boolean done = false;
        do {
            try {
                // prompt for and get the dimension of the barrel
                System.out.println("\nEnter the diameter and heigth  of the barrel in inches (e.g., 12 18)");
                Point coordinates = this.getCoordinates(); // get the dimensions
                if (coordinates == null) // entered "Q" to quit
                    break;
                
                // get the number of barrels to be built
                System.out.println("\nEnter the number of barrels to be built");
                Double numberOfBarrels = this.getDoubleNumber();
                if (numberOfBarrels == null)  // entered "Q" to quit
                    break;
                
                // call control function to build barrels and add to inventory
                
                System.out.println("\n" + numberOfBarrels + " " + item 
                                   + " barrels were successfully built and "
                                   + "added to the warehouse inventory.");
                done = true;
                
            } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                    return false;
            }       
        } while (!done);

        return false;  
    }
    
    public Point getCoordinates() throws ViewException {
        
        String value = this.getInput();
        value = value.trim().toUpperCase();
        if (value.equals("Q"))
            return null;

        //tokenize values int string
        String[] values = value.split(" ");

        if (values.length < 2) {
            throw new ViewException("You must enter both a row and column number.");
        }

        // parse out row and column numbers
        try {
            int row = Integer.parseInt(values[0]);
            int column = Integer.parseInt(values[1]);
            return new Point(row, column);

        } catch (NumberFormatException nf) {
            throw new ViewException("The row or column number is not a  number.");
        }        
    }
    
    public Double getDoubleNumber() throws ViewException {
        Double number = null;
        
        while (number == null) {
            String value = this.getInput();
            value = value.trim().toUpperCase();
            
            if (value.equals("Q")) 
                break;

            try {
                // parse and convert number from text to a double
                number = Double.parseDouble(value);
                
            } catch (NumberFormatException nf) {
                
                System.out.println("\nYou must enter a valid number."
                        + " Try again or enter Q to quit.");
                
            }        
        }
        
        return number;
    }
    
}
