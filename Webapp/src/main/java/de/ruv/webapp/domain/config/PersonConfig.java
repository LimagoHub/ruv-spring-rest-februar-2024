package de.ruv.webapp.domain.config;

import de.ruv.webapp.domain.PersonenService;
import de.ruv.webapp.domain.internal.PersonenServiceImpl;
import de.ruv.webapp.domain.mapper.PersonMapper;
import de.ruv.webapp.persistence.PersonenRepository;


import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;

import java.util.List;

@Configuration
public class PersonConfig {

    @Bean
    @Qualifier("antipathen")
    public List<String> createAntipathen() {
        return List.of("Attila", "Peter", "Paul", "Mary");
    }

    @Bean
    @Qualifier("fruits")
    public List<String> createFruits() {
        return List.of("Cherry", "Apple", "Banana", "Strawberry");
    }

//    @Bean
//    public PersonenService createPersonenService(PersonenRepository repo, PersonMapper mapper, List<String> antipathen) {
//        return new PersonenServiceImpl(repo, mapper, antipathen);
//    }

    /*
        1. Grund Quellcode nicht erreichbar
        2. Grund komplexe Konstruktion
        3. Grund man will keine Spring Annotation
     */
}
