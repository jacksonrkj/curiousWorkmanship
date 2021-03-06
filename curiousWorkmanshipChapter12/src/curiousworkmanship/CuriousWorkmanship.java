/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package curiousworkmanship;

import citbyui.cit260.curiousworkmanship.frames.MainMenuFrame;
import citbyui.cit260.curiousworkmanship.frames.StartProgramFrame;
import citbyui.cit260.curiousworkmanship.model.Game;
import citbyui.cit260.curiousworkmanship.model.Player;


public class CuriousWorkmanship {
    
    private static Game currentGame = null;
    private static Player player = null;   
    private static MainMenuFrame mainMenuFrame = null;

    public static MainMenuFrame getMainMenuFrame() {
        return mainMenuFrame;
    }

    public static void setMainMenuFrame(MainMenuFrame mainMenuFrame) {
        CuriousWorkmanship.mainMenuFrame = mainMenuFrame;
    }


    public static void main(String[] args) { 
    
//        while (true) { // play game until user explcitly quits
            try {
                // create StartProgramView and start the program
//                StartProgramView startProgramView = new StartProgramView();
//                startProgramView.display();
                /* Create and display the form */
                java.awt.EventQueue.invokeLater(new Runnable() {
                    public void run() {
                        StartProgramFrame startProgramFrame = new StartProgramFrame();
                        startProgramFrame.setVisible(true); 
                        return;
                    }
                });

                return;
                          
                    
            } catch (Exception e) {
                
                // build stacktrace string.
                StringBuilder sb = new StringBuilder();
                for (StackTraceElement element : e.getStackTrace()) {
                    sb.append("\t" + element.toString());
                    sb.append("\n");
                }

                System.out.println("\n"
                        + "\n*%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%"
                        + "\nAn abnormal error occured. ");

                System.out.println("Exception: " + e.toString() + 
                                   "\nCause: " + e.getCause() + 
                                   "\nMessage: " + e.getMessage());

                System.out.println("\n" + e.toString() + "\n" + sb);

                System.out.println("\nRestarting the program."              
                        + "\nIf this error persist, contact support."
                        + "\n%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%"
                        + "\n\n\n");
                return;
            }

//        }
        
        
    }

    
    
    
    
    
    public static Game getCurrentGame() {
        return currentGame;
    }

    public static void setCurrentGame(Game currentGame) {
        CuriousWorkmanship.currentGame = currentGame;
    }

    public static Player getPlayer() {
        return player;
    }

    public static void setPlayer(Player player) {
        CuriousWorkmanship.player = player;
    }

    
    
    
}
