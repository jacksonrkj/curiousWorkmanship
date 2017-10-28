/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package citbyui.cit260.curiousworkmanship.model;

import citbyui.cit260.curiousworkmanship.enums.SceneGroup;
import citbyui.cit260.curiousworkmanship.enums.SceneType;

/**
 *
 * @author jacksonrkj
 */
public class ConstructionScene extends Scene {
    private InventoryItem[] requiredItems = new InventoryItem[5];

    public ConstructionScene() {
    }

    public ConstructionScene(SceneGroup sceneGroup, 
                             String description, 
                             String mapSymbol, 
                             double travelTime, 
                             boolean blocked,
                             InventoryItem[] requiredItems) {
        super(sceneGroup, description, mapSymbol, travelTime, blocked);
        this.requiredItems = requiredItems;
    }

    public InventoryItem[] getRequiredItems() {
        return requiredItems;
    }

    public void setRequiredItems(InventoryItem[] requiredItems) {
        this.requiredItems = requiredItems;
    }
    
    
    
}
