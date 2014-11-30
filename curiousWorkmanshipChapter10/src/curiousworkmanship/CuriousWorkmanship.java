/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package curiousworkmanship;

import citbyui.cit260.curiousworkmanship.model.Game;
import citbyui.cit260.curiousworkmanship.model.Player;
import citbyui.cit260.curiousworkmanship.view.ErrorView;
import citbyui.cit260.curiousworkmanship.view.StartProgramView;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;


public class CuriousWorkmanship {
    
    private static Game currentGame = null;
    private static Player player = null;  
    private static PrintWriter logFile = null;
    private static PrintWriter outFile = null;
    private static BufferedReader inFile = null;

    public static void main(String[] args) { 

        try {
            
            // open charcter stream files for end user input and output
            CuriousWorkmanship.inFile = 
                    new BufferedReader(new InputStreamReader(System.in));
            
            CuriousWorkmanship.outFile = new PrintWriter(System.out, true);
        
            // open log file
            String filePath = "log.txt";
            CuriousWorkmanship.logFile = new PrintWriter(filePath);


            // create StartProgramView and start the program
            StartProgramView startProgramView = new StartProgramView();
            startProgramView.display();
            return; 

        } catch (Exception e) {

            // build stacktrace string.
            StringBuilder sb = new StringBuilder();
            for (StackTraceElement element : e.getStackTrace()) {
                sb.append("\t" + element.toString());
                sb.append("\n");
            }

            ErrorView.display("CuriousWorkmanship",  
                "An abnormal error occured. "
                + "Exception: " + e.toString()  
                + "\nCause: " + e.getCause()
                + "\nMessage: " + e.getMessage()
                + "\nRestarting the program."              
                + "\nIf this error persist, contact support."
                + "\n\n" + e.getStackTrace()[0].toString()
                ); 

            // create StartProgramView and start the program
            StartProgramView startProgramView = new StartProgramView();
            startProgramView.display();

        }

        finally {
            
            try {
                CuriousWorkmanship.inFile.close();
                CuriousWorkmanship.outFile.close();
                CuriousWorkmanship.logFile.close();
                
            } catch (IOException ex) {
                ErrorView.display("CuriousWorkmanship", "Error closing files");
            }

        }
        
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

    public static PrintWriter getLogFile() {
        return logFile;
    }

    public static void setLogFile(PrintWriter logFile) {
        CuriousWorkmanship.logFile = logFile;
    }

    public static PrintWriter getOutFile() {
        return outFile;
    }

    public static void setOutFile(PrintWriter outFile) {
        CuriousWorkmanship.outFile = outFile;
    }

    public static BufferedReader getInFile() {
        return inFile;
    }

    public static void setInFile(BufferedReader inFile) {
        CuriousWorkmanship.inFile = inFile;
    }

    
    
}
