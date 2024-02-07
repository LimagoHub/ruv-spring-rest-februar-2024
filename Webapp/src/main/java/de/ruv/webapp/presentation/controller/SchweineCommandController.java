package de.ruv.webapp.presentation.controller;

import de.ruv.webapp.domain.PersonenServiceException;
import de.ruv.webapp.domain.SchweineService;
import de.ruv.webapp.presentation.dto.PersonDTO;
import de.ruv.webapp.presentation.dto.SchweinDTO;
import de.ruv.webapp.presentation.mapper.SchweinDTOMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/schweine")
@RequiredArgsConstructor
public class SchweineCommandController {

    private final SchweineService service;
    private final SchweinDTOMapper mapper;




    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id)  {

        if(service.loeschen(id))
            return ResponseEntity.ok().build();
        return ResponseEntity.notFound().build();
    }

    @PostMapping(path="", consumes = MediaType.APPLICATION_JSON_VALUE)
    public  ResponseEntity<Void> save(@Valid @RequestBody SchweinDTO dto, UriComponentsBuilder builder)  {
        service.erfassen(mapper.convert(dto));
        UriComponents uriComponents = builder.path("/api/v1/schweine/{id}").buildAndExpand(dto.getId());
        return ResponseEntity.created(uriComponents.toUri()).build();
    }

    @PutMapping(path="/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public  ResponseEntity<Void> update(@Valid @RequestBody SchweinDTO dto, @PathVariable UUID id) {
        service.aendern(mapper.convert(dto));

        return ResponseEntity.ok().build();
    }

}
