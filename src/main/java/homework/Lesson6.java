package homework;
// 1.Написать метод, которому в качестве аргумента передается не пустой одномерный целочисленный массив.
// Метод должен вернуть новый массив, который получен путем вытаскивания из исходного массива элементов,
// идущих после последней четверки. Входной массив должен содержать хотя бы одну четверку, иначе в методе необходимо выбросить RuntimeException.
// Написать набор тестов для этого метода (по 3-4 варианта входных данных).
// Вх: [ 1 2 4 4 2 3 4 1 7 ] -> вых: [ 1 7 ].

// 1.Написать метод, который проверяет состав массива из чисел 1 и 4. Если в нем нет хоть одной четверки или единицы, то метод вернет false;
// Написать набор тестов для этого метода (по 3-4 варианта входных данных).
// [ 1 1 1 4 4 1 4 4 ] -> true
// [ 1 1 1 1 1 1 ] -> false
// [ 4 4 4 4 ] -> false
// [ 1 4 4 1 1 4 3 ] -> false


import java.util.Arrays;

public class Lesson6 {

    public int[] task1(int[] data) { // Создаём метод получающий в качестве аргумента массив
        for (int i = data.length - 1; i >= 0; i--) { //Проходим циклом по массиву
            // i = (длинна массива -1) - начинаем с последнего индекса массива, остаёмся в цикле пока i больше или равно 0 или не будет выполнено
            // нижеследующее условие, при каждом проходе дикрементируем i

            if (data[i] == 4) { // есле значение по индексу i равно 4, то
                return Arrays.copyOfRange(data, i + 1, data.length); // возвращаем массив скопированный из исходного с индекса i+1 (после 4)
                //до конца массива
            }
        }
        throw new RuntimeException("Invalid array");// Есле не сработало условие (data[i] == 4), то выбрасываем ошибку "Invalid array"
    }

    public boolean task2(int[] data) { // Получаем на вход массив
        boolean contains1 = false; // создаём логическую переменную для 1
        boolean contains4 = false; // создаём логическую переменную для 4

        for (int value : data) { // пробегаем по массиву циклом
            switch (value) { //сравниваем значение каждого элемента массива
                case 1:  // с 1
                    contains1 = true; //переменную устанавливаем в true
                    break; //конец проверки
                case 4: // с 4
                    contains4 = true; //переменную устанавливаем в true
                    break;//конец проверки
                default: // усли не сработало ни одно условие
                    return false; //возвращем false
            }
        }
        return contains1 && contains4; // возвращем значение условного И (&& - true&true=true, false&true=false, false&false=false)
    }


}