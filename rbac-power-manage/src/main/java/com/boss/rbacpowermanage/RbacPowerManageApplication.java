package com.boss.rbacpowermanage;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author 黄杰峰
 */
@SpringBootApplication
@MapperScan("com.boss.rbacpowermanage.mapper")
@EnableDiscoveryClient
@RefreshScope
public class RbacPowerManageApplication {

    public static void main(String[] args) {
        SpringApplication.run(RbacPowerManageApplication.class, args);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
