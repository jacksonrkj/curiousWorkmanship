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
    
    private Game game;
    private Player player; 

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    
    
    public Player createPlayer(String name) {
        
        player = new Player();
        player.setName(name);
        
        return player;
    
    }

    public void saveGame() {
       // TODO
        System.out.println("\n**** saveGame stub ****");
    }
    
    
}
