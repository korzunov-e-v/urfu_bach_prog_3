package ru.ekorzunov.urfu_bach_prog_3.lr3.service;

import org.springframework.stereotype.Service;
import ru.ekorzunov.urfu_bach_prog_3.lr3.model.Response;

@Service
public interface ModifyResponseService {

    Response modify(Response response);

}
