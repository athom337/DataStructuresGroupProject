import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class User {
    private String username;
    private String email;
    private String password;
    private String address;
    private String zipcode;


    public void linkToPasswordManager() {
        System.out.println("Linking user " + username + " to password manager...");
    }
}
