package com.sofka.logs;

import com.rabbitmq.client.Connection;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import reactor.core.publisher.Mono;

@SpringBootApplication
public class LogsApplication {

    @Autowired
    private Mono<Connection> connectionMono;

	public static void main(String[] args) {
		SpringApplication.run(LogsApplication.class, args);
	}

    @PreDestroy
    public void close() throws Exception {
        connectionMono.block().close();
    }
}
