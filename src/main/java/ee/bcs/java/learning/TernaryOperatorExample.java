package ee.bcs.java.learning;

public class TernaryOperatorExample {

    public static void main(String[] args) {
        int a = 20;

        if (a < 100) {
            System.out.println("a < 100");
        } else {
            System.out.println("a > 100");
        }

        String answer = (a<100) ? "a < 100" : "a > 100";
        //                           if true    if false
        System.out.println(answer);
    }
}
