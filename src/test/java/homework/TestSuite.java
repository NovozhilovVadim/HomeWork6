package homework;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

    @RunWith(Suite.class) // Аннотация указывает, что надо использовать средства класса Suite


    @Suite.SuiteClasses({ // Определяем какие именно тесты следует запустить.
            Task1JUnit4TestCase.class, // тест проверки задания 1 с исползованием JUnit 4

            Task2TestCase.class, //тест проверки задания 2
    })
    public class TestSuite {
    }

