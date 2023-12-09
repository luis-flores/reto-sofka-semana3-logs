package com.sofka.logs.use_cases;

import com.sofka.logs.driven_adapters.repositorios.ILogRepositorio;
import com.sofka.logs.models.dto.LogDTO;
import com.sofka.logs.models.mongo.Log;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;

import java.sql.SQLOutput;
import java.util.function.Function;

@Service
@Validated
@AllArgsConstructor
public class LogSaveUseCase implements Function<LogDTO, Mono<LogDTO>> {
//    private ILogRepositorio logRepositorio;
    private final ReactiveMongoTemplate mongoTemplate;
    private ModelMapper modelMapper;

    @Override
    public Mono<LogDTO> apply(LogDTO logDTO) {
        Log log = modelMapper.map(logDTO, Log.class);
        System.out.println("Log mappeado: " + log);

        mongoTemplate.save(log).subscribe();
        return Mono.just(modelMapper.map(log, LogDTO.class));
    }
}
