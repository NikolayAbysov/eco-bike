package com.dev.appconfig;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {
        "com.dev.service",
        "com.dev.dao"
})
public class AppConfig {
}
