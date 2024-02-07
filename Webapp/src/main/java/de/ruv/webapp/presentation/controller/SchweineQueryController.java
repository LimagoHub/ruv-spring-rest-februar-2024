package de.ruv.webapp.presentation.controller;

import de.ruv.webapp.domain.SchweineService;
import de.ruv.webapp.presentation.dto.SchweinDTO;
import de.ruv.webapp.presentation.mapper.SchweinDTOMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/schweine")
@RequiredArgsConstructor
public class SchweineQueryController {

    private final SchweineService service;
    private final SchweinDTOMapper mapper;

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SchweinDTO> findById(final UUID id) {

        return ResponseEntity.of(service.findeNachId(id).map(mapper::convert));
    }

    @GetMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Iterable<SchweinDTO>> findAll() {

        return ResponseEntity.ok(mapper.convert(service.findeAlle()));
    }
}
