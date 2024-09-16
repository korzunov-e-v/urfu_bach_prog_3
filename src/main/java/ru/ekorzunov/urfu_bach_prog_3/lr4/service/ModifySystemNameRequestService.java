package ru.ekorzunov.urfu_bach_prog_3.lr4.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ru.ekorzunov.urfu_bach_prog_3.lr4.model.Request;


@Service
@Qualifier("ModifySystemNameRequestService")
public class ModifySystemNameRequestService implements ModifyRequestService {

    @Override
    public Request modify(Request request) {

        request.setSystemName("Service 1");

        return request;
    }
}
