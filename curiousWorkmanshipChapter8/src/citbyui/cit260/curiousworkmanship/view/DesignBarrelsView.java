/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package citbyui.cit260.curiousworkmanship.view;

import citbyui.cit260.curiousworkmanship.control.InventoryControl;
import citbyui.cit260.curiousworkmanship.enums.Item;
import java.awt.Point;

/**
 *
 * @author jacksonrkj
 */
public class DesignBarrelsView extends View {
   
    public DesignBarrelsView() {
        super();
    }


    @Override
    public String[] getInputs() {
        String[] inputs = new String[4];

        System.out.println(
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
        );

        boolean valid = false;
        do {
            inputs[0] = this.getInput("\nEnter a menu item").toUpperCase();
            if (inputs[0].equals("Q")) {
                return null;
            }
            
            String[] menu = {"G", "L", "O", "W", "H", "S"};          
            valid = this.validMenuItem(menu, inputs[0]);
            if (!valid) {
                System.out.println("\n*** Invalid menu item.");
            }

        } while (!valid);

        inputs[1] = this.getInput("\nEnter the diameter of the barrel in inches: ");
        if (inputs[1].toUpperCase().equals("Q")) {
            return null;
        }
        
        inputs[2] = this.getInput("\nEnter the height of the barrel in inches: ");
        if (inputs[2].toUpperCase().equals("Q")) {
            return null;
        }
        
        inputs[3] = this.getInput("\nEnter the number barrel to build");
        if (inputs[3].toUpperCase().equals("Q")) {
            return null;
        }

        return inputs;
    }
    
    
    private boolean validMenuItem(String[] menuItems, String menuItem) {

        for (int i = 0; i < menuItems.length; i++) {
            if (menuItem.toUpperCase().equals(menuItems[i])) {
                return true;
            }
        }
        return false;
    }


    @Override
    public boolean doAction(String[] inputs) {
        
        Item item; 
        
        String choice = inputs[0].trim().toUpperCase(); // trim blanks and uppercase
        
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
        
        double diameter = Double.parseDouble(inputs[1]);
        double height = Double.parseDouble(inputs[2]);
        int noOfBarrels = Integer.parseInt(inputs[3]);
        
        int returnValue = InventoryControl.buildBarrels(item, diameter, height, noOfBarrels);
        switch (returnValue) {
            case -1:
                System.out.println("\n***Invalid diameter");
                return false;
            case -2:
                System.out.println("\n***Invalid height");
                return false;
            case -3:
                System.out.println("\n***Invalid number of barrels");
                return false;
            case -4:
                System.out.println("\n***The barrel is too large for a human being to handle");
                return false;
            default:
                System.out.println("\n" + noOfBarrels + " " + item 
                                   + " barrels were successfully built and "
                                   + "added to the warehouse inventory.");
                return true;
        }

    }
    
   
    
}
