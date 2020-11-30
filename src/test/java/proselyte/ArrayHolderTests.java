package proselyte;

import org.junit.jupiter.api.Test;
import proselyte.ArrayHolder;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ArrayHolderTests {

    ArrayHolder arrayHolder = new ArrayHolder();

    @Test
    public void shouldCreateDefaultArrayTest() {
        assertEquals(arrayHolder.toString(), "[1, 2, 3, 4, 5]");
    }
}

/*
Фреймворк JUnit состоит из следующих ключевых групп:
Fixtures (каркас)
Это фиксированное состояние множества (набора) объектов, которые служат базисом для выполнения тестов.
Их цель – гарантировать, что существует хорошо известное и фиксированное окружение в котором тесты выполняются
таким образом, что результаты повторяемы. Он включает в себя следующие методы:
setUp() Выполняется перед каждым запуском тестов + tearDown() Выполняется после каждого тестового метода

Test Suites (группа тестов)
Это группа, состоящая из нескольких тестов, которые запускаются вместе.
Для запуска групповых тестов используются аннотации @RunWith и @Suite.
1	void addTest(Test test) Добавляет тест в suite.
2	void addTestSuite(Class<? extends TestCase> testClass) Добавляет тесты из указанного тестового класса.
3	int countTestCases() Возвращает количество тестовых случаев, которые будут запущены в данном тесте.
4	String getName() Возвращает имя suite.
5	void run(TestResult result) Запускает тесты и записывает их результаты в TestResult.
6	void setName(String name) Указывает имя suite.
7	Test testAt(int index) Возвращает тест с указанным индексом
8	int testCount() Возвращает количество тестов в данном сьюте.
9	static Test warning(String message) Возвращает тест, который не пройдёт и выводит сообщение



Test runners (сущности, которые выполняют тесты)

Классы JUnit
используются для написания тестов и их выполнения
Assert Содержит множество методов утверждений. Записываются только те утверждения, которые оказываются ложными (false)
1	void assertEquals(boolean expected, boolean actual) Проверяет, равенство значений двух примитивных типов данных.
2	void assertFalse(boolean condition) Проверяет, является ли утверждение ложным.
3	void assertNotNull(Object object) Проверяет, что объект нe является null
4	void assertNull(Object object) Проверяет, что данный объект является типом null
5	void assertTrue(boolean condition) Проверяет, что указанное выражение является истинным (true)
6	void fail() Проваливает тест без вывода сообщений
7   void assertSame(boolean condition) Проверяет, ссылаются ли ссылки двух объектов на один и тот же объект
8 void assertNotSame(boolean condition) Проверяет, не ссылаются ли ссылки двух объектов на один и тот же объект

TestCase Содержит тестовые случаи, который определяют каркас для выполнения нескольких тестов.
определяет ряд каркас (fixture) для выполнения нескольких тестов
1	int countTestCases() Возвращает количество выполнняемых тестовых случаев (test cases).
2	TestResult createResult() Создаёт экземпялр класса TestResult по умолчанию.
3	String getName() Вовращает имя тестового случая
4	TestResult run() Выполняет тест, собирая результаты с помощью стандартного объекта TestResult.
5	void run(TestResult result) Выполняет тестовый случай и собирает результаты в экземпляре TestResult
6	void setName(String name) Задаёт имя тестовому случаю
7	void setUp() Устанавливает каркас (fixture), например, открывает сетевое соединение
8	void tearDown() Уничтожает каркас (fixture), например, закрывает сетевое соединение


TestResult Содержит методы для хранения данных, полученных в результате выполнения тестовых случаев.
Он отличает failures (сбои) и errors (ошибки).  Сбои ожидаются и проверяются с помощью утверждений.
Ошибки же, в свою очередь, не ожидаются (например OutOfMemoryError).
1	void addError(Test test, Throwable t) Добавляет ошибку в список ошибок
2	void addFailure(Test test, AssertionFailedError t) Добавялет сбой в список сбоев.
3	void endTest(Test test) Выводит результаты завершённых тестов.
4	int errorCount() Возвращает количество обнаруженных ошибок.
5	Enumeration<TestFailure> errors() Возвращает перечисление для ошибок.
6	int failureCount() Возвращает количество обнаруженных сбоев.
7	void run(TestCase test) Запускает TestCase.
8	int runCount() Возвращает количество запущенных тестов.
9	void startTest(Test test) Выводит результат теста, который передаётся в параметре.
10	void stop() Останавливает запущенный тест.

 */
