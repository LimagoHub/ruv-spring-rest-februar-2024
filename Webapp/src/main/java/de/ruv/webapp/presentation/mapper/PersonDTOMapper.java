package de.ruv.webapp.presentation.mapper;

import de.ruv.webapp.domain.model.Person;
import de.ruv.webapp.presentation.dto.PersonDTO;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface PersonDTOMapper {


    Person convert(PersonDTO personDto);

    PersonDTO convert(Person person);

    Iterable<PersonDTO> convert(Iterable<Person> personen);
}
