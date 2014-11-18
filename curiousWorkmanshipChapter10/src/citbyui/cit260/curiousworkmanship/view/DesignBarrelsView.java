/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package citbyui.cit260.curiousworkmanship.view;

import citbyui.cit260.curiousworkmanship.control.BarrelControl;
import citbyui.cit260.curiousworkmanship.control.Constants;
import citbyui.cit260.curiousworkmanship.control.GameControl;
import citbyui.cit260.curiousworkmanship.control.MapControl;
import citbyui.cit260.curiousworkmanship.exceptions.BarrelControlException;
import citbyui.cit260.curiousworkmanship.exceptions.MapControlException;
import citbyui.cit260.curiousworkmanship.exceptions.ViewException;
import citbyui.cit260.curiousworkmanship.model.ActorOld;
import citbyui.cit260.curiousworkmanship.model.Barrel;
import citbyui.cit260.curiousworkmanship.model.InventoryItem;
import curiousworkmanship.CuriousWorkmanship;
import java.awt.Point;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jacksonrkj
 */
public class DesignBarrelsView extends View {
   
    public DesignBarrelsView() {
        super("\n"
            + "\n---------------------------------------------"
            + "\n| Select actor to move                       |"
            + "\n---------------------------------------------"
            + "\nG - Grain"
            + "\nL - Legumes"
            + "\nO - Oil"
            + "\nW - Water"
            + "\nH - Honey"
            + "\nS - Salt"
            + "\nQ - Quit to main main menu"
            + "\n---------------------------------------------");
    }


    @Override
    public boolean doAction(String choice) {
        int inventoryType; 
        
        choice = choice.trim().toUpperCase(); // trim blanks and uppercase
        
        // check for valid actor
        switch (choice) {
            case "G":
                inventoryType = Constants.ITEM_GRAIN;
                break;
            case "L":
                inventoryType = Constants.ITEM_LEGUME;
                break;   
            case "O":
                inventoryType = Constants.ITEM_OIL;
                break;  
            case "W":
                inventoryType = Constants.ITEM_WATER;
                break; 
            case "H":
                inventoryType = Constants.ITEM_HONEY;
                break; 
            case "S":
                inventoryType = Constants.ITEM_SALT;
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
                // prompt for and get the row and column numbers
                System.out.println("\nEnter the width and height of the barrel in inches (e.g., 9 18)");
                Point dimensions = this.getDimensions(); // get the row and column
                if (dimensions == null) // entered "Q" to quit
                    break;
                
                // move actor to specified location
                InventoryItem inventoryItem = BarrelControl.designBarrel(inventoryType, dimensions.x, dimensions.y);
                
                System.out.println(  "\n A barrel "         
                                   + dimensions.x + " x " + dimensions.y + " inches "
                                   + " has been for " + "inventoryItem " + inventoryItem.getDescription());
                done = true;
            } catch (ViewException | BarrelControlException ex) {
                    System.out.println(ex.getMessage());
            }   
        } while (!done);

        return false;  
    }
    
    public Point getDimensions() throws ViewException {
        
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
    
}
