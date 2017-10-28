
package citbyui.cit260.curiousworkmanship.view;

import citbyui.cit260.curiousworkmanship.control.GameControl;
import citbyui.cit260.curiousworkmanship.exceptions.MapControlException;
import curiousworkmanship.CuriousWorkmanship;

/**
 *
 * @author jacksonrkj
 */


public class MainMenuView extends ViewNew {
    
    public MainMenuView() {
    }
    
    
    @Override
    public String[] getInputs() {
        String[] inputs = new String[1];
        
        System.out.println(
                "\n"
              + "\n-----------------------------------------"
              + "\n| Main Menu                             |"
              + "\n-----------------------------------------"
              + "\nN - Start new game"
              + "\nG - Get and start saved game"
              + "\nH - Get help on how to play the game"
              + "\nS - Save game"
              + "\nQ - Quit"
              + "\n-----------------------------------------");
        
        String promptMessage = "\nSelect and enter a menu item: ";
        inputs[0] = this.getInput(promptMessage).toUpperCase();    
        
        return inputs;
        
    }



    @Override
    public boolean doAction(String[] inputs) {
       
        char choice = inputs[0].charAt(0); // get first character entered

        switch (choice) {
            case 'N': // create and start a new game
                this.startNewGame();
                break;
            case 'G': // get and start an existing game
                this.startSavedGame();
                break;
            case 'H': // display the help menu
                this.displayHelpMenu();
                break;
            case 'S': // save the current game
                this.saveGame();               
                break;
            case 'Q':
                return true;
            default:
                ErrorView.display("MainMenuView", 
                                  "*** Invalid selection *** Try again");
                break;
        }

        return false;
    }
     

    private void startNewGame() {
        
        try {   
            
            
            // create a new game
            GameControl.createNewGame(CuriousWorkmanship.getPlayer()); 
            
            
        } catch (MapControlException mce) {
            ErrorView.display("MainMenuView", mce.getMessage());
            return;
        } 

        // display the game menu
        GameMenuView gameMenu = new GameMenuView();
        gameMenu.display();
    }

    private void startSavedGame() {
        
        // prompt for and get the name of the file to save the game in
        String promptMessage = "\n\nEnter the file path for file where the game"
                             + " was previously saved.";

        String filePath = this.getInput(promptMessage);       
        if (filePath == null || filePath.equals("Q")) {
            return;
        }

        
        try {
            // start a saved game
            GameControl.getSavedGame(filePath);
        } catch (Exception ex) {
            ErrorView.display("MainMenuView", ex.getMessage());
        } 

        // display the game menu
        GameMenuView gameMenu = new GameMenuView();
        gameMenu.display();
    }

    private void saveGame() {
        // prompt for and get the name of the file to save the game in
        String promptMessage = "\n\nEnter the file path for file where the game"
                             + "is to be saved.";

        String filePath = this.getInput(promptMessage);       
        if (filePath == null || filePath.equals("Q")) {
            return;
        }    
        
        try {
            // save the game to the speciried file
            GameControl.saveGame(CuriousWorkmanship.getCurrentGame(), filePath);
        } catch (Exception ex) {
            ErrorView.display("MainMenuView", ex.getMessage());
        } 
    }

    private void displayHelpMenu() {
        HelpMenuView helpMenu = new HelpMenuView();
        helpMenu.display();
    }


}
