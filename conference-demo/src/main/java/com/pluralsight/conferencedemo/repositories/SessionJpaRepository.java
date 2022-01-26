package com.pluralsight.conferencedemo.repositories;

import com.pluralsight.conferencedemo.models.Session;
import com.pluralsight.conferencedemo.models.Speaker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(path = "conference_sessions", collectionResourceRel = "conference_sessions")
public interface  SessionJpaRepository extends JpaRepository<Session, Long> {
	List<Session> findBySessionNameContains(String name);
}

