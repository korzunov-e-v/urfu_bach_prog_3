package ru.ekorzunov.urfu_bach_prog_3.lr5.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ru.ekorzunov.urfu_bach_prog_3.lr5.model.Request;


@Service
@Qualifier("ModifySourceRequestService")
public class ModifySourceRequestService implements ModifyRequestService {

    @Override
    public Request modify(Request request) {

        request.setSource("Service 1");

        return request;
    }
}
