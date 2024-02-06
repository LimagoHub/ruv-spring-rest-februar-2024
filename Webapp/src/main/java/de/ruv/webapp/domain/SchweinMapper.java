package de.ruv.webapp.domain;

import de.ruv.webapp.domain.model.Schwein;
import de.ruv.webapp.persistence.entity.SchweinEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface SchweinMapper {
    SchweinEntity convert(Schwein schwein);
    Schwein convert(SchweinEntity schwein);

    Iterable<Schwein> convert(Iterable<SchweinEntity> entities);
}
