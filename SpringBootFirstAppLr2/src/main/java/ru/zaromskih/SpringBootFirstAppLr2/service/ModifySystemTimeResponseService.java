package ru.zaromskih.SpringBootFirstAppLr2.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ru.zaromskih.SpringBootFirstAppLr2.model.Response;
import ru.zaromskih.SpringBootFirstAppLr2.util.DateTimeUtil;

import java.util.Date;

@Slf4j
@Service
@Qualifier("ModifySystemTimeResponseService")

public class ModifySystemTimeResponseService
        implements ModifyResponseService {
    @Override
    public Response modify(Response response) {

        response.setSystemTime(DateTimeUtil.getCustomFormat().
                format(new Date()));
        log.info("Updated systemTime to: {}", response.getSystemTime());
        return response;
    }
}
