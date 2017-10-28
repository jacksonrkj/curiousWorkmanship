/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package citbyui.cit260.curiousworkmanship.control;

import citbyui.cit260.curiousworkmanship.exceptions.BarrelControlException;
import citbyui.cit260.curiousworkmanship.model.InventoryItem;
import curiousworkmanship.CuriousWorkmanship;

/**
 *
 * @author jacksonrkj
 */
public class BarrelControl {
    
    public static InventoryItem designBarrel(int inventoryType, int width, int height) throws BarrelControlException {
        
        if (inventoryType < 0 || inventoryType >= CuriousWorkmanship.getCurrentGame().getInventory().length) {
            throw new BarrelControlException("Invalid inventory type specified");
        }
        
        if (width < 0 || height < 0) {
            throw new BarrelControlException("The width and height of the barrel must be greater than zero");
        }
        
        // caculate max weight of barrel
        
        // if barrel is too heavy then throw exceptions
        
        // create barrel and add to the inventory item.
        
        return null;
    }
    
}
