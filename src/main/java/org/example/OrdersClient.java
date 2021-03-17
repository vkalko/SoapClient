package org.example;

import org.example.wsdl.GetOrderInfoRequest;
import org.example.wsdl.GetOrderInfoResponse;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

public class OrdersClient extends WebServiceGatewaySupport {
    private static final String ORDERS_ENDPOINT_URL = "http://localhost:8080/ws/orders";

    public GetOrderInfoResponse getOrderInfo(int orderId) {
        GetOrderInfoRequest orderInfoRequest = new GetOrderInfoRequest();
        orderInfoRequest.setOrderId(orderId);

        GetOrderInfoResponse orderInfoResponse = (GetOrderInfoResponse)getWebServiceTemplate()
                .marshalSendAndReceive(ORDERS_ENDPOINT_URL, orderInfoRequest);
        return orderInfoResponse;
    }

}
