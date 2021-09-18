package homework;
//JUnit5
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class Task1JUnit5TestCase {

    private Lesson6 dz;

    @BeforeEach// Аннотация указывает, что надо сделать до запуска
    public void prepare() {
        dz = new Lesson6();//создаём объект класса Lesson6
    }

    @Test
    public void empty_array() { //тест считается успешным если пойманно исключение
        Assertions.assertThrows(RuntimeException.class, () -> { //Сравниваем ожидаемый результат RuntimeException.class
            dz.task1(new int[0]); // и результат полученный в отдельном процессе
            // (в данном случае массив нулевой длинны выбросит исключение RuntimeException("Invalid array")
        });
    }

    @Test
    public void without_4() { //тест считается успешным если пойманно исключение
        Assertions.assertThrows(RuntimeException.class, () -> {//Сравниваем ожидаемый результат RuntimeException.class
            dz.task1(new int[]{1, 2, 3});// и результат полученный в отдельном процессе
            // (в данном случае массив без значения 4 выбросит исключение RuntimeException("Invalid array")
        });
    }

    @Test
    public void where_4_is_not_last() {
        int[] data = {1, 2, 3, 4, 5, 6, 7};
        Assertions.assertArrayEquals(new int[]{5, 6, 7}, dz.task1(data));// проверяем, что результат равен ожидаемому
    }

    @Test
    public void with_some_4() {
        int[] data = {1, 4, 3, 4, 5, 6, 4};
        Assertions.assertArrayEquals(new int[]{}, dz.task1(data));// проверяем, что результат равен ожидаемому
    }

    @ParameterizedTest// аннотация объявляющая параметризированный тест
    @MethodSource("params")//Ставим аннотацию позволяющую ссылаться на метод класса
    public void with_params(int[] data, int[] result) { //создаём метод который принимает значения массива для тестирования
        // и значения массива для проверки результата выполнения
        Assertions.assertArrayEquals(result, dz.task1(data));// проверяем, что результат равен ожидаемому
    }

    private static Stream params() { //ссылающийся на метод with_params
        return Stream.of( // Возвращает поток содержащий значения
                Arguments.of(//значения для выполнения with_params
                        new int[]{1, 2, 3, 4},//значения для data
                        new int[]{}),// значения для result
                Arguments.of(
                        new int[]{1, 4, 3, 4},
                        new int[]{}),
                Arguments.of(
                        new int[]{1, 4, 3, 5},
                        new int[]{3, 5})
        );
    }

}