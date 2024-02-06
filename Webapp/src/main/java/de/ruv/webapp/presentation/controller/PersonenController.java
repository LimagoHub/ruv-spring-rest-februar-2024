package de.ruv.webapp.presentation.controller;

import de.ruv.webapp.domain.PersonenService;
import de.ruv.webapp.domain.PersonenServiceException;
import de.ruv.webapp.presentation.dto.PersonDTO;
import de.ruv.webapp.presentation.mapper.PersonDTOMapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.context.annotation.SessionScope;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/personen")
@RequiredArgsConstructor
public class PersonenController {

    private final PersonenService service;
    private final PersonDTOMapper mapper;

    @Operation(summary = "Liefert eine Person")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Person gefunden",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = PersonDTO.class)) }),
            @ApiResponse(responseCode = "400", description = "ungueltige ID",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Person nicht gefunden",
                    content = @Content),
            @ApiResponse(responseCode = "500", description = "internal server error",
                    content = @Content)})
    @GetMapping(path="/{id}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<PersonDTO> findPersonById(@PathVariable  UUID id) throws PersonenServiceException {

        return ResponseEntity.of(service.findeNachId(id).map(mapper::convert));

    }

    @GetMapping(path="", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Iterable<PersonDTO>> findAll (

            @RequestParam(required = false, defaultValue = "Max") String vorname,
            @RequestParam(required = false, defaultValue = "Mustermann") String nachname
    ) throws PersonenServiceException {


        return ResponseEntity.ok(mapper.convert(service.findeAlle()));
    }

    @PostMapping("/functions/toUpper")
    public  ResponseEntity<PersonDTO> toUpper(@RequestBody PersonDTO dto) {
        dto.setVorname(dto.getVorname().toUpperCase());
        dto.setNachname(dto.getNachname().toUpperCase());
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) throws PersonenServiceException {

        if(service.loeschen(id))
            return ResponseEntity.ok().build();
        return ResponseEntity.notFound().build();
    }

    @PostMapping(path="", consumes = MediaType.APPLICATION_JSON_VALUE)
    public  ResponseEntity<Void> save(@Valid @RequestBody PersonDTO dto, UriComponentsBuilder builder) throws PersonenServiceException {
        service.erfassen(mapper.convert(dto));
        UriComponents uriComponents = builder.path("/api/v1/personen/{id}").buildAndExpand(dto.getId());
        return ResponseEntity.created(uriComponents.toUri()).build();
    }

    @PutMapping(path="/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public  ResponseEntity<Void> update(@Valid @RequestBody PersonDTO dto, @PathVariable UUID id) throws PersonenServiceException {
        service.aendern(mapper.convert(dto));

        return ResponseEntity.ok().build();
    }

}
