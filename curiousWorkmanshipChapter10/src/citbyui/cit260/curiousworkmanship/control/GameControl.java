/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package citbyui.cit260.curiousworkmanship.control;

import citbyui.cit260.curiousworkmanship.enums.Actor;
import citbyui.cit260.curiousworkmanship.enums.FoodItem;
import citbyui.cit260.curiousworkmanship.enums.Item;
import citbyui.cit260.curiousworkmanship.exceptions.GameControlException;
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
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.security.InvalidParameterException;

/**
 *
 * @author jacksonrkj
 */



public class GameControl {
    
    public enum Probability {
        OK,
        TOO_LOW,
        TOO_HIGH,
        LOW_PROBABILITY,
        HIGH_PROBABILITY;
    }
    
    
    public GameControl() {
    }


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
       Actor[] actors = Actor.values();
       
       MapControl.moveActorsToStartingLocation(map, actors);    
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
        nails.setDescription("Nails");
        nails.setQuantityInStock(0);
        nails.setRequiredAmount(50);
        inventory[Item.nails.ordinal()] = nails;
   
        return inventory;
    }
    
  
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
    
    
    public static InventoryItem[] getInventory() {
        return CuriousWorkmanship.getCurrentGame().getInventory();
    }

    
    public static void saveGame(Game game, String filepath) 
            throws GameControlException {

        try( FileOutputStream fops = new FileOutputStream(filepath)) {
            ObjectOutputStream output = new ObjectOutputStream(fops);
            
            output.writeObject(game); // write the game object out to file
        }
        catch(Exception e) {
            throw new GameControlException(e.getMessage());
        } 
    }

    
    public static void getSavedGame(String filepath) 
                        throws GameControlException {
        Game game = null;

        try( FileInputStream fips = new FileInputStream(filepath)) {
            ObjectInputStream input = new ObjectInputStream(fips);
            
            game = (Game) input.readObject(); // read the game object from file
        }
        catch(Exception e) {
            throw new GameControlException(e.getMessage());
        }

       // close the outuput file
       CuriousWorkmanship.setCurrentGame(game); // save in CuriousWorkmanship
    }
 
    
    public static double getLengthOfTrip(double speed) {
        return Constants.TRIP_DISTANCE / 24 / speed;
    }
    
    public static Probability checkSpeedOfShip(double speed) throws GameControlException {
        if (speed < 0) {
            throw new GameControlException("The speed must be a number greater than zero.");
        }
        
        if (speed >= Constants.DEV_ONE_LOW && speed <= Constants.DEV_ONE_HIGH) {
            return Probability.HIGH_PROBABILITY;
        }
        else if (speed >= Constants.DEV_TWO_LOW && speed <= Constants.DEV_TWO_HIGH) {
            return Probability.LOW_PROBABILITY;
        }
        else if (speed < Constants.DEV_TWO_LOW) {
            return Probability.TOO_LOW;
        }
        else {
            return Probability.TOO_HIGH;
        }

    }   
    
    public static Probability checkNoOfPeople(int noOfPeople) throws GameControlException {
        
        if (noOfPeople < 0) {
            throw new GameControlException( "The number of people must be a "
                                          + "number greater than zero.");
        }
        
        if (noOfPeople < Constants.MIN_PERSONS_SAILING) {
            return Probability.TOO_LOW;
        }
        else if (noOfPeople > Constants.MAX_PERSONS_SAILING) {
            return Probability.TOO_HIGH;
        }
        else {
            return Probability.OK;
        }

    }
    
    public static Probability checkRequiredAmount(FoodItem item, 
                                             double noOfDays, 
                                             int noOfPeople, 
                                             double estimatedAmount) 
                                throws GameControlException { 
        
        if (item == null  ||  
            noOfDays < 0  ||  
            noOfPeople < Constants.MIN_PERSONS_SAILING ||
            estimatedAmount < 0) {
            throw new InvalidParameterException("calculateRequiredAMount");
        }

        double requiredAmount = item.getRecommendedAmountPerDay() * noOfDays * noOfPeople;
        
        if (estimatedAmount < requiredAmount * .90) {
            return Probability.TOO_LOW;            
        } 
        else if (estimatedAmount > requiredAmount * 1.10) {
            return Probability.TOO_HIGH;            
        } 
        else {
            return Probability.OK;
        }

    }
    
    
    public double getPercentage(String value1, String value2) {
        double percentage = 0.0;
        
        try {
             
            try {
                double firstNumber = Double.parseDouble(value1);
                double secondNumber = Double.parseDouble(value2);
                percentage = (firstNumber / secondNumber) * 100;            
            } catch (ArithmeticException ae) {
                System.out.println("The second value can not be zero.");
            } finally {
                System.out.println("Inner try statement completed.");
            }
             
        } catch (Exception e) {
            System.out.println("Some other exception occurred.");
        } finally {
            System.out.println("Outer try statement completed."); 
        }
               
        return percentage;
    }

   
    
  
    
}
