package seminars.first.Shop;

import org.junit.jupiter.api.*;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
public class ShopTest {

    /*
   1. Напишите тесты, чтобы проверить, что магазин хранит верный список продуктов (правильное количество продуктов, верное содержимое корзины).
   2. Напишите тесты для проверки корректности работы метода getMostExpensiveProduct.
   3. Напишите тесты для проверки корректности работы метода sortProductsByPrice (проверьте правильность сортировки).
   */

    @Test
    @DisplayName("Проверка корректности работы метода getMostExpensiveProduct")
    void getMostExpensiveProduct() {
        Product prod1 = new Product("Banana", 120);
        Product prod2 = new Product("Lemon", 150);
        Product prod3 = new Product("Apple", 180);
        Product prod4 = new Product("Kiwi", 200);
        Product prod5 = new Product("Orange", 300);

        List<Product> actualList = new ArrayList<>();
        actualList.add(prod5);
        actualList.add(prod3);
        actualList.add(prod4);
        actualList.add(prod1);
        actualList.add(prod2);

        int expectedValue = prod5.getCost();
        int maxValue = actualList.stream().max(new Comparator<Product>() {
            @Override
            public int compare(Product p1, Product p2) {
                return p1.getCost() - p2.getCost();
            }
        }).get().getCost();
        assertEquals(expectedValue, maxValue);
    }

    @Test
    @DisplayName("Проверка корректности работы метода sortProductsByPrice (проверьте правильность сортировки)")
    void sortProductsByPrice() {
        Product prod1 = new Product("Banana", 120);
        Product prod2 = new Product("Lemon", 150);
        Product prod3 = new Product("Apple", 180);
        Product prod4 = new Product("Kiwi", 200);
        Product prod5 = new Product("Orange", 300);

        List<Product> actualList = new ArrayList<>();
        actualList.add(prod5);
        actualList.add(prod3);
        actualList.add(prod4);
        actualList.add(prod1);
        actualList.add(prod2);

        List<Product> expectedList = new ArrayList<>();
        expectedList.add(prod1);
        expectedList.add(prod2);
        expectedList.add(prod3);
        expectedList.add(prod4);
        expectedList.add(prod5);
        Collections.sort(actualList, new Comparator<Product>() {
            @Override
            public int compare(Product p1, Product p2) {
                return p1.getCost() - p2.getCost();
            }
        });
        assertLinesMatch(Collections.singletonList(actualList.toString()), Collections.singletonList(expectedList.toString()));
    }


}