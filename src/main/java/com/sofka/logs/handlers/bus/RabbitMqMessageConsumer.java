package com.sofka.logs.handlers.bus;


import com.sofka.logs.RabbitConfig;
import com.sofka.logs.models.dto.LogDTO;
import com.sofka.logs.use_cases.LogSaveUseCase;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import reactor.rabbitmq.Receiver;

import java.util.Date;

@Component
@AllArgsConstructor
public class RabbitMqMessageConsumer implements CommandLineRunner {
    private Receiver receiver;
    private LogSaveUseCase saveUseCase;

    @Override
    public void run(String... args) throws Exception {
        receiver.consumeAutoAck(RabbitConfig.LOG_QUEUE_NAME)
            .map(message -> {
                LogDTO logDTO = new LogDTO();
                logDTO.setMessage(new String(message.getBody()));
                logDTO.setDate(new Date());

                return saveUseCase.apply(logDTO);
            }).subscribe();
    }
}
