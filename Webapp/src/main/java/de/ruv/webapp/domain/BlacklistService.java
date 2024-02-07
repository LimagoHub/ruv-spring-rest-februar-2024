package de.ruv.webapp.domain;

import de.ruv.webapp.domain.model.Person;

public interface BlacklistService {

    boolean isBlacklisted(Person possibleBlacklistedPerson);
}
