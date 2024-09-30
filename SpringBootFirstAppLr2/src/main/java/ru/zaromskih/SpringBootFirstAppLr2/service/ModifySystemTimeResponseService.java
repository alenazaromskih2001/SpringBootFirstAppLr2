package ru.zaromskih.SpringBootFirstAppLr2.service;

import ru.zaromskih.SpringBootFirstAppLr2.model.Response;
import ru.zaromskih.SpringBootFirstAppLr2.util.DateTimeUtil;

import java.util.Date;

public class ModifySystemTimeResponseService
        implements ModifyResponseService {
    @Override
    public Response modify(Response response) {

        response.setSystemTime(DateTimeUtil.getCustomFormat().
                format(new Date()));
        return response;
    }
}
