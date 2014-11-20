/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package citbyui.cit260.curiousworkmanship.view;

import citbyui.cit260.curiousworkmanship.control.MapControl;
import citbyui.cit260.curiousworkmanship.enums.Actor;
import java.awt.Point;

/**
 *
 * @author jacksonrkj
 */
public class MoveActorView extends View {
   
    public MoveActorView() {
        super("\n"
            + "\n---------------------------------------------"
            + "\n| Select actor to move                       |"
            + "\n---------------------------------------------"
            + "\nL - Lehi"
            + "\nS - Sarah"
            + "\nA - Laman"
            + "\nE - Lemuel"
            + "\nN - Nephi"
            + "\nJ - Jacob"
            + "\nM - Sam"
            + "\nZ - Zoram"
            + "\nQ - Quit"
            + "\n---------------------------------------------");
    }


    @Override
    public boolean doAction(String choice) {
        Actor actor; 
        
        choice = choice.trim().toUpperCase(); // trim blanks and uppercase
        
        // check for valid actor
        switch (choice) {
            case "L":
                actor = Actor.Lehi;
                break;
            case "S":
                actor = Actor.Sariah;;
                break;   
            case "A":
                actor = Actor.Laman;
                break;  
            case "E":
                actor = Actor.Lemuel;;
                break; 
            case "N":
                actor = Actor.Nephi;
                break; 
            case "J":
                actor = Actor.Jacob;
                break; 
            case "M":
                actor = Actor.Sam;
                break;
            case "Z":
                actor = Actor.Zoram;
                break;
            case "Q":
                return true;
            default:
                System.out.println("Invalid selection");
                return false;
        }
        
        
        boolean done = false;
        do {

            // prompt for and get the row and column numbers
            System.out.println("\nEnter the row and column number of the location (e.g., 1 3)");
            Point coordinates = this.getCoordinates(); // get the row and column
            if (coordinates == null) // entered "Q" to quit
                break;

            // move actor to specified location
            int returnValue = MapControl.moveActorToLocation(actor, coordinates);
            if (returnValue < 0) {
                System.out.println("\nERROR" + actor + 
                               " counld not be moved to location: " + 
                               coordinates.x + ", " + coordinates.y);
            }

            System.out.println("\n" + actor + 
                               " was successfully moved to location: " + 
                               coordinates.x + ", " + coordinates.y);
            done = true;

        } while (!done);

        return false;  
    }
    
    public Point getCoordinates() {
        
        String value = this.getInput();
        value = value.trim().toUpperCase();
        if (value.equals("Q"))
            return null;

        //tokenize values int string
        String[] values = value.split(" ");

        if (values.length < 2) {
            System.out.println("You must enter both a row and column number.");
            return null;
        }

        // parse out row and column numbers
        int row = Integer.parseInt(values[0]);
        int column = Integer.parseInt(values[1]);
        return new Point(row, column);
      
    }
    
}
