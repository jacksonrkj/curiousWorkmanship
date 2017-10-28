/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package citbyui.cit260.curiousworkmanship.enums;

/**
 *
 * @author jacksonrkj
 */


public enum Item {    
    lumber("raw", "feet"),
    ore("raw", "tons"),
    grain("food", "pounds"),
    legume("food", "pounds"),
    oil("food", "gallons"),
    water("food", "gallons"),
    honey("food", "gallons"),
    salt("food", "pounds"),
    axe("tool",""),
    hammer("tool", ""),
    drill("tool", ""),
    shovel("tool", ""),
    sickle("tool", ""),
    saw("tool", ""),
    nails("tool", "pounds");
    
    private String itemType;
    private String unitsOfMeasure;

    private Item(String itemType, String unitsOfMeasure) {
        this.itemType = itemType;
        this.unitsOfMeasure = unitsOfMeasure;
    }

    public String getItemType() {
        return itemType;
    }

    public String getUnitsOfMeasure() {
        return unitsOfMeasure;
    }

  
    
}
