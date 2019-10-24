package com.olie.controller.request;

import lombok.Data;

import java.util.List;

@Data
public class BaseRequest {

    private String name;

    private List<String> interests;
}
