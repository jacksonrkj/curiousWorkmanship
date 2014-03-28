/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package citbyui.cit260.curiousworkmanship.control;

import citbyui.cit260.curiousworkmanship.model.Barrel;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jacksonrkj
 */
public class InventoryControlTest {
    
    public InventoryControlTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of calVolumeOfBarrel method, of class InventoryControl.
     */
    @Test
    public void testCalVolumeOfBarrel() {
            System.out.println("calVolumeOfBarrel");
        
        // test case #1
        System.out.println("\tTest case #1");
        
        // input values for test case 1
        double height = 24.0;
        double diameter = 12.0;
       
        // create instance of InventoryControl class
        InventoryControl instance = new InventoryControl();
        
        double expResult = 1.5708; // expected output returned value
        
        // call function to run test
        double result = instance.calVolumeOfBarrel(height, diameter);
        
        // compare expected return value with actual value returned
        assertEquals(expResult, result, 0.0001);
        
        
        // test case #2
        System.out.println("\tTest case #2");
        
        // input values for test case 2
        height = -1.0;
        diameter = 12.0;
       
        expResult = -1; // expected output returned value
        
        // call function to run test
        result = instance.calVolumeOfBarrel(height, diameter);
        
        // compare expected return value with actual value returned
        assertEquals(expResult, result, 0.0001);
        
        
        // test case #3
        System.out.println("\tTest case #3");
        
        // input values for test case 3
        height = 24.0;
        diameter = -1.0;
       
        expResult = -1; // expected output returned value
        
        // call function to run test
        result = instance.calVolumeOfBarrel(height, diameter);
        
        // compare expected return value with actual value returned
        assertEquals(expResult, result, 0.0001);
        
        // test case #4
        System.out.println("\tTest case #4");
        
        // input values for test case 4
        height = 24.0;
        diameter = 37.0;
       
        expResult = -1; // expected output returned value
        
        // call function to run test
        result = instance.calVolumeOfBarrel(height, diameter);
        
        // compare expected return value with actual value returned
        assertEquals(expResult, result, 0.0001);
        
        // test case #5
        System.out.println("\tTest case #5");
        
        // input values for test case 5
        height = 0.0;
        diameter = 12.0;
       
        expResult = 0; // expected output returned value
        
        // call function to run test
        result = instance.calVolumeOfBarrel(height, diameter);
        
        // compare expected return value with actual value returned
        assertEquals(expResult, result, 0.0001);
        
        // test case #6
        System.out.println("\tTest case #6");
        
        // input values for test case 6
        height = 24.0;
        diameter = 0.0;
       
        expResult = 0; // expected output returned value
        
        // call function to run test
        result = instance.calVolumeOfBarrel(height, diameter);
        
        // compare expected return value with actual value returned
        assertEquals(expResult, result, 0.0001); 
        
        
        // test case #7
        System.out.println("\tTest case #7");
        
        // input values for test case 7
        height = 24.0;
        diameter = 36.0;
       
        expResult = 14.1372; // expected output returned value
        
        // call function to run test
        result = instance.calVolumeOfBarrel(height, diameter);
        
        // compare expected return value with actual value returned
        assertEquals(expResult, result, 0.0001);        
         
        
    }

    /**
     * Test of calculateBarrelsNeeded method, of class InventoryControl.
     */
    @Test
    public void testCalculateBarrelsNeeded() {
//        System.out.println("calculateBarrelsNeeded");
//        double amountNeededPerDay = 0.0;
//        double amountPerCubicFoot = 0.0;
//        long noOfPeople = 0L;
//        double noOfDays = 0.0;
//        Barrel barrel = null;
//        InventoryControl instance = new InventoryControl();
//        long expResult = 0L;
//        long result = instance.calculateBarrelsNeeded(amountNeededPerDay, amountPerCubicFoot, noOfPeople, noOfDays, barrel);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }
    
}
