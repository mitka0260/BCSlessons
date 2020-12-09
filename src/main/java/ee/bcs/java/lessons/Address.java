package ee.bcs.java.lessons;

public class Address {
    private String locality;
    private String city;

    Address(String locality, String city) {
        this.locality = locality;
        this.city = city;
    }

    public String getLocality() {
        return locality;
    }

    public void setLocality(String locality) {
        this.locality = locality;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String toString() {
        return locality + " " + city;
    }

}