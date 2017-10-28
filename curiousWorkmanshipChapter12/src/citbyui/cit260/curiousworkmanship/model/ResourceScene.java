/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package citbyui.cit260.curiousworkmanship.model;

import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;

/**
 *
 * @author jacksonrkj
 */
public class ResourceScene extends Scene {
    
    private double amountOfResource;
    private int resourceType;

    public ResourceScene() {
    }

    public ResourceScene(int sceneType, String description, 
                         String mapSymbol, 
                         ImageIcon image, 
                         double travelTime, 
                         boolean blocked, 
                         double amountOfResource,
                         int resourceType) {
        super(sceneType, description, mapSymbol, travelTime, blocked, image);
        this.amountOfResource = amountOfResource;
        this.resourceType = resourceType;
    }



    public double getAmountOfResource() {
        return amountOfResource;
    }

    public void setAmountOfResource(double amountOfResource) {
        this.amountOfResource = amountOfResource;
    }

    public int getResourceType() {
        return resourceType;
    }

    public void setResourceType(int resourceType) {
        this.resourceType = resourceType;
    }



    
    
}
