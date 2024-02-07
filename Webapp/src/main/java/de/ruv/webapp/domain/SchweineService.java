package de.ruv.webapp.domain;

import de.ruv.webapp.domain.model.Schwein;

import java.util.Optional;
import java.util.UUID;

public interface SchweineService {

    void erfassen(Schwein schwein);
    void aendern(Schwein schwein);

    boolean loeschen(UUID id);

    Optional<Schwein> findeNachId(UUID id);

    Iterable<Schwein> findeAlle();

    boolean fuettern(UUID id);

}
