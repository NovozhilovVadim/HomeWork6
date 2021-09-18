package homework;
//JUnit4
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class Task1JUnit4TestCase {

    private Lesson6 dz;

    @Before // Аннотация указывает, что надо сделать до запуска
    public void prepare() {
        dz = new Lesson6();
    } //создаём объект класса Lesson6

    @Test(expected = RuntimeException.class) //тест считается успешным если пойманно исключение
    public void empty_array() {
        dz.task1(new int[0]);
    } //передаём объекту массив нулевого размера

    @Test(expected = RuntimeException.class)//тест считается успешным если пойманно исключение
    public void without_4() {
        dz.task1(new int[]{1, 2, 3});
    } // передаём массив не содержащий 4

    @Test
    public void where_4_is_not_last() { // передаём массив где 4 не является последним значением массива
        int[] data = {1, 2, 3, 4, 5, 6, 7};
        Assert.assertArrayEquals(new int[]{5, 6, 7}, dz.task1(data)); // проверяем, что результат равен ожидаемому
    }

    @Test
    public void test_task1_with_some_4() { //передаём массив где 4 последнее значение в массиве
        int[] data = {2, 3, 4, 4, 5, 6, 4};
        Assert.assertArrayEquals(new int[]{}, dz.task1(data)); // проверяем, что результат равен ожидаемому
    }

}