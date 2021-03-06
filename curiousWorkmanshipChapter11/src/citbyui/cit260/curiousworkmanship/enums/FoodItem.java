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
public enum FoodItem {
    grain("G", "Wheat, rice, and rye", 0.8334, 300, 48.18, "pound"),
    legumes("L", "Lentils, chickpeas and faba beans", 0.1644, 60, 48.18, "pound"),
    honey("H", "Honey sweetens every day", 0.1644, 60, 89.45, "pound"),
    salt("S", "Used for seasoning", 0.01369, 5.0, 79.0, "pound"),
    oil("O", "Used for cooking", 0.03562, 4.0, 45.00, "gallon"),
    water("W", "Water for washing, drinking and cooking", 12.85592, 730, 156.06, "gallon");

    private final String menuItem;
    private final String description;
    private final double poundsPerCubicFoot;
    private final double recommendedAmountPerDay;
    private final double recommendedAmountPerYear;
    private final String unitOfMeasure;

    private FoodItem(String menuItem, String description, double recommendedAmountPerDay, double recommendedAmountPerYear, double poundsPerCubicFoot, String unitOfMeasure) {
        this.menuItem = menuItem;
        this.description = description;
        this.poundsPerCubicFoot = poundsPerCubicFoot;
        this.recommendedAmountPerDay = recommendedAmountPerDay;
        this.recommendedAmountPerYear = recommendedAmountPerYear;
        this.unitOfMeasure = unitOfMeasure;
    }

    public String getMenuItem() {
        return menuItem;
    }

    public String getDescription() {
        return description;
    }

    public double getPoundsPerCubicFoot() {
        return poundsPerCubicFoot;
    }

    public double getRecommendedAmountPerDay() {
        return recommendedAmountPerDay;
    }

    public double getRecommendedAmountPerYear() {
        return recommendedAmountPerYear;
    }

    public String getUnitOfMeasure() {
        return unitOfMeasure;
    }
    
}

