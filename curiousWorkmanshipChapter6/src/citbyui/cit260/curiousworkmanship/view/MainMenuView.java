/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package citbyui.cit260.curiousworkmanship.view;

import citbyui.cit260.curiousworkmanship.control.GameControl;
import citbyui.cit260.curiousworkmanship.control.ProgramControl;
import curiousworkmanship.CuriousWorkmanship;

/**
 *
 * @author jacksonrkj
 */
// public class MainMenuView extends View 

public class MainMenuView extends View {

    private String menu;

    public MainMenuView() {
        super(  "\n"
                + "\n-----------------------------------------"
                + "\n| Main Menu                             |"
                + "\n-----------------------------------------"
                + "\nN - Start new game"
                + "\nG - Get and start saved game"
                + "\nH - Get help on how to play the game"
                + "\nS - Save game"
                + "\nQ - Quit"
                + "\n-----------------------------------------"
             );
    }

    @Override
    public boolean doAction(String choice) {

        choice = choice.toUpperCase(); // convert choice to upper case

        switch (choice) {
            case "N": // create and start a new game
                this.startNewGame();
                break;
            case "G": // get and start an existing game
                this.startExistingGame();
                break;
            case "H": // display the help menu
                this.displayHelpMenu();
                break;
            case "S": // save the current game
                this.saveGame();
                break;
            default:
                System.out.println("\n*** Invalid selection *** Try again");
                break;
        }

        return false;
    }

    private void startNewGame() {

        // create a new game
        GameControl.createNewGame(CuriousWorkmanship.getPlayer());

        // display the game menu
        GameMenuView gameMenu = new GameMenuView();
        gameMenu.display();
    }

    private void startExistingGame() {
        // start a saved game
        GameControl.startSavedGame();

        // display the game menu
        GameMenuView gameMenu = new GameMenuView();
        gameMenu.display();
    }

    private void saveGame() {
        new SaveGameView().display();

    }

    private void displayHelpMenu() {
        HelpMenuView helpMenu = new HelpMenuView();
        helpMenu.display();
    }

    private class SaveGameView extends View {

        public SaveGameView() {
            super("\n\nEnter the file path for file where the game "
                    + "is to be saved.");
        }

        @Override
        public boolean doAction(String filePath) {
            // save the game to the speciried file
            ProgramControl.saveGame(CuriousWorkmanship.getCurrentGame(), filePath);

            System.out.println("The game has been successfully saved to: " + filePath);
            return true;
        }

    }

}
