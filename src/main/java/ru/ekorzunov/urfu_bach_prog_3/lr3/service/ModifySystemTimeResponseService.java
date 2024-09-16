package ru.ekorzunov.urfu_bach_prog_3.lr3.service;

import ru.ekorzunov.urfu_bach_prog_3.lr3.model.Response;
import ru.ekorzunov.urfu_bach_prog_3.lr3.util.DateTimeUtil;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@Qualifier("ModifySystemTimeResponseService")
public class ModifySystemTimeResponseService implements ModifyResponseService {

    @Override
    public Response modify(Response response) {

        response.setSystemTime(DateTimeUtil.getCustomFormat().format(new Date()));

        return response;

    }
}
