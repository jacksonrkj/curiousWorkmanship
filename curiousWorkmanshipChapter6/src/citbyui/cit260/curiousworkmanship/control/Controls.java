/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package citbyui.cit260.curiousworkmanship.control;

import citbyui.cit260.curiousworkmanship.model.Game;

/**
 * This class contains constants used in the control layer
 * @author jacksonrkj
 */
public final class Controls {
    
    private final static ProgramControl programControl = new ProgramControl();    
    private final static GameControl gameControl = new GameControl();    
    private final static InventoryControl inventoryControl = new InventoryControl();
    private static Game currentGame = null;
    
    public static ProgramControl getProgramControl() {
        return programControl;
    }

    public static GameControl getGameControl() {
        return gameControl;
    }

    public static InventoryControl getInventoryControl() {
        return inventoryControl;
    }

    public static Game getCurrentGame() {
        return currentGame;
    }

    public static void setCurrentGame(Game currentGame) {
        Controls.currentGame = currentGame;
    }
    
    
}
