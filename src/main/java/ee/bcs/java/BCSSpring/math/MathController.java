package ee.bcs.java.BCSSpring.math;

import ee.bcs.java.lessons.Lesson1;
import ee.bcs.java.lessons.Lesson3;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MathController {

    //аннотация, работает сервер спринга, запускает мой код, ищет весь мой код
    //контроллер - это важный для нас класс, и это спринг знает
    /*
    @GetMapping(value = "")
    public String helloSpring() {
        return "Hello, Spring!";
    }

*/
    /*
    @GetMapping("")
    public String helloSpringPage(
            @RequestParam("name") String name) {
        if (name==null || name=="")
            return "Hello, Spring";
        else
            return "Hello, " + name;
    }
*/

/*    @GetMapping(value = "")
    public String helloSpring(@RequestParam(value = "name", defaultValue = "Spring") String name) {
        return "Hello, " + name;
        //return String.format("Hello %s!", name);
    }
*/
    @GetMapping("testing/min")
    public int testing(@RequestParam("a") int a,
                            @RequestParam("b") int b) {
        return Lesson1.min(a, b);
    }

    @GetMapping("math/abs/{n}")
    public String absValuePath(
            @PathVariable("n") Integer n) {
        return "Your number's absolute value is " + Lesson1.abs(n);
    }
    //http://localhost:8080/math/abs/-10

    @GetMapping("math/isEven/{n}")
    public String isNumberEvenPath(
            @PathVariable("n") Integer n) {
        return "Your number is even - " + Lesson1.isNumberEven(n);
    }
    //http://localhost:8080/math/isEven/5

    @GetMapping("math/isEven")
    public String isNumberEvenReq(
            @RequestParam("number") int a) {
        return "Your number is even - " + Lesson1.isNumberEven(a);
    }
    //http://localhost:8080/math/isEven?number=4

    @GetMapping("math/max/{a}/{b}")
    public String maxValuePath(
            @PathVariable("a") Integer a,
            @PathVariable("b") Integer b) {
        return "Max value = " + Lesson1.max(a, b);
        //return "Max value = " + max(a, b);
    }
    //http://localhost:8080/math/max/3/7

    //можно и здесь написать код метода
    private int max(int a, int b) {
        if (a > b)
            return a;
        else
            return b;
    }

    @GetMapping("math/max")
    public String maxValueReq(
            @RequestParam("aKey") int a,
            @RequestParam("bKey") int b,
            @RequestParam("cKey") int c) {
        return "Max value is " + Lesson1.max(a, b, c);
    }
    //http://localhost:8080/math/max?aKey=3&bKey=4&cKey=10

    @GetMapping("math/min/{a}/{b}")
    public String minValuePath(
            @PathVariable("a") int a,
            @PathVariable("b") int b) {
        return "Min value is " + Lesson1.min(a, b);
    }
    //http://localhost:8080/math/min/7/2

    @GetMapping("math/min")
    public String minValueReq(
            @RequestParam("aKey") int a,
            @RequestParam("bKey") int b) {
        return "Min value is " + Lesson1.min(a, b);
    }
    //http://localhost:8080/math/min?aKey=3&bKey=10

    @GetMapping("math/Fibonacci/{n}")
    public String fibonacciNrPath(
            @PathVariable("n") int n) {
        return "Fibonacci " + n + "th number is " + Lesson3.fibonacci1(n);
    }
    //http://localhost:8080/math/Fibonacci/7

    @GetMapping("math/Fibonacci")
    public String fibonacciNrReq(
            @RequestParam("n") int n) {
        return "Fibonacci " + n + "th number is " + Lesson3.fibonacci1(n);
    }
    //http://localhost:8080/math/Fibonacci?n=7

    @GetMapping("math/closestToNr/{a}/{b}/{c}/{d}/{e}/{f}/{g}")
    public String closestToNrPath(
            @PathVariable("a") Integer a,
            @PathVariable("b") Integer b,
            @PathVariable("c") Integer c,
            @PathVariable("d") Integer d,
            @PathVariable("e") Integer e,
            @PathVariable("f") Integer f,
            @PathVariable("g") Integer g) {
        int[] array = {b, c, d, e, f, g};
        return "Closest to " + a + " is number " + Lesson1.closestTo2(a, array);
    }
    //http://localhost:8080/math/closestToNr/1/2/3/4/5/6/7

    @GetMapping("math/ClosestToNr")
    public String closestToNrReq(
            @RequestParam("aKey") int a,
            @RequestParam("bKey") int b,
            @RequestParam("cKey") int c,
            @RequestParam("dKey") int d,
            @RequestParam("eKey") int e,
            @RequestParam("fKey") int f,
            @RequestParam("gKey") int g) {
        int[] array = {b, c, d, e, f, g};
        return "Closest to " + a + " is " + Lesson1.closestTo2(a, array);
    }
    //http://localhost:8080/math/ClosestToNr?aKey=1&bKey=2&cKey=3&dKey=4&eKey=5&fKey=6&gKey=7


    int value = 0;

    @GetMapping("math/gameWithValues/add")
    public int addGameWithValues(
            @RequestParam("x") int x) {
        value += x;
        return value;
    }
    //http://localhost:8080/math/gameWithValues/add?x=5

    @GetMapping("math/gameWithValues/multiply")
    public int multiplyGameWithValues(
            @RequestParam("x") int x) {
        value *= x;
        return value;
    }
    //http://localhost:8080/math/gameWithValues/multiply?x=5

    @GetMapping("math/gameWithValues/subtract")
    public int subtractGameWithValues(
            @RequestParam("x") int x) {
        value -= x;
        return value;
    }
    //http://localhost:8080/math/gameWithValues/subtract?x=4
}
