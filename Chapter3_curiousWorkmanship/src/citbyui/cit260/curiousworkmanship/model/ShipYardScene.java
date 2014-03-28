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
public class ShipYardScene implements Serializable {
        
    private int sceneType;
    private String description;
    private String mapSymbol;
    private double travelTime;

    public ShipYardScene(int sceneType, String description, String mapSymbol, double travelTime) {
        this.sceneType = sceneType;
        this.description = description;
        this.mapSymbol = mapSymbol;
        this.travelTime = travelTime;
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

    @Override
    public String toString() {
        return "ShipYardScene{" + "sceneType=" + sceneType + ", description=" + description + ", mapSymbol=" + mapSymbol + ", travelTime=" + travelTime + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 83 * hash + this.sceneType;
        hash = 83 * hash + Objects.hashCode(this.description);
        hash = 83 * hash + Objects.hashCode(this.mapSymbol);
        hash = 83 * hash + (int) (Double.doubleToLongBits(this.travelTime) ^ (Double.doubleToLongBits(this.travelTime) >>> 32));
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
        final ShipYardScene other = (ShipYardScene) obj;
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
        return true;
    }
    
    
    
}
