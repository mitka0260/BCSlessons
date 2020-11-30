package proselyte;

import org.junit.*;

/*
Аннотации представляют собой, своего рода, теги, которые мы добавляем в код и применяем их к классам и методам. По назначению мы можем их разделить на следующие группы:

игнорируют методы и классы
запускаются перед и после всех методов
запускаются до и после всех тестовых методов

1	@Test   Указывает, что данный метод (public void) может быть запущен, как тестовый случай.
2	@Before Методы с данной аннотацией запускаются перед каждым тестом.
3	@After  Методы с данной аннотацией запускаются после каждого теста.
4	@BeforeClass    Запускается один раз перед запуском любого тестового метода в классе (метод должен быть статическим).
5	@AfterClass Запускается один раз после запуска любого тестового метода в классе (метод должен быть статическим).
6	@Ignore Тестовые методы с данной аннотацией не будут выполнены.
 */

public class AnnotationTests {


    @BeforeClass
    public static void beforeClass() {
        System.out.println("This method has been executed first...");
    }

    @AfterClass
    public static void afterClass() {
        System.out.println("This method has been executed last...");
    }

    @Before
    public void before() {
        System.out.println("Before each test");
    }

    @After
    public void after() {
        System.out.println("After each test");
    }

    @Test
    public void simpleTest() {
        System.out.println("Simple test");
    }

    @Ignore
    public void ignoreTest() {
        System.out.println("This test will be ignored");
    }

}