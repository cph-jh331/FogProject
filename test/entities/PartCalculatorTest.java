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
        int lengthOfCarport = 0;
        PartCalculator instance = new PartCalculator();
        int expResult = 0;
        int result = instance.numbPoles(lengthOfCarport);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of numbSideRafter method, of class PartCalculator.
     */
    @Test
    public void testNumbSideRafter() {
        System.out.println("numbSideRafter");
        int lengthOfCarport = 0;
        PartCalculator instance = new PartCalculator();
        int expResult = 0;
        int result = instance.numbSideRafter(lengthOfCarport);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of lengthOfSideRafter method, of class PartCalculator.
     */
    @Test
    public void testLengthOfSideRafter() {
        System.out.println("lengthOfSideRafter");
        int lengthOfCarport = 0;
        PartCalculator instance = new PartCalculator();
        int expResult = 0;
        int result = instance.lengthOfSideRafter(lengthOfCarport);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of numbRafters method, of class PartCalculator.
     */
    @Test
    public void testNumbRafters() {
        System.out.println("numbRafters");
        int lengthOfCarport = 0;
        PartCalculator instance = new PartCalculator();
        int expResult = 0;
        int result = instance.numbRafters(lengthOfCarport);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of numbRightMounts method, of class PartCalculator.
     */
    @Test
    public void testNumbRightMounts() {
        System.out.println("numbRightMounts");
        int numbRafters = 0;
        PartCalculator instance = new PartCalculator();
        int expResult = 0;
        int result = instance.numbRightMounts(numbRafters);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of numbLeftMounts method, of class PartCalculator.
     */
    @Test
    public void testNumbLeftMounts() {
        System.out.println("numbLeftMounts");
        int numbRafters = 0;
        PartCalculator instance = new PartCalculator();
        int expResult = 0;
        int result = instance.numbLeftMounts(numbRafters);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of lengthOfPole method, of class PartCalculator.
     */
    @Test
    public void testLengthOfPole() {
        System.out.println("lengthOfPole");
        int heightOfCarport = 0;
        PartCalculator instance = new PartCalculator();
        int expResult = 0;
        int result = instance.lengthOfPole(heightOfCarport);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of lengthOfRafter method, of class PartCalculator.
     */
    @Test
    public void testLengthOfRafter() {
        System.out.println("lengthOfRafter");
        int widthOfCarport = 0;
        PartCalculator instance = new PartCalculator();
        int expResult = 0;
        int result = instance.lengthOfRafter(widthOfCarport);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of numbOfMetalTapes method, of class PartCalculator.
     */
    @Test
    public void testNumbOfMetalTapes() {
        System.out.println("numbOfMetalTapes");
        int lengthOfCarport = 0;
        int widthOfCarport = 0;
        PartCalculator instance = new PartCalculator();
        int expResult = 0;
        int result = instance.numbOfMetalTapes(lengthOfCarport, widthOfCarport);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of lengthUnderStern method, of class PartCalculator.
     */
    @Test
    public void testLengthUnderStern() {
        System.out.println("lengthUnderStern");
        int lengthOfCarport = 0;
        PartCalculator instance = new PartCalculator();
        int expResult = 0;
        int result = instance.lengthUnderStern(lengthOfCarport);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of numbOfLengthUnderStern method, of class PartCalculator.
     */
    @Test
    public void testNumbOfLengthUnderStern() {
        System.out.println("numbOfLengthUnderStern");
        int lengthUnderStern = 0;
        PartCalculator instance = new PartCalculator();
        int expResult = 0;
        int result = instance.numbOfLengthUnderStern(lengthUnderStern);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of widthUnderStern method, of class PartCalculator.
     */
    @Test
    public void testWidthUnderStern() {
        System.out.println("widthUnderStern");
        int widthOfCarport = 0;
        PartCalculator instance = new PartCalculator();
        int expResult = 0;
        int result = instance.widthUnderStern(widthOfCarport);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of numbOfWidthUnderStern method, of class PartCalculator.
     */
    @Test
    public void testNumbOfWidthUnderStern() {
        System.out.println("numbOfWidthUnderStern");
        int widthUnderStern = 0;
        PartCalculator instance = new PartCalculator();
        int expResult = 0;
        int result = instance.numbOfWidthUnderStern(widthUnderStern);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of lengthOverStern method, of class PartCalculator.
     */
    @Test
    public void testLengthOverStern() {
        System.out.println("lengthOverStern");
        int lengthOfCarport = 0;
        PartCalculator instance = new PartCalculator();
        int expResult = 0;
        int result = instance.lengthOverStern(lengthOfCarport);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of numbOfLengthOverStern method, of class PartCalculator.
     */
    @Test
    public void testNumbOfLengthOverStern() {
        System.out.println("numbOfLengthOverStern");
        int lengthOverStern = 0;
        PartCalculator instance = new PartCalculator();
        int expResult = 0;
        int result = instance.numbOfLengthOverStern(lengthOverStern);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of widthOverStern method, of class PartCalculator.
     */
    @Test
    public void testWidthOverStern() {
        System.out.println("widthOverStern");
        int widthOfCarport = 0;
        PartCalculator instance = new PartCalculator();
        int expResult = 0;
        int result = instance.widthOverStern(widthOfCarport);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of numbOfWidthOverStern method, of class PartCalculator.
     */
    @Test
    public void testNumbOfWidthOverStern() {
        System.out.println("numbOfWidthOverStern");
        int widthOverStern = 0;
        PartCalculator instance = new PartCalculator();
        int expResult = 0;
        int result = instance.numbOfWidthOverStern(widthOverStern);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of widthWaterBoard method, of class PartCalculator.
     */
    @Test
    public void testWidthWaterBoard() {
        System.out.println("widthWaterBoard");
        int widthOfCarport = 0;
        PartCalculator instance = new PartCalculator();
        int expResult = 0;
        int result = instance.widthWaterBoard(widthOfCarport);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of numbWidthWaterBoard method, of class PartCalculator.
     */
    @Test
    public void testNumbWidthWaterBoard() {
        System.out.println("numbWidthWaterBoard");
        int widthWaterBoard = 0;
        PartCalculator instance = new PartCalculator();
        int expResult = 0;
        int result = instance.numbWidthWaterBoard(widthWaterBoard);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of lengthWaterBoard method, of class PartCalculator.
     */
    @Test
    public void testLengthWaterBoard() {
        System.out.println("lengthWaterBoard");
        int lengthOfCarport = 0;
        PartCalculator instance = new PartCalculator();
        int expResult = 0;
        int result = instance.lengthWaterBoard(lengthOfCarport);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of numbLengthWaterBoard method, of class PartCalculator.
     */
    @Test
    public void testNumbLengthWaterBoard() {
        System.out.println("numbLengthWaterBoard");
        int legnthWaterBoard = 0;
        PartCalculator instance = new PartCalculator();
        int expResult = 0;
        int result = instance.numbLengthWaterBoard(legnthWaterBoard);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
