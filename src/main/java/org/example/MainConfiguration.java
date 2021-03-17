package org.example;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class MainConfiguration {

    @Bean
    public Jaxb2Marshaller marshaller() {
        Jaxb2Marshaller jaxb2Marshaller = new Jaxb2Marshaller();
        jaxb2Marshaller.setContextPath("org.example.wsdl");
        return jaxb2Marshaller;
    }

    @Bean
    public OrdersClient ordersClient(Jaxb2Marshaller marshaller) {
        OrdersClient ordersClient = new OrdersClient();
        ordersClient.setMarshaller(marshaller);
        ordersClient.setUnmarshaller(marshaller);
        return ordersClient;
    }

    @Bean
    public UsersClient usersClient(Jaxb2Marshaller marshaller) {
        UsersClient usersClient = new UsersClient();
        usersClient.setMarshaller(marshaller);
        usersClient.setUnmarshaller(marshaller);
        return usersClient;
    }

}
