import lombok.*;

import java.util.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Order {
    private double totalAmount;
    private String state;
    private boolean freeShipping;

    public static List<Order> filterByState(List<Order> orders, List<String> excludedStates) {
        List<Order> filteredOrders = new ArrayList<>();
        for (Order order : orders) {
            if (!excludedStates.contains(order.getState())) {
                order.setFreeShipping(true);
                filteredOrders.add(order);
            }
        }
        return filteredOrders;
    }
    public static Map<String, Integer> filterByState(List<Order> orders) {
        Map<String, Integer> ordersByState = new HashMap<>();
        for (Order order : orders) {
            String state = order.getState();
            int count = ordersByState.getOrDefault(state, 0);
            ordersByState.put(state, count + 1);
        }
        return ordersByState;
    }
}

