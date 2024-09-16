package ru.ekorzunov.urfu_bach_prog_3.lr4.service;

import org.springframework.stereotype.Service;
import ru.ekorzunov.urfu_bach_prog_3.lr4.model.Response;

@Service
public interface ModifyResponseService {

    Response modify(Response response);

}
