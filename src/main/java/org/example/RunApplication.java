package org.example;

import org.example.wsdl.Order;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class RunApplication {

    public static void main(String[] args) {
        SpringApplication.run(RunApplication.class, args);
    }

    @Bean
    CommandLineRunner runner(OrdersClient ordersClient) {
        return args -> {
            int orderId = 3;
            if (args.length == 1) {
                try {
                    orderId = Integer.parseInt(args[0]);
                } catch (NumberFormatException ex) {
                    System.out.println("Please enter desired Id of the order");
                }
            }
            Order order = ordersClient.getOrderInfo(orderId).getOrder();
            System.out.printf("Order {Id: %d, Description: %s, Status: %s}",
                    order.getOrderId(), order.getOrderDescription(), order.getOrderStatus());
        };
    }

}
