/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package citbyui.cit260.curiousworkmanship.view;

import citbyui.cit260.curiousworkmanship.control.GameControl;
import citbyui.cit260.curiousworkmanship.enums.FoodItem;
import citbyui.cit260.curiousworkmanship.enums.Item;
import citbyui.cit260.curiousworkmanship.exceptions.GameControlException;
import citbyui.cit260.curiousworkmanship.model.Game;
import citbyui.cit260.curiousworkmanship.model.InventoryItem;
import curiousworkmanship.CuriousWorkmanship;

/**
 *
 * @author jacksonrkj
 */
public class EstimateResourcesView extends View {
    
    private FoodItem selectedFoodItem = null;
    private double lengthOfTrip = 0.0;
    private int noOfPeople = 0;
    private double amountEstimated;
    private boolean quit = false;
    private int inventoryIndex;

    public EstimateResourcesView() {
        super(false, 
              "Estimate the required amount food that you will need "
              + "for the voyage to the promised land.");
    }

    
    @Override
    public boolean doAction(Object obj) {
        Game game = CuriousWorkmanship.getCurrentGame();
        
        boolean done = false;
        // estimate speed and get length of the voyage.
        new GetShipSpeedView("").display();
        if (quit) {
            return true;
        }

        // get number of people of trip
        new GetNoOfPeopleView("").display();
        if (quit) {
            return true;
        }
        
        // while not quit
        boolean success = false;
        while (!quit) {
            
            // select a resource
            new GetResourceView("").display();
            if (quit) {
                return true;
            }
            
            // get the amount required per day        
            new GetAmountView("").display();
            if (quit) {
                return true;
            }
            else {
                // Set the required amount in inventory for the resource
                CuriousWorkmanship.getCurrentGame().
                        getInventory()[selectedFoodItem.ordinal()].
                        setRequiredAmount(amountEstimated);
            }
  
         }
        return done;
    }
    
    
    private class GetResourceView extends View {
        
        public GetResourceView(String message) {
            super( 
                   "\n---------------------------------------------------------------"
                 + "\n| You will need each of the following food items for the trip.|"
                 + "\n|                                                             |"   
                 + "\n| Select and estimate the amount of each food item that is    |"
                 + "\n| needed to complete the voyage. Your estimate should be based|"
                 + "\n| the length of the trip, the number of people traveling on   |"
                 + "\n| the ship and the minimum amount required per day per person.|"
                 + "\n---------------------------------------------------------------"
                 + "\nG - Grain"
                 + "\nL - Legumes"
                 + "\nO - Oil"
                 + "\nW - Water"
                 + "\nH - Honey"
                 + "\nS - Salt"
                 + "\nQ - Quit to main main menu"
                 + "\n---------------------------------------------------------------");
        }

        @Override
        public boolean doAction(Object obj) {
            String value = (String) obj;
            char choice = value.trim().toUpperCase().charAt(0);
   
            selectedFoodItem = null;
            
            switch (choice) {
                case 'G':
                    selectedFoodItem = FoodItem.grain;
                    inventoryIndex = Item.grain.ordinal();
                    break;
                case 'L':
                    selectedFoodItem = FoodItem.legumes;
                    inventoryIndex = Item.legume.ordinal();
                    break;
                case 'O':
                    selectedFoodItem = FoodItem.oil;
                    inventoryIndex = Item.oil.ordinal();
                    break;
                case 'W':
                    selectedFoodItem = FoodItem.water;
                    inventoryIndex = Item.water.ordinal();
                    break;
                case 'H':
                    selectedFoodItem = FoodItem.honey;
                    inventoryIndex = Item.honey.ordinal();
                    break;
                case 'S':
                    selectedFoodItem = FoodItem.salt;
                    inventoryIndex = Item.salt.ordinal();
                    break;
                case 'Q':
                    quit = true;
                    return true;  
                default:
                    ErrorView.display("EstimateResourcesView", "Invalid resource entered");
                    return false;
            }  
            
            return true;
        }
    }
    
    private class GetShipSpeedView extends View {
        
        public GetShipSpeedView(String message) {
            super("\nEnter the estimated average speed of the ship "
                  + "that you will be sailing");
        }

        @Override
        public boolean doAction(Object obj) {
            String value = (String) obj;
            
            if ( value.trim().toUpperCase().charAt(0) == 'Q') {
                quit = true;
                return true;
            }

            double speed = Double.parseDouble(value);
            double numberOfDays = Math.round(GameControl.getLengthOfTrip(speed));
            
            GameControl.Probability probability;
            try {
                speed = Double.parseDouble(value);
                probability = GameControl.checkSpeedOfShip(speed);
            }
            catch (NumberFormatException ne) {
                ErrorView.display("EstimateResourcesView", 
                                  "You must enter a valid number for the speed.");
                return false;
            } catch (GameControlException ex) {
                ErrorView.display(EstimateResourcesView.class.getName(), ex.getMessage());
                return false;
            }

            switch (probability) {
                case HIGH_PROBABILITY: 
                    this.console.println("\n" + this.getBlockedMessage( 
                          "You have greater than a 68% probability that trip will be "
                        + "completed in " + numberOfDays +  " days at an average "
                        + "speed of " + speed + " mph. You can be "
                        + "confident in the amount of resources that you "
                        + "estimate for the voyage."));
                    lengthOfTrip = numberOfDays;
                    return true;

                case LOW_PROBABILITY:
                    this.console.println("\n" + this.getBlockedMessage(
                         "You have less than a 16% probability that trip will be "
                        + "completed in " + numberOfDays +  " days at an average "
                        + "speed of " + speed + " mph. Your estimate of the "
                        + "amount of resources need for the trip may be way off."));

                   this.console.println("\nDo you want to re-estimate your speed? (Y/N)");
                   String answer = this.getInput().trim().toUpperCase();
                   if (answer.charAt(0) != 'Y') {
                      return false;
                   }
                   lengthOfTrip = numberOfDays;
                   return true;
                 
                case TOO_LOW:
                    this.console.println( this.getBlockedMessage(
                            "\nYour estimated average speed is too "
                            + "low. Most sailing vessels can go "
                            + "faster than that."));
                    return false;
                    
                case TOO_HIGH:
                    this.console.println(this.getBlockedMessage( 
                                "\nYour estimated average speed is too "
                                + "high. Even the best sailing vessels "
                                + "can not maintain that average speed"));
                    return false;
                    
                case OK:
                    lengthOfTrip = numberOfDays;
                    return true;
                    
                default: ErrorView.display(this.getClass().getName(), 
                                           "Invalid speed entered.");
                    return false;
            }   
        
        }
        
    }
    
    private class GetNoOfPeopleView extends View {
        
        public GetNoOfPeopleView(String message) {
            super("\nEnter the number of people that sailing on "
                  + "the ship.");
        }

        @Override
        public boolean doAction(Object obj) {
            int peopleEntered = 0;
            
            String value = (String) obj;
            
            if ( value.trim().toUpperCase().charAt(0) == 'Q') {
                quit = true;
                return true;
            }

            try {
                peopleEntered = Integer.parseInt(value);

                if (peopleEntered < 0) {
                    ErrorView.display( "EstimateResourcesView"
                                     , "The number of people must be greater than zero.");
                    return false;
                }
               
                GameControl.Probability probabilty = 
                        GameControl.checkNoOfPeople(peopleEntered);
                
                switch (probabilty) {
                    case TOO_LOW:
                        ErrorView.display( "EstimateResourcesView"
                                     , "The number of people specified is too low.");
                        return false;
                    case TOO_HIGH:
                        ErrorView.display( "EstimateResourcesView"
                                     , "The number of people specified is too high.");
                        return false;
                    case OK:
                        noOfPeople = peopleEntered;
                        return true;
                    default:
                        ErrorView.display("EstimateResourcesView", 
                                  "Invalid probability value.");
                        return false;
                }
            }
            catch (NumberFormatException ne) {
                ErrorView.display("EstimateResourcesView", 
                                  "You must enter a valid number for the number of people.");
                return false;
            } catch (GameControlException ex) {
                ErrorView.display("EstimateResourcesView", ex.getMessage());
                return false;
            }
        }
        
    }

    
    private class GetAmountView extends View {
        
        public GetAmountView(String message) {
            super("\nEstimate and enter the amount of " 
                    + selectedFoodItem.name() 
                    + " needed for the voyage below (in " 
                    + selectedFoodItem.getUnitOfMeasure()
                    + "s)");
        }

        @Override
        public boolean doAction(Object obj) {
            String value = (String) obj;
           
            if ( value.trim().toUpperCase().charAt(0) == 'Q') {
                quit = true;
                return true;
            }
               
            double estimatedAmount = 0;
            
            try {
                estimatedAmount = Double.parseDouble(value);
                
                if (estimatedAmount < 0) {
                    ErrorView.display( "EstimateResourcesView"
                                     , "The amount you estimated must be greater than zero.");
                    return false;
                }
                
                GameControl.Probability probabilty = GameControl.checkRequiredAmount( 
                                                        selectedFoodItem, 
                                                        lengthOfTrip, 
                                                        noOfPeople, 
                                                        estimatedAmount);
                switch (probabilty) {
                    case TOO_LOW:
                        ErrorView.display( "EstimateResourcesView"
                                     , "The amount you estimated is too low.");
                        return false;
                    case TOO_HIGH:
                        ErrorView.display( "EstimateResourcesView"
                                     , "The amount you estimated is too high.");
                        return false;
                    case OK:
                        
                        String unitOfMeasure = selectedFoodItem.getUnitOfMeasure();
                        
                        unitOfMeasure = (estimatedAmount > 1) ? unitOfMeasure + "s": unitOfMeasure;
                        
                        // set required resources for inventor item
                        InventoryItem[] inventory = CuriousWorkmanship.getCurrentGame().getInventory();
                        inventory[inventoryIndex].setRequiredAmount(estimatedAmount);
                        
                        this.console.println("\n" + this.getBlockedMessage(
                              "The amount you estimated should "
                            + "allow " + noOfPeople  + " people to survive the voyage. "
                            + "You now need to go search for and harvest " 
                            + estimatedAmount + " " + unitOfMeasure 
                            + " of " + selectedFoodItem.name() + "."));
                        return true;
                    default:
                        ErrorView.display("EstimateResourcesView", 
                                  "Invalid probability value.");
                        return false;
                }
            }
            catch (NumberFormatException ne) {
                ErrorView.display("EstimateResourcesView", 
                                  "You must enter a valid number for the number of people.");
                return false;
            } catch (GameControlException ex) {
                ErrorView.display("EstimateResourcesView", ex.getMessage());
                return false;
            }
        }
        
    }
    
}
