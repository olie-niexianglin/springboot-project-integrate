package com.olie.controller.session;

import com.alibaba.fastjson.JSON;
import com.olie.controller.request.BaseRequest;
import com.olie.utils.aspects.log.SystemLog;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@Slf4j
public class SpringSessionExampleController {


    @PostMapping(value = "/setSession")
    public Object setRedis(@RequestParam("key") String key, @RequestParam("value") String value, HttpServletRequest request) {

        request.getSession().setAttribute(key, value);

        return value;
    }


}
