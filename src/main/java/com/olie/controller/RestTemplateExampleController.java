package com.olie.controller;

import com.olie.mybatis.model.ScheduleTask;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;


@RestController
public class RestTemplateExampleController {

    private static final Logger logger = LoggerFactory.getLogger(RestTemplateExampleController.class);

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/resttemplateExample")
    public ResponseEntity getRedisBody() {

        String coffeeUri = "http://localhost:8080/logExample/";
        MultiValueMap<String, Object> paramMap = new LinkedMultiValueMap<String, Object>();
        paramMap.add("param", "123");

        ScheduleTask responseObject = restTemplate.postForObject(coffeeUri, paramMap, ScheduleTask.class);
        logger.info("New Coffee: {}", responseObject);


        ResponseEntity<ScheduleTask> responseEntity = restTemplate.postForEntity(coffeeUri, paramMap, ScheduleTask.class);
        logger.info("Response Status: {}, Response Headers: {}", responseEntity.getStatusCode(), responseEntity.getHeaders().toString());
        logger.info("Coffee: {}", responseEntity.getBody());

        String responseString = restTemplate.postForObject(coffeeUri, paramMap, String.class);
        logger.info("responseString: {}", responseString);


        return new ResponseEntity(HttpStatus.OK);

    }

}
