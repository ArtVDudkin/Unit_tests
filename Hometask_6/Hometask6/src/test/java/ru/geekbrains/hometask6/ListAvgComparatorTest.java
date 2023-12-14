package ru.geekbrains.hometask6;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import static org.mockito.Mockito.*;

class ListAvgComparatorTest {

    private ListAvgComparator listAvgComparator;

    @BeforeEach
    void setUp() {
        // Создаем Mock-заглушку для класса ListAvgComparator
        listAvgComparator = mock(ListAvgComparator.class);
    }

    @AfterEach
    void tearDown() {
        listAvgComparator = null;
    }

    @Test
    @DisplayName("Проверка метода расчета среднего значения чисел в списке")
    void calcAverage() {
        List<Integer> list = List.of(1,2,3,4,5);
        double avg = list.stream().mapToInt(i -> i.intValue()).sum() / list.size();
        double res = listAvgComparator.calcAverage(list);
        assertEquals(avg, res);
    }

    @Test
    @DisplayName("Проверка метода сравнения чисел, все числа больше заданного")
    public void compare() {
        double value1 = 3.5;
        double value2 = 2.5;
        int res = listAvgComparator.compare(value1, value2);
        assertEquals(1, res, "Число должно быть больше заданного");
        res = listAvgComparator.compare(value2, value1);
        assertEquals(2, res, "Число должно быть меньше заданного");
        res = listAvgComparator.compare(value1, value1);
        assertEquals(0, res, "Числа должны быть равны");
    }

    @Test
    @DisplayName("Проверка вызова интерпретации и отображения результатов сревнения средних значений в двух списках в требуемом виде")
    void viewComparison() {
        double value1 = 1.1;
        double value2 = 2.2;
        listAvgComparator.viewComparison(value1, value2);
        // Убеждаемся, что метод viewComparison() был вызван 1 раз
        verify(listAvgComparator, times(1)).viewComparison(value1, value2);
    }

    @Test
    @DisplayName("Проверка вызова метода отображения величин средних значений в двух списках")
    void showAverage() {
        listAvgComparator.showAverage();
        // Убеждаемся, что метод showAverage() был вызван 1 раз
        verify(listAvgComparator, times(1)).showAverage();
    }
}