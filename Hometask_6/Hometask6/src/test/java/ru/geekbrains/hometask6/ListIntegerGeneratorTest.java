package ru.geekbrains.hometask6;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

class ListIntegerGeneratorTest {

    private ListIntegerGenerator listIntegerGenerator;
    @BeforeEach
    void setUp() {
        listIntegerGenerator = new ListIntegerGenerator();
    }

    @AfterEach
    void tearDown() {
        listIntegerGenerator = null;
    }

    @Test
    @DisplayName("Проверка метода получения элементов списка")
    void getNumList() {
        // Создаем список случайных целых чисел
        listIntegerGenerator.generate(20, 1, 10);
        // Убеждаемся, что полученный список является сущностью типа List<Integer>
        assertTrue(listIntegerGenerator.getNumList() instanceof List<Integer>);
        // Убеждаемся, что список не пустой
        assertNotNull(listIntegerGenerator.getNumList());
    }

    @Test
    @DisplayName("Проверка метода генерирования списка случайных целых чисел")
    void generate() {
        // Создаем список случайных целых чисел
        listIntegerGenerator.generate(20, 1, 10);
        // Убеждаемся, что список не пустой
        assertNotNull(listIntegerGenerator.getNumList());
        // Убеждаемся, что полученный список является сущностью типа List<Integer>
        assertTrue(listIntegerGenerator.getNumList() instanceof List<Integer>);
        // Убеждаемся, что список содержит 20 значений
        assertEquals(20, listIntegerGenerator.getNumList().size());
        // Убеждаемся, что минимальное значение в списке не менее 1
        assertTrue(1 <= listIntegerGenerator.getNumList().stream().mapToInt(i -> i.intValue()).min().getAsInt());
        // Убеждаемся, что максимальное значение в списке не более 10
        assertTrue(10 >= listIntegerGenerator.getNumList().stream().mapToInt(i -> i.intValue()).max().getAsInt());
    }

    @Test
    @DisplayName("Проверка метода очистки списка")
    void clear() {
        // Создаем список случайных целых чисел
        listIntegerGenerator.generate(20, 1, 10);
        // Убеждаемся, что список не пустой и содержит 20 значений
        assertNotNull(listIntegerGenerator.getNumList());
        assertEquals(20, listIntegerGenerator.getNumList().size());
        // Вызываем метод очистки списка
        listIntegerGenerator.clear();
        // Убеждаемся, что в списке нет ни одного значения
        assertEquals(0, listIntegerGenerator.getNumList().size());
    }
}