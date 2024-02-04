package com.drn.tinyurl.controller;

import com.drn.tinyurl.entity.Redirect;
import com.drn.tinyurl.request.RedirectCreationRequest;
import com.drn.tinyurl.service.RedirectService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;

import static org.springframework.http.HttpStatus.MOVED_PERMANENTLY;

@RestController
@Slf4j
public class RedirectController {
    private RedirectService service;

    @Autowired
    public RedirectController(RedirectService service) {
        this.service = service;
    }

    @GetMapping("/{alias}")
    public ResponseEntity<?> handlerRedirect(@PathVariable String alias) throws URISyntaxException {
        Redirect redirect = service.getRedirect(alias);
        log.info("Directing "+ redirect);
        URI uri = new URI(redirect.getUrl());
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setLocation(uri);
    return new ResponseEntity<>(httpHeaders, MOVED_PERMANENTLY);
    }

    @PostMapping("/")
    public ResponseEntity<?> createRedirect(@Valid @RequestBody RedirectCreationRequest redirectCreationRequest) {
        return ResponseEntity.ok(service.createRedirect(redirectCreationRequest));
    }


}
