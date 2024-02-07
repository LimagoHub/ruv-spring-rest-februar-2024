package de.ruv.webapp.domain;

import de.ruv.webapp.domain.config.MailConfig;
import de.ruv.webapp.domain.model.Spiel;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
@RequiredArgsConstructor
public class Demo {
    private final Set<String> mailconfig;
    //private final MailConfig config;

    private final Spiel spiel;
    @PostConstruct
   public void run() {

        System.out.println(mailconfig);
        System.out.println(spiel);
   }
}
