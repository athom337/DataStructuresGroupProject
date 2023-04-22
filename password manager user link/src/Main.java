import java.util.*;

public class Main {
    public static void main(String[] args) {

        User user1 = new User("johndoe", "johndoe@gmail.com", "password", "123 Main St", "10001");
        user1.linkToPasswordManager();

        Order order1 = new Order(100.00, "NY", false);
        Order order2 = new Order(50.00, "HI", false);
        Order order3 = new Order(75.00, "CA", false);
        Order order4 = new Order(200.00, "NY", false);

        List<Order> orders = new ArrayList<>();
        orders.add(order1);
        orders.add(order2);
        orders.add(order3);
        orders.add(order4);


        Map<String, Integer> ordersByState = Order.filterByState(orders);
        System.out.println("Total number of orders by state:");
        for (Map.Entry<String, Integer> entry : ordersByState.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        List<String> excludedStates = new ArrayList<>();
        excludedStates.add("HI");
        excludedStates.add("AK");

        List<Order> filteredOrders = Order.filterByState(orders, excludedStates);
        System.out.println("\nOrders eligible for free shipping:");
        for (Order order : filteredOrders) {
            System.out.println(order);
        }
    }
}