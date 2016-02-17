/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package citbyui.cit260.curiousworkmanship.view;

/**
 *
 * @author jacksonrkj
 */
interface MenuInterface {
    
    public void displayMenu();
    public String getInput();
    public void doAction(char choice);
    public void clearConsole();
    
}
