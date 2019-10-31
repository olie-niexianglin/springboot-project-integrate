package com.olie.fastjson;

import com.alibaba.fastjson.JSON;
import org.junit.Test;


public class FastJSOnTest {

    @Test
    public void testfastJsonTest() {

        User user = new User();
        user.setAge(0);
        user.setName("sa");

        String jsonString = JSON.toJSONString(user);

        System.out.println(jsonString);

        User user1 = JSON.parseObject(jsonString, User.class);


        System.out.printf("");

    }
}