/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package citbyui.cit260.curiousworkmanship.control;

import citbyui.cit260.curiousworkmanship.enums.Actor;
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
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.ImageIcon;

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



    private static Scene[] createScenes() throws MapControlException {
        BufferedImage image = null;

        Game game = CuriousWorkmanship.getCurrentGame();

        Scene[] scenes = new Scene[SceneType.values().length];

        Scene startingScene = new Scene();
        startingScene.setDescription(
                  "\nAnd we did come to the land which was called Bountiful, "
                + "because of its much fruit and also wild honey; and all  "
                + "these things were prepared of the Lord that we might not "
                + "perish. And we beheld the sea, which we called Irreantum, "
                + "which, being interpreted, is many waters");
        startingScene.setMapSymbol(" ST ");
        startingScene.setBlocked(false);
        startingScene.setTravelTime(240);
        ImageIcon startingSceneImage = MapControl.getImage(startingScene, 
                "/citbyui/cit260/curiousworkmanship/images/startingPoint.jpg");
        startingScene.setIcon(startingSceneImage);
        scenes[SceneType.start.ordinal()] = startingScene;


        Scene finishScene = new Scene();
        finishScene.setDescription(
                  "\nCongratulations! Well done thou good and faithful servant. "
                + "You have just launced your ship of  curious workmanship and "
                + "\nbegun your journey to the promised land.");
        finishScene.setMapSymbol(" FN ");
        finishScene.setBlocked(false);
        finishScene.setTravelTime(Double.POSITIVE_INFINITY);
        ImageIcon finishSceneImage = MapControl.getImage(finishScene, 
                "/citbyui/cit260/curiousworkmanship/images/finish.jpg");
            finishScene.setIcon(finishSceneImage);
        scenes[SceneType.finish.ordinal()] = finishScene;

        Scene cliffScene = new Scene();
        cliffScene.setDescription(
                  "\nThis is a tall cliff. You can not climb over the cliff. "
                + "\nYou will have to go another way.");
        cliffScene.setMapSymbol(" || ");
        cliffScene.setBlocked(true);
        cliffScene.setTravelTime(Double.POSITIVE_INFINITY);
        ImageIcon cliffSceneImage = MapControl.getImage(cliffScene, 
                "/citbyui/cit260/curiousworkmanship/images/cliff.jpeg");
        cliffScene.setIcon(cliffSceneImage);
        scenes[Constants.CLIFF] = cliffScene;

        Scene oceanScene = new Scene();
        oceanScene.setDescription(
                  "\nAll you see is the deep blue ocean. You can not enter "
                + "the ocean unless you are on a ship.");
        oceanScene.setMapSymbol("~~~~");
        oceanScene.setBlocked(true);
        oceanScene.setTravelTime(Double.POSITIVE_INFINITY);
        ImageIcon oceanSceneImage = MapControl.getImage(oceanScene, 
                "/citbyui/cit260/curiousworkmanship/images/ocean.jpeg");
        oceanScene.setIcon(oceanSceneImage);
        scenes[Constants.OCEAN] = oceanScene;

        Scene lumberScene = new Scene();
        lumberScene.setDescription(
                  "\nYou have entered a forest of hardwood. This is a great "
                + "source of lumber to build things with.");
        lumberScene.setMapSymbol("tttt");
        lumberScene.setBlocked(false);
        lumberScene.setTravelTime(Double.POSITIVE_INFINITY);
        ImageIcon lumberSceneImage = MapControl.getImage(lumberScene, 
                "/citbyui/cit260/curiousworkmanship/images/lumberyard.jpeg");
        lumberScene.setIcon(lumberSceneImage);
        scenes[Constants.LUMBER] = lumberScene;

        Scene riverScene = new Scene();
        riverScene.setDescription(
                  "\nYou have come to a river. It is too deep to cross here.");
        riverScene.setMapSymbol("}}}}");
        riverScene.setBlocked(true);
        riverScene.setTravelTime(Double.POSITIVE_INFINITY);
        ImageIcon riverSceneImage = MapControl.getImage(riverScene, 
                "/citbyui/cit260/curiousworkmanship/images/river.jpeg");
        riverScene.setIcon(riverSceneImage);
        scenes[Constants.RIVER] = riverScene;

        Scene sandyDesert = new Scene();
        sandyDesert.setBlocked(false);
        sandyDesert.setDescription(
                  "\nYou have wandered into the dry sandy desert. Very little "
                + "\ngrows here.");
        sandyDesert.setMapSymbol("::::");
        sandyDesert.setTravelTime(20);
        ImageIcon sandyDesertImage = MapControl.getImage(sandyDesert, 
                "/citbyui/cit260/curiousworkmanship/images/desert.jpeg");
        sandyDesert.setIcon(sandyDesertImage);
        scenes[Constants.DESERT] = sandyDesert;

        Scene savana = new Scene();
        savana.setBlocked(false);
        savana.setDescription(
                  "\nYou have entered the savana. Lush grass and flowers grow here.");
        savana.setMapSymbol(",,,,");
        ImageIcon savanaImage = MapControl.getImage(savana, 
                "/citbyui/cit260/curiousworkmanship/images/prarie.jpeg");
        savana.setIcon(savanaImage);
        savana.setTravelTime(15);
        scenes[Constants.SAVANA] = savana;

        Scene mountain = new Scene();
        mountain.setBlocked(false);
        mountain.setDescription(
                  "\nYou are walking through the mountains. The going can be slow here");
        mountain.setMapSymbol("^^^^");
        mountain.setTravelTime(30);
        ImageIcon mountainImage = MapControl.getImage(mountain, 
                "/citbyui/cit260/curiousworkmanship/images/mountain.jpg");
        mountain.setIcon(mountainImage);
        scenes[Constants.MOUNTAIN] = mountain;

        Scene riverCrossing = new Scene();
        riverCrossing.setBlocked(false);
        riverCrossing.setDescription(
                  "\nThe river is shallow here. It is a good place to cross. "
                + "\nYou might even think about building a bridge here.");
        riverCrossing.setMapSymbol("=}{=");
        riverCrossing.setTravelTime(20);
        ImageIcon riverCrossingImage = MapControl.getImage(riverCrossing, 
                "/citbyui/cit260/curiousworkmanship/images/river forde.jpeg");
        riverCrossing.setIcon(riverCrossingImage);
        scenes[Constants.FORDE] = riverCrossing;
    //

        Scene beach = new Scene();
        beach.setBlocked(false);
        beach.setDescription(
                  "\nYou are walking across a beautiful sandy beach.");
        beach.setMapSymbol("....");
        beach.setTravelTime(20);
        ImageIcon beachImage = MapControl.getImage(beach, 
                "/citbyui/cit260/curiousworkmanship/images/beach.jpeg");
        beach.setIcon(beachImage);
        scenes[Constants.BEACH] = beach;

        Scene swamp = new Scene();
        swamp.setBlocked(false);
        swamp.setDescription(
                  "\nYou are walking through a swampy area. You can really"
                + "\nget \"bogged\" down here");
        swamp.setMapSymbol("####");
        swamp.setTravelTime(60);
        ImageIcon swampImage = MapControl.getImage(swamp, 
                "/citbyui/cit260/curiousworkmanship/images/swamp.jpeg");
        swamp.setIcon(swampImage);
        scenes[Constants.SWAMP] = swamp;


        ResourceScene iron = new ResourceScene();
                iron.setBlocked(false);
        iron.setDescription(
                    "\nThere is a outcropping with a large rusting red streaks."
                  + "\nThere appears to be a large vein of iron ore here.");
                iron.setBlocked(false);
        iron.setMapSymbol(" IR ");
        iron.setTravelTime(20);
        iron.setAmountOfResource(100);
        iron.setResourceType(Constants.ITEM_ORE);
        ImageIcon ironOreImage = MapControl.getImage(iron, 
                "/citbyui/cit260/curiousworkmanship/images/iron ore.jpg");
        iron.setIcon(ironOreImage);
        scenes[Constants.IRON] = iron;

        ResourceScene wheat= new ResourceScene();
                wheat.setBlocked(false);
        wheat.setDescription(
                  "\nYou are standing in a field of wheat.");
        wheat.setMapSymbol(" WH ");
        wheat.setTravelTime(20);
        wheat.setAmountOfResource(2000);
        wheat.setResourceType(Constants.ITEM_GRAIN);
        ImageIcon wheatImage = MapControl.getImage(wheat, 
                "/citbyui/cit260/curiousworkmanship/images/wheat.jpeg");
        wheat.setIcon(wheatImage);
        scenes[Constants.WHEAT] = wheat;

        ResourceScene water= new ResourceScene();
        water.setBlocked(false);
        water.setDescription(
                    "\nThis is a well of clean wather. You will need this for "
                    + "for your trip.");
        wheat.setMapSymbol(" WA ");
        water.setTravelTime(20);
        water.setAmountOfResource(2000);
        water.setResourceType(Constants.ITEM_WATER);
        ImageIcon waterImage = MapControl.getImage(water, 
                "/citbyui/cit260/curiousworkmanship/images/water.jpeg");
        water.setIcon(waterImage);
        scenes[Constants.WATER] = water;


        ResourceScene rye = new ResourceScene();
                rye.setBlocked(false);
        rye.setDescription(
                  "\nYou are standing in a field of rye.");
        rye.setMapSymbol(" RY ");
        rye.setTravelTime(20);
        rye.setAmountOfResource(900);
        rye.setResourceType(Constants.ITEM_GRAIN);
        ImageIcon ryeImage = MapControl.getImage(rye, 
                "/citbyui/cit260/curiousworkmanship/images/rye.jpeg");
        rye.setIcon(ryeImage);
        scenes[Constants.RYE] = rye;


        ResourceScene rice = new ResourceScene();
                rice.setBlocked(false);
        rice.setDescription(
                  "\nYou are standing in a field of rice.");
        rice.setMapSymbol(" RI ");
        rice.setTravelTime(20);
        rice.setAmountOfResource(1200);
        rice.setResourceType(Constants.ITEM_GRAIN);
        ImageIcon riceImage = MapControl.getImage(rice, 
                "/citbyui/cit260/curiousworkmanship/images/rice.jpeg");
        rice.setIcon(riceImage);
        scenes[Constants.RICE] = rice;

        ResourceScene oliveOil = new ResourceScene();
        oliveOil.setBlocked(false);
        oliveOil.setDescription(
                  "\nThese olive trees should be a great source for our oil");
        oliveOil.setMapSymbol(" OO ");
        oliveOil.setTravelTime(20);
        oliveOil.setAmountOfResource(30);
        oliveOil.setResourceType(Constants.ITEM_OIL);
        ImageIcon oliveOilImage = MapControl.getImage(oliveOil, 
                "/citbyui/cit260/curiousworkmanship/images/olive orchard.jpeg");
        oliveOil.setIcon(oliveOilImage);
        scenes[Constants.OLIVEORCHARD] = oliveOil;        

        ResourceScene lentils = new ResourceScene();
                lentils.setBlocked(false);
        lentils.setDescription(
                  "\nYou have located a patch of lentils.");
        lentils.setMapSymbol(" LN ");
        lentils.setTravelTime(20);
        lentils.setAmountOfResource(600);
        lentils.setResourceType(Constants.ITEM_LEGUME);
        ImageIcon lentilsImage = MapControl.getImage(lentils, 
                "/citbyui/cit260/curiousworkmanship/images/Lentils.jpg");
        lentils.setIcon(lentilsImage);
        scenes[Constants.LENTIL] = lentils;


        ResourceScene chickpeas = new ResourceScene();
                chickpeas.setBlocked(false);
        chickpeas.setDescription(
                  "\nThere are a lot of chickpeas growing here.");
        chickpeas.setMapSymbol(" CP ");
        chickpeas.setTravelTime(20);
        chickpeas.setAmountOfResource(1000);
        chickpeas.setResourceType(Constants.ITEM_LEGUME);
        ImageIcon chickpeasImage = MapControl.getImage(chickpeas, 
                "/citbyui/cit260/curiousworkmanship/images/chickpeas.JPG");
        chickpeas.setIcon(chickpeasImage);
        scenes[Constants.CHICKPEAS] = chickpeas;

        ResourceScene fababeans = new ResourceScene();
                fababeans.setBlocked(false);
        fababeans.setDescription(
                  "\nLooks like someone planted a bunch of Faba beans here.");
        fababeans.setMapSymbol(" FB ");
        fababeans.setTravelTime(20);
        fababeans.setAmountOfResource(900);
        fababeans.setResourceType(Constants.ITEM_LEGUME);
        ImageIcon fababeansImage = MapControl.getImage(fababeans, 
                "/citbyui/cit260/curiousworkmanship/images/fababean.jpg");
        fababeans.setIcon(fababeansImage);
        scenes[Constants.FABABEAN] = fababeans;


        ResourceScene honey = new ResourceScene();
                honey.setBlocked(false);
        honey.setDescription(
                  "\nThat beehive can give us a log of good honey for our trip");
        honey.setMapSymbol(" HO ");
        honey.setTravelTime(15);
        honey.setAmountOfResource(30);
        honey.setResourceType(Constants.ITEM_HONEY);
        honey.setResourceType(Constants.HONEY);
        ImageIcon honeyImage = MapControl.getImage(honey, 
                "/citbyui/cit260/curiousworkmanship/images/beehives.jpg");
        honey.setIcon(honeyImage);
        scenes[Constants.HONEY] = honey;

        ResourceScene salt = new ResourceScene();
                salt.setBlocked(false);
        salt.setDescription(
                  "\nYou have found a cave full of interesting salt formations.");
        salt.setMapSymbol(" SA ");
        salt.setTravelTime(15);
        salt.setAmountOfResource(60);
        salt.setResourceType(Constants.ITEM_SALT);
        ImageIcon saltImage = MapControl.getImage(salt, 
                "/citbyui/cit260/curiousworkmanship/images/salt.jpg");
        salt.setIcon(saltImage);
        scenes[Constants.SALT] = salt;
    //

        InventoryItem[] inventory = game.getInventory();

        ConstructionScene blacksmith = new ConstructionScene();
        blacksmith.setBlocked(false);
        blacksmith.setDescription(
                  "\nYou just entered the blacksmith shop where you can build "
                  + "all sorts of tools.");
        blacksmith.setMapSymbol(" BL ");
        blacksmith.setTravelTime(180);
        InventoryItem[] requiredItems = new InventoryItem[2];
        requiredItems[0] = inventory[Constants.ITEM_LUMBER];
        requiredItems[1] = inventory[Constants.ITEM_ORE];
        blacksmith.setRequiredItems(requiredItems);
        ImageIcon blacksmithImage = MapControl.getImage(blacksmith, 
                "/citbyui/cit260/curiousworkmanship/images/blacksmith.jpeg");
        blacksmith.setIcon(blacksmithImage);
        scenes[Constants.BLACKSMITH] = blacksmith;
    //

        ConstructionScene bridge = new ConstructionScene();
        bridge.setBlocked(false);
        bridge.setDescription(
                  "\nYou are crossing a bridge over the river. It is a lot "
                + "faster to cross the river");
        bridge.setMapSymbol("====");
        bridge.setTravelTime(5);
        requiredItems = new InventoryItem[5];
        requiredItems[0] = inventory[Constants.ITEM_LUMBER];
        requiredItems[1] = inventory[Constants.ITEM_HAMMER];
        requiredItems[2] = inventory[Constants.ITEM_SAW];
        requiredItems[3] = inventory[Constants.ITEM_SHOVEL];
        requiredItems[4] = inventory[Constants.ITEM_NAILS];
        bridge.setRequiredItems(requiredItems);

        scenes[Constants.BRIDGE] = bridge;

        WarehouseScene toolshed = new WarehouseScene();
        toolshed.setBlocked(false);
        toolshed.setDescription("All of the tools are stored in here");
        toolshed.setMapSymbol(" TS ");
        toolshed.setTravelTime(15);
        InventoryItem[] itemsStored = new InventoryItem[7];
        itemsStored[0] = inventory[Constants.ITEM_AXE];
        itemsStored[1] = inventory[Constants.ITEM_HAMMER];
        itemsStored[2] = inventory[Constants.ITEM_DRILL];
        itemsStored[3] = inventory[Constants.ITEM_SHOVEL];
        itemsStored[4] = inventory[Constants.ITEM_SICKLE];
        itemsStored[5] = inventory[Constants.ITEM_SAW];
        itemsStored[6] = inventory[Constants.ITEM_NAILS];
        toolshed.setItemsStored(itemsStored);
        ImageIcon toolshedImage = MapControl.getImage(toolshed, 
                "/citbyui/cit260/curiousworkmanship/images/toolshop.jpeg");
        toolshed.setIcon(toolshedImage);
        scenes[Constants.TOOLSHED] = toolshed;

        WarehouseScene warehouse = new WarehouseScene();
        warehouse.setBlocked(false);
        warehouse.setDescription("This warehouse contains all of your food storage items");
        warehouse.setMapSymbol(" WR ");
        warehouse.setTravelTime(120);
        itemsStored = new InventoryItem[6];
        itemsStored[0] = inventory[Constants.ITEM_GRAIN];
        itemsStored[1] = inventory[Constants.ITEM_LEGUME];
        itemsStored[2] = inventory[Constants.ITEM_OIL];
        itemsStored[3] = inventory[Constants.ITEM_WATER];
        itemsStored[4] = inventory[Constants.ITEM_HONEY];
        itemsStored[5] = inventory[Constants.ITEM_SALT];
        warehouse.setItemsStored(itemsStored);
        ImageIcon warehouseImage = MapControl.getImage(warehouse, 
                "/citbyui/cit260/curiousworkmanship/images/warehouse.jpeg");
        warehouse.setIcon(warehouseImage);
        scenes[Constants.WAREHOUSE] = warehouse;

        WarehouseScene lumberyard = new WarehouseScene();
        lumberyard.setBlocked(false);
        lumberyard.setDescription("All of the lumber is stored here");
        lumberyard.setMapSymbol(" LU ");
        lumberyard.setTravelTime(60);
        itemsStored = new InventoryItem[1];
        itemsStored[0] = inventory[Constants.ITEM_LUMBER];
        lumberyard.setItemsStored(itemsStored);
        ImageIcon lumberyardImage = MapControl.getImage(lumberyard, 
                "/citbyui/cit260/curiousworkmanship/images/lumberyard.jpeg");
        lumberyard.setIcon(lumberyardImage);
        scenes[Constants.LUMBERYARD] = lumberyard;



        Question[] questions = new Question[2];
        questions[0] = new Question(
                        "Lord, what should we do here in this land of Bountiful?", 
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
                                      Constants.KNOWLEDGE_SCENE,
                                      "You have come to the tops of the mountains. "
                                      + "This is the place where Nephi was instruced "
                                      + "to go to receive further instructions "
                                      + "from the Lord.",
                                      " HM ",
                                      null,
                                      720,
                                      false,
                                      questions);

        ImageIcon highMountainImage = MapControl.getImage(highMountain, 
                "/citbyui/cit260/curiousworkmanship/images/highmounttop.jpeg");
        highMountain.setIcon(highMountainImage);
        scenes[Constants.HIGHMOUNTAIN] = highMountain;

        Scene instructionScene = new Scene();
        instructionScene.setDescription(
                    "The voice of the Lord comes unto Nephi,"
                    + "\nArise, and get thee into the montain.");
        instructionScene.setMapSymbol(" IN ");
        instructionScene.setBlocked(false);
        instructionScene.setTravelTime(480);   
        ImageIcon instructionsImage = MapControl.getImage(instructionScene, 
                "/citbyui/cit260/curiousworkmanship/images/nephiInstructions.jpg");
        instructionScene.setIcon(instructionsImage);
        scenes[Constants.INSTRUCTIONS] = instructionScene;


        Scene rebellionScene = new Scene();
        rebellionScene.setDescription(
                  "\nLaman and Lemuel have refused to help you build a ship. "
                + "\nNephi chastizes and rebukes them.");
        rebellionScene.setMapSymbol(" RB ");
        rebellionScene.setBlocked(false);
        rebellionScene.setTravelTime(10000);
        ImageIcon rebellionSceneImage = MapControl.getImage(rebellionScene, 
                "/citbyui/cit260/curiousworkmanship/images/rebellion.jpg");
        rebellionScene.setIcon(rebellionSceneImage);
        scenes[Constants.REBELLION] = rebellionScene;


        Scene boatyardScene = new Scene();
        boatyardScene.setDescription(
                  "\nThis is the boatyard where you work on building the ship. ");
        boatyardScene.setMapSymbol(" BY ");
        boatyardScene.setBlocked(false);
        boatyardScene.setTravelTime(600);
        ImageIcon boatyardSceneImage = MapControl.getImage(boatyardScene, 
                "/citbyui/cit260/curiousworkmanship/images/boatyard.jpeg");
        boatyardScene.setIcon(boatyardSceneImage);
        scenes[Constants.BOATYARD] = boatyardScene;


        Scene blacksmithScene = new Scene();
        blacksmithScene.setDescription(
                  "\nThis is the blacksmith where you work on building the ship. ");
        blacksmithScene.setMapSymbol(" BY ");
        blacksmithScene.setBlocked(false);
        blacksmithScene.setTravelTime(600);
        ImageIcon blacksmithSceneImage = MapControl.getImage(blacksmithScene, 
                "/citbyui/cit260/curiousworkmanship/images/blacksmith.jpeg");
        blacksmithScene.setIcon(blacksmithSceneImage);
        scenes[Constants.BLACKSMITH] = blacksmithScene;


        Scene campScene = new Scene();
        campScene.setDescription(
                  "\nThis is the camp where you work on building the ship. ");
        campScene.setMapSymbol(" BY ");
        campScene.setBlocked(false);
        campScene.setTravelTime(600);
        ImageIcon campSceneImage = MapControl.getImage(campScene, 
                "/citbyui/cit260/curiousworkmanship/images/camp.jpg");
        campScene.setIcon(campSceneImage);
        scenes[Constants.CAMP] = campScene;


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
        locations[11][8].setScene(scenes[Constants.WATER]);
        locations[9][14].setScene(scenes[Constants.WATER]);
        locations[9][5].setScene(scenes[Constants.IRON]);
        locations[8][6].setScene(scenes[Constants.IRON]);
        locations[7][15].setScene(scenes[Constants.IRON]);
        locations[5][4].setScene(scenes[Constants.HONEY]);
        locations[14][7].setScene(scenes[Constants.HONEY]);
        locations[2][12].setScene(scenes[Constants.HONEY]);
        locations[6][13].setScene(scenes[Constants.HONEY]);
        locations[11][17].setScene(scenes[Constants.HONEY]);
        locations[15][16].setScene(scenes[Constants.HONEY]);
        locations[6][7].setScene(scenes[Constants.RYE]);
        locations[7][7].setScene(scenes[Constants.RYE]);
        locations[8][11].setScene(scenes[Constants.CHICKPEAS]);
        locations[6][11].setScene(scenes[Constants.WHEAT]);
        locations[10][11].setScene(scenes[Constants.WHEAT]);
        locations[11][11].setScene(scenes[Constants.WHEAT]);
        locations[12][11].setScene(scenes[Constants.RICE]);
        locations[13][11].setScene(scenes[Constants.RICE]);
        locations[4][15].setScene(scenes[Constants.OLIVEORCHARD]);
        locations[5][16].setScene(scenes[Constants.OLIVEORCHARD]);
        locations[6][17].setScene(scenes[Constants.OLIVEORCHARD]);
        locations[7][15].setScene(scenes[Constants.OLIVEORCHARD]);
        locations[12][14].setScene(scenes[Constants.OLIVEORCHARD]);
        locations[12][15].setScene(scenes[Constants.OLIVEORCHARD]);
        locations[12][16].setScene(scenes[Constants.OLIVEORCHARD]);
        locations[12][6].setScene(scenes[Constants.LUMBER]);
        locations[1][8].setScene(scenes[Constants.LUMBER]);
        locations[1][9].setScene(scenes[Constants.LUMBER]);
        locations[2][8].setScene(scenes[Constants.LUMBER]);
        locations[2][9].setScene(scenes[Constants.LUMBER]);
        locations[2][13].setScene(scenes[Constants.LUMBER]);
        locations[3][12].setScene(scenes[Constants.LUMBER]);
        locations[3][13].setScene(scenes[Constants.LUMBER]);
        locations[3][14].setScene(scenes[Constants.LUMBER]);
        locations[4][13].setScene(scenes[Constants.LUMBER]);
        locations[4][14].setScene(scenes[Constants.LUMBER]);
        locations[5][13].setScene(scenes[Constants.LUMBER]);
        locations[9][16].setScene(scenes[Constants.LUMBER]);
        locations[9][17].setScene(scenes[Constants.LUMBER]);
        locations[10][16].setScene(scenes[Constants.LUMBER]);
        locations[11][6].setScene(scenes[Constants.LUMBER]);
        locations[12][5].setScene(scenes[Constants.LUMBER]);
        locations[11][14].setScene(scenes[Constants.LUMBER]);
        locations[3][9].setScene(scenes[Constants.CHICKPEAS]);
        locations[7][11].setScene(scenes[Constants.CHICKPEAS]);
        locations[4][9].setScene(scenes[Constants.LENTIL]);
        locations[5][9].setScene(scenes[Constants.LENTIL]);
        locations[7][11].setScene(scenes[Constants.CHICKPEAS]);
        locations[7][13].setScene(scenes[Constants.FABABEAN]);
        locations[9][10].setScene(scenes[Constants.FORDE]); 
        locations[10][6].setScene(scenes[Constants.SALT]);
        locations[18][3].setScene(scenes[Constants.BOATYARD]);
        locations[19][3].setScene(scenes[Constants.FINISH]);
        locations[1][2].setScene(scenes[Constants.INSTRUCTIONS]);
        locations[7][4].setScene(scenes[Constants.HIGHMOUNTAIN]);
        locations[13][5].setScene(scenes[Constants.REBELLION]);
        locations[16][4].setScene(scenes[Constants.TOOLSHED]);
        locations[16][5].setScene(scenes[Constants.BLACKSMITH]);
        locations[16][6].setScene(scenes[Constants.WAREHOUSE]);
        locations[14][5].setScene(scenes[Constants.CAMP]);


    }


    public static void moveActorsToStartingLocation(Map map) 
                            throws MapControlException {
        Location[][] locations = map.getLocations();

        // for every actor
        Actor[] actors = Actor.values();

        for (Actor actor : actors) {
            int row = actor.getCoordinates().x;
            int column = actor.getCoordinates().y;
            Location location = locations[row][column];
            location.addActor(actor); // add actor to new location
            location.setVisited(true); // mark as a visted locations
        }
}
    
    
        
    
    public static void moveActorToLocation(Actor actor, Point coordinates) 
                            throws MapControlException {
        
        Map map = CuriousWorkmanship.getCurrentGame().getMap();
        int newRow = coordinates.x-1;
        int newColumn = coordinates.y-1;
        
        if (newRow < 0  || newRow >= map.getNoOfRows() ||
            newColumn < 0  || newColumn >= map.getNoOfColumns()) {
            throw new MapControlException("The Row or newColumn number is outside bounds of the map");
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
    
    
    public static ImageIcon getImage(Object object, String location) throws MapControlException {
        ImageIcon icon = null;
//        
//        URL url = object.getClass().getResource(location);
//        
//        try {
//            icon = new ImageIcon(url);
//        } catch (Exception ex) {
//            thnewRow new MapControlException("Error reading file: "
//                    + location + "\n\t" + ex.getMessage());
//        }
//        
        return icon;
    }

    
    
}
