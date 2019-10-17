package com.olie;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.olie.mybatis.mapper")//扫描 Mapper 类，这样就不用在每一个 Mapper 类上面使用 @Mapper 注解了
public class SpringbootIntegrateApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootIntegrateApplication.class, args);
    }

}
