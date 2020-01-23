package org.peopleskill.application;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@ComponentScan(basePackages = { "org.peopleskill"})
@EntityScan({ "org.peopleskill.entity" })
@EnableJpaRepositories({ "org.peopleskill.repository" })
public class PeopleSkillServiceApplication {
    private static final Logger LOGGER = LoggerFactory.getLogger(PeopleSkillServiceApplication.class);

    public static void main(final String... args) {
        LOGGER.info("Starting People Skill Service ");
        SpringApplication.run(PeopleSkillServiceApplication.class, args);
    }
}
