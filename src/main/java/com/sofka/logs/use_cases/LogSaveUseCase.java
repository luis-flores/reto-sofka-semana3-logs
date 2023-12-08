package com.sofka.logs.use_cases;

import com.sofka.logs.driven_adapters.repositorios.ILogRepositorio;
import com.sofka.logs.models.dto.LogDTO;
import com.sofka.logs.models.mongo.Log;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;

import java.util.function.Function;

@Service
@Validated
@AllArgsConstructor
public class LogSaveUseCase implements Function<LogDTO, Mono<LogDTO>> {
    private ILogRepositorio logRepositorio;
    private ModelMapper modelMapper;

    @Override
    public Mono<LogDTO> apply(LogDTO logDTO) {
        Log log = modelMapper.map(logDTO, Log.class);

        return logRepositorio.save(log)
            .map(logSave -> modelMapper.map(logSave, LogDTO.class));
    }
}
