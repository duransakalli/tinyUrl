package com.drn.tinyurl.repository;

import com.drn.tinyurl.entity.Redirect;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface RedirectRepository extends JpaRepository<Redirect, UUID> {
    Optional<Redirect> findByAlias(String alias);

    Boolean existsByAlias(String alias);
}
