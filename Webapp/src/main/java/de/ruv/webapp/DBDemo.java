package de.ruv.webapp;


import de.ruv.webapp.persistence.PersonenRepository;
import de.ruv.webapp.persistence.entity.PersonEntity;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

//@Component
@RequiredArgsConstructor
public class DBDemo {

    private final PersonenRepository repo;

    @PostConstruct
    public void foo() {
       /* PersonEntity p = PersonEntity.builder().id(UUID.randomUUID()).vorname("Jane").nachname("Doe").build();
        repo.save(p);
        System.out.println(p.getId());

        */
        /*
        Optional<PersonEntity> optionalPersonEntity = repo.findById(UUID.fromString("9f0bc2f8-5615-4128-8f03-9de399f95c1b"));
        System.out.println(optionalPersonEntity);
        */
        repo.findAllTinyPersons().forEach(System.out::println);
    }
}
