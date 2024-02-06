package de.ruv.webapp.presentation.mapper;

import de.ruv.webapp.domain.model.Schwein;
import de.ruv.webapp.presentation.dto.SchweinDTO;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface SchweinDTOMapper {

    SchweinDTO convert(Schwein schwein);
    Schwein convert(SchweinDTO schwein);

    Iterable<SchweinDTO> convert(Iterable<Schwein> schweine);
}
