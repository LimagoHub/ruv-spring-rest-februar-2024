package de.ruv.webapp.domain;

import de.ruv.webapp.domain.config.MailConfig;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
@RequiredArgsConstructor
public class Demo {
    private final Set<String> mailconfig;
    //private final MailConfig config;

    @PostConstruct
   public void run() {
       System.out.println(mailconfig);
   }
}
