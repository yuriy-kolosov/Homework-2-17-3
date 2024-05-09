package pro.sky.homework217_3.service;

import pro.sky.homework217_3.exception.InvalidIndexException;
import pro.sky.homework217_3.exception.NoItemException;
import pro.sky.homework217_3.exception.NullItemException;

import java.util.Arrays;
import java.util.Objects;

public class IntegerListImpl implements IntegerList {

    private Integer[] integerList;
    //                                Количество занятых (не null) элементов в массиве:
    private int integerListSize;

    public IntegerListImpl() {
        this.integerList = new Integer[4];
        this.integerListSize = 0;
    }

    @Override
    public Integer add(Integer item) {
        validateItem(item);
        if (integerListSize == integerList.length) {
            grow();
        }
        integerList[integerListSize++] = item;
        return item;
    }

    @Override
    public Integer add(int index, Integer item) {
        validateIndex(index);
        validateItem(item);
        if (integerListSize == integerList.length) {
            grow();
        }
        integerList[index] = item;
        integerListSize++;
        return item;
    }

    @Override
    public void grow() {
        integerList = Arrays.copyOf(integerList, integerListSize + integerListSize / 2);
    }

    @Override
    public Integer set(int index, Integer item) {
        validateIndex(index);
        validateItem(item);
        integerList[index] = item;
        return item;
    }

    @Override
    public Integer remove(Integer item) {
        validateItem(item);
        for (int i = 0; i < integerListSize; i++) {
            if (integerList[i].equals(item)) {
                int j = (integerListSize--) - i - 1;
                if (j != 0) {
                    System.arraycopy(integerList, i + 1, integerList, i, j);
                }
                return item;
            }
        }
        throw new NoItemException("Искомый элемент отсутствует");
    }

    @Override
    public Integer remove(int index) {
        validateIndex(index);
        Integer item = integerList[index];
        int j = (integerListSize--) - index - 1;
        if (j != 0) {
            System.arraycopy(integerList, index + 1, integerList, index, j);
        }
        return item;
    }

    @Override
    public boolean contains(Integer item) {
        validateItem(item);
        return Arrays.asList(integerList).contains(item);
    }

//    @Override
//    public boolean containsWithBinarySearch(Integer item) {
//        validateItem(item);
//        sortIntegerInsertion(integerList, integerListSize);
//        return binaryIntegerSearch(integerList, integerListSize, item);
//    }

    @Override
    public int indexOf(Integer item) {
        validateItem(item);
        int index = -1;
        for (int i = 0; i < integerListSize; i++) {
            if (integerList[i].equals(item)) {
                index = i;
                break;
            }
        }
        return index;
    }

    @Override
    public int lastIndexOf(Integer item) {
        validateItem(item);
        int index = -1;
        for (int i = integerListSize - 1; i >= 0; i--) {
            if (integerList[i].equals(item)) {
                index = i;
                break;
            }
        }
        return index;
    }

    @Override
    public Integer get(int index) {
        validateIndex(index);
        return integerList[index];
    }

    @Override
    public boolean equals(IntegerList otherList) {
        if (otherList == null) {
            throw new NullItemException("Неверный массив: null");
        }
        return Arrays.equals(this.toArray(), otherList.toArray());
    }

    @Override
    public int size() {
        return integerListSize;
    }

    @Override
    public boolean isEmpty() {
        return integerListSize == 0;
    }

    @Override
    public void clear() {
        integerListSize = 0;
    }

    @Override
    public Integer[] toArray() {
        return Arrays.copyOf(integerList, integerListSize);
    }

    @Override
    public void validateIndex(int index) {
        if (index < 0 || index > integerListSize) {
            throw new InvalidIndexException("Неверный индекс");
        }
    }

    @Override
    public void validateItem(Integer item) {
        if (item == null) {
            throw new NullItemException("Неверный массив: null");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IntegerListImpl that = (IntegerListImpl) o;
        return integerListSize == that.integerListSize && Objects.deepEquals(integerList, that.integerList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Arrays.hashCode(integerList), integerListSize);
    }
}
