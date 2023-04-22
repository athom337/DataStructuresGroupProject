import java.util.*;
import lombok.*;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PasswordManager {
    private List<User> users = new ArrayList<>();

    public void addUser(User user) {
        users.add(user);
    }
}