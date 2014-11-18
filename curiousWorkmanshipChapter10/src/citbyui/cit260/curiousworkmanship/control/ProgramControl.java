/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package citbyui.cit260.curiousworkmanship.control;

import citbyui.cit260.curiousworkmanship.model.Game;
import citbyui.cit260.curiousworkmanship.model.Player;

/**
 *
 * @author jacksonrkj
 */


public class ProgramControl {
    
    private static Player player = null; // current player of the game
    private static Game game = null; // current game being played
    
    
    

    public static Player getPlayer() {
        return player;
    }

    public static void setPlayer(Player player) {
        ProgramControl.player = player;
    }

    public static Game getGame() {
        return game;
    }

    public static void setGame(Game game) {
        ProgramControl.game = game;
    }
    
    
    
      
    private final static int INVENTORY_COUNT = 10;
    
    
    public static Player createPlayer(String name) {
        
        Player player = new Player();
        player.setName(name);
        
        ProgramControl.setPlayer(player); // save the player
        
        return player;
    }

    public static void saveGame(Game game, String filepath) {
       // TODO
        System.out.println("\n**** saveGame stub ****");
    }
    
}
