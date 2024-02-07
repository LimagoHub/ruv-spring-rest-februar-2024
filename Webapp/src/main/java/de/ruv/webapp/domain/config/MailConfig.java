package de.ruv.webapp.domain.config;

import de.ruv.webapp.YamlPropertySourceFactory;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.Set;

@Configuration
@PropertySource(value = "classpath:application-mail.yml", factory = YamlPropertySourceFactory.class)
@ConfigurationProperties(prefix = "mail")
@Setter
public class MailConfig {
    private String smtp;
    private String user;
    private String password;

    @Bean
    @Qualifier("mail")
    public Set<String> strings() {
        return Set.of(smtp, user,password);
    }
}
