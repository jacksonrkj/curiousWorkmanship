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
public class HelpMenuView extends MenuView {

    public HelpMenuView() {
        super("\n"
             + "\n-----------------------------------------"
             + "\n| Help Menu                             |"
             + "\n-----------------------------------------"
             + "\nG - What is the goal of the game?"
             + "\nT - Travel to a new location"
             + "\nV - View a description of a location"
             + "\nE - Estimating the resources needed"
             + "\nB - Design barrels"
             + "\nM - Manufacture items"
             + "\nR - Harvesting resources"
             + "\nD - Deliver resources"
             + "\nW - Work on ship"
             + "\nP - Pack ship"
             + "\nJ - Launch ship"
             + "\nQ - Quit"
             + "\n-----------------------------------------"); 
    }    

   
    
    
    public void doAction(char selection) {
     
        switch (selection) {
            case 'G':
                System.out.println("\n"
                    + "\nThe goals of the game are to first determine what"
                    + "\nresources are needed for the trip. Then you must"
                    + "\nsearch for, locate and harvest the resources"
                    + "\needed to build and stock the ship with provisions."
                    + "\nYou will also need to manufacture tools and the "
                    + "\nbarrels needed to store the necessary items for"
                    + "\nthe journey on the ship. You will need to"
                    + "\nbuild the ship, load the barrel of resources on"
                    + "\nthe ship. Finally, when all is ready you must"
                    + "\nlaunch the ship to the promised land.");
                break;
            case 'T':
                 System.out.println("\n"
                    + "\nMove a person to a new location in the game. Select"
                    + "\nthe Travel to new location option in the Game"
                    + "\nMenu. Select the person that will be moved"
                    + "\nand the row and column coordinates of the location"
                    + "\nthey are to be moved to in the map. The person"
                    + "\nbe moved to the new location if there are no"
                    + "\nobstacles in the most direct path to the location."
                    + "\nIf you encounter an obstacle you will have"
                    + "\nto move around the obstacle to get to your desired"
                    + "\nlocation.");

                break;
            case 'V':
                System.out.println("\n"
                    + "\nView the description of a location and who is"
                    + "\ncurrently at that location. You can not view a "
                    + "\nlocation until someone has visited the location at"
                    + "\nleast one time. Select the View Location option in"
                    + "\nthe Game menu and enter the coordinates of the"
                    + "\nlocation you would like to view.");
                break;
            case 'E':
                System.out.println("\n"
                    + "\nAs part of the planning phase of the game, you will"
                    + "\nneed to estimate the resources that will be needed"
                    + "\nto survive the voyage to the promised land. Select"
                    + "\nthe Estimate the resources needed option on the"
                    + "\nGame menu. Select a resource and then enter the "
                    + "\nnumber of barrels of that particular item that are"
                    + "\nneeded for the trip. The amount needed is based on"
                    + "\nthe recommended daily amount of food storage per" 
                    + "\nperson. You will need to go search the Internet"
                    + "\nthe recommended amount per person. You will then"
                    + "\nhave to figure how much can be stored in the barrels" 
                    + "\ndesigned to hold the selected type of resource you"
                    + "\nyou are planning for. You will have to go back to"
                    + "\ngame menu and design the barrels first if you have"
                    + "\nalready done so");
                break;
            case 'B':
                System.out.println("\n"
                    + "\nDesign the barrels to hold the different types of "
                    + "\nresources to be loaded on the ship. Select the Design "
                    + "\nBarrels option on the Game menu. Select a resource "
                    + "\nand then enter height and diameter of the barrel for"
                    + "\nthe resource being selected.");
                break;
            case 'M':
                System.out.println("\n"
                    + "\nYou will need to manufacture items needed to build"
                    + "\nthe ship and store the items that you will take on"
                    + "\nyour journey. Select the Manufacture items option"
                    + "\non the Game Menu. Select a person to manufacture"
                    + "\nthe item and the amount to be manufacured.");
                break;
            case 'R':
                System.out.println("\n"
                    + "\nYou must locate the resources needed in the land"
                    + "\nof Bountiful and then harvest the resource."
                    + "\nSelect the Havest resource option in the Game"
                    + "\nMenu and enter the amount that you want to harvest.");
                break;
            case 'D':
                System.out.println("\n"
                    + "\nOnce you have harvested a resource you will need"
                    + "\nto deliver the resource to the warehouse. Move the"
                    + "\nperson who just harvested a resource to the"
                    + "\nwarehouse and Select the Deliver resource option"
                    + "\non the Game Menu. The items will be unloaded and"
                    + "\nstored in the warehouse.");
                break;

            case 'W':
                System.out.println("\n"
                    + "\nYou will need to assign people to work on building"
                    + "\nthe ship. Select the indvidual to work on the ship"
                    + "\nand enter the number of days that they will work"
                    + "\non the ship.");
                break;
            case 'P':
                System.out.println("\n"
                    + "\nYou will need to load and pack the resources on"
                    + "\nthe ship before you can launch it. You can start"
                    + "\nloading the ship once that it is 75% complete."
                    + "\nSelect the Pack ship option on the Game Menu. Then"
                    + "\nselect an indvidual to working on packing the ship"
                    + "\nand the number days they are to work on this task.");
                break;

            case 'J':
                System.out.println("\n"
                    + "\nLaunch the ship and embark on your journey to the "
                    + "\ntPromised Land. You must have completed the ship"
                    + "\nand loaded ship with all of the required resources"
                    + "\nbefore you start your journey. Select the Launch"
                    + "\nship option on the Game Menu. If the shipe is"
                    + "\ncompleted and all of the required resources are"
                    + "\nloaded on the ship then win the game");
                break;
            case 'Q':
                return;

            default:
                System.out.println("\n*** Invalid selection *** Try again");
        }
       
    }    

    
    
    
    
}
