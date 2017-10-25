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

public class Player implements Serializable {
    
    private String name;
    private double time;

    public Player() {
    }

    public Player(String name, double time) {
        this.name = name;
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getTime() {
        return time;
    }

    public void setTime(double time) {
        this.time = time;
    }
 }

//    @Override
//    public String toString() {
//        return "Player{" + "name=" + name + ", time=" + time + '}';
//    }
//
//    @Override
//    public int hashCode() {
//        int hash = 5;
//        hash = 23 * hash + Objects.hashCode(this.name);
//        hash = 23 * hash + (int) (Double.doubleToLongBits(this.time) ^ (Double.doubleToLongBits(this.time) >>> 32));
//        return hash;
//    }
//
//    @Override
//    public boolean equals(Object obj) {
//        if (obj == null) {
//            return false;
//        }
//        if (getClass() != obj.getClass()) {
//            return false;
//        }
//        final Player other = (Player) obj;
//        if (!Objects.equals(this.name, other.name)) {
//            return false;
//        }
//        if (Double.doubleToLongBits(this.time) != Double.doubleToLongBits(other.time)) {
//            return false;
//        }
//        return true;
//    }
//    
//    
//    
//}
