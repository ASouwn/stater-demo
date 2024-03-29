package com.asouwn.staterdemo;

import com.asouwn.staterdemo.server.User;
import lombok.Data;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@AutoConfiguration
@ConfigurationProperties("stater.demo")
@Data
@ComponentScan()
public class Configuration {
    private String name;
    @Bean
    public User user(){
        return new User(name);
    }
}
