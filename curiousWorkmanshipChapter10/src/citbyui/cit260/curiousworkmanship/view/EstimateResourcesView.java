/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package citbyui.cit260.curiousworkmanship.view;

import citbyui.cit260.curiousworkmanship.control.GameControl;
import citbyui.cit260.curiousworkmanship.enums.FoodItem;
import citbyui.cit260.curiousworkmanship.exceptions.GameControlException;
import citbyui.cit260.curiousworkmanship.exceptions.ViewException;
import citbyui.cit260.curiousworkmanship.model.Game;
import curiousworkmanship.CuriousWorkmanship;

/**
 *
 * @author jacksonrkj
 */
public class EstimateResourcesView extends View {

    public EstimateResourcesView() {
        super(false, 
              "Estimate the required resources that you will need of each item "
              + "for the voyage to the promised land.");
    }

    
    @Override
    public boolean doAction(Object obj) {
        Game game = CuriousWorkmanship.getCurrentGame();
        boolean success = false;
        
        // estimate speed and get length of the voyage.
        double lengthOfTrip = getShipsSpeed();
        if (lengthOfTrip < 1) {
            return false;
        }
 
        // get number of people of trip
        int noOfPeople = this.getNumberOfPeople();
            if (lengthOfTrip < 1) {
            return false;
        } 
        
        // while not quit
        while (!success) {
            // select a resource
//            this.getResource();
            // get the amount required per day
            // check to see a valid amount was entered
            // Set the required amount in inventory for the resource
            
         }
        return success;
    }
    
    private double getShipsSpeed() {
        double speed = -1;
        
        boolean done = false;
        while (!done) {
            this.console.println("Enter the estimated average speed of the ship"
                                + " that you will be sailing");
            
            String value = this.getInput().trim();
            if (value.equals("Q"))
                break;
            
            try {
                speed = Double.parseDouble(value);
                
            } catch (NumberFormatException e) {
                ErrorView.display(this.getClass().getName(), 
                                  "The speed  must be a valid number");
                continue;
            }

            try {   
                done = this.validSpeed(speed);
                if (done) {
                    double numberOfDays = GameControl.getLengthOfTrip(speed);
                    this.console.println( "The trip will take you approximately" 
                               + numberOfDays + "  days to complete the trip at"
                               + "that average speed.");
                }
            } catch (Exception e) {
                ErrorView.display(this.getClass().getName(), e.getMessage());
            }

        }
        
        return speed;    
    }
    
    
    private boolean validSpeed(double speed) throws GameControlException {
        boolean valid = false;
        
        double numberOfDays = GameControl.getLengthOfTrip(speed);
        GameControl.Estimate_status status = GameControl.checkSpeedOfShip(speed);

        this.console.println( "The trip will take you approximately" 
                       + numberOfDays + "  days to complete the trip at"
                       + "that average speed.");
        switch (status) {
            case HIGH_PROBABILITY: 
                    valid = true;
                    this.console.println( 
                        "\nYou have a greater than 68% probability that trip will be "
                      + "\ncompleted in the number of days indicated above. You "
                      + "\ncan be confident in the amount of resources that you "
                      + "\nestimate are needed for the voyage.");
                    break;

            case LOW_PROBABILITY:
                this.console.println( 
                     "\nYou have less than a 16% probability that the trip will "
                   + "\ntake that many days to complete the trip at the speed "
                   + "\nspecified. The amount of resources you take on the ship "
                   + "\nmay be way off resulting in a good possibility of either "
                   + "\nstarvation or the wasting a lot of valuable time in "
                   + "\ncollecting resources that are needed for the voyage.");

               this.console.println("\nDo you want to re-estimate your speed? (Y/N)");
               String answer = this.getInput().trim().toUpperCase();
               if (answer.charAt(0) != 'Y') {
                  valid = true;
               }
               break;
            case TOO_LOW:
                this.console.println( "Your estimated average speed is too "
                            + "low. \nMost sailing vessels of the time can make a "
                            + "better time than that.");
                break;
            case TOO_HIGH:
                this.console.println( "Your estimated average speed is too "
                            + "high. \nEven the best sailing vessels of the time "
                            + "can not maintain that average speed");
                break;
            default: ErrorView.display(this.getClass().getName(), 
                                       "Invalid speed entered.");
        }   
        
        return valid;
        
    }
    
    private int getNumberOfPeople() {
        
        int noOfPeople = -1;
        
        boolean done = false;
        while (!done) {
            this.console.println("Enter the number of people that sailing on "
                                + " ship.");
            
            String value = this.getInput().trim();
            if (value.equals("Q"))
                return -1;
            
            try {
                noOfPeople = Integer.parseInt(value);
                
            } catch (NumberFormatException e) {
                ErrorView.display(this.getClass().getName(), 
                                  "You must enter a valid number for "
                                + "the number of people");
                continue;
            }

            if (GameControl.checkNoOfPeople(noOfPeople)) {
                return noOfPeople;
            }

        }
        
        return noOfPeople;    
    }

    private FoodItem getResource() throws ViewException {
        this.console.println("\n"
            + "\n---------------------------------------------------------------"
            + "\n| Select a resource to estimate the amount required.           |"
            + "\n---------------------------------------------------------------"
            + "\nG - Grain"
            + "\nL - Legumes"
            + "\nO - Oil"
            + "\nW - Water"
            + "\nH - Honey"
            + "\nS - Salt"
            + "\nQ - Quit to main main menu"
            + "\n---------------------------------------------------------------");
        
        char selection = this.getInput().trim().toUpperCase().charAt(0);
        if (selection == 'Q') 
            return null;
        
        switch (selection) {
            case 'G':
                return FoodItem.Grain;
            case 'L':
                return FoodItem.Legumes;
            case 'O':
                return FoodItem.Oil;
            case 'W':
                return FoodItem.Water;
            case 'H':
                return FoodItem.Honey;
            case 'S':
                return FoodItem.Salt;  
            default:
                throw new ViewException("Invalid resource entered");
        }  
    }

    
    private double getAmount(FoodItem item, int noOfPeople, int noOfDays) {
        double amount = -1;
        
        boolean done = false;
        while (!done) {
            this.console.println("Enter the number of pounds of "
                                + item + " required for "
                                + noOfPeople + " for a voyage of "
                                + noOfDays + " days.");
            
            String value = this.getInput().trim();
            if (value.charAt(0) == 'Q')
                return -1;
            
            try {
                amount = Double.parseDouble(value);
                
            } catch (NumberFormatException e) {
                ErrorView.display(this.getClass().getName(), 
                                  "You must enter a valid number for "
                                + "the amount");
                continue;
            }
            
            
            if (GameControl.checkNoOfPeople(noOfPeople)) {
                return amount;
            }

        }
        
        return amount;    

        
    }
    
    
}
