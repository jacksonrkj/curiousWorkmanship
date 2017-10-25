/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package citbyui.cit260.curiousworkmanship.view;

import citbyui.cit260.curiousworkmanship.control.GameControl;

/**
 *
 * @author jacksonrkj
 */
public class GatherResourcesView extends View {

    public GatherResourcesView() {
        super("\nEnter the type of resource to be gathered);"
            + "\nG - Grain"
            + "\nH - Honey"
            + "\nS - Salt"
            + "\nW - Water"
            + "\nL - Legume");
    }
    
    

    @Override
    public boolean doAction(String value) {
        
       String resourceType = value.toLowerCase();
       
       this.displayMessage = "Enter the amount of resource to be collected";
       String strAmount = this.getInput();
       double amount = Double.parseDouble(strAmount);
       
       if (amount <= 0) {
           System.out.println("Invalid amount, the amount must be greater than 0");
           return true;
       }
       
       double amountCollected = GameControl.gatherResource(resourceType, amount);
       
       if (amountCollected < 0) {
           System.out.println("Invalid resouce or amount entered. Try again.");
           return false;
       }
       
       if (amount > amountCollected) {
           System.out.println("The amount you requested exceeds the amount available. "
                   + "\nYou added " + amountCollected + " of " + resourceType 
                   + " to your inventory");
           return true;
       }
      
        System.out.println("\nSuccess! You added " + amountCollected + " of " + resourceType 
                + " to your inventory.");

        return false;
    
        
       
    }
    
}
