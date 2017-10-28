/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package citbyui.cit260.curiousworkmanship.model;

import javax.swing.ImageIcon;

/**
 *
 * @author jacksonrkj
 */
public class ConstructionScene extends Scene {
    private InventoryItem[] requiredItems = new InventoryItem[5];

    public ConstructionScene() {
    }

    public ConstructionScene(int sceneType, 
                             String description, 
                             String mapSymbol,
                             ImageIcon image, 
                             double travelTime, 
                             boolean blocked,
                             InventoryItem[] requiredItems) {
        super(sceneType, description, mapSymbol, travelTime, blocked,image);
        this.requiredItems = requiredItems;
    }

    public InventoryItem[] getRequiredItems() {
        return requiredItems;
    }

    public void setRequiredItems(InventoryItem[] requiredItems) {
        this.requiredItems = requiredItems;
    }
    
    
    
}
