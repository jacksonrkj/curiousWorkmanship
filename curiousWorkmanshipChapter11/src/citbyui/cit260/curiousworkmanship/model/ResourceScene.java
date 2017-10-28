/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package citbyui.cit260.curiousworkmanship.model;

import citbyui.cit260.curiousworkmanship.enums.Item;
import citbyui.cit260.curiousworkmanship.enums.SceneGroup;

/**
 *
 * @author jacksonrkj
 */
public class ResourceScene extends Scene {
    
    private double amountOfResource;
    private Item resourceType;

    public ResourceScene() {
    }

    public ResourceScene(SceneGroup sceneGroup, String description, 
                         String mapSymbol, double travelTime, 
                         boolean blocked, double amountOfResource,
                         Item resourceType) {
        super(sceneGroup, description, mapSymbol, travelTime, blocked);
        this.amountOfResource = amountOfResource;
        this.resourceType = resourceType;
    }



    public double getAmountOfResource() {
        return amountOfResource;
    }

    public void setAmountOfResource(double amountOfResource) {
        this.amountOfResource = amountOfResource;
    }

    public Item getResourceType() {
        return resourceType;
    }

    public void setResourceType(Item resourceType) {
        this.resourceType = resourceType;
    }



    
    
}
