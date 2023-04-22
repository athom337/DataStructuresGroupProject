import lombok.*;

import java.util.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Address {
    private String street;
    private String city;
    private String state;
    private String zipcode;

    public static List<Address> sortByState(List<Address> addresses) {
        Comparator<Address> byState = Comparator.comparing(Address::getState);
        Collections.sort(addresses, byState);
        return addresses;
    }

}
