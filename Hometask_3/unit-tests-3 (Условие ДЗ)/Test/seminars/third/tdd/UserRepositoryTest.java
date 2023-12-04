package seminars.third.tdd;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class UserRepositoryTest {

    private UserRepository userRepo = new UserRepository();

    /**
     * Добавляем перед проведением теста в репозиторий трёх обычных пользователей и двух админов
     */
    @BeforeEach
    void setUp() {
        userRepo.data.clear();
        userRepo.addUser(new User("Andrey","123",false));
        userRepo.addUser(new User("Boris","1234",false));
        userRepo.addUser(new User("Vladimir","12345",true));
        userRepo.addUser(new User("Gleb","123456",true));
        userRepo.addUser(new User("Denis","1234567",false));
    }

    @AfterEach
    void tearDown() {
        userRepo = null;
    }

    @Test
    @DisplayName("Проверка, что все пользователи, кроме администраторов, разлогинены")
    void logoutAllUsers() {
        int countSimpleUser = 0;
        int countAdmin = 0;
        for (User user : userRepo.data) {
            if(user.isAdmin) {
                countAdmin++;
            } else {
                countSimpleUser++;
            }
        }

        // Убеждемся, что в исходном репозитории есть три обычных пользователя и два админа
        assertEquals(3, countSimpleUser, "В репозитории осталось количество пользователей, отличное от 3");
        assertEquals(2, countAdmin, "В репозитории осталось количество администраторов, отличное от 2");
        // Разлогиниваем всех пользователей, кроме администраторов, и обнуляем счетчики
        userRepo.logoutAllUsers();
        countSimpleUser = 0;
        countAdmin = 0;
        if(userRepo.data.size() != 0) {
            for (User user : userRepo.data) {
                if(user.isAdmin) {
                    countAdmin++;
                } else {
                    countSimpleUser++;
                }
            }
        }

        // Убеждемся, что в исходном репозитории остались только два админа
        assertEquals(0, countSimpleUser, "В репозитории осталось количество пользователей, отличное от 0");
        assertEquals(2, countAdmin, "В репозитории осталось количество администраторов, отличное от 2");
    }

}