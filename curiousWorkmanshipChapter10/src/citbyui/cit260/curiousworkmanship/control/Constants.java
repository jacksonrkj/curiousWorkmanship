/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package citbyui.cit260.curiousworkmanship.control;

/**
 *
 * @author jacksonrkj
 */
public class Constants {
    
    public final static int NUMBER_OF_INVENTORY_ITEMS = 15;
    public final static int NUMBER_OF_ACTORS = 8;
    
    public final static int REGULAR_SCENE = 0;
    public final static int KNOWLEDGE_SCENE = 1;
    public final static int RESOURCE_SCENE = 2;
    public final static int WAREHOUSE_SCENE = 3; 
    
    // INVENTORY ITEM TYPES
    public final static int ITEM_LUMBER = 0;
    public final static int ITEM_ORE = 1;
    public final static int ITEM_GRAIN = 2;
    public final static int ITEM_LEGUME = 3;
    public final static int ITEM_OIL = 4;
    public final static int ITEM_WATER = 5;
    public final static int ITEM_HONEY = 6;
    public final static int ITEM_SALT = 7;
    public final static int ITEM_AXE = 8;
    public final static int ITEM_HAMMER = 9;
    public final static int ITEM_DRILL = 10;
    public final static int ITEM_SHOVEL = 11;
    public final static int ITEM_SICKLE = 12;
    public final static int ITEM_SAW = 13;
    public final static int ITEM_NAILS = 14;

    
    
    // SCENES TYPES
    public final static int START = 0;
    public final static int ANGEL = 1;
    public final static int LUMBER = 2;
    public final static int IRON  = 3;
    public final static int RYE = 4;
    public final static int RICE = 5;
    public final static int WHEAT = 6;
    public final static int OLIVEORCHARD = 7;
    public final static int LENTIL = 8;
    public final static int FABABEAN = 9;
    public final static int WATER = 10;
    public final static int HONEY = 11;
    public final static int SALT = 12;
    public final static int CLIFF = 13;
    public final static int OCEAN = 14;
    public final static int DESERT = 15;
    public final static int RIVER = 16;
    public final static int BEACH = 17;
    public final static int SWAMP = 18;
    public final static int SAVANA = 19;
    public final static int FOREST = 20;
    public final static int MOUNTAIN = 21;
    public final static int FORDE = 22;
    public final static int BRIDGE = 23;
    public final static int TOOLSHED = 24;
    public final static int LUMBERYARD = 25;
    public final static int WAREHOUSE = 26;
    public final static int CHICKPEAS = 27;
    public final static int BLACKSMITH = 28;
    public final static int BOATYARD = 29;
    public final static int REBELLION = 30;
    public final static int VILLAGE = 31;
    public final static int FINISH = 32;

    
    public final static double GRAIN_POUNDS_PER_CUBIC_FOOT = 48.18;
    public final static double LEGUMES_POUNDS_PER_CUBIC_FOOT = 48.18;
    public final static double HONEY_POUNDS_PER_CUBIC_FOOT = 7.48;
    public final static double SALT_POUNDS_PER_CUBIC_FOOT = 79.0;
    public final static double OIL_POUNDS_PER_CUBIC_FOOT = 57.0;
    public final static double WATER_POUNDS_PER_CUBIC_FOOT = 62.4280;
    public final static double LUMBER_POUNDS_PER_CUBIC_FOOT = 45.00;
    public final static double ORE_POUNDS_PER_CUBIC_FOOT = 156.06;
    
    
    public final static long GRAIN_RECOMMENDED_PER_YEAR = 300;
    public final static long LEGUMES_RECOMMENDED_PER_YEAR = 60;
    public final static long HONEY_RECOMMENDED_PER_YEAR = 60;
    public final static long SALT_RECOMMENDED_PER_YEAR = 5;
    public final static long OIL_RECOMMENDED_PER_YEAR = 4;
    public final static long WATER_RECOMMENDED_PER_YEAR = 730;
    
    
    public final static double GRAIN_RECOMMENDED_PER_DAY = 0.8334;
    public final static double LEGUMES_RECOMMENDED_PER_DAY = 0.1644;
    public final static double HONEY_RECOMMENDED_PER_DAY = 0.1644;
    public final static double SALT_RECOMMENDED_PER_DAY = 0.01369;
    public final static double OIL_RECOMMENDED_PER_DAY = 0.03562;
    public final static double WATER_RECOMMENDED_PER_DAY = 12.85592;
    
    public final static int LEHI = 0;
    public final static int SARAH = 1;
    public final static int NEPHI = 2;
    public final static int JACOB = 3;
    public final static int SAM = 4;
    public final static int LAMAN = 5;
    public final static int LEMUEL = 6;
    public final static int ZORAM = 7;
    
    public final static int MAP_ROW_COUNT = 10;
    public final static int MAP_COLUMN_COUNT = 10;
    public final static int ACTOR_COUNT = 8;
    public final static int NUMBER_OF_SCENES = 33;
    
    // miles saudia arabia to panama via pacific (14328 miles)
    // miles saudia arabia to panama via alantic (7741 miles)
    // minimum speed 1.5 miles per hour
    // maximum speed 4.3 miles per hour
    // minimum days 14328 / 2.3 / 24;
    // average speed (4.3 + 1.5) / 2 = 2.9
    
    // 1 deviation range (avg * 34%) = .98 (low 1.92 - 3.88 high)
    // 2 deviation range (avg * 49%) =  1.421 (low 1.48 - 4.32 high)
    
    public final static double TRIP_DISTANCE = 14328;
    public final static double MIN_SPEED = 1.5;
    public final static double MAX_SPEED = 4.3;  
    public final static double DEV_ONE_LOW = 1.92;
    public final static double DEV_ONE_HIGH = 3.88;
    public final static double DEV_TWO_LOW = 1.48;  
    public final static double DEV_TWO_HIGH = 4.32;
    public final static int MIN_PERSONS_SAILING = 20;
    public final static int MAX_PERSONS_SAILING = 68;
    
    
    
    
}
