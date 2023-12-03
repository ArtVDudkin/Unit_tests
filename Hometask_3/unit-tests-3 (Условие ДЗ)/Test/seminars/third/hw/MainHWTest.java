package seminars.third.hw;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class MainHWTest {

    private MainHW mainHW;

    @BeforeEach
    void setUp() {
        mainHW = new MainHW();
    }

    @AfterEach
    void tearDown() {
        mainHW = null;
    }

    /**
     * Проверяем, что чётное целое положительное число (например, 4) является чётным
     */
    @Test
    @DisplayName("Проверка, что чётное целое положительное число является чётным")
    void evenOddNumber() {
        assertEquals(true, mainHW.evenOddNumber(4));
    }

    /**
     * Проверяем, что нечётное целое положительное число (например, 7)является нечётным
     */
    @Test
    @DisplayName("Проверка, что нечётное целое положительное число является нечётным")
    void noEvenOddNumber() {
        assertEquals(false, mainHW.evenOddNumber(7));
    }

    /**
     * Проверяем, что чётное целое отрицательное число (например, -4) является чётным
     */
    @Test
    @DisplayName("Проверка, что чётное целое отрицательное число является чётным")
    void evenOddNegativeNumber() {
        assertEquals(true, mainHW.evenOddNumber(-4));
    }

    /**
     * Проверяем, что заданное целое число (например, 26) попадает в заданный диапазон (25;100)
     */
    @Test
    @DisplayName("Проверка, что заданное целое число находится в диапазоне (25;100)")
    void numberInInterval() {
        assertEquals(true, mainHW.numberInInterval(26));
        assertEquals(true, mainHW.numberInInterval(99));
    }

    /**
     * Проверяем, что пограничные значения целых чисел 25 и 100 не попадают в заданный диапазон (25;100)
     */
    @Test
    @DisplayName("Проверка, что заданное целое число не находится в диапазоне (25;100)")
    void NotNumberInInterval() {
        assertEquals(false, mainHW.numberInInterval(25));
        assertEquals(false, mainHW.numberInInterval(100));
    }

}