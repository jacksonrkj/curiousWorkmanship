/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package citbyui.cit260.curiousworkmanship.model;

import java.util.Objects;

/**
 *
 * @author jacksonrkj
 */
public class WarehouseScene {
        
    private int sceneType;
    private String description;
    private String mapSymbol;
    private double travelTime;
    private double capacity;

    public WarehouseScene() {
    }

    public WarehouseScene(int sceneType, String description, String mapSymbol, double travelTime, double capacity) {
        this.sceneType = sceneType;
        this.description = description;
        this.mapSymbol = mapSymbol;
        this.travelTime = travelTime;
        this.capacity = capacity;
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

    public double getCapacity() {
        return capacity;
    }

    public void setCapacity(double capacity) {
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return "WarehouseScene{" + "sceneType=" + sceneType + ", description=" + description + ", mapSymbol=" + mapSymbol + ", travelTime=" + travelTime + ", capacity=" + capacity + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 11 * hash + this.sceneType;
        hash = 11 * hash + Objects.hashCode(this.description);
        hash = 11 * hash + Objects.hashCode(this.mapSymbol);
        hash = 11 * hash + (int) (Double.doubleToLongBits(this.travelTime) ^ (Double.doubleToLongBits(this.travelTime) >>> 32));
        hash = 11 * hash + (int) (Double.doubleToLongBits(this.capacity) ^ (Double.doubleToLongBits(this.capacity) >>> 32));
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
        final WarehouseScene other = (WarehouseScene) obj;
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
        if (Double.doubleToLongBits(this.capacity) != Double.doubleToLongBits(other.capacity)) {
            return false;
        }
        return true;
    }
    
    
    
}
