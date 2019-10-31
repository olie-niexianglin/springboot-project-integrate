package com.olie.controller.exception;


import com.alibaba.fastjson.JSON;
import com.olie.utils.ResponseEntity;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler
    @ResponseBody
    public ResponseEntity globalExceptionHandler(Exception exception) {

        logger.info("GlobalExceptionHandler.globalExceptionHandler param is：{}", JSON.toJSONString(new Object[]{exception}));
        return ResponseEntity.fail;
    }

    @ExceptionHandler(MyException.class)
    @ResponseBody
    public ResponseEntity myExceptionHandler(MyException myException) {

        logger.info("GlobalExceptionHandler.myExceptionHandler param is：{}", JSON.toJSONString(new Object[]{myException}));

        return ResponseEntity.fail;
    }
}
