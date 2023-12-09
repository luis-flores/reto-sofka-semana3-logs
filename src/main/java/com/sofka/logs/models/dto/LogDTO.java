package com.sofka.logs.models.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LogDTO {
    private String id;
    private String message;
    private Date date;

    @Override
    public String toString() {
        return "LogDTO{" +
            "id='" + id + '\'' +
            ", message='" + message + '\'' +
            ", date=" + date +
            '}';
    }
}
