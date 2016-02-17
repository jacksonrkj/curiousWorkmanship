/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package citbyui.cit260.curiousworkmanship.control;

import citbyui.cit260.curiousworkmanship.model.Game;
import citbyui.cit260.curiousworkmanship.model.InventoryItem;
import citbyui.cit260.curiousworkmanship.model.Player;
import curiousworkmanship.CuriousWorkmanship;

/**
 *
 * @author jacksonrkj
 */
public class ProgramControl {
      
    private final static int INVENTORY_COUNT = 10;
    
    
    public static Player createPlayer(String name) {
        
        Player player = new Player();
        player.setName(name);
        
        CuriousWorkmanship.setPlayer(player); // save the player
        
        return player;
    }

    public static void saveGame(Game game, String filepath) {
       // TODO
        System.out.println("\n**** saveGame stub ****");
    }
    
    public void createInventoryList() {
        
        InventoryItem[] inventory = 
            new InventoryItem[ProgramControl.INVENTORY_COUNT];
        
        InventoryItem wheat = new InventoryItem();
        wheat.setDescription("Wheat");
        wheat.setQuantityInStock(0);
        wheat.setRequiredAmount(0);
        inventory[0] = wheat;
        
        InventoryItem honey = new InventoryItem();
        honey.setDescription("Honey");
        honey.setQuantityInStock(0);
        honey.setRequiredAmount(0);
        inventory[1] = honey;
        
        
        
        
        
        
    }
    
}
