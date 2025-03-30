package io.github.studiotrek.morpheus.resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/v1")
public class MorpheusResource {

    @ResponseStatus(OK)
    @GetMapping("/health")
    public String healthcheck() {
        return "SUCCESS";
    }
}