/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package citbyui.cit260.curiousworkmanship.view;

import citbyui.cit260.curiousworkmanship.control.GameControl;
import citbyui.cit260.curiousworkmanship.control.MapControl;
import citbyui.cit260.curiousworkmanship.enums.Actor;
import citbyui.cit260.curiousworkmanship.enums.Item;
import citbyui.cit260.curiousworkmanship.exceptions.GameControlException;
import citbyui.cit260.curiousworkmanship.exceptions.ViewException;
import citbyui.cit260.curiousworkmanship.model.Location;
import citbyui.cit260.curiousworkmanship.model.ResourceScene;
import java.awt.Point;
import java.util.ArrayList;

/**
 *
 * @author jacksonrkj
 */
public class HarvestResourcesView extends View {

    private double noOfHours = 0.0;
    private int noOfPeople = 0;
    private ResourceScene scene = null;
    ArrayList<Actor> actorsInLocation = null;

    public HarvestResourcesView() {
        super("\n"
                + "Enter the row and column number of the location you want to "
                + "harvest resources in (e.g., 1 3).");
    }

    @Override
    public boolean doAction(String value) {


        try {
            Point coordinates = this.getCoordinates(value); // get the row and column
            if (coordinates == null) {
                return true;
            }

            // get the location in the map
            Location location = MapControl.getLocation(coordinates);
            if (!(location.getScene() instanceof ResourceScene)) {
                ErrorView.display("HarvestResourceView", "This location does not contain any resources that can be harvested");
                return false;
            }

            this.scene = (ResourceScene) location.getScene();
            this.actorsInLocation = location.getActors();
            this.noOfPeople = actorsInLocation.size();
            Item item = scene.getResourceType();

            this.console.println("\n" + scene.getDescription());
            this.console.printf("This locations contains "
                    + item.name()
                    + " that you can harvest");

            // display contents of location
            if (actorsInLocation.size() < 1) {
                ErrorView.display("HarvestResourcesView", "There are no actors in this location to harvest this resource. "
                        + "Move to a different location that contains items to harvest");
                return false;
            }
            this.console.println("\nThe following actors are currently in this location");
            for (Actor actor : actorsInLocation) {
                this.console.println("   " + actor);

            }

            // display view to get number of hours to harvest resources
            new GetAmountToHarvestView().display();
            

            // harvest the resources
            double amountHarvested
                    = GameControl.harvestResource(location,
                            item,
                            noOfPeople,
                            noOfHours);
            
            this.console.println( "You have successfully harvested "
                                + amountHarvested + " " 
                                + item.getUnitsOfMeasure()
                                + " of " + item.name());
            
        } catch (Exception e) {
            ErrorView.display("HarvestResourcesView", e.getMessage());
            return false;
        }

        return true;
    }

    public Point getCoordinates(String value) throws ViewException {
        Point coordinates = null;

        value = value.trim().toUpperCase();
        if (value.equals("Q")) {
            return null;
        }

        //tokenize values int string
        String[] values = value.split(" ");

        if (values.length < 2) {
            ErrorView.display("ViewLocationView", "You must enter both a row and column number.");
        }

        // parse out row and column numbers
        try {
            int row = Integer.parseInt(values[0]);
            int column = Integer.parseInt(values[1]);
            coordinates = new Point(row, column);

        } catch (NumberFormatException nf) {
            ErrorView.display("ViewLocationView", "The row or column entered is not a number.");
        }

        return coordinates;
    }

    private class GetAmountToHarvestView extends View {

        public GetAmountToHarvestView() {
            super("\n"
                    + "Enter the number of hours you will spend harvesting this resource: ");
        }

        @Override
        public boolean doAction(String value) {
            
            noOfHours = 0;

            try {
                noOfHours = Double.parseDouble(value);

            } catch (NumberFormatException ne) {
                ErrorView.display("EstimateResourcesView",
                        "You must enter a valid number for the speed.");
                return false;
            }
            
            return true;
        }

    }

}
