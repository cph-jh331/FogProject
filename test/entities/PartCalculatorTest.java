/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Pva
 */
public class PartCalculatorTest {
    
    public PartCalculatorTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of numbPoles method, of class PartCalculator.
     */
    @Test
    public void testNumbPoles() {
        System.out.println("numbPoles");
        int lengthOfCarport = 400;
        PartCalculator instance = new PartCalculator();
        int expResult = 4;
        int result = instance.numbPoles(lengthOfCarport);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of numbSideRafter method, of class PartCalculator.
     */
    @Test
    public void testNumbSideRafter() {
        System.out.println("numbSideRafter");
        int lengthOfCarport = 500;
        PartCalculator instance = new PartCalculator();
        int expResult = 2;
        int result = instance.numbSideRafter(lengthOfCarport);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of lengthOfSideRafter method, of class PartCalculator.
     */
    @Test
    public void testLengthOfSideRafter() {
        System.out.println("lengthOfSideRafter");
        int lengthOfCarport = 550;
        PartCalculator instance = new PartCalculator();
        int expResult = 550;
        int result = instance.lengthOfSideRafter(lengthOfCarport);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of numbRafters method, of class PartCalculator.
     */
    @Test
    public void testNumbRafters() {
        System.out.println("numbRafters");
        int lengthOfCarport = 600;
        PartCalculator instance = new PartCalculator();
        int expResult = 11;
        int result = instance.numbRafters(lengthOfCarport);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       
    }

    /**
     * Test of numbRightMounts method, of class PartCalculator.
     */
    @Test
    public void testNumbRightMounts() {
        System.out.println("numbRightMounts");
        int numbRafters = 10;
        PartCalculator instance = new PartCalculator();
        int expResult = 20;
        int result = instance.numbRightMounts(numbRafters);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of numbLeftMounts method, of class PartCalculator.
     */
    @Test
    public void testNumbLeftMounts() {
        System.out.println("numbLeftMounts");
        int numbRafters = 10;
        PartCalculator instance = new PartCalculator();
        int expResult = 20;
        int result = instance.numbLeftMounts(numbRafters);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of numbTrapezRoof method, of class PartCalculator.
     */
//        @Test
//        public void testNumbTrapezRoof() {
//            System.out.println("numbTrapezRoof");
//            int lengthOfCarport = 0;
//            int widthOfCarport = 0;
//            PartCalculator instance = new PartCalculator();
//            int expResult = 0;
//            int result = instance.numbTrapezRoof(lengthOfCarport, widthOfCarport);
//            assertEquals(expResult, result);
//            // TODO review the generated test code and remove the default call to fail.
//            fail("The test case is a prototype.");
//        }

    /**
     * Test of lengthOfPole method, of class PartCalculator.
     */
    @Test
    public void testLengthOfPole() {
        System.out.println("lengthOfPole");
        int heightOfCarport = 300;
        PartCalculator instance = new PartCalculator();
        int expResult = 390;
        int result = instance.lengthOfPole(heightOfCarport);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of lengthOfRafter method, of class PartCalculator.
     */
    @Test
    public void testLengthOfRafter() {
        System.out.println("lengthOfRafter");
        int widthOfCarport = 500;
        PartCalculator instance = new PartCalculator();
        int expResult = 500;
        int result = instance.lengthOfRafter(widthOfCarport);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of NumberOfMetalTapes method, of class PartCalculator.
     */
    @Test
    public void testNumberOfMetalTapes() {
        System.out.println("NumberOfMetalTapes");
        int lengthOfCarport = 500;
        int widthOfCarport = 500;
        PartCalculator instance = new PartCalculator();
        int expResult = 2;
        int result = instance.NumberOfMetalTapes(lengthOfCarport, widthOfCarport);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       
    }

    /**
     * Test of lengthUnderStern method, of class PartCalculator.
     */
    @Test
    public void testLengthUnderStern() {
        System.out.println("lengthUnderStern");
        int lengthOfCarport = 500;
        PartCalculator instance = new PartCalculator();
        int expResult = 500;
        int result = instance.lengthUnderStern(lengthOfCarport);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of numbOfLengthUnderStern method, of class PartCalculator.
     */
    @Test
    public void testNumbOfLengthUnderStern() {
        System.out.println("numbOfLengthUnderStern");
        int lengthUnderStern = 500;
        PartCalculator instance = new PartCalculator();
        int expResult = 2;
        int result = instance.numbOfLengthUnderStern(lengthUnderStern);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of widthUnderStern method, of class PartCalculator.
     */
    @Test
    public void testWidthUnderStern() {
        System.out.println("widthUnderStern");
        int widthOfCarport = 500;
        PartCalculator instance = new PartCalculator();
        int expResult = 500;
        int result = instance.widthUnderStern(widthOfCarport);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of numbOfWidthUnderStern method, of class PartCalculator.
     */
    @Test
    public void testNumbOfWidthUnderStern() {
        System.out.println("numbOfWidthUnderStern");
        int widthUnderStern = 500;
        PartCalculator instance = new PartCalculator();
        int expResult = 2;
        int result = instance.numbOfWidthUnderStern(widthUnderStern);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of lengthOverStern method, of class PartCalculator.
     */
    @Test
    public void testLengthOverStern() {
        System.out.println("lengthOverStern");
        int lengthOfCarport = 500;
        PartCalculator instance = new PartCalculator();
        int expResult = 500;
        int result = instance.lengthOverStern(lengthOfCarport);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of numbOfLengthOverStern method, of class PartCalculator.
     */
    @Test
    public void testNumbOfLengthOverStern() {
        System.out.println("numbOfLengthOverStern");
        int lengthOverStern = 500;
        PartCalculator instance = new PartCalculator();
        int expResult = 2;
        int result = instance.numbOfLengthOverStern(lengthOverStern);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of widthOverStern method, of class PartCalculator.
     */
    @Test
    public void testWidthOverStern() {
        System.out.println("widthOverStern");
        int widthOfCarport = 400;
        PartCalculator instance = new PartCalculator();
        int expResult = 400;
        int result = instance.widthOverStern(widthOfCarport);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of numbOfWidthOverStern method, of class PartCalculator.
     */
    @Test
    public void testNumbOfWidthOverStern() {
        System.out.println("numbOfWidthOverStern");
        int widthOverStern = 400;
        PartCalculator instance = new PartCalculator();
        int expResult = 2;
        int result = instance.numbOfWidthOverStern(widthOverStern);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of widthWaterBoard method, of class PartCalculator.
     */
    @Test
    public void testWidthWaterBoard() {
        System.out.println("widthWaterBoard");
        int widthOfCarport = 400;
        PartCalculator instance = new PartCalculator();
        int expResult = 400;
        int result = instance.widthWaterBoard(widthOfCarport);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of numbWidthWaterBoard method, of class PartCalculator.
     */
    @Test
    public void testNumbWidthWaterBoard() {
        System.out.println("numbWidthWaterBoard");
        int widthWaterBoard = 400;
        PartCalculator instance = new PartCalculator();
        int expResult = 1;
        int result = instance.numbWidthWaterBoard(widthWaterBoard);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of lengthWaterBoard method, of class PartCalculator.
     */
    @Test
    public void testLengthWaterBoard() {
        System.out.println("lengthWaterBoard");
        int lengthOfCarport = 500;
        PartCalculator instance = new PartCalculator();
        int expResult = 500;
        int result = instance.lengthWaterBoard(lengthOfCarport);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of numbLengthWaterBoard method, of class PartCalculator.
     */
    @Test
    public void testNumbLengthWaterBoard() {
        System.out.println("numbLengthWaterBoard");
        int legnthWaterBoard = 500;
        PartCalculator instance = new PartCalculator();
        int expResult = 2;
        int result = instance.numbLengthWaterBoard(legnthWaterBoard);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }
    
}
