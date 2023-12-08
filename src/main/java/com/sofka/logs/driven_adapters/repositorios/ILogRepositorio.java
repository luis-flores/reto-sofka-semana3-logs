package com.sofka.logs.driven_adapters.repositorios;

import com.sofka.logs.models.mongo.Log;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface ILogRepositorio extends ReactiveMongoRepository<Log, String> {
}
