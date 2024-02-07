package de.ruv.webapp.domain.mapper;

import de.ruv.webapp.domain.model.Person;
import de.ruv.webapp.persistence.entity.PersonEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;


@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface PersonMapper {


    Person convert(PersonEntity personEntity);

    PersonEntity convert(Person person);

    Iterable<Person> convert(Iterable<PersonEntity> entities);
}
