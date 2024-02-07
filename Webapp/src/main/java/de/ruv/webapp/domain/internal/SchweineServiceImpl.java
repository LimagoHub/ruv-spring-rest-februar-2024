package de.ruv.webapp.domain.internal;

import de.ruv.webapp.domain.mapper.SchweinMapper;
import de.ruv.webapp.domain.SchweineService;
import de.ruv.webapp.domain.SchweineServiceException;
import de.ruv.webapp.domain.model.Schwein;
import de.ruv.webapp.persistence.SchweineRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional(propagation = Propagation.REQUIRED, rollbackFor = SchweineServiceException.class, isolation = Isolation.DEFAULT)
public class SchweineServiceImpl implements SchweineService {

    private final SchweineRepository repo;
    private final SchweinMapper mapper;
    @Override
    public void erfassen(final Schwein schwein) {
        try {
            if (repo.existsById(schwein.getId())) throw new SchweineServiceException("Pig already exists");
            repo.save(mapper.convert(schwein));
        }catch (SchweineServiceException e) {
            throw e;
        }
        catch (RuntimeException e) {
            throw new SchweineServiceException("Echt jetzt?", e);
        }
    }

    @Override
    public void aendern(final Schwein schwein) {
        try {
            if (! repo.existsById(schwein.getId())) throw new SchweineServiceException("Pig do not exists");
            repo.save(mapper.convert(schwein));
        }catch (SchweineServiceException e) {
            throw e;
        }
        catch (RuntimeException e) {
            throw new SchweineServiceException("Echt jetzt?", e);
        }
    }

    @Override
    public boolean loeschen(final UUID id) {
        try {
            if (repo.existsById(id)) {
                repo.deleteById(id);
                return true;
            }
            return false;
        }catch (SchweineServiceException e) {
            throw e;
        }
        catch (RuntimeException e) {
            throw new SchweineServiceException("Echt jetzt?", e);
        }
    }

    @Override
    public Optional<Schwein> findeNachId(final UUID id) {
        try {
            return repo.findById(id).map(mapper::convert);
        }catch (SchweineServiceException e) {
            throw e;
        }
        catch (RuntimeException e) {
            throw new SchweineServiceException("Echt jetzt?", e);
        }
    }

    @Override
    public Iterable<Schwein> findeAlle() {
        try {
            return mapper.convert(repo.findAll());
        }catch (SchweineServiceException e) {
            throw e;
        }
        catch (RuntimeException e) {
            throw new SchweineServiceException("Echt jetzt?", e);
        }
    }

    @Override
    public boolean fuettern(final UUID id) {
        final Optional<Schwein> optionalSchwein = findeNachId(id);
        if(optionalSchwein.isEmpty()) return false;
        final Schwein schwein = optionalSchwein.get();
        schwein.fuettern();
        aendern(schwein);
        return true;
    }
}
