package ee.bcs.java.lessons;

public class Customer {
    private int id;
    private String name;
    private Address address;

    Customer(Integer id, String name, Address address) {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return id + " " + name;
    }


}
