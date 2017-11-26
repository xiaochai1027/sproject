package com.cfc;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.system.ApplicationPidFileWriter;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.SpringServletContainerInitializer;

/**
 * @auther fangchen.chai ON 2017/11/20
 */
@SpringBootApplication(scanBasePackages = "com.cfc")
@MapperScan(basePackages = "com.cfc.mapper")
@EnableScheduling
public class App extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(App.class);
    }

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(App.class);
        app.addListeners(new ApplicationPidFileWriter());
        app.run(args);
    }
}
