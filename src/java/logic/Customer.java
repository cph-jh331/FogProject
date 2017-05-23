package logic;

public class Customer extends User {

    public Customer(int customerId, String email, String firstName, String lastName, String address, String city, int zip, int phone, boolean isAdmin)
    {
        super(customerId, email, firstName, lastName, address, city, zip, phone, isAdmin);
    }
}
