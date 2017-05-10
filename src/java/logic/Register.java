package logic;

public class Register {

    private String firstname, lastname, adress, zip, city, phone, email, password1;

    public Register() {

        firstname = "";
        lastname = "";
        adress = "";
        zip = "";
        city = "";
        phone = "";
        email = "";
        password1 = "";
    }

    

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String fname) {
        this.firstname = fname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lname) {
        this.lastname = lname;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword1() {
        return password1;
    }

    public void setPassword1(String p1) {
        this.password1 = p1;
    }



}
