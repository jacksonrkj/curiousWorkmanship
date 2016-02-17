/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package citbyui.cit260.curiousworkmanship.control;

import citbyui.cit260.curiousworkmanship.model.Actor;
import citbyui.cit260.curiousworkmanship.model.Game;
import citbyui.cit260.curiousworkmanship.model.InventoryItem;
import citbyui.cit260.curiousworkmanship.model.Location;
import citbyui.cit260.curiousworkmanship.model.Map;
import citbyui.cit260.curiousworkmanship.model.Player;
import citbyui.cit260.curiousworkmanship.model.Ship;
import citbyui.cit260.curiousworkmanship.model.Wagon;
import curiousworkmanship.CuriousWorkmanship;

/**
 *
 * @author jacksonrkj
 */

public class GameControl {
    
    private static Game game;

    public static Game getGame() {
        return game;
    }

    public static void setGame(Game game) {
        GameControl.game = game;
    }
    
    
    
    public static void createNewGame(Player player) {
        
       // create a new game
       GameControl.game = new Game();
       
       // save as current game
       CuriousWorkmanship.setCurrentGame(game);
       
       // set (save) the player in the game object
       GameControl.game.setPlayer(CuriousWorkmanship.getPlayer());
       
       // create list of actors and save in game
       Actor[] actors = GameControl.createActorList();
       GameControl.game.setActors(actors); // create list of actors
       
       // create the inventory list amd save in the game
       InventoryItem[] inventoryList = GameControl.createInventoryList();
       GameControl.game.setInventory(inventoryList);
       
       // create the ship and save in game
       Ship ship = new Ship();
       GameControl.game.setShip(ship);
       
       // create the wagon and save in game
       Wagon wagon = new Wagon(); 
       GameControl.game.setWagon(wagon);
        
       // create the map and save in tame
       Map map = MapControl.createMap();
       GameControl.game.setMap(map); // create and initialize the map
       
       // move player to starting position
       MapControl.moveActorsToLocation(map, actors, 0, 3);    
    }
    
    

    public static void startSavedGame() {
        System.out.println("\n*** Calling startSaveGame stub function ****");
    }
    
    

    private static Actor[] createActorList() {
        
        // create list of actors
        Actor[] actors = new Actor[Constants.NUMBER_OF_ACTORS];
        
        Actor lehi = new Actor("Lehi"); // create new actor
        actors[Constants.LEHI] = lehi; // Save actor in array
        
        Actor sarah = new Actor("Sarah");
        actors[Constants.SARAH] = sarah;
        
        Actor nephi = new Actor("Nephi"); // create new actor
        actors[Constants.NEPHI] = nephi; // Save actor in array
        
        Actor jacob = new Actor("Jacob");
        actors[Constants.JACOB] = jacob;
        
        Actor sam = new Actor("Sam");
        actors[Constants.SAM] = sam;
        
        Actor laman = new Actor("Laman");
        actors[Constants.LAMAN] = laman;
        
        Actor lemuel = new Actor("Lemuel");
        actors[Constants.LEMUEL] = lemuel;
        
        Actor zoram = new Actor("Zoram");
        actors[Constants.ZORAM] = zoram;
        
        return actors;  
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
        inventory[Constants.ITEM_LUMBER] = lumber;
        
        InventoryItem ore = new InventoryItem();
        ore.setDescription("Ore");
        ore.setQuantityInStock(0);
        ore.setRequiredAmount(0);
        inventory[Constants.ITEM_ORE] = ore;
        
        InventoryItem grain = new InventoryItem();
        grain.setDescription("Grain");
        grain.setQuantityInStock(0);
        grain.setRequiredAmount(0);
        inventory[Constants.ITEM_GRAIN] = grain;
        
        InventoryItem legumes = new InventoryItem();
        legumes.setDescription("Legumes");
        legumes.setQuantityInStock(0);
        legumes.setRequiredAmount(0);
        inventory[Constants.ITEM_LEGUME] = legumes;
        
        InventoryItem oil = new InventoryItem();
        oil.setDescription("Olive Oil");
        oil.setQuantityInStock(0);
        oil.setRequiredAmount(0);
        inventory[Constants.ITEM_OIL] = oil;
        
        InventoryItem water = new InventoryItem();
        water.setDescription("Water");
        water.setQuantityInStock(0);
        water.setRequiredAmount(0);
        inventory[Constants.ITEM_WATER] = water;
        
        InventoryItem honey = new InventoryItem();
        honey.setDescription("Honey");
        honey.setQuantityInStock(0);
        honey.setRequiredAmount(0);
        inventory[Constants.ITEM_HONEY] = honey;
        
        InventoryItem salt = new InventoryItem();
        salt.setDescription("Salt");
        salt.setQuantityInStock(0);
        salt.setRequiredAmount(0);
        inventory[Constants.ITEM_SALT] = salt;
        
        InventoryItem axe = new InventoryItem();
        axe.setDescription("Axe");
        axe.setQuantityInStock(0);
        axe.setRequiredAmount(2);
        inventory[Constants.ITEM_AXE] = axe;

        InventoryItem hammer = new InventoryItem();
        hammer.setDescription("Hammer");
        hammer.setQuantityInStock(0);
        hammer.setRequiredAmount(3);
        inventory[Constants.ITEM_HAMMER] = hammer;
        
        InventoryItem drill = new InventoryItem();
        drill.setDescription("Drill");
        drill.setQuantityInStock(0);
        drill.setRequiredAmount(1);
        inventory[Constants.ITEM_DRILL] = drill;
        
        InventoryItem shovel = new InventoryItem();
        shovel.setDescription("Shovel");
        shovel.setQuantityInStock(0);
        shovel.setRequiredAmount(1);
        inventory[Constants.ITEM_SHOVEL] = shovel;
        
        InventoryItem sickle = new InventoryItem();
        sickle.setDescription("Sickle");
        sickle.setQuantityInStock(0);
        sickle.setRequiredAmount(2);
        inventory[Constants.ITEM_SICKLE] = sickle;
        
        
        InventoryItem saw = new InventoryItem();
        saw.setDescription("Saw");
        saw.setQuantityInStock(0);
        saw.setRequiredAmount(2);
        inventory[Constants.ITEM_SAW] = saw;
        
        
        InventoryItem nails = new InventoryItem();
        nails.setDescription("Sickle");
        nails.setQuantityInStock(0);
        nails.setRequiredAmount(50);
        inventory[Constants.ITEM_NAILS] = nails;
   
        return inventory;
    }
    
    

    
    
    
    
    
  
    public static void getSortActorList() {
        
        Actor[] actors = CuriousWorkmanship.getCurrentGame().getActors();
        
        // using a BubbleSort to sort the list of actors by name
        Actor tempActor;
        for (int i = 0; i < actors.length-1; i++) {
            for (int j = 0; j < actors.length-1-i; j++) {
                if (actors[j].getName().compareToIgnoreCase(actors[j + 1].getName()) > 0) {
                    tempActor = actors[j];
                    actors[j] = actors[j+1];
                    actors[j+1] = tempActor;
                }
            }
        }
    }


    public static InventoryItem[] getSortedInventoryList() {
        
        // get inventory list for the current game
        InventoryItem[] inventoryList = 
                CuriousWorkmanship.getCurrentGame().getInventory();
        
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
    
    

    public static Player createPlayer(String playersName) {
        System.out.println("\n*** CreatePlayer function called ***");
        return null;
    }

}
