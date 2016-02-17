/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package citbyui.cit260.curiousworkmanship.model;

/**
 *
 * @author jacksonrkj
 */
public class WarehouseScene extends Scene {
        
    private InventoryItem[] itemsStored;

    public WarehouseScene() {
    }

    public WarehouseScene(int sceneType, String description, String mapSymbol, double travelTime, double capacity, InventoryItem[] itemsStored) {
        super(sceneType, description, mapSymbol, travelTime, true);
        this.itemsStored = itemsStored;
        
    }

    public InventoryItem[] getItemsStored() {
        return itemsStored;
    }

    public void setItemsStored(InventoryItem[] itemsStored) {
        this.itemsStored = itemsStored;
    }
    
    

    
}
