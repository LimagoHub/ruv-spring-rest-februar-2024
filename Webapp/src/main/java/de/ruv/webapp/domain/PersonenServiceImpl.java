package de.ruv.webapp.domain;

import de.ruv.webapp.domain.model.Person;
import de.ruv.webapp.persistence.PersonenRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional(propagation = Propagation.REQUIRED, rollbackFor = PersonenServiceException.class, isolation = Isolation.READ_COMMITTED)
public class PersonenServiceImpl implements PersonenService{


    private final PersonenRepository repo;
    private final PersonMapper mapper;

//    void bulkInsert(List<Person> personen) throws PersonenServiceException {
//        for (Person p: personen) {
//            this.erfassen(p);
//        }
//    }


    @Override
    public void erfassen(final Person person) throws PersonenServiceException {
        try {
            checkPerson(person);

            if (repo.existsById(person.getId())) throw new PersonenServiceException("Person already exists");

            repo.save(mapper.convert(person));
        } catch (RuntimeException e) {
            throw new PersonenServiceException("Echt jetzt?", e);
        }

    }



    @Override
    public boolean aendern(final Person person) throws PersonenServiceException {
        try {
            checkPerson(person);

            if (! repo.existsById(person.getId())) throw new PersonenServiceException("Person does not exist");

            repo.save(mapper.convert(person));
        } catch (RuntimeException e) {
            throw new PersonenServiceException("Echt jetzt?", e);
        }
        return true;
    }

    @Override
    public boolean loeschen(final Person person) throws PersonenServiceException {
        return loeschen(person.getId());
    }

    @Override
    public boolean loeschen(final UUID id) throws PersonenServiceException {
        boolean retval = repo.existsById(id);
        try {


            repo.deleteById(id);

        } catch (RuntimeException e) {
            throw new PersonenServiceException("Upps", e);
        }
        return  retval;
    }
    @Transactional( isolation = Isolation.READ_UNCOMMITTED)
    @Override
    public Optional<Person> findeNachId(final UUID id) throws PersonenServiceException {
        try {
            return repo.findById(id).map(mapper::convert);
        } catch (RuntimeException e) {
            throw new PersonenServiceException("Upps", e);
        }
    }

    @Override
    public Iterable<Person> findeAlle() throws PersonenServiceException {
        try {
            return mapper.convert(repo.findAll());
        } catch (RuntimeException e) {
            throw new PersonenServiceException("Upps", e);
        }
    }

    private static void checkPerson(final Person person) throws PersonenServiceException {
        if(person == null) throw new PersonenServiceException("Person darf nicht null sein");

        if (person.getVorname() == null || person.getVorname().length() < 2)
            throw new PersonenServiceException("firstname too short");

        if (person.getVorname().equals("Attila"))
            throw new PersonenServiceException("Antipath");
    }
}
