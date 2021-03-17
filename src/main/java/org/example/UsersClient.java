package org.example;

import org.example.wsdl.GetUserInfoRequest;
import org.example.wsdl.GetUserInfoResponse;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

public class UsersClient extends WebServiceGatewaySupport {
    private static final String USERS_ENDPOINT_URL = "http://localhost:8080/ws/users";

    public GetUserInfoResponse getUserInfo(int userId) {
        GetUserInfoRequest userInfoRequest = new GetUserInfoRequest();
        userInfoRequest.setUserId(userId);

        return (GetUserInfoResponse) getWebServiceTemplate()
                .marshalSendAndReceive(USERS_ENDPOINT_URL, userInfoRequest);
    }

}
