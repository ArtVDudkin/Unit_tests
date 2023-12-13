package ru.geekbrains.hometask6;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Класс служит для создания и заполнения списка случайными целыми числами
 */
public class ListIntegerGenerator {

    private List<Integer> numList;
    private Random rand;

    public ListIntegerGenerator() {
        this.numList = new ArrayList<>();
        this.rand = new Random();
    }

    public List<Integer> getNumList() {
        return numList;
    }

    /**
     * Метод служит для заполнения списка случайными целыми числами в диапазоне от min до max
     * @param amount требуемое количество чисел, которое должен содержать список
     * @param min минимальное значение чисел в списке
     * @param max максимальное значение чисел в списке
     */
    public List<Integer> generate(int amount, int min, int max) {
        numList.clear();
        for(int i = 0; i < amount; i++) {
            numList.add(rand.nextInt(max - min + 1) + min);
        }
        return numList;
    }

    /**
     * Метод служит для очистки списка для его повторного использования
     */
    public void clear() {
        numList.clear();
    }

}
