package com.vtw.pulsar;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.vtw.pulsar.team.repository.TeamRepository;
import com.vtw.pulsar.user.repository.UserRepository;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    CommandLineRunner init(UserRepository userRepository, TeamRepository teamRepository) {
        return args -> {
//            Stream.of("John", "Julie", "Jennifer", "Helen", "Rachel").forEach(name -> {
//                User user = new User(name, name.toLowerCase() + "@domain.com");
//                userRepository.save(user);
//            });
            userRepository.findAll().forEach(System.out::println);
            teamRepository.findAll().forEach(System.out::println);
        };
    }
}
