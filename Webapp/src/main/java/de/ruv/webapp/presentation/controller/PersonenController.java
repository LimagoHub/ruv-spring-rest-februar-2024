package de.ruv.webapp.presentation.controller;

import de.ruv.webapp.presentation.dto.PersonDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/personen")
public class PersonenController {

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
    public ResponseEntity<PersonDTO> findPersonById(@PathVariable  UUID id) {

        // Finderaufruf
        if(id.equals(UUID.fromString("3fa85f64-5717-4562-b3fc-2c963f66afa6")))
            return ResponseEntity.ok(PersonDTO.builder().id(id).vorname("John").nachname("Doe").build());

        return ResponseEntity.notFound().build();
    }

    @GetMapping(path="", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Iterable<PersonDTO>> findAll(

            @RequestParam(required = false, defaultValue = "Max") String vorname,
            @RequestParam(required = false, defaultValue = "Mustermann") String nachname
    ) {
         var liste = List.of(
                 PersonDTO.builder().id(UUID.randomUUID()).vorname("John").nachname("Doe").build(),
                 PersonDTO.builder().id(UUID.randomUUID()).vorname("John").nachname("Wayne").build(),
                 PersonDTO.builder().id(UUID.randomUUID()).vorname("John").nachname("Wick").build(),
                 PersonDTO.builder().id(UUID.randomUUID()).vorname("John").nachname("McClaine").build(),
                 PersonDTO.builder().id(UUID.randomUUID()).vorname("John").nachname("Rambo").build()

         );

        System.out.printf("Vorname = %s, Nachname = %s%n", vorname, nachname);
        return ResponseEntity.ok(liste);
    }

}
