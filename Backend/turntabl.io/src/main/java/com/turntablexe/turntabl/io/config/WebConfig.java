package com.turntablexe.turntabl.io.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@Configuration
public class WebConfig {

	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {

		return new BCryptPasswordEncoder();
	}
}
