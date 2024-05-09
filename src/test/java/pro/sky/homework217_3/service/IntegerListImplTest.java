package pro.sky.homework217_3.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pro.sky.homework217_3.exception.InvalidIndexException;
import pro.sky.homework217_3.exception.NoItemException;
import pro.sky.homework217_3.exception.NullItemException;

import static pro.sky.homework217_3.service.IntegerSort.mergeIntegerSort;
import static pro.sky.homework217_3.service.IntegerSort.quickIntegerSort;
import static pro.sky.homework217_3.service.IntegerUtilities.generateRandomIntegerArray;

public class IntegerListImplTest {

    public final IntegerListImpl integerList = new IntegerListImpl();
    public final IntegerListImpl integerList2 = new IntegerListImpl();
    public final IntegerListImpl integerList3 = new IntegerListImpl();
    public final IntegerListImpl integerList4 = new IntegerListImpl();
    public final IntegerListImpl integerList5 = new IntegerListImpl();

    @Test
    void shouldAddCorrect() {

        //        Тест: добавлен первый элемент (в исходный массив)
        Assertions.assertEquals(1, integerList.add(1));
        //        Тест: добавлен второй элемент (в исходный массив)
        Assertions.assertEquals(1, integerList.add(1));
        //        Тест: добавлен третий элемент (в исходный массив)
        Assertions.assertEquals(1, integerList.add(1));
        //        Тест: добавлен четвертый элемент (в исходный массив)
        Assertions.assertEquals(1, integerList.add(1));
        //        Тест: добавлен пятый элемент (размер массива увеличен)
        Assertions.assertEquals(1, integerList.add(1));

        //        Тест: (null)
        Assertions.assertThrows(NullItemException.class, () -> integerList.add(null));

    }

    @Test
    void shouldAddWithIndexCorrect() {

        //        Подготовка: добавлен первый элемент
        Integer iTest = integerList.add(0);

        //        Тест: повторно добавлен первый элемент (в исходный массив по индексу)
        Assertions.assertEquals(1, integerList.add(0, 1));
        //        Тест: повторно добавлен второй элемент (в исходный массив по индексу)
        Assertions.assertEquals(2, integerList.add(1, 2));
        //        Тест: повторно добавлен третий элемент (в исходный массив по индексу)
        Assertions.assertEquals(3, integerList.add(2, 3));
        //        Тест: повторно добавлен четвертый элемент (в исходный массив по индексу)
        Assertions.assertEquals(4, integerList.add(3, 4));
        //        Тест: повторно добавлен пятый элемент (в массив по индексу, размер массива увеличен)
        Assertions.assertEquals(5, integerList.add(4, 5));

        //        Тест: (превышен размер массива)
        Assertions.assertThrows(InvalidIndexException.class, () -> integerList.add(10, 11));
        //        Тест: (превышен размер занятой части массива)
        Assertions.assertThrows(InvalidIndexException.class, () -> integerList.add(8, 9));

        //        Тест: (null)
        Assertions.assertThrows(NullItemException.class, () -> integerList.add(1, null));

    }

    @Test
    void shouldSetCorrect() {

        //        Подготовка: добавлено несколько элементов
        Integer iTest = integerList.add(0);
        Integer iTest2 = integerList.add(1);
        Integer iTest3 = integerList.add(2);
        Integer iTest4 = integerList.add(3);
        Integer iTest5 = integerList.add(4);

        //        Тест
        Assertions.assertEquals(3, integerList.set(2, 3));

    }

    @Test
    void shouldRemoveCorrect() {

        //        Подготовка: добавлено несколько элементов
        Integer iTest = integerList.add(1);
        Integer iTest2 = integerList.add(2);
        Integer iTest3 = integerList.add(3);
        Integer iTest4 = integerList.add(4);
        Integer iTest5 = integerList.add(5);
        //        Подготовка: элемент для проверки
        Integer iTest3_1 = 3;
        //        Подготовка: такого элемента в массиве нет
        Integer iTest6 = 6;

        //        Тест
        Assertions.assertEquals(3, integerList.remove(iTest3_1));
        //        Тест (на несуществующий элемент)
        Assertions.assertThrows(NoItemException.class, () -> integerList.remove(iTest6));

    }

    @Test
    void shouldRemoveWithIndexCorrect() {

        //        Подготовка: добавлено несколько элементов
        Integer iTest = integerList.add(1);
        Integer iTest2 = integerList.add(2);
        Integer iTest3 = integerList.add(3);
        Integer iTest4 = integerList.add(4);
        Integer iTest5 = integerList.add(5);
        //        Подготовка: элемент для проверки
        Integer iTest3_1 = 3;
        //        Подготовка: такого элемента в массиве нет
        Integer iTest6 = 6;

        //        Тест
        Assertions.assertEquals(3, integerList.remove(2));
        //        Тест (на несуществующий элемент)
        Assertions.assertThrows(InvalidIndexException.class, () -> integerList.remove(6));

    }

    @Test
    void shouldConteinsCorrect() {

//        Подготовка: добавлено несколько элементов
        Integer iTest = integerList.add(1);
        Integer iTest2 = integerList.add(2);
        Integer iTest3 = integerList.add(3);
        Integer iTest4 = integerList.add(4);
        Integer iTest5 = integerList.add(5);

        //        Тест: поиск элемента
        Assertions.assertTrue(integerList.contains(1));
        //        Тест: поиск элемента
        Assertions.assertTrue(integerList.contains(3));
        //        Тест: поиск элемента
        Assertions.assertTrue(integerList.contains(5));

        //        Тест: поиск элемента (элемент не найден)
        Assertions.assertFalse(integerList.contains(7));

    }

    @Test
    void shouldIndexOfCorrect() {

//        Подготовка: добавлено несколько элементов
        Integer iTest = integerList.add(1);
        Integer iTest2 = integerList.add(2);
        Integer iTest3 = integerList.add(3);
        Integer iTest4 = integerList.add(4);
        Integer iTest5 = integerList.add(5);

        //        Тест: поиск элемента
        Assertions.assertEquals(0, integerList.indexOf(1));
        //        Тест: поиск элемента
        Assertions.assertEquals(2, integerList.indexOf(3));
        //        Тест: поиск элемента
        Assertions.assertEquals(4, integerList.indexOf(5));

        //        Тест: поиск элемента (элемент не найден)
        Assertions.assertEquals(-1, integerList.indexOf(0));

    }

    @Test
    void shouldLastIndexOfCorrect() {

//        Подготовка: добавлено несколько элементов
        Integer iTest = integerList.add(1);
        Integer iTest2 = integerList.add(2);
        Integer iTest3 = integerList.add(3);
        Integer iTest4 = integerList.add(4);
        Integer iTest5 = integerList.add(5);

        //        Тест: поиск элемента
        Assertions.assertEquals(0, integerList.lastIndexOf(1));
        //        Тест: поиск элемента
        Assertions.assertEquals(2, integerList.lastIndexOf(3));
        //        Тест: поиск элемента
        Assertions.assertEquals(4, integerList.lastIndexOf(5));

        //        Тест: поиск элемента (элемент не найден)
        Assertions.assertEquals(-1, integerList.lastIndexOf(0));

    }

    @Test
    void shouldGetCorrect() {

//        Подготовка: добавлено несколько элементов
        Integer iTest = integerList.add(1);
        Integer iTest2 = integerList.add(2);
        Integer iTest3 = integerList.add(3);
        Integer iTest4 = integerList.add(4);
        Integer iTest5 = integerList.add(5);

        //        Тест: поиск элемента
        Assertions.assertEquals(1, integerList.get(0));
        //        Тест: поиск элемента
        Assertions.assertEquals(3, integerList.get(2));
        //        Тест: поиск элемента
        Assertions.assertEquals(5, integerList.get(4));

        //        Тест: поиск элемента (элемент не найден)
        Assertions.assertThrows(InvalidIndexException.class, () -> integerList.get(8));

    }

    @Test
    void shouldEqualsCorrect() {

//        Подготовка: добавлено несколько элементов
        Integer i1Test = integerList.add(1);
        Integer i1Test2 = integerList.add(2);
        Integer i1Test3 = integerList.add(3);
        Integer i1Test4 = integerList.add(4);
        Integer i1Test5 = integerList.add(5);

        Integer i2Test = integerList2.add(1);
        Integer i2Test2 = integerList2.add(2);
        Integer i2Test3 = integerList2.add(3);
        Integer i2Test4 = integerList2.add(4);
        Integer i2Test5 = integerList2.add(5);

        Integer i3Test = integerList3.add(1);
        Integer i3Test2 = integerList3.add(2);
        Integer i3Test3 = integerList3.add(3);
        Integer i3Test4 = integerList3.add(4);
        Integer i3Test5 = integerList3.add(5);
        Integer i3Test6 = integerList3.add(6);
        Integer i3Test7 = integerList3.add(7);

        Integer i4Test = integerList4.add(11);
        Integer i4Test2 = integerList4.add(12);
        Integer i4Test3 = integerList4.add(13);
        Integer i4Test4 = integerList4.add(14);
        Integer i4Test5 = integerList4.add(15);

        //        Тест: сравнение массивов
        Assertions.assertTrue(integerList.equals(integerList2));

        //        Тест: сравнение массивов (не совпадают)
        Assertions.assertFalse(integerList.equals(integerList3));
        //        Тест: сравнение массивов (не совпадают)
        Assertions.assertFalse(integerList.equals(integerList4));

        //        Тест: (null)
        Assertions.assertThrows(NullItemException.class, () -> integerList.equals(null));

    }

    @Test
    void shouldSizeCorrect() {

//        Подготовка: добавлено несколько элементов
        Integer i1Test = integerList.add(1);
        Integer i1Test2 = integerList.add(2);
        Integer i1Test3 = integerList.add(3);
        Integer i1Test4 = integerList.add(4);
        Integer i1Test5 = integerList.add(5);

        Integer i2Test = integerList2.add(1);
        Integer i2Test2 = integerList2.add(2);
        Integer i2Test3 = integerList2.add(3);
        Integer i2Test4 = integerList2.add(4);
        Integer i2Test5 = integerList2.add(5);

        Integer i3Test = integerList3.add(1);
        Integer i3Test2 = integerList3.add(2);
        Integer i3Test3 = integerList3.add(3);
        Integer i3Test4 = integerList3.add(4);
        Integer i3Test5 = integerList3.add(5);
        Integer i3Test6 = integerList3.add(6);
        Integer i3Test7 = integerList3.add(7);

        Integer i4Test = integerList4.add(11);
        Integer i4Test2 = integerList4.add(12);
        Integer i4Test3 = integerList4.add(13);
        Integer i4Test4 = integerList4.add(14);
        Integer i4Test5 = integerList4.add(15);
        Integer i4Test6 = integerList4.add(16);

        //        Тест: размер массива
        Assertions.assertEquals(5, integerList.size());
        //        Тест: размер массива
        Assertions.assertEquals(5, integerList2.size());
        //        Тест: размер массива
        Assertions.assertEquals(7, integerList3.size());
        //        Тест: размер массива
        Assertions.assertEquals(6, integerList4.size());

    }

    @Test
    void shouldIsEmptyCorrect() {

//                  Подготовка
        Integer i1Test = integerList.add(1);
        Integer i2Test = integerList.add(2);
        Integer i3Test = integerList.add(3);

        //        Тест: проверка массива
        Assertions.assertFalse(integerList.isEmpty());
        //        Тест: проверка массива (пустой)
        Assertions.assertTrue(integerList5.isEmpty());

    }

    @Test
    void shouldClearCorrect() {

//                  Подготовка
        Integer i1Test = integerList.add(1);
        Integer i2Test = integerList.add(2);
        Integer i3Test = integerList.add(3);

        //        Выполнение
        integerList.clear();

        //        Тест: проверка
        Assertions.assertTrue(integerList.isEmpty());

    }

    @Test
    void shouldToArrayCorrect() {

        //                  Подготовка
        Integer i1Test = integerList.add(1);
        Integer i2Test = integerList.add(2);
        Integer i3Test = integerList.add(3);

        //        Выполнение
        Integer[] newStringArray = integerList.toArray();

        //        Тест: проверка
        Assertions.assertEquals(integerList.get(0), newStringArray[0]);
        Assertions.assertEquals(integerList.get(1), newStringArray[1]);
        Assertions.assertEquals(integerList.get(2), newStringArray[2]);

    }

    @Test
    void shouldQuickIntegerSortCorrect() {

//              Подготовка: генерация массива
        Integer[] intTestArray1 = generateRandomIntegerArray(30);
//              Быстрая сортировка
        quickIntegerSort(intTestArray1, 0, 29);

    }

    @Test
    void shouldMergeIntegerSort() {

//              Подготовка: генерация массива
        Integer[] intTestArray1 = generateRandomIntegerArray(30);
//              Сортировка слиянием
        mergeIntegerSort(intTestArray1);

    }

}
