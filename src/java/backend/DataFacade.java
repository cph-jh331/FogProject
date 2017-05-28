package backend;

import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
import logic.Part;
import logic.SvgDrawing;
import logic.User;

/**
 * DataFacade is a facade for the Mapper classes. It it used to update the
 * tables in the database.
 *
 * @author Lasse Andersen, Marco Frydshou, John Hansen, Per Andersen
 */
public class DataFacade {

    /**
     * PartMapper partMap attribute used for assigning a PartMapper.
     */
    private PartMapper partMap;
    /**
     * UserMapper userMap attribute used for assigning a UserMapper.
     */
    private UserMapper userMap;
    /**
     * SvgMapper svgMap attribute used for assigning a SvgMapper.
     */
    private SvgMapper svgMap;
    /**
     * DBConnector dbc attribute used for assigning a DBConnector.
     */
    private DBConnector dbc;
    /**
     * Connection conn used for setting a SQL Connection.
     */
    private Connection conn;

    /**
     * Constructor that instantiates the Mappers classes and sets the Connection
     * to the one of the parameter conn.
     *
     * @param conn requires a Connection.
     */
    public DataFacade(Connection conn)
    {
        this.conn = conn;
        this.partMap = new PartMapper(conn);
        this.userMap = new UserMapper(conn);
        this.svgMap = new SvgMapper(conn);
    }

    /**
     * Constructor that instantiates the Mapper classes, DBConnector class and
     * sets the predefined connection from the DBConnector class.
     */
    public DataFacade()
    {
        this.dbc = new DBConnector();
        this.conn = dbc.connectDB();
        this.partMap = new PartMapper(conn);
        this.userMap = new UserMapper(conn);
        this.svgMap = new SvgMapper(conn);
    }

    /**
     * Updates the status of a row in the SvgTable based on the svgId and the
     * Status.
     *
     * @param svgId int value of the svgId.
     * @param status Enum Status to set. Expected values are CREATED,
     * REQAPPROVED, APPROVED and DONE.
     */
    public void changeStatusOnSvg(int svgId, SvgDrawing.Status status)
    {
        svgMap.changeStatusOnSvg(svgId, status);
    }

    /**
     * Returns a SvgDrawing object with the specified svgId. SvgDrawing CAN BE
     * NULL.
     *
     * @param svgId int value of the svgId.
     * @return SvgDrawing object. SvgDrawing Object will be null, if the svgId
     * does not exists in the Svg table in the MySQL database.
     */
    public SvgDrawing getSvgDrawingWithSvgId(int svgId)
    {
        return svgMap.getSvgDrawingWithSvgId(svgId);
    }

    /**
     * Returns a List with SvgDrawing objects based on the int parameter
     * customerId. The List can be empty.
     *
     * @param customerId int for the customer you want to get a List of
     * SvgDrawings from.
     * @return List with SvgDrawing objects from a specific customer. The List
     * will return empty if the customerId does not exist in the Svg table.
     */
    public List<SvgDrawing> getAllSvgsWithCustomer(int customerId)
    {
        return svgMap.getAllSvgsWithCustomer(customerId);
    }

    /**
     * Returns a List with SvgDrawing objects based on the customerId and
     * svgStatus. List can be empty.
     *
     * @param svgStatus Enum SvgDrawing.Status to set. Expected values are
     * CREATED, REQAPPROVED, APPROVED and DONE.
     * @param customerId int value of customerId.
     * @return List with SvgDrawing objects. The List will return empty if the
     * customer does not exist in the Svg table or if the status does not exist
     * with specific customerId.
     */
    public List<SvgDrawing> getCustomerSvgWithStatus(SvgDrawing.Status svgStatus, int customerId)
    {
        return svgMap.getCustomerSvgWithStatus(svgStatus, customerId);
    }

    /**
     * Returns a List with SvgDrawing objects based on the SvgDrawing.Status
     * parameter. The List can be empty.
     *
     * @param status Enum SvgDrawing.Status to set. Expected values are CREATED,
     * REQAPPROVED, APPROVED and DONE.
     * @return A List of SvgDrawing objects with a specific Status. The List
     * will be empty if the specified Status does not exist in the Svg table.
     */
    public List<SvgDrawing> getAllSvgWithStatus(SvgDrawing.Status status)
    {
        return svgMap.getAllSvgWithStatus(status);
    }

    /**
     * Returns a List with Part Objects based on the String parameter
     * typeCategory. The List can be empty.
     *
     * @param typeCategory String value of the typeCategory to set.
     * @return A List with Part objects. The List can return empty if the
     * specific typeCategory does not exist.
     */
    public List<Part> getTypeCategory(String typeCategory)
    {
        return partMap.getTypeCategory(typeCategory);
    }

    /**
     * Returns a HashMap with Part objects with the category of 'Træ' with
     * integer keys of the partId and the values of a Part Object. HashMap can
     * return empty.
     *
     * @return HashMap with Parts as value and integer keys based on the partId.
     * The HashMap will return empty if no rows contains the category of 'Træ'.
     */
    public HashMap<Integer, Part> getWoodMap()
    {
        return partMap.getWoodParts();
    }

    /**
     * Returns a HashMap with Part objects with the category of 'tag' with
     * integer keys of the partId and the values of a Part Object. HashMap can
     * return empty.
     *
     * @return HashMap with Parts as value and integer keys based on the partId.
     * The HashMap will return empty if no rows contains the category of 'tag'.
     */
    public HashMap<Integer, Part> getRoofMap()
    {
        return partMap.getRoofParts();
    }

    /**
     * Returns a HashMap with Part objects with the category of 'løsdele' with
     * integer keys of the partId and the values of a Part Object. HashMap can
     * return empty.
     *
     * @return HashMap with Parts as value and integer keys based on the partId.
     * The HashMap will return empty if no rows contains the category of
     * 'løsdele'.
     */
    public HashMap<Integer, Part> getMiscMap()
    {
        return partMap.getMiscParts();
    }

    /**
     * Returns a User object based on the two String parameters email and pass.
     * User object can be null. Should be used when validating a customer.
     *
     * @param email String value of the email.
     * @param password String value of the password.
     * @return User object. Will return NULL if the email or password are not
     * equal to the ones in the Customer table.
     */
    public User validateCustomer(String email, String password)
    {
        return userMap.validateCustomer(email, password);
    }

    /**
     * Returns a User object based on the two String parameters email and pass.
     * User object can be null. Should be used when validating a FogUser/admin.
     *
     * @param email String value of the email.
     * @param password String value of the password.
     * @return User object. Will return NULL if the email or password are not
     * equal to the ones in the FogUser table.
     */
    public User validateAdmin(String email, String password)
    {
        return userMap.validateAdmin(email, password);
    }

    /**
     * Inserts a User object's data into Customer table in the MySQL database.
     * Throws an UserAlreadyExistException if email is already in the database.
     *
     * @param customer User object to be inserted into the Customer table.
     * @param password String value for password to be inserted into the
     * Customer table.
     * @throws UserAlreadyExistException if the email is already in the Customer
     * table in the MySQL database.
     */
    public void insertUser(User customer, String password) throws UserAlreadyExistException
    {
        userMap.insertUser(customer, password);
    }

    /**
     * Adds a row with the data of the Part object designated by the parameter
     * part in the Part table.
     *
     * @param part Part object to be added to the Part table.
     */
    public void addPart(Part part)
    {
        partMap.addPart(part);
    }

    /**
     * Removes the row designated by the int parameter PartId in the Part table.
     *
     * @param partId int value of the partId to be removed from the Part table.
     */
    public void removePart(int partId)
    {
        partMap.removePart(partId);
    }

    /**
     * Inserts a row in the Svg table based on the String SvgInline and a
     * CustomerId.
     *
     * @param SvgInLine String value with Svg in html.
     * @param customerId int value of the customerId.
     */
    public void insertSvg(String SvgInLine, int customerId)
    {
        svgMap.saveDrawing(SvgInLine, customerId);
    }

    /**
     * Remove an row in the Svg table based ont the int customerId and the
     * String removeImage.
     *
     * @param removeimage String with Svg in html.
     * @param customerid int of a customer id.
     */
    public void removeDrawing(String removeimage, int customerid)
    {
        svgMap.removeDrawing(removeimage, customerid);

    }

    /**
     * Remove a row from Svg table in the MySQL database based on the svgId.
     * Returns true if the it succeded.
     *
     * @param svgId int value for the SvgDrawing's id you want to remove.
     * @return True if the svgId existed.
     */
    public boolean removeSvgDrawing(int svgId)
    {
        return svgMap.removeSvgDrawing(svgId);
    }

    /**
     * Returns a List with SvgDrawing objects based on the int parameter
     * customerId. The List can be empty.
     *
     * @param customerId int value of the customerId you want to get a List of
     * SvgDrawings from.
     * @return List with SvgDrawing objects from a specific customer. List will
     * return empty, if no rows contains the specified customerId.
     */
    public List<SvgDrawing> getDrawings(int customerId)
    {
        return svgMap.getCustomerSvgs(customerId);

    }

}
