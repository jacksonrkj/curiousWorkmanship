/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package curiousworkmanship;

import citbyui.cit260.curiousworkmanship.model.Game;
import citbyui.cit260.curiousworkmanship.model.Player;
import citbyui.cit260.curiousworkmanship.view.StartProgramViewOrig;


public class CuriousWorkmanship {
    
    private static Game currentGame = null;
    private static Player player = null;   
    
    
    

    public static void main(String[] args) {  
        // create StartProgramViewOrig and start the program
        StartProgramViewOrig startProgramView = new StartProgramViewOrig();
        startProgramView.displayStartProgramView();
    }

    
    
    
    
    
    public static Game getCurrentGame() {
        return currentGame;
    }

    public static void setCurrentGame(Game currentGame) {
        CuriousWorkmanship.currentGame = currentGame;
    }

    public static Player getPlayer() {
        return player;
    }

    public static void setPlayer(Player player) {
        CuriousWorkmanship.player = player;
    }

    
    
    
}
