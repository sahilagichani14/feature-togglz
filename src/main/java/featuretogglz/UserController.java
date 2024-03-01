package featuretogglz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.togglz.core.Feature;
import org.togglz.core.manager.FeatureManager;
import org.togglz.core.util.NamedFeature;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class UserController {
    @Autowired
    private FeatureManager featureManager;

    //public static final Feature ADMIN_ROLE_APPLIED = new NamedFeature("ADMIN_ROLE_APPLIED");

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public List<User> getAllUsers(){
        List<User> adminUserList = new ArrayList<>();
        if(featureManager.isActive(MyFeatures.ADMIN_ROLE_APPLIED)){
            adminUserList = this.specialFeatureForAdminRole();
            return adminUserList;
        } else {
            return userService.getAllUsers();
        }
    }

    @GetMapping("/disablefeature")
    public void callToDisableFeature() throws IOException, InterruptedException {
        DisableFeature.callToDisableFeature("ADMIN_ROLE_APPLIED");
    }

    @GetMapping("/getAllUserMoods")
    public Map<String, String> getAllUsersMoods(){
        Map<String, String> map = new HashMap<>();
        if(featureManager.isActive(MyFeatures.MAKE_HAPPY_MOOD)){
            userService.getAllUsers()
                    .forEach(user -> {
                        map.put(user.getUsername(), "Balle Balle, Shava Shava!!!!");
                    });
        } else {
            userService.getAllUsers()
                    .forEach(user -> {
                        map.put(user.getUsername(), user.getUserMood());
                    });
        }
        return map;
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
