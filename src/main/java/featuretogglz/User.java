package featuretogglz;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
//@AllArgsConstructor
public class User {
    private int userId;
    private String username;
    private String password;
    private Role userrole;
    private String userMood;

    public User(int userId, String username, String password, Role userrole, String userMood) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.userrole = userrole;
        this.userMood = userMood;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getUserrole() {
        return userrole;
    }

    public void setUserrole(Role userrole) {
        this.userrole = userrole;
    }

    public String getUserMood() {
        return userMood;
    }

    public void setUserMood(String userMood) {
        this.userMood = userMood;
    }
}
