package seminars.fourth.book;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertLinesMatch;
import static org.mockito.Mockito.*;

class BookServiceTest {

    private InMemoryBookRepository inMemoryBookRepository;
    private BookService bookService;

    /**
     * Создаем Mock-заглушку для класса InMemoryBookRepository
     */
    @BeforeEach
    void setUp() {
        // Создаем Mock-заглушку для класса InMemoryBookRepository
        inMemoryBookRepository = mock(InMemoryBookRepository.class);
        // Создаем репозиторий BookService с использованием данных Mock-заглушки
        bookService = new BookService(inMemoryBookRepository);
    }

    /**
     * Обнуляем Mock-заглушку для класса InMemoryBookRepository после проведения теста
     */
    @AfterEach
    void tearDown() {
        inMemoryBookRepository = null;
        bookService = null;
    }

    /**
     * Проводим параметризованный тест метода findBookById(String id) с использованием имещихся в Mock-заглушке id книг
     */
    @ParameterizedTest
    @ValueSource(strings = { "1", "2" })
    @DisplayName("Проверка метода поиска книги по ее ID")
    void findBookById(String id) {

        Book expectedBook = new Book(id);
        // Возвращаем книгу по id из Mock-заглушки
        when(inMemoryBookRepository.findById(id)).thenReturn(expectedBook);
        // Возвращаем книгу по id из репозитория
        Book book = bookService.findBookById(id);
        // Убеждаемся, что найдена одна и та же книга
        assertEquals(expectedBook, book);
        // Убеждаемся, что метод findById(id) был вызван 1 раз
        verify(inMemoryBookRepository, times(1)).findById(id);
    }

    /**
     * Проводим тест метода findAllBooks() с использованием имещихся в Mock-заглушке книг
     */
    @Test
    @DisplayName("Метод findAll вызван хотя бы раз")
    void findAllBooks() {
        // Возвращаем список книг из репозитория
        List<Book> bookList = bookService.findAllBooks();
        // Получаем список книг из Mock-заглушки
        List<Book> expectedBookList = new ArrayList<>();
        when(inMemoryBookRepository.findAll()).thenReturn(expectedBookList);
//      // Убеждаемся, что список книг, полученных из репозитория, совпадает со списком книг из Mock-заглушки
        assertLinesMatch(Collections.singletonList(bookList.toString()), Collections.singletonList(expectedBookList.toString()));
        // Убеждаемся, что метод findAll() был вызван 1 раз
        verify(inMemoryBookRepository, times(1)).findAll();
    }

}