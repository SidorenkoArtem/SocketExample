package com.example.socket;

import javafx.application.Application;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.scheduling.annotation.EnableScheduling;

import javax.annotation.PostConstruct;
import java.time.ZoneId;
import java.util.TimeZone;

@SpringBootApplication
@EnableScheduling
@EnableAutoConfiguration
public class SocketApplication implements CommandLineRunner {

	@PostConstruct
	void started() {
		TimeZone.setDefault(TimeZone.getTimeZone(ZoneId.of("Europe/Minsk")));
	}

	public static void main(String[] args) {
		SpringApplication.run(SocketApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

	}
}
