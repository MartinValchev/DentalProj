package com.spring.dental.proj.DentalProj.repositories;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Configuration
@EnableJpaAuditing
@ComponentScan(basePackages = "com.spring.dental.proj.DentalProj")
public class PersistenceConfig {
}
