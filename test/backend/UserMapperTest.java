/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import logic.Customer;
import logic.User;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import static org.hamcrest.CoreMatchers.is;
import org.junit.AfterClass;
import org.junit.BeforeClass;

/**
 *
 * @author Bloch
 */
public class UserMapperTest {

    private UserMapper um;
    private Connection con;
    private String DRIVER = "com.mysql.jdbc.Driver";
    private String ID = "seer";
    private String PASSWORD = "Hest123@hest.dk";
    private String DATABASE = "testDB";
    private String HOST = "207.154.197.253";

    @BeforeClass
    public static void setUpClass() throws Exception
    {
    }

    @AfterClass
    public static void tearDownClass() throws Exception
    {
    }

    @Before
    public void setUp()
    {
        try
        {
            String url = String.format("jdbc:mysql://%s:3306/%s", HOST, DATABASE);
            Class.forName(DRIVER);
            con = DriverManager.getConnection(url, ID, PASSWORD);

            try (Statement stmt = con.createStatement())
            {
                stmt.execute("use testDB");
                stmt.execute("drop table if exists Customer");
                stmt.execute("drop table if exists FogUser");

                stmt.execute("CREATE TABLE Customer ("
                        + "  customerId int(12) NOT NULL AUTO_INCREMENT,"
                        + "  userName varchar(45) NOT NULL,"
                        + "  userLastname varchar(45) NOT NULL,"
                        + "  userAddress varchar(45) NOT NULL,"
                        + "  userCity varchar(45) NOT NULL,"
                        + "  userZip varchar(45) NOT NULL,"
                        + "  userPhone varchar(45) NOT NULL,"
                        + "  userEmail varchar(45) NOT NULL,"
                        + "  password varchar(45) NOT NULL,"
                        + "  admin tinyint(1) NOT NULL DEFAULT '0',"
                        + "  PRIMARY KEY (customerId),"
                        + "  UNIQUE KEY customerId_UNIQUE (customerId),"
                        + "  UNIQUE KEY userEmail_UNIQUE (userEmail)) ");

                stmt.execute("CREATE TABLE `FogUser` (\n"
                        + "  `empId` int(12) NOT NULL AUTO_INCREMENT,\n"
                        + "  `empEmail` varchar(36) NOT NULL,\n"
                        + "  `empName` varchar(36) NOT NULL,\n"
                        + "  `password` varchar(36) NOT NULL,\n"
                        + "  `admin` tinyint(1) DEFAULT '1',\n"
                        + "  PRIMARY KEY (`empId`),\n"
                        + "  UNIQUE KEY `empId` (`empId`),\n"
                        + "  UNIQUE KEY `empEmail` (`empEmail`))");

                stmt.execute("insert into FogUser values (1, 'fog@test.dk', "
                        + "'testFog', 'test', 1)");
                stmt.execute("insert into Customer values (1, 'test1',"
                        + " 'testen', 'tested', 'testhavn', 9999, "
                        + "39493929, 'test@test.dk', 'test', 0);");

            }
            um = new UserMapper(con);
        } catch (ClassNotFoundException | SQLException ex)
        {
            con = null;
            System.out.println("connection failed + " + ex.getMessage());
        }

    }

    @Test
    public void testSetUpOK()
    {
        assertNotNull("setup failed", con);
    }

    /**
     * Test of validateCustomer method, of class UserMapper.
     */
    @Test
    public void testValidateCustomerIsThere()
    {
        String email = "test@test.dk";
        String pass = "test";
        String expFirstName = "test1";
        User customer = um.validateCustomer(email, pass);
        assertNotNull("Customer was not expected to be null", customer);
        String actualFirstName = customer.getFirstName();
        assertEquals(expFirstName, actualFirstName);
    }

    /**
     * Test of validateCustomer method, of class UserMapper.
     */
    @Test
    public void testValidateCustomerIsNotThere()
    {
        String email = "tests@test.dk";
        String pass = "test";
        User expResult = null;
        User result = um.validateCustomer(email, pass);
        assertEquals(expResult, result);

    }

    /**
     * Test of validateAdmin method, of class UserMapper.
     */
    @Test
    public void testValidateAdminIsThere()
    {
        String email = "fog@test.dk";
        String pass = "test";
        String expFirstName = "testFog";
        User user = um.validateAdmin(email, pass);
        String result = user.getFirstName();
        assertEquals(expFirstName, result);
    }

    @Test
    public void testValidateAdminIsNotThere()
    {
        String email = "fogds@test.dk";
        String pass = "test";
        User user = um.validateAdmin(email, pass);
        assertNull("user was expected to be null", user);
    }

    /**
     * Test of insertUser method, of class UserMapper.
     *
     */
    @Test
    public void testInsertUser()
    {
        User customer = new Customer(2, "ged@test.dk", "test", "testen",
                "testland", "testby", 9999, 49393939, false);
        String pass = "test";
        String expResult = customer.getFirstName();
        try
        {
            um.insertUser(customer, pass);
        } catch (UserAlreadyExistException ex)
        {
            fail("Did not expect UserAlreadyExistException to be thrown");
        }
        customer = um.validateCustomer("ged@test.dk", "test");
        String result = customer.getFirstName();
        assertEquals(expResult, result);
    }

    /**
     * Test of insert user with email that already exists, of class UserMapper
     *
     */
    @Test
    public void testInsertUserException()
    {
        User customer = new Customer(43, "test@test.dk", "test", 
                "test", "test", "test", 9999, 99999999, false);
        String pass = "test";
        try
        {
            um.insertUser(customer, pass);
            fail("Expected UserAlreadyExistException to be thrown");
        } catch (UserAlreadyExistException ex)
        {
            assertThat(ex.getMessage(), is("user already exists"));
        }
    }

    /**
     * Test of validateCustomer method, of class UserMapper.
     */
    @Test
    public void testValidateCustomer()
    {
        System.out.println("validateCustomer");
        String email = "";
        String pass = "";
        UserMapper instance = null;
        User expResult = null;
        User result = instance.validateCustomer(email, pass);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of validateAdmin method, of class UserMapper.
     */
    @Test
    public void testValidateAdmin()
    {
        System.out.println("validateAdmin");
        String email = "";
        String pass = "";
        UserMapper instance = null;
        User expResult = null;
        User result = instance.validateAdmin(email, pass);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
