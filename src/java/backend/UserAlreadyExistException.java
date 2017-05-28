package backend;

/**
 * UserAlreadyExistsException is used in the UserMapper class to be thrown if
 * the user's email already exists in the database.
 *
 * @author Lasse Andersen, Marco Frydshou, John Hansen, Per Andersen
 */
public class UserAlreadyExistException extends Exception {

    /**
     * An exception for when the user's email already exists in the database.
     *
     * @param str String, the message to set for the exception.
     */
    public UserAlreadyExistException(String str)
    {
        super(str);
    }

}
