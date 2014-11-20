/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package citbyui.cit260.curiousworkmanship.view;

import citbyui.cit260.curiousworkmanship.control.MapControl;
import citbyui.cit260.curiousworkmanship.enums.Actor;
import citbyui.cit260.curiousworkmanship.model.Location;
import java.awt.Point;
import java.util.ArrayList;

/**
 *
 * @author jacksonrkj
 */
public class ViewLocationView extends View {
   
    public ViewLocationView() {
        super("\n"
            + "Enter the row and column number of the location you want to view (e.g., 1 3).");
    }


    @Override
    public boolean doAction(String choice) {

            Point coordinates = this.getCoordinates(choice); // get the row and column
            if (coordinates == null)
                return false;
            
            // get the location in the map
            Location location = MapControl.getLocation(coordinates);
            
            // display contents of location
            this.displayLocationInfo(coordinates, location);     

        return true;  
        
    }
    
    public Point getCoordinates(String value) {
       
        value = value.trim().toUpperCase();
        if (value.equals("Q"))
            return null;

        //tokenize values int string
        String[] values = value.split(" ");

        if (values.length < 2) {
            System.out.println("You must enter both a row and column number.");
        }

        // parse out row and column numbers
        int row = Integer.parseInt(values[0]);
        int column = Integer.parseInt(values[1]);
        return new Point(row, column);
       
    }

    private void displayLocationInfo(Point coordinates, Location location) {
        System.out.println("\n"
                + "Location (" + coordinates.x + ", " + coordinates.y + ")"
                + location.getScene().getDescription());
        System.out.println("\n\tActors in location");
        ArrayList<Actor> actorsInLocation = location.getActors();
        for (Actor actor : actorsInLocation) {
            System.out.println("\t" + actor);        
        }
        
    }
    
}
