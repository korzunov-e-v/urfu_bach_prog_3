package ru.ekorzunov.urfu_bach_prog_3.lr4.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.ekorzunov.urfu_bach_prog_3.lr4.model.Request;


@Service
@Qualifier("SendToSecondInstanceService")
public class SendToSecondInstanceService {

    public void send(Request request) {
        HttpEntity<Request> httpEntity = new HttpEntity<>(request);

        new RestTemplate().exchange(
                "http://localhost:8082/lr3/feedback",
                HttpMethod.POST,
                httpEntity,
                new ParameterizedTypeReference<>() {}
        );
    }

}
