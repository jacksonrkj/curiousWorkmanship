/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package citbyui.cit260.curiousworkmanship.control;

import citbyui.cit260.curiousworkmanship.enums.Item;
import citbyui.cit260.curiousworkmanship.model.Barrel;
import citbyui.cit260.curiousworkmanship.model.InventoryItem;

/**
 *
 * @author jacksonrkj
 */
public class InventoryControl {

    public static int buildBarrels(Item item, double diameter, double height, int noOfBarrels) {
        System.out.println("\n***buildBarrels() called");
        return 1;
    }

    /*
     Calculates the volume of a barrel
     @param height The height of the barrel in inches
     @param diameter The diameter of the barrel in inches
     @returns The volume of the barren in cubic feet.
     */
    public double calVolumeOfBarrel(double height, double diameter) {

        if (height < 0) { // height is negative?
            return -1;
        }

        if (diameter < 0 || diameter > 36) { // diameter out of range?
            return -1;
        }

        double radius = diameter / 2;
        double volume = (Math.PI * Math.pow(radius, 2) * height) / 1728;

        return volume;

    }

    /*
     * Calculates the number of barrels needed for the given commodity
     * @param numberOfPeople The number of people traveling on the ship
     * @param numberOfDays The estimated total number days of the trip
     * @param amountNeededPerDay The amount of the commodity needed per day in cubic feet
     * @param volumeOfBarrel The volume of the barrel in cubic feet
     * @returns The number of barrels needed for that commodity
     */
    public long calculateBarrelsNeeded(double amountNeededPerDay, double amountPerCubicFoot, long noOfPeople, double noOfDays, Barrel barrel
    ) {

        if (amountNeededPerDay < 0) {
            return -1;
        }

        if (amountPerCubicFoot < 0) {
            return -1;
        }

        if (barrel == null || !(barrel instanceof Barrel)) {
            return -1;
        }

        double totalVolumeNeeded = (noOfPeople * noOfDays * amountNeededPerDay) / amountPerCubicFoot;
        double volumeOfBarrel = this.calVolumeOfBarrel(barrel.getHeight(), barrel.getDiameter());
        long numberOfBarrelsOfNeeded = (long) (totalVolumeNeeded / volumeOfBarrel);

        return numberOfBarrelsOfNeeded;
    }


    public static void sortByDescription(InventoryItem[] items) {

        InventoryItem tempItem;
        for (int i = 0; i < items.length-1; i++) {
            for (int j = 0; j < items.length-1-i; j++) {
                if (items[j].getDescription().compareToIgnoreCase(items[j + 1].getDescription()) > 0) {
                    tempItem = items[j];
                    items[j] = items[j+1];
                    items[j+1] = tempItem;
                }
            }
        }

    }

}
