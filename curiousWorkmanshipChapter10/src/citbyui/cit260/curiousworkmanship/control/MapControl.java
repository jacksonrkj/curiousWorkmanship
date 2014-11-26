/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package citbyui.cit260.curiousworkmanship.control;

import citbyui.cit260.curiousworkmanship.enums.Actor;
import citbyui.cit260.curiousworkmanship.enums.Item;
import citbyui.cit260.curiousworkmanship.enums.SceneGroup;
import citbyui.cit260.curiousworkmanship.enums.SceneType;
import citbyui.cit260.curiousworkmanship.exceptions.MapControlException;
import citbyui.cit260.curiousworkmanship.model.ConstructionScene;
import citbyui.cit260.curiousworkmanship.model.Game;
import citbyui.cit260.curiousworkmanship.model.InventoryItem;
import citbyui.cit260.curiousworkmanship.model.KnowledgeScene;
import citbyui.cit260.curiousworkmanship.model.Location;
import citbyui.cit260.curiousworkmanship.model.Map;
import citbyui.cit260.curiousworkmanship.model.Question;
import citbyui.cit260.curiousworkmanship.model.ResourceScene;
import citbyui.cit260.curiousworkmanship.model.Scene;
import citbyui.cit260.curiousworkmanship.model.WarehouseScene;
import curiousworkmanship.CuriousWorkmanship;
import java.awt.Point;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author jacksonrkj
 */
public class MapControl {
   

    public static Map createMap() {
        // create the map
        Map map = new Map(20, 20);
        
        // create a list of the different scenes in the game
        Scene[] scenes = createScenes(); 
        
        // assign the different scenes to locations in the map
        assignScenesToLocations(map, scenes); 
        
        return map;
    }
    
    
    
    private static Scene[] createScenes() {
        
        Game game = CuriousWorkmanship.getCurrentGame();
        
        Scene[] scenes = new Scene[SceneType.values().length];
          
        Scene cliffScene = new Scene();
        cliffScene.setDescription(
                  "\nThis is a tall cliff. You can not climb over the cliff. "
                + "\nYou will have to go another way.");
        cliffScene.setMapSymbol(" || ");
        cliffScene.setBlocked(true);
        cliffScene.setTravelTime(Double.POSITIVE_INFINITY);
        scenes[SceneType.cliff.ordinal()] = cliffScene;
        
        Scene oceanScene = new Scene();
        oceanScene.setDescription(
                  "\nAll you see is the deep blue ocean. You can not enter "
                + "the ocean unless you are on a ship.");
        oceanScene.setMapSymbol("~~~~");
        oceanScene.setBlocked(true);
        oceanScene.setTravelTime(Double.POSITIVE_INFINITY);
        scenes[SceneType.ocean.ordinal()] = oceanScene;
        
        Scene riverScene = new Scene();
        riverScene.setDescription(
                  "\nYou have come to a river. It is too deep to cross here.");
        riverScene.setMapSymbol("}}}}");
        riverScene.setBlocked(true);
        riverScene.setTravelTime(Double.POSITIVE_INFINITY);
        scenes[SceneType.river.ordinal()] = riverScene;
        
        Scene sandyDesert = new Scene();
        sandyDesert.setBlocked(false);
        sandyDesert.setDescription(
                  "\nYou have wandered into the dry sandy desert. Very little "
                + "\ngrows here.");
        sandyDesert.setMapSymbol("::::");
        sandyDesert.setTravelTime(20);
        scenes[SceneType.desert.ordinal()] = sandyDesert;
               
        Scene savana = new Scene();
        savana.setBlocked(false);
        savana.setDescription(
                  "\nYou have entered the savana. Lush grass and flowers grow here.");
        savana.setMapSymbol(",,,,");
        savana.setTravelTime(15);
        scenes[SceneType.savana.ordinal()] = savana;
        
        Scene mountain = new Scene();
        mountain.setBlocked(false);
        mountain.setDescription(
                  "\nYou are walking through the mountain. The going can be slow here");
        mountain.setMapSymbol("^^^^");
        mountain.setTravelTime(30);
        scenes[SceneType.mountain.ordinal()] = mountain;
        
        Scene riverCrossing = new Scene();
        riverCrossing.setBlocked(false);
        riverCrossing.setDescription(
                  "\nThe river is shallow here. It is a good place to cross. "
                + "\nYou might even think about building a bridge here.");
        riverCrossing.setMapSymbol("=}{=");
        riverCrossing.setTravelTime(20);
        scenes[SceneType.riverCrossing.ordinal()] = riverCrossing;

        
        Scene beach = new Scene();
        beach.setBlocked(false);
        beach.setDescription(
                  "\nYou are walking across a beautiful sandy beach.");
        beach.setMapSymbol("....");
        beach.setTravelTime(20);
        scenes[SceneType.beach.ordinal()] = beach;
        
        Scene swamp = new Scene();
        swamp.setBlocked(false);
        swamp.setDescription(
                  "\nYou are walking through a swampy area. You can really"
                + "\nget \"bogged\" down here");
        swamp.setMapSymbol("####");
        swamp.setTravelTime(60);
        scenes[SceneType.swamp.ordinal()] = swamp;
        
                
        ResourceScene iron = new ResourceScene();
                iron.setBlocked(false);
        iron.setDescription(
                    "\nThere is a outcropping with a large rusting red streaks."
                  + "\nThere appears to be a large vein of iron ore here.");
                iron.setBlocked(false);
        iron.setMapSymbol(" IR ");
        iron.setTravelTime(20);
        iron.setAmountOfResource(100);
        iron.setResourceType(Item.ore);
        scenes[SceneType.iron.ordinal()] = iron;
        
        ResourceScene wheat= new ResourceScene();
                wheat.setBlocked(false);
        wheat.setDescription(
                  "\nYou are standing in a field of wheat.");
        wheat.setMapSymbol(" WH ");
        wheat.setTravelTime(20);
        wheat.setAmountOfResource(2000);
        wheat.setResourceType(Item.grain);
        scenes[SceneType.wheat.ordinal()] = wheat;
        
        
        
        ResourceScene rye = new ResourceScene();
                rye.setBlocked(false);
        rye.setDescription(
                  "\nYou are standing in a field of rye.");
        rye.setMapSymbol(" RY ");
        rye.setTravelTime(20);
        rye.setAmountOfResource(900);
        rye.setResourceType(Item.grain);
        scenes[SceneType.rye.ordinal()] = rye;
        
        
        ResourceScene rice = new ResourceScene();
                rice.setBlocked(false);
        rice.setDescription(
                  "\nYou are standing in a field of rice.");
        rice.setMapSymbol(" RI ");
        rice.setTravelTime(20);
        rice.setAmountOfResource(1200);
        rice.setResourceType(Item.grain);
        scenes[SceneType.rice.ordinal()] = rice;
          
        ResourceScene oliveOrchard = new ResourceScene();
        oliveOrchard.setBlocked(false);
        oliveOrchard.setDescription(
                  "\nThese olive trees should be a great source for our oil");
        oliveOrchard.setMapSymbol(" OO ");
        oliveOrchard.setTravelTime(20);
        oliveOrchard.setAmountOfResource(30);
        oliveOrchard.setResourceType(Item.oil);
        scenes[SceneType.oliveOrchard.ordinal()] = oliveOrchard;        
        
        ResourceScene lentils = new ResourceScene();
                lentils.setBlocked(false);
        lentils.setDescription(
                  "\nYou have located a patch of lentils.");
        lentils.setMapSymbol(" LN ");
        lentils.setTravelTime(20);
        lentils.setAmountOfResource(600);
        lentils.setResourceType(Item.legume);
        scenes[SceneType.lentil.ordinal()] = lentils;
        
        
        ResourceScene chickpeas = new ResourceScene();
                chickpeas.setBlocked(false);
        chickpeas.setDescription(
                  "\nThere are a lot of chickpeas growing here.");
        chickpeas.setMapSymbol(" CP ");
        chickpeas.setTravelTime(20);
        chickpeas.setAmountOfResource(1000);
        chickpeas.setResourceType(Item.legume);
        scenes[SceneType.chickpeas.ordinal()] = chickpeas;
        
        ResourceScene fababeans = new ResourceScene();
                fababeans.setBlocked(false);
        fababeans.setDescription(
                  "\nLooks like someone planted a bunch of Faba beans here.");
        fababeans.setMapSymbol(" FB ");
        fababeans.setTravelTime(20);
        fababeans.setAmountOfResource(900);
        fababeans.setResourceType(Item.legume);
        scenes[SceneType.fababeans.ordinal()] = fababeans;
        
        
        ResourceScene honey = new ResourceScene();
                honey.setBlocked(false);
        honey.setDescription(
                  "\nThat beehive can give us a log of good honey for our trip");
        honey.setMapSymbol(" HO ");
        honey.setTravelTime(15);
        honey.setAmountOfResource(30);
        honey.setResourceType(Item.honey);
        honey.setResourceType(Item.honey);
        scenes[SceneType.honey.ordinal()] = honey;
        
        ResourceScene salt = new ResourceScene();
                salt.setBlocked(false);
        salt.setDescription(
                  "\nYou have found a cave full of interesting salt formations.");
        salt.setMapSymbol(" SA ");
        salt.setTravelTime(15);
        salt.setAmountOfResource(60);
        salt.setResourceType(Item.salt);
        scenes[SceneType.salt.ordinal()] = salt;

        
        InventoryItem[] inventory = game.getInventory();
        
        ConstructionScene blacksmith = new ConstructionScene();
        blacksmith.setBlocked(false);
        blacksmith.setDescription(
                  "\nYou just entered the blacksmith shop where you can build "
                  + "all sorts of tools.");
        blacksmith.setMapSymbol(" BL ");
        blacksmith.setTravelTime(180);
        InventoryItem[] requiredItems = new InventoryItem[2];
        requiredItems[0] = inventory[Item.lumber.ordinal()];
        requiredItems[1] = inventory[Item.ore.ordinal()];
        blacksmith.setRequiredItems(requiredItems);
        scenes[SceneType.blacksmith.ordinal()] = blacksmith;

                
        ConstructionScene bridge = new ConstructionScene();
        bridge.setBlocked(false);
        bridge.setDescription(
                  "\nYou are crossing a bridge over the river. It is a lot "
                + "faster to cross the river");
        bridge.setMapSymbol("====");
        bridge.setTravelTime(5);
        requiredItems = new InventoryItem[5];
        requiredItems[0] = inventory[Item.lumber.ordinal()];
        requiredItems[1] = inventory[Item.hammer.ordinal()];
        requiredItems[2] = inventory[Item.saw.ordinal()];
        requiredItems[3] = inventory[Item.shovel.ordinal()];
        requiredItems[4] = inventory[Item.nails.ordinal()];
        bridge.setRequiredItems(requiredItems);
        scenes[SceneType.bridge.ordinal()] = bridge;
        
        WarehouseScene toolshed = new WarehouseScene();
        toolshed.setBlocked(false);
        toolshed.setDescription("All of the tools are stored in here");
        toolshed.setMapSymbol(" TS ");
        toolshed.setTravelTime(15);
        InventoryItem[] itemsStored = new InventoryItem[7];
        itemsStored[0] = inventory[Item.axe.ordinal()];
        itemsStored[1] = inventory[Item.hammer.ordinal()];
        itemsStored[2] = inventory[Item.drill.ordinal()];
        itemsStored[3] = inventory[Item.shovel.ordinal()];
        itemsStored[4] = inventory[Item.sickle.ordinal()];
        itemsStored[5] = inventory[Item.saw.ordinal()];
        itemsStored[6] = inventory[Item.nails.ordinal()];
        toolshed.setItemsStored(itemsStored);
        scenes[SceneType.toolShed.ordinal()] = toolshed;
        
        WarehouseScene warehouse = new WarehouseScene();
        warehouse.setBlocked(false);
        warehouse.setDescription("This warehouse contains all of your food storage items");
        warehouse.setMapSymbol(" WR ");
        warehouse.setTravelTime(120);
        itemsStored = new InventoryItem[6];
        itemsStored[0] = inventory[Item.grain.ordinal()];
        itemsStored[1] = inventory[Item.legume.ordinal()];
        itemsStored[2] = inventory[Item.oil.ordinal()];
        itemsStored[3] = inventory[Item.water.ordinal()];
        itemsStored[4] = inventory[Item.honey.ordinal()];
        itemsStored[5] = inventory[Item.salt.ordinal()];
        warehouse.setItemsStored(itemsStored);
        scenes[SceneType.warehouse.ordinal()] = warehouse;
        
        WarehouseScene lumberyard = new WarehouseScene();
        lumberyard.setBlocked(false);
        lumberyard.setDescription("All of the lumber is stored here");
        lumberyard.setMapSymbol(" LU ");
        lumberyard.setTravelTime(60);
        itemsStored = new InventoryItem[1];
        itemsStored[0] = inventory[Item.lumber.ordinal()];
        lumberyard.setItemsStored(itemsStored);
        scenes[SceneType.lumberYard.ordinal()] = lumberyard;
        
        
        
        Question[] questions = new Question[2];
        questions[0] = new Question(
                        "Where can I find honey?", 
                        "Go east near the sea shore and seach near the cliffs");
        questions[1] = new Question(
                        "Whre can I go to find ore to build tools with?", 
                        "Go to the cliffs on the east side of this mountain range. ");
        KnowledgeScene highMountain = new KnowledgeScene(
                                      SceneGroup.knowledge,
                                      "You are in the tops of the mountains. "
                                      + "This is a greate place to receive revelation.",
                                      " HM ",
                                      180,
                                      false,
                                      questions);
        scenes[SceneType.highMountain.ordinal()] = highMountain;
        
        return scenes;
        
        
    }
    
    private static void assignScenesToLocations(Map map, Scene[] scenes) {
        Location[][] locations = map.getLocations();
        Point coordinate;
        
        HashMap<String, ArrayList<Point>> sceneLocations =  new HashMap<String, ArrayList<Point>>();
        
        // create list of scenes to be assigned to locations
        ArrayList<Point> lumberCoordinates = new ArrayList<Point>();
        lumberCoordinates.add(new Point(1,8));
        lumberCoordinates.add(new Point(2,8));
        lumberCoordinates.add(new Point(1,9));
        lumberCoordinates.add(new Point(2,9));
        lumberCoordinates.add(new Point(2,13));
        lumberCoordinates.add(new Point(3,13));
        lumberCoordinates.add(new Point(4,13));
        lumberCoordinates.add(new Point(5,13));
        lumberCoordinates.add(new Point(3,14));
        lumberCoordinates.add(new Point(4,14));
        lumberCoordinates.add(new Point(9,16));
        lumberCoordinates.add(new Point(10,16));
        lumberCoordinates.add(new Point(9,17));
        lumberCoordinates.add(new Point(11,14));
        lumberCoordinates.add(new Point(12,5));
        sceneLocations.put("LUMBER", lumberCoordinates);
        
        
        ArrayList<Point> oceanCoordinates = new ArrayList<Point>();
        for (int row = 0; row < 20; row++) {
            oceanCoordinates.add(new Point(row,0));
        }
        for (int row = 0; row < 4; row++) {
            oceanCoordinates.add(new Point(row,1));
        }
        for (int row = 17; row < 20; row++) {
            oceanCoordinates.add(new Point(row,1));
        }
        oceanCoordinates.add(new Point(19,2));
        oceanCoordinates.add(new Point(18,5));
        for (int col = 4; col < 20; col++) {
            oceanCoordinates.add(new Point(19,col));
        }
        for (int col = 16; col < 20; col++) {
            oceanCoordinates.add(new Point(18,col));
        }
        for (int col = 17; col < 20; col++) {
            oceanCoordinates.add(new Point(17,col));
        }
        oceanCoordinates.add(new Point(16,19));
        for (Point point : oceanCoordinates) {
            locations[point.x][point.y].setScene(scenes[Constants.OCEAN]);   
        }
        
        
        ArrayList<Point> desertCoordinates = new ArrayList<Point>();
        for (int col = 3; col < 11; col++) {
            desertCoordinates.add(new Point(0,col));
        }
        for (int col = 13; col < 20; col++) {
            desertCoordinates.add(new Point(0,col));
        }
        for (int col = 13; col < 20; col++) {
            desertCoordinates.add(new Point(1,col));
        }
        for (int col = 14; col < 20; col++) {
            desertCoordinates.add(new Point(2,col));
        }
        for (int col = 16; col < 20; col++) {
            desertCoordinates.add(new Point(3,col));
        }
        for (int col = 17; col < 20; col++) {
            desertCoordinates.add(new Point(4,col));
        }
        for (int col = 18; col < 20; col++) {
            desertCoordinates.add(new Point(5,col));
        }
        for (int col = 18; col < 20; col++) {
            desertCoordinates.add(new Point(6,col));
        }
        desertCoordinates.add(new Point(7,19));
        desertCoordinates.add(new Point(10,19));
        for (int col = 18; col < 20; col++) {
            desertCoordinates.add(new Point(11,col));
        }
        for (int col = 18; col < 20; col++) {
            desertCoordinates.add(new Point(12,col));
        }
        desertCoordinates.add(new Point(13,19));
        for (Point point : desertCoordinates) {
            locations[point.x][point.y].setScene(scenes[Constants.DESERT]);   
        }
        
        ArrayList<Point> mountainCoordinates = new ArrayList<Point>();
        mountainCoordinates.add(new Point(1,3));
        mountainCoordinates.add(new Point(1,4));
        mountainCoordinates.add(new Point(1,6));
        mountainCoordinates.add(new Point(2,3));
        mountainCoordinates.add(new Point(2,6));
        mountainCoordinates.add(new Point(3,4));
        mountainCoordinates.add(new Point(3,5));
        mountainCoordinates.add(new Point(3,6));
        mountainCoordinates.add(new Point(3,4));
        mountainCoordinates.add(new Point(3,5));
        mountainCoordinates.add(new Point(5,3));
        mountainCoordinates.add(new Point(5,6));
        mountainCoordinates.add(new Point(8,3));
        mountainCoordinates.add(new Point(8,4));
        mountainCoordinates.add(new Point(8,5));
        mountainCoordinates.add(new Point(9,4));
        mountainCoordinates.add(new Point(10,4));
        mountainCoordinates.add(new Point(11,4));
        mountainCoordinates.add(new Point(12,4));
        mountainCoordinates.add(new Point(13,4));
        for (Point point : mountainCoordinates) {
            locations[point.x][point.y].setScene(scenes[Constants.MOUNTAIN]);   
        }
        
        
        ArrayList<Point> beachCoordinates = new ArrayList<Point>();
      
        for (int row = 4; row < 17; row++) {
            beachCoordinates.add(new Point(row,1));
        }
        beachCoordinates.add(new Point(15,1));
        beachCoordinates.add(new Point(16,1));
        beachCoordinates.add(new Point(17,2));
        beachCoordinates.add(new Point(17,3));
        beachCoordinates.add(new Point(18,2));
        beachCoordinates.add(new Point(18,3));
        beachCoordinates.add(new Point(18,4));
        beachCoordinates.add(new Point(18,6));
        beachCoordinates.add(new Point(15,15));
        beachCoordinates.add(new Point(15,17));
        for (int col = 15; col < 19; col++) {
            beachCoordinates.add(new Point(16,col));
        }
        for (int col = 13; col < 17; col++) {
            beachCoordinates.add(new Point(17,col));
        }
        for (int col = 13; col < 16; col++) {
            beachCoordinates.add(new Point(18,col));
        }
        for (Point point : beachCoordinates) {
            locations[point.x][point.y].setScene(scenes[Constants.BEACH]);   
        }
        
        
        ArrayList<Point> savanaCoordinates = new ArrayList<Point>();
        for (int row = 9; row < 16; row++) {
            savanaCoordinates.add(new Point(row,2));
        }
        for (int row = 14; row < 17; row++) {
            savanaCoordinates.add(new Point(row,3));
        }
        for (int col = 4; col < 7; col++) {
            savanaCoordinates.add(new Point(14,col));
        }
        for (int col = 4; col < 7; col++) {
            savanaCoordinates.add(new Point(15,col));
        }
        savanaCoordinates.add(new Point(13,6));
        savanaCoordinates.add(new Point(4,7));
        savanaCoordinates.add(new Point(5,7));
        for (int row = 8; row < 14; row++) {
            savanaCoordinates.add(new Point(row,7));
        }
        for (int row = 3; row < 11; row++) {
            savanaCoordinates.add(new Point(row,8));
        }
        savanaCoordinates.add(new Point(4,9));
        savanaCoordinates.add(new Point(9,9));
        savanaCoordinates.add(new Point(9,11));
        for (int row = 4; row < 16; row++) {
            savanaCoordinates.add(new Point(row,12));
        }
        for (int row = 9; row < 16; row++) {
            savanaCoordinates.add(new Point(row,13));
        }
        
        for (int col = 14; col < 19; col++) {
            savanaCoordinates.add(new Point(13,col));
        }
        savanaCoordinates.add(new Point(14,19));
        for (Point point : savanaCoordinates) {
            locations[point.x][point.y].setScene(scenes[Constants.SAVANA]);   
        }
        
        
        ArrayList<Point> riverCoordinates = new ArrayList<Point>();
        for (int row = 15; row < 19; row++) {
            riverCoordinates.add(new Point(row,8));
        }
        riverCoordinates.add(new Point(6,9));
        riverCoordinates.add(new Point(7,9));
        for (int row = 11; row < 19; row++) {
            riverCoordinates.add(new Point(row,9));
        }
        for (int row = 1; row < 9; row++) {
            riverCoordinates.add(new Point(row,10));
        }
        for (int row = 10; row < 19; row++) {
            riverCoordinates.add(new Point(row,10));
        }
        for (int row = 0; row < 6; row++) {
            riverCoordinates.add(new Point(row,11));
        }
        riverCoordinates.add(new Point(0,12));
        riverCoordinates.add(new Point(1,12));
        for (Point point : oceanCoordinates) {
            locations[point.x][point.y].setScene(scenes[Constants.SAVANA]);   
        }
        
        
        ArrayList<Point> cliffCoordinates = new ArrayList<Point>();
        for (int row = 5; row < 9; row++) {
            cliffCoordinates.add(new Point(row,2));
        }
        cliffCoordinates.add(new Point(3,3));
        cliffCoordinates.add(new Point(4,3));
        cliffCoordinates.add(new Point(9,3));
        cliffCoordinates.add(new Point(10,3));
        cliffCoordinates.add(new Point(2,4));
        cliffCoordinates.add(new Point(1,5));
        cliffCoordinates.add(new Point(2,5));
        cliffCoordinates.add(new Point(8,5));
        cliffCoordinates.add(new Point(10,5));
        cliffCoordinates.add(new Point(1,5));
        cliffCoordinates.add(new Point(5,6));
        cliffCoordinates.add(new Point(6,6));
        cliffCoordinates.add(new Point(7,6));
        cliffCoordinates.add(new Point(9,6));
        cliffCoordinates.add(new Point(1,7));
        cliffCoordinates.add(new Point(2,7));
        cliffCoordinates.add(new Point(3,7));
        cliffCoordinates.add(new Point(16,13));
        cliffCoordinates.add(new Point(14,14));
        cliffCoordinates.add(new Point(15,14));
        cliffCoordinates.add(new Point(16,14));
        cliffCoordinates.add(new Point(14,15));
        cliffCoordinates.add(new Point(14,16));
        cliffCoordinates.add(new Point(14,17));
        cliffCoordinates.add(new Point(14,18));
        cliffCoordinates.add(new Point(15,18));
        cliffCoordinates.add(new Point(15,19));
        for (Point point : cliffCoordinates) {
            locations[point.x][point.y].setScene(scenes[Constants.CLIFF]);   
        }   
        
    }
    

 
    public static void moveActorsToStartingLocation(Map map) 
                            throws MapControlException {
        // for every actor
        Actor[] actors = Actor.values();

        for (Actor actor : actors) {
            MapControl.moveActorToLocation(actor, actor.getCoordinates());
        }
        
    }
    
    
        
    
    public static void moveActorToLocation(Actor actor, Point coordinates) 
                            throws MapControlException {
        
        Map map = CuriousWorkmanship.getCurrentGame().getMap();
        int newRow = coordinates.x-1;
        int newColumn = coordinates.y-1;
        
        if (newRow < 0  || newRow >= map.getNoOfRows() ||
            newColumn < 0  || newColumn >= map.getNoOfColumns()) {
            throw new MapControlException("The row or column number is "
                                          + "outside bounds of the map");
        }
        
        Location newLocation = map.getLocations()[newRow][newColumn];
        Point actorCoordinates = actor.getCoordinates();
        Location oldLocation = map.getLocations()[actorCoordinates.x][actorCoordinates.y];
        
        // check to see if the actor is in the current location
        if (oldLocation != null) {
            oldLocation.removeActor(actor); // remove actor from old location
        }
        
        newLocation.addActor(actor); // add actor to new location
        actorCoordinates.x = newRow;
        actorCoordinates.y = newColumn; // set actor to new location
        newLocation.setVisited(true); // mark as a visted locations
    }
    
    
    
    public static Location getLocation(Point coordinates) {
        return CuriousWorkmanship.getCurrentGame().getMap().getLocations()[coordinates.x-1][coordinates.y-1];
    }
    
}
