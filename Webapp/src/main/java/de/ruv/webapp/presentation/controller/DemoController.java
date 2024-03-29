package de.ruv.webapp.presentation.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/demo")
public class DemoController {

    @GetMapping(value = "/gruss", produces = MediaType.TEXT_PLAIN_VALUE)
    public String greeting() {
        return "Hallo Rest";
    }
}
