/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package citbyui.cit260.curiousworkmanship.view;

import java.util.Scanner;


public class GameMenuView {

       private static final String MENU = "\n"
            + "\n-----------------------------------------"
            + "\n| Game Menu                             |"
            + "\n-----------------------------------------"  
            + "\nT - Travel to new location"
            + "\nV - View location"
            + "\nE - Estimate the resource needed"
            + "\nB - Design barrels"
            + "\nM - Manufacture items"
            + "\nR - Harvest resource"
            + "\nD - Deliver resource"
            + "\nW - Work on ship"
            + "\nI - View list of items in inventory"
            + "\nS - View ship status"
            + "\nP - Pack ship"
            + "\nJ - Launch ship"
            + "\nH - Help"
            + "\nQ - Quit"              
            + "\n-----------------------------------------";
    

    public void displayMenu() {
        
        boolean done = false;
        do {
            // display menu
            System.out.println(MENU);
            
            char selection = this.getInput();

            // get selection and take the appropriate action
            done = this.doAction(selection);
        } while(!done);
        
        
        
    }
    
    
    public boolean doAction(char selection) {
        int returnValue = -1; // set default to indicate an error
        
        switch (selection) {
            case 'T': // Travel to new location
                returnValue = this.moveToLocation(); 
                break;
            case 'V': // View location
                returnValue = this.viewLocation(); 
                break;
            case 'E': // Estimate the resource needed
                returnValue = this.estimateResources();
            case 'B': // Design barrels
                returnValue = this.designBarrels(); 
                break;
            case 'M': // Manufacture items
                returnValue = this.manufactureItems(); 
                break;
            case 'R': // Harvest resource
                returnValue = this.harvestResources(); 
                break;
            case 'D': // Deliver resource
                returnValue = this.deliverResources(); 
                break;
            case 'W': // Work on ship
                returnValue = returnValue = this.workOnShip();
                break;
            case 'I': // View list of items in inventory
                returnValue = this.viewInventory(); 
                break;
            case 'P': // Pack ship
                returnValue = this.packShip(); 
                break;
            case 'J': // Launch ship
                returnValue = this.launchShip();      
                break;
            case 'H': // display the help menu
                HelpMenuView helpMenu = new HelpMenuView();
                helpMenu.displayMenu();
                break;
            case 'Q':
                return true;

            default:
                System.out.println("\n*** Invalid selection *** Try again");
        }
       
        return false;
        
    }
    
    private char getInput() {
        
        Scanner keyboard = new Scanner(System.in);
        boolean valid = false;
        String strValue;
        char selection = ' ';    
        
        // while a valid name has not been retrieved
        while(!valid) {
            
            // prompt for the player's name
            System.out.println("\t\nEnter your selection below:");
        
            // get the value entered from the keyboard
            strValue = keyboard.nextLine(); 
            
            if (strValue.trim().length() < 1) { // blank value entered
                // display and error
                System.out.println("\n*** Invalid selection *** Try again");
            }
            
            selection = strValue.trim().toUpperCase().charAt(0);
            
            // signal that a valid name was entered
            valid = true;            
        }
        
        return selection; // return the name        
    }

    private int moveToLocation() {
        System.out.println("--- moveToLocation Called ---");
        return 0;
    }

    private int viewLocation() {
        System.out.println("--- moveToLocation Called ---");
        return 0;
    }

    private int estimateResources() {
        System.out.println("--- moveToLocation Called ---");
        return 0;
    }

    private int designBarrels() {
        System.out.println("--- moveToLocation Called ---");
        return 0;
    }

    private int manufactureItems() {
        System.out.println("--- moveToLocation Called ---");
        return 0; 
    }
    
    private int harvestResources() {
        System.out.println("--- moveToLocation Called ---");
        return 0;
    }

    private int deliverResources() {
        System.out.println("--- moveToLocation Called ---");
        return 0;
    }

    private int workOnShip() {
        System.out.println("--- moveToLocation Called ---");
        return 0;
    }

    private int viewInventory() {
        System.out.println("--- moveToLocation Called ---");
        return 0;
    }

    private int packShip() {
        System.out.println("--- moveToLocation Called ---");
        return 0;
    }

    private int launchShip() {
        System.out.println("--- moveToLocation Called ---");
        return 0;
    }
             
    
}
