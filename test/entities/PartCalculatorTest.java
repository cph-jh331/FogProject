/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import backend.UserMapper;
import java.util.List;
import logic.Customer;
import logic.LogicCtrl;
import logic.PartCalculator;
import logic.SvgDrawing;
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
        LogicCtrl lc = new LogicCtrl();
        List<SvgDrawing> drawList = lc.getCustomerSvgWithStatus(SvgDrawing.Status.reqApproved, 8);
        SvgDrawing svgDrawing = drawList.get(0);
        lc.changeStatusOnSvg(svgDrawing.getSvgId(), SvgDrawing.Status.created);        
    }

    /**
     * Test of numbPoles method, of class PartCalculator.
     */
    @Test
    public void testNumbPoles() {
        System.out.println("numbPoles");
        int lengthOfCarport = 500;
        PartCalculator instance = new PartCalculator();
        int expResult = 4;
        int result = instance.numbPoles(lengthOfCarport);
        assertEquals(expResult, result);
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
    }

    /**
     * Test of lengthOfSideRafter method, of class PartCalculator.
     */
    @Test
    public void testLengthOfSideRafter() {
        System.out.println("lengthOfSideRafter");
        int lengthOfCarport = 500;
        PartCalculator instance = new PartCalculator();
        int expResult = 500;
        int result = instance.lengthOfSideRafter(lengthOfCarport);
        assertEquals(expResult, result);
    }

    /**
     * Test of numbRafters method, of class PartCalculator.
     */
    @Test
    public void testNumbRafters() {
        System.out.println("numbRafters");
        int lengthOfCarport = 500;
        PartCalculator instance = new PartCalculator();
        int expResult = 10;
        int result = instance.numbRafters(lengthOfCarport);
        assertEquals(expResult, result);
    }

    /**
     * Test of numbRightMounts method, of class PartCalculator.
     */
    @Test
    public void testNumbRightMounts() {
        System.out.println("numbRightMounts");
        int numbRafters = 10;
        PartCalculator instance = new PartCalculator();
        int expResult = 10;
        int result = instance.numbRightMounts(numbRafters);
        assertEquals(expResult, result);
    }

    /**
     * Test of numbLeftMounts method, of class PartCalculator.
     */
    @Test
    public void testNumbLeftMounts() {
        System.out.println("numbLeftMounts");
        int numbRafters = 10;
        PartCalculator instance = new PartCalculator();
        int expResult = 10;
        int result = instance.numbLeftMounts(numbRafters);
        assertEquals(expResult, result);
    }

    /**
     * Test of lengthOfPole method, of class PartCalculator.
     */
    @Test
    public void testLengthOfPole() {
        System.out.println("lengthOfPole");
        int heightOfCarport = 200;
        PartCalculator instance = new PartCalculator();
        int expResult = 290;
        int result = instance.lengthOfPole(heightOfCarport);
        assertEquals(expResult, result);
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
    }

    /**
     * Test of numbOfMetalTapes method, of class PartCalculator.
     */
    @Test
    public void testNumbOfMetalTapes() {
        System.out.println("numbOfMetalTapes");
        int lengthOfCarport = 500;
        int widthOfCarport = 500;
        PartCalculator instance = new PartCalculator();
        int expResult = 2;
        int result = instance.numbOfMetalTapes(lengthOfCarport, widthOfCarport);
        assertEquals(expResult, result);
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
    }

    /**
     * Test of widthOverStern method, of class PartCalculator.
     */
    @Test
    public void testWidthOverStern() {
        System.out.println("widthOverStern");
        int widthOfCarport = 500;
        PartCalculator instance = new PartCalculator();
        int expResult = 500;
        int result = instance.widthOverStern(widthOfCarport);
        assertEquals(expResult, result);
    }

    /**
     * Test of numbOfWidthOverStern method, of class PartCalculator.
     */
    @Test
    public void testNumbOfWidthOverStern() {
        System.out.println("numbOfWidthOverStern");
        int widthOverStern = 500;
        PartCalculator instance = new PartCalculator();
        int expResult = 2;
        int result = instance.numbOfWidthOverStern(widthOverStern);
        assertEquals(expResult, result);
    }

    /**
     * Test of widthWaterBoard method, of class PartCalculator.
     */
    @Test
    public void testWidthWaterBoard() {
        System.out.println("widthWaterBoard");
        int widthOfCarport = 500;
        PartCalculator instance = new PartCalculator();
        int expResult = 500;
        int result = instance.widthWaterBoard(widthOfCarport);
        assertEquals(expResult, result);
    }

    /**
     * Test of numbWidthWaterBoard method, of class PartCalculator.
     */
    @Test
    public void testNumbWidthWaterBoard() {
        System.out.println("numbWidthWaterBoard");
        int widthWaterBoard = 500;
        PartCalculator instance = new PartCalculator();
        int expResult = 1;
        int result = instance.numbWidthWaterBoard(widthWaterBoard);
        assertEquals(expResult, result);
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
    }

    //Test userlogin
    @Test
    public void testCustomerLogin() {
        UserMapper um = new UserMapper();
        String email = "user@test.dk";
        String password = "123";
        Customer cust = um.validateCustomer(email, password);
        int expId = 1;
        int result = cust.getCustomerId();
        assertEquals(expId, result);
    }

    //test admin login
    @Test
    public void testAdminLogin() {
        UserMapper um = new UserMapper();
        String email = "test@test.dk";
        String password = "123";
        Customer cust = um.validateAdmin(email, password);
        int expId = 1;
        int result = cust.getCustomerId();
        assertEquals(expId, result);
    }

    //test user laver tegning
    @Test
    public void testUserCreateDrawing() {
        String height = "200";
        String width = "400";
        String length = "600";
        String expResult = "<svg id='svg1' xmlns='http://www.w3.org/2000/svg' xmlns:xlink='http://www.w3.org/1999/xlink'\n"
                + "width='100%'viewbox='0,0,800,300' preserveaspectratio='none'>\n"
                + "<rect x='1' y='1' width='800' height='300' style='stroke:000000;fill:white;'/>\n"
                + "<rect x='65' y='50' width='5' height='200'\n"
                + "style='stroke:#000000;fill:none;'/>\n"
                + "<rect x='575' y='50' width='5' height ='200'\n"
                + "style='stroke:#000000;fill:none;'/>\n"
                + "<rect x='320' y='50' width='5' height='200'\n"
                + "style='stroke:#000000;fill:none;'/>\n"
                + "<rect x='20' y='39' width='600' height='20'\n"
                + "style='stroke:#000000;fill:white;'/>\n"
                + "<rect x='20' y='39' width ='600' height='15'\n"
                + "style='stroke:#000000;fill:white;'/>\n"
                + "<text x='110' y='290'style='fill:black;'>længde: 600</text>\n"
                + "<line x1='20' y1='270' x2='620' y2='270'style='stroke:black;stroke-width:1;'/><text x='650' y='40' style='fill:black'>Højde:200</text>\n"
                + "\n"
                + "</svg>";
        
        LogicCtrl lc = new LogicCtrl();
        String result = lc.createSvgSideView(height, length);
        assertEquals(expResult, result);
        
    }

    //test user sender tegning til godkendelse.
    @Test
    public void userDrawToApprove() {
        
        LogicCtrl lc = new LogicCtrl();
        List<SvgDrawing> drawList = lc.getCustomerSvgWithStatus(SvgDrawing.Status.created, 8);
        SvgDrawing svgDrawing = drawList.get(0);
        String firstResult = svgDrawing.getStatus().toString();
        String expResult = "created";
        assertEquals(expResult, firstResult);
        
        lc.changeStatusOnSvg(svgDrawing.getSvgId(), SvgDrawing.Status.reqApproved);
        String expResult2 = "reqApproved";
        String secondResult = svgDrawing.getStatus().toString();
        assertEquals(expResult, secondResult);
        
    }

    //test fog godkender tegning.
    //test user afslutter tegning.
    //fjerne sout msg. 
}
