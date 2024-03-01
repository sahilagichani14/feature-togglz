package featuretogglz;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    public List<User> getAllUsers(){
        List<User> userList = List.of(
                new User(1, "sahil", "password123", Role.ADMIN, "Mood Off"),
                new User(2, "ramesh", "password999", Role.NORMAL, "Mood Off"),
                new User(3, "suresh", "password000", Role.NORMAL, "Mood Off"),
                new User(4, "rohit", "password444", Role.NORMAL, "Mood Off"),
                new User(4, "kumar", "password666", Role.NORMAL, "Mood Off")
                );
        return userList;
    }

}
