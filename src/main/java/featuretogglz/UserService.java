package featuretogglz;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    public List<User> getAllUsers(){
        List<User> userList = List.of(
                new User(1, "sahil", "password123", Role.ADMIN),
                new User(1, "ramesh", "password123", Role.NORMAL),
                new User(1, "suresh", "password123", Role.NORMAL));
        return userList;
    }

}
