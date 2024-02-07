package de.ruv.webapp.persistence;

import de.ruv.webapp.persistence.entity.PersonEntity;
import de.ruv.webapp.persistence.entity.TinyPerson;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface PersonenRepository extends CrudRepository<PersonEntity, UUID> {

    Iterable<PersonEntity> findByVorname(String vorname);
    Iterable<PersonEntity> findByVornameOrNachname(String vorname, String nachname);

    @Query("select p from PersonEntity p where p.vorname like :vorname")
    Iterable<PersonEntity> nameIstWurst(String vorname);

    @Query("select new de.ruv.webapp.persistence.entity.TinyPerson(p.id, p.nachname) from PersonEntity p")
    Iterable<TinyPerson> findAllTinyPersons();


}
