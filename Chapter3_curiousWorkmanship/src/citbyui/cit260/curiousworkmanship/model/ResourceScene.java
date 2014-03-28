/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package citbyui.cit260.curiousworkmanship.model;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author jacksonrkj
 */
public class ResourceScene implements Serializable {
    
    private int sceneType;
    private String description;
    private String mapSymbol;
    private double travelTime;
    private double amountOfResource;

    public ResourceScene() {
    }

    public ResourceScene(int sceneType, String description, String mapSymbol, double travelTime, double amountOfResource, boolean blocked) {
        this.sceneType = sceneType;
        this.description = description;
        this.mapSymbol = mapSymbol;
        this.travelTime = travelTime;
        this.amountOfResource = amountOfResource;
    }

    public int getSceneType() {
        return sceneType;
    }

    public void setSceneType(int sceneType) {
        this.sceneType = sceneType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMapSymbol() {
        return mapSymbol;
    }

    public void setMapSymbol(String mapSymbol) {
        this.mapSymbol = mapSymbol;
    }

    public double getTravelTime() {
        return travelTime;
    }

    public void setTravelTime(double travelTime) {
        this.travelTime = travelTime;
    }

    public double getAmountOfResource() {
        return amountOfResource;
    }

    public void setAmountOfResource(double amountOfResource) {
        this.amountOfResource = amountOfResource;
    }

    @Override
    public String toString() {
        return "ResourceScene{" + "sceneType=" + sceneType + ", description=" + description + ", mapSymbol=" + mapSymbol + ", travelTime=" + travelTime + ", amountOfResource=" + amountOfResource  + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + this.sceneType;
        hash = 83 * hash + Objects.hashCode(this.description);
        hash = 83 * hash + Objects.hashCode(this.mapSymbol);
        hash = 83 * hash + (int) (Double.doubleToLongBits(this.travelTime) ^ (Double.doubleToLongBits(this.travelTime) >>> 32));
        hash = 83 * hash + (int) (Double.doubleToLongBits(this.amountOfResource) ^ (Double.doubleToLongBits(this.amountOfResource) >>> 32));
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ResourceScene other = (ResourceScene) obj;
        if (this.sceneType != other.sceneType) {
            return false;
        }
        if (!Objects.equals(this.description, other.description)) {
            return false;
        }
        if (!Objects.equals(this.mapSymbol, other.mapSymbol)) {
            return false;
        }
        if (Double.doubleToLongBits(this.travelTime) != Double.doubleToLongBits(other.travelTime)) {
            return false;
        }
        if (Double.doubleToLongBits(this.amountOfResource) != Double.doubleToLongBits(other.amountOfResource)) {
            return false;
        }
        return true;
    }

 
    
}
