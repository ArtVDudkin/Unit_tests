package ru.geekbrains.hometask6;

import java.util.List;

/**
 * Класс предназначен для получения среднего значения чисел в списке и средних сравнения значений двух списков
 */
public class ListAvgComparator {

    private double avgList1;
    private double avgList2;

    public ListAvgComparator(List<Integer> numList1, List<Integer> numList2) {
        this.avgList1 = calcAverage(numList1);
        this.avgList2 = calcAverage(numList2);
    }

    /**
     * Метод служит для расчета среднего значения всех чисел в списке
     * @param numList список целых чисел
     * @return возвращает среднее арифметическое значение всех чисел в списке
     */
    public double calcAverage(List<Integer> numList) {
        int sum = 0;
        double result = 0;
        for (Integer num : numList) {
            sum += num;
        }
        result = (double)sum / numList.size();
        return result;
    }

    /**
     * Метод служит для сревнения двух вещественных чисел
     * @return возвращает 1, если среднее значение чисел в списке 1 больше, чем среднее значение чисел в списке 2
     *         возвращает 2, если среднее значение чисел в списке 2 больше, чем среднее значение чисел в списке 1
     *         возвращает 0, если средние значения чисел в обоих списках равны
     */
    public int compare() {
        if(avgList1 > avgList2) {return 1;}
        if(avgList1 < avgList2) {return 2;}
        return 0;   // if(avgList1 == avgList2)
    }

    /**
     * Метод служит для интерпретации и отображения результатов сревнения средних значений в двух списках в требуемом виде
     */
    public void viewComparison() {
        switch (compare()) {
            case 0: {
                System.out.println("Средние значения равны");
                break;
            }
            case 1: {
                System.out.println("Первый список имеет большее среднее значение");
                break;
            }
            case 2: {
                System.out.println("Второй список имеет большее среднее значение");
                break;
            }
        }
    }

    /**
     * Метод служит для отображения величин средних значений в двух списках
     */
    public void showAverage() {
        System.out.println("Среднее значение первого списка: " + avgList1);
        System.out.println("Среднее значение второго списка: " + avgList2);
    }

}
