/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package citbyui.cit260.curiousworkmanship.control;

import citbyui.cit260.curiousworkmanship.enums.Actor;
import citbyui.cit260.curiousworkmanship.enums.Direction;
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
import java.awt.image.BufferedImage;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author jacksonrkj
 */
public class MapControl {
   

    public static Map createMap() throws MapControlException {
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

        Scene startingScene = new Scene();
        startingScene.setDescription(
                  "And we did come to the land which was called Bountiful, "
                + "because of its much fruit and also wild honey; and all "
                + "these things were prepared of the Lord that we might not "
                + "perish. And we beheld the sea, which we called Irreantum, "
                + "which, being interpreted, is many waters");
        startingScene.setMapSymbol(" ST ");
        startingScene.setBlocked(false);
        startingScene.setTravelTime(240);
        scenes[SceneType.start.ordinal()] = startingScene;


        Scene finishScene = new Scene();
        finishScene.setDescription(
                  "Congratulations! Well done thou good and faithful servant. "
                + "You have just launced your ship of  curious workmanship and "
                + "begun your journey to the promised land.");
        finishScene.setMapSymbol(" FN ");
        finishScene.setBlocked(false);
        finishScene.setTravelTime(Double.POSITIVE_INFINITY);
        scenes[SceneType.finish.ordinal()] = finishScene;

        Scene cliffScene = new Scene();
        cliffScene.setDescription(
                  "This is a tall cliff. You can not climb over the cliff. "
                + "You will have to go another way.");
        cliffScene.setMapSymbol(" || ");
        cliffScene.setBlocked(true);
        cliffScene.setTravelTime(Double.POSITIVE_INFINITY);
        scenes[SceneType.cliff.ordinal()] = cliffScene;

        Scene oceanScene = new Scene();
        oceanScene.setDescription(
                  "All you see is the deep blue ocean. You can not enter "
                + "the ocean unless you are on a ship.");
        oceanScene.setMapSymbol("~~~~");
        oceanScene.setBlocked(true);
        oceanScene.setTravelTime(Double.POSITIVE_INFINITY);
        scenes[SceneType.ocean.ordinal()] = oceanScene;


        Scene riverScene = new Scene();
        riverScene.setDescription(
                  "You have come to a river. It is too deep to cross here.");
        riverScene.setMapSymbol("}}}}");
        riverScene.setBlocked(true);
        riverScene.setTravelTime(Double.POSITIVE_INFINITY);
        scenes[SceneType.river.ordinal()] = riverScene;

        Scene sandyDesert = new Scene();
        sandyDesert.setBlocked(false);
        sandyDesert.setDescription(
                  "You have wandered into the dry sandy desert. Very little "
                + "grows here.");
        sandyDesert.setMapSymbol("::::");
        sandyDesert.setTravelTime(20);
        scenes[SceneType.desert.ordinal()] = sandyDesert;

        Scene savana = new Scene();
        savana.setBlocked(false);
        savana.setDescription(
                  "You have entered the savana. Lush grass and flowers grow here.");
        savana.setMapSymbol(",,,,");
        savana.setTravelTime(15);
        scenes[SceneType.savana.ordinal()] = savana;

        Scene mountain = new Scene();
        mountain.setBlocked(false);
        mountain.setDescription(
                  "You are walking through the mountains. The going can be slow here");
        mountain.setMapSymbol("^^^^");
        mountain.setTravelTime(30);
        scenes[SceneType.mountain.ordinal()] = mountain;

        Scene riverCrossing = new Scene();
        riverCrossing.setBlocked(false);
        riverCrossing.setDescription(
                  "The river is shallow here. It is a good place to cross. "
                + "You might even think about building a bridge here.");
        riverCrossing.setMapSymbol("=}{=");
        riverCrossing.setTravelTime(20);
        scenes[SceneType.riverCrossing.ordinal()] = riverCrossing;
    //

        Scene beach = new Scene();
        beach.setBlocked(false);
        beach.setDescription(
                  "You are walking across a beautiful sandy beach.");
        beach.setMapSymbol("....");
        beach.setTravelTime(20);
        scenes[SceneType.beach.ordinal()] = beach;

        Scene swamp = new Scene();
        swamp.setBlocked(false);
        swamp.setDescription(
                  "You are walking through a swampy area. You can really "
                + "get \"bogged\" down here");
        swamp.setMapSymbol("####");
        swamp.setTravelTime(60);
        scenes[SceneType.swamp.ordinal()] = swamp;

        ResourceScene lumber = new ResourceScene();
        lumber.setDescription(
                  "You have entered a forest of hardwood. This is a great "
                + "source of lumber to build things with.");
        lumber.setMapSymbol("tttt");
        lumber.setBlocked(false);
        lumber.setTravelTime(20);
        lumber.setAmountOfResource(100);
        lumber.setResourceType(Item.lumber);
        scenes[SceneType.lumber.ordinal()] = lumber;
        
        
        ResourceScene iron = new ResourceScene();
                iron.setBlocked(false);
        iron.setDescription(
                    "There is a outcropping with a large rusting red streaks."
                  + "There appears to be a large vein of iron ore here.");
                iron.setBlocked(false);
        iron.setMapSymbol(" IR ");
        iron.setTravelTime(20);
        iron.setAmountOfResource(100);
        iron.setResourceType(Item.ore);
        scenes[SceneType.iron.ordinal()] = iron;

        ResourceScene wheat= new ResourceScene();
                wheat.setBlocked(false);
        wheat.setDescription(
                  "You are standing in a field of wheat.");
        wheat.setMapSymbol(" WH ");
        wheat.setTravelTime(20);
        wheat.setAmountOfResource(2000);
        wheat.setResourceType(Item.grain);
        scenes[SceneType.wheat.ordinal()] = wheat;

        ResourceScene water= new ResourceScene();
        water.setBlocked(false);
        water.setDescription(
                    "This is a well of clean wather. You will need this for "
                    + "for your trip.");
        wheat.setMapSymbol(" WA ");
        water.setTravelTime(20);
        water.setAmountOfResource(2000);
        water.setResourceType(Item.water);
        scenes[SceneType.water.ordinal()] = water;


        ResourceScene rye = new ResourceScene();
                rye.setBlocked(false);
        rye.setDescription(
                  "You are standing in a field of rye.");
        rye.setMapSymbol(" RY ");
        rye.setTravelTime(20);
        rye.setAmountOfResource(900);
        rye.setResourceType(Item.grain);
        scenes[SceneType.rye.ordinal()] = rye;


        ResourceScene rice = new ResourceScene();
                rice.setBlocked(false);
        rice.setDescription(
                  "You are standing in a field of rice.");
        rice.setMapSymbol(" RI ");
        rice.setTravelTime(20);
        rice.setAmountOfResource(1200);
        rice.setResourceType(Item.grain);
        scenes[SceneType.rice.ordinal()] = rice;

        ResourceScene oliveOil = new ResourceScene();
        oliveOil.setBlocked(false);
        oliveOil.setDescription(
                  "These olive trees should be a great source for our oil");
        oliveOil.setMapSymbol(" OO ");
        oliveOil.setTravelTime(20);
        oliveOil.setAmountOfResource(30);
        oliveOil.setResourceType(Item.oil);
        scenes[SceneType.oliveOrchard.ordinal()] = oliveOil;        

        ResourceScene lentils = new ResourceScene();
                lentils.setBlocked(false);
        lentils.setDescription(
                  "You have located a patch of lentils.");
        lentils.setMapSymbol(" LN ");
        lentils.setTravelTime(20);
        lentils.setAmountOfResource(600);
        lentils.setResourceType(Item.legume);
        scenes[SceneType.lentil.ordinal()] = lentils;


        ResourceScene chickpeas = new ResourceScene();
                chickpeas.setBlocked(false);
        chickpeas.setDescription(
                  "There are a lot of chickpeas growing here.");
        chickpeas.setMapSymbol(" CP ");
        chickpeas.setTravelTime(20);
        chickpeas.setAmountOfResource(1000);
        chickpeas.setResourceType(Item.legume);
        scenes[SceneType.chickpeas.ordinal()] = chickpeas;

        ResourceScene fababeans = new ResourceScene();
                fababeans.setBlocked(false);
        fababeans.setDescription(
                  "Looks like someone planted a bunch of Faba beans here.");
        fababeans.setMapSymbol(" FB ");
        fababeans.setTravelTime(20);
        fababeans.setAmountOfResource(900);
        fababeans.setResourceType(Item.legume);
        scenes[SceneType.fababeans.ordinal()] = fababeans;


        ResourceScene honey = new ResourceScene();
                honey.setBlocked(false);
        honey.setDescription(
                  "That beehive can give us a log of good honey for our trip");
        honey.setMapSymbol(" HO ");
        honey.setTravelTime(15);
        honey.setAmountOfResource(30);
        honey.setResourceType(Item.honey);
        scenes[SceneType.honey.ordinal()] = honey;

        ResourceScene salt = new ResourceScene();
                salt.setBlocked(false);
        salt.setDescription(
                  "You have found a cave full of interesting salt formations.");
        salt.setMapSymbol(" SA ");
        salt.setTravelTime(15);
        salt.setAmountOfResource(60);
        salt.setResourceType(Item.salt);
        scenes[SceneType.salt.ordinal()] = salt;
    //

        InventoryItem[] inventory = game.getInventory();

        ConstructionScene blacksmith = new ConstructionScene();
        blacksmith.setBlocked(false);
        blacksmith.setDescription(
                  "You just entered the blacksmith shop where you can build "
                  + "all sorts of tools.");
        blacksmith.setMapSymbol(" BL ");
        blacksmith.setTravelTime(180);
        InventoryItem[] requiredItems = new InventoryItem[2];
        requiredItems[0] = inventory[Item.lumber.ordinal()];
        requiredItems[1] = inventory[Item.ore.ordinal()];
        blacksmith.setRequiredItems(requiredItems);
        scenes[SceneType.blacksmith.ordinal()] = blacksmith;
    //

        ConstructionScene bridge = new ConstructionScene();
        bridge.setBlocked(false);
        bridge.setDescription(
                  "You are crossing a bridge over the river. It is a lot "
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
                        "Lord, what should we do here in this land of Bountiful? ", 
                        "Thou shalt construct a ship after the manner which I "
                        + "shall show thee, that I may carry thy people "
                        + "across these waters. And I will prepare the way "
                        + "before you, if it so be that ye shall keep "
                        + "my commandments ye shall be led towards the promised land; "
                        + "and ye shall know that it is by me that ye are led. light "
                        + "in the wilderness; and I will ");
        questions[1] = new Question(
                        "Lord, whither shall I go that I may find ore to molten, "
                        + "that I amy make tools to construct the ship?", 
                        "Go to the cliffs on the east side of this mountain range. ");
        KnowledgeScene highMountain = new KnowledgeScene(
                                      SceneGroup.knowledge,
                                      "You have come to the tops of the mountains. "
                                      + "This is the place where Nephi was instruced "
                                      + "to go to receive further instructions "
                                      + "from the Lord.",
                                      " HM ",
                                      720,
                                      false,
                                      questions);
        scenes[SceneType.highMountain.ordinal()] = highMountain;

        Scene instructionScene = new Scene();
        instructionScene.setDescription(
                    "The voice of the Lord comes unto Nephi, "
                  + "Arise, and get thee into the montain.");
        instructionScene.setMapSymbol(" IN ");
        instructionScene.setBlocked(false);
        instructionScene.setTravelTime(480);
        scenes[SceneType.instructions.ordinal()] = instructionScene;


        Scene rebellionScene = new Scene();
        rebellionScene.setDescription(
                  "Laman and Lemuel have refused to help you build a ship. "
                + "Nephi chastizes and rebukes them.");
        rebellionScene.setMapSymbol(" RB ");
        rebellionScene.setBlocked(false);
        rebellionScene.setTravelTime(10000);
        scenes[SceneType.rebellion.ordinal()] = rebellionScene;


        Scene boatyardScene = new Scene();
        boatyardScene.setDescription(
                  "This is the boatyard where you work on building the ship. ");
        boatyardScene.setMapSymbol(" BY ");
        boatyardScene.setBlocked(false);
        boatyardScene.setTravelTime(600);
        scenes[SceneType.boatyard.ordinal()] = boatyardScene;


        Scene blacksmithScene = new Scene();
        blacksmithScene.setDescription(
                  "This is the blacksmith where you work on building the ship. ");
        blacksmithScene.setMapSymbol(" BY ");
        blacksmithScene.setBlocked(false);
        blacksmithScene.setTravelTime(600);
        scenes[SceneType.blacksmith.ordinal()] = blacksmithScene;


        Scene campScene = new Scene();
        campScene.setDescription(
                  "This is the camp where you work on building the ship. ");
        campScene.setMapSymbol(" BY ");
        campScene.setBlocked(false);
        campScene.setTravelTime(600);
        scenes[SceneType.camp.ordinal()] = campScene;


        return scenes;


    }

    private static void assignScenesToLocations(Map map, Scene[] scenes) {
        Location[][] locations = map.getLocations();

        // start point
        locations[0][0].setScene(scenes[SceneType.desert.ordinal()]);
        locations[0][1].setScene(scenes[SceneType.desert.ordinal()]);
        locations[0][2].setScene(scenes[SceneType.start.ordinal()]);
        locations[0][3].setScene(scenes[SceneType.beach.ordinal()]);
      
        locations[9][9].setScene(scenes[SceneType.ocean.ordinal()]);

        
        
        HashMap<String, ArrayList<Point>> sceneLocations =  
                new HashMap<String, ArrayList<Point>>();
 

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
        mountainCoordinates.add(new Point(4,4));
        mountainCoordinates.add(new Point(4,5));
        mountainCoordinates.add(new Point(4,6));
        mountainCoordinates.add(new Point(5,3));
        mountainCoordinates.add(new Point(5,5));
        mountainCoordinates.add(new Point(6,3));
        mountainCoordinates.add(new Point(6,4));
        mountainCoordinates.add(new Point(6,5));     
        mountainCoordinates.add(new Point(7,3));
        mountainCoordinates.add(new Point(7,5));
        mountainCoordinates.add(new Point(8,3));
        mountainCoordinates.add(new Point(8,4));;
        mountainCoordinates.add(new Point(9,4));
        mountainCoordinates.add(new Point(10,4));
        mountainCoordinates.add(new Point(11,4));
        mountainCoordinates.add(new Point(12,3));
        mountainCoordinates.add(new Point(12,4));
        mountainCoordinates.add(new Point(13,4));

        mountainCoordinates.add(new Point(3,15));
        mountainCoordinates.add(new Point(4,16));
        mountainCoordinates.add(new Point(5,14));
        mountainCoordinates.add(new Point(5,15));
        mountainCoordinates.add(new Point(5,17));
        mountainCoordinates.add(new Point(6,14));
        mountainCoordinates.add(new Point(6,15));
        mountainCoordinates.add(new Point(6,16));
        mountainCoordinates.add(new Point(7,14));
        mountainCoordinates.add(new Point(7,16));
        mountainCoordinates.add(new Point(7,17));
        mountainCoordinates.add(new Point(7,18));
        for (int i = 13; i < 20; i++) {
            mountainCoordinates.add(new Point(8,i));
        }
        mountainCoordinates.add(new Point(9,15));
        mountainCoordinates.add(new Point(9,18));
        mountainCoordinates.add(new Point(9,19));
        mountainCoordinates.add(new Point(10,14));
        mountainCoordinates.add(new Point(10,15));
        mountainCoordinates.add(new Point(10,17));
        mountainCoordinates.add(new Point(10,18));
        mountainCoordinates.add(new Point(11,15));
        mountainCoordinates.add(new Point(11,16));
        mountainCoordinates.add(new Point(12,17));
    // 
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
        savanaCoordinates.add(new Point(2,2));
        savanaCoordinates.add(new Point(3,2));
        savanaCoordinates.add(new Point(4,2));
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
        savanaCoordinates.add(new Point(12,8));
        savanaCoordinates.add(new Point(13,8));
        savanaCoordinates.add(new Point(17,3));
        savanaCoordinates.add(new Point(11,3));
        savanaCoordinates.add(new Point(13,3));
        savanaCoordinates.add(new Point(16,2));
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
        riverCoordinates.add(new Point(18,11));
        for (Point point : riverCoordinates) {
            locations[point.x][point.y].setScene(scenes[Constants.RIVER]);   
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
        cliffCoordinates.add(new Point(11,5));
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
        cliffCoordinates.add(new Point(17,4));
        cliffCoordinates.add(new Point(17,5));
        for (Point point : cliffCoordinates) {
            locations[point.x][point.y].setScene(scenes[Constants.CLIFF]);   
        }

        ArrayList<Point> swampCoordinates = new ArrayList<Point>();
        for (int row = 15; row < 19; row++) {
            swampCoordinates.add(new Point(row,7));
        }
        swampCoordinates.add(new Point(17,6));
        swampCoordinates.add(new Point(14,8));
        swampCoordinates.add(new Point(14,8));
        swampCoordinates.add(new Point(8,9));
        swampCoordinates.add(new Point(10,9));
        for (int row = 14; row < 18; row++) {
            swampCoordinates.add(new Point(row,11));
        }
        for (int row = 16; row < 19; row++) {
            swampCoordinates.add(new Point(row,12));
        }
        for (Point point : swampCoordinates) {
            locations[point.x][point.y].setScene(scenes[Constants.SWAMP]);   
        }


        // water
        locations[11][8].setScene(scenes[SceneType.water.ordinal()]);
        locations[9][14].setScene(scenes[SceneType.water.ordinal()]);
        locations[9][5].setScene(scenes[SceneType.iron.ordinal()]);
        locations[8][6].setScene(scenes[SceneType.iron.ordinal()]);
        locations[7][15].setScene(scenes[SceneType.iron.ordinal()]);
        locations[5][4].setScene(scenes[SceneType.honey.ordinal()]);
        locations[14][7].setScene(scenes[SceneType.honey.ordinal()]);
        locations[2][12].setScene(scenes[SceneType.honey.ordinal()]);
        locations[6][13].setScene(scenes[SceneType.honey.ordinal()]);
        locations[11][17].setScene(scenes[SceneType.honey.ordinal()]);
        locations[15][16].setScene(scenes[SceneType.honey.ordinal()]);
        locations[6][7].setScene(scenes[SceneType.rye.ordinal()]);
        locations[7][7].setScene(scenes[SceneType.rye.ordinal()]);
        locations[8][11].setScene(scenes[SceneType.chickpeas.ordinal()]);
        locations[6][11].setScene(scenes[SceneType.wheat.ordinal()]);
        locations[10][11].setScene(scenes[SceneType.wheat.ordinal()]);
        locations[11][11].setScene(scenes[SceneType.wheat.ordinal()]);
        locations[12][11].setScene(scenes[SceneType.rice.ordinal()]);
        locations[13][11].setScene(scenes[SceneType.rice.ordinal()]);
        locations[4][15].setScene(scenes[SceneType.oliveOrchard.ordinal()]);
        locations[5][16].setScene(scenes[SceneType.oliveOrchard.ordinal()]);
        locations[6][17].setScene(scenes[SceneType.oliveOrchard.ordinal()]);
        locations[7][15].setScene(scenes[SceneType.oliveOrchard.ordinal()]);
        locations[12][14].setScene(scenes[SceneType.oliveOrchard.ordinal()]);
        locations[12][15].setScene(scenes[SceneType.oliveOrchard.ordinal()]);
        locations[12][16].setScene(scenes[SceneType.oliveOrchard.ordinal()]);
        locations[12][6].setScene(scenes[SceneType.lumber.ordinal()]);
        locations[1][8].setScene(scenes[SceneType.lumber.ordinal()]);
        locations[1][9].setScene(scenes[SceneType.lumber.ordinal()]);
        locations[2][8].setScene(scenes[SceneType.lumber.ordinal()]);
        locations[2][9].setScene(scenes[SceneType.lumber.ordinal()]);
        locations[2][13].setScene(scenes[SceneType.lumber.ordinal()]);
        locations[3][12].setScene(scenes[SceneType.lumber.ordinal()]);
        locations[3][13].setScene(scenes[SceneType.lumber.ordinal()]);
        locations[3][14].setScene(scenes[SceneType.lumber.ordinal()]);
        locations[4][13].setScene(scenes[SceneType.lumber.ordinal()]);
        locations[4][14].setScene(scenes[SceneType.lumber.ordinal()]);
        locations[5][13].setScene(scenes[SceneType.lumber.ordinal()]);
        locations[9][16].setScene(scenes[SceneType.lumber.ordinal()]);
        locations[9][17].setScene(scenes[SceneType.lumber.ordinal()]);
        locations[10][16].setScene(scenes[SceneType.lumber.ordinal()]);
        locations[11][6].setScene(scenes[SceneType.lumber.ordinal()]);
        locations[12][5].setScene(scenes[SceneType.lumber.ordinal()]);
        locations[11][14].setScene(scenes[SceneType.lumber.ordinal()]);
        locations[3][9].setScene(scenes[SceneType.chickpeas.ordinal()]);
        locations[7][11].setScene(scenes[SceneType.chickpeas.ordinal()]);
        locations[4][9].setScene(scenes[SceneType.lentil.ordinal()]);
        locations[5][9].setScene(scenes[SceneType.lentil.ordinal()]);
        locations[7][11].setScene(scenes[SceneType.chickpeas.ordinal()]);
        locations[7][13].setScene(scenes[SceneType.fababeans.ordinal()]);
        locations[9][10].setScene(scenes[SceneType.riverCrossing.ordinal()]);
        locations[10][6].setScene(scenes[SceneType.salt.ordinal()]);
        locations[18][3].setScene(scenes[SceneType.boatyard.ordinal()]);
        locations[19][3].setScene(scenes[SceneType.finish.ordinal()]);
        locations[1][2].setScene(scenes[SceneType.instructions.ordinal()]);
        locations[7][4].setScene(scenes[SceneType.highMountain.ordinal()]);
        locations[13][5].setScene(scenes[SceneType.rebellion.ordinal()]);
        locations[16][4].setScene(scenes[SceneType.toolShed.ordinal()]);
        locations[16][5].setScene(scenes[SceneType.blacksmith.ordinal()]);
        locations[16][6].setScene(scenes[SceneType.warehouse.ordinal()]);
        locations[14][5].setScene(scenes[SceneType.camp.ordinal()]);

    }

    

 
    public static void moveActorsToStartingLocation(Map map, Actor[] actors) 
                            throws MapControlException {
        Game game = CuriousWorkmanship.getCurrentGame();
        for (Actor actor : actors) {
            Point position = new Point(0, 2);
            game.getActorsLocation()[actor.ordinal()] = new Point();
            MapControl.moveActorToLocation(game, actor, position);
        }
        
    }
    
    
     public static Point moveActor(Actor actor, Direction direction, int distance) 
                            throws MapControlException {
        
        Point blockedLocation = null;
        
        if (actor == null  || direction == null  || distance < 1) {
            throw new InvalidParameterException("actor, direction or distance is invalid");
        }
        
        Game game = CuriousWorkmanship.getCurrentGame();    
        Map map = CuriousWorkmanship.getCurrentGame().getMap();
        Point currentPosition = game.getActorsLocation()[actor.ordinal()];
        Point newPosition = null;
        
        if (currentPosition == null) {
            throw new MapControlException("Actor is currently is not assigned "
                                          + "to a location");
        }
        
        int currentRow = currentPosition.x;
        int currentColumn = currentPosition.y;

        if (currentRow < 0  || currentRow >= map.getNoOfRows() ||
            currentColumn < 0  || currentColumn >= map.getNoOfColumns()) {
            throw new MapControlException("Actor is currently in an invalid "
                                          + "location");
        }
        
        // get new position
        int newRow = currentPosition.x + (direction.getxIncrement() * distance);
        int newColumn = currentPosition.y + (direction.getyIncrement() * distance);
        
                   
        if (newRow < 0  || newRow >= map.getNoOfRows() ||
            newColumn < 0  || newColumn >= map.getNoOfColumns()) {
            throw new MapControlException("Trying to move to a location "
                                          + "outside bounds of the map");
        }  
        
        
        // Check to see if the path is blocked
        boolean blocked = false;
        Location[][] locations = map.getLocations();
        
        int noOfRows = (newRow - currentRow) * direction.getxIncrement();
        int row = currentRow + direction.getxIncrement();      
        for (int i = 0; i < noOfRows; i++ ) {
            locations[row][currentColumn].setVisited(true);
            
            if (locations[row][currentColumn].getScene().isBlocked()){   
                blocked = true;
                newRow = row - direction.getxIncrement();
                blockedLocation = new Point(row+1, currentColumn+1);
                break;
            }
            
            row += direction.getxIncrement();
        }
        
        
        int noOfColumns = (newColumn - currentColumn) * direction.getyIncrement();
        int column = currentColumn + direction.getyIncrement();       
        for (int i = 0; i < noOfColumns; i++ ) {
            locations[currentRow][column].setVisited(true);

            if (locations[currentRow][column].getScene().isBlocked()){ 
                blocked = true;
                newColumn = column - direction.getyIncrement();
                blockedLocation = new Point(currentRow+1, column+1);
                break;
            }  
            column += direction.getyIncrement();
        } 
        
        
        if (currentRow != newRow || currentColumn != newColumn) {
            Location currentLocation = map.getLocations()[currentRow][currentColumn];
            currentLocation.removeActor(actor); // remove actor from old location

            // set actor to new location
            newPosition = new Point(newRow, newColumn);
            MapControl.moveActorToLocation(game, actor, newPosition);
        }

        
        return blockedLocation;
    }    
    
    public static void moveActorToLocation(Game game, Actor actor, Point position) 
            throws MapControlException {
        Map map = game.getMap();
        
        Location location = game.getMap().getLocations()[position.x][position.y];
            
        if (position.x < 0  || position.x >= map.getNoOfRows() ||
            position.y < 0  || position.y >= map.getNoOfColumns()) {
            throw new MapControlException("Trying to move to a location "
                                          + "outside bounds of the map");
        }    
        
        location.addActor(actor); // add actor to new location

        // set actor to new location
        game.getActorsLocation()[actor.ordinal()].setLocation(position);
        
        location.setVisited(true); // mark as a visted locations// mark as a visted locations// mark as a visted locations// mark as a visted locations
    }
    
    
    
    public static Location getLocation(Point coordinates) {
        return CuriousWorkmanship.getCurrentGame().getMap().getLocations()[coordinates.x-1][coordinates.y-1];
    }
    
}
