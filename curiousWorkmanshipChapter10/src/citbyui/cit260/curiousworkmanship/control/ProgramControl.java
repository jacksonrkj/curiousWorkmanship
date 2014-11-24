/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package citbyui.cit260.curiousworkmanship.control;

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

    
    
}
