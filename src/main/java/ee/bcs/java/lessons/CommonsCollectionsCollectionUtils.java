//package ee.bcs.java.lessons;
//
////import org.apache.commons.collections4.CollectionUtils;
//
//import java.util.Arrays;
//import java.util.LinkedList;
//import java.util.List;
//
//public class CommonsCollectionsCollectionUtils {
//
//    public static void main(String[] args) {
//
//        Customer customer1 = new Customer(1, "Daniel");
//        Customer customer2 = new Customer(2, "Fredrik");
//        Customer customer3 = new Customer(3, "Kyle");
//        Customer customer4 = new Customer(4, "Bob");
//        Customer customer5 = new Customer(5, "Cat");
//        Customer customer6 = new Customer(6, "John");
//
//        System.out.println(customer1); //1 Daniel, toString is overridden
//
//        List<Customer> list1 = Arrays.asList(customer1, customer2, customer3);
//        List<Customer> list2 = Arrays.asList(customer4, customer5, customer6);
//        List<Customer> list3 = Arrays.asList(customer1, customer2);
//
//        List<Customer> linkedList1 = new LinkedList<>(list1);
//        System.out.println(linkedList1);
//
//        //добавление только ненулевых элементов
//        System.out.println("list1: " + list1); //[1 Daniel, 2 Fredrik, 3 Kyle]
//        CollectionUtils.addIgnoreNull(list1, customer4);
//        System.out.println("list1: " + list1); //[1 Daniel, 2 Fredrik, 3 Kyle]
//    }
//
//}
//
//class Customer {
//    private int id;
//    private String name;
//
//    Customer(Integer id, String name) {
//        this.id = id;
//        this.name = name;
//    }
//
//    public Integer getId() {
//        return id;
//    }
//
//    public void setId(Integer id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    @Override
//    public String toString() {
//        return this.getId() + " " + this.getName();
//    }
//
//}
