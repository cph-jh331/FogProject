/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

<<<<<<< HEAD
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
=======
import org.junit.AfterClass;
>>>>>>> a8e1d681b07b859c96291074d0c085584666dde6
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
<<<<<<< HEAD
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
=======
 * @author bloch
 */
public class PartCalculatorTest {

    public PartCalculatorTest()
    {
    }

    @BeforeClass
    public static void setUpClass()
    {
    }

    @AfterClass
    public static void tearDownClass()
    {
>>>>>>> a8e1d681b07b859c96291074d0c085584666dde6
    }

    /**
     * Test of numbPoles method, of class PartCalculator.
     */
    @Test
<<<<<<< HEAD
    public void testNumbPoles() {
=======
    public void testNumbPoles()
    {
>>>>>>> a8e1d681b07b859c96291074d0c085584666dde6
        System.out.println("numbPoles");
        int lengthOfCarport = 400;
        PartCalculator instance = new PartCalculator();
        int expResult = 4;
        int result = instance.numbPoles(lengthOfCarport);
        assertEquals(expResult, result);
<<<<<<< HEAD
        // TODO review the generated test code and remove the default call to fail.
        
=======
>>>>>>> a8e1d681b07b859c96291074d0c085584666dde6
    }

    /**
     * Test of numbSideRafter method, of class PartCalculator.
     */
    @Test
<<<<<<< HEAD
    public void testNumbSideRafter() {
=======
    public void testNumbSideRafter()
    {
>>>>>>> a8e1d681b07b859c96291074d0c085584666dde6
        System.out.println("numbSideRafter");
        int lengthOfCarport = 500;
        PartCalculator instance = new PartCalculator();
        int expResult = 2;
        int result = instance.numbSideRafter(lengthOfCarport);
        assertEquals(expResult, result);
<<<<<<< HEAD
        // TODO review the generated test code and remove the default call to fail.
        
=======
>>>>>>> a8e1d681b07b859c96291074d0c085584666dde6
    }

    /**
     * Test of lengthOfSideRafter method, of class PartCalculator.
     */
    @Test
<<<<<<< HEAD
    public void testLengthOfSideRafter() {
        System.out.println("lengthOfSideRafter");
        int lengthOfCarport = 550;
        PartCalculator instance = new PartCalculator();
        int expResult = 550;
        int result = instance.lengthOfSideRafter(lengthOfCarport);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
=======
    public void testLengthOfSideRafter()
    {
        System.out.println("lengthOfSideRafter");
        int lengthOfCarport = 500;
        PartCalculator instance = new PartCalculator();
        int expResult = 500;
        int result = instance.lengthOfSideRafter(lengthOfCarport);
        assertEquals(expResult, result);
>>>>>>> a8e1d681b07b859c96291074d0c085584666dde6
    }

    /**
     * Test of numbRafters method, of class PartCalculator.
     */
    @Test
<<<<<<< HEAD
    public void testNumbRafters() {
        System.out.println("numbRafters");
        int lengthOfCarport = 600;
        PartCalculator instance = new PartCalculator();
        int expResult = 11;
        int result = instance.numbRafters(lengthOfCarport);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       
=======
    public void testNumbRafters()
    {
        System.out.println("numbRafters");
        int lengthOfCarport = 500;
        PartCalculator instance = new PartCalculator();
        int expResult = 10;
        int result = instance.numbRafters(lengthOfCarport);
        assertEquals(expResult, result);
>>>>>>> a8e1d681b07b859c96291074d0c085584666dde6
    }

    /**
     * Test of numbRightMounts method, of class PartCalculator.
     */
    @Test
<<<<<<< HEAD
    public void testNumbRightMounts() {
=======
    public void testNumbRightMounts()
    {
>>>>>>> a8e1d681b07b859c96291074d0c085584666dde6
        System.out.println("numbRightMounts");
        int numbRafters = 10;
        PartCalculator instance = new PartCalculator();
        int expResult = 20;
        int result = instance.numbRightMounts(numbRafters);
        assertEquals(expResult, result);
<<<<<<< HEAD
        // TODO review the generated test code and remove the default call to fail.
        
=======
>>>>>>> a8e1d681b07b859c96291074d0c085584666dde6
    }

    /**
     * Test of numbLeftMounts method, of class PartCalculator.
     */
    @Test
<<<<<<< HEAD
    public void testNumbLeftMounts() {
=======
    public void testNumbLeftMounts()
    {
>>>>>>> a8e1d681b07b859c96291074d0c085584666dde6
        System.out.println("numbLeftMounts");
        int numbRafters = 10;
        PartCalculator instance = new PartCalculator();
        int expResult = 20;
        int result = instance.numbLeftMounts(numbRafters);
        assertEquals(expResult, result);
<<<<<<< HEAD
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
        
=======
    }

    /**
     * Test of lengthOfPole method, of class PartCalculator.
     */
    @Test
    public void testLengthOfPole()
    {
        System.out.println("lengthOfPole");
        int heightOfCarport = 200;
        PartCalculator instance = new PartCalculator();
        int expResult = 290;
        int result = instance.lengthOfPole(heightOfCarport);
        assertEquals(expResult, result);
>>>>>>> a8e1d681b07b859c96291074d0c085584666dde6
    }

    /**
     * Test of lengthOfRafter method, of class PartCalculator.
     */
    @Test
<<<<<<< HEAD
    public void testLengthOfRafter() {
=======
    public void testLengthOfRafter()
    {
>>>>>>> a8e1d681b07b859c96291074d0c085584666dde6
        System.out.println("lengthOfRafter");
        int widthOfCarport = 500;
        PartCalculator instance = new PartCalculator();
        int expResult = 500;
        int result = instance.lengthOfRafter(widthOfCarport);
        assertEquals(expResult, result);
<<<<<<< HEAD
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of NumberOfMetalTapes method, of class PartCalculator.
     */
    @Test
    public void testNumberOfMetalTapes() {
        System.out.println("NumberOfMetalTapes");
=======
    }

    /**
     * Test of numbOfMetalTapes method, of class PartCalculator.
     */
    @Test
    public void testNumbOfMetalTapes()
    {
        System.out.println("numbOfMetalTapes");
>>>>>>> a8e1d681b07b859c96291074d0c085584666dde6
        int lengthOfCarport = 500;
        int widthOfCarport = 500;
        PartCalculator instance = new PartCalculator();
        int expResult = 2;
<<<<<<< HEAD
        int result = instance.NumberOfMetalTapes(lengthOfCarport, widthOfCarport);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       
=======
        int result = instance.numbOfMetalTapes(lengthOfCarport, widthOfCarport);
        assertEquals(expResult, result);
>>>>>>> a8e1d681b07b859c96291074d0c085584666dde6
    }

    /**
     * Test of lengthUnderStern method, of class PartCalculator.
     */
    @Test
<<<<<<< HEAD
    public void testLengthUnderStern() {
=======
    public void testLengthUnderStern()
    {
>>>>>>> a8e1d681b07b859c96291074d0c085584666dde6
        System.out.println("lengthUnderStern");
        int lengthOfCarport = 500;
        PartCalculator instance = new PartCalculator();
        int expResult = 500;
        int result = instance.lengthUnderStern(lengthOfCarport);
        assertEquals(expResult, result);
<<<<<<< HEAD
        // TODO review the generated test code and remove the default call to fail.
        
=======
>>>>>>> a8e1d681b07b859c96291074d0c085584666dde6
    }

    /**
     * Test of numbOfLengthUnderStern method, of class PartCalculator.
     */
    @Test
<<<<<<< HEAD
    public void testNumbOfLengthUnderStern() {
=======
    public void testNumbOfLengthUnderStern()
    {
>>>>>>> a8e1d681b07b859c96291074d0c085584666dde6
        System.out.println("numbOfLengthUnderStern");
        int lengthUnderStern = 500;
        PartCalculator instance = new PartCalculator();
        int expResult = 2;
        int result = instance.numbOfLengthUnderStern(lengthUnderStern);
        assertEquals(expResult, result);
<<<<<<< HEAD
        // TODO review the generated test code and remove the default call to fail.
        
=======
>>>>>>> a8e1d681b07b859c96291074d0c085584666dde6
    }

    /**
     * Test of widthUnderStern method, of class PartCalculator.
     */
    @Test
<<<<<<< HEAD
    public void testWidthUnderStern() {
=======
    public void testWidthUnderStern()
    {
>>>>>>> a8e1d681b07b859c96291074d0c085584666dde6
        System.out.println("widthUnderStern");
        int widthOfCarport = 500;
        PartCalculator instance = new PartCalculator();
        int expResult = 500;
        int result = instance.widthUnderStern(widthOfCarport);
        assertEquals(expResult, result);
<<<<<<< HEAD
        // TODO review the generated test code and remove the default call to fail.
        
=======
>>>>>>> a8e1d681b07b859c96291074d0c085584666dde6
    }

    /**
     * Test of numbOfWidthUnderStern method, of class PartCalculator.
     */
    @Test
<<<<<<< HEAD
    public void testNumbOfWidthUnderStern() {
=======
    public void testNumbOfWidthUnderStern()
    {
>>>>>>> a8e1d681b07b859c96291074d0c085584666dde6
        System.out.println("numbOfWidthUnderStern");
        int widthUnderStern = 500;
        PartCalculator instance = new PartCalculator();
        int expResult = 2;
        int result = instance.numbOfWidthUnderStern(widthUnderStern);
        assertEquals(expResult, result);
<<<<<<< HEAD
        // TODO review the generated test code and remove the default call to fail.
        
=======
>>>>>>> a8e1d681b07b859c96291074d0c085584666dde6
    }

    /**
     * Test of lengthOverStern method, of class PartCalculator.
     */
    @Test
<<<<<<< HEAD
    public void testLengthOverStern() {
=======
    public void testLengthOverStern()
    {
>>>>>>> a8e1d681b07b859c96291074d0c085584666dde6
        System.out.println("lengthOverStern");
        int lengthOfCarport = 500;
        PartCalculator instance = new PartCalculator();
        int expResult = 500;
        int result = instance.lengthOverStern(lengthOfCarport);
        assertEquals(expResult, result);
<<<<<<< HEAD
        // TODO review the generated test code and remove the default call to fail.
        
=======
>>>>>>> a8e1d681b07b859c96291074d0c085584666dde6
    }

    /**
     * Test of numbOfLengthOverStern method, of class PartCalculator.
     */
    @Test
<<<<<<< HEAD
    public void testNumbOfLengthOverStern() {
=======
    public void testNumbOfLengthOverStern()
    {
>>>>>>> a8e1d681b07b859c96291074d0c085584666dde6
        System.out.println("numbOfLengthOverStern");
        int lengthOverStern = 500;
        PartCalculator instance = new PartCalculator();
        int expResult = 2;
        int result = instance.numbOfLengthOverStern(lengthOverStern);
        assertEquals(expResult, result);
<<<<<<< HEAD
        // TODO review the generated test code and remove the default call to fail.
        
=======
>>>>>>> a8e1d681b07b859c96291074d0c085584666dde6
    }

    /**
     * Test of widthOverStern method, of class PartCalculator.
     */
    @Test
<<<<<<< HEAD
    public void testWidthOverStern() {
        System.out.println("widthOverStern");
        int widthOfCarport = 400;
        PartCalculator instance = new PartCalculator();
        int expResult = 400;
        int result = instance.widthOverStern(widthOfCarport);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
=======
    public void testWidthOverStern()
    {
        System.out.println("widthOverStern");
        int widthOfCarport = 500;
        PartCalculator instance = new PartCalculator();
        int expResult = 500;
        int result = instance.widthOverStern(widthOfCarport);
        assertEquals(expResult, result);
>>>>>>> a8e1d681b07b859c96291074d0c085584666dde6
    }

    /**
     * Test of numbOfWidthOverStern method, of class PartCalculator.
     */
    @Test
<<<<<<< HEAD
    public void testNumbOfWidthOverStern() {
        System.out.println("numbOfWidthOverStern");
        int widthOverStern = 400;
=======
    public void testNumbOfWidthOverStern()
    {
        System.out.println("numbOfWidthOverStern");
        int widthOverStern = 500;
>>>>>>> a8e1d681b07b859c96291074d0c085584666dde6
        PartCalculator instance = new PartCalculator();
        int expResult = 2;
        int result = instance.numbOfWidthOverStern(widthOverStern);
        assertEquals(expResult, result);
<<<<<<< HEAD
        // TODO review the generated test code and remove the default call to fail.
        
=======
>>>>>>> a8e1d681b07b859c96291074d0c085584666dde6
    }

    /**
     * Test of widthWaterBoard method, of class PartCalculator.
     */
    @Test
<<<<<<< HEAD
    public void testWidthWaterBoard() {
        System.out.println("widthWaterBoard");
        int widthOfCarport = 400;
        PartCalculator instance = new PartCalculator();
        int expResult = 400;
        int result = instance.widthWaterBoard(widthOfCarport);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
=======
    public void testWidthWaterBoard()
    {
        System.out.println("widthWaterBoard");
        int widthOfCarport = 500;
        PartCalculator instance = new PartCalculator();
        int expResult = 500;
        int result = instance.widthWaterBoard(widthOfCarport);
        assertEquals(expResult, result);
>>>>>>> a8e1d681b07b859c96291074d0c085584666dde6
    }

    /**
     * Test of numbWidthWaterBoard method, of class PartCalculator.
     */
    @Test
<<<<<<< HEAD
    public void testNumbWidthWaterBoard() {
        System.out.println("numbWidthWaterBoard");
        int widthWaterBoard = 400;
=======
    public void testNumbWidthWaterBoard()
    {
        System.out.println("numbWidthWaterBoard");
        int widthWaterBoard = 500;
>>>>>>> a8e1d681b07b859c96291074d0c085584666dde6
        PartCalculator instance = new PartCalculator();
        int expResult = 1;
        int result = instance.numbWidthWaterBoard(widthWaterBoard);
        assertEquals(expResult, result);
<<<<<<< HEAD
        // TODO review the generated test code and remove the default call to fail.
        
=======
>>>>>>> a8e1d681b07b859c96291074d0c085584666dde6
    }

    /**
     * Test of lengthWaterBoard method, of class PartCalculator.
     */
    @Test
<<<<<<< HEAD
    public void testLengthWaterBoard() {
=======
    public void testLengthWaterBoard()
    {
>>>>>>> a8e1d681b07b859c96291074d0c085584666dde6
        System.out.println("lengthWaterBoard");
        int lengthOfCarport = 500;
        PartCalculator instance = new PartCalculator();
        int expResult = 500;
        int result = instance.lengthWaterBoard(lengthOfCarport);
        assertEquals(expResult, result);
<<<<<<< HEAD
        // TODO review the generated test code and remove the default call to fail.
        
=======
>>>>>>> a8e1d681b07b859c96291074d0c085584666dde6
    }

    /**
     * Test of numbLengthWaterBoard method, of class PartCalculator.
     */
    @Test
<<<<<<< HEAD
    public void testNumbLengthWaterBoard() {
=======
    public void testNumbLengthWaterBoard()
    {
>>>>>>> a8e1d681b07b859c96291074d0c085584666dde6
        System.out.println("numbLengthWaterBoard");
        int legnthWaterBoard = 500;
        PartCalculator instance = new PartCalculator();
        int expResult = 2;
        int result = instance.numbLengthWaterBoard(legnthWaterBoard);
        assertEquals(expResult, result);
<<<<<<< HEAD
        // TODO review the generated test code and remove the default call to fail.
        
    }
    
=======
    }

>>>>>>> a8e1d681b07b859c96291074d0c085584666dde6
}
