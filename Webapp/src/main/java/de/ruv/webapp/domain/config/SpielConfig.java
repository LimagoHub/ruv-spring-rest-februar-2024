package de.ruv.webapp.domain.config;

import de.ruv.webapp.YamlPropertySourceFactory;
import de.ruv.webapp.domain.model.Spiel;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.Set;

@Configuration
@PropertySource(value = "classpath:spiel.properties")
@ConfigurationProperties(prefix = "spiel")
@Setter
public class SpielConfig {

    private String stadt;
    private String land;
    private String fluss;


    @Bean

    public Spiel create() {
        return Spiel.builder().stadt(stadt).land(land).fluss(fluss).build();
    }
}
