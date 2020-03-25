package com.goshgarmirzayev.lastrebound.config;

import com.goshgarmirzayev.lastrebound.service.inter.PostServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.firewall.HttpFirewall;
import org.springframework.security.web.firewall.StrictHttpFirewall;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.TimeZone;

@Configuration
@EnableScheduling
public class AllConfig {
    @Autowired
    PostServiceInter postServiceInter;

    @Bean("pwdEncoder")
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    @PostConstruct
    void started() {
        TimeZone.setDefault(TimeZone.getTimeZone("Asia/Baku"));
    }

}
