package featuretogglz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    private List<User> specialFeatureForAdminRole(){
        List<User> normalUserList = new ArrayList<>();
        List<User> adminUserList = new ArrayList<>();

        userService.getAllUsers()
                .forEach(user -> {
                    if(user.getUserrole().equals(Role.ADMIN)){
                        adminUserList.add(user);
                    } else {
                        normalUserList.add(user);
                    }
                });
        return adminUserList;
    }

}
