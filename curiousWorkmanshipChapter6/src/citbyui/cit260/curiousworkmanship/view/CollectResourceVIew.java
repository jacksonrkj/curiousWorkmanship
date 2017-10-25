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
public class CollectResourceVIew extends View {

    public CollectResourceVIew() {
        super("\nEnter the type of resource to be gathered): "
            + "\nG - Grain"
            + "\nH - Honey"
            + "\nS - Salt"
            + "\nW - Water"
            + "\nL - Legume");
                
    }

    
    
    @Override
    public boolean doAction(String value) {
        String resourceType = value.toLowerCase();
        
        this.displayMessage = "\nEnter the amount of resources you want to collect:";
        String strAmount = this.getInput();
        double amount = Double.parseDouble(strAmount);
        
        double amountCollected = GameControl.gatherResource(resourceType, amount);
        
        if (amountCollected < 0 ) {
            System.out.println("\nInvalid resource type or amount entered");
            return false;
        }
        
        if (amountCollected < amount ) {
            System.out.println("\nThe amount you request is not available. You collected " + 
                    amountCollected);
            return true;
        }
        
        System.out.println("\nSuccess! You now have added  " + amountCollected + " to your inventory");
        return false;
        
        
        
    }
    
    
    
}
