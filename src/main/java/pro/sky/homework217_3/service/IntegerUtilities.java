package pro.sky.homework217_3.service;

public class IntegerUtilities {

    //                  Генерация массива псевдослучайных элементов типа Integer
    public static Integer[] generateRandomIntegerArray(int length) {
        java.util.Random random = new java.util.Random();
        Integer[] arr = new Integer[length];
        int bound = 100_000;
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(bound) + 100_000;
        }
        return arr;
    }
}
