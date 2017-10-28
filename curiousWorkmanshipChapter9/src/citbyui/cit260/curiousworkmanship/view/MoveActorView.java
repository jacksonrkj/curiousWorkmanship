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
    }

    @Override
    public String[] getInputs() {
        String[] inputs = new String[2];

        System.out.println(
                "\n"
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
                + "\n---------------------------------------------"
        );

        boolean valid = false;
        do {
            inputs[0] = this.getInput("\nEnter a menu item").toUpperCase();
            if (inputs[0].equals("Q")) {
                return null;
            }

            String[] menu = {"L", "S", "A", "E", "N", "J", "M", "Z"};
            valid = this.validMenuItem(menu, inputs[0]);
            if (!valid) {
                System.out.println("\n*** Invalid menu item.");
            }

        } while (!valid);

        inputs[1] = this.getInput("\nEnter the row and column number of the location (e.g., 1 3)");
        if (inputs[1].toUpperCase().equals("Q")) {
            return null;
        }

        return inputs;
    }

    private boolean validMenuItem(String[] menuItems, String menuItem) {

        for (int i = 0; i < menuItems.length; i++) {
            if (menuItem.toUpperCase().equals(menuItems[i])) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean doAction(String[] inputs) {

        Actor actor;

        String choice = inputs[0].trim().toUpperCase(); // trim blanks and uppercase

        // check for valid actor
        switch (choice) {
            case "L":
                actor = Actor.Lehi;
                break;
            case "S":
                actor = Actor.Sariah;
                ;
                break;
            case "A":
                actor = Actor.Laman;
                break;
            case "E":
                actor = Actor.Lemuel;
                ;
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

        Point coordinates = this.getCoordinates(inputs[1]); // get the row and column
        if (coordinates == null) // entered "Q" to quit
        {
            System.out.println("\nERROR" + actor
                    + " could not be moved to location: "
                    + coordinates.x + ", " + coordinates.y);
            return false;
        }

        // move actor to specified location
        int returnValue = MapControl.moveActorToLocation(actor, coordinates);
        if (returnValue < 0) {
            System.out.println("\nERROR" + actor
                    + " could not be moved to location: "
                    + coordinates.x + ", " + coordinates.y);
            return false;
        }

        System.out.println("\n" + actor
                + " was successfully moved to location: "
                + coordinates.x + ", " + coordinates.y);

        return true;
    }

    public Point getCoordinates(String value) {

        value = value.trim().toUpperCase();
        if (value.equals("Q")) {
            return null;
        }

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
