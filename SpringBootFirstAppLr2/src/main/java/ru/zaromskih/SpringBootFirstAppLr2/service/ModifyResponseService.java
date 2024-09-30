package ru.zaromskih.SpringBootFirstAppLr2.service;

import org.springframework.stereotype.Service;
import ru.zaromskih.SpringBootFirstAppLr2.model.Response;

@Service
public interface ModifyResponseService {

    Response modify(Response response);
}
