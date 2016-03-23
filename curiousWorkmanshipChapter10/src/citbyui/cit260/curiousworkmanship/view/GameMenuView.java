/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package citbyui.cit260.curiousworkmanship.view;

import citbyui.cit260.curiousworkmanship.control.GameControl;
import citbyui.cit260.curiousworkmanship.enums.Actor;
import citbyui.cit260.curiousworkmanship.model.Game;
import citbyui.cit260.curiousworkmanship.model.InventoryItem;
import citbyui.cit260.curiousworkmanship.model.Location;
import citbyui.cit260.curiousworkmanship.model.Scene;
import curiousworkmanship.CuriousWorkmanship;
import java.awt.Point;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


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
            + "\nK - Pack ship for journey"
            + "\nJ - Launch ship to the promised land"
            + "\nH - Display help menu"
            + "\nP - Print game report"
            + "\nZ - Calculate volume of barrel" 
            + "\nQ - Quit"
            + "\n---------------------------------------------");

    }
    
      
    
    
    @Override
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
                this.displayActors(); 
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
            case 'K': // Pack ship
                this.packShip(); 
                break;
            case 'J': // Launch ship
                this.launchShip();      
                break;
            case 'H': // display the help menu
                this.displayHelpMenu();
                break;
            case 'P': // print game report
                this.printReport();
                break;

            default:
                ErrorView.display("GameMenuView", "*** Invalid selection *** Try again");
        }
        return false;
    }
    
    public void displayMap() { 
       this.viewMap(CuriousWorkmanship.getOutFile()); 
    }
    
    public void viewMap(PrintWriter out) {
        int lineLength = 0;
        
        // get the map for the game
        Location[][] locations = GameControl.getMapLocations();
        int noColumns = locations[0].length; // get number columns in row
        
        this.printTitle(out, noColumns, "THE LAND OF BOUNTIFUL");
        this.printColumnHeaders(out, noColumns);
        
        for (int i = 0; i < locations.length; i++) {    
            Location[] rowLocations = locations[i];
            this.printRowDivider(out, noColumns);
            out.println(); // move down one i
            if (i < 9)
                out.print(" " + (i+1));
            else 
                out.print(i+1);
            
            // for every column in the row
            for (int column = 0; column < noColumns; column++) {
                out.print("|"); // print column divider
                Location location = rowLocations[column];
                if (location != null && location.isVisited()) { // if location is visited 
                    
                    Scene scene = location.getScene();
                    if (scene != null)
                        out.print(scene.getMapSymbol());
                    else
                        out.print("    ");
                }
                else {
                    out.print(" ?? ");
                }      
            }
            
            out.print("|"); // print column divider
        }
        
        this.printRowDivider(out, noColumns);
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
        EstimateResourcesView estimateResourcesView = new EstimateResourcesView();
        estimateResourcesView.display();

    }
    
    

    private void designBarrels() {
        DesignBarrelsView designBarrelsView = new DesignBarrelsView();
        designBarrelsView.display();
    }

    private void manufactureItems() {
        this.console.println("*** manufactureItems stub function called ***");         
    }
    
    private void harvestResources() {
        this.console.println("*** harvestResources stub function called ***");        
    }

    private void deliverResources() {
        this.console.println("*** deliverResources stub function called ***");        
    }

    private void workOnShip() {
        this.console.println("*** workOnShip stub function called ***");        
    }
    
    private void displayActors() {
        this.viewActors(CuriousWorkmanship.getOutFile());
    }
    private void viewActors(PrintWriter out) {
        Game game = CuriousWorkmanship.getCurrentGame();
        out.println("\n    LIST OF ACTORS");
        StringBuilder line = new StringBuilder("                                                          ");
        line.insert(0, "NAME"); 
        line.insert(15, "LOCATION");
        out.println(line.toString());
        
        Actor[] actors = Actor.values();
        for (Actor actor : actors) {
            Point coordinates = game.getActorsLocation()[actor.ordinal()];
            line = new StringBuilder("                                                          ");
            line.insert(0, actor.name());
            int row = coordinates.x+1;
            int column = coordinates.y+1;
            line.insert(17,  + row + ", " + column);
            out.println(line.toString());
        }
        
    }

    private void viewShipStatus() {
        this.console.println("*** viewShipStatus stub function called ***");        
    }
    
    
    private void displayHelpMenu() {
        HelpMenuView helpMenu = new HelpMenuView();
        helpMenu.display(); 
    }

//    private void viewInventory() {
//        this.viewInventory(CuriousWorkmanship.getOutFile());
//    }
//    
//        private void viewInventory(PrintWriter out) {
//        // get the sorted list of inventory items for the current game
//        InventoryItem[] inventory = GameControl.getSortedInventoryList();
//        
//        out.println("\n        LIST OF INVENTORY ITEMS");
//        StringBuilder line = new StringBuilder("                                                          ");
//        line.insert(0, "DESCRIPTION"); 
//        line.insert(20, "REQUIRED");
//        line.insert(30, "IN STOCK");
//        out.println(line.toString());
//        
//        // for each inventory item
//        for (InventoryItem inventoryItem : inventory) {
//            line = new StringBuilder("                                                          ");
//            line.insert(0, inventoryItem.getDescription());
//            line.insert(23, inventoryItem.getRequiredAmount());
//            line.insert(33, inventoryItem.getQuantityInStock());
//            
//            // DISPLAY the description, the required amount and amount in stock
//            out.println(line.toString());
//        }   
//    }
        
        
    private void viewInventory() {
        StringBuilder line;
        
        Game game = CuriousWorkmanship.getCurrentGame();
        InventoryItem[] inventory = game.getInventory();
        
        System.out.println("\n        LIST OF INVENTORY ITEMS");
        line = new StringBuilder("                                       ");
        line.insert(0, "DESCRIPTION"); 
        line.insert(20, "REQUIRED");
        line.insert(30, "IN STOCK");
        System.out.println(line.toString());
        
        // for each inventory item
        for (InventoryItem item : inventory) {
            line = new StringBuilder("                                       ");
            line.insert(0, item.getDescription());
            line.insert(23, item.getRequiredAmount());
            line.insert(33, item.getQuantityInStock());
            
            // DISPLAY the line
            System.out.println(line.toString());
        }   
    }

    private void packShip() {
        this.console.println("*** packShip stub function called ***");       
    }

    private void launchShip() {
        this.console.println("*** launchShip stub function called ***");        
    }


    private void printColumnHeaders(PrintWriter out, int noOfColumns) {
        for (int i = 1; i < noOfColumns+1; i++) {
            if (i < 10) {
                out.print("   " + i + " ");
            }
            else {
                out.print("  " + i + " ");
            }
        }
    }

    private void printRowDivider(PrintWriter out, int noColumns) {
        out.println();
        out.print("  ");
        for (int i = 0; i < noColumns; i++) { // print row divider
                out.print("-----");
        }
        out.print("-");
    }

    private void printTitle(PrintWriter out, int noOfColumns, String title) {
        
        int titleLength = title.length();
        int lineLength = noOfColumns * 5 + 3;
        int startPosition = (lineLength / 2) - (titleLength / 2);
        out.println("\n");
        for (int i = 0; i < startPosition; i++) {
            out.print(" ");  
        }
        out.print(title);
        out.println("\n");
        
    }
    
    
    
     public void printReport() {
        // get the filepath and name of the file
        this.console.println("\nEnter the file path where the report is to be saved");
        
        String filePath = this.getInput();
        if (filePath == null) {
            return;
        }
        
        // Create a new printwriter
        try (PrintWriter reportFile = new PrintWriter(filePath)) {
            
            
            LocalDateTime currentTime = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
            String dateTime = formatter.format(currentTime);
            
            reportFile.println("Report printed: " + dateTime);
            
            this.viewMap(reportFile);
            
            reportFile.println();
//            this.viewInventory(reportFile);

            reportFile.println();
            this.viewActors(reportFile); 
            
            CuriousWorkmanship.getOutFile().println(
                    "\n*** Report printed to file: " + filePath + " ***");
            
        } catch (Exception ex) {
            ErrorView.display("GameMenuView", "Error writing to game report file. "
                    + "\n\t" + ex.getMessage());
        }

    }


}
