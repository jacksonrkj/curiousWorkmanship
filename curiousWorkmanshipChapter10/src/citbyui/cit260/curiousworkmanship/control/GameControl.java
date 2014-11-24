/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package citbyui.cit260.curiousworkmanship.control;

import citbyui.cit260.curiousworkmanship.enums.Actor;
import citbyui.cit260.curiousworkmanship.enums.Item;
import citbyui.cit260.curiousworkmanship.exceptions.MapControlException;
import citbyui.cit260.curiousworkmanship.model.Game;
import citbyui.cit260.curiousworkmanship.model.InventoryItem;
import citbyui.cit260.curiousworkmanship.model.Location;
import citbyui.cit260.curiousworkmanship.model.Map;
import citbyui.cit260.curiousworkmanship.model.Player;
import citbyui.cit260.curiousworkmanship.model.Ship;
import citbyui.cit260.curiousworkmanship.model.Wagon;
import curiousworkmanship.CuriousWorkmanship;
import java.awt.Point;

/**
 *
 * @author jacksonrkj
 */



public class GameControl {

    public static void createNewGame(Player player) 
            throws MapControlException {
        
       Game game = new Game(); // create new game
       CuriousWorkmanship.setCurrentGame(game); // save in CuriousWorkmanship
       
       game.setPlayer(player); // save player in game
       
       // create the inventory list amd save in the game
       InventoryItem[] inventoryList = GameControl.createInventoryList();
       game.setInventory(inventoryList);
       
       Ship ship = new Ship(); // create new ship
       game.setShip(ship); // save ship in game
       
       Wagon wagon = new Wagon(); // create new wagon
       game.setWagon(wagon); // save wagon in game
        
       Map map = MapControl.createMap(); // create and initialize new map
       game.setMap(map); // save map in game

       // move actors to starting position in the map
       
       // ...
       
       MapControl.moveActorsToStartingLocation(map);    
    }
 
    
    private static Ship createShip() {
        Ship ship = new Ship();
        ship.setDescription(
                          "\nThis is the ship of curious workmanship. If you "
                        + "\nhave faith it will take you to the promised land");
        ship.setHeight(0);
        ship.setLength(0);
        ship.setWidth(0);
        ship.setMaxWeighCapacity(0);
        ship.setSqFtOfSale(0);
        
        return ship;
    }

    private static Wagon createWagon() {
        Wagon wagon = new Wagon();
        wagon.setMaxWeight(1000);
        wagon.setLoadedWeight(0);
        wagon.setNumberBarrelsLoaded(0);
        return wagon;
    }    

    
  
    public static InventoryItem[] createInventoryList() {
        // created array(list) of inventory items    
        InventoryItem[] inventory = 
            new InventoryItem[Constants.NUMBER_OF_INVENTORY_ITEMS];
        
        InventoryItem lumber = new InventoryItem();
        lumber.setDescription("Lumber");
        lumber.setQuantityInStock(0);
        lumber.setRequiredAmount(0);
        inventory[Item.lumber.ordinal()] = lumber;
        
        InventoryItem ore = new InventoryItem();
        ore.setDescription("Ore");
        ore.setQuantityInStock(0);
        ore.setRequiredAmount(0);
        inventory[Item.ore.ordinal()] = ore;
        
        InventoryItem grain = new InventoryItem();
        grain.setDescription("Grain");
        grain.setQuantityInStock(0);
        grain.setRequiredAmount(0);
        inventory[Item.grain.ordinal()] = grain;
        
        InventoryItem legumes = new InventoryItem();
        legumes.setDescription("Legumes");
        legumes.setQuantityInStock(0);
        legumes.setRequiredAmount(0);
        inventory[Item.legume.ordinal()] = legumes;
        
        InventoryItem oil = new InventoryItem();
        oil.setDescription("Olive Oil");
        oil.setQuantityInStock(0);
        oil.setRequiredAmount(0);
        inventory[Item.oil.ordinal()] = oil;
        
        InventoryItem water = new InventoryItem();
        water.setDescription("Water");
        water.setQuantityInStock(0);
        water.setRequiredAmount(0);
        inventory[Item.water.ordinal()] = water;
        
        InventoryItem honey = new InventoryItem();
        honey.setDescription("Honey");
        honey.setQuantityInStock(0);
        honey.setRequiredAmount(0);
        inventory[Item.honey.ordinal()] = honey;
        
        InventoryItem salt = new InventoryItem();
        salt.setDescription("Salt");
        salt.setQuantityInStock(0);
        salt.setRequiredAmount(0);
        inventory[Item.salt.ordinal()] = salt;
        
        InventoryItem axe = new InventoryItem();
        axe.setDescription("Axe");
        axe.setQuantityInStock(0);
        axe.setRequiredAmount(2);
        inventory[Item.axe.ordinal()] = axe;

        InventoryItem hammer = new InventoryItem();
        hammer.setDescription("Hammer");
        hammer.setQuantityInStock(0);
        hammer.setRequiredAmount(3);
        inventory[Item.hammer.ordinal()] = hammer;
        
        InventoryItem drill = new InventoryItem();
        drill.setDescription("Drill");
        drill.setQuantityInStock(0);
        drill.setRequiredAmount(1);
        inventory[Item.drill.ordinal()] = drill;
        
        InventoryItem shovel = new InventoryItem();
        shovel.setDescription("Shovel");
        shovel.setQuantityInStock(0);
        shovel.setRequiredAmount(1);
        inventory[Item.shovel.ordinal()] = shovel;
        
        InventoryItem sickle = new InventoryItem();
        sickle.setDescription("Sickle");
        sickle.setQuantityInStock(0);
        sickle.setRequiredAmount(2);
        inventory[Item.sickle.ordinal()] = sickle;
        
        
        InventoryItem saw = new InventoryItem();
        saw.setDescription("Saw");
        saw.setQuantityInStock(0);
        saw.setRequiredAmount(2);
        inventory[Item.saw.ordinal()] = saw;
        
        
        InventoryItem nails = new InventoryItem();
        nails.setDescription("Sickle");
        nails.setQuantityInStock(0);
        nails.setRequiredAmount(50);
        inventory[Item.nails.ordinal()] = nails;
   
        return inventory;
    }

    public static void startSavedGame() {
        System.out.println("*** startSavedGame() called ***");
    }
    


    
    /*
    public static InventoryItem[] createInventoryList() {
            
        // created array(list) of inventory items    
        InventoryItem[] inventory = 
            new InventoryItem[14];
        
        InventoryItem lumber = new InventoryItem();
        lumber.setDescription("Lumber");
        lumber.setQuantityInStock(0);
        lumber.setRequiredAmount(0);
        inventory[0] = lumber;
        
        InventoryItem ore = new InventoryItem();
        ore.setDescription("Ore");
        ore.setQuantityInStock(0);
        ore.setRequiredAmount(0);
        inventory[1] = ore;
        
        InventoryItem grain = new InventoryItem();
        grain.setDescription("Grain");
        grain.setQuantityInStock(0);
        grain.setRequiredAmount(0);
        inventory[2] = grain;
        
        InventoryItem legumes = new InventoryItem();
        legumes.setDescription("Legumes");
        legumes.setQuantityInStock(0);
        legumes.setRequiredAmount(0);
        inventory[3] = legumes;
        
        InventoryItem oil = new InventoryItem();
        oil.setDescription("Olive Oil");
        oil.setQuantityInStock(0);
        oil.setRequiredAmount(0);
        inventory[4] = oil;
        
        InventoryItem water = new InventoryItem();
        water.setDescription("Water");
        water.setQuantityInStock(0);
        water.setRequiredAmount(0);
        inventory[5] = water;
        
        InventoryItem honey = new InventoryItem();
        honey.setDescription("Honey");
        honey.setQuantityInStock(0);
        honey.setRequiredAmount(0);
        inventory[6] = honey;
        
        InventoryItem salt = new InventoryItem();
        salt.setDescription("Salt");
        salt.setQuantityInStock(0);
        salt.setRequiredAmount(0);
        inventory[Constants.ITEM_SALT] = salt;
        
        InventoryItem axe = new InventoryItem();
        axe.setDescription("Axe");
        axe.setQuantityInStock(0);
        axe.setRequiredAmount(2);
        inventory[7] = axe;

        InventoryItem hammer = new InventoryItem();
        hammer.setDescription("Hammer");
        hammer.setQuantityInStock(0);
        hammer.setRequiredAmount(3);
        inventory[8] = hammer;
        
        InventoryItem drill = new InventoryItem();
        drill.setDescription("Drill");
        drill.setQuantityInStock(0);
        drill.setRequiredAmount(1);
        inventory[9] = drill;
        
        InventoryItem shovel = new InventoryItem();
        shovel.setDescription("Shovel");
        shovel.setQuantityInStock(0);
        shovel.setRequiredAmount(1);
        inventory[10] = shovel;
        
        InventoryItem sickle = new InventoryItem();
        sickle.setDescription("Sickle");
        sickle.setQuantityInStock(0);
        sickle.setRequiredAmount(2);
        inventory[11] = sickle;
        
        
        InventoryItem saw = new InventoryItem();
        saw.setDescription("Saw");
        saw.setQuantityInStock(0);
        saw.setRequiredAmount(2);
        inventory[12] = saw;
        
        
        InventoryItem nails = new InventoryItem();
        nails.setDescription("Sickle");
        nails.setQuantityInStock(0);
        nails.setRequiredAmount(50);
        inventory[13] = nails;
   
        return inventory;
    }
    
    */
    
    
  
    public Actor[]  getSortActorList(Actor[] actors) {
        
        // using a BubbleSort to sort the list of actors by name
        Actor tempActor;
        for (int i = 0; i < actors.length-1; i++) {
            for (int j = 0; j < actors.length-1-i; j++) {
                String currentActorsName = actors[j].toString();
                String nextActorsNames = actors[j + 1].toString();
                if ( currentActorsName.compareToIgnoreCase(nextActorsNames) > 0) {
                    tempActor = actors[j];
                    actors[j] = actors[j+1];
                    actors[j+1] = tempActor;
                }
            }
        }
        
        return actors;
    }


    public static InventoryItem[] getSortedInventoryList() {
        
        // get inventory list for the current game
        InventoryItem[] originalInventoryList = 
                CuriousWorkmanship.getCurrentGame().getInventory();
        
        // clone (make a copy) orignalList
        InventoryItem[] inventoryList = originalInventoryList.clone();
        
       // using a BubbleSort to sort the list of inventoryList by name
        InventoryItem tempInventoryItem;
        for (int i = 0; i < inventoryList.length-1; i++) {
            for (int j = 0; j < inventoryList.length-1-i; j++) {
                if (inventoryList[j].getDescription().
                        compareToIgnoreCase(inventoryList[j + 1].getDescription()) > 0) {
                    tempInventoryItem = inventoryList[j];
                    inventoryList[j] = inventoryList[j+1];
                    inventoryList[j+1] = tempInventoryItem;
                }
            }
        }
        
        return inventoryList;
    }

    public static Location[][] getMapLocations() {
        return CuriousWorkmanship.getCurrentGame().getMap().getLocations();
    }
    
    
    
    public static void moveActorToLocation(Actor actor, int row, int column) 
                            throws MapControlException {
        Map map = CuriousWorkmanship.getCurrentGame().getMap();
        try {
            if (row < 1  || row > map.getNoOfRows() ||
                column < 1  || row > map.getNoOfColumns()) {

                throw new CuriousWorkmanshipException("Row or column is outsides the bounds of the map");
            }
        } catch (CuriousWorkmanshipException ex) {
            System.out.println(ex.getMessage());
        }
        
        MapControl.moveActorToLocation(actor, new Point(row, column));
        
    }
    
    public static InventoryItem[] getInventory() {
        return CuriousWorkmanship.getCurrentGame().getInventory();
    }

    enum ToolWeights {
        HAMMER(2.75),
        AX(10.0),
        DRILL(1.5),
        SHOVEL(7.25),
        SICKLE(2.3),
        SAW(1.75);
        
        private final double weight;

        private ToolWeights(double weight) {
            this.weight = weight;
        }
        
        
        public double getWeight() {
            return weight;
        }
            
        
    }
    
    private double getWeightOfToolBox() {
        
        double totalWeight = ToolWeights.HAMMER.getWeight() + ToolWeights.DRILL.getWeight();
        
        return totalWeight;
        
    }
    
    
    


}
