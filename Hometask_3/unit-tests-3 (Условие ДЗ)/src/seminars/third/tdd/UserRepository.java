package seminars.third.tdd;

import java.util.ArrayList;
import java.util.List;

public class UserRepository {

    // Тут можно хранить аутентифицированных пользователей
    List<User> data = new ArrayList<>();

    /**
     * Метод добавляет авторизовавшегося пользователя в репозиторий авторизовавшихся пользователей
     * ToDo где-то должен быть отдельный метод проверки авторизации, что бы присвоить  user.isAuthenticate = true;
     */
    public void addUser(User user) {
       user.isAuthenticate = true;
       data.add(user);
    }

    /**
     * Метод удаляет пользователя из репозитория авторизовавшихся пользователей
     */
    public void removeUser(User user) {
        data.remove(user);
    }

    /**
     * Метод ищет пользователя по его имени в репозитории авторизовавшихся пользователей
     */
    public boolean findByName(String username) {
        for (User user : data) {
            if (user.name.equals(username)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Метод разлогинивает всех всех пользователей, кроме администраторов
     */
    public void logoutAllUsers() {
        if(data.size() > 0) {
            for (User user : data) {
                if (!user.isAdmin) {
                    user.isAuthenticate = false;
                }
            }
        }
    }

}