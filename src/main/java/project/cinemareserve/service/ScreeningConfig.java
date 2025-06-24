package project.cinemareserve.service;

import jakarta.persistence.Column;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "screening")
public class ScreeningConfig {
    private int totalSeats;
    private int totalRows;
}
