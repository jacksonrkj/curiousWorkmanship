/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package citbyui.cit260.curiousworkmanship.model;

import citbyui.cit260.curiousworkmanship.enums.SceneGroup;
import java.io.Serializable;

/**
 *
 * @author jacksonrkj
 */
public class Scene implements Serializable {
   
    private SceneGroup sceneGroup;
    private String description;
    private String mapSymbol;
    private double travelTime;
    private boolean blocked;
   
    public Scene() {
    }

    public Scene(SceneGroup sceneGroup, String description, String mapSymbol, double travelTime, boolean blocked) {
        this.sceneGroup = sceneGroup;
        this.description = description;
        this.mapSymbol = mapSymbol;
        this.travelTime = travelTime;
        this.blocked = blocked;
    }

    public SceneGroup getSceneGroup() {
        return sceneGroup;
    }

    public void setSceneGroup(SceneGroup sceneGroup) {
        this.sceneGroup = sceneGroup;
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

    public boolean isBlocked() {
        return blocked;
    }

    public void setBlocked(boolean blocked) {
        this.blocked = blocked;
    }
    
    
    
}
