package pro.sky.homework217_3;

import pro.sky.homework217_3.service.IntegerUtilities;

import java.util.Arrays;

import static pro.sky.homework217_3.service.IntegerSort.mergeIntegerSort;
import static pro.sky.homework217_3.service.IntegerSort.quickIntegerSort;

public class Main {
    public static void main(String[] args) {
        //                                              Домашнее задание 2-17. Основы алгоритмов. Часть 3
        System.out.println("Домашнее задание 2-17. Основы алгоритмов. Часть 3");
        System.out.println();

        //      Проверка работоспособности и сравнение времени выполнения сортировки массива элементов типа Integer:
        //      1) быстрой сортировки
        //      2) сортировки слиянием
        int intArrayLength = 100000;

        Integer[] intTestArray1 = IntegerUtilities.generateRandomIntegerArray(intArrayLength);
        Integer[] intTestArray2 = Arrays.copyOf(intTestArray1, intTestArray1.length);

        System.out.println("Проверка работоспособности и времени выполнения сортировки массива элементов типа Integer");
        System.out.println("размером " + intArrayLength + " элементов:");
        System.out.println();

        //      Быстрая сортировка
//        System.out.println("Исходный массив:");
//        System.out.println(Arrays.toString(intTestArray1));
        System.out.println("Быстрая сортировка: время выполнения (мс):");
        long start1 = System.currentTimeMillis();
        quickIntegerSort(intTestArray1, 0, intArrayLength - 1);
        System.out.println(System.currentTimeMillis() - start1);
//        System.out.println("Итоговый массив:");
//        System.out.println(Arrays.toString(intTestArray1));
        System.out.println();

        //      Сортировка слиянием
//        System.out.println("Исходный массив:");
//        System.out.println(Arrays.toString(intTestArray2));
        System.out.println("Сортировка слиянием: время выполнения (мс):");
        long start2 = System.currentTimeMillis();
        mergeIntegerSort(intTestArray2);
        System.out.println(System.currentTimeMillis() - start2);
//        System.out.println("Итоговый массив:");
//        System.out.println(Arrays.toString(intTestArray2));

    }
}