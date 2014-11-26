/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package citbyui.cit260.curiousworkmanship.model;

import citbyui.cit260.curiousworkmanship.enums.Actor;
import java.awt.Point;
import java.io.Serializable;

/**
 *
 * @author jacksonrkj
 */

public class Game implements Serializable {
    
    private double totalTime;
   
    private Player player;
    private InventoryItem[] inventory; 
    private Wagon wagon;
    private Ship ship;
    private Map map;
    private Point[] actorLocations = new Point[Actor.values().length];

    public Game() {
        this.totalTime = 0;
    }

    public double getTotalTime() {
        return totalTime;
    }

    public void setTotalTime(double totalTime) {
        this.totalTime = totalTime;
    }

    public Ship getShip() {
        return ship;
    }

    public void setShip(Ship ship) {
        this.ship = ship;
    }
    
    public InventoryItem[] getInventory() {
        return inventory;
    }

    public void setInventory(InventoryItem[] inventory) {
        this.inventory = inventory;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }


    public Wagon getWagon() {
        return wagon;
    }

    public void setWagon(Wagon wagon) {
        this.wagon = wagon;
    }

    public Map getMap() {
        return map;
    }

    public void setMap(Map map) {
        this.map = map;
    }

    public Point[] getActorLocations() {
        return actorLocations;
    }

    public void setActorLocations(Point[] actorLocations) {
        this.actorLocations = actorLocations;
    }

    


    
    @Override
    public String toString() {
        return "Game{" + "totalTime=" + totalTime + ", player=" + player.toString() + '}';
    }
   
    
}
