package pro.sky.homework217_3.service;

public class IntegerSort {

    //      Быстрая сортировка массивов типа Integer
    public static void quickIntegerSort(Integer[] arr, int begin, int end) {
        if (begin < end) {
            int partitionIndex = partition(arr, begin, end);

            quickIntegerSort(arr, begin, partitionIndex - 1);
            quickIntegerSort(arr, partitionIndex + 1, end);
        }
    }

    private static int partition(Integer[] arr, int begin, int end) {
        int pivot = arr[end];
        int i = (begin - 1);

        for (int j = begin; j < end; j++) {
            if (arr[j] <= pivot) {
                i++;

                swapIntegerElements(arr, i, j);
            }
        }

        swapIntegerElements(arr, i + 1, end);
        return i + 1;
    }

    //                  Перестановка элементов массива
    public static void swapIntegerElements(Integer[] arr, int indexA, int indexB) {
        Integer tmp = arr[indexA];
        arr[indexA] = arr[indexB];
        arr[indexB] = tmp;
    }

    //      Сортировка слиянием массивов типа Integer
    public static void mergeIntegerSort(Integer[] arr) {
        if (arr.length < 2) {
            return;
        }
        int mid = arr.length / 2;
        Integer[] left = new Integer[mid];
        Integer[] right = new Integer[arr.length - mid];

        for (int i = 0; i < left.length; i++) {
            left[i] = arr[i];
        }

        for (int i = 0; i < right.length; i++) {
            right[i] = arr[mid + i];
        }

        mergeIntegerSort(left);
        mergeIntegerSort(right);

        mergeInteger(arr, left, right);
    }

    public static void mergeInteger(Integer[] arr, Integer[] left, Integer[] right) {

        int mainP = 0;
        int leftP = 0;
        int rightP = 0;
        while (leftP < left.length && rightP < right.length) {
            if (left[leftP] <= right[rightP]) {
                arr[mainP++] = left[leftP++];
            } else {
                arr[mainP++] = right[rightP++];
            }
        }
        while (leftP < left.length) {
            arr[mainP++] = left[leftP++];
        }
        while (rightP < right.length) {
            arr[mainP++] = right[rightP++];
        }
    }

}
