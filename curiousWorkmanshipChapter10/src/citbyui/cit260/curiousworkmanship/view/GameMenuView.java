/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package citbyui.cit260.curiousworkmanship.view;

import citbyui.cit260.curiousworkmanship.control.GameControl;
import citbyui.cit260.curiousworkmanship.model.InventoryItem;
import citbyui.cit260.curiousworkmanship.model.Location;
import citbyui.cit260.curiousworkmanship.model.Scene;


public class GameMenuView extends View {

    public GameMenuView() {
        super("\n"
            + "\n---------------------------------------------"
            + "\n| Game Menu                                 |"
            + "\n---------------------------------------------"
            + "\nV - View map"
            + "\nI - View list of items in inventory"
            + "\nA - View list of actors"
            + "\nS - View the ship's status"
            + "\nL - View location"
            + "\nM - Move actor to a new location"
            + "\nE - Estimate the resources needed for trip"
            + "\nB - Design barrels to hold resources"
            + "\nC - Construct tools and items needed"
            + "\nR - Harvest resource at location"
            + "\nD - Deliver harvested resources to warehouse"
            + "\nW - Work on ship"
            + "\nP - Pack ship for journey"
            + "\nJ - Launch ship to the promised land"
            + "\nH - Display help menu"
            + "\nQ - Quit"
            + "\n---------------------------------------------");
    }
  
    
    
    public boolean doAction(String value) {
        
        value = value.toUpperCase(); // convert to all upper case
        char choice = value.charAt(0); // get first character entered
     
        switch (choice) {
            case 'V': // Travel to new location
                this.displayMap(); 
                break;
            case 'I': // View list of items in inventory
                this.viewInventory(); 
                break;
            case 'A': // View list of actors
                this.viewActors(); 
                break;
            case 'S': // View the ship's status
                this.viewShipStatus(); 
                break;
            case 'L': // View description of location
                this.viewLocation(); 
                break;    
            case 'M': // Move actor to new location
                this.moveToLocation(); 
                break;                
            case 'E': // Estimate the resource needed
                this.estimateResources();
                break;
            case 'B': // Design barrels
                this.designBarrels(); 
                break;
            case 'C': // Construct tools and other items
                this.manufactureItems(); 
                break;
            case 'R': // Harvest resource
                this.harvestResources(); 
                break;
            case 'D': // Deliver resource
                this.deliverResources(); 
                break;
            case 'W': // Work on ship
                this.workOnShip();
                break;
            case 'P': // Pack ship
                this.packShip(); 
                break;
            case 'J': // Launch ship
                this.launchShip();      
                break;
            case 'H': // display the help menu
                this.displayHelpMenu();
                break;
            case 'Q':
                return true;
            default:
                System.out.println("\n*** Invalid selection *** Try again");
        }
        return false;
    }
    
    public void displayMap() {
        int lineLength = 0;
        
        // get the map for the game
        Location[][] locations = GameControl.getMapLocations();
        int noColumns = locations[0].length; // get number columns in row
        
        this.printTitle(noColumns, "THE LAND OF BOUNTIFUL");
        this.printColumnHeaders(noColumns);
        
        for (int i = 0; i < locations.length; i++) {    
            Location[] rowLocations = locations[i];
            this.printRowDivider(noColumns);
            System.out.println(); // move down one i
            if (i < 9)
                System.out.print(" " + (i+1));
            else 
                System.out.print(i+1);
            
            // for every column in the row
            for (int column = 0; column < noColumns; column++) {
                System.out.print("|"); // print column divider
                Location location = rowLocations[column];
//                if (location.isVisited() || location == null) { // if location is visited 
//                    Scene scene = location.getScene();
//                    System.out.print(scene.getMapSymbol());
//                }
//                else {
//                    System.out.print(" ?? ");
//                }  
                
                Scene scene = location.getScene();
                System.out.print(scene.getMapSymbol());
                
            }
            System.out.print("|"); // print column divider
        }
        
        this.printRowDivider(noColumns);
    }  

    private void moveToLocation() {
        MoveActorView moveActorView = new MoveActorView();     
        moveActorView.display();     
    }

    private void viewLocation() {
        ViewLocationView viewLocationView = new ViewLocationView();
        viewLocationView.display();
    }

    private void estimateResources() {
        System.out.println("*** estimateResources stub function called ***");        
    }

    private void designBarrels() {
        System.out.println("*** designBarrels stub function called ***");
        
    }

    private void manufactureItems() {
        System.out.println("*** manufactureItems stub function called ***");         
    }
    
    private void harvestResources() {
        System.out.println("*** harvestResources stub function called ***");        
    }

    private void deliverResources() {
        System.out.println("*** deliverResources stub function called ***");        
    }

    private void workOnShip() {
        System.out.println("*** workOnShip stub function called ***");        
    }
    
    private void viewActors() {
        System.out.println("*** viewActors stub function called ***");       
    }

    private void viewShipStatus() {
        System.out.println("*** viewShipStatus stub function called ***");        
    }
    
    
    private void displayHelpMenu() {
        HelpMenuView helpMenu = new HelpMenuView();
        helpMenu.display(); 
    }

    private void viewInventory() {
        // get the sorted list of inventory items for the current game
        InventoryItem[] inventory = GameControl.getSortedInventoryList();
        
        System.out.println("\nList of Inventory Items");
        StringBuilder line = new StringBuilder("                                                          ");
        line.insert(0, "Description"); 
        line.insert(20, "Required");
        line.insert(30, "In Stock");
        System.out.println(line.toString());
        
        // for each inventory item
        for (InventoryItem inventoryItem : inventory) {
            line = new StringBuilder("                                                          ");
            line.insert(0, inventoryItem.getDescription());
            line.insert(23, inventoryItem.getRequiredAmount());
            line.insert(33, inventoryItem.getQuantityInStock());
            
            // DISPLAY the description, the required amount and amount in stock
            System.out.println(line.toString());
        }   
    }

    private void packShip() {
        System.out.println("*** packShip stub function called ***");       
    }

    private void launchShip() {
        System.out.println("*** launchShip stub function called ***");        
    }


    private void printColumnHeaders(int noOfColumns) {
        for (int i = 1; i < noOfColumns+1; i++) {
            if (i < 10) {
                System.out.print("   " + i + " ");
            }
            else {
                System.out.print("  " + i + " ");
            }
        }
    }

    private void printRowDivider(int noColumns) {
        System.out.println();
        System.out.print("  ");
        for (int i = 0; i < noColumns; i++) { // print row divider
                System.out.print("-----");
        }
        System.out.print("-");
    }

    private void printTitle(int noOfColumns, String title) {
        
        int titleLength = title.length();
        int lineLength = noOfColumns * 5 + 3;
        int startPosition = (lineLength / 2) - (titleLength / 2);
        System.out.println("\n");
        for (int i = 0; i < startPosition; i++) {
            System.out.print(" ");  
        }
        System.out.print(title);
        System.out.println("\n");
        
    }
    
}
