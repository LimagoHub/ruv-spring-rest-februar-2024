package de.ruv.webapp.persistence;

import de.ruv.webapp.persistence.entity.SchweinEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface SchweineRepository extends CrudRepository<SchweinEntity, UUID> {
}
