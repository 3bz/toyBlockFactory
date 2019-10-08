public class Customer {
    private String name;
    private String address;

    public Customer(String aName, String aAddress) {
        name = aName;
        address = aAddress;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }
}