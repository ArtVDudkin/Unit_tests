package seminars.second.hw;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class VehicleTest {

    private Car car;
    private Motorcycle motorcycle;

    // Перед каждым тестом создаем экземпляр класса Car
    @BeforeEach
    void setUp() {
        car = new Car("FHI","Subaru Forester",2009);
        motorcycle = new Motorcycle("Honda","Shadow", 2003);
    }

    // После каждого теста "обнуляем" экземпляр класса Car, чтобы в следующий раз использовать новый экземпляр
    @AfterEach
    void tearDown() {
        car = null;
        motorcycle = null;
    }

    // - Проверить, что экземпляр объекта Car также является экземпляром транспортного средства (используя оператор instanceof).
    @Test
    @DisplayName("Проверка, что экземпляр объекта Car также является экземпляром Vehicle")
    void isVehicle() {
        assertTrue(car instanceof Vehicle);
    }

    // - Проверить, что объект Car создается с 4-мя колесами.
    @Test
    @DisplayName("Проверка, что объект Car создается с 4-мя колесами")
    void checkCarWheels(){
        assertEquals(4, car.getNumWheels(), "Неверное количество колес у автомобиля");
    }

    // - Проверить, что объект Car развивает скорость 60 в режиме тестового вождения
    @Test
    @DisplayName("Проверка, что объект Car развивает скорость 60 в режиме тестового вождения")
    void checkCarSpeedDrive(){
        car.testDrive();
        assertEquals(60, car.getSpeed(), "Неверная скорость движения автомобиля в режиме testDrive");
    }

    // - Проверить, что в режиме парковки (сначала testDrive, потом park, т.е. эмуляция движения транспорта) машина останавливается (speed = 0)
    @Test
    @DisplayName("Проверка, что в режиме парковки (сначала testDrive, потом park, т.е. эмуляция движения транспорта) машина останавливается (speed = 0)")
    void checkCarParking(){
        car.testDrive();
        assertEquals(60, car.getSpeed(), "Неверная скорость движения автомобиля в режиме testDrive");
        car.park();
        assertEquals(0, car.getSpeed(), "Неверная скорость после остановки автомобиля");
    }

    // - Проверить, что объект Motorcycle создается с 2-мя колесами
    @Test
    @DisplayName("Проверка, что объект Motorcycle создается с 2-мя колесами")
    void checkMotorcycleWheels(){
        assertEquals(2, motorcycle.getNumWheels(), "Неверное количество колес у мотоцикла");
    }

    // - Проверить, что объект Motorcycle развивает скорость 75 в режиме тестового вождения
    @Test
    @DisplayName("Проверка, что объект Motorcycle развивает скорость 75 в режиме тестового вождения")
    void checkMotorcycleDrive(){
        motorcycle.testDrive();
        assertEquals(75, motorcycle.getSpeed(), "Неверная скорость движения мотоцикла в режиме testDrive");
    }

    // - Проверить, что в режиме парковки (сначала testDrive, потом park, т.е. эмуляция движения транспорта) мотоцикл останавливается (speed = 0)
    @Test
    @DisplayName("Проверка, что в режиме парковки (сначала testDrive, потом park, т.е. эмуляция движения транспорта) мотоцикл останавливается (speed = 0)")
    void checkMotorcycleParking(){
        motorcycle.testDrive();
        assertEquals(75, motorcycle.getSpeed(), "Неверная скорость движения мотоцикла в режиме testDrive");
        motorcycle.park();
        assertEquals(0, motorcycle.getSpeed(), "Неверная скорость после остановки мотоцикла");
    }

}