package ee.bcs.java.lessons;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class CommonsCollectionsCollectionUtils {

    public static void main(String[] args) {

        Address address1 = new Address("locality1", "city1");
        Address address2 = new Address("locality2", "city2");
        Address address3 = new Address("locality3", "city3");
        Address address4 = new Address("locality4", "city4");
        Address address5 = new Address("locality5", "city5");
        Address address6 = new Address("locality6", "city6");

        Customer customer1 = new Customer(1, "Daniel", address1);
        Customer customer2 = new Customer(2, "Fredrik", address2);
        Customer customer3 = new Customer(3, "Kyle", address3);
        Customer customer4 = new Customer(4, "Bob", address4);
        Customer customer5 = new Customer(5, "Cat", address5);
        Customer customer6 = new Customer(6, "John", address6);

        List<Customer> list1 = Arrays.asList(customer1, customer2, customer3);
        List<Customer> list2 = Arrays.asList(customer4, customer5, customer6);
        List<Customer> list3 = Arrays.asList(customer1, customer2);

        List<Customer> linkedList1 = new LinkedList<>(list1);
    }

}
