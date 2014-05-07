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
public class Ship implements Serializable {
    
    private String description;
    private double width;
    private double length;
    private double height;
    private double sqFtOfSale;
    private double maxWeighCapacity;

    public Ship() {
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getSqFtOfSale() {
        return sqFtOfSale;
    }

    public void setSqFtOfSale(double sqFtOfSale) {
        this.sqFtOfSale = sqFtOfSale;
    }

    public double getMaxWeighCapacity() {
        return maxWeighCapacity;
    }

    public void setMaxWeighCapacity(double maxWeighCapacity) {
        this.maxWeighCapacity = maxWeighCapacity;
    }

    @Override
    public String toString() {
        return "Ship{" + "description=" + description + ", width=" + width + ", length=" + length + ", height=" + height + ", sqFtOfSale=" + sqFtOfSale + ", maxWeighCapacity=" + maxWeighCapacity + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 17 * hash + Objects.hashCode(this.description);
        hash = 17 * hash + (int) (Double.doubleToLongBits(this.width) ^ (Double.doubleToLongBits(this.width) >>> 32));
        hash = 17 * hash + (int) (Double.doubleToLongBits(this.length) ^ (Double.doubleToLongBits(this.length) >>> 32));
        hash = 17 * hash + (int) (Double.doubleToLongBits(this.height) ^ (Double.doubleToLongBits(this.height) >>> 32));
        hash = 17 * hash + (int) (Double.doubleToLongBits(this.sqFtOfSale) ^ (Double.doubleToLongBits(this.sqFtOfSale) >>> 32));
        hash = 17 * hash + (int) (Double.doubleToLongBits(this.maxWeighCapacity) ^ (Double.doubleToLongBits(this.maxWeighCapacity) >>> 32));
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
        final Ship other = (Ship) obj;
        if (!Objects.equals(this.description, other.description)) {
            return false;
        }
        if (Double.doubleToLongBits(this.width) != Double.doubleToLongBits(other.width)) {
            return false;
        }
        if (Double.doubleToLongBits(this.length) != Double.doubleToLongBits(other.length)) {
            return false;
        }
        if (Double.doubleToLongBits(this.height) != Double.doubleToLongBits(other.height)) {
            return false;
        }
        if (Double.doubleToLongBits(this.sqFtOfSale) != Double.doubleToLongBits(other.sqFtOfSale)) {
            return false;
        }
        if (Double.doubleToLongBits(this.maxWeighCapacity) != Double.doubleToLongBits(other.maxWeighCapacity)) {
            return false;
        }
        return true;
    }
    
    
            
    
}
