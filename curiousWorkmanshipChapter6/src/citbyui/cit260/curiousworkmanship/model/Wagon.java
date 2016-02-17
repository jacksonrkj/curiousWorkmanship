/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package citbyui.cit260.curiousworkmanship.model;

import java.io.Serializable;

/**
 *
 * @author jacksonrkj
 */
public class Wagon implements Serializable {
    
    private long numberBarrelsLoaded;
    private double maxWeight;
    private double loadedWeight;

    public Wagon() {
        this.numberBarrelsLoaded = 0;
        this.maxWeight = 1000;
        this.loadedWeight = 0;
    }

    public long getNumberBarrelsLoaded() {
        return numberBarrelsLoaded;
    }

    public void setNumberBarrelsLoaded(long numberBarrelsLoaded) {
        this.numberBarrelsLoaded = numberBarrelsLoaded;
    }

    public double getMaxWeight() {
        return maxWeight;
    }

    public void setMaxWeight(double maxWeight) {
        this.maxWeight = maxWeight;
    }

    public double getLoadedWeight() {
        return loadedWeight;
    }

    public void setLoadedWeight(double loadedWeight) {
        this.loadedWeight = loadedWeight;
    }

    @Override
    public String toString() {
        return "Wagon{" + "numberLoaded=" + numberBarrelsLoaded + ", maxWeight=" + maxWeight + ", loadedWeight=" + loadedWeight + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 13 * hash + (int) (this.numberBarrelsLoaded ^ (this.numberBarrelsLoaded >>> 32));
        hash = 13 * hash + (int) (Double.doubleToLongBits(this.maxWeight) ^ (Double.doubleToLongBits(this.maxWeight) >>> 32));
        hash = 13 * hash + (int) (Double.doubleToLongBits(this.loadedWeight) ^ (Double.doubleToLongBits(this.loadedWeight) >>> 32));
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
        final Wagon other = (Wagon) obj;
        if (this.numberBarrelsLoaded != other.numberBarrelsLoaded) {
            return false;
        }
        if (Double.doubleToLongBits(this.maxWeight) != Double.doubleToLongBits(other.maxWeight)) {
            return false;
        }
        if (Double.doubleToLongBits(this.loadedWeight) != Double.doubleToLongBits(other.loadedWeight)) {
            return false;
        }
        return true;
    }
    
    
    
}
