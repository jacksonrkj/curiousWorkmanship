/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package citbyui.cit260.curiousworkmanship.view;

import citbyui.cit260.curiousworkmanship.control.Constants;
import citbyui.cit260.curiousworkmanship.control.GameControl;
import citbyui.cit260.curiousworkmanship.control.MapControl;
import citbyui.cit260.curiousworkmanship.enums.Actor;
import citbyui.cit260.curiousworkmanship.exceptions.MapControlException;
import citbyui.cit260.curiousworkmanship.exceptions.ViewException;
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
                
                ErrorView.display("MoveActorView", "Invalid selection");
                return false;
        }
        
        
        boolean done = false;
        do {
            try {
                // prompt for and get the row and column numbers
                System.out.println("\nEnter the row and column number of the location (e.g., 1 3)");
                Point coordinates = this.getCoordinates(); // get the row and column
                if (coordinates == null) // entered "Q" to quit
                    break;
                
                // move actor to specified location
                MapControl.moveActorToLocation(actor, coordinates);
                
                System.out.println(actor + 
                                   " was successfully moved to location: " + 
                                   coordinates.x + ", " + coordinates.y);
                done = true;
            } catch (ViewException | MapControlException ex) {
                    ErrorView.display("MoveActorView", ex.getMessage());
            }       
        } while (!done);

        return false;  
    }
    
    public Point getCoordinates() throws ViewException {
        Point coordinates = null;
        
        String value = this.getInput();
        value = value.trim().toUpperCase();
        if (value.equals("Q"))
            return null;

        //tokenize values int string
        String[] values = value.split(" ");

        if (values.length < 2) {
            ErrorView.display("MoveActorView", "You must enter both a row and column number.");
        }

        // parse out row and column numbers
        try {
            int row = Integer.parseInt(values[0]);
            int column = Integer.parseInt(values[1]);
            coordinates =  new Point(row, column);

        } catch (NumberFormatException nf) {
            ErrorView.display("MoveActorView", "The row or column number is not a  number.");
        }     
        
        return coordinates;
    }
    
}
