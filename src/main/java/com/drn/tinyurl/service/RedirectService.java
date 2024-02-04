package com.drn.tinyurl.service;

import com.drn.tinyurl.entity.Redirect;
import com.drn.tinyurl.exception.BadRequestException;
import com.drn.tinyurl.exception.NotFoundException;
import com.drn.tinyurl.repository.RedirectRepository;
import com.drn.tinyurl.request.RedirectCreationRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class RedirectService {

    private RedirectRepository redirectRepository;

    @Autowired
    public RedirectService(RedirectRepository redirectRepository) {
        this.redirectRepository = redirectRepository;
    }

    public Optional<Redirect> createRedirect(RedirectCreationRequest redirectCreationRequest) {

        if(redirectRepository.existsByAlias(redirectCreationRequest.getAlias())) {
            throw new BadRequestException("Alias already exist!");
        }

        Redirect redirect = Redirect.builder()
                .alias(redirectCreationRequest.getAlias())
                .url(redirectCreationRequest.getUrl())
                .build();

        log.info("Redirect Request: " + redirectCreationRequest.toString());

        redirectRepository.save(redirect);

        log.info("Redirect " + redirect.toString());

        return Optional.ofNullable(redirect);
    }

    public Redirect getRedirect(String alias) {
        Redirect redirect = redirectRepository.findByAlias(alias)
                .orElseThrow(() -> new NotFoundException("Alias not created yet.."));

        return redirect;
    }
}
