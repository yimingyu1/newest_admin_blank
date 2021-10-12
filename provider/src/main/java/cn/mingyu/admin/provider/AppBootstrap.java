package cn.mingyu.admin.provider;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;

/**
 * @author yimingyu
 * @date 2021/09/26
 */
@SpringBootApplication
@ComponentScan("cn.mingyu.admin.*")
@MapperScan(basePackages = "cn.mingyu.admin.dao.*")
@PropertySource({"classpath:druidConfig.properties"})
@Slf4j
public class AppBootstrap {
    public static void main(String[] args) {
        log.info("start to run AppBootstrap");
        SpringApplication.run(AppBootstrap.class, args);
    }
}
