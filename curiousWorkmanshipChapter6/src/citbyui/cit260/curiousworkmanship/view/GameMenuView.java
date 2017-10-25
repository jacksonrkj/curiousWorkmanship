/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package citbyui.cit260.curiousworkmanship.view;

import citbyui.cit260.curiousworkmanship.control.GameControl;
import citbyui.cit260.curiousworkmanship.control.MapControl;
import citbyui.cit260.curiousworkmanship.model.InventoryItem;
import citbyui.cit260.curiousworkmanship.model.Location;
import citbyui.cit260.curiousworkmanship.model.Scene;
import curiousworkmanship.CuriousWorkmanship;


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
            + "\nQ - Quit to main main menu"
            + "\n---------------------------------------------");
    }

   
    
    
    public boolean doAction(String selection) {
        selection = selection.toUpperCase();
        
        switch (selection) {
            case "V": // Travel to new location
                this.displayMap(); 
                break;
            case "I": // View list of items in inventory
                this.viewInventory(); 
                break;
            case "A": // View list of actors
                this.viewActors(); 
                break;
            case "S": // View the ship"s status
                this.viewShipStatus(); 
                break;
            case "L": // View description of location
                this.viewLocation(); 
                break;    
            case "M": // Move actor to new location
                this.moveToLocation(); 
                break;                
            case "E": // Estimate the resource needed
                this.estimateResources();
                break;
            case "B": // Design barrels
                this.designBarrels(); 
                break;
            case "C": // Construct tools and other items
                this.manufactureItems(); 
                break;
            case "R": // Harvest resource
                this.harvestResources(); 
                break;
            case "D": // Deliver resource
                this.deliverResources(); 
                break;
            case "W": // Work on ship
                this.workOnShip();
                break;
            case "P": // Pack ship
                this.packShip(); 
                break;
            case "J": // Launch ship
                this.launchShip();      
                break;
            case "H": // display the help menu
                this.displayHelpMenu();
                break;
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
        this.printColumnHeaders(noColumns);
        
        for (Location[] row : locations) { // for every row in the map           
            this.printRowDivider(noColumns);

            // for every column in the row
            for (int column = 0; column < noColumns; column++) {
                System.out.println("|"); // print column divider
                Location location = row[column];
                if (location.isVisited() || location == null) { // if location is visited 
                    Scene scene = location.getScene();
                    System.out.println(scene.getMapSymbol());
                }
                else {
                    System.out.println(" ?? ");
                }  
            }
            System.out.println("|"); // print column divider
        }
        
        this.printRowDivider(noColumns);
    }  

    private void moveToLocation() {
        this.displayMessage = "Enter the coordinates of where you want to move (e.g., 5 2):";
        String strCoordinates = this.getInput().trim();
        
        int separatorPos = strCoordinates.indexOf(" ");
        String strRow = strCoordinates.substring(separatorPos, separatorPos);
        String strCol = strCoordinates.substring(separatorPos+1);
        int row;
        int col;
        try {
            row = Integer.parseInt(strRow);
            col = Integer.parseInt(strCol);
        } catch (NumberFormatException e) {
            System.out.println("You must end valid numbers for the row and column.");
            return;  
        }
       
        // get the list of actors chosen
        // get the location
        MapControl.moveActorsToLocation(curiousworkmanship.CuriousWorkmanship.getCurrentGame().getMap(), 
                                        CuriousWorkmanship.getCurrentGame().getActors(), row, col);
        
        System.out.println();
   
    }

    private void viewLocation() {
        System.out.println("*** viewLocation stub function called ***");        
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
        CollectResourceVIew collectResourceVIew = new CollectResourceVIew();
        collectResourceVIew.display();
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
        System.out.println("Description" + "\t" + 
                           "Required" + "\t" +
                           "In Stock");
        
        // for each inventory item
        for (InventoryItem inventoryItem : inventory) {
            // DISPLAY the description, the required amount and amount in stock
            System.out.println(inventoryItem.getDescription() + "\t    " +
                               inventoryItem.getRequiredAmount() + "\t    " +
                               inventoryItem.getQuantityInStock());
        }   
    }

    private void packShip() {
        System.out.println("*** packShip stub function called ***");       
    }

    private void launchShip() {
        System.out.println("*** launchShip stub function called ***");        
    }


    private void printColumnHeaders(int noOfColumns) {
        for (int i = 0; i < noOfColumns; i++) {
            if (i < 10) {
                System.out.println("   " + i + " ");
            }
            else {
                System.out.println("  " + i + " ");
            }
        }
    }

    private void printRowDivider(int noColumns) {
        for (int i = 0; i < noColumns; i++) { // print row divider
                System.out.println("-----");
        }
        System.out.println("-");
    }


    

    
}
